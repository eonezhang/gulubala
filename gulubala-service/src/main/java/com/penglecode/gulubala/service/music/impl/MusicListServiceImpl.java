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
import com.penglecode.gulubala.common.model.MusicList;
import com.penglecode.gulubala.common.support.Pager;
import com.penglecode.gulubala.common.support.PagingList;
import com.penglecode.gulubala.common.support.ValidationAssert;
import com.penglecode.gulubala.common.util.DateTimeUtils;
import com.penglecode.gulubala.common.util.StringUtils;
import com.penglecode.gulubala.dao.music.MusicDAO;
import com.penglecode.gulubala.dao.music.MusicListDAO;
import com.penglecode.gulubala.service.music.MusicListService;

@Service("musicListService")
public class MusicListServiceImpl implements MusicListService {

	@Resource(name="musicDAO")
	private MusicDAO musicDAO;
	
	@Resource(name="musicListDAO")
	private MusicListDAO musicListDAO;
	
	@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRED)
	public Long createMusicList(MusicList musicList) {
		ValidationAssert.notNull(musicList, "请求参数不能为空!");
		musicList.setCreateTime(DateTimeUtils.formatNow());
		musicList.setUpdateTime(DateTimeUtils.formatNow());
		musicListDAO.insertMusicList(musicList);
		return musicList.getListId();
	}

	public MusicList getMusicListById(Long listId) {
		MusicList musicList = musicListDAO.getMusicListById(listId);
		if(musicList != null && !StringUtils.isEmpty(musicList.getMusicIds())){
			List<Long> idList = new ArrayList<Long>();
			String[] ids = musicList.getMusicIds().split(",");
			for(String id : ids){
				idList.add(Long.valueOf(id));
			}
			musicList.setMusicList(musicDAO.getMusicListByIds(idList, true));
		}
		return musicList;
	}

	public PagingList<MusicList> getMusicLists(Long userId,
			Integer currentPage, Integer pageSize, String orderby, String order) {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("userId", userId);
		paramMap.put("orderby", orderby);
		paramMap.put("order", order);
		Pager pager = new Pager(currentPage, pageSize);
		return new PagingList<MusicList>(musicListDAO.getMusicLists(paramMap, pager), pager);
	}

	public PagingList<MusicList> getMusicListsByUserId(Long userId,
			Integer currentPage, Integer pageSize) {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("orderby", "createTime");
		paramMap.put("order", "DESC");
		Pager pager = new Pager(currentPage, pageSize);
		return new PagingList<MusicList>(musicListDAO.getMusicLists(paramMap, pager), pager);
	}

	@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRED)
	public Integer praiseMusicList(Long listId) {
		ValidationAssert.notNull(listId, "歌单ID不能为空!");
		musicListDAO.incrMusicListPraises(listId);
		MusicList musicList = musicListDAO.getMusicListById(listId);
		ValidationAssert.notNull(musicList, "该歌单已不存在了!(listId=" + listId + ")");
		return musicList.getPraises();
	}

	@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRED)
	public void delItemFromMusicList(Long listId, Long musicId) {
		ValidationAssert.notNull(listId, "歌单ID不能为空!");
		ValidationAssert.notNull(musicId, "音乐ID不能为空!");
		MusicList musicList = musicListDAO.getMusicListById(listId);
		if(!StringUtils.isEmpty(musicList.getMusicIds())){
			String[] musicIds = musicList.getMusicIds().split(",");
			StringBuilder sb = new StringBuilder();
			for(int i = 0, len = musicIds.length; i < len; i++){
				if(!musicIds[i].equals(musicId.toString())){
					sb.append(musicIds[i] + ",");
				}
			}
			musicListDAO.updateMusicIds(listId, StringUtils.strip(sb.toString(), ","));
		}
	}

	@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRED)
	public void addItemIntoMusicList(Long listId, Long musicId) {
		ValidationAssert.notNull(listId, "歌单ID不能为空!");
		ValidationAssert.notNull(musicId, "音乐ID不能为空!");
		MusicList musicList = musicListDAO.getMusicListById(listId);
		String musicIds = StringUtils.defaultIfEmpty(musicList.getMusicIds(), "");
		musicIds = StringUtils.strip(musicIds, ",");
		List<String> musicIdList = new ArrayList<String>(Arrays.asList(musicIds.split(",")));
		if(!musicIdList.contains(musicId.toString())){ //防止重复记录
			musicIdList.add(0, musicId.toString()); //最近加入的放在前面
			long maxSize = GlobalConstants.DEFAULT_MUSIC_LIST_MAX_SIZE;
			ValidationAssert.isTrue(musicIdList.size() <= maxSize, "添加失败！歌单中歌曲的数量已超出最大容量" + maxSize + "首!");
			long length = musicIdList.size();
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < length; i++){
				sb.append(musicIdList.get(i) + ",");
			}
			musicListDAO.updateMusicIds(listId, StringUtils.strip(sb.toString(), ","));
		}
	}

	@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRED)
	public void deleteMusicListById(Long listId) {
		ValidationAssert.notNull(listId, "歌单ID不能为空!");
		musicListDAO.deleteMusicListById(listId);
	}
	
}
