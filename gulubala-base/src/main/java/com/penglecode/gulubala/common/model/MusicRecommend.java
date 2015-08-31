package com.penglecode.gulubala.common.model;

import java.io.Serializable;
/**
 * 音乐推荐表
 * 
 * @author  pengpeng
 * @date 	 2015年8月29日 下午1:50:36
 * @version 1.0
 */
public class MusicRecommend implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 推荐ID */
	private Long id;
	
	/** 所属推荐分类 */
	private Integer categoryId;
	
	/** 标题 */
	private String title;
	
	/** 排序 */
	private Integer orderNum;
	
	/** 媒体资源URL */
	private String url;
	
	/** 图片URL */
	private String imgUrl;
	
	/** 媒体类型#MediaTypeEnum */
	private Integer mediaType;
	
	/** 关联的歌曲ID */
	private Long songId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Integer getMediaType() {
		return mediaType;
	}

	public void setMediaType(Integer mediaType) {
		this.mediaType = mediaType;
	}

	public Long getSongId() {
		return songId;
	}

	public void setSongId(Long songId) {
		this.songId = songId;
	}
	
}
