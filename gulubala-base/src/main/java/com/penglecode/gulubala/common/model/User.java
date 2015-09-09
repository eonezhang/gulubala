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
	
	/** 昵称 */
	private String nickName;
	
	/** 密码 */
	private String password;
	
	/** 手机号(唯一) */
	private String mobilePhone;
	
	/** 邮箱(唯一) */
	private String email;
	
	/** 第三方账户名 */
	private String thirdAccountName;
	
	/** 注册方式 @{link #UserRegisterTypeEnum} */
	private Integer registerType;
	
	/** 是否是vip */
	private boolean vip;
	
	/** 是否已认证 */
	private boolean authenticated;
	
	/** 积分数量 */
	private Integer score;
	
	/** 个性签名 */
	private String remark;
	
	/** 用户头像地址 */
	private String iconUrl;
	
	/** 关注数他人数 */
	private Integer follows;
	
	/** 粉丝数(被关注数) */
	private Integer fas;
	
	/** 人气数 */
	private Integer hots;
	
	/** 点赞数 */
	private Integer praises;
	
	/** 生日 */
	private String birthday;
	
	/** 性别:1-男0-女 */
	private Integer sex;
	
	/** 用户状态@{link #UserStatusEnum} */
	private Integer status;

	/** 登录次数 */
	private Integer loginTimes;
	
	/** 最近登录时间 */
	private String lastLoginTime;
	
	/** 注册时间 */
	private String createTime;
	
	/** 更新时间 */
	private String updateTime;
	
	/** QQ号码 */
	private String qq;
	
	/** 微博账号 */
	private String weibo;
	
	/** 真实姓名 */
	private String realName;
	
	/** 身份证号码 */
	private String idCard;
	
	/** 身份证正面照片路径 */
	private String idCardFrontUrl;
	
	/** 身份证反面照片路径 */
	private String idCardBackUrl;
	
	//以下属于辅助字段
	
	private String fullIconUrl;
	
	private String validateCode;
	
	private String encryptedPassword;

	private String statusName;

	/** 投稿数(上传歌曲数) */
	private Integer tgCount;
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
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

	public String getThirdAccountName() {
		return thirdAccountName;
	}

	public void setThirdAccountName(String thirdAccountName) {
		this.thirdAccountName = thirdAccountName;
	}

	public Integer getRegisterType() {
		return registerType;
	}

	public void setRegisterType(Integer registerType) {
		this.registerType = registerType;
	}

	public boolean isVip() {
		return vip;
	}

	public void setVip(boolean vip) {
		this.vip = vip;
	}

	public boolean isAuthenticated() {
		return authenticated;
	}

	public void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getIconUrl() {
		return iconUrl;
	}

	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

	public Integer getFollows() {
		return follows;
	}

	public void setFollows(Integer follows) {
		this.follows = follows;
	}

	public Integer getFas() {
		return fas;
	}

	public void setFas(Integer fas) {
		this.fas = fas;
	}

	public Integer getHots() {
		return hots;
	}

	public void setHots(Integer hots) {
		this.hots = hots;
	}

	public Integer getPraises() {
		return praises;
	}

	public void setPraises(Integer praises) {
		this.praises = praises;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
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

	public Integer getLoginTimes() {
		return loginTimes;
	}

	public void setLoginTimes(Integer loginTimes) {
		this.loginTimes = loginTimes;
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

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getWeibo() {
		return weibo;
	}

	public void setWeibo(String weibo) {
		this.weibo = weibo;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getIdCardFrontUrl() {
		return idCardFrontUrl;
	}

	public void setIdCardFrontUrl(String idCardFrontUrl) {
		this.idCardFrontUrl = idCardFrontUrl;
	}

	public String getIdCardBackUrl() {
		return idCardBackUrl;
	}

	public void setIdCardBackUrl(String idCardBackUrl) {
		this.idCardBackUrl = idCardBackUrl;
	}

	public String getFullIconUrl() {
		return fullIconUrl;
	}

	public void setFullIconUrl(String fullIconUrl) {
		this.fullIconUrl = fullIconUrl;
	}

	public String getValidateCode() {
		return validateCode;
	}

	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
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

	public Integer getTgCount() {
		return tgCount;
	}

	public void setTgCount(Integer tgCount) {
		this.tgCount = tgCount;
	}

}
