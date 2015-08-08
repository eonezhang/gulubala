package com.penglecode.gulubala.common.dubbo.filter;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.Priority;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.ReaderInterceptor;
import javax.ws.rs.ext.ReaderInterceptorContext;
import javax.ws.rs.ext.WriterInterceptor;
import javax.ws.rs.ext.WriterInterceptorContext;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.penglecode.gulubala.common.consts.em.UserLogType;
import com.penglecode.gulubala.common.model.UserLog;
import com.penglecode.gulubala.common.support.NamedThreadFactory;
import com.penglecode.gulubala.common.support.UserLogging;
import com.penglecode.gulubala.common.util.DateTimeUtils;
import com.penglecode.gulubala.common.util.ExceptionUtils;
import com.penglecode.gulubala.common.util.JsonUtils;
import com.penglecode.gulubala.common.util.NetUtils;
import com.penglecode.gulubala.common.util.SpringUtils;
import com.penglecode.gulubala.common.util.StringUtils;
/**
 * 用户访问日志记录拦截器
 * 
 * @author  pengpeng
 * @date 	 2015年8月8日 上午10:29:09
 * @version 1.0
 */
@Priority(Integer.MIN_VALUE + 1)
public class RestRpcUserLoggingInterceptor implements ContainerRequestFilter, WriterInterceptor, ReaderInterceptor {

	private static final Logger logger = LoggerFactory.getLogger(RestRpcUserLoggingInterceptor.class);
	
	private static final String CONTEXT_ATTR_KEY_LOGGING_CONTEXT_PROPERTY = "CONTEXT_ATTR_KEY_LOGGING_CONTEXT_PROPERTY";
	
	private static final ExecutorService userLoggingExecutor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2, new NamedThreadFactory("USER-LOGGING-EXECUTE-WORKER-"));
	
	@Context
	private HttpServletRequest request;
	
	public void filter(ContainerRequestContext requestContext) throws IOException {
		logger.debug(">>> [执行]RestRpcUserLoggingInterceptor.filter()");
		try {
			String path = requestContext.getUriInfo().getPath();
			LoggingContext loggingContext = new LoggingContext();
			loggingContext.setOperateIp(NetUtils.getRemoteIpAddr(request));
			loggingContext.setOperateTime(DateTimeUtils.formatNow());
			loggingContext.setBeginTimeMillis(System.currentTimeMillis());
			loggingContext.setRequestUrl(path);
			loggingContext.setHttpMethod(requestContext.getMethod());
			loggingContext.setHeaders(requestContext.getHeaders());
			requestContext.setProperty(CONTEXT_ATTR_KEY_LOGGING_CONTEXT_PROPERTY, loggingContext);
		} catch (Throwable e) {
			logger.error(">>>[filter] 记录用户操作日志发生错误！错误信息：" + ExceptionUtils.getRootCauseMessage(e));
		}
	}

	public Object aroundReadFrom(ReaderInterceptorContext context) throws IOException, WebApplicationException {
		logger.debug(">>> [执行]RestRpcUserLoggingInterceptor.aroundReadFrom()");
		try {
			Object attribute = context.getProperty(CONTEXT_ATTR_KEY_LOGGING_CONTEXT_PROPERTY);
			if(attribute instanceof LoggingContext){
				LoggingContext loggingContext = (LoggingContext) attribute;
				loggingContext.setInputStream(context.getInputStream());
			}
		} catch (Throwable e) {
			logger.error(">>>[aroundReadFrom] 记录用户操作日志发生错误！错误信息：" + ExceptionUtils.getRootCauseMessage(e));
			context.setProperty(CONTEXT_ATTR_KEY_LOGGING_CONTEXT_PROPERTY, null);
		}
		return context.proceed();
	}

	public void aroundWriteTo(WriterInterceptorContext context) throws IOException, WebApplicationException {
		logger.debug(">>> [执行]RestRpcUserLoggingInterceptor.aroundWriteTo() ");
		try {
			UserLogging userLogging = getUserLoggingAnnotation(context);
			if(userLogging != null){
				Object attribute = context.getProperty(CONTEXT_ATTR_KEY_LOGGING_CONTEXT_PROPERTY);
				if(attribute instanceof LoggingContext){
					LoggingContext loggingContext = (LoggingContext) attribute;
					loggingContext.setUserLogging(userLogging);
					loggingContext.setEndTimeMillis(System.currentTimeMillis());
					
					UserLog userLog = new UserLog();
					userLog.setLogTitle(userLogging.title());
					userLog.setLogType(determinLogType(loggingContext).getTypeCode());
					userLog.setHttpMethod(loggingContext.getHttpMethod());
					userLog.setRequestUrl(loggingContext.getRequestUrl());
					userLog.setRequestParams(getRequestParams(loggingContext));
					userLog.setRequestResult(getRequestResult(context));
					userLog.setOperatorId(getOperatorId(loggingContext));
					userLog.setOperateTime(loggingContext.getOperateTime());
					userLog.setOperateTimeMillis(getOperateTimeMillis(loggingContext));
					userLog.setOperateIp(loggingContext.getOperateIp());
					AbstractUserLoggingHandler userLoggingHandler = null;
					try {
						userLoggingHandler = SpringUtils.getBean(AbstractUserLoggingHandler.class);
					} catch (Exception e) {
						logger.error(e.getMessage());
					}
					if(userLoggingHandler != null){
						userLoggingHandler.setUserLog(userLog);
						userLoggingExecutor.execute(userLoggingHandler);
					}
				}
			}
		} catch (Throwable e) {
			logger.error(">>>[aroundWriteTo] 记录用户操作日志发生错误！错误信息：" + ExceptionUtils.getRootCauseMessage(e));
		} finally {
			context.setProperty(CONTEXT_ATTR_KEY_LOGGING_CONTEXT_PROPERTY, null);
		}
		context.proceed();
	}

	/**
	 * 获取打在接口方法上的@UserLogging注解
	 * @param context
	 * @return
	 */
	protected UserLogging getUserLoggingAnnotation(WriterInterceptorContext context) {
		Annotation[] annotations = context.getAnnotations();
		if(annotations != null && annotations.length > 0){
			for(Annotation anno : annotations){
				if(anno instanceof UserLogging){
					return (UserLogging) anno;
				}
			}
		}
		return null;
	}
	
	/**
	 * 得出日志类型
	 * @param loggingContext
	 * @return
	 */
	protected UserLogType determinLogType(LoggingContext loggingContext) {
		UserLogging userLogging = loggingContext.getUserLogging();
		String httpMethod = loggingContext.getHttpMethod();
		UserLogType logType = userLogging.logType();
		if(logType == null && httpMethod != null){
			if("POST".equals(httpMethod)){
				logType = UserLogType.WRITE;
			}else if("GET".equals(httpMethod)){
				logType = UserLogType.READ;
			}
		}
		return logType == null ? UserLogType.READ : logType;
	}
	
	/**
	 * 获取请求体参数
	 * @param inputStream
	 * @return
	 * @throws IOException
	 */
	protected String getLoggingParams(InputStream inputStream) throws IOException {
		String params = null;
		if(inputStream != null){
			byte[] buffer = IOUtils.toByteArray(inputStream);
			params = new String(buffer, "UTF-8");
		}
		return StringUtils.defaultIfEmpty(params, null);
	}
	
	/**
	 * 获取请求头
	 * @param headers
	 * @return
	 */
	protected Map<String,String> getLoggingHeaders(MultivaluedMap<String,String> headers) {
		Map<String,String> filteredHeaders = new LinkedHashMap<String,String>();
		if(headers != null && !headers.isEmpty()){
			filteredHeaders.put(RestRpcAuthInterceptor.HEADER_CLIENT_ID, headers.getFirst(RestRpcAuthInterceptor.HEADER_CLIENT_ID));
			filteredHeaders.put(RestRpcAuthInterceptor.HEADER_AUTH_TOKEN, headers.getFirst(RestRpcAuthInterceptor.HEADER_AUTH_TOKEN));
			filteredHeaders.put(RestRpcAuthInterceptor.HEADER_USER_ID, headers.getFirst(RestRpcAuthInterceptor.HEADER_USER_ID));
		}
		return filteredHeaders;
	}
	
	/**
	 * 获取全部请求参数
	 * @param loggingContext
	 * @return json数据
	 * @throws IOException
	 */
	protected String getRequestParams(LoggingContext loggingContext) throws IOException {
		Map<String,Object> paramMap = new LinkedHashMap<String,Object>();
		paramMap.put("headers", getLoggingHeaders(loggingContext.getHeaders()));
		paramMap.put("params", getLoggingParams(loggingContext.getInputStream()));
		return JsonUtils.object2Json(paramMap);
	}
	
	/**
	 * 获取请求结果
	 * @param context
	 * @return json数据
	 */
	protected String getRequestResult(WriterInterceptorContext context) {
		return context.getEntity() == null ? null : JsonUtils.object2Json(context.getEntity());
	}
	
	/**
	 * 计算请求耗时(毫秒)
	 * @param loggingContext
	 * @return
	 */
	protected long getOperateTimeMillis(LoggingContext loggingContext) {
		long operateTimeMillis = loggingContext.getEndTimeMillis() - loggingContext.getBeginTimeMillis();
		return operateTimeMillis < 0 ? 0 : operateTimeMillis;
	}
	
	/**
	 * 获取操作人id,从请求头中获取user-id
	 * @param loggingContext
	 * @return
	 */
	protected Long getOperatorId(LoggingContext loggingContext) {
		String suid = loggingContext.getHeaders().getFirst(RestRpcAuthInterceptor.HEADER_USER_ID);
		if(suid != null){
			suid = suid.trim();
			try {
				return Long.valueOf(suid);
			} catch (Exception e) {
			}
		}
		return null;
	}
	
	public static class LoggingContext {
		
		private String operateIp;
		
		private String operateTime;
		
		private long beginTimeMillis;
		
		private long endTimeMillis;
		
		private MultivaluedMap<String,String> headers;
		
		private String requestUrl;
		
		private String httpMethod;

		private InputStream inputStream;
		
		private UserLogging userLogging;

		public String getOperateIp() {
			return operateIp;
		}

		public void setOperateIp(String operateIp) {
			this.operateIp = operateIp;
		}

		public String getOperateTime() {
			return operateTime;
		}

		public void setOperateTime(String operateTime) {
			this.operateTime = operateTime;
		}

		public long getBeginTimeMillis() {
			return beginTimeMillis;
		}

		public void setBeginTimeMillis(long beginTimeMillis) {
			this.beginTimeMillis = beginTimeMillis;
		}

		public long getEndTimeMillis() {
			return endTimeMillis;
		}

		public void setEndTimeMillis(long endTimeMillis) {
			this.endTimeMillis = endTimeMillis;
		}

		public MultivaluedMap<String, String> getHeaders() {
			return headers;
		}

		public void setHeaders(MultivaluedMap<String, String> headers) {
			this.headers = headers;
		}

		public String getRequestUrl() {
			return requestUrl;
		}

		public void setRequestUrl(String requestUrl) {
			this.requestUrl = requestUrl;
		}

		public String getHttpMethod() {
			return httpMethod;
		}

		public void setHttpMethod(String httpMethod) {
			this.httpMethod = httpMethod;
		}

		public InputStream getInputStream() {
			return inputStream;
		}

		public void setInputStream(InputStream inputStream) {
			this.inputStream = inputStream;
		}

		public UserLogging getUserLogging() {
			return userLogging;
		}

		public void setUserLogging(UserLogging userLogging) {
			this.userLogging = userLogging;
		}

	}
	
}
