package com.penglecode.gulubala.common.listener;

import java.lang.reflect.Field;

import com.penglecode.gulubala.common.util.FinalFieldUtils;
import com.penglecode.gulubala.common.util.ReflectionUtils;

/**
 * 应用程序初始化基类
 * 
 * @author	  	pengpeng
 * @date	  	2014年10月14日 下午4:01:51
 * @version  	1.0
 */
public abstract class AbstractApplicationInitializer implements ApplicationInitializer {

	protected void setFinalFieldValue(Field field, Object value) {
		if(field != null){
			FinalFieldUtils.setFinalFieldValue(null, field, value);
		}
	}
	
	protected void setFinalFieldValue(Class<?> targetClass, String fieldName, Object value) {
		Field field = ReflectionUtils.findField(targetClass, fieldName);
		if(field != null){
			FinalFieldUtils.setFinalFieldValue(null, field, value);
		}
	}
	
}
