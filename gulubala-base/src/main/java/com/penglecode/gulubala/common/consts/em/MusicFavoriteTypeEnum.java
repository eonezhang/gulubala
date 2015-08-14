package com.penglecode.gulubala.common.consts.em;
/**
 * 音乐收藏对象类型
 * 
 * @author  pengpeng
 * @date 	 2015年8月14日 下午1:56:55
 * @version 1.0
 */
public enum MusicFavoriteTypeEnum {

	FAVORITE_TYPE_MUSIC(1, "歌曲"), FAVORITE_TYPE_MUSIC_LIST(2, "歌单");
	
	private Integer typeCode;
	
	private String typeName;

	private MusicFavoriteTypeEnum(Integer typeCode, String typeName) {
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
	
	public static MusicFavoriteTypeEnum getFavoriteType(Integer typeCode) {
		for(MusicFavoriteTypeEnum em : values()){
			if(em.getTypeCode().equals(typeCode)){
				return em;
			}
		}
		return null;
	}
	
}
