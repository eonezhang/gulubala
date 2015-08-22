package com.penglecode.gulubala.service.rest.test;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.GenericType;

import com.penglecode.gulubala.common.support.Result;
import com.penglecode.gulubala.common.util.JsonUtils;
import com.penglecode.gulubala.common.util.RestServiceUtils;
import com.penglecode.gulubala.service.url.MessageSendServiceURL;

public class MessageSendServiceTest {

	public static void sendValidateCodeBySms(){
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("sceneType", "password");
		paramMap.put("mobilePhone", "15151887280");
		Result<Object> result = RestServiceUtils.get(MessageSendServiceURL.URL_MSG_SEND_SMS, paramMap, new GenericType<Result<Object>>(){});
		System.out.println(JsonUtils.object2Json(result));
	}
	
	public static void sendValidateCodeByEmail(){
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("sceneType", "retrievepwd");
		paramMap.put("email", "303836018@qq.com");
		Result<Object> result = RestServiceUtils.get(MessageSendServiceURL.URL_MSG_SEND_EMAIL, paramMap, new GenericType<Result<Object>>(){});
		System.out.println(JsonUtils.object2Json(result));
	}
	
	public static void main(String[] args) {
		sendValidateCodeBySms();
	}

}
