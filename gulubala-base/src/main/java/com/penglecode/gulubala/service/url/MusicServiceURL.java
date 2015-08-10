package com.penglecode.gulubala.service.url;
/**
 * 音乐服务URL
 * 
 * @author  pengpeng
 * @date 	 2015年8月10日 上午10:54:46
 * @version 1.0
 */
public interface MusicServiceURL {

	/** 创建音乐 */
	String URL_MUSIC_CREATE = "music/create";
	
	/** 根据音乐id查询音乐详情 */
	String URL_MUSIC_DETAIL = "music/detial/{musicId}";
	
	/** 根据分类ID获取音乐列表(首页接口)[分页、排序] */
	String URL_MUSIC_LIST_INDEX = "music/list/index";
	
}
