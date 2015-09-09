package com.penglecode.gulubala.service.user.impl;

import javax.annotation.Resource;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.penglecode.gulubala.common.model.UserFollow;
import com.penglecode.gulubala.common.support.BusinessAssert;
import com.penglecode.gulubala.common.support.Pager;
import com.penglecode.gulubala.common.support.PagingList;
import com.penglecode.gulubala.common.support.ValidationAssert;
import com.penglecode.gulubala.common.util.DateTimeUtils;
import com.penglecode.gulubala.dao.user.UserDAO;
import com.penglecode.gulubala.dao.user.UserFollowDAO;
import com.penglecode.gulubala.service.user.UserFollowService;

@Service("userFollowService")
public class UserFollowServiceImpl implements UserFollowService {

	@Resource(name="userDAO")
	private UserDAO userDAO;
	
	@Resource(name="userFollowDAO")
	private UserFollowDAO userFollowDAO;
	
	@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRED)
	public Long addUserFollow(UserFollow userFollow) {
		ValidationAssert.notNull(userFollow, "请求参数不能为空!");
		ValidationAssert.notNull(userFollow.getUserId(), "用户ID不能为空!");
		ValidationAssert.notNull(userFollow.getFollowId(), "被关注用户ID不能为空!");
		ValidationAssert.isTrue(!userFollow.getUserId().equals(userFollow.getFollowId()), "亲，自己是不能关注自己的!");
		userFollow.setCreateTime(DateTimeUtils.formatNow());
		try {
			userFollowDAO.insertUserFollow(userFollow);
			userDAO.incrUserFollows(userFollow.getUserId()); //增加当前用户的关注他人数
			userDAO.incrUserFas(userFollow.getFollowId()); //增加被关注用户的被关注数
		} catch (DuplicateKeyException e) {
			BusinessAssert.isTrue(!e.getCause().getMessage().toLowerCase().contains("uk_user_follows"), "亲，该用户您已经关注过了!");
			throw e;
		}
		return userFollow.getId();
	}

	@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRED)
	public void cancelUserFollow(Long id) {
		ValidationAssert.notNull(id, "关注ID不能为空!");
		UserFollow userFollow = userFollowDAO.getUserFollowById(id);
		if(userFollow != null){
			userFollowDAO.deleteUserFollowById(id);
			userDAO.decrUserFollows(userFollow.getUserId()); //减少当前用户的关注他人数
			userDAO.decrUserFas(userFollow.getFollowId()); //减少被关注用户的被关注数
		}
	}

	public PagingList<UserFollow> getUserFollowListByUserId(Long userId, Integer currentPage, Integer pageSize) {
		ValidationAssert.notNull(userId, "用户ID不能为空!");
		Pager pager = new Pager(currentPage, pageSize);
		return new PagingList<UserFollow>(userFollowDAO.getUserFollowListByUserId(userId, pager), pager);
	}

}
