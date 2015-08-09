package com.penglecode.gulubala.common.util;

import java.util.Map;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

import org.springframework.util.Assert;

public class RestClientUtils {

	public static final String MEDIA_TYPE_APPLICATION_JSON = "application/json;charset=UTF-8";
	
	public static final String MEDIA_TYPE_APPLICATION_XML = "application/xml;charset=UTF-8";
	
	public static <T> T get(String url, Map<String,Object> paramMap, GenericType<T> responseType) {
		return get(ClientBuilder.newClient(), url, paramMap, MEDIA_TYPE_APPLICATION_JSON, responseType);
	}
	
	public static <T> T get(String url, Map<String,Object> paramMap, String responseMediaType, GenericType<T> responseType) {
		return get(ClientBuilder.newClient(), url, paramMap, responseMediaType, responseType);
	}
	
	public static <T> T get(Client client, String url, Map<String,Object> paramMap, String responseMediaType, GenericType<T> responseType) {
		Assert.notNull(client, "Parameter 'client' can not be null!");
		Assert.hasText(url, "Parameter 'url' can not be empty!");
		WebTarget target = client.target(url);
		if(!CollectionUtils.isEmpty(paramMap)){
			for(Map.Entry<String,Object> entry : paramMap.entrySet()){
				String placeholder = "{" + entry.getKey() + "}";
				if(url.contains(placeholder)){
					target = target.resolveTemplate(entry.getKey(), entry.getValue());
				}else{
					target = target.queryParam(entry.getKey(), entry.getValue());
				}
			}
		}
		Response response = target.request(responseMediaType).get();
		if(response.getStatus() == Response.Status.OK.getStatusCode()){
			return response.readEntity(responseType);
		}else{
			String responseText = response.readEntity(String.class);
			throw new RestClientException(responseText);
		}
	}
	
	public static <T> T post(String url, Object requestEntity, GenericType<T> responseType) {
		return post(ClientBuilder.newClient(), url, requestEntity, MEDIA_TYPE_APPLICATION_JSON, MEDIA_TYPE_APPLICATION_JSON, responseType);
	}
	
	public static <T> T post(String url, Object requestEntity, String requestMediaType, String responseMediaType, GenericType<T> responseType) {
		return post(ClientBuilder.newClient(), url, requestEntity, requestMediaType, responseMediaType, responseType);
	}
	
	public static <T> T post(Client client, String url, Object requestEntity, String requestMediaType, String responseMediaType, GenericType<T> responseType) {
		Assert.notNull(client, "Parameter 'client' can not be null!");
		Assert.hasText(url, "Parameter 'url' can not be empty!");
		WebTarget target = client.target(url);
		Response response = target.request(responseMediaType).post(Entity.entity(requestEntity, requestMediaType));
		if(response.getStatus() == Response.Status.OK.getStatusCode()){
			return response.readEntity(responseType);
		}else{
			String responseText = response.readEntity(String.class);
			throw new RestClientException(responseText);
		}
	}
	
	public static class RestClientException extends RuntimeException {

		private static final long serialVersionUID = 1L;

		public RestClientException(String message, Throwable cause) {
			super(message, cause);
		}

		public RestClientException(String message) {
			super(message);
		}

		public RestClientException(Throwable cause) {
			super(cause);
		}
		
	}
	
}
