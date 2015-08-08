package com.penglecode.gulubala.common.cache;

import java.util.concurrent.TimeUnit;

import org.springframework.data.redis.core.RedisTemplate;

import com.penglecode.gulubala.common.support.CacheDefinition;
/**
 * 通用redis缓存管理器
 * 
 * @author  pengpeng
 * @date 	 2015年4月22日 下午4:11:17
 * @version 1.0
 */
public abstract class AbstractCacheManager {

	private CacheDefinition cacheDefinition;
	
	private RedisTemplate<String,Object> redisTemplate;

	public CacheDefinition getCacheDefinition() {
		return cacheDefinition;
	}

	public void setCacheDefinition(CacheDefinition cacheDefinition) {
		this.cacheDefinition = cacheDefinition;
	}

	public RedisTemplate<String, Object> getRedisTemplate() {
		return redisTemplate;
	}

	public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	public String getCacheKey() {
		return cacheDefinition.getCacheKey();
	}
	
	public String getDescription() {
		return cacheDefinition.getDescription();
	}
	
	public long getExpireTime() {
		return cacheDefinition.getExpireTime();
	}
	
	public TimeUnit getTimeUnit() {
		return cacheDefinition.getTimeUnit();
	}
	
}
