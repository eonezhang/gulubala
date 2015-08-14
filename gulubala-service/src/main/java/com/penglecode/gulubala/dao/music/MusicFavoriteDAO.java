package com.penglecode.gulubala.dao.music;

import java.util.List;

import com.penglecode.gulubala.common.model.MusicFavorite;

/**
 * 歌曲收藏DAO
 * 
 * @author  pengpeng
 * @date 	 2015年8月14日 上午11:24:10
 * @version 1.0
 */
public interface MusicFavoriteDAO {

	/**
	 * 新增歌曲收藏
	 * @param favorite
	 */
	public void insertMusicFavorite(MusicFavorite favorite);
	
	/**
	 * 根据收藏id删除收藏
	 * @param id
	 */
	public void deleteMusicFavoriteById(Long id);
	
	/**
	 * 根据用户ID获取用户的歌曲收藏列表
	 * @param userId			- 必填
	 * @param favoriteType		- 选填
	 * @return
	 */
	public List<MusicFavorite> getMusicFavoritesByUserId(Long userId, Integer favoriteType);
	
}
