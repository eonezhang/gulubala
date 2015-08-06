package com.penglecode.gulubala.common.util;

import java.text.SimpleDateFormat;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JsonUtils {

	public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	
	private static final ObjectMapper defaultObjectMapper = new ObjectMapper();
	
	static {
		// 建只输出非Null且非Empty(如List.isEmpty)的属性到Json字符串的Mapper,建议在外部接口中使用
		//defaultObjectMapper.setSerializationInclusion(Include.NON_DEFAULT);
		//去掉默认的时间戳格式
		defaultObjectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		//设置输入时忽略在JSON字符串中存在但Java对象实际没有的属性
		defaultObjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		defaultObjectMapper.setDateFormat(new SimpleDateFormat(DEFAULT_DATE_FORMAT));
		defaultObjectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		//单引号处理,允许单引号
		defaultObjectMapper.configure(com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
	}
	
	/**
	 * 对象转json字符串
	 * @param object
	 * @return
	 */
	public static String object2Json(Object object) {
		try {
			return defaultObjectMapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			throw new JacksonException(e);
		}
	}
	
	/**
	 * json字符串转普通javabean
	 * @param <T>
	 * @param json
	 * @param clazz		- 注：clazz所指对象存在泛型,例如 Result<User> 则转换后User的实际类型是个Map,此类情况应该使用TypeReference进行转换
	 * @return
	 */
	public static <T> T json2Object(String json, Class<T> clazz) {
		try {
			return defaultObjectMapper.readValue(json, clazz);
		} catch (Exception e) {
			throw new JacksonException(e);
		}
	}
	
	/**
	 * json字符串转泛型类对象
	 * 示例： List<User> userList = json2Object("[{"username":"jack","accounts":[{"accountId":"","amount":1200.00},...]},...]", new TypeReference<List<User>>(){});
	 * 		  Result<User> result = json2Object("{"success": true, "message": "OK", data: {"userId": 12345, "userName": "jack"}}", new TypeReference<Result<User>>(){});
	 * @param <T>
	 * @param json
	 * @param typeReference
	 * @return
	 */
	public static <T> T json2Object(String json, TypeReference<T> typeReference) {
		try {
			return defaultObjectMapper.readValue(json, typeReference);
		} catch (Exception e) {
			throw new JacksonException(e);
		}
	}
	
	public static ObjectMapper getDefaultObjectMapper() {
		return defaultObjectMapper;
	}
	
	public static class JacksonException extends RuntimeException {

		private static final long serialVersionUID = 1L;

		public JacksonException(String message, Throwable cause) {
			super(message, cause);
		}

		public JacksonException(String message) {
			super(message);
		}

		public JacksonException(Throwable cause) {
			super(cause);
		}
		
	}
	
}
