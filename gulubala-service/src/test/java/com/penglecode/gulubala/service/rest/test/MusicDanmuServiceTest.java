package com.penglecode.gulubala.service.rest.test;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.GenericType;

import com.penglecode.gulubala.common.model.MusicDanmu;
import com.penglecode.gulubala.common.support.Result;
import com.penglecode.gulubala.common.util.JsonUtils;
import com.penglecode.gulubala.common.util.RestServiceUtils;
import com.penglecode.gulubala.service.url.MusicDanmuServiceURL;

public class MusicDanmuServiceTest {

	public static void testCreateMusicDanmu(){
		MusicDanmu danmu = new MusicDanmu();
		danmu = new MusicDanmu();
		danmu.setMusicId(1L);
		danmu.setUserId(3L);
		danmu.setContent("这首歌真心不错哎！!!");
		Result<Object> result = RestServiceUtils.post(MusicDanmuServiceURL.URL_MUSIC_DANMU_CREATE, danmu, new GenericType<Result<Object>>(){});
		System.out.println(result);
	}
	
	public static void testShowNextMusicDanmu(){
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("musicId", 1);
		Result<MusicDanmu> result = RestServiceUtils.get(MusicDanmuServiceURL.URL_MUSIC_DANMU_SHOW_NEXT, paramMap, new GenericType<Result<MusicDanmu>>(){});
		System.out.println(JsonUtils.object2Json(result));
	}
	
	public static void main(String[] args) {
		//testCreateMusicDanmu();
		testShowNextMusicDanmu();
	}

}
