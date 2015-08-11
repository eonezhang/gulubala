package com.penglecode.gulubala.common.dubbo.resteasy;

import java.text.SimpleDateFormat;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
/**
 * 基于jackson2序列化及反序列化的特性话支持
 * 
 * @author  pengpeng
 * @date 	 2015年8月11日 下午5:46:37
 * @version 1.0
 */
@Provider
@Produces({MediaType.APPLICATION_JSON})
public class Jackson2ObjectMapperProvider implements ContextResolver<ObjectMapper> {

	public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	
	private static final ObjectMapper objectMapper = new ObjectMapper();
	
	static {
		// 建只输出非Null且非Empty(如List.isEmpty)的属性到Json字符串的Mapper,建议在外部接口中使用
		objectMapper.setSerializationInclusion(Include.NON_DEFAULT);
		//去掉默认的时间戳格式
		objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		//设置输入时忽略在JSON字符串中存在但Java对象实际没有的属性
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		objectMapper.setDateFormat(new SimpleDateFormat(DEFAULT_DATE_FORMAT));
		objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		//单引号处理,允许单引号
		//objectMapper.configure(Feature.ALLOW_SINGLE_QUOTES, true);
	}
	
	public ObjectMapper getContext(Class<?> type) {
		return objectMapper;
	}

}
