package com.penglecode.gulubala.common.consts.em;
/**
 * 用户日志类型
 * 
 * @author  pengpeng
 * @date 	 2015年8月5日 下午5:08:49
 * @version 1.0
 */
public enum UserLogType {

	READ(1, "读操作"), WRITE(2, "写操作");
	
	private Integer typeCode;
	
	private String typeName;

	private UserLogType(Integer typeCode, String typeName) {
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

	public static UserLogType getRegisterType(Integer typeCode){
		for(UserLogType em : values()){
			if(em.getTypeCode().equals(typeCode)){
				return em;
			}
		}
		return null;
	}
	
}
