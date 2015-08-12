package com.penglecode.gulubala.dao.music;

import java.util.List;
import java.util.Map;

import com.penglecode.gulubala.common.model.MusicList;
import com.penglecode.gulubala.common.support.Pager;

/**
 * 歌单DAO
 * 
 * @author  pengpeng
 * @date 	 2015年8月12日 上午10:09:37
 * @version 1.0
 */
public interface MusicListDAO {

	/**
	 * 新增歌单
	 * @param musicList
	 */
	public void insertMusicList(MusicList musicList);
	
	/**
	 * 根据歌单Id获取歌单详情
	 * @param listId
	 * @return
	 */
	public MusicList getMusicListById(Long listId);
	
	/**
	 * 根据条件查询歌单列表
	 * @param paramMap
	 * @return
	 */
	public List<MusicList> getMusicLists(Map<String,Object> paramMap, Pager pager);
	
}
