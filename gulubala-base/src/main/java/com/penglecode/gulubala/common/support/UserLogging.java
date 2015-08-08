package com.penglecode.gulubala.common.support;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.penglecode.gulubala.common.consts.em.UserLogType;
/**
 * 对用户行为进行日志记录
 * 
 * @author	  	pengpeng
 * @date	  	2014年10月16日 下午9:17:42
 * @version  	1.0
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface UserLogging {

	String title();
	
	UserLogType logType();
	
}
