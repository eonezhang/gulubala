package com.penglecode.gulubala.common.consts.em;
/**
 * 用户上传音乐审核状态
 * 
 * @author  pengpeng
 * @date 	 2015年9月8日 上午10:08:57
 * @version 1.0
 */
public enum UserUploadMusicCheckStatus {

	CHECK_STATUS_INITIAL(0, "草稿"), CHECK_STATUS_WAIT(1, "待审核"), CHECK_STATUS_APPROVED(2, "审核通过"), CHECK_STATUS_UNAPPROVED(3, "谢绝");
	
	private Integer statusCode;
	
	private String statusName;

	private UserUploadMusicCheckStatus(Integer statusCode, String statusName) {
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
