package com.penglecode.gulubala.common.model;

import java.io.Serializable;
/**
 * 音乐评论模型
 * 
 * @author  pengpeng
 * @date 	 2015年8月7日 下午12:22:12
 * @version 1.0
 */
public class MusicComment implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 评论ID */
	private Long id;
	
	/** 评论的父节点ID */
	private Long parentId;
	
	/** 评论内容 */
	private String content;
	
	/** 评论时间 */
	private String commentTime;
	
	/** 评论用户ID */
	private Long userId;
	
	/** 评论类型 # */
	private Integer commentType;
	
	/** 评论的对象ID,歌曲ID或者歌单ID */
	private Long commentId;
	
	/** 评论点赞数 */
	private Integer commentPraises;

	//以下属于辅助字段
	
	/** 评论对象的名称 */
	private String commentName;
	
	/** 评论用户的头像URL */
	private String userIconUrl;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCommentTime() {
		return commentTime;
	}

	public void setCommentTime(String commentTime) {
		this.commentTime = commentTime;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getCommentType() {
		return commentType;
	}

	public void setCommentType(Integer commentType) {
		this.commentType = commentType;
	}

	public Long getCommentId() {
		return commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}

	public Integer getCommentPraises() {
		return commentPraises;
	}

	public void setCommentPraises(Integer commentPraises) {
		this.commentPraises = commentPraises;
	}

	public String getCommentName() {
		return commentName;
	}

	public void setCommentName(String commentName) {
		this.commentName = commentName;
	}

	public String getUserIconUrl() {
		return userIconUrl;
	}

	public void setUserIconUrl(String userIconUrl) {
		this.userIconUrl = userIconUrl;
	}
	
}
