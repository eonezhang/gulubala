package com.penglecode.gulubala.service.url;
/**
 * 用户播放历史服务URL
 * 
 * @author  pengpeng
 * @date 	 2015年8月18日 下午2:14:27
 * @version 1.0
 */
public interface MusicPlayHistoryServiceURL {

	/** 清空播放历史 */
	String URL_MUSIC_PLAY_HISTORY_DEL = "playhistory/del/{userId}";
	
	/** 播放历史列表 */
	String URL_MUSIC_PLAY_HISTORY_LIST = "playhistory/list/{userId}";
	
}
