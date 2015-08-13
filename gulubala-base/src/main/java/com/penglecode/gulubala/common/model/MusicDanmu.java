package com.penglecode.gulubala.common.model;

import java.io.Serializable;
/**
 * 音乐弹幕模型
 * 
 * @author  pengpeng
 * @date 	 2015年8月7日 下午12:22:12
 * @version 1.0
 */
public class MusicDanmu implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 弹幕ID */
	private Long id;
	
	/** 评论的音乐ID */
	private Long musicId;
	
	/** 评论用户ID */
	private Long userId;
	
	/** 弹幕内容 */
	private String content;
	
	/** 评论时间 */
	private String showTime;
	
	private String createTime;
	
	private String updateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMusicId() {
		return musicId;
	}

	public void setMusicId(Long musicId) {
		this.musicId = musicId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getShowTime() {
		return showTime;
	}

	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

}
