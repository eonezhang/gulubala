package com.penglecode.gulubala.service.rest.test;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.GenericType;

import com.penglecode.gulubala.common.model.Music;
import com.penglecode.gulubala.common.support.PagingList;
import com.penglecode.gulubala.common.support.Result;
import com.penglecode.gulubala.common.util.JsonUtils;
import com.penglecode.gulubala.common.util.RestServiceUtils;
import com.penglecode.gulubala.service.url.MusicPlayHistoryServiceURL;

public class MusicPlayHistoryServiceTest {

	public static void testDeleteMusicPlayHistoryByUserId() {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("userId", 2);
		Result<Object> result = RestServiceUtils.get(MusicPlayHistoryServiceURL.URL_MUSIC_PLAY_HISTORY_DEL, paramMap, new GenericType<Result<Object>>(){});
		System.out.println(JsonUtils.object2Json(result));
	}
	
	public static void testGetMusicPlayHistoryByUserId() {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("userId", 3);
		paramMap.put("currentPage", 1);
		paramMap.put("pageSize", 10);
		Result<PagingList<Music>> result = RestServiceUtils.get(MusicPlayHistoryServiceURL.URL_MUSIC_PLAY_HISTORY_LIST, paramMap, new GenericType<Result<PagingList<Music>>>(){});
		System.out.println(JsonUtils.object2Json(result));
	}
	
	public static void main(String[] args) {
		testGetMusicPlayHistoryByUserId();
		//testDeleteMusicPlayHistoryByUserId();
	}

}
