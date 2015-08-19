package com.penglecode.gulubala.service.music.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.penglecode.gulubala.common.model.Music;
import com.penglecode.gulubala.common.model.MusicPlayHistory;
import com.penglecode.gulubala.common.support.Pager;
import com.penglecode.gulubala.common.support.PagingList;
import com.penglecode.gulubala.common.support.ValidationAssert;
import com.penglecode.gulubala.common.util.CollectionUtils;
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

	public List<Music> getMusicPlayHistoryByUserId(Long userId) {
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
		return allHistoryList;
	}

	public PagingList<Map<String,Object>> getMusicPlayHistoryByUserId(Long userId, Integer currentPage, Integer pageSize) {
		ValidationAssert.notNull(userId, "用户ID不能为空!");
		Pager pager = new Pager(currentPage, pageSize);
		List<Music> allHistoryList = getMusicPlayHistoryByUserId(userId);
		List<Music> pagingList = PaginationUtils.getPagedList(allHistoryList, pager);
		List<Map<String,Object>> mapList = null;
		if(!CollectionUtils.isEmpty(pagingList)){
			mapList = new ArrayList<Map<String,Object>>();
			for(Music music : pagingList){
				Map<String,Object> map = new HashMap<String,Object>();
				map.put("musicId", music.getMusicId());
				map.put("musicName", music.getMusicName());
				map.put("zuoqu", music.getZuoqu());
				map.put("zuoci", music.getZuoci());
				map.put("bianqu", music.getBianqu());
				map.put("singerId", music.getSingerId());
				map.put("fullSmallPictureUrl", music.getFullSmallPictureUrl());
				map.put("mv", music.isMv());
				mapList.add(map);
			}
		}
		return new PagingList<Map<String,Object>>(mapList, pager);
	}
	
}
