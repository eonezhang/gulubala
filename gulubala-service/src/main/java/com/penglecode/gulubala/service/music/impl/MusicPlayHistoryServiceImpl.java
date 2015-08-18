package com.penglecode.gulubala.service.music.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.penglecode.gulubala.common.model.Music;
import com.penglecode.gulubala.common.model.MusicPlayHistory;
import com.penglecode.gulubala.common.support.Pager;
import com.penglecode.gulubala.common.support.PagingList;
import com.penglecode.gulubala.common.support.ValidationAssert;
import com.penglecode.gulubala.common.util.PaginationUtils;
import com.penglecode.gulubala.common.util.StringUtils;
import com.penglecode.gulubala.dao.music.MusicDAO;
import com.penglecode.gulubala.dao.music.MusicPlayHistoryDAO;
import com.penglecode.gulubala.service.music.MusicPlayHistoryService;

@Service("musicPlayHistoryService")
public class MusicPlayHistoryServiceImpl implements MusicPlayHistoryService {

	@Resource(name="musicPlayHistoryDAO")
	private MusicPlayHistoryDAO musicPlayHistoryDAO;
	
	@Resource(name="musicDAO")
	private MusicDAO musicDAO;
	
	@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRED)
	public void deleteMusicPlayHistoryByUserId(Long userId) {
		ValidationAssert.notNull(userId, "用户ID不能为空!");
		musicPlayHistoryDAO.deleteMusicPlayHistoryByUserId(userId);
	}

	public PagingList<Music> getMusicPlayHistoryByUserId(Long userId, Integer currentPage, Integer pageSize) {
		ValidationAssert.notNull(userId, "用户ID不能为空!");
		Pager pager = new Pager(currentPage, pageSize);
		List<Music> allHistoryList = new ArrayList<Music>();
		MusicPlayHistory history = musicPlayHistoryDAO.getMusicPlayHistoryByUserId(userId);
		if(history != null && !StringUtils.isEmpty(history.getMusicIds())){
			List<Long> musicIdList = new ArrayList<Long>();
			String[] musicIds = history.getMusicIds().split(",");
			for(String id : musicIds){
				musicIdList.add(Long.valueOf(id));
			}
			allHistoryList.addAll(musicDAO.getMusicListByIds(musicIdList, true));
		}
		return PaginationUtils.getPagingList(allHistoryList, pager);
	}

}
