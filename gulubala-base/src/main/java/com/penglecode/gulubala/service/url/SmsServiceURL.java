package com.penglecode.gulubala.service.url;
/**
 * 公共的短信服务URL
 * 
 * @author  pengpeng
 * @date 	 2015年8月4日 下午1:11:43
 * @version 1.0
 */
public interface SmsServiceURL {

	/** 短信验证码 */
	String URL_SEND_SMS_CODE = "common/send/smscode/{mobilePhone}";
	
}
