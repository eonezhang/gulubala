package com.penglecode.gulubala.dao.user;

import com.penglecode.gulubala.common.model.UserMessage;

/**
 * 用户留言DAO
 * 
 * @author  pengpeng
 * @date 	 2015年8月20日 下午1:35:31
 * @version 1.0
 */
public interface UserMessageDAO {

	/**
	 * 新增用户留言
	 * @param message
	 */
	public void insertUserMessage(UserMessage message);
	
}
