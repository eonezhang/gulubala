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
	 * 自增歌单的评论数
	 * @param listId
	 */
	public void incrMusicListComments(Long listId);
	
	/**
	 * 自增歌单的播放次数
	 * @param listId
	 */
	public void incrMusicListPlays(Long listId);
	
	/**
	 * 自增歌单的点赞次数
	 * @param listId
	 */
	public void incrMusicListPraises(Long listId);
	
	/**
	 * 自增歌单的收藏次数
	 * @param listId
	 */
	public void incrMusicListCollects(Long listId);
	
	/**
	 * 更新歌单中的音乐列表
	 * @param listId
	 * @param musicIds
	 */
	public void updateMusicIds(Long listId, String musicIds);
	
	/**
	 * 删除歌单
	 * @param listId
	 */
	public void deleteMusicListById(Long listId);
	
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
