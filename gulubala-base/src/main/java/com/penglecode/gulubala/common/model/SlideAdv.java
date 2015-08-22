package com.penglecode.gulubala.common.model;

import java.io.Serializable;
/**
 * 轮播广告模型
 * 
 * @author  pengpeng
 * @date 	 2015年8月21日 下午5:02:42
 * @version 1.0
 */
public class SlideAdv implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 广告ID */
	private Long id;
	
	/** 广告标题 */
	private String title;
	
	/** 广告图片URL */
	private String imgUrl;
	
	/** 轮播排序值 */
	private Integer orderIndex; 
	
	/** 状态(1-上架,0-下架) */
	private Integer status;
	
	/** 备注 */
	private String remark;
	
	private String createTime;
	
	private String updateTime;

	//以下属于辅助字段
	
	private String fullImgUrl;
	
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

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Integer getOrderIndex() {
		return orderIndex;
	}

	public void setOrderIndex(Integer orderIndex) {
		this.orderIndex = orderIndex;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	public String getFullImgUrl() {
		return fullImgUrl;
	}

	public void setFullImgUrl(String fullImgUrl) {
		this.fullImgUrl = fullImgUrl;
	}
	
}
