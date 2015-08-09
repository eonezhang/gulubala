package com.penglecode.gulubala.service.category.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.penglecode.gulubala.common.model.MediaCategory;
import com.penglecode.gulubala.common.support.ValidationAssert;
import com.penglecode.gulubala.common.util.CollectionUtils;
import com.penglecode.gulubala.common.util.DateTimeUtils;
import com.penglecode.gulubala.dao.category.MediaCategoryDAO;
import com.penglecode.gulubala.service.category.MediaCategoryService;

@Service("mediaCategoryService")
public class MediaCategoryServiceImpl implements MediaCategoryService {

	@Resource(name="mediaCategoryDAO")
	private MediaCategoryDAO mediaCategoryDAO;
	
	@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRED)
	public Integer createCategory(MediaCategory category) {
		ValidationAssert.notNull(category, "请求参数不能为空!");
		category.setCreateTime(DateTimeUtils.formatNow());
		mediaCategoryDAO.insertCategory(category);
		return category.getCategoryId();
	}

	public List<MediaCategory> getCategoryList(Integer parentCategoryId, boolean loadAll) {
		List<MediaCategory> resultList = new ArrayList<MediaCategory>();
		List<MediaCategory> allCategoryList = mediaCategoryDAO.getCategoryList(parentCategoryId);
		if(!CollectionUtils.isEmpty(allCategoryList)){
			if(parentCategoryId == null){
				resultList.addAll(allCategoryList);
			}else{
				if(loadAll){
					//递归加载parentCategoryId下的所有子节点
					loadCategorysByParentId(allCategoryList, parentCategoryId, resultList, true);
				}else{
					//加载parentCategoryId下的直接子节点
					loadCategorysByParentId(allCategoryList, parentCategoryId, resultList, false);
				}
			}
		}
		return resultList;
	}
	
	protected void loadCategorysByParentId(List<MediaCategory> allCategoryList, Integer parentCategoryId, List<MediaCategory> resultList, boolean recursiveLoad) {
		for(MediaCategory category : allCategoryList){
			if(parentCategoryId.equals(category.getParentCategoryId())){
				resultList.add(category);
				if(recursiveLoad){
					loadCategorysByParentId(allCategoryList, category.getParentCategoryId(), resultList, recursiveLoad);
				}
			}
		}
	}

}
