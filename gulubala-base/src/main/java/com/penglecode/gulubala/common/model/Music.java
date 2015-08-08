package com.penglecode.gulubala.common.model;

import java.io.Serializable;
/**
 * 音乐模型
 * 
 * @author  pengpeng
 * @date 	 2015年8月7日 上午11:01:08
 * @version 1.0
 */
public class Music implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 音乐ID */
	private Long musicId;
	
	/** 音乐名称 */
	private String musicName;
	
	/** 音乐分类 */
	private Integer musicCategory;
	
	/** 歌词链接地址 */
	private String lrcUrl;
	
	/** 播放次数 */
	private Integer playTimes; 
	
	/** 音乐封面小图URL */
	private String smallPictureUrl;
	
	/** 音乐封面大图URL */
	private String pictureUrl;
	
	/** 音乐文件地址 */
	private String musicUrl;
	
	/** 创建者ID */
	private Long createBy; 
	
	/** 创建时间 */
	private String createTime;

	public Long getMusicId() {
		return musicId;
	}

	public void setMusicId(Long musicId) {
		this.musicId = musicId;
	}

	public String getMusicName() {
		return musicName;
	}

	public void setMusicName(String musicName) {
		this.musicName = musicName;
	}

	public Integer getMusicCategory() {
		return musicCategory;
	}

	public void setMusicCategory(Integer musicCategory) {
		this.musicCategory = musicCategory;
	}

	public String getLrcUrl() {
		return lrcUrl;
	}

	public void setLrcUrl(String lrcUrl) {
		this.lrcUrl = lrcUrl;
	}

	public Integer getPlayTimes() {
		return playTimes;
	}

	public void setPlayTimes(Integer playTimes) {
		this.playTimes = playTimes;
	}

	public String getSmallPictureUrl() {
		return smallPictureUrl;
	}

	public void setSmallPictureUrl(String smallPictureUrl) {
		this.smallPictureUrl = smallPictureUrl;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	public String getMusicUrl() {
		return musicUrl;
	}

	public void setMusicUrl(String musicUrl) {
		this.musicUrl = musicUrl;
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
