package com.penglecode.gulubala.service.notice;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.penglecode.gulubala.common.consts.ContentType;
import com.penglecode.gulubala.common.model.Notice;
import com.penglecode.gulubala.common.support.PagingList;
import com.penglecode.gulubala.service.url.NoticeServiceURL;

/**
 * 公告服务
 * 
 * @author  pengpeng
 * @date 	 2015年9月8日 上午11:15:41
 * @version 1.0
 */
@Path("")
public interface NoticeService {

	/**
	 * 查询公告详情
	 * @param id
	 * @return
	 */
	@GET
	@Path(NoticeServiceURL.URL_NOTICE_DETAIL)
	@Produces({ContentType.APPLICATION_JSON_UTF_8})
	public Notice getNoticeById(@PathParam("id") Long id);
	
	/**
	 * 查询公告列表
	 * @param title
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	@GET
	@Path(NoticeServiceURL.URL_NOTICE_LIST)
	@Produces({ContentType.APPLICATION_JSON_UTF_8})
	public PagingList<Notice> getNoticeList(
			@QueryParam("title") String title,
			@DefaultValue("1")@QueryParam("currentPage") Integer currentPage,
			@DefaultValue("10")@QueryParam("pageSize") Integer pageSize);
	
	/**
	 * 自增公告已阅数
	 * @param id
	 */
	@GET
	@Path(NoticeServiceURL.URL_NOTICE_READ_COUNT_INCR)
	@Produces({ContentType.APPLICATION_JSON_UTF_8})
	public void incrNoticeReadCount(@PathParam("id") Long id);
	
}
