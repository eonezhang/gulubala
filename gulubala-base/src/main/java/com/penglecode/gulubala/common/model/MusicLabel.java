package com.penglecode.gulubala.common.model;

import java.io.Serializable;
/**
 * 音乐标签模型
 * 
 * @author  pengpeng
 * @date 	 2015年8月7日 下午1:11:57
 * @version 1.0
 */
public class MusicLabel implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 标签ID */
	private Integer labelId;
	
	/** 标签名称 */
	private String labelName;
	
	/** 创建者ID */
	private Long createBy;
	
	/** 创建时间 */
	private String createTime;

	public Integer getLabelId() {
		return labelId;
	}

	public void setLabelId(Integer labelId) {
		this.labelId = labelId;
	}

	public String getLabelName() {
		return labelName;
	}

	public void setLabelName(String labelName) {
		this.labelName = labelName;
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
