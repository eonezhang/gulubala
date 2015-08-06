package com.penglecode.gulubala.common.model;

import java.io.Serializable;
/**
 * 用户模型
 * 
 * @author  pengpeng
 * @date 	 2015年8月5日 下午4:41:21
 * @version 1.0
 */
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/** 用户ID */
	private Long userId;
	
	/** 用户名 */
	private String userName;
	
	/** 密码 */
	private String password;
	
	/** 手机号(唯一) */
	private String mobilePhone;
	
	/** 邮箱(唯一) */
	private String email;
	
	/** 注册方式 @{link #UserRegisterTypeEnum} */
	private Integer registerType;
	
	/** 用户等级 */
	private String userGrade;
	
	/** 是否已认证 */
	private boolean authenticated;
	
	/** 硬币数量 */
	private Integer priceNum;
	
	/** 积分数量 */
	private Integer integralNum;
	
	/** 登录次数 */
	private Integer loginTimes;
	
	/** 个性签名 */
	private String remark;
	
	/** QQ号码 */
	private String qqNumber;
	
	/** 用户头像 */
	private String userIcon;
	
	/** 性别:1-男0-女 */
	private Integer sex;
	
	/** 用户状态@{link #UserStatusEnum} */
	private Integer status;
	
	/** 最近登录时间 */
	private String lastLoginTime;
	
	/** 注册时间 */
	private String createTime;
	
	//以下属于辅助字段
	
	private String smsCode;
	
	private String repassword;
	
	private String encryptedPassword;

	private String statusName;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getRegisterType() {
		return registerType;
	}

	public void setRegisterType(Integer registerType) {
		this.registerType = registerType;
	}

	public String getUserGrade() {
		return userGrade;
	}

	public void setUserGrade(String userGrade) {
		this.userGrade = userGrade;
	}

	public boolean isAuthenticated() {
		return authenticated;
	}

	public void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
	}

	public Integer getPriceNum() {
		return priceNum;
	}

	public void setPriceNum(Integer priceNum) {
		this.priceNum = priceNum;
	}

	public Integer getIntegralNum() {
		return integralNum;
	}

	public void setIntegralNum(Integer integralNum) {
		this.integralNum = integralNum;
	}

	public Integer getLoginTimes() {
		return loginTimes;
	}

	public void setLoginTimes(Integer loginTimes) {
		this.loginTimes = loginTimes;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getQqNumber() {
		return qqNumber;
	}

	public void setQqNumber(String qqNumber) {
		this.qqNumber = qqNumber;
	}

	public String getUserIcon() {
		return userIcon;
	}

	public void setUserIcon(String userIcon) {
		this.userIcon = userIcon;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getSmsCode() {
		return smsCode;
	}

	public void setSmsCode(String smsCode) {
		this.smsCode = smsCode;
	}

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	
}
