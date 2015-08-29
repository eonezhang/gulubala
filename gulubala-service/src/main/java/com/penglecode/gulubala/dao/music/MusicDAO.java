package com.penglecode.gulubala.dao.music;

import java.util.List;
import java.util.Map;

import com.penglecode.gulubala.common.model.Music;
import com.penglecode.gulubala.common.support.Pager;

/**
 * 音乐DAO
 * 
 * @author  pengpeng
 * @date 	 2015年8月10日 上午11:00:15
 * @version 1.0
 */
public interface MusicDAO {

	/**
	 * 新增音乐
	 * @param music
	 */
	public void insertMusic(Music music);
	
	/**
	 * 自增音乐的人气数
	 * @param musicId
	 */
	public void incrMusicHots(Long musicId);
	
	/**
	 * 自增音乐的播放次数
	 * @param musicId
	 */
	public void incrMusicPlays(Long musicId);
	
	/**
	 * 自增音乐的点赞次数
	 * @param musicId
	 */
	public void incrMusicPraises(Long musicId);
	
	/**
	 * 自增音乐的收藏次数
	 * @param musicId
	 */
	public void incrMusicCollects(Long musicId);
	
	/**
	 * 获取轻量级的Music对象
	 * @param musicId
	 * @return
	 */
	public Music getThinMusicById(Long musicId);
	
	/**
	 * 根据id查询音乐详情
	 * @param musicId
	 * @return
	 */
	public Music getMusicById(Long musicId);
	
	/**
	 * 根据多个音乐Id查询音乐列表
	 * @param musicIdList
	 * @param orderedAsIdList	- 和musicIdList一样的顺序?
	 * @return
	 */
	public List<Music> getMusicListByIds(List<Long> musicIdList, boolean orderedAsIdList);
	
	/**
	 * 根据音乐名字关键字模糊搜索(首页接口)[分页、排序]
	 * @param paramMap
	 * @param pager
	 * @return
	 */
	public List<Music> getMusicList4search(Map<String,Object> paramMap, Pager pager);
	
	/**
	 * 根据获取音乐列表(首页接口)[分页、排序]
	 * @param categoryId
	 * @param pager
	 * @return
	 */
	public List<Music> getMusicListByMediaType(Map<String,Object> paramMap, Pager pager);
	
}
