package com.penglecode.gulubala.service.auth.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.penglecode.gulubala.common.cache.AuthTokenCacheManager;
import com.penglecode.gulubala.common.consts.em.EnableDisableStatusEnum;
import com.penglecode.gulubala.common.support.AuthClientAppType;
import com.penglecode.gulubala.common.support.AuthRequest;
import com.penglecode.gulubala.common.support.AuthResponse;
import com.penglecode.gulubala.common.support.ClientAppAuthConfig;
import com.penglecode.gulubala.common.support.ValidationAssert;
import com.penglecode.gulubala.common.util.ClientAppAuthUtils;
import com.penglecode.gulubala.common.util.DateTimeUtils;
import com.penglecode.gulubala.common.util.StringUtils;
import com.penglecode.gulubala.dao.auth.ClientAppAuthConfigDAO;
import com.penglecode.gulubala.service.auth.ClientAppAuthService;

@Service("clientAppAuthService")
public class ClientAppAuthServiceImpl implements ClientAppAuthService {

	@Resource(name="authTokenCacheManager")
	private AuthTokenCacheManager authTokenCacheManager;
	
	@Resource(name="clientAppAuthConfigDAO")
	private ClientAppAuthConfigDAO clientAppAuthConfigDAO;
	
	@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRED)
	public void createClientAppAuthConfig(ClientAppAuthConfig config) {
		ValidationAssert.notNull(config, "请求参数不能为空!");
		ValidationAssert.notEmpty(config.getAppType(), "appType不能为空!");
		AuthClientAppType authClientAppType = AuthClientAppType.getAuthClientType(config.getAppType());
		ValidationAssert.notNull(authClientAppType, "appType无法识别!");
		config.setAppId(StringUtils.defaultIfEmpty(config.getAppId(), ClientAppAuthUtils.generateAppId()));
		config.setAppKey(ClientAppAuthUtils.generateAppKey());
		config.setStatus(EnableDisableStatusEnum.STATUS_ENABLED.getStatusCode());
		config.setCreateTime(DateTimeUtils.formatNow());
		clientAppAuthConfigDAO.insertClientAppAuthConfig(config);
	}

	public AuthResponse authClientApp(AuthRequest authRequest) {
		ValidationAssert.notNull(authRequest, "请求参数不能为空!");
		ValidationAssert.notEmpty(authRequest.getAppId(), "appId不能为空!");
		ValidationAssert.notEmpty(authRequest.getAppType(), "appType不能为空!");
		ValidationAssert.notEmpty(authRequest.getAuthTime(), "authTime不能为空!");
		ValidationAssert.notEmpty(authRequest.getAuthCode(), "authCode不能为空!");
		AuthClientAppType authClientAppType = AuthClientAppType.getAuthClientType(authRequest.getAppType());
		ValidationAssert.notNull(authClientAppType, "appType无法识别!");
		ClientAppAuthConfig clientAppAuthConfig = clientAppAuthConfigDAO.getClientAppAuthConfigById(authRequest.getAppId());
		ValidationAssert.notNull(clientAppAuthConfig, "appId不存在!");
		ValidationAssert.isTrue(authRequest.getAppType().equals(clientAppAuthConfig.getAppType()), "appType不匹配!");
		
		authRequest.setAppKey(clientAppAuthConfig.getAppKey());
		String authCode = ClientAppAuthUtils.buildAuthCode(authRequest);
		ValidationAssert.isTrue(authRequest.getAuthCode().equals(authCode), "授权码不合法!");
		AuthResponse authResponse = new AuthResponse();
		authResponse.setClientId(ClientAppAuthUtils.generateClientId());
		authResponse.setAuthToken(ClientAppAuthUtils.generateAuthToken());
		authTokenCacheManager.setCache(authResponse.getClientId(), authResponse.getAuthToken());
		return authResponse;
	}

}
