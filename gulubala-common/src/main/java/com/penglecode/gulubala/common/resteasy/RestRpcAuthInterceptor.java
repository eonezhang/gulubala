package com.penglecode.gulubala.common.resteasy;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Response;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.penglecode.gulubala.common.cache.AuthTokenCacheManager;
import com.penglecode.gulubala.common.support.BusinessAssert;
import com.penglecode.gulubala.common.util.CollectionUtils;
import com.penglecode.gulubala.common.util.SpringUtils;
import com.penglecode.gulubala.service.url.AppAuthServiceURL;
/**
 * 外部客户端通过rest方式调用服务时,对其请求进行认证
 * 
 * @author  pengpeng
 * @date 	 2015年7月29日 上午9:21:08
 * @version 1.0
 */

@PreMatching
public class RestRpcAuthInterceptor implements ContainerRequestFilter {

	private static final Logger logger = LoggerFactory.getLogger(RestRpcAuthInterceptor.class);
	
	public static final List<String> ALLOWED_HTTP_METHODS = Arrays.asList("GET", "POST");
	
	public static final String HEADER_USER_ID = "user-id";
	
	public static final String HEADER_AUTH_TOKEN = "auth-token";
	
	public static final String HEADER_CLIENT_ID = "client-id";
	
	public static final String DEFAULT_CONTEXT_PATH = "/services/";
	
	private final Object lock = new Object();
	
	private String contextPath = DEFAULT_CONTEXT_PATH;
	
	/** 不需要认证授权的url */
	private Set<String> noAuthUrls;
	
	private volatile AuthTokenCacheManager authTokenCacheManager;
	
	public RestRpcAuthInterceptor() {
		super();
		noAuthUrls = new HashSet<String>();
		noAuthUrls.add(AppAuthServiceURL.URL_CLIENT_AUTH);
	}

	public String getContextPath() {
		return contextPath;
	}

	public void setContextPath(String contextPath) {
		if(contextPath.endsWith("/")){
			contextPath = contextPath + "/";
		}
		this.contextPath = contextPath;
	}

	public Set<String> getNoAuthUrls() {
		return noAuthUrls;
	}

	public void setNoAuthUrls(Set<String> noAuthUrls) {
		this.noAuthUrls = noAuthUrls;
	}

	public AuthTokenCacheManager getAuthTokenCacheManager(){
		if(authTokenCacheManager == null){
			synchronized (lock) {
				if(authTokenCacheManager == null){
					authTokenCacheManager = SpringUtils.getBean(AuthTokenCacheManager.class);
				}
			}
		}
		return authTokenCacheManager;
	}
	
	public void filter(ContainerRequestContext requestContext) throws IOException {
		String path = requestContext.getUriInfo().getPath();
		path = path.replace(getContextPath(), "");
		logger.info("Do rest rpc auth validation for current request : {}", path);
		path = StringUtils.stripStart(path, "/");
		BusinessAssert.isTrue(ALLOWED_HTTP_METHODS.contains(requestContext.getMethod()), String.valueOf(Response.Status.METHOD_NOT_ALLOWED), "不允许的请求方法(" + requestContext.getMethod() + ")!");
		
		if(!CollectionUtils.isEmpty(noAuthUrls)){
			for(String noAuthUrl : noAuthUrls){
				if(!path.startsWith(noAuthUrl)){
					String authToken = requestContext.getHeaderString(HEADER_AUTH_TOKEN);
					String clientId = requestContext.getHeaderString(HEADER_CLIENT_ID);
					BusinessAssert.isTrue(isAuthTokenValid(clientId, authToken), String.valueOf(Response.Status.UNAUTHORIZED.getStatusCode()), "不合法的auth-token!");
				}
			}
		}
	}

	protected String getAuthToken(ContainerRequestContext requestContext) {
		return requestContext.getHeaderString(HEADER_AUTH_TOKEN);
	}
	
	protected boolean isAuthTokenValid(String clientId, String authToken) {
		BusinessAssert.notEmpty(clientId, "请求头中未发现" + HEADER_CLIENT_ID + "参数!");
		BusinessAssert.notEmpty(authToken, "请求头中未发现" + HEADER_AUTH_TOKEN + "参数!");
		String realAuthToken = getAuthTokenCacheManager().getCache(clientId);
		if(authToken.equals(realAuthToken)){
			return true;
		}
		return false;
	}
	
}
