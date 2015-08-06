package com.penglecode.gulubala.service.common;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.penglecode.gulubala.common.consts.ContentType;
import com.penglecode.gulubala.service.url.SmsServiceURL;

/**
 * 公共的短信服务
 * 
 * @author  pengpeng
 * @date 	 2015年8月4日 下午1:10:36
 * @version 1.0
 */
@Path("")
public interface SmsService {

	/**
	 * 发送短信验证码
	 * @param mobilePhone
	 * @return
	 */
	@GET
	@Path(SmsServiceURL.URL_SEND_SMS_CODE)
	@Produces({ContentType.APPLICATION_JSON_UTF_8})
	public String sendSmsCode(@PathParam("mobilePhone") String mobilePhone);
	
}
