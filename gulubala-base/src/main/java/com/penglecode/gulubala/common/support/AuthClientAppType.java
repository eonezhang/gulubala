package com.penglecode.gulubala.common.support;
/**
 * 认证授权-客户端类型
 * 
 * @author  pengpeng
 * @date 	 2015年8月4日 上午9:41:03
 * @version 1.0
 */
public enum AuthClientAppType {

	CLIENT_APP_TYPE_ANDROID("android", "android"), CLIENT_APP_TYPE_IOS("ios", "ios");
	
	private String typeCode;
	
	private String typeName;

	private AuthClientAppType(String typeCode, String typeName) {
		this.typeCode = typeCode;
		this.typeName = typeName;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public static AuthClientAppType getAuthClientType(String typeCode) {
		for(AuthClientAppType em : values()){
			if(em.getTypeCode().equals(typeCode)){
				return em;
			}
		}
		return null;
	}
	
}
