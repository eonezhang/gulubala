package com.penglecode.gulubala.service.url;
/**
 * 音乐推荐服务URL
 * 
 * @author  pengpeng
 * @date 	 2015年8月29日 下午3:13:21
 * @version 1.0
 */
public interface MusicRecommendServiceURL {

	/** 根据媒体类型获取音乐列表(首页接口)[分页、排序] */
	String URL_MUSIC_LIST_INDEX = "music/list/index";
	
	/** 根据分类ID获取排行榜列表(排行榜接口)[分页、排序] */
	String URL_MUSIC_LIST_HOTS = "music/list/hots";
	
	/** 获取首页轮播图列表 */
	String URL_INDEX_ADV_LIST = "index/adv/list";
	
}
