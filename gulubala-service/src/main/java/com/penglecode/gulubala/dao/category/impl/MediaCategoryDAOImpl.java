package com.penglecode.gulubala.dao.category.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.penglecode.gulubala.common.consts.GlobalConstants;
import com.penglecode.gulubala.common.model.MediaCategory;
import com.penglecode.gulubala.dao.BaseMybatisDAO;
import com.penglecode.gulubala.dao.category.MediaCategoryDAO;

@Repository("mediaCategoryDAO")
public class MediaCategoryDAOImpl extends BaseMybatisDAO implements MediaCategoryDAO {

	public void insertCategory(MediaCategory category) {
		getSqlSessionTemplate().insert(getMapperKey("insertCategory"), category);
	}

	public List<MediaCategory> getCategoryList(Integer categoryType) {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("appParentId", GlobalConstants.GLOBAL_MEDIA_CATEGORY_ID_APP);
		paramMap.put("categoryType", categoryType);
		return getSqlSessionTemplate().selectList(getMapperKey("getCategoryList"), paramMap);
	}

	protected Class<?> getBoundModelClass() {
		return MediaCategory.class;
	}

}
