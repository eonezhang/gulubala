package com.penglecode.gulubala.common.support;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;
/**
 * 弹幕数据
 * 
 * @author  pengpeng
 * @date 	 2015年8月15日 上午10:49:08
 * @version 1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DanmuMsgItem4Andriod implements ServiceResultNoWrap {

	private static final long serialVersionUID = 1L;

	@XmlAttribute(name="p")
	private String position;
	
	@XmlValue()
	private String content;

	public DanmuMsgItem4Andriod() {
		super();
	}

	public DanmuMsgItem4Andriod(String position, String content) {
		super();
		this.position = position;
		this.content = content;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
