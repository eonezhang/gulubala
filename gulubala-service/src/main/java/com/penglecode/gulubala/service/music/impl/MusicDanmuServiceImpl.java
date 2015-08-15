package com.penglecode.gulubala.service.music.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.penglecode.gulubala.common.model.MusicDanmu;
import com.penglecode.gulubala.common.support.DanmuMessageTemplate;
import com.penglecode.gulubala.common.support.Pager;
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

	public DanmuMessageTemplate getNextMusicDanmuList4Andriod(Long musicId, Integer currentPage, Integer pageSize) {
		ValidationAssert.notNull(musicId, "请求参数不能为空!");
		ValidationAssert.isTrue(pageSize % 10 == 0, "分页参数pageSize必须是10的整数倍!");
		ValidationAssert.isTrue(pageSize <= 500, "分页参数pageSize至多不超过500!");
		Pager pager = new Pager(currentPage, pageSize);
		List<MusicDanmu> danmuList = musicDanmuDAO.getNextMusicDanmuList(musicId, pager);
		return MusicDanmuUtils.createDanmuMessage(danmuList, pager);
	}

}
