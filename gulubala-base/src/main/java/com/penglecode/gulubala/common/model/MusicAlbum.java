package com.penglecode.gulubala.common.model;

import java.io.Serializable;
/**
 * 音乐专辑模型
 * 
 * @author  pengpeng
 * @date 	 2015年8月7日 下午12:56:45
 * @version 1.0
 */
public class MusicAlbum implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 专辑ID */
	private Long albumId;
	
	/** 专辑名称 */
	private String albumName;
	
	/** 专辑封面图片地址 */
	private String albumPictureUrl;
	
	/** 专辑播放次数 */
	private Integer plays;
	
	/** 发行单位 */
	private String publisher;
	
	/** 所属歌手ID */
	private Long singerId;
	
	/** 专辑简介 */
	private String remark;
	
	/** 创建时间 */
	private String createTime;
	
	/** 更新时间 */
	private String updateTime;

	//以下属于辅助字段
	
	private String fullAlbumPictureUrl;
	
	public Long getAlbumId() {
		return albumId;
	}

	public void setAlbumId(Long albumId) {
		this.albumId = albumId;
	}

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public String getAlbumPictureUrl() {
		return albumPictureUrl;
	}

	public void setAlbumPictureUrl(String albumPictureUrl) {
		this.albumPictureUrl = albumPictureUrl;
	}

	public Integer getPlays() {
		return plays;
	}

	public void setPlays(Integer plays) {
		this.plays = plays;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Long getSingerId() {
		return singerId;
	}

	public void setSingerId(Long singerId) {
		this.singerId = singerId;
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

	public String getFullAlbumPictureUrl() {
		return fullAlbumPictureUrl;
	}

	public void setFullAlbumPictureUrl(String fullAlbumPictureUrl) {
		this.fullAlbumPictureUrl = fullAlbumPictureUrl;
	}
	
}
