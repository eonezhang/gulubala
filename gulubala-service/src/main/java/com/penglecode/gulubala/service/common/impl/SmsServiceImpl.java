package com.penglecode.gulubala.service.common.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.penglecode.gulubala.common.cache.SmsCodeCacheManager;
import com.penglecode.gulubala.common.support.Messages;
import com.penglecode.gulubala.common.util.RandomUtils;
import com.penglecode.gulubala.common.util.SmsUtils;
import com.penglecode.gulubala.service.common.SmsService;

@Service("smsService")
public class SmsServiceImpl implements SmsService {

	@Resource(name="smsCodeCacheManager")
	private SmsCodeCacheManager smsCodeCacheManager;
	
	public String sendSmsCode(String mobilePhone) {
		String smsCode = RandomUtils.randomNumberCode(6);
		String message = Messages.getMessage("message.sms.register", smsCode);
		SmsUtils.sendMessage(mobilePhone, message);
		smsCodeCacheManager.setCache(mobilePhone, smsCode);
		return smsCode;
	}

}
