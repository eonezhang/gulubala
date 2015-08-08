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
	private Long commentId;
	
	/** 评论内容 */
	private String content;
	
	/** 评论的音乐ID */
	private Long musicId;
	
	/** 评论时间 */
	private String commentTime;
	
	/** 评论的父节点ID */
	private Long parentCommentId;
	
	/** 评论点赞数 */
	private Integer commentPraiseCount;
	
	/** 评论用户ID */
	private Long userId;

	public Long getCommentId() {
		return commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getMusicId() {
		return musicId;
	}

	public void setMusicId(Long musicId) {
		this.musicId = musicId;
	}

	public String getCommentTime() {
		return commentTime;
	}

	public void setCommentTime(String commentTime) {
		this.commentTime = commentTime;
	}

	public Long getParentCommentId() {
		return parentCommentId;
	}

	public void setParentCommentId(Long parentCommentId) {
		this.parentCommentId = parentCommentId;
	}

	public Integer getCommentPraiseCount() {
		return commentPraiseCount;
	}

	public void setCommentPraiseCount(Integer commentPraiseCount) {
		this.commentPraiseCount = commentPraiseCount;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
}
