package com.penglecode.gulubala.common.model;

import java.io.Serializable;
import java.util.List;
/**
 * 音乐播放历史
 * 
 * @author  pengpeng
 * @date 	 2015年8月18日 上午11:20:07
 * @version 1.0
 */
public class MusicPlayHistory implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 播放历史ID */
	private Long id;
	
	/** 用户ID */
	private Long userId;
	
	/** 音乐Ids(逗号隔开) */
	private String musicIds;
	
	private String createTime;
	
	private String updateTime;
	
	//以下属于辅助字段
	
	private List<Music> musicList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getMusicIds() {
		return musicIds;
	}

	public void setMusicIds(String musicIds) {
		this.musicIds = musicIds;
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

	public List<Music> getMusicList() {
		return musicList;
	}

	public void setMusicList(List<Music> musicList) {
		this.musicList = musicList;
	}
	
}
