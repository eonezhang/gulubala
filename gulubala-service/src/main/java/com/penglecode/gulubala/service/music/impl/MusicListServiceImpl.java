package com.penglecode.gulubala.service.music.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.penglecode.gulubala.common.model.MusicList;
import com.penglecode.gulubala.common.support.Pager;
import com.penglecode.gulubala.common.support.PagingList;
import com.penglecode.gulubala.common.support.ValidationAssert;
import com.penglecode.gulubala.common.util.DateTimeUtils;
import com.penglecode.gulubala.common.util.StringUtils;
import com.penglecode.gulubala.dao.music.MusicDAO;
import com.penglecode.gulubala.dao.music.MusicListDAO;
import com.penglecode.gulubala.service.music.MusicListService;

@Service("musicListService")
public class MusicListServiceImpl implements MusicListService {

	@Resource(name="musicDAO")
	private MusicDAO musicDAO;
	
	@Resource(name="musicListDAO")
	private MusicListDAO musicListDAO;
	
	@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRED)
	public Long createMusicList(MusicList musicList) {
		ValidationAssert.notNull(musicList, "请求参数不能为空!");
		musicList.setCreateTime(DateTimeUtils.formatNow());
		musicList.setUpdateTime(DateTimeUtils.formatNow());
		musicListDAO.insertMusicList(musicList);
		return musicList.getListId();
	}

	public MusicList getMusicById(Long listId) {
		MusicList musicList = musicListDAO.getMusicListById(listId);
		if(musicList != null && !StringUtils.isEmpty(musicList.getMusicIds())){
			List<Long> idList = new ArrayList<Long>();
			String[] ids = musicList.getMusicIds().split(",");
			for(String id : ids){
				idList.add(Long.valueOf(id));
			}
			musicList.setMusicList(musicDAO.getMusicListByIds(idList));
		}
		return musicList;
	}

	public PagingList<MusicList> getMusicLists(Long userId,
			Integer currentPage, Integer pageSize, String orderby, String order) {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("userId", userId);
		paramMap.put("orderby", orderby);
		paramMap.put("order", order);
		Pager pager = new Pager(currentPage, pageSize);
		return new PagingList<MusicList>(musicListDAO.getMusicLists(paramMap, pager), pager);
	}

}
