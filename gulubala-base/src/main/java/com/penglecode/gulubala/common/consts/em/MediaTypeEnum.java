package com.penglecode.gulubala.common.consts.em;
/**
 * 媒体类型
 * 
 * @author  pengpeng
 * @date 	 2015年8月5日 下午5:08:49
 * @version 1.0
 */
public enum MediaTypeEnum {

	MEDIA_TYPE_MUSIC(0, "音乐"), MEDIA_TYPE_MV(1, "MV");
	
	private Integer typeCode;
	
	private String typeName;

	private MediaTypeEnum(Integer typeCode, String typeName) {
		this.typeCode = typeCode;
		this.typeName = typeName;
	}

	public Integer getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(Integer typeCode) {
		this.typeCode = typeCode;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public static MediaTypeEnum getMediaType(Integer typeCode){
		for(MediaTypeEnum em : values()){
			if(em.getTypeCode().equals(typeCode)){
				return em;
			}
		}
		return null;
	}
	
}
