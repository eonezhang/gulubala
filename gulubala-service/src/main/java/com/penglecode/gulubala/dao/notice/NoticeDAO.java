package com.penglecode.gulubala.dao.notice;

import java.util.List;
import java.util.Map;

import com.penglecode.gulubala.common.model.Notice;
import com.penglecode.gulubala.common.support.Pager;

/**
 * 公告DAO
 * 
 * @author  pengpeng
 * @date 	 2015年9月8日 上午11:09:04
 * @version 1.0
 */
public interface NoticeDAO {

	/**
	 * 根据id查询公告详情
	 * @param id
	 * @return
	 */
	public Notice getNoticeById(Long id);
	
	/**
	 * 根据公告状态、公告标题等条件查询公告列表
	 * @param parameter
	 * @param pager
	 * @return
	 */
	public List<Notice> getNoticeList(Map<String,Object> parameter, Pager pager);
	
	/**
	 * 自增公告已阅数
	 * @param id
	 */
	public void incrNoticeReadCount(Long id);
	
}
