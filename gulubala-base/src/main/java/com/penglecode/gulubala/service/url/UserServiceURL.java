package com.penglecode.gulubala.service.url;
/**
 * 用户服务URL
 * 
 * @author  pengpeng
 * @date 	 2015年7月29日 上午9:46:45
 * @version 1.0
 */
public interface UserServiceURL {

	/** APP端用户登录 */
	String URL_USER_LOGIN_APP = "app/user/login";
	
	/** APP端用户注册 */
	String URL_USER_REGISTER_APP = "app/user/register";
	
	/** 根据用户id获取用户详情信息 */
	String URL_USER_DETAIL_USERID = "user/detail/userid/{userId}";
	
	/** 根据手机号或邮箱获取用户详情信息 */
	String URL_USER_DETAIL_ACCOUNTNAME = "user/detail/accountname/{accountName}";
	
	/** 判断手机号或邮箱是否已存在 */
	String URL_USER_ACCOUNTNAME_EXISTS = "user/accountname/exists/{accountName}";
	
}
