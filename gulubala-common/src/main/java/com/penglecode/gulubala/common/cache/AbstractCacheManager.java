package com.penglecode.gulubala.common.cache;

import java.util.concurrent.TimeUnit;

import org.springframework.data.redis.core.RedisTemplate;
/**
 * 通用redis缓存管理器
 * 
 * @author  pengpeng
 * @date 	 2015年4月22日 下午4:11:17
 * @version 1.0
 */
public abstract class AbstractCacheManager {

	private String keyPattern;
	
	private long expire = 0;
	
	private TimeUnit expireTimeUnit = TimeUnit.SECONDS;
	
	private String keyDescription;
	
	private RedisTemplate<String,Object> redisTemplate;

	public String getKeyPattern() {
		return keyPattern;
	}

	protected void setKeyPattern(String keyPattern) {
		this.keyPattern = keyPattern;
	}

	public long getExpire() {
		return expire;
	}

	protected void setExpire(long expire) {
		this.expire = expire;
	}

	public TimeUnit getExpireTimeUnit() {
		return expireTimeUnit;
	}

	protected void setExpireTimeUnit(TimeUnit expireTimeUnit) {
		this.expireTimeUnit = expireTimeUnit;
	}

	public String getKeyDescription() {
		return keyDescription;
	}

	protected void setKeyDescription(String keyDescription) {
		this.keyDescription = keyDescription;
	}

	public RedisTemplate<String, Object> getRedisTemplate() {
		return redisTemplate;
	}

	public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

}
