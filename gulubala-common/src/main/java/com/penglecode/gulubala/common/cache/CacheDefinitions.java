package com.penglecode.gulubala.common.cache;

import com.penglecode.gulubala.common.support.CacheDefinition;
import static com.penglecode.gulubala.common.support.CacheDefinition.*;

/**
 * 统一缓存常量类
 * 
 * @author  pengpeng
 * @date 	 2015年8月7日 下午1:19:01
 * @version 1.0
 */
public interface CacheDefinitions {

	/** 全局认证鉴权authToken缓存 */
	CacheDefinition CACHE_GLOBAL_AUTH_TOKEN = valueOf("global_auth_token_%s", "全局认证鉴权authToken缓存Key", 60 * 60 * 24 * 7);
	
	/** 全局短信验证码缓存 */
	CacheDefinition CACHE_GLOBAL_SMS_CODE = valueOf("global_sms_code_%s", "全局短信验证码缓存", 10 * 60);
	
}
