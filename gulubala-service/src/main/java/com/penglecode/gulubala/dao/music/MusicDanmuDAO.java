package com.penglecode.gulubala.dao.music;

import com.penglecode.gulubala.common.model.MusicDanmu;

/**
 * 音乐弹幕DAO
 * 
 * @author  pengpeng
 * @date 	 2015年8月13日 下午8:45:18
 * @version 1.0
 */
public interface MusicDanmuDAO {

	/**
	 * 新增弹幕
	 * @param danmu
	 */
	public void insertMusicDanmu(MusicDanmu danmu);
	
	/**
	 * 更新弹幕状态
	 * @param danmu
	 */
	public void updateMusicDanmuStatus(MusicDanmu danmu);
	
	/**
	 * 获取先一个待弹出的弹幕
	 * @return
	 */
	public MusicDanmu lockNextMusicDanmu4show(Long musicId);
	
}
