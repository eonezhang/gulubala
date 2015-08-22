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
	 * 更新用户登录信息
	 * @param userId
	 * @param loginTime
	 */
	public void updateUser4Login(Long userId, String loginTime);
	
	/**
	 * 更新用户基本信息
	 * @param user
	 */
	public void updateUserProfile(User user);
	
	/**
	 * 更新用户密码
	 * @param user
	 */
	public void updateUserPassword(User user);
	
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
	 * 根据mobilePhone获取用户信息(部分字段)
	 * @param userId
	 * @return
	 */
	public User getThinUserByMobile(String mobilePhone);
	
	/**
	 * 根据email获取用户信息(部分字段)
	 * @param email
	 * @return
	 */
	public User getThinUserByEmail(String email);
	
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
	
	/**
	 * 判断手机号是否存在
	 * @param mobilePhone
	 * @return
	 */
	public boolean isMobilePhoneExists(String mobilePhone);
	
	/**
	 * 判断email号是否存在
	 * @param email
	 * @return
	 */
	public boolean isEmailExists(String email);
	
	/**
	 * 自增用户的被关注数
	 * @param userId
	 */
	public void incrUserFollows(Long userId);

	/**
	 * 自减用户的被关注数
	 * @param userId
	 */
	public void decrUserFollows(Long userId);
	
	/**
	 * 自增用户的人气数
	 * @param userId
	 */
	public void incrUserHots(Long userId);

	/**
	 * 自增用户的点赞数
	 * @param userId
	 */
	public void incrUserPraises(Long userId);
	
}
