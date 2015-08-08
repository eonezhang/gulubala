package com.penglecode.gulubala.common.cache;

import javax.annotation.PostConstruct;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.SessionCallback;

/**
 * 短信验证码缓存管理器
 * 
 * @author  pengpeng
 * @date 	 2015年7月29日 下午12:36:57
 * @version 1.0
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class SmsCodeCacheManager extends AbstractCacheManager {

	@PostConstruct
	protected void init() {
		setCacheDefinition(CacheDefinitions.CACHE_GLOBAL_AUTH_TOKEN);
	}
	
	/**
	 * 设置缓存
	 * @param mobilePhone
	 * @param smsCode
	 */
	public void setCache(final String mobilePhone, final String smsCode) {
		final String realKey = key(mobilePhone);
		getRedisTemplate().execute(new SessionCallback<Object>() {
			public Object execute(RedisOperations operations) throws DataAccessException {
				operations.opsForValue().set(realKey, smsCode);
				operations.expire(realKey, getExpireTime(), getTimeUnit());
				return null;
			}
		});
	}
	
	/**
	 * 获取缓存
	 * @param mobilePhone
	 * @return
	 */
	public String getCache(final String mobilePhone) {
		return (String) getRedisTemplate().opsForValue().get(key(mobilePhone));
	}
	
	/**
	 * 删除缓存
	 * @param mobilePhone
	 */
	public void removeCache(final String mobilePhone) {
		getRedisTemplate().delete(key(mobilePhone));
	}
	
	/**
	 * 获取实际缓存key
	 * @param mobilePhone
	 * @return
	 */
	public String key(final String mobilePhone) {
		return String.format(getCacheKey(), mobilePhone);
	}
	
}
