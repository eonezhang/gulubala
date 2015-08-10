package com.penglecode.gulubala.dao.music.impl;

import org.springframework.stereotype.Repository;

import com.penglecode.gulubala.common.model.MusicAlbum;
import com.penglecode.gulubala.common.mybatis.EscapeFilter;
import com.penglecode.gulubala.common.util.AppResourceUtils;
import com.penglecode.gulubala.common.util.StringUtils;
import com.penglecode.gulubala.dao.BaseMybatisDAO;
import com.penglecode.gulubala.dao.music.MusicAlbumDAO;

@Repository("musicAlbumDAO")
public class MusicAlbumDAOImpl extends BaseMybatisDAO implements MusicAlbumDAO {

	public void insertMusicAlbum(MusicAlbum album) {
		getSqlSessionTemplate().insert(getMapperKey("insertMusicAlbum"), album);
	}

	public MusicAlbum getMusicAlbumById(Long albumId) {
		return getSqlSessionTemplate().selectOne(getMapperKey("getMusicAlbumById"), albumId, new MusicAlbumEscapeFilter());
	}

	protected Class<?> getBoundModelClass() {
		return MusicAlbum.class;
	}

	public static class MusicAlbumEscapeFilter implements EscapeFilter<MusicAlbum> {

		public void doEscapeFilter(MusicAlbum element) {
			if(!StringUtils.isEmpty(element.getAlbumPictureUrl())){
				element.setFullAlbumPictureUrl(AppResourceUtils.getFullPictureUrl(element.getAlbumPictureUrl()));
			}
		}
		
	}
	
}
