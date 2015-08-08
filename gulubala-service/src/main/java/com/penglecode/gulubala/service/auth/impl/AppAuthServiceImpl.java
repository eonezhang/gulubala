package com.penglecode.gulubala.service.auth.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.penglecode.gulubala.common.cache.AuthTokenCacheManager;
import com.penglecode.gulubala.common.consts.em.EnableDisableStatusEnum;
import com.penglecode.gulubala.common.support.AuthAppType;
import com.penglecode.gulubala.common.support.AuthRequest;
import com.penglecode.gulubala.common.support.AuthResponse;
import com.penglecode.gulubala.common.support.AppAuth;
import com.penglecode.gulubala.common.support.ValidationAssert;
import com.penglecode.gulubala.common.util.AppAuthUtils;
import com.penglecode.gulubala.common.util.DateTimeUtils;
import com.penglecode.gulubala.common.util.StringUtils;
import com.penglecode.gulubala.dao.auth.AppAuthDAO;
import com.penglecode.gulubala.service.auth.AppAuthService;

@Service("appAuthService")
public class AppAuthServiceImpl implements AppAuthService {

	@Resource(name="authTokenCacheManager")
	private AuthTokenCacheManager authTokenCacheManager;
	
	@Resource(name="appAuthDAO")
	private AppAuthDAO appAuthDAO;
	
	@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRED)
	public void createAppAuth(AppAuth config) {
		ValidationAssert.notNull(config, "请求参数不能为空!");
		ValidationAssert.notEmpty(config.getAppType(), "appType不能为空!");
		AuthAppType authAppType = AuthAppType.getAuthType(config.getAppType());
		ValidationAssert.notNull(authAppType, "appType无法识别!");
		config.setAppId(StringUtils.defaultIfEmpty(config.getAppId(), AppAuthUtils.generateAppId()));
		config.setAppKey(AppAuthUtils.generateAppKey());
		config.setStatus(EnableDisableStatusEnum.STATUS_ENABLED.getStatusCode());
		config.setCreateTime(DateTimeUtils.formatNow());
		appAuthDAO.insertAppAuth(config);
	}

	public AuthResponse authApp(AuthRequest authRequest) {
		ValidationAssert.notNull(authRequest, "请求参数不能为空!");
		ValidationAssert.notEmpty(authRequest.getAppId(), "appId不能为空!");
		ValidationAssert.notEmpty(authRequest.getAppType(), "appType不能为空!");
		ValidationAssert.notEmpty(authRequest.getAuthTime(), "authTime不能为空!");
		ValidationAssert.notEmpty(authRequest.getAuthCode(), "authCode不能为空!");
		AuthAppType authAppType = AuthAppType.getAuthType(authRequest.getAppType());
		ValidationAssert.notNull(authAppType, "appType无法识别!");
		AppAuth clientAppAuth = appAuthDAO.getAppAuthById(authRequest.getAppId());
		ValidationAssert.notNull(clientAppAuth, "appId不存在!");
		ValidationAssert.isTrue(authRequest.getAppType().equals(clientAppAuth.getAppType()), "appType不匹配!");
		
		authRequest.setAppKey(clientAppAuth.getAppKey());
		String authCode = AppAuthUtils.buildAuthCode(authRequest);
		ValidationAssert.isTrue(authRequest.getAuthCode().equals(authCode), "授权码不合法!");
		AuthResponse authResponse = new AuthResponse();
		authResponse.setClientId(AppAuthUtils.generateClientId());
		authResponse.setAuthToken(AppAuthUtils.generateAuthToken());
		authTokenCacheManager.setCache(authResponse.getClientId(), authResponse.getAuthToken());
		String oldId = authRequest.getClientId();
		if(!StringUtils.isEmpty(oldId)){
			authTokenCacheManager.removeCache(oldId);
		}
		return authResponse;
	}

}
