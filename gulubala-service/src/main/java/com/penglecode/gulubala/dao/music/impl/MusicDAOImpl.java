package com.penglecode.gulubala.dao.music.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.penglecode.gulubala.common.model.Music;
import com.penglecode.gulubala.common.mybatis.EscapeFilter;
import com.penglecode.gulubala.common.support.Pager;
import com.penglecode.gulubala.common.util.AppResourceUtils;
import com.penglecode.gulubala.common.util.StringUtils;
import com.penglecode.gulubala.dao.BaseMybatisDAO;
import com.penglecode.gulubala.dao.music.MusicDAO;

@Repository("musicDAO")
public class MusicDAOImpl extends BaseMybatisDAO implements MusicDAO {

	public void insertMusic(Music music) {
		getSqlSessionTemplate().insert(getMapperKey("insertMusic"), music);
	}

	public Music getMusicById(Long musicId) {
		return getSqlSessionTemplate().selectOne(getMapperKey("getMusicById"), musicId, new MusicEscapeFilter());
	}

	public List<Music> getMusicList4index(Map<String,Object> paramMap, Pager pager) {
		return getSqlSessionTemplate().selectList(getMapperKey("getMusicList4index"), paramMap, new MusicEscapeFilter(), pager);
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
				element.setFullMusicUrl(AppResourceUtils.getFullFileUrl(element.getMusicUrl()));
			}
			if(!StringUtils.isEmpty(element.getLrcUrl())){
				element.setFullLrcUrl(AppResourceUtils.getFullFileUrl(element.getLrcUrl()));
			}
		}
		
	}
	
}
