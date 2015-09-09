package com.penglecode.gulubala.common.resteasy;

import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.Path;
import javax.ws.rs.core.Application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Service;

import com.penglecode.gulubala.common.util.CollectionUtils;
import com.penglecode.gulubala.common.util.SpringUtils;
/**
 * 基于JAX-RS的rest服务应用程序
 * 
 * @author  pengpeng
 * @date 	 2015年9月9日 上午12:25:48
 * @version 1.0
 */
public class RestServiceApplication extends Application {

	private static final Logger logger = LoggerFactory.getLogger(RestServiceApplication.class);
	
	private final Set<Object> singletons = new HashSet<Object>();

	public RestServiceApplication() {
		super();
		loadProviders();
		logger.info(">>> Load rest service start!");
		loadRestService();
		logger.info(">>> Load rest service end!");
	}
	
	public Set<Object> getSingletons() {
        return singletons;
    }
	
	protected void loadProviders() {
		singletons.add(new LoggingFilter()); //日志记录过滤器
		singletons.add(new Jackson2ObjectMapperProvider()); //Jackson2序列化定制
		singletons.add(new RestRpcAuthInterceptor()); //接口调用认证鉴权
		singletons.add(new RestRpcResultWrappHandler()); //结果集处理
		singletons.add(new RestRpcUserLoggingInterceptor()); //用户操作日志处理
	}
	
	protected void loadRestService() {
		Map<String,Object> serviceBeans = SpringUtils.getBeansWithAnnotation(Service.class);
		if(!CollectionUtils.isEmpty(serviceBeans)){
			for(Map.Entry<String,Object> entry : serviceBeans.entrySet()){
				Object serviceBean = entry.getValue();
				Annotation anno = AnnotationUtils.findAnnotation(serviceBean.getClass(), Path.class);
				logger.debug(">>> Registry rest service: " + serviceBean.getClass().getName());
				if(anno != null){
					singletons.add(serviceBean);
				}
			}
		}
	}
	
}
