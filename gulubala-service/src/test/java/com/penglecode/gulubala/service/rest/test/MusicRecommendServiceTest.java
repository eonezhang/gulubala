package com.penglecode.gulubala.service.rest.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.GenericType;

import com.penglecode.gulubala.common.model.MusicRecommend;
import com.penglecode.gulubala.common.support.PagingList;
import com.penglecode.gulubala.common.support.Result;
import com.penglecode.gulubala.common.util.JsonUtils;
import com.penglecode.gulubala.common.util.RestServiceUtils;
import com.penglecode.gulubala.service.url.MusicRecommendServiceURL;

public class MusicRecommendServiceTest {

	public static void testGetMusicList4index() {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("categoryId", 9);
		paramMap.put("mediaType", 1);
		Result<PagingList<MusicRecommend>> result = RestServiceUtils.get(MusicRecommendServiceURL.URL_MUSIC_LIST_INDEX, paramMap, new GenericType<Result<PagingList<MusicRecommend>>>(){});
		System.out.println(JsonUtils.object2Json(result));
	}
	
	public static void testGetMusicList4hots() {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("categoryId", 9);
		//paramMap.put("mediaType", 1);
		Result<PagingList<MusicRecommend>> result = RestServiceUtils.get(MusicRecommendServiceURL.URL_MUSIC_LIST_HOTS, paramMap, new GenericType<Result<PagingList<MusicRecommend>>>(){});
		System.out.println(JsonUtils.object2Json(result));
	}
	
	public static void testGetIndexAdvList4index() {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		//paramMap.put("categoryId", 6);
		//paramMap.put("mediaType", 1);
		Result<List<MusicRecommend>> result = RestServiceUtils.get(MusicRecommendServiceURL.URL_INDEX_ADV_LIST, paramMap, new GenericType<Result<List<MusicRecommend>>>(){});
		System.out.println(JsonUtils.object2Json(result));
	}
	
	public static void testGetGuideAdvList4index() {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		//paramMap.put("categoryId", 6);
		//paramMap.put("mediaType", 1);
		Result<List<MusicRecommend>> result = RestServiceUtils.get(MusicRecommendServiceURL.URL_GUIDE_ADV_LIST, paramMap, new GenericType<Result<List<MusicRecommend>>>(){});
		System.out.println(JsonUtils.object2Json(result));
	}
	
	public static void main(String[] args) throws Exception {
		//testGetMusicList4index();
		//testGetMusicList4hots();
		//testGetIndexAdvList4index();
		testGetGuideAdvList4index();
	}

}
