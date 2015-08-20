package com.penglecode.gulubala.service.url;
/**
 * 音乐收藏服务URL
 * 
 * @author  pengpeng
 * @date 	 2015年8月14日 下午2:03:09
 * @version 1.0
 */
public interface MusicFavoriteServiceURL {                         

	/** 新增收藏 */
	String URL_MUSIC_FAVORITE_CREATE = "favorite/create";
	
	/** 删除收藏 */
	String URL_MUSIC_FAVORITE_DELETE = "favorite/delete/{id}";
	
	/** 获取用户的收藏(歌曲/歌单)列表 */
	String URL_MUSIC_FAVORITE_LIST_USER = "favorite/list/{userId}/{favoriteType}";
	
}
