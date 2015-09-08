package com.penglecode.gulubala.service.rest.test;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.GenericType;

import com.penglecode.gulubala.common.model.Notice;
import com.penglecode.gulubala.common.support.PagingList;
import com.penglecode.gulubala.common.support.Result;
import com.penglecode.gulubala.common.util.JsonUtils;
import com.penglecode.gulubala.common.util.RestServiceUtils;
import com.penglecode.gulubala.service.url.NoticeServiceURL;

public class NoticeServiceTest {

	public static void testGetNoticeList() {
		Result<PagingList<Notice>> result = RestServiceUtils.get(NoticeServiceURL.URL_NOTICE_LIST, null, new GenericType<Result<PagingList<Notice>>>(){});
		System.out.println(JsonUtils.object2Json(result));
	}
	
	public static void testGetNoticeById() {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("id", 1L);
		Result<Notice> result = RestServiceUtils.get(NoticeServiceURL.URL_NOTICE_DETAIL, paramMap, new GenericType<Result<Notice>>(){});
		System.out.println(JsonUtils.object2Json(result));
	}
	
	public static void testIncrNoticeReadCount() {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("id", 1L);
		Result<Object> result = RestServiceUtils.get(NoticeServiceURL.URL_NOTICE_READ_COUNT_INCR, paramMap, new GenericType<Result<Object>>(){});
		System.out.println(JsonUtils.object2Json(result));
	}
	
	public static void main(String[] args) throws Exception {
		//testGetNoticeList();
		//testGetNoticeById();
		testIncrNoticeReadCount();
	}
	
}
