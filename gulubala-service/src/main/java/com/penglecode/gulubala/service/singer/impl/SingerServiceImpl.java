package com.penglecode.gulubala.service.singer.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.penglecode.gulubala.common.model.Singer;
import com.penglecode.gulubala.common.support.ValidationAssert;
import com.penglecode.gulubala.common.util.DateTimeUtils;
import com.penglecode.gulubala.dao.singer.SingerDAO;
import com.penglecode.gulubala.service.singer.SingerService;

@Service("singerService")
public class SingerServiceImpl implements SingerService {

	@Resource(name="singerDAO")
	private SingerDAO singerDAO;
	
	@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRED)
	public Long createSinger(Singer singer) {
		ValidationAssert.notNull(singer, "请求参数不能为空!");
		singer.setCreateTime(DateTimeUtils.formatNow());
		singerDAO.insertSinger(singer);
		return singer.getSingerId();
	}

	public Singer getSingerById(Long singerId) {
		return singerDAO.getSingerById(singerId);
	}

}
