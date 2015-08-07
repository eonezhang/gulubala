package com.penglecode.gulubala.common.support;

import java.io.Serializable;
/**
 * 客户端应用程序认证授权请求
 * 
 * @author  pengpeng
 * @date 	 2015年8月4日 上午9:20:36
 * @version 1.0
 */
public class AuthRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 旧的客户端id(该参数客户端可选) */
	private String clientId;
	
	/** 分配给客户端应用程序的秘钥 */
	private String appKey;
	
	/** 分配给客户端应用程序的ID */
	private String appId;
	
	/** 客户端应用程序类型{@link #AuthClientAppType} */
	private String appType;
	
	/** 认证授权时间 */
	private String authTime;

	/** 认证授权码,由客户端算出,计算公式：MD5(appId + appType + appKey + authTime) 注意顺序 */
	private String authCode;

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getAppKey() {
		return appKey;
	}

	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getAppType() {
		return appType;
	}

	public void setAppType(String appType) {
		this.appType = appType;
	}

	public String getAuthTime() {
		return authTime;
	}

	public void setAuthTime(String authTime) {
		this.authTime = authTime;
	}

	public String getAuthCode() {
		return authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	public String toString() {
		return "AuthRequest [appKey=" + appKey + ", appId=" + appId
				+ ", appType=" + appType + ", authTime=" + authTime
				+ ", authCode=" + authCode + "]";
	}
	
}
