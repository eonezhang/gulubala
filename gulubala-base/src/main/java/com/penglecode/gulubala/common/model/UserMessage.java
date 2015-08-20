package com.penglecode.gulubala.common.model;

import java.io.Serializable;
/**
 * 用户留言模型
 * 
 * @author  pengpeng
 * @date 	 2015年8月20日 下午12:29:48
 * @version 1.0
 */
public class UserMessage implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 留言id */
	private Long id;
	
	/** 用户id */
	private Long userId;
	
	/** 留言内容 */
	private String messageContent;
	
	/** 留言回复 */
	private String messageReply;
	
	private String createTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	public String getMessageReply() {
		return messageReply;
	}

	public void setMessageReply(String messageReply) {
		this.messageReply = messageReply;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
}
