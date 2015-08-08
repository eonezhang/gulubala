package com.penglecode.gulubala.service.common;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.penglecode.gulubala.common.consts.ContentType;
import com.penglecode.gulubala.service.url.MessageSendServiceURL;

/**
 * 公共的信息发送服务
 * 
 * @author  pengpeng
 * @date 	 2015年8月4日 下午1:10:36
 * @version 1.0
 */
@Path("")
public interface MessageSendService {

	/**
	 * 发送注册短信验证码
	 * @param mobilePhone
	 * @return
	 */
	@GET
	@Path(MessageSendServiceURL.URL_MSG_SEND_REGISTER_SMS)
	@Produces({ContentType.APPLICATION_JSON_UTF_8})
	public String sendMessageBySms4Register(@PathParam("mobilePhone") String mobilePhone);
	
	/**
	 * 发送注册邮件验证码
	 * @param email
	 * @return
	 */
	@GET
	@Path(MessageSendServiceURL.URL_MSG_SEND_REGISTER_EMAIL)
	@Produces({ContentType.APPLICATION_JSON_UTF_8})
	public String sendMessageByEmail4Register(@PathParam("email") String email);
	
}
