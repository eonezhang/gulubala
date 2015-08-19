package com.penglecode.gulubala.service.url;
/**
 * 用户关注服务URL
 * 
 * @author  pengpeng
 * @date 	 2015年8月19日 下午1:19:32
 * @version 1.0
 */
public interface UserFollowServiceURL {

	/** 添加关注 */
	String URL_USER_FOLLOW_ADD = "user/follow/add";
	
	/** 取消关注 */
	String URL_USER_FOLLOW_CANCEL = "user/follow/cancel/{id}";
	
	/** 我的关注列表(分页) */
	String URL_USER_FOLLOW_LIST = "user/follow/list/{userId}";
	
}
