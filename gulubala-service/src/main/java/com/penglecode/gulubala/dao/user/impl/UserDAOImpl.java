package com.penglecode.gulubala.dao.user.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.penglecode.gulubala.common.model.User;
import com.penglecode.gulubala.common.mybatis.EscapeFilter;
import com.penglecode.gulubala.common.util.AppResourceUtils;
import com.penglecode.gulubala.common.util.DateTimeUtils;
import com.penglecode.gulubala.common.util.StringUtils;
import com.penglecode.gulubala.dao.BaseMybatisDAO;
import com.penglecode.gulubala.dao.user.UserDAO;

@Repository("userDAO")
public class UserDAOImpl extends BaseMybatisDAO implements UserDAO {

	public void insertUser(User user) {
		getSqlSessionTemplate().insert(getMapperKey("insertUser"), user);
	}

	public void updateUser4Login(Long userId, String loginTime) {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("userId", userId);
		paramMap.put("loginTime", loginTime);
		getSqlSessionTemplate().update(getMapperKey("updateUser4Login"), paramMap);
	}

	public User getUserById(Long userId) {
		return getSqlSessionTemplate().selectOne(getMapperKey("getUserById"), userId, new UserEscapeFilter());
	}
	
	public User getThinUserById(Long userId) {
		return getSqlSessionTemplate().selectOne(getMapperKey("getThinUserById"), userId);
	}

	public User getUserByMobile(String mobilePhone) {
		return getSqlSessionTemplate().selectOne(getMapperKey("getUserByMobile"), mobilePhone, new UserEscapeFilter());
	}
	
	public User getUserByEmail(String email) {
		return getSqlSessionTemplate().selectOne(getMapperKey("getUserByEmail"), email, new UserEscapeFilter());
	}

	public boolean isMobilePhoneExists(String mobilePhone) {
		return getSqlSessionTemplate().selectOne(getMapperKey("isMobilePhoneExists"), mobilePhone);
	}

	public boolean isEmailExists(String email) {
		return getSqlSessionTemplate().selectOne(getMapperKey("isEmailExists"), email);
	}

	public void incrUserFollows(Long userId) {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("userId", userId);
		paramMap.put("updateTime", DateTimeUtils.formatNow());
		getSqlSessionTemplate().update(getMapperKey("incrUserFollows"), paramMap);
	}
	
	public void decrUserFollows(Long userId) {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("userId", userId);
		paramMap.put("updateTime", DateTimeUtils.formatNow());
		getSqlSessionTemplate().update(getMapperKey("decrUserFollows"), paramMap);
	}

	public void incrUserHots(Long userId) {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("userId", userId);
		paramMap.put("updateTime", DateTimeUtils.formatNow());
		getSqlSessionTemplate().update(getMapperKey("incrUserHots"), paramMap);
	}

	public void incrUserPraises(Long userId) {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("userId", userId);
		paramMap.put("updateTime", DateTimeUtils.formatNow());
		getSqlSessionTemplate().update(getMapperKey("incrUserPraises"), paramMap);
	}

	public static class UserEscapeFilter implements EscapeFilter<User> {

		public void doEscapeFilter(User element) {
			if(!StringUtils.isEmpty(element.getIconUrl())){
				element.setFullIconUrl(AppResourceUtils.getFullPictureUrl(element.getIconUrl()));
			}
		}
		
	}
	
	protected Class<?> getBoundModelClass() {
		return User.class;
	}

}
