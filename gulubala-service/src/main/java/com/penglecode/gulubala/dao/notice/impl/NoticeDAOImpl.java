package com.penglecode.gulubala.dao.notice.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.penglecode.gulubala.common.model.Notice;
import com.penglecode.gulubala.common.support.Pager;
import com.penglecode.gulubala.dao.BaseMybatisDAO;
import com.penglecode.gulubala.dao.notice.NoticeDAO;

@Repository("noticeDAO")
public class NoticeDAOImpl extends BaseMybatisDAO implements NoticeDAO {

	public Notice getNoticeById(Long id) {
		return getSqlSessionTemplate().selectOne(getMapperKey("getNoticeById"), id);
	}

	public List<Notice> getNoticeList(Map<String, Object> parameter, Pager pager) {
		return getSqlSessionTemplate().selectList(getMapperKey("getNoticeList"), parameter, pager);
	}

	public void incrNoticeReadCount(Long id) {
		getSqlSessionTemplate().update(getMapperKey("incrNoticeReadCount"), id);
	}

	protected Class<?> getBoundModelClass() {
		return Notice.class;
	}

}
