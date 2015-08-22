package com.penglecode.gulubala.service.rest.test;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.GenericType;

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
	
	public static void main(String[] args) {
		testRestUserPassword();
	}

}
