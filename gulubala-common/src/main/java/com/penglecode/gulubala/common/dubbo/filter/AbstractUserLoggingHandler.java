package com.penglecode.gulubala.common.dubbo.filter;

import org.springframework.util.Assert;

import com.penglecode.gulubala.common.model.UserLog;
/**
 * 用户日志处理类
 * 
 * @author  pengpeng
 * @date 	 2015年8月8日 上午10:51:16
 * @version 1.0
 */
public abstract class AbstractUserLoggingHandler implements Runnable {

	private UserLog userLog;
	
	public AbstractUserLoggingHandler() {
		super();
	}
	
	protected void setUserLog(UserLog userLog) {
		Assert.notNull(userLog, "Property 'userLog' can not be null!");
		this.userLog = userLog;
	}

	public void run() {
		handleUserLogging(userLog);
	}
	
	public abstract void handleUserLogging(UserLog userLog);
	
}