package com.penglecode.gulubala.service.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.penglecode.gulubala.common.cache.AuthTokenCacheManager;
import com.penglecode.gulubala.common.support.AuthAppType;
import com.penglecode.gulubala.common.support.AppAuth;
import com.penglecode.gulubala.service.auth.AppAuthService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/spring-base.xml","classpath:spring/spring-beans.xml","classpath:spring/spring-dao.xml","classpath:spring/spring-cache.xml"})
public class AuthServiceTest {

	@Resource(name="appAuthService")
	private AppAuthService appAuthService;
	
	@Resource(name="authTokenCacheManager")
	private AuthTokenCacheManager authTokenCacheManager;
	
	@Test
	public void testCreateAppAuth(){
		AppAuth config = new AppAuth();
		config.setAppId("gulubala_app_android1");
		config.setAppType(AuthAppType.APP_TYPE_ANDROID.getTypeCode());
		config.setAppName("gulubala安卓客户端!");
		appAuthService.createAppAuth(config);
	}
	
	@Test
	public void testSetAuthCache(){
		authTokenCacheManager.setCache("72ec935e8e4f49f888ec15e480937aa0", "ebcd92560afa416b947c984d74b6b715");
	}
	
}
