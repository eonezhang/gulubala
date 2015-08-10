package com.penglecode.gulubala.common.model;

import java.io.Serializable;
/**
 * 歌手表
 * 
 * @author  pengpeng
 * @date 	 2015年8月10日 上午10:22:24
 * @version 1.0
 */
public class Singer implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 歌手ID */
	private Long singerId;
	
	/** 歌手名称 */
	private String singerName;
	
	/** 歌手简介 */
	private String singerProfile;
	
	/** 性别 */
	private Integer sex;
	
	/** 生日 */
	private String birthday;
	
	/** 国籍 */
	private String country;
	
	/** 星座 */
	private String xingzuo;
	
	/** 血型 */
	private String xuexing;
	
	/** 身高 */
	private String shengao;
	
	/** 体重 */
	private String tizhong;
	
	/** 职业 */
	private String zhiye;
	
	private String createTime;
	
	private String updateTime;

	public Long getSingerId() {
		return singerId;
	}

	public void setSingerId(Long singerId) {
		this.singerId = singerId;
	}

	public String getSingerName() {
		return singerName;
	}

	public void setSingerName(String singerName) {
		this.singerName = singerName;
	}

	public String getSingerProfile() {
		return singerProfile;
	}

	public void setSingerProfile(String singerProfile) {
		this.singerProfile = singerProfile;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getXingzuo() {
		return xingzuo;
	}

	public void setXingzuo(String xingzuo) {
		this.xingzuo = xingzuo;
	}

	public String getXuexing() {
		return xuexing;
	}

	public void setXuexing(String xuexing) {
		this.xuexing = xuexing;
	}

	public String getShengao() {
		return shengao;
	}

	public void setShengao(String shengao) {
		this.shengao = shengao;
	}

	public String getTizhong() {
		return tizhong;
	}

	public void setTizhong(String tizhong) {
		this.tizhong = tizhong;
	}

	public String getZhiye() {
		return zhiye;
	}

	public void setZhiye(String zhiye) {
		this.zhiye = zhiye;
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
	
}
