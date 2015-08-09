package com.penglecode.gulubala.dao.category;

import java.util.List;

import com.penglecode.gulubala.common.model.MediaCategory;

/**
 * 媒体通用分类DAO
 * 
 * @author  pengpeng
 * @date 	 2015年8月9日 下午3:00:58
 * @version 1.0
 */
public interface MediaCategoryDAO {

	/**
	 * 新增分类
	 * @param category
	 */
	public void insertCategory(MediaCategory category);

	/**
	 * 根据条件获取媒体通用分类列表
	 * @param parentCategoryId		- 如果不为空则获取该父分类下的子分类,否则获取所有分类列表
	 * @return
	 */
	public List<MediaCategory> getCategoryList(Integer parentCategoryId);
	
}
