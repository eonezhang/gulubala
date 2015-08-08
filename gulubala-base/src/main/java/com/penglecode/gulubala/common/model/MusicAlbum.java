package com.penglecode.gulubala.common.model;

import java.io.Serializable;
/**
 * 音乐歌单模型
 * 
 * @author  pengpeng
 * @date 	 2015年8月7日 下午12:56:45
 * @version 1.0
 */
public class MusicAlbum implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 歌单ID */
	private Long albumId;
	
	/** 歌单名称 */
	private String albumName;
	
	/** 歌单封面图片地址 */
	private String albumPictureUrl;
	
	/** 歌单播放次数 */
	private Integer playTimes;
	
	/** 创建人ID */
	private Long createBy;
	
	/** 创建时间 */
	private String createTime;
	
	/** 是否分享 */
	private boolean shared;
	
	/** 歌单简介 */
	private String remark;

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

	public Integer getPlayTimes() {
		return playTimes;
	}

	public void setPlayTimes(Integer playTimes) {
		this.playTimes = playTimes;
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

	public boolean isShared() {
		return shared;
	}

	public void setShared(boolean shared) {
		this.shared = shared;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
