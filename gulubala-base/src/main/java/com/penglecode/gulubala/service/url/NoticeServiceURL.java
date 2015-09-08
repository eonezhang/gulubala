package com.penglecode.gulubala.service.url;
/**
 * 公告服务URL
 * 
 * @author  pengpeng
 * @date 	 2015年9月8日 上午11:16:13
 * @version 1.0
 */
public interface NoticeServiceURL {

	/** 查询公告详情 */
	String URL_NOTICE_DETAIL = "notice/detail/{id}";
	
	/** 查询公告列表 */
	String URL_NOTICE_LIST = "notice/list";
	
	/** 自增公告已阅数 */
	String URL_NOTICE_READ_COUNT_INCR = "notice/readcount/incr/{id}";
	
}
