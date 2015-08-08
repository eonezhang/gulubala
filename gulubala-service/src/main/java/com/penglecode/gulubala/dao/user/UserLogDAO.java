package com.penglecode.gulubala.dao.user;

import com.penglecode.gulubala.common.model.UserLog;

/**
 * 用户操作日志DAO
 * 
 * @author  pengpeng
 * @date 	 2015年8月7日 下午2:40:39
 * @version 1.0
 */
public interface UserLogDAO {

	/**
	 * 插入日志记录
	 * @param accessLog
	 */
	public void insertUserLog(UserLog userLog);
	
}
