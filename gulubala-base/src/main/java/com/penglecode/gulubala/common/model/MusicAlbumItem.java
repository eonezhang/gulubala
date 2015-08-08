package com.penglecode.gulubala.common.model;

import java.io.Serializable;
/**
 * 音乐歌单内容表
 * 
 * @author  pengpeng
 * @date 	 2015年8月7日 下午1:06:04
 * @version 1.0
 */
public class MusicAlbumItem implements Serializable {

	private static final long serialVersionUID = 1L;

	/** ID */
	private Long itemId;
	
	/** 音乐ID */
	private Long musicId;
	
	/** 所属歌单ID */
	private Long albumId;

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public Long getMusicId() {
		return musicId;
	}

	public void setMusicId(Long musicId) {
		this.musicId = musicId;
	}

	public Long getAlbumId() {
		return albumId;
	}

	public void setAlbumId(Long albumId) {
		this.albumId = albumId;
	}
	
}
