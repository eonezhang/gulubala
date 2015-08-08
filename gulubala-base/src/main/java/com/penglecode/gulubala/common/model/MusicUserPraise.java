package com.penglecode.gulubala.common.model;

import java.io.Serializable;
/**
 * 音乐用户点赞模型
 * 
 * @author  pengpeng
 * @date 	 2015年8月7日 下午12:29:22
 * @version 1.0
 */
public class MusicUserPraise implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 点赞ID */
	private Long praiseId;
	
	/** 点赞类别ID */
	private Long praiseCategoryId;
	
	/** 操作人ID */
	private Long createBy;
	
	/** 点赞时间 */
	private String createTime;

	public Long getPraiseId() {
		return praiseId;
	}

	public void setPraiseId(Long praiseId) {
		this.praiseId = praiseId;
	}

	public Long getPraiseCategoryId() {
		return praiseCategoryId;
	}

	public void setPraiseCategoryId(Long praiseCategoryId) {
		this.praiseCategoryId = praiseCategoryId;
	}

	public Long getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
}
