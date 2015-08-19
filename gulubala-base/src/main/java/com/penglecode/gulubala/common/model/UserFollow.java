package com.penglecode.gulubala.common.model;

import java.io.Serializable;
/**
 * 用户关注模型
 * 
 * @author  pengpeng
 * @date 	 2015年8月19日 下午12:42:33
 * @version 1.0
 */
public class UserFollow implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 关注ID */
	private Long id;
	
	/** 关注者ID */
	private Long userId;
	
	/** 被关注者ID */
	private Long followId;
	
	/** 关注时间 */
	private String createTime;
	
	//以下属于辅助字段
	
	/** 用户头像地址 */
	private String iconUrl;
	
	/** 被关注数 */
	private Integer follows;
	
	/** 人气数 */
	private Integer hots;
	
	/** 点赞数 */
	private Integer praises;
	
	/** 性别:1-男0-女 */
	private Integer sex;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getFollowId() {
		return followId;
	}

	public void setFollowId(Long followId) {
		this.followId = followId;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
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

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}
	
}
