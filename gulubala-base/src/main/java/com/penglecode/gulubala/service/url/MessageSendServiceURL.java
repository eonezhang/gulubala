package com.penglecode.gulubala.service.url;
/**
 * 公共的信息发送服务URL
 * 
 * @author  pengpeng
 * @date 	 2015年8月4日 下午1:11:43
 * @version 1.0
 */
public interface MessageSendServiceURL {

	/** 发送注册短信验证码 */
	String URL_MSG_SEND_SMS = "common/msgsend/{sceneType}/sms/{mobilePhone}";
	
	/** 发送注册邮件验证码 */
	String URL_MSG_SEND_EMAIL = "common/msgsend/{sceneType}/email/{email}";
	
}
