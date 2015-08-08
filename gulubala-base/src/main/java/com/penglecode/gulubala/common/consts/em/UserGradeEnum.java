package com.penglecode.gulubala.common.consts.em;
/**
 * 用户等级
 * 
 * @author  pengpeng
 * @date 	 2015年8月5日 下午5:09:01
 * @version 1.0
 */
public enum UserGradeEnum {

	USER_GRADE_LV1("LV1", "LV1"), USER_GRADE_LV2("LV2", "LV2"), USER_GRADE_LV3("LV3", "LV3"), USER_GRADE_LV4("LV4", "LV4"), USER_GRADE_LV5("LV5", "LV5");
	
	private String gradeCode;
	
	private String gradeName;

	private UserGradeEnum(String gradeCode, String gradeName) {
		this.gradeCode = gradeCode;
		this.gradeName = gradeName;
	}

	public String getGradeCode() {
		return gradeCode;
	}

	public void setGradeCode(String gradeCode) {
		this.gradeCode = gradeCode;
	}

	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	
}
