package com.penglecode.gulubala.common.model;

import java.io.Serializable;
/**
 * 通用媒体分类模型
 * 
 * @author  pengpeng
 * @date 	 2015年8月7日 上午11:20:26
 * @version 1.0
 */
public class MediaCategory implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 分类ID */
	private Integer categoryId; 
	
	/** 分类名称 */
	private String categoryName;
	
	/** 父分类ID */
	private Integer parentCategoryId;
	
	/** 兄弟分类节点间的排序值,ASC */
	private Integer siblingsOrder;
	
	/** 创建者ID */
	private Long createBy;
	
	/** 创建时间 */
	private String createTime;

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Integer getParentCategoryId() {
		return parentCategoryId;
	}

	public void setParentCategoryId(Integer parentCategoryId) {
		this.parentCategoryId = parentCategoryId;
	}

	public Integer getSiblingsOrder() {
		return siblingsOrder;
	}

	public void setSiblingsOrder(Integer siblingsOrder) {
		this.siblingsOrder = siblingsOrder;
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
