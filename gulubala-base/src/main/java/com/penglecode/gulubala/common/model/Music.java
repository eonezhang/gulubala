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
	
	/** 作曲 */
	private String zuoqu;
	
	/** 作词 */
	private String zuoci;
	
	/** 编曲 */
	private String bianqu;
	
	/** 歌手ID */
	private Long singerId;
	
	/** 专辑ID */
	private Long albumId;
	
	/** 是否原唱 */
	private boolean originalSong;
	
	/** 是否翻唱 */
	private boolean overrideSong;
	
	/** 是否是MV */
	private boolean mv;
	
	/** 发行单位 */
	private String publisher;
	
	/** 发行时间 */
	private String publishTime;
	
	/** 人气数 */
	private Integer hots;
	
	/** 播放次数 */
	private Integer plays; 
	
	/** 点赞数 */
	private Integer praises;
	
	/** 收藏数 */
	private Integer collects;
	
	/** 今日人气数 */
	private Integer dayHots;
	
	/** 3日人气数 */
	private Integer threeDayHots;
	
	/** 一周人气数 */
	private Integer weekHots;
	
	/** 人气趋势（0：下降；1：上升） */
	private Integer hotTrend;
	
	/** GU主id */
	private Long userId;
	
	/** 歌曲时长 */
	private String musicTime;
	
	/** 是否是官方推荐 */
	private boolean recommend;
	
	/** 音乐分类 */
	private Integer categoryId;
	
	/** 歌词链接地址 */
	private String lrcUrl;
	
	/** 音乐封面小图URL */
	private String smallPictureUrl;
	
	/** 音乐封面大图URL */
	private String pictureUrl;
	
	/** 音乐文件地址 */
	private String musicUrl;
	
	/** 歌曲描述 */
	private String description;
	
	/** 创建时间 */
	private String createTime;
	
	/** 更新时间 */
	private String updateTime;

	//以下属于辅助字段
	
	private String fullLrcUrl;
	
	private String fullMusicUrl;
	
	private String fullSmallPictureUrl;
	
	private String fullPictureUrl;
	
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

	public String getZuoqu() {
		return zuoqu;
	}

	public void setZuoqu(String zuoqu) {
		this.zuoqu = zuoqu;
	}

	public String getZuoci() {
		return zuoci;
	}

	public void setZuoci(String zuoci) {
		this.zuoci = zuoci;
	}

	public String getBianqu() {
		return bianqu;
	}

	public void setBianqu(String bianqu) {
		this.bianqu = bianqu;
	}

	public Long getSingerId() {
		return singerId;
	}

	public void setSingerId(Long singerId) {
		this.singerId = singerId;
	}

	public Long getAlbumId() {
		return albumId;
	}

	public void setAlbumId(Long albumId) {
		this.albumId = albumId;
	}

	public boolean isOriginalSong() {
		return originalSong;
	}

	public void setOriginalSong(boolean originalSong) {
		this.originalSong = originalSong;
	}

	public boolean isOverrideSong() {
		return overrideSong;
	}

	public void setOverrideSong(boolean overrideSong) {
		this.overrideSong = overrideSong;
	}

	public boolean isMv() {
		return mv;
	}

	public void setMv(boolean mv) {
		this.mv = mv;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}

	public Integer getHots() {
		return hots;
	}

	public void setHots(Integer hots) {
		this.hots = hots;
	}

	public Integer getPlays() {
		return plays;
	}

	public void setPlays(Integer plays) {
		this.plays = plays;
	}

	public Integer getPraises() {
		return praises;
	}

	public void setPraises(Integer praises) {
		this.praises = praises;
	}

	public Integer getCollects() {
		return collects;
	}

	public void setCollects(Integer collects) {
		this.collects = collects;
	}
	
	public Integer getDayHots() {
		return dayHots;
	}

	public void setDayHots(Integer dayHots) {
		this.dayHots = dayHots;
	}

	public Integer getThreeDayHots() {
		return threeDayHots;
	}

	public void setThreeDayHots(Integer threeDayHots) {
		this.threeDayHots = threeDayHots;
	}

	public Integer getWeekHots() {
		return weekHots;
	}

	public void setWeekHots(Integer weekHots) {
		this.weekHots = weekHots;
	}

	public Integer getHotTrend() {
		return hotTrend;
	}

	public void setHotTrend(Integer hotTrend) {
		this.hotTrend = hotTrend;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getMusicTime() {
		return musicTime;
	}

	public void setMusicTime(String musicTime) {
		this.musicTime = musicTime;
	}

	public boolean isRecommend() {
		return recommend;
	}

	public void setRecommend(boolean recommend) {
		this.recommend = recommend;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getLrcUrl() {
		return lrcUrl;
	}

	public void setLrcUrl(String lrcUrl) {
		this.lrcUrl = lrcUrl;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getFullLrcUrl() {
		return fullLrcUrl;
	}

	public void setFullLrcUrl(String fullLrcUrl) {
		this.fullLrcUrl = fullLrcUrl;
	}

	public String getFullMusicUrl() {
		return fullMusicUrl;
	}

	public void setFullMusicUrl(String fullMusicUrl) {
		this.fullMusicUrl = fullMusicUrl;
	}

	public String getFullSmallPictureUrl() {
		return fullSmallPictureUrl;
	}

	public void setFullSmallPictureUrl(String fullSmallPictureUrl) {
		this.fullSmallPictureUrl = fullSmallPictureUrl;
	}

	public String getFullPictureUrl() {
		return fullPictureUrl;
	}

	public void setFullPictureUrl(String fullPictureUrl) {
		this.fullPictureUrl = fullPictureUrl;
	}

}
