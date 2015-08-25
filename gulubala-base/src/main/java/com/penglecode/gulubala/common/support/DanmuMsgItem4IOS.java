package com.penglecode.gulubala.common.support;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 弹幕数据
 * 
 * @author  pengpeng
 * @date 	 2015年8月15日 上午10:49:08
 * @version 1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder={"mkey", "mvalue", "key", "string"}) 
public class DanmuMsgItem4IOS implements ServiceResultNoWrap {

	private static final long serialVersionUID = 1L;

	@XmlElement(name="mkey")
	private String mkey = "m";
	
	@XmlElement(name="mvalue")
	private String mvalue;
	
	@XmlElement(name="key")
	private String key = "p";
	
	@XmlElement(name="string")
	private String string;

	public String getMkey() {
		return mkey;
	}

	public void setMkey(String mkey) {
		this.mkey = mkey;
	}

	public String getMvalue() {
		return mvalue;
	}

	public void setMvalue(String mvalue) {
		this.mvalue = mvalue;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

}
