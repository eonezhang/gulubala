package com.penglecode.gulubala.service.url;
/**
 * 歌手服务URL
 * 
 * @author  pengpeng
 * @date 	 2015年8月10日 上午10:54:46
 * @version 1.0
 */
public interface SingerServiceURL {

	/** 创建歌手 */
	String URL_SINGER_CREATE = "singer/create";
	
	/** 根据歌手id查询歌手详情 */
	String URL_SINGER_DETAIL = "singer/detial/{singerId}";
	
}
