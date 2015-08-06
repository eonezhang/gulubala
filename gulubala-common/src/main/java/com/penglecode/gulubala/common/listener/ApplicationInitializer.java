package com.penglecode.gulubala.common.listener;

import org.springframework.context.ApplicationContext;

/**
 * 应用程序初始化接口
 * 
 * @author	  	pengpeng
 * @date	  	2014年10月14日 下午4:00:50
 * @version  	1.0
 */
public interface ApplicationInitializer {

	/**
	 * 是否已经初始化了
	 * @return
	 */
	public boolean isInitialized();
	
	/**
	 * 是否支持多次初始化
	 * @return
	 */
	public boolean supportMultipleInitialize();
	
    /**
     * 执行初始化
     * @param applicationContext
     */
    public void initialize(ApplicationContext applicationContext) throws Exception;

}
