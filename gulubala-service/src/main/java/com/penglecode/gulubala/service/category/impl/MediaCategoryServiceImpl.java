package com.penglecode.gulubala.service.category.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.penglecode.gulubala.common.consts.GlobalConstants;
import com.penglecode.gulubala.common.consts.em.MediaCategoryTypeEnum;
import com.penglecode.gulubala.common.model.MediaCategory;
import com.penglecode.gulubala.common.support.ValidationAssert;
import com.penglecode.gulubala.dao.category.MediaCategoryDAO;
import com.penglecode.gulubala.service.category.MediaCategoryService;

@Service("mediaCategoryService")
public class MediaCategoryServiceImpl implements MediaCategoryService {

	@Resource(name="mediaCategoryDAO")
	private MediaCategoryDAO mediaCategoryDAO;
	
	public List<MediaCategory> getCategoryListByType(Integer category) {
		MediaCategoryTypeEnum categoryType = MediaCategoryTypeEnum.getCategoryType(category);
		ValidationAssert.notNull(categoryType, "无法识别的category类型!");
		return mediaCategoryDAO.getCategoryList(GlobalConstants.GLOBAL_MEDIA_CATEGORY_ID_APP, categoryType.getTypeCode());
	}

	public List<MediaCategory> getCategoryListByParentId(Integer parentId) {
		ValidationAssert.notNull(parentId, "父分类的ID不能为空!");
		return mediaCategoryDAO.getCategoryList(parentId, null);
	}
	
}
