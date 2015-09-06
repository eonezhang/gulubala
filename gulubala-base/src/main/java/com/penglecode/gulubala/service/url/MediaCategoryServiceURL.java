package com.penglecode.gulubala.service.url;
/**
 * 媒体通用分类服务
 * 
 * @author  pengpeng
 * @date 	 2015年8月9日 下午2:04:07
 * @version 1.0
 */
public interface MediaCategoryServiceURL {

	/** 根据父标签的ID获取媒体通用分类列表 */
	String URL_MEDIA_CATEGORY_LIST_PARENT = "mcategory/list/parent/{parentId}";
	
	/** 根据标签类型查询媒体通用分类 */
	String URL_MEDIA_CATEGORY_LIST_INDEX = "mcategory/list/index/{category}";
	
}
