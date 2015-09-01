package com.penglecode.gulubala.common.consts.em;
/**
 * 用户注册方式
 * 
 * @author  pengpeng
 * @date 	 2015年8月5日 下午5:08:49
 * @version 1.0
 */
public enum UserRegisterTypeEnum {

	USER_REG_TYPE_MOBILE(1, "使用手机号码注册"), USER_REG_TYPE_EMAIL(2, "使用邮箱注册"), USER_REG_TYPE_THIRD_QQ(3, "使用QQ账号注册"), USER_REG_TYPE_THIRD_WEIXIN(4, "使用微信账号注册"), USER_REG_TYPE_THIRD_SINA(5, "使用新浪账号注册");
	
	private Integer typeCode;
	
	private String typeName;

	private UserRegisterTypeEnum(Integer typeCode, String typeName) {
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

	public static UserRegisterTypeEnum getRegisterType(Integer typeCode){
		for(UserRegisterTypeEnum em : values()){
			if(em.getTypeCode().equals(typeCode)){
				return em;
			}
		}
		return null;
	}
	
}
