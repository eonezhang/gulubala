package com.penglecode.gulubala.common.consts.em;

/**
 * 通用上下架状态枚举
 * 
 * @author	  	pengpeng
 * @date	  	2014年10月28日 下午5:26:46
 * @version  	1.0
 */
public enum OnlineOfflineStatusEnum {
	
	STATUS_OFFLINE(0, "下架"), STATUS_ONLINE(1, "上架");
	
	private Integer statusCode;
	
	private String statusName;
	

	private OnlineOfflineStatusEnum(Integer statusCode, String statusName) {
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

	public static OnlineOfflineStatusEnum getStatus(Integer statusCode) {
		for(OnlineOfflineStatusEnum em : values()){
			if(em.getStatusCode().equals(statusCode)){
				return em;
			}
		}
		return null;
	}
	
}
