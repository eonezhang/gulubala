package com.penglecode.gulubala.common.cache;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.SessionCallback;

import com.penglecode.gulubala.common.support.NamedThreadFactory;
import com.penglecode.gulubala.common.util.StringUtils;

/**
 * 客户端接口调用认证鉴权authToken缓存管理器
 * 
 * @author  pengpeng
 * @date 	 2015年7月29日 下午12:36:57
 * @version 1.0
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class AuthTokenCacheManager extends AbstractCacheManager {

	/**
	 * 二级缓存
	 */
	private static final ConcurrentMap<String,String> authTokenNativeCache = new ConcurrentHashMap<String,String>(1000);
	
	private ScheduledExecutorService authTokenNativeCacheClearScheduler = Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors(), new NamedThreadFactory("AUTH-TOKEN-CACHE-CLEAR"));
	
	private long cacheClearInterval = 60 * 60; // 默认60分钟
	
	public ScheduledExecutorService getAuthTokenNativeCacheClearScheduler() {
		return authTokenNativeCacheClearScheduler;
	}

	public void setAuthTokenNativeCacheClearScheduler(
			ScheduledExecutorService authTokenNativeCacheClearScheduler) {
		this.authTokenNativeCacheClearScheduler = authTokenNativeCacheClearScheduler;
	}

	public long getCacheClearInterval() {
		return cacheClearInterval;
	}

	public void setCacheClearInterval(long cacheClearInterval) {
		this.cacheClearInterval = cacheClearInterval;
	}

	@PostConstruct
	protected void init() {
		setKeyPattern("global_auth_token_%s");
		setExpire(60 * 60 * 24 * 7);
		setKeyDescription("全局认证鉴权authToken缓存Key");
		getAuthTokenNativeCacheClearScheduler().scheduleWithFixedDelay(new Runnable(){
			public void run() {
				authTokenNativeCache.clear();
			}
		}, cacheClearInterval, cacheClearInterval, TimeUnit.SECONDS);
	}
	
	/**
	 * 设置缓存
	 * @param clientId
	 * @param authToken
	 */
	public void setCache(final String clientId, final String authToken) {
		authTokenNativeCache.put(clientId, authToken);
		final String realKey = key(clientId);
		getRedisTemplate().execute(new SessionCallback<Object>() {
			public Object execute(RedisOperations operations) throws DataAccessException {
				operations.opsForValue().set(realKey, authToken);
				operations.expire(realKey, getExpire(), getExpireTimeUnit());
				return null;
			}
		});
	}
	
	/**
	 * 获取缓存
	 * @param clientId
	 * @return
	 */
	public String getCache(final String clientId) {
		String authToken = authTokenNativeCache.get(clientId);
		if(StringUtils.isEmpty(authToken)){
			authToken = (String) getRedisTemplate().opsForValue().get(key(clientId));
			if(!StringUtils.isEmpty(authToken)){
				authTokenNativeCache.put(clientId, authToken);
			}
		}
		return authToken;
	}
	
	/**
	 * 删除缓存
	 * @param clientId
	 */
	public void removeCache(final String clientId) {
		authTokenNativeCache.remove(clientId);
		getRedisTemplate().delete(key(clientId));
	}
	
	/**
	 * 获取实际缓存key
	 * @param clientId
	 * @return
	 */
	public String key(final String clientId) {
		return String.format(getKeyPattern(), clientId);
	}
	
}
