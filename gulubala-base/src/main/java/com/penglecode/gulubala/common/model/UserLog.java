package com.penglecode.gulubala.common.model;

import java.io.Serializable;
/**
 * 用户操作日志表
 * 
 * @author  pengpeng
 * @date 	 2015年8月7日 下午1:51:59
 * @version 1.0
 */
public class UserLog implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 日志ID */
	private Long logId;
	
	/** 日志标题 */
	private String logTitle;
	
	/** 日志类型 */
	private Integer logType;
	
	/** Http请求方法 */
	private String httpMethod;
	
	/** 请求URL */
	private String requestUrl;
	
	/** 请求参数(Json字符串) */
	private String requestParams;
	
	/** 请求结果(Json字符串) */
	private String requestResult;
	
	/** 操作用户ID */
	private Long operatorId;
	
	/** 操作时间 */
	private String operateTime;
	
	/** 操作耗时 */
	private Long operateTimeMillis;
	
	/** 操作IP */
	private String operateIp;
	
	public Long getLogId() {
		return logId;
	}

	public void setLogId(Long logId) {
		this.logId = logId;
	}

	public String getLogTitle() {
		return logTitle;
	}

	public void setLogTitle(String logTitle) {
		this.logTitle = logTitle;
	}

	public Integer getLogType() {
		return logType;
	}

	public void setLogType(Integer logType) {
		this.logType = logType;
	}

	public String getHttpMethod() {
		return httpMethod;
	}

	public void setHttpMethod(String httpMethod) {
		this.httpMethod = httpMethod;
	}

	public String getRequestUrl() {
		return requestUrl;
	}

	public void setRequestUrl(String requestUrl) {
		this.requestUrl = requestUrl;
	}

	public String getRequestParams() {
		return requestParams;
	}

	public void setRequestParams(String requestParams) {
		this.requestParams = requestParams;
	}

	public String getRequestResult() {
		return requestResult;
	}

	public void setRequestResult(String requestResult) {
		this.requestResult = requestResult;
	}

	public Long getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}

	public String getOperateTime() {
		return operateTime;
	}

	public void setOperateTime(String operateTime) {
		this.operateTime = operateTime;
	}

	public Long getOperateTimeMillis() {
		return operateTimeMillis;
	}

	public void setOperateTimeMillis(Long operateTimeMillis) {
		this.operateTimeMillis = operateTimeMillis;
	}

	public String getOperateIp() {
		return operateIp;
	}

	public void setOperateIp(String operateIp) {
		this.operateIp = operateIp;
	}

}
