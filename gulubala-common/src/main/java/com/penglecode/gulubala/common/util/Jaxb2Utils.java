package com.penglecode.gulubala.common.util;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.penglecode.gulubala.common.consts.GlobalConstants;

/**
 * 
 * @author 	pengpeng
 * @date	2014年6月15日 下午6:14:33
 * @version 1.0
 */
public class Jaxb2Utils {

	public static final String DEFAULT_CHARSET_ENCODING = GlobalConstants.SYSTEM_DEFAULT_ENCODING;
	
	/**
	 * JavaBean转换成xml
	 * @param obj
	 * @return
	 */
	public static String object2Xml(Object obj) {
		return object2Xml(obj, DEFAULT_CHARSET_ENCODING, true);
	}
	
	/**
	 * JavaBean转换成xml
	 * @param obj
	 * @param declaration
	 * @return
	 */
	public static String object2Xml(Object obj, boolean declaration) {
		return object2Xml(obj, DEFAULT_CHARSET_ENCODING, true);
	}

	/**
	 * JavaBean转换成xml
	 * @param obj
	 * @param encoding
	 * @param declaration		是否加入xml头声明: <?xml version="1.0" encoding="UTF-8" ?>
	 * @return
	 */
	public static String object2Xml(Object obj, String encoding, boolean declaration) {
		if(obj == null){
			return "";
		}
		String result = null;
		try {
			JAXBContext context = JAXBContext.newInstance(obj.getClass());
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, false); //是否格式化输出xml
			marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding); //xml编码
			marshaller.setProperty(Marshaller.JAXB_FRAGMENT, declaration); //xml声明
			StringWriter writer = new StringWriter();
			marshaller.marshal(obj, writer);
			result = writer.toString();
		} catch (Exception e) {
			throw new Jaxb2JavaConvertXmlException(e);
		}
		return result;
	}

	/**
	 * xml转换成JavaBean
	 * @param xml
	 * @param c
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T xml2Object(String xml, Class<T> c) {
		T t = null;
		try {
			JAXBContext context = JAXBContext.newInstance(c);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			t = (T) unmarshaller.unmarshal(new StringReader(xml));
		} catch (Exception e) {
			throw new Jaxb2XmlConvertJavaException(e);
		}
		return t;
	}
	
}
/**
 * Jaxb2 xml数据转java对象异常
 * 
 * @author 	pengpeng
 * @date	2014年6月16日 上午9:54:42
 * @version 1.0
 */
class Jaxb2XmlConvertJavaException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public Jaxb2XmlConvertJavaException() {
		super();
	}

	public Jaxb2XmlConvertJavaException(String message, Throwable cause) {
		super(message, cause);
	}

	public Jaxb2XmlConvertJavaException(String message) {
		super(message);
	}

	public Jaxb2XmlConvertJavaException(Throwable cause) {
		super(cause);
	}
	
}

/**
 * Jaxb2 xml数据转java对象异常
 * 
 * @author 	pengpeng
 * @date	2014年6月16日 上午9:54:42
 * @version 1.0
 */
class Jaxb2JavaConvertXmlException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public Jaxb2JavaConvertXmlException() {
		super();
	}

	public Jaxb2JavaConvertXmlException(String message, Throwable cause) {
		super(message, cause);
	}

	public Jaxb2JavaConvertXmlException(String message) {
		super(message);
	}

	public Jaxb2JavaConvertXmlException(Throwable cause) {
		super(cause);
	}
	
}