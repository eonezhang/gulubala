package com.penglecode.gulubala.dao.auth;

import com.penglecode.gulubala.common.support.AppAuth;

/**
 * 客户端应用程序认证授权配置DAO
 * 
 * @author  pengpeng
 * @date 	 2015年8月4日 上午9:59:23
 * @version 1.0
 */
public interface AppAuthDAO {

	/**
	 * 新增客户端应用程序认证授权配置
	 * @param config
	 */
	public void insertAppAuth(AppAuth appAuth);
	
	/**
	 * 修改客户端应用程序认证授权配置
	 * @param config
	 */
	public void updateAppAuth(AppAuth appAuth);
	
	/**
	 * 删除客户端应用程序认证授权配置
	 * @param config
	 */
	public void deleteAppAuthById(String appId);
	
	/**
	 * 根据客户端应用程序id获取客户端认证授权配置
	 * @param clientId
	 * @return
	 */
	public AppAuth getAppAuthById(String appId);
	
}
