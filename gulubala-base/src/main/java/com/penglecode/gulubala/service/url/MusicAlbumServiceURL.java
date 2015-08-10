package com.penglecode.gulubala.service.url;
/**
 * 音乐专辑服务URL
 * 
 * @author  pengpeng
 * @date 	 2015年8月10日 上午10:54:46
 * @version 1.0
 */
public interface MusicAlbumServiceURL {

	/** 创建音乐专辑 */
	String URL_MUSIC_ALBUM_CREATE = "musicalbum/create";
	
	/** 根据专辑id查询音乐专辑详情 */
	String URL_MUSIC_ALBUM_DETAIL = "musicalbum/detial/{albumId}";
	
}
