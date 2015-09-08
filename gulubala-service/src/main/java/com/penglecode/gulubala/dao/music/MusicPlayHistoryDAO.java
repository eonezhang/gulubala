package com.penglecode.gulubala.dao.music;

import java.util.List;
import java.util.Map;

import com.penglecode.gulubala.common.model.MusicPlayHistory;
import com.penglecode.gulubala.common.support.Pager;

/**
 * 用户音乐播放记录DAO
 * 
 * @author  pengpeng
 * @date 	 2015年8月18日 下午1:48:06
 * @version 1.0
 */
public interface MusicPlayHistoryDAO {

	/**
	 * 新增播放记录
	 * @param history
	 */
	public void insertMusicPlayHistory(MusicPlayHistory history);
	
	/**
	 * 清空用户的播放历史
	 * @param userId
	 */
	public void deleteMusicPlayHistoryByUserId(Long userId);
	
	/**
	 * 获取用户的播放历史(分页)
	 * @param userId
	 * @param pager
	 * @return
	 */
	public List<Map<String,Object>> getMusicPlayHistoryByUserId(Long userId, Pager pager);
	
}
