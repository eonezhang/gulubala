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
	 * 根据id查询音乐详情
	 * @param musicId
	 * @return
	 */
	public Music getMusicById(Long musicId);
	
	/**
	 * 根据分类ID获取音乐列表(首页接口)[分页、排序]
	 * @param categoryId
	 * @param pager
	 * @return
	 */
	public List<Music> getMusicList4index(Map<String,Object> paramMap, Pager pager);
	
}
