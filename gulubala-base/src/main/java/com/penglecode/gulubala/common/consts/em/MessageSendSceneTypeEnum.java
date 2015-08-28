package com.penglecode.gulubala.common.consts.em;
/**
 * 信息发送场景类型
 * 
 * @author  pengpeng
 * @date 	 2015年8月21日 上午9:21:51
 * @version 1.0
 */
public enum MessageSendSceneTypeEnum {

	SCENE_TYPE_REGISTER("register", "用户注册"), SCENE_TYPE_RETRIEVE_PASSWORD("retrievepwd", "找回密码、修改密码");
	
	private String sceneType;
	
	private String description;

	private MessageSendSceneTypeEnum(String sceneType, String description) {
		this.sceneType = sceneType;
		this.description = description;
	}

	public String getSceneType() {
		return sceneType;
	}

	public void setSceneType(String sceneType) {
		this.sceneType = sceneType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public static MessageSendSceneTypeEnum getSceneType(String sceneType) {
		for(MessageSendSceneTypeEnum em : values()){
			if(em.getSceneType().equals(sceneType)){
				return em;
			}
		}
		return null;
	}
	
}
