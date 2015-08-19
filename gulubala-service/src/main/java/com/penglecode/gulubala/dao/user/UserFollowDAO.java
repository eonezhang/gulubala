package com.penglecode.gulubala.dao.user;

import java.util.List;

import com.penglecode.gulubala.common.model.UserFollow;
import com.penglecode.gulubala.common.support.Pager;

/**
 * 用户关注DAO
 * 
 * @author  pengpeng
 * @date 	 2015年8月19日 下午1:02:45
 * @version 1.0
 */
public interface UserFollowDAO {

	/**
	 * 新增用户关注
	 * @param userFollow
	 */
	public void insertUserFollow(UserFollow userFollow);
	
	/**
	 * 取消关注
	 * @param id
	 */
	public void deleteUserFollowById(Long id);
	
	/**
	 * 获取详情
	 * @param id
	 * @return
	 */
	public UserFollow getUserFollowById(Long id);
	
	/**
	 * 获取用户的关注列表
	 * @param userId
	 * @param pager
	 * @return
	 */
	public List<UserFollow> getUserFollowListByUserId(Long userId, Pager pager);
	
}
