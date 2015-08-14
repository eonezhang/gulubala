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
	
	/** 显示弹幕 */
	String URL_MUSIC_DANMU_SHOW_NEXT = "musicdanmu/shownext/{musicId}";
	
}
