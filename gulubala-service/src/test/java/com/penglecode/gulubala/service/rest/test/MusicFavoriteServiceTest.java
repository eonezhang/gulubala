package com.penglecode.gulubala.service.rest.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.GenericType;

import com.penglecode.gulubala.common.consts.em.MusicFavoriteTypeEnum;
import com.penglecode.gulubala.common.model.MusicFavorite;
import com.penglecode.gulubala.common.support.Result;
import com.penglecode.gulubala.common.util.JsonUtils;
import com.penglecode.gulubala.common.util.RestServiceUtils;
import com.penglecode.gulubala.service.url.MusicFavoriteServiceURL;

public class MusicFavoriteServiceTest {

	public static void testCreateMusicFavorite(){
		MusicFavorite favorite = new MusicFavorite();
		favorite = new MusicFavorite();
		favorite.setUserId(2L);
		favorite.setFavoriteId(2L);
		favorite.setFavoriteType(MusicFavoriteTypeEnum.FAVORITE_TYPE_MUSIC_LIST.getTypeCode());
		Result<Object> result = RestServiceUtils.post(MusicFavoriteServiceURL.URL_MUSIC_FAVORITE_CREATE, favorite, new GenericType<Result<Object>>(){});
		System.out.println(result);
	}
	
	public static void testDeleteMusicFavoriteById(){
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("id", 1);
		Result<Object> result = RestServiceUtils.get(MusicFavoriteServiceURL.URL_MUSIC_FAVORITE_DELETE, paramMap, new GenericType<Result<Object>>(){});
		System.out.println(JsonUtils.object2Json(result));
	}
	
	public static void testGetMusicFavoritesByUserId(){
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("userId", 2);
		Result<List<MusicFavorite>> result = RestServiceUtils.get(MusicFavoriteServiceURL.URL_MUSIC_FAVORITE_LIST, paramMap, new GenericType<Result<List<MusicFavorite>>>(){});
		System.out.println(JsonUtils.object2Json(result));
	}
	
	public static void main(String[] args) {
		//testCreateMusicFavorite();
		testDeleteMusicFavoriteById();
		//testGetMusicFavoritesByUserId();
	}

}
