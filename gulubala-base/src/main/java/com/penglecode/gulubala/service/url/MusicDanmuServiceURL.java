package com.penglecode.gulubala.service.url;
/**
 * 弹幕服务URL
 * 
 * @author  pengpeng
 * @date 	 2015年8月13日 下午8:32:21
 * @version 1.0
 */
public interface MusicDanmuServiceURL {

	/** 创建弹幕 */
	String URL_MUSIC_DANMU_CREATE = "musicdanmu/create";
	
	/** 获取下一批弹幕数据给客户端 */
	String URL_MUSIC_DANMU_LIST = "musicdanmu/list/{musicId}";
	
}
