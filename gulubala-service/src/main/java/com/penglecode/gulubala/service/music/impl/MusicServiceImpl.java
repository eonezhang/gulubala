package com.penglecode.gulubala.service.music.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.penglecode.gulubala.common.consts.GlobalConstants;
import com.penglecode.gulubala.common.consts.em.MediaTypeEnum;
import com.penglecode.gulubala.common.model.Music;
import com.penglecode.gulubala.common.model.MusicPlayHistory;
import com.penglecode.gulubala.common.support.Pager;
import com.penglecode.gulubala.common.support.PagingList;
import com.penglecode.gulubala.common.support.ValidationAssert;
import com.penglecode.gulubala.common.util.DateTimeUtils;
import com.penglecode.gulubala.common.util.StringUtils;
import com.penglecode.gulubala.dao.music.MusicAlbumDAO;
import com.penglecode.gulubala.dao.music.MusicDAO;
import com.penglecode.gulubala.dao.music.MusicListDAO;
import com.penglecode.gulubala.dao.music.MusicPlayHistoryDAO;
import com.penglecode.gulubala.service.music.MusicService;

@Service("musicService")
public class MusicServiceImpl implements MusicService {

	@Resource(name="musicPlayHistoryDAO")
	private MusicPlayHistoryDAO musicPlayHistoryDAO;
	
	@Resource(name="musicDAO")
	private MusicDAO musicDAO;
	
	@Resource(name="musicAlbumDAO")
	private MusicAlbumDAO musicAlbumDAO;
	
	@Resource(name="musicListDAO")
	private MusicListDAO musicListDAO;
	
	@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRED)
	public Long createMusic(Music music) {
		ValidationAssert.notNull(music, "请求参数不能为空!");
		ValidationAssert.notNull(music.getSingerId(), "所属歌手ID不能为空!");
		ValidationAssert.notNull(music.getAlbumId(), "所属专辑ID不能为空!");
		ValidationAssert.notNull(music.getCategoryId(), "所属分类ID不能为空!");
		music.setHots(0);
		music.setPlays(0);
		music.setPraises(0);
		music.setCollects(0);
		music.setCreateTime(DateTimeUtils.formatNow());
		musicDAO.insertMusic(music);
		return music.getMusicId();
	}

	public Music getMusicById(Long musicId) {
		return musicDAO.getMusicById(musicId);
	}

	public Music playMusic(final Long musicId, final Long userId, final Long listId, final Long albumId) {
		final Music music = getMusicById(musicId);
		if(music != null){
			new Thread(new Runnable(){
				public void run() {
					incrMusicPlays(music, listId, albumId);
					if(userId != null){
						addMusicPlayHistory(musicId, userId);
					}
				}
			}).start();
		}
		return music;
	}

	protected void incrMusicPlays(Music music, Long listId, Long albumId) {
		if(music != null){
			//musicDAO.incrMusicHots(music.getMusicId()); //增加人气数
			musicDAO.incrMusicPlays(music.getMusicId()); //增加人播放数
			if(listId != null){
				musicListDAO.incrMusicListPlays(listId); //增加人播放数
			}else if(albumId != null){
				musicAlbumDAO.incrMusicAlbumPlays(music.getAlbumId()); //增加人播放数
			}
		}
	}
	
	protected void addMusicPlayHistory(Long musicId, Long userId) {
		MusicPlayHistory phistory = musicPlayHistoryDAO.getMusicPlayHistoryByUserId(userId);
		if(phistory != null){//修改
			String musicIds = StringUtils.defaultIfEmpty(phistory.getMusicIds(), "");
			musicIds = StringUtils.strip(musicIds, ",");
			List<String> musicIdList = new ArrayList<String>(Arrays.asList(musicIds.split(",")));
			if(!musicIdList.contains(musicId.toString())){ //防止重复记录
				musicIdList.add(0, musicId.toString()); //最近播放的放在前面
				long length = Math.min(musicIdList.size(), GlobalConstants.DEFAULT_MUSIC_PLAY_HISTORY_MAX_SIZE);
				StringBuilder sb = new StringBuilder();
				for(int i = 0; i < length; i++){
					sb.append(musicIdList.get(i) + ",");
				}
				musicPlayHistoryDAO.updateMusicIds(userId, StringUtils.strip(sb.toString(), ","));
			}
		}else{//新增
			MusicPlayHistory history = new MusicPlayHistory();
			history.setUserId(userId);
			history.setMusicIds(musicId.toString());
			history.setCreateTime(DateTimeUtils.formatNow());
			musicPlayHistoryDAO.insertMusicPlayHistory(history);
		}
	}
	
	public PagingList<Music> getMusicList4index(Integer mediaType,
			Integer categoryId, Integer currentPage, Integer pageSize,
			String orderby, String order) {
		MediaTypeEnum em = MediaTypeEnum.getMediaType(mediaType);
		ValidationAssert.notNull(em, "无法识别的mediaType类型!");
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("mediaType", em.getTypeCode());
		paramMap.put("categoryId", categoryId);
		paramMap.put("orderby", orderby);
		paramMap.put("order", order);
		Pager pager = new Pager(currentPage, pageSize);
		return new PagingList<Music>(musicDAO.getMusicList4index(paramMap, pager), pager);
	}

	public PagingList<Music> getMusicList4search(String musicName,
			Integer currentPage, Integer pageSize, String orderby, String order) {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("musicName", musicName);
		paramMap.put("orderby", orderby);
		paramMap.put("order", order);
		Pager pager = new Pager(currentPage, pageSize);
		return new PagingList<Music>(musicDAO.getMusicList4search(paramMap, pager), pager);
	}

	public PagingList<Music> getMusicList4hots(Integer mediaType,
			Integer categoryId, String hotType, Integer currentPage,
			Integer pageSize) {
		if(!StringUtils.isEmpty(hotType)){
			List<String> hotTypes = Arrays.asList("hots","dayHots","threeDayHots","weekHots");
			ValidationAssert.isTrue(hotTypes.contains(hotType), "无法识别的排行类型[hotType]");
		}
		MediaTypeEnum em = MediaTypeEnum.getMediaType(mediaType);
		ValidationAssert.notNull(em, "无法识别的mediaType类型!");
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("mediaType", em.getTypeCode());
		paramMap.put("categoryId", categoryId);
		paramMap.put("orderby", hotType);
		paramMap.put("order", "DESC");
		Pager pager = new Pager(currentPage, pageSize);
		return new PagingList<Music>(musicDAO.getMusicList4index(paramMap, pager), pager);
	}

	@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRED)
	public Integer praiseMusic(Long musicId) {
		ValidationAssert.notNull(musicId, "音乐ID不能为空!");
		musicDAO.incrMusicPraises(musicId);
		Music music = musicDAO.getThinMusicById(musicId);
		ValidationAssert.notNull(music, "该音乐已不存在了!(musicId=" + musicId + ")");
		return music.getPraises();
	}

}
