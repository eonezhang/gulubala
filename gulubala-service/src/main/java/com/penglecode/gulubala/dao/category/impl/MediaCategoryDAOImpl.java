package com.penglecode.gulubala.dao.category.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.penglecode.gulubala.common.model.MediaCategory;
import com.penglecode.gulubala.dao.BaseMybatisDAO;
import com.penglecode.gulubala.dao.category.MediaCategoryDAO;

@Repository("mediaCategoryDAO")
public class MediaCategoryDAOImpl extends BaseMybatisDAO implements MediaCategoryDAO {

	public void insertCategory(MediaCategory category) {
		getSqlSessionTemplate().insert(getMapperKey("insertCategory"), category);
	}

	public List<MediaCategory> getCategoryList(Integer parentCategoryId) {
		return getSqlSessionTemplate().selectList(getMapperKey("getCategoryList"), Collections.singletonMap("parentCategoryId", parentCategoryId));
	}

	protected Class<?> getBoundModelClass() {
		return MediaCategory.class;
	}

}
