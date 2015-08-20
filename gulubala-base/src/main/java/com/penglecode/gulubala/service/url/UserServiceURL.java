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
	
	/** 自增用户的被关注数 */
	String URL_USER_INCR_FOLLOWS = "user/follows/incr/{userId}";
	
	/** 自增用户的人气数 */
	String URL_USER_INCR_HOTS = "user/hots/incr/{userId}";
	
	/** 自增用户的点赞数 */
	String URL_USER_INCR_PRAISES = "user/praises/incr/{userId}";
	
	/** 修改用户基本信息 */
	String URL_USER_PROFILE_UPDATE = "user/profile/update";
	
	/** 用户提交留言信息 */
	String URL_USER_MESSAGE_SUBMIT = "user/message/submit";
	
}
