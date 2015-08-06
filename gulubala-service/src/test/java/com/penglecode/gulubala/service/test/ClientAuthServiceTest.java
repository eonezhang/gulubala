package com.penglecode.gulubala.service.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.penglecode.gulubala.common.support.AuthClientAppType;
import com.penglecode.gulubala.common.support.ClientAppAuthConfig;
import com.penglecode.gulubala.service.auth.ClientAppAuthService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/spring-base.xml","classpath:spring/spring-beans.xml","classpath:spring/spring-dao.xml","classpath:spring/spring-cache.xml"})
public class ClientAuthServiceTest {

	@Resource(name="clientAppAuthService")
	private ClientAppAuthService clientAppAuthService;
	
	@Test
	public void testCreateClientAuthConfig(){
		ClientAppAuthConfig config = new ClientAppAuthConfig();
		config.setAppId("gulubala_app_android");
		config.setAppType(AuthClientAppType.CLIENT_APP_TYPE_ANDROID.getTypeCode());
		config.setAppName("gulubala安卓客户端!");
		clientAppAuthService.createClientAppAuthConfig(config);
	}
	
}
