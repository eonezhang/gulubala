package com.penglecode.gulubala.common.util;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.BasicAuthentication;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.jboss.resteasy.specimpl.MultivaluedMapImpl;
import org.springframework.http.MediaType;

import com.penglecode.gulubala.common.consts.AbstractConstants;
import com.penglecode.gulubala.common.support.BusinessAssert;
import com.penglecode.gulubala.common.support.ConstValue;
import com.penglecode.gulubala.common.support.ValidationAssert;
/**
 * 基于螺丝帽的短信发送工具类
 * 
 * @author  pengpeng
 * @date 	 2015年8月4日 下午1:52:05
 * @version 1.0
 */
public class SmsUtils extends AbstractConstants {

	@ConstValue("${url.sms.send}")
	public static final String URL_SMS_SEND = valueOf("http://sms-api.luosimao.com/v1/send.json");
	
	@ConstValue("${sms.account.username}")
	public static final String SMS_ACCOUNT_USERNAME = valueOf("api");
	
	@ConstValue("${sms.account.password}")
	public static final String SMS_ACCOUNT_PASSWORD = valueOf("6ce13aa094d21878ed6ff9c969c7981c");
	
	public static final Map<Integer,String> ERROR_MESSAGES = new HashMap<Integer,String>();
	
	static {
		ERROR_MESSAGES.put(-10, "验证信息失败"); //检查api key是否和各种中心内的一致，调用传入是否正确
		ERROR_MESSAGES.put(-20, "短信余额不足");
		ERROR_MESSAGES.put(-30, "短信内容为空");
		ERROR_MESSAGES.put(-31, "短信内容存在敏感词");
		ERROR_MESSAGES.put(-32, "短信内容缺少签名信息"); //短信内容末尾增加签名信息eg.【公司名称】
		ERROR_MESSAGES.put(-40, "错误的手机号");
		ERROR_MESSAGES.put(-41, "号码在黑名单中");
		ERROR_MESSAGES.put(-42, "验证码类短信发送频率过快");
		ERROR_MESSAGES.put(-50, "请求发送IP不在白名单内"); //查看触发短信IP白名单的设置
	}
	
	/**
	 * 发送短信
	 * @param mobile		- 手机号码
	 * @param message		- 短信内容
	 * @return
	 */
	public static void sendMessage(String mobile, String message) {
		ValidationAssert.notEmpty(mobile, "手机号码不能为空!");
		ValidationAssert.notEmpty(message, "短信内容不能为空!");
		ResteasyClient client = new ResteasyClientBuilder().build();
		client.register(new BasicAuthentication(SMS_ACCOUNT_USERNAME, "key-" + SMS_ACCOUNT_PASSWORD));
		ResteasyWebTarget target = client.target(URL_SMS_SEND);
		MultivaluedMapImpl<String,String> formData = new MultivaluedMapImpl<String,String>();
        formData.add("mobile", mobile);
        formData.add("message", message);
		Response response = target.request().post(Entity.entity(formData, MediaType.APPLICATION_FORM_URLENCODED_VALUE));
		SmsResult result = response.readEntity(SmsResult.class);
		BusinessAssert.isTrue(!ERROR_MESSAGES.containsKey(result.getError()), ERROR_MESSAGES.get(result.getError()));
	}
	
	public static class SmsResult {
		
		private Integer error;
		
		private String msg;

		public Integer getError() {
			return error;
		}

		public void setError(Integer error) {
			this.error = error;
		}

		public String getMsg() {
			return msg;
		}

		public void setMsg(String msg) {
			this.msg = msg;
		}

		public String toString() {
			return "SmsResult [error=" + error + ", msg=" + msg + "]";
		}
		
	}
	
}
