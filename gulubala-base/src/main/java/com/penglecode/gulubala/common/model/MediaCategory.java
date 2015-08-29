package com.penglecode.gulubala.common.model;

import java.io.Serializable;
/**
 * 推荐分类模型
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
	
	/** 分类类型 #MediaCategoryTypeEnum */
	private Integer categoryType;
	
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

	public Integer getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(Integer categoryType) {
		this.categoryType = categoryType;
	}

}
