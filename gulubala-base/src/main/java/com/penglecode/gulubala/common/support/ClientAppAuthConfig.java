package com.penglecode.gulubala.common.support;

import java.io.Serializable;
/**
 * 客户端认证授权配置
 * 
 * @author  pengpeng
 * @date 	 2015年8月4日 上午9:58:36
 * @version 1.0
 */
public class ClientAppAuthConfig implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 分配给客户端的应用ID */
	private String appId;
	
	/** 客户端应用名称 */
	private String appName;
	
	/** 分配给客户端的应用秘钥 */
	private String appKey;
	
	/** 客户端类型{@link #AuthClientAppType} */
	private String appType;
	
	/** 客户端认证授权配置状态 {@link #EnableDisableStatusEnum} */
	private Integer status;
	
	private String createTime;

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getAppKey() {
		return appKey;
	}

	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

	public String getAppType() {
		return appType;
	}

	public void setAppType(String appType) {
		this.appType = appType;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

}
