package com.penglecode.gulubala.service.music.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.penglecode.gulubala.common.consts.em.MusicDanmuStatusEnum;
import com.penglecode.gulubala.common.model.MusicDanmu;
import com.penglecode.gulubala.common.support.ValidationAssert;
import com.penglecode.gulubala.common.util.DateTimeUtils;
import com.penglecode.gulubala.dao.music.MusicDanmuDAO;
import com.penglecode.gulubala.service.music.MusicDanmuService;

@Service("musicDanmuService")
public class MusicDanmuServiceImpl implements MusicDanmuService {

	@Resource(name="musicDanmuDAO")
	private MusicDanmuDAO musicDanmuDAO;
	
	@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRED)
	public Long createMusicDanmu(MusicDanmu danmu) {
		ValidationAssert.notNull(danmu, "请求参数不能为空!");
		danmu.setCreateTime(DateTimeUtils.formatNow());
		musicDanmuDAO.insertMusicDanmu(danmu);
		return danmu.getId();
	}

	@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRED)
	public MusicDanmu showNextMusicDanmu(Long musicId) {
		ValidationAssert.notNull(musicId, "请求参数不能为空!");
		MusicDanmu danmu = musicDanmuDAO.lockNextMusicDanmu4show(musicId);
		if(danmu != null){
			String nowTime = DateTimeUtils.formatNow();
			danmu.setStatus(MusicDanmuStatusEnum.DANMU_STATUS_YES.getStatusCode());
			danmu.setShowTime(nowTime);
			danmu.setUpdateTime(nowTime);
			musicDanmuDAO.updateMusicDanmuStatus(danmu);
		}
		return danmu;
	}

}
