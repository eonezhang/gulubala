package com.penglecode.gulubala.common.cache;

import javax.annotation.PostConstruct;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.SessionCallback;

/**
 * 验证码缓存管理器
 * 
 * @author  pengpeng
 * @date 	 2015年7月29日 下午12:36:57
 * @version 1.0
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class ValidateCodeCacheManager extends AbstractCacheManager {

	@PostConstruct
	protected void init() {
		setCacheDefinition(CacheDefinitions.CACHE_GLOBAL_VALIDATE_CODE);
	}
	
	/**
	 * 设置缓存
	 * @param recipient		- 接收者(手机号、邮箱)
	 * @param validateCode	- 验证码
	 */
	public void setCache(final String recipient, final String validateCode) {
		final String realKey = key(recipient);
		getRedisTemplate().execute(new SessionCallback<Object>() {
			public Object execute(RedisOperations operations) throws DataAccessException {
				operations.opsForValue().set(realKey, validateCode);
				operations.expire(realKey, getExpireTime(), getTimeUnit());
				return null;
			}
		});
	}
	
	/**
	 * 获取缓存
	 * @param recipient
	 * @return
	 */
	public String getCache(final String recipient) {
		return (String) getRedisTemplate().opsForValue().get(key(recipient));
	}
	
	/**
	 * 删除缓存
	 * @param recipient
	 */
	public void removeCache(final String recipient) {
		getRedisTemplate().delete(key(recipient));
	}
	
	/**
	 * 获取实际缓存key
	 * @param recipient
	 * @return
	 */
	public String key(final String recipient) {
		return String.format(getCacheKey(), recipient);
	}
	
}
