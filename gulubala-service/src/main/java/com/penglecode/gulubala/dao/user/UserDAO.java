package com.penglecode.gulubala.dao.user;

import com.penglecode.gulubala.common.model.User;
/**
 * 用户账户DAO
 * 
 * @author  pengpeng
 * @date 	 2015年8月5日 下午5:49:01
 * @version 1.0
 */
public interface UserDAO {

	/**
	 * 新增用户
	 * @param user
	 */
	public void insertUser(User user);
	
	/**
	 * 根据userId获取用户信息(全字段)
	 * @param userId
	 * @return
	 */
	public User getUserById(Long userId);
	
	/**
	 * 根据userId获取用户信息(部分字段)
	 * @param userId
	 * @return
	 */
	public User getThinUserById(Long userId);
	
	/**
	 * 根据mobilePhone获取用户信息(全字段)
	 * @param mobilePhone
	 * @return
	 */
	public User getUserByMobile(String mobilePhone);
	
	/**
	 * 根据email获取用户信息(全字段)
	 * @param email
	 * @return
	 */
	public User getUserByEmail(String email);
	
}
