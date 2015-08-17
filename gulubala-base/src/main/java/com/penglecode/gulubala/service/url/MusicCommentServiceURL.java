package com.penglecode.gulubala.service.url;
/**
 * 音乐评论服务URL
 * 
 * @author  pengpeng
 * @date 	 2015年8月17日 上午10:30:29
 * @version 1.0
 */
public interface MusicCommentServiceURL {

	/** 创建评论 */
	String URL_MUSIC_COMMENT_CREATE = "comment/create";
	
	/** 获取用户评论 */
	String URL_MUSIC_COMMENT_LIST_USER = "comment/list/{userId}";
	
	/** 删除用户评论 */
	String URL_MUSIC_COMMENT_DELETE = "comment/delete/{id}";
	
	/** 点赞用户评论 */
	String URL_MUSIC_COMMENT_PRAISE = "comment/praise/{id}";
	
}
