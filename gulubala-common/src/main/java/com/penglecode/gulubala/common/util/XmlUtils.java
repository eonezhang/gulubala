package com.penglecode.gulubala.common.util;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

import com.fasterxml.aalto.stax.InputFactoryImpl;
import com.fasterxml.aalto.stax.OutputFactoryImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlFactory;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationIntrospector;

/**
 * XML工具类
 * 
 * @author  pengpeng
 * @date 	 2015年8月14日 下午8:59:06
 * @version 1.0
 */
public class XmlUtils {

public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	
	private static final ObjectMapper defaultObjectMapper = new XmlMapper(new XmlFactory(new InputFactoryImpl(), new OutputFactoryImpl()));
	
	static {
		defaultObjectMapper.setAnnotationIntrospector(new JaxbAnnotationIntrospector(defaultObjectMapper.getTypeFactory()));
	}
	
	public static String object2Xml(Object object) {
		try {
			return defaultObjectMapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			throw new JacksonXmlException(e);
		}
	}
	
	public static <T> T xml2Object(String xml, Class<T> clazz) {
		try {
			return defaultObjectMapper.readValue(xml, clazz);
		} catch (Exception e) {
			throw new JacksonXmlException(e);
		}
	}
	
	public static class JacksonXmlException extends RuntimeException {

		private static final long serialVersionUID = 1L;

		public JacksonXmlException(String message, Throwable cause) {
			super(message, cause);
		}

		public JacksonXmlException(String message) {
			super(message);
		}

		public JacksonXmlException(Throwable cause) {
			super(cause);
		}
		
	}
	
	public static void main(String[] args) {
		BeanDefinition definition = new BeanDefinition();
		definition.setBeanId("userService");
		definition.setBeanClass("com.penglecode.gulubala.service.user.UserService");
		definition.setSinglton(true);
		definition.setValue("userService");
		String xml = object2Xml(definition);
		System.out.println(xml);
		
		definition = xml2Object(xml, BeanDefinition.class);
		String xml2 = object2Xml(definition);
		System.out.println(xml2);
	}
	
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlRootElement(name="bean")
	public static class BeanDefinition {
		
		@XmlAttribute(name="id")
		private String beanId;
		
		@XmlAttribute(name="name")
		private String beanName;
		
		@XmlAttribute(name="class")
		private String beanClass;
		
		@XmlAttribute(name="singlton")
		private boolean singlton;
		
		@XmlValue
		private String value;

		public String getBeanId() {
			return beanId;
		}

		public void setBeanId(String beanId) {
			this.beanId = beanId;
		}

		public String getBeanName() {
			return beanName;
		}

		public void setBeanName(String beanName) {
			this.beanName = beanName;
		}

		public String getBeanClass() {
			return beanClass;
		}

		public void setBeanClass(String beanClass) {
			this.beanClass = beanClass;
		}

		public boolean isSinglton() {
			return singlton;
		}

		public void setSinglton(boolean singlton) {
			this.singlton = singlton;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}
		
	}
	
}
