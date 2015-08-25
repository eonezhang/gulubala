package com.penglecode.gulubala.common.support;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 弹幕数据模板
 * 
 * @author  pengpeng
 * @date 	 2015年8月15日 上午10:48:07
 * @version 1.0
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="plist")
public class DanmuMsgTpl4IOS implements DanmuMsgTpl {

	private static final long serialVersionUID = 1L;
	
	@XmlAttribute
	private String version = "1.0";
	
	@XmlElementWrapper(name="array")
	@XmlElement(name="dict")
	private List<DanmuMsgItem4IOS> items;

	public List<DanmuMsgItem4IOS> getItems() {
		return items;
	}

	public void setItems(List<DanmuMsgItem4IOS> items) {
		this.items = items;
	}
	
}
