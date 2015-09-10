package com.penglecode.gulubala.service.rest.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.GenericType;

import com.penglecode.gulubala.common.model.MediaCategory;
import com.penglecode.gulubala.common.support.Result;
import com.penglecode.gulubala.common.util.JsonUtils;
import com.penglecode.gulubala.common.util.RestServiceUtils;
import com.penglecode.gulubala.service.url.MediaCategoryServiceURL;

public class MediaCategoryServiceTest {

	public static void testGetCategoryListByType() {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("category", 1);
		Result<List<MediaCategory>> result = RestServiceUtils.get(MediaCategoryServiceURL.URL_MEDIA_CATEGORY_LIST_INDEX, paramMap, new GenericType<Result<List<MediaCategory>>>(){});
		System.out.println(JsonUtils.object2Json(result));
	}
	
	public static void testGetCategoryListByParentId() {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("parentId", 9);
		Result<List<MediaCategory>> result = RestServiceUtils.get(MediaCategoryServiceURL.URL_MEDIA_CATEGORY_LIST_PARENT, paramMap, new GenericType<Result<List<MediaCategory>>>(){});
		System.out.println(JsonUtils.object2Json(result));
	}
	
	public static void main(String[] args) {
		//testGetCategoryListByType();
		testGetCategoryListByParentId();
	}

}
