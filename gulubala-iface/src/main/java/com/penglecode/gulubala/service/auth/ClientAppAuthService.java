package com.penglecode.gulubala.service.auth;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.penglecode.gulubala.common.consts.ContentType;
import com.penglecode.gulubala.common.support.AuthRequest;
import com.penglecode.gulubala.common.support.AuthResponse;
import com.penglecode.gulubala.common.support.ClientAppAuthConfig;
import com.penglecode.gulubala.service.url.ClientAuthServiceURL;

/**
 * 客户端应用程序认证授权服务
 * 
 * @author  pengpeng
 * @date 	 2015年8月4日 上午9:17:03
 * @version 1.0
 */
@Path("")
public interface ClientAppAuthService {

	/**
	 * 创建客户端认证授权配置
	 * @param config
	 */
	public void createClientAppAuthConfig(ClientAppAuthConfig config);
	
	/**
	 * 客户端应用程序认证授权服务
	 * @param user
	 */
	@POST
	@Path(ClientAuthServiceURL.URL_CLIENT_AUTH)
	@Consumes({ContentType.APPLICATION_JSON_UTF_8})
	@Produces({ContentType.APPLICATION_JSON_UTF_8})
	public AuthResponse authClientApp(AuthRequest authRequest);
	
}
