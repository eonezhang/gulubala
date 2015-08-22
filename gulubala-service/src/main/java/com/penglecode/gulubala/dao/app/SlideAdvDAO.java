package com.penglecode.gulubala.dao.app;

import java.util.List;

import com.penglecode.gulubala.common.model.SlideAdv;

/**
 * 轮播广告DAO
 * 
 * @author  pengpeng
 * @date 	 2015年8月21日 下午5:16:10
 * @version 1.0
 */
public interface SlideAdvDAO {

	/**
	 * 新增轮播图
	 * @param adv
	 */
	public void insertAdv(SlideAdv adv);
	
	/**
	 * 获取广告列表
	 * @param status	- 如果为空则获取全部
	 * @return
	 */
	public List<SlideAdv> getSlideAdvList(Integer status);
	
}
