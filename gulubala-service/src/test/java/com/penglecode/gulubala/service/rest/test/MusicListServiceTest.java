package com.penglecode.gulubala.service.rest.test;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.GenericType;

import com.penglecode.gulubala.common.model.MusicList;
import com.penglecode.gulubala.common.support.PagingList;
import com.penglecode.gulubala.common.support.Result;
import com.penglecode.gulubala.common.util.JsonUtils;
import com.penglecode.gulubala.common.util.RestServiceUtils;
import com.penglecode.gulubala.service.url.MusicListServiceURL;

public class MusicListServiceTest {

	public static void testCreateMusicList() {
		Result<Object> result = null;
		MusicList musicList = null;
		musicList = new MusicList();
		musicList.setListName("Vsinger 乐正绫试听曲 梦雨");
		musicList.setRemark("up主: 止战之殇");
		musicList.setMusicIds("8,9,10,11,12");
		result = RestServiceUtils.post(MusicListServiceURL.URL_MUSIC_LIST_CREATE, musicList, new GenericType<Result<Object>>(){});
		System.out.println(result);
		
		musicList = new MusicList();
		musicList.setListName("Evilious恶之大罪系列全PV合集");
		musicList.setRemark("up主: 夜的第七章");
		musicList.setMusicIds("1,2,3,4,5,6");
		result = RestServiceUtils.post(MusicListServiceURL.URL_MUSIC_LIST_CREATE, musicList, new GenericType<Result<Object>>(){});
		System.out.println(result);
		
		musicList = new MusicList();
		musicList.setListName("【双排键】WE GO");
		musicList.setRemark("up主: 止战之殇");
		musicList.setMusicIds("13,14,15,16,17");
		result = RestServiceUtils.post(MusicListServiceURL.URL_MUSIC_LIST_CREATE, musicList, new GenericType<Result<Object>>(){});
		System.out.println(result);
		
		musicList = new MusicList();
		musicList.setListName("周董的最爱！！！");
		musicList.setRemark("up主: 哟，不错噢！");
		musicList.setMusicIds("13,14,15,16,17");
		result = RestServiceUtils.post(MusicListServiceURL.URL_MUSIC_LIST_CREATE, musicList, new GenericType<Result<Object>>(){});
		System.out.println(result);
		
		musicList = new MusicList();
		musicList.setListName("永恒的周董！！！");
		musicList.setRemark("up主: 听爸爸的话");
		musicList.setMusicIds("18,19,20,21,22,23,24");
		result = RestServiceUtils.post(MusicListServiceURL.URL_MUSIC_LIST_CREATE, musicList, new GenericType<Result<Object>>(){});
		System.out.println(result);
		
		musicList = new MusicList();
		musicList.setListName("G.E.M.邓紫棋，我顶你！");
		musicList.setRemark("up主: 止战之殇");
		musicList.setMusicIds("7,8,9,10,11,12,25,26,27,28,29,30,31,32");
		result = RestServiceUtils.post(MusicListServiceURL.URL_MUSIC_LIST_CREATE, musicList, new GenericType<Result<Object>>(){});
		System.out.println(result);
		
		musicList = new MusicList();
		musicList.setListName("G.E.M.邓紫棋，中国好呻吟！");
		musicList.setRemark("up主: 止战之殇");
		musicList.setMusicIds("7,8,9,10,25,26,27,28,29,30,31,32");
		result = RestServiceUtils.post(MusicListServiceURL.URL_MUSIC_LIST_CREATE, musicList, new GenericType<Result<Object>>(){});
		System.out.println(result);
		
		musicList = new MusicList();
		musicList.setListName("大悲咒合集");
		musicList.setRemark("up主: 阿弥陀否");
		musicList.setMusicIds("1,2,3,4,5,6,8,9,10");
		result = RestServiceUtils.post(MusicListServiceURL.URL_MUSIC_LIST_CREATE, musicList, new GenericType<Result<Object>>(){});
		System.out.println(result);
		
		musicList = new MusicList();
		musicList.setListName("Vsinger 乐正绫试听曲 梦雨[Remix]");
		musicList.setRemark("up主: 止战之殇");
		musicList.setMusicIds("8,9,10,11,12");
		result = RestServiceUtils.post(MusicListServiceURL.URL_MUSIC_LIST_CREATE, musicList, new GenericType<Result<Object>>(){});
		System.out.println(result);
		
		musicList = new MusicList();
		musicList.setListName("Evilious恶之大罪系列全PV合集[Remix]");
		musicList.setRemark("up主: 夜的第七章");
		musicList.setMusicIds("1,2,3,4,5,6");
		result = RestServiceUtils.post(MusicListServiceURL.URL_MUSIC_LIST_CREATE, musicList, new GenericType<Result<Object>>(){});
		System.out.println(result);
		
		musicList = new MusicList();
		musicList.setListName("【双排键】WE GO[Remix]");
		musicList.setRemark("up主: 止战之殇");
		musicList.setMusicIds("13,14,15,16,17");
		result = RestServiceUtils.post(MusicListServiceURL.URL_MUSIC_LIST_CREATE, musicList, new GenericType<Result<Object>>(){});
		System.out.println(result);
		
		musicList = new MusicList();
		musicList.setListName("周董的最爱！！！[Remix]");
		musicList.setRemark("up主: 哟，不错噢！");
		musicList.setMusicIds("13,14,15,16,17");
		result = RestServiceUtils.post(MusicListServiceURL.URL_MUSIC_LIST_CREATE, musicList, new GenericType<Result<Object>>(){});
		System.out.println(result);
		
		musicList = new MusicList();
		musicList.setListName("永恒的周董！！！[Remix]");
		musicList.setRemark("up主: 听爸爸的话");
		musicList.setMusicIds("18,19,20,21,22,23,24");
		result = RestServiceUtils.post(MusicListServiceURL.URL_MUSIC_LIST_CREATE, musicList, new GenericType<Result<Object>>(){});
		System.out.println(result);
		
		musicList = new MusicList();
		musicList.setListName("G.E.M.邓紫棋，我顶你！[Remix]");
		musicList.setRemark("up主: 止战之殇");
		musicList.setMusicIds("7,8,9,10,11,12,25,26,27,28,29,30,31,32");
		result = RestServiceUtils.post(MusicListServiceURL.URL_MUSIC_LIST_CREATE, musicList, new GenericType<Result<Object>>(){});
		System.out.println(result);
		
		musicList = new MusicList();
		musicList.setListName("G.E.M.邓紫棋，中国好呻吟！[Remix]");
		musicList.setRemark("up主: 止战之殇");
		musicList.setMusicIds("7,8,9,10,25,26,27,28,29,30,31,32");
		result = RestServiceUtils.post(MusicListServiceURL.URL_MUSIC_LIST_CREATE, musicList, new GenericType<Result<Object>>(){});
		System.out.println(result);
		
		musicList = new MusicList();
		musicList.setListName("大悲咒合集[Remix]");
		musicList.setRemark("up主: 阿弥陀否");
		musicList.setMusicIds("1,2,3,4,5,6,8,9,10");
		result = RestServiceUtils.post(MusicListServiceURL.URL_MUSIC_LIST_CREATE, musicList, new GenericType<Result<Object>>(){});
		System.out.println(result);
	}
	
	public static void testGetMusicListById() {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("listId", 1);
		Result<MusicList> result = RestServiceUtils.get(MusicListServiceURL.URL_MUSIC_LIST_DETAIL, paramMap, new GenericType<Result<MusicList>>(){});
		System.out.println(JsonUtils.object2Json(result));
	}
	
	public static void testGetMusicLists() {
		Result<PagingList<MusicList>> result = RestServiceUtils.get(MusicListServiceURL.URL_MUSIC_LIST_LIST, null, new GenericType<Result<PagingList<MusicList>>>(){});
		System.out.println(JsonUtils.object2Json(result));
	}
	
	public static void main(String[] args) {
		//testCreateMusicList();
		testGetMusicListById();
		//testGetMusicLists();
	}

}
