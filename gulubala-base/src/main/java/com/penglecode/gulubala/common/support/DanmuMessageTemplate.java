package com.penglecode.gulubala.common.support;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 弹幕数据模板
 * 
 * @author  pengpeng
 * @date 	 2015年8月15日 上午10:48:07
 * @version 1.0
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="i")
@XmlType(propOrder={"chatServer", "chatId", "mission", "maxLimit", "source", "items"}) 
public class DanmuMessageTemplate implements ServiceResultNoWrap {

	private static final long serialVersionUID = 1L;

	@XmlElement(name="chatserver")
	private String chatServer;
	
	@XmlElement(name="chatid")
	private Integer chatId;
	
	@XmlElement(name="mission")
	private Integer mission;
	
	@XmlElement(name="maxlimit")
	private Integer maxLimit;
	
	@XmlElement(name="source")
	private String source;
	
	@XmlElement(name="d")
	private List<DanmuMessageItem> items;

	public String getChatServer() {
		return chatServer;
	}

	public void setChatServer(String chatServer) {
		this.chatServer = chatServer;
	}

	public Integer getChatId() {
		return chatId;
	}

	public void setChatId(Integer chatId) {
		this.chatId = chatId;
	}

	public Integer getMission() {
		return mission;
	}

	public void setMission(Integer mission) {
		this.mission = mission;
	}

	public Integer getMaxLimit() {
		return maxLimit;
	}

	public void setMaxLimit(Integer maxLimit) {
		this.maxLimit = maxLimit;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public List<DanmuMessageItem> getItems() {
		return items;
	}

	public void setItems(List<DanmuMessageItem> items) {
		this.items = items;
	}
	
}
