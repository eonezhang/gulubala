package com.penglecode.gulubala.common.model;

import java.io.Serializable;
import java.util.List;
/**
 * 歌单模型
 * 
 * @author  pengpeng
 * @date 	 2015年8月12日 上午9:20:15
 * @version 1.0
 */
public class MusicList implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 歌单Id */
	private Long listId;
	
	/** 歌单名称 */
	private String listName;
	
	/** 用户Id */
	private Long userId;
	
	/** 音乐Ids(逗号隔开) */
	private String musicIds;
	
	/** 歌单描述 */
	private String remark;
	
	private String createTime;
	
	private String updateTime;
	
	//以下属于辅助字段
	
	private int musicCount;
	
	private List<Music> musicList;

	public Long getListId() {
		return listId;
	}

	public void setListId(Long listId) {
		this.listId = listId;
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
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

	public int getMusicCount() {
		return musicCount;
	}

	public void setMusicCount(int musicCount) {
		this.musicCount = musicCount;
	}

	public List<Music> getMusicList() {
		return musicList;
	}

	public void setMusicList(List<Music> musicList) {
		this.musicList = musicList;
	}

}
