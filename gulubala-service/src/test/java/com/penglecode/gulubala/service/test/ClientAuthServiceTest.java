package com.penglecode.gulubala.service.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.penglecode.gulubala.common.support.AuthAppType;
import com.penglecode.gulubala.common.support.AppAuth;
import com.penglecode.gulubala.service.auth.AppAuthService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/spring-base.xml","classpath:spring/spring-beans.xml","classpath:spring/spring-dao.xml","classpath:spring/spring-cache.xml"})
public class ClientAuthServiceTest {

	@Resource(name="appAuthService")
	private AppAuthService appAuthService;
	
	@Test
	public void testCreateAppAuth(){
		AppAuth config = new AppAuth();
		config.setAppId("gulubala_app_android1");
		config.setAppType(AuthAppType.APP_TYPE_ANDROID.getTypeCode());
		config.setAppName("gulubala安卓客户端!");
		appAuthService.createAppAuth(config);
	}
	
}
