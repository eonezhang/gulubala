package com.penglecode.gulubala.common.support;

import java.io.Serializable;
/**
 * 客户端认证授权令牌
 * 
 * @author  pengpeng
 * @date 	 2015年7月29日 上午9:51:38
 * @version 1.0
 */
public class AuthResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 登录成功后服务端为客户端分配的一个唯一ID */
	private String clientId;
	
	/** 登录成功后服务端为客户端分配的认证授权码 */
	private String authToken;

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}
	
}
