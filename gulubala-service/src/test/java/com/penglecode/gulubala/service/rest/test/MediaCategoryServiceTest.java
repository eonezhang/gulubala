package com.penglecode.gulubala.service.rest.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.GenericType;

import com.penglecode.gulubala.common.model.MediaCategory;
import com.penglecode.gulubala.common.support.Result;
import com.penglecode.gulubala.common.util.CollectionUtils;
import com.penglecode.gulubala.common.util.JsonUtils;
import com.penglecode.gulubala.common.util.RestServiceUtils;
import com.penglecode.gulubala.service.url.MediaCategoryServiceURL;

public class MediaCategoryServiceTest {

	public static void testCreateCategory() {
		Result<Object> result = null;
		MediaCategory category = null;
		category = new MediaCategory();
		category.setCategoryName("华语金曲");
		category.setParentCategoryId(1);
		category.setCreateBy(0L);
		category.setSiblingsOrder(1);
		result = RestServiceUtils.post(MediaCategoryServiceURL.URL_MEDIA_CATEGORY_CREATE, category, new GenericType<Result<Object>>(){});
		System.out.println(result);
		System.out.println("<---------------------------------------------------------------------->");
		category = new MediaCategory();
		category.setCategoryName("欧美流行");
		category.setParentCategoryId(1);
		category.setCreateBy(0L);
		category.setSiblingsOrder(2);
		result = RestServiceUtils.post(MediaCategoryServiceURL.URL_MEDIA_CATEGORY_CREATE, category, new GenericType<Result<Object>>(){});
		System.out.println(result);
		System.out.println("<---------------------------------------------------------------------->");
		category = new MediaCategory();
		category.setCategoryName("经典翻唱");
		category.setParentCategoryId(1);
		category.setCreateBy(0L);
		category.setSiblingsOrder(3);
		result = RestServiceUtils.post(MediaCategoryServiceURL.URL_MEDIA_CATEGORY_CREATE, category, new GenericType<Result<Object>>(){});
		System.out.println(result);
		System.out.println("<---------------------------------------------------------------------->");
		category = new MediaCategory();
		category.setCategoryName("酒吧最热");
		category.setParentCategoryId(1);
		category.setCreateBy(0L);
		category.setSiblingsOrder(4);
		result = RestServiceUtils.post(MediaCategoryServiceURL.URL_MEDIA_CATEGORY_CREATE, category, new GenericType<Result<Object>>(){});
		System.out.println(result);
	}
	
	public static void testGetCategoryList() {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("parentCategoryId", 1);
		paramMap.put("loadAll", true);
		Result<List<MediaCategory>> result = RestServiceUtils.get(MediaCategoryServiceURL.URL_MEDIA_CATEGORY_LIST, paramMap, new GenericType<Result<List<MediaCategory>>>(){});
		System.out.println(result);
		if(result.isSuccess() && !CollectionUtils.isEmpty(result.getData())){
			for(MediaCategory category : result.getData()){
				System.out.println(JsonUtils.object2Json(category));
			}
		}
	}
	
	public static void testGetCategoryListIndex() {
		Result<List<MediaCategory>> result = RestServiceUtils.get(MediaCategoryServiceURL.URL_MEDIA_CATEGORY_LIST, null, new GenericType<Result<List<MediaCategory>>>(){});
		System.out.println(JsonUtils.object2Json(result));
	}
	
	public static void main(String[] args) {
		//testCreateCategory();
		//testGetCategoryList();
		testGetCategoryListIndex();
	}

}
