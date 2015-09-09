package com.penglecode.gulubala.service.rest.test;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.GenericType;

import com.penglecode.gulubala.common.consts.em.UserRegisterTypeEnum;
import com.penglecode.gulubala.common.support.Result;
import com.penglecode.gulubala.common.util.JsonUtils;
import com.penglecode.gulubala.common.util.RestServiceUtils;
import com.penglecode.gulubala.service.url.UserServiceURL;

public class UserServiceTest {

	public static void testRestUserPassword(){
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("validateCode", "506468");
		paramMap.put("newPassword", "111222");
		paramMap.put("accountName", "15151887280");
		Result<Object> result = RestServiceUtils.post(UserServiceURL.URL_USER_PASSWORD_RESET, paramMap, new GenericType<Result<Object>>(){});
		System.out.println(JsonUtils.object2Json(result));
	}
	
	public static void testThirdUserLogin(){
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("thirdAccountName", "303836018");
		paramMap.put("registerType", UserRegisterTypeEnum.USER_REG_TYPE_THIRD_QQ.getTypeCode());
		Result<Object> result = RestServiceUtils.post(UserServiceURL.URL_THIRD_USER_LOGIN_APP, paramMap, new GenericType<Result<Object>>(){});
		System.out.println(JsonUtils.object2Json(result));
	}
	
	public static void testGetUserById(){
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("userId", 2L);
		Result<Object> result = RestServiceUtils.get(UserServiceURL.URL_USER_DETAIL_USERID, paramMap, new GenericType<Result<Object>>(){});
		System.out.println(JsonUtils.object2Json(result));
	}
	
	public static void main(String[] args) {
		//testRestUserPassword();
		testThirdUserLogin();
		//testGetUserById();
	}

}
