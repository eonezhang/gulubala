package com.penglecode.gulubala.dao.singer;

import com.penglecode.gulubala.common.model.Singer;

/**
 * 歌手DAO
 * 
 * @author  pengpeng
 * @date 	 2015年8月10日 上午11:00:15
 * @version 1.0
 */
public interface SingerDAO {

	/**
	 * 新增歌手
	 * @param singer
	 */
	public void insertSinger(Singer singer);
	
	/**
	 * 根据id查询歌手详情
	 * @param singerId
	 * @return
	 */
	public Singer getSingerById(Long singerId);
	
}
