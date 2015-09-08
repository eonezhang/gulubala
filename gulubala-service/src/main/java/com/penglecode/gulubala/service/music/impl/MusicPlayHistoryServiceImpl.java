package com.penglecode.gulubala.service.music.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.penglecode.gulubala.common.support.Pager;
import com.penglecode.gulubala.common.support.PagingList;
import com.penglecode.gulubala.common.support.ValidationAssert;
import com.penglecode.gulubala.dao.music.MusicDAO;
import com.penglecode.gulubala.dao.music.MusicPlayHistoryDAO;
import com.penglecode.gulubala.service.music.MusicPlayHistoryService;

@Service("musicPlayHistoryService")
public class MusicPlayHistoryServiceImpl implements MusicPlayHistoryService {

	@Resource(name = "musicPlayHistoryDAO")
	private MusicPlayHistoryDAO musicPlayHistoryDAO;

	@Resource(name = "musicDAO")
	private MusicDAO musicDAO;

	@Transactional(rollbackFor = { Exception.class }, propagation = Propagation.REQUIRED)
	public void deleteMusicPlayHistoryByUserId(Long userId) {
		ValidationAssert.notNull(userId, "用户ID不能为空!");
		this.musicPlayHistoryDAO.deleteMusicPlayHistoryByUserId(userId);
	}

	public PagingList<Map<String, Object>> getMusicPlayHistoryByUserId(Long userId, Integer currentPage, Integer pageSize) {
		ValidationAssert.notNull(userId, "用户ID不能为空!");
		Pager pager = new Pager(currentPage, pageSize);
		return new PagingList<Map<String, Object>>(this.musicPlayHistoryDAO.getMusicPlayHistoryByUserId(userId, pager), pager);
	}

}
