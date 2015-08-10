package com.penglecode.gulubala.dao.music;

import com.penglecode.gulubala.common.model.MusicAlbum;

/**
 * 音乐专辑DAO
 * 
 * @author  pengpeng
 * @date 	 2015年8月10日 上午11:00:15
 * @version 1.0
 */
public interface MusicAlbumDAO {

	/**
	 * 新增音乐专辑
	 * @param album
	 */
	public void insertMusicAlbum(MusicAlbum album);
	
	/**
	 * 根据id查询音乐专辑详情
	 * @param albumId
	 * @return
	 */
	public MusicAlbum getMusicAlbumById(Long albumId);
	
}
