package com.penglecode.gulubala.common.util;

import java.util.Map;

import com.penglecode.gulubala.common.consts.ServletAppConstants;

/**
 * Spring Bean工具类
 * 
 * @author  pengpeng
 * @date 	 2015年4月26日 下午8:36:35
 * @version 1.0
 */
@SuppressWarnings("unchecked")
public class SpringUtils {

	public static <T> T getBean(Class<T> requiredType) {
		return ServletAppConstants.APPLICATION_CONTEXT.getBean(requiredType);
	}
	
	public static <T> T getBean(String name, Class<T> requiredType) {
		return ServletAppConstants.APPLICATION_CONTEXT.getBean(name, requiredType);
	}
	
	public static <T> T getBean(String name) {
		return (T) ServletAppConstants.APPLICATION_CONTEXT.getBean(name);
	}
	
	public static <T> Map<String,T> getBeansOfType(Class<T> type) {
		return ServletAppConstants.APPLICATION_CONTEXT.getBeansOfType(type);
	}
	
}
