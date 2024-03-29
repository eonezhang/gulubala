package com.penglecode.gulubala.dao.music.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.penglecode.gulubala.common.consts.em.MediaSource;
import com.penglecode.gulubala.common.model.Music;
import com.penglecode.gulubala.common.mybatis.EscapeFilter;
import com.penglecode.gulubala.common.support.Pager;
import com.penglecode.gulubala.common.util.AppResourceUtils;
import com.penglecode.gulubala.common.util.CollectionUtils;
import com.penglecode.gulubala.common.util.StringUtils;
import com.penglecode.gulubala.dao.BaseMybatisDAO;
import com.penglecode.gulubala.dao.music.MusicDAO;

@Repository("musicDAO")
public class MusicDAOImpl extends BaseMybatisDAO implements MusicDAO {

	public void insertMusic(Music music) {
		getSqlSessionTemplate().insert(getMapperKey("insertMusic"), music);
	}

	public void incrMusicHots(Long musicId) {
		getSqlSessionTemplate().update(getMapperKey("incrMusicHots"), musicId);
	}

	public void incrMusicPlays(Long musicId) {
		getSqlSessionTemplate().update(getMapperKey("incrMusicPlays"), musicId);
	}

	public void incrMusicPraises(Long musicId) {
		getSqlSessionTemplate().update(getMapperKey("incrMusicPraises"), musicId);
	}

	public void incrMusicCollects(Long musicId) {
		getSqlSessionTemplate().update(getMapperKey("incrMusicCollects"), musicId);
	}

	public Music getThinMusicById(Long musicId) {
		return getSqlSessionTemplate().selectOne(getMapperKey("getThinMusicById"), musicId);
	}

	public Music getMusicById(Long musicId) {
		return getSqlSessionTemplate().selectOne(getMapperKey("getMusicById"), musicId, new MusicEscapeFilter());
	}

	public List<Music> getMusicListByIds(List<Long> musicIdList, boolean orderedAsIdList) {
		List<Music> list = getSqlSessionTemplate().selectList(getMapperKey("getMusicListByIds"), musicIdList, new MusicEscapeFilter());
		if(orderedAsIdList && !CollectionUtils.isEmpty(list)){
			List<Music> dataList = new ArrayList<Music>();
			for(Long id : musicIdList){
				for(Music music : list){
					if(music.getMusicId().equals(id)){
						dataList.add(music);
					}
				}
			}
			return dataList;
		}
		return list;
	}

	public List<Music> getMusicList4search(Map<String,Object> paramMap, Pager pager) {
		return getSqlSessionTemplate().selectList(getMapperKey("getMusicList4search"), paramMap, new MusicEscapeFilter(), pager);
	}
	
	public List<Music> getMusicList4userUpload(Map<String, Object> paramMap, Pager pager) {
		return getSqlSessionTemplate().selectList(getMapperKey("getMusicList4userUpload"), paramMap, new MusicEscapeFilter(), pager);
	}

	public List<Music> getMusicListByMediaType(Map<String,Object> paramMap, Pager pager) {
		return getSqlSessionTemplate().selectList(getMapperKey("getMusicListByMediaType"), paramMap, new MusicEscapeFilter(), pager);
	}

	protected Class<?> getBoundModelClass() {
		return Music.class;
	}

	public static class MusicEscapeFilter implements EscapeFilter<Music> {

		public void doEscapeFilter(Music element) {
			if(!StringUtils.isEmpty(element.getSmallPictureUrl())){
				element.setFullSmallPictureUrl(AppResourceUtils.getFullPictureUrl(element.getSmallPictureUrl()));
			}
			if(!StringUtils.isEmpty(element.getPictureUrl())){
				element.setFullPictureUrl(AppResourceUtils.getFullPictureUrl(element.getPictureUrl()));
			}
			if(!StringUtils.isEmpty(element.getMusicUrl())){
				element.setFullMusicUrl(AppResourceUtils.getFullFileUrl(element.getMusicUrl(), MediaSource.EXTERNAL));
			}
			if(!StringUtils.isEmpty(element.getLrcUrl())){
				element.setFullLrcUrl(AppResourceUtils.getFullFileUrl(element.getLrcUrl(), MediaSource.INTERNAL));
			}
		}
		
	}
	
}
