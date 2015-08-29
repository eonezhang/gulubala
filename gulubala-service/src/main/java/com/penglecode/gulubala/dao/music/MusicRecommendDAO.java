package com.penglecode.gulubala.dao.music;

import java.util.List;
import java.util.Map;

import com.penglecode.gulubala.common.model.MusicRecommend;
import com.penglecode.gulubala.common.support.Pager;

/**
 * 音乐推荐DAO
 * 
 * @author  pengpeng
 * @date 	 2015年8月29日 下午2:12:57
 * @version 1.0
 */
public interface MusicRecommendDAO {

	/**
	 * 根据推荐分类查询推荐列表
	 * @param paramMap
	 * @param pager
	 * @return
	 */
	public List<MusicRecommend> getRecommendList(Map<String,Object> paramMap, Pager pager);
	
}
