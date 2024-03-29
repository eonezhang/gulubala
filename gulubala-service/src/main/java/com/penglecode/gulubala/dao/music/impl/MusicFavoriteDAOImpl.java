package com.penglecode.gulubala.dao.music.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.penglecode.gulubala.common.consts.em.MusicFavoriteTypeEnum;
import com.penglecode.gulubala.common.model.MusicFavorite;
import com.penglecode.gulubala.common.mybatis.EscapeFilter;
import com.penglecode.gulubala.common.support.Pager;
import com.penglecode.gulubala.common.util.AppResourceUtils;
import com.penglecode.gulubala.common.util.StringUtils;
import com.penglecode.gulubala.dao.BaseMybatisDAO;
import com.penglecode.gulubala.dao.music.MusicFavoriteDAO;

@Repository("musicFavoriteDAO")
public class MusicFavoriteDAOImpl extends BaseMybatisDAO implements MusicFavoriteDAO {

	public void insertMusicFavorite(MusicFavorite favorite) {
		getSqlSessionTemplate().insert(getMapperKey("insertMusicFavorite"), favorite);
	}

	public void deleteMusicFavoriteById(Long id) {
		getSqlSessionTemplate().delete(getMapperKey("deleteMusicFavoriteById"), id);
	}

	public List<MusicFavorite> getMusicFavoritesByUserId(Long userId, Integer favoriteType, Pager pager) {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("userId", userId);
		paramMap.put("musicFavoriteType", MusicFavoriteTypeEnum.FAVORITE_TYPE_MUSIC.getTypeCode());
		paramMap.put("musicListFavoriteType", MusicFavoriteTypeEnum.FAVORITE_TYPE_MUSIC_LIST.getTypeCode());
		paramMap.put("favoriteType", favoriteType);
		return getSqlSessionTemplate().selectList(getMapperKey("getMusicFavoritesByUserId"), paramMap, new MusicFavoriteEscapeFilter(), pager);
	}

	public static class MusicFavoriteEscapeFilter implements EscapeFilter<MusicFavorite> {

		public void doEscapeFilter(MusicFavorite element) {
			if(!StringUtils.isEmpty(element.getFavoriteImgUrl())){
				element.setFavoriteImgUrl(AppResourceUtils.getFullPictureUrl(element.getFavoriteImgUrl()));
			}
		}
		
	}
	
	protected Class<?> getBoundModelClass() {
		return MusicFavorite.class;
	}

}
