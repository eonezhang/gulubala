package com.penglecode.gulubala.common.dubbo.filter;

import java.io.IOException;
import java.lang.annotation.Annotation;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.Produces;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.RuntimeDelegate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.penglecode.gulubala.common.consts.GlobalConstants;
import com.penglecode.gulubala.common.exception.SystemException;
import com.penglecode.gulubala.common.support.Result;
import com.penglecode.gulubala.common.util.ExceptionUtils;

/**
 * 外部客户端通过rest方式调用服务时,对返回结果进行一层统一包装的的处理类
 * 
 * @author  pengpeng
 * @date 	 2015年4月18日 下午3:55:42
 * @version 1.0
 */
public class RestRpcResultWrappHandler implements ContainerResponseFilter, ExceptionMapper<Exception> {

	private static final Logger logger = LoggerFactory.getLogger(RestRpcResultWrappHandler.class);
	
	public static final MediaType DEFAULT_MEDIA_TYPE = new MediaType("application", "json", "UTF-8");
	
	/**
	 * 当仅当调用的服务方法未发生异常时响应才会走该filter方法
	 */
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
		Object responseEntity = responseContext.getEntity();
		if(!(responseEntity instanceof Result)){ //当调用的服务方法返回结果集不是Result类型时,使用Result进行包裹
			Result<Object> result = new Result<Object>();
			result.setSuccess(true);
			result.setCode(GlobalConstants.RESULT_CODE_SUCCESS);
			result.setMessage("OK");
			result.setData(responseEntity);
			
			MediaType mediaType = resolveResponseMediaType(requestContext, responseContext);
			responseContext.setEntity(result, responseContext.getEntityAnnotations(), mediaType);
			responseContext.setStatus(Response.Status.OK.getStatusCode());
			logger.debug("Rest rpc result has been wrapped, the wrapped result is : " + result);
		}
	}
	
	/**
	 * 当仅当调用的服务方法发生异常时响应才会走该toResponse方法
	 */
    public Response toResponse(Exception e) {
    	Throwable cause = ExceptionUtils.getRootCause(e);
        if (cause instanceof ConstraintViolationException) {
            return handleConstraintViolationException((ConstraintViolationException) cause);
        }
        logger.error("Rest rpc exception mapper got an Exception: " + e.getMessage(), e);
        Result<Object> result = new Result<Object>();
        Throwable rootException = ExceptionUtils.getRootCause(e);
		String code = GlobalConstants.RESULT_CODE_FAILURE;
		String message = rootException.getMessage();
		if(rootException instanceof SystemException){
			SystemException ex = (SystemException)rootException;
			code = ex.getCode();
		}
		result.setSuccess(false);
		result.setCode(code);
		result.setMessage(message);
		result.setData(null);
        return Response.status(Response.Status.OK).entity(result).type(ContentType.APPLICATION_JSON_UTF_8).build();
    }
    
    /**
     * 处理javax.validation验证体系的错误提示信息
     */
    protected Response handleConstraintViolationException(ConstraintViolationException cve) {
    	StringBuilder sb = new StringBuilder();
    	int i = 0, len = cve.getConstraintViolations().size();
        for (ConstraintViolation<?> cv : cve.getConstraintViolations()) {
        	sb.append(cv.getMessage());
        	if(i < len - 1){
        		sb.append(";");
        	}
        }
        Result<Object> result = new Result<Object>();
        result.setSuccess(false);
        result.setCode(GlobalConstants.RESULT_CODE_FAILURE);
        result.setMessage(sb.toString());
        result.setData(null);
        return Response.status(Response.Status.OK).entity(result).type(ContentType.APPLICATION_JSON_UTF_8).build();
    }
    
    protected MediaType resolveResponseMediaType(ContainerRequestContext requestContext, ContainerResponseContext responseContext) {
    	MediaType targetMediaType = null;
    	Annotation[] annotations = responseContext.getEntityAnnotations();
		if(annotations != null && annotations.length > 0){
			for(Annotation anno : annotations){
				if(anno instanceof Produces){
					Produces annotation = (Produces) anno;
					String[] contentTypes = annotation.value();
					if(contentTypes != null && contentTypes.length > 0){
						String primeContentType = contentTypes[0];
						targetMediaType = RuntimeDelegate.getInstance().createHeaderDelegate(MediaType.class).fromString(primeContentType);
					}
				}
			}
		}
		if(targetMediaType == null){
			targetMediaType = DEFAULT_MEDIA_TYPE;
		}
		return targetMediaType;
    }
    
}
