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
	
	/** 获取用户的歌单列表[分页] */
	String URL_MUSIC_LIST_LIST_USER = "musiclist/list/{userId}";
	
	/** 删除歌单 */
	String URL_MUSIC_LIST_DELETE = "musiclist/delete/{listId}";
	
	/** 给歌单点赞 */
	String URL_MUSIC_LIST_PRAISE = "musiclist/praise/{listId}";
	
	/** 收藏歌单 */
	String URL_MUSIC_LIST_COLLECT = "musiclist/collect/{listId}";
	
	/** 删除歌单中的某个歌曲 */
	String URL_MUSIC_LIST_DEL_ITEM = "musiclist/item/del/{listId}/{musicId}";

	/** 向歌单中添加某个歌曲 */
	String URL_MUSIC_LIST_ADD_ITEM = "musiclist/item/add/{listId}/{musicId}";
	
}
