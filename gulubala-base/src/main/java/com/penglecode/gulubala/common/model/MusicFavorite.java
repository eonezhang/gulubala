package com.penglecode.gulubala.common.model;

import java.io.Serializable;
/**
 * 音乐收藏
 * 
 * @author  pengpeng
 * @date 	 2015年8月14日 上午11:09:57
 * @version 1.0
 */
public class MusicFavorite implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 收藏ID */
	private Long id;
	
	/** 用户ID */
	private Long userId;
	
	/** 收藏数据 */
	private String data;
	
	/** 收藏对象的类型 {@link #MusicFavoriteTypeEnum} */
	private Integer favoriteType;
	
	/** 收藏对象的ID */
	private Long favoriteId;
	
	private String createTime;
	
	//以下属于辅助字段
	
	/** 收藏对象的名称 */
	private String favoriteName;
	
	/** 用户昵称 */
	private String nickName;

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

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Integer getFavoriteType() {
		return favoriteType;
	}

	public void setFavoriteType(Integer favoriteType) {
		this.favoriteType = favoriteType;
	}

	public Long getFavoriteId() {
		return favoriteId;
	}

	public void setFavoriteId(Long favoriteId) {
		this.favoriteId = favoriteId;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getFavoriteName() {
		return favoriteName;
	}

	public void setFavoriteName(String favoriteName) {
		this.favoriteName = favoriteName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
}
