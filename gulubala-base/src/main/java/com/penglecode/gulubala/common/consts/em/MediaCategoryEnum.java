package com.penglecode.gulubala.common.consts.em;
/**
 * 通用媒体分类类型
 * 
 * @author  pengpeng
 * @date 	 2015年8月5日 下午5:08:49
 * @version 1.0
 */
public enum MediaCategoryEnum {

	MEDIA_CATEGORY_MUSIC(1, "音乐分类"), MEDIA_CATEGORY_VIDEO(2, "视频分类");
	
	private Integer typeCode;
	
	private String typeName;

	private MediaCategoryEnum(Integer typeCode, String typeName) {
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

	public static MediaCategoryEnum getCategory(Integer typeCode){
		for(MediaCategoryEnum em : values()){
			if(em.getTypeCode().equals(typeCode)){
				return em;
			}
		}
		return null;
	}
	
}
