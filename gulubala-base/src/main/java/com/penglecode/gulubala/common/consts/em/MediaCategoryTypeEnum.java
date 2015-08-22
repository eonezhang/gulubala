package com.penglecode.gulubala.common.consts.em;
/**
 * 通用媒体分类类型
 * 
 * @author  pengpeng
 * @date 	 2015年8月5日 下午5:08:49
 * @version 1.0
 */
public enum MediaCategoryTypeEnum {

	MEDIA_CATEGORY_TYPE_MUSIC(1, "音乐分类"), MEDIA_CATEGORY_TYPE_VIDEO(2, "视频分类"), MEDIA_CATEGORY_TYPE_HOTS(3, "排行榜分类");
	
	private Integer typeCode;
	
	private String typeName;

	private MediaCategoryTypeEnum(Integer typeCode, String typeName) {
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

	public static MediaCategoryTypeEnum getCategoryType(Integer typeCode){
		for(MediaCategoryTypeEnum em : values()){
			if(em.getTypeCode().equals(typeCode)){
				return em;
			}
		}
		return null;
	}
	
}
