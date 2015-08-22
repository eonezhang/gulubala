package com.penglecode.gulubala.service.rest.test;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.GenericType;

import com.penglecode.gulubala.common.consts.em.MusicCommentTypeEnum;
import com.penglecode.gulubala.common.model.MusicComment;
import com.penglecode.gulubala.common.support.PagingList;
import com.penglecode.gulubala.common.support.Result;
import com.penglecode.gulubala.common.util.JsonUtils;
import com.penglecode.gulubala.common.util.RestServiceUtils;
import com.penglecode.gulubala.service.url.MusicCommentServiceURL;

public class MusicCommentServiceTest {

	public static void testCreateMusicComment(){
		MusicComment comment = new MusicComment();
		comment = new MusicComment();
		comment.setUserId(2L);
		comment.setCommentId(4L);
		comment.setContent("这歌太烂了！");
		comment.setCommentType(MusicCommentTypeEnum.COMMENT_TYPE_MUSIC.getTypeCode());
		Result<Object> result = RestServiceUtils.post(MusicCommentServiceURL.URL_MUSIC_COMMENT_CREATE, comment, new GenericType<Result<Object>>(){});
		System.out.println(result);
	}
	
	public static void testDeleteMusicCommentById(){
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("id", 1);
		Result<Object> result = RestServiceUtils.get(MusicCommentServiceURL.URL_MUSIC_COMMENT_DELETE, paramMap, new GenericType<Result<Object>>(){});
		System.out.println(JsonUtils.object2Json(result));
	}
	
	public static void testPraiseMusicComment(){
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("id", 4);
		Result<Object> result = RestServiceUtils.get(MusicCommentServiceURL.URL_MUSIC_COMMENT_PRAISE, paramMap, new GenericType<Result<Object>>(){});
		System.out.println(JsonUtils.object2Json(result));
	}
	
	public static void testGetMusicCommentsByUserId(){
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("userId", 2);
		paramMap.put("commentType", 1);
		Result<PagingList<MusicComment>> result = RestServiceUtils.get(MusicCommentServiceURL.URL_MUSIC_COMMENT_LIST_USER, paramMap, new GenericType<Result<PagingList<MusicComment>>>(){});
		System.out.println(JsonUtils.object2Json(result));
	}
	
	public static void testGetMusicCommentsByCommentId(){
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("commentId", 5);
		paramMap.put("commentType", 1);
		Result<PagingList<MusicComment>> result = RestServiceUtils.get(MusicCommentServiceURL.URL_MUSIC_COMMENT_LIST_MUSIC, paramMap, new GenericType<Result<PagingList<MusicComment>>>(){});
		System.out.println(JsonUtils.object2Json(result));
	}
	
	public static void main(String[] args) {
		//testCreateMusicComment();
		//testPraiseMusicComment();
		//testDeleteMusicCommentById();
		testGetMusicCommentsByUserId();
		//testGetMusicCommentsByCommentId();
	}

}
