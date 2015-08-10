package com.penglecode.gulubala.service.url;
/**
 * 媒体通用分类服务
 * 
 * @author  pengpeng
 * @date 	 2015年8月9日 下午2:04:07
 * @version 1.0
 */
public interface MediaCategoryServiceURL {

	/** 创建媒体通用分类 */
	String URL_MEDIA_CATEGORY_CREATE = "mcategory/create";
	
	/** 根据条件查询媒体通用分类 */
	String URL_MEDIA_CATEGORY_LIST = "mcategory/list";
	
	/** 查询媒体通用分类(首页接口) */
	String URL_MEDIA_CATEGORY_LIST_INDEX = "mcategory/list/index";
	
}
