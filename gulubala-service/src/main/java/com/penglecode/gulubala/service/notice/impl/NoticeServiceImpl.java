package com.penglecode.gulubala.service.notice.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.penglecode.gulubala.common.consts.em.NoticeCheckStatus;
import com.penglecode.gulubala.common.model.Notice;
import com.penglecode.gulubala.common.support.Pager;
import com.penglecode.gulubala.common.support.PagingList;
import com.penglecode.gulubala.dao.notice.NoticeDAO;
import com.penglecode.gulubala.service.notice.NoticeService;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {

	@Resource(name="noticeDAO")
	private NoticeDAO noticeDAO;
	
	public Notice getNoticeById(Long id) {
		return noticeDAO.getNoticeById(id);
	}

	public PagingList<Notice> getNoticeList(String title, Integer currentPage, Integer pageSize) {
		Pager pager = new Pager(currentPage, pageSize);
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("title", title);
		paramMap.put("status", NoticeCheckStatus.CHECK_STATUS_APPROVED.getStatusCode());
		return new PagingList<Notice>(noticeDAO.getNoticeList(paramMap, pager), pager);
	}

	public void incrNoticeReadCount(Long id) {
		noticeDAO.incrNoticeReadCount(id);
	}

}
