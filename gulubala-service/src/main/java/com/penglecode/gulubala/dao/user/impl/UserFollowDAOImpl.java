package com.penglecode.gulubala.dao.user.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.penglecode.gulubala.common.model.UserFollow;
import com.penglecode.gulubala.common.mybatis.EscapeFilter;
import com.penglecode.gulubala.common.support.Pager;
import com.penglecode.gulubala.common.util.AppResourceUtils;
import com.penglecode.gulubala.common.util.StringUtils;
import com.penglecode.gulubala.dao.BaseMybatisDAO;
import com.penglecode.gulubala.dao.user.UserFollowDAO;

@Repository("userFollowDAO")
public class UserFollowDAOImpl extends BaseMybatisDAO implements UserFollowDAO {

	public void insertUserFollow(UserFollow userFollow) {
		getSqlSessionTemplate().insert(getMapperKey("insertUserFollow"), userFollow);
	}

	public void deleteUserFollowById(Long id) {
		getSqlSessionTemplate().delete(getMapperKey("deleteUserFollowById"), id);
	}

	public UserFollow getUserFollowById(Long id) {
		return getSqlSessionTemplate().selectOne(getMapperKey("getUserFollowById"), id);
	}
	
	public List<UserFollow> getUserFollowListByUserId(Long userId, Pager pager) {
		return getSqlSessionTemplate().selectList(getMapperKey("getUserFollowListByUserId"), userId, new UserFollowEscapeFilter(), pager);
	}

	public static class UserFollowEscapeFilter implements EscapeFilter<UserFollow> {

		public void doEscapeFilter(UserFollow element) {
			if(!StringUtils.isEmpty(element.getIconUrl())){
				element.setIconUrl(AppResourceUtils.getFullPictureUrl(element.getIconUrl()));
			}
		}
		
	}
	
	protected Class<?> getBoundModelClass() {
		return UserFollow.class;
	}

}
