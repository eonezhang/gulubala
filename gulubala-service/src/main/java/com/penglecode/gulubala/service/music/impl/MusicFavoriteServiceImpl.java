package com.penglecode.gulubala.service.music.impl;

import javax.annotation.Resource;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.penglecode.gulubala.common.consts.em.MusicFavoriteTypeEnum;
import com.penglecode.gulubala.common.model.MusicFavorite;
import com.penglecode.gulubala.common.support.BusinessAssert;
import com.penglecode.gulubala.common.support.Pager;
import com.penglecode.gulubala.common.support.PagingList;
import com.penglecode.gulubala.common.support.ValidationAssert;
import com.penglecode.gulubala.common.util.DateTimeUtils;
import com.penglecode.gulubala.dao.music.MusicDAO;
import com.penglecode.gulubala.dao.music.MusicFavoriteDAO;
import com.penglecode.gulubala.dao.music.MusicListDAO;
import com.penglecode.gulubala.service.music.MusicFavoriteService;

@Service("musicFavoriteService")
public class MusicFavoriteServiceImpl implements MusicFavoriteService {

	@Resource(name="musicFavoriteDAO")
	private MusicFavoriteDAO musicFavoriteDAO;
	
	@Resource(name="musicDAO")
	private MusicDAO musicDAO;
	
	@Resource(name="musicListDAO")
	private MusicListDAO musicListDAO;
	
	@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRED)
	public Long createMusicFavorite(MusicFavorite favorite) {
		ValidationAssert.notNull(favorite, "请求参数不能为空!");
		ValidationAssert.notNull(favorite.getUserId(), "用户ID不能为空!");
		ValidationAssert.notNull(favorite.getFavoriteId(), "收藏对象ID不能为空!");
		MusicFavoriteTypeEnum favoriteType = MusicFavoriteTypeEnum.getFavoriteType(favorite.getFavoriteType());
		ValidationAssert.notNull(favoriteType, "收藏对象类型[favoriteType]不能为空!");
		favorite.setCreateTime(DateTimeUtils.formatNow());
		try {
			musicFavoriteDAO.insertMusicFavorite(favorite);
		} catch (DuplicateKeyException e) {
			BusinessAssert.isTrue(!e.getCause().getMessage().toLowerCase().contains("uk_favorites_user"), "亲! 您已经收藏过了!");
			throw e;
		}
		if(favoriteType.equals(MusicFavoriteTypeEnum.FAVORITE_TYPE_MUSIC)){
			musicDAO.incrMusicCollects(favorite.getFavoriteId());
		}else if(favoriteType.equals(MusicFavoriteTypeEnum.FAVORITE_TYPE_MUSIC_LIST)){
			musicListDAO.incrMusicListCollects(favorite.getFavoriteId());
		}
		return favorite.getId();
	}

	@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRED)
	public void deleteMusicFavorite(Long id) {
		ValidationAssert.notNull(id, "id不能为空!");
		musicFavoriteDAO.deleteMusicFavoriteById(id);
	}

	public PagingList<MusicFavorite> getMusicFavoritesByUserId(Long userId, Integer favoriteType, Integer currentPage, Integer pageSize) {
		ValidationAssert.notNull(userId, "用户ID不能为空!");
		ValidationAssert.notNull(userId, "收藏类型[favoriteType]不能为空!");
		Pager pager = new Pager(currentPage, pageSize);
		return new PagingList<MusicFavorite>(musicFavoriteDAO.getMusicFavoritesByUserId(userId, favoriteType, pager), pager);
	}

}
