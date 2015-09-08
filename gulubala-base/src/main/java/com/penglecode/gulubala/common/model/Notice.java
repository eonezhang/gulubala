package com.penglecode.gulubala.common.model;

import java.io.Serializable;
/**
 * 公告模型
 * 
 * @author  pengpeng
 * @date 	 2015年9月8日 上午10:39:43
 * @version 1.0
 */
public class Notice implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 公告ID */
	private Long id;
	
	/** 公告标题 */
	private String title;

	/** 公告内容 */
	private String content;
	
	/** 公告发布者 */
	private String publisher;
	
	/** 公告发布状态 */
	private Integer status;
	
	/** 公告已阅人数 */
	private Integer readCount;
	
	/** 创建时间 */
	private String createTime;
	
	/** 更新时间 */
	private String updateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getReadCount() {
		return readCount;
	}

	public void setReadCount(Integer readCount) {
		this.readCount = readCount;
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
