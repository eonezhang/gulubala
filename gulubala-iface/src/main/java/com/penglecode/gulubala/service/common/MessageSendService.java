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
	 * 发送短信消息
	 * @param mobilePhone
	 * @return
	 */
	@GET
	@Path(MessageSendServiceURL.URL_MSG_SEND_SMS)
	@Produces({ContentType.APPLICATION_JSON_UTF_8})
	public String sendValidateCodeBySms(@PathParam("sceneType") String sceneType, @PathParam("mobilePhone") String mobilePhone);
	
	/**
	 * 发送邮件消息
	 * @param email
	 * @return
	 */
	@GET
	@Path(MessageSendServiceURL.URL_MSG_SEND_EMAIL)
	@Produces({ContentType.APPLICATION_JSON_UTF_8})
	public String sendValidateCodeByEmail(@PathParam("sceneType") String sceneType, @PathParam("email") String email);
	
}
