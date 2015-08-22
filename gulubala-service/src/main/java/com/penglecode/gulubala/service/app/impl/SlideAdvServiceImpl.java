package com.penglecode.gulubala.service.app.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.penglecode.gulubala.common.consts.em.OnlineOfflineStatusEnum;
import com.penglecode.gulubala.common.model.SlideAdv;
import com.penglecode.gulubala.common.support.ValidationAssert;
import com.penglecode.gulubala.common.util.DateTimeUtils;
import com.penglecode.gulubala.dao.app.SlideAdvDAO;
import com.penglecode.gulubala.service.app.SlideAdvService;

@Service("slideAdvService")
public class SlideAdvServiceImpl implements SlideAdvService {

	@Resource(name="slideAdvDAO")
	private SlideAdvDAO slideAdvDAO;
	
	@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRED)
	public Long createAdv(SlideAdv adv) {
		ValidationAssert.notNull(adv, "请求参数不能为空!");
		adv.setCreateTime(DateTimeUtils.formatNow());
		adv.setStatus(OnlineOfflineStatusEnum.STATUS_ONLINE.getStatusCode());
		slideAdvDAO.insertAdv(adv);
		return adv.getId();
	}

	public List<SlideAdv> getSlideAdvList(Integer status) {
		return slideAdvDAO.getSlideAdvList(status);
	}

}
