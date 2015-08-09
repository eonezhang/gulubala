package com.penglecode.gulubala.common.util;

import java.io.IOException;
import java.util.Map;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.core.GenericType;

import com.penglecode.gulubala.common.consts.AbstractConstants;

public class RestServiceUtils extends AbstractConstants {

	private static final String URL_SERVICE_DOMAIN = valueOf("http://127.0.0.1:8082/gulubala-service/services/");
	
	private static final String CLIENT_ID = valueOf("72ec935e8e4f49f888ec15e480937aa0");
	
	private static final String AUTH_TOKEN = valueOf("ebcd92560afa416b947c984d74b6b715");
	
	public static <T> T get(String url, Map<String,Object> paramMap, GenericType<T> responseType) {
		return get(prepareUrl(url), paramMap, RestClientUtils.MEDIA_TYPE_APPLICATION_JSON, responseType);
	}
	
	public static <T> T get(String url, Map<String,Object> paramMap, String responseMediaType, GenericType<T> responseType) {
		Client client = ClientBuilder.newClient();
		client.register(RestServiceClientRequestFilter.class, Integer.MIN_VALUE);
		return RestClientUtils.get(client, prepareUrl(url), paramMap, RestClientUtils.MEDIA_TYPE_APPLICATION_JSON, responseType);
	}
	
	public static <T> T post(String url, Object requestEntity, GenericType<T> responseType) {
		return post(prepareUrl(url), requestEntity, RestClientUtils.MEDIA_TYPE_APPLICATION_JSON, RestClientUtils.MEDIA_TYPE_APPLICATION_JSON, responseType);
	}
	
	public static <T> T post(String url, Object requestEntity, String requestMediaType, String responseMediaType, GenericType<T> responseType) {
		Client client = ClientBuilder.newClient();
		client.register(RestServiceClientRequestFilter.class, Integer.MIN_VALUE);
		return RestClientUtils.post(client, prepareUrl(url), requestEntity, requestMediaType, responseMediaType, responseType);
	}
	
	private static String prepareUrl(String url) {
		if(url != null){
			if(!url.startsWith("http://")){
				url = URL_SERVICE_DOMAIN + url;
			}
		}
		return url;
	}
	
	public static class RestServiceClientRequestFilter implements ClientRequestFilter {
		public void filter(ClientRequestContext requestContext) throws IOException {
			requestContext.getHeaders().add("client-id", CLIENT_ID);
			requestContext.getHeaders().add("auth-token", AUTH_TOKEN);
		}
	}
	
}
