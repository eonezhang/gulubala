package com.penglecode.gulubala.common.util;

import java.lang.annotation.Annotation;
import java.util.Map;

import org.springframework.context.ApplicationContext;

import com.penglecode.gulubala.common.consts.ApplicationConstants;

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
		return getApplicationContext().getBean(requiredType);
	}
	
	public static <T> T getBean(String name, Class<T> requiredType) {
		return getApplicationContext().getBean(name, requiredType);
	}
	
	public static <T> T getBean(String name) {
		return (T) getApplicationContext().getBean(name);
	}
	
	public static <T> Map<String,T> getBeansOfType(Class<T> type) {
		return getApplicationContext().getBeansOfType(type);
	}
	
	public static Map<String, Object> getBeansWithAnnotation(Class<? extends Annotation> annotationType) {
		return getApplicationContext().getBeansWithAnnotation(annotationType);
	}
	
	protected static ApplicationContext getApplicationContext(){
		return ApplicationConstants.APPLICATION_CONTEXT;
	}
	
}
