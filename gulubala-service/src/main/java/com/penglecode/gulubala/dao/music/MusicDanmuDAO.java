package com.penglecode.gulubala.dao.music;

import java.util.List;

import com.penglecode.gulubala.common.model.MusicDanmu;
import com.penglecode.gulubala.common.support.Pager;

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
	 * 获取下一批弹幕数据给客户端
	 * @param musicId
	 * @param pager
	 * @return
	 */
	public List<MusicDanmu> getNextMusicDanmuList(Long musicId, Pager pager);
	
}
