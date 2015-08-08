package com.penglecode.gulubala.common.util;

import org.apache.commons.codec.digest.DigestUtils;

import com.penglecode.gulubala.common.support.AuthAppType;
import com.penglecode.gulubala.common.support.AuthRequest;
import com.penglecode.gulubala.common.support.ValidationAssert;

/**
 * 客户端应用程序认证授权码工具类
 * 
 * @author  pengpeng
 * @date 	 2015年8月4日 上午11:07:01
 * @version 1.0
 */
public class AppAuthUtils {

	/**
	 * 生成授权码
	 * @param authRequest
	 * @return
	 */
	public static String buildAuthCode(AuthRequest authRequest){
		ValidationAssert.notNull(authRequest, "请求参数不能为空!");
		ValidationAssert.notEmpty(authRequest.getAppId(), "appId不能为空!");
		ValidationAssert.notEmpty(authRequest.getAppType(), "appType不能为空!");
		ValidationAssert.notEmpty(authRequest.getAuthTime(), "authTime不能为空!");
		ValidationAssert.notEmpty(authRequest.getAppKey(), "appKey不能为空!");
		String code = authRequest.getAppId() + authRequest.getAppType() + authRequest.getAppKey() + authRequest.getAuthTime();
		return DigestUtils.md5Hex(code);
	}
	
	/**
	 * authToken生成方法
	 * @param user
	 * @return
	 */
	public static String generateAuthToken() {
		return UUIDUtils.uuid();
	}
	
	/**
	 * clientId生成方法
	 * @return
	 */
	public static String generateClientId() {
		return UUIDUtils.uuid();
	}
	
	/**
	 * appId生成方法
	 * @return
	 */
	public static String generateAppId() {
		return UUIDUtils.uuid();
	}
	
	/**
	 * appKey生成方法
	 * @param user
	 * @return
	 */
	public static String generateAppKey() {
		return UUIDUtils.uuid();
	}
	
	public static void main(String[] args) {
		AuthRequest authRequest = new AuthRequest();
		authRequest.setAppId("gulubala_app_android");
		authRequest.setAppType(AuthAppType.APP_TYPE_ANDROID.getTypeCode());
		authRequest.setAppKey("90e98f4e2c6d49b4a1b7e70588898517");
		authRequest.setAuthTime(String.valueOf(System.currentTimeMillis()));
		authRequest.setAuthCode(buildAuthCode(authRequest));
		System.out.println(JsonUtils.object2Json(authRequest));
	}
	
}
