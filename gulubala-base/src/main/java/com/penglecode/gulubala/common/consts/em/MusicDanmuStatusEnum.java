package com.penglecode.gulubala.common.consts.em;
/**
 * 用户状态
 * 
 * @author  pengpeng
 * @date 	 2015年8月5日 下午5:09:01
 * @version 1.0
 */
public enum MusicDanmuStatusEnum {

	DANMU_STATUS_YES(1, "已弹出"), DANMU_STATUS_NO(0, "未弹出");
	
	private Integer statusCode;
	
	private String statusName;

	private MusicDanmuStatusEnum(Integer statusCode, String statusName) {
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
