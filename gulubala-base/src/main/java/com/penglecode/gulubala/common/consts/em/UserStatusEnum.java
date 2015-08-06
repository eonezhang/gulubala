package com.penglecode.gulubala.common.consts.em;
/**
 * 用户状态
 * 
 * @author  pengpeng
 * @date 	 2015年8月5日 下午5:09:01
 * @version 1.0
 */
public enum UserStatusEnum {

	USER_STATUS_ENABLED(1, "正常"), USER_STATUS_DISABLED(0, "冻结");
	
	private Integer statusCode;
	
	private String statusName;

	private UserStatusEnum(Integer statusCode, String statusName) {
		this.statusCode = statusCode;
		this.statusName = statusName;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	
}
