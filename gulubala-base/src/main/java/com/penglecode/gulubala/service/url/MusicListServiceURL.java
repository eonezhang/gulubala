package com.penglecode.gulubala.service.url;
/**
 * 歌单服务URL
 * 
 * @author  pengpeng
 * @date 	 2015年8月10日 上午10:54:46
 * @version 1.0
 */
public interface MusicListServiceURL {

	/** 创建歌单 */
	String URL_MUSIC_LIST_CREATE = "musiclist/create";
	
	/** 根据歌单id查询歌单详情 */
	String URL_MUSIC_LIST_DETAIL = "musiclist/detial/{listId}";
	
	/** 获取歌单列表[分页、排序] */
	String URL_MUSIC_LIST_LIST = "musiclist/list";
	
}
