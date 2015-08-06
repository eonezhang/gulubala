package com.penglecode.gulubala.dao.user.impl;

import org.springframework.stereotype.Repository;

import com.penglecode.gulubala.common.model.User;
import com.penglecode.gulubala.dao.BaseMybatisDAO;
import com.penglecode.gulubala.dao.user.UserDAO;

@Repository("userDAO")
public class UserDAOImpl extends BaseMybatisDAO implements UserDAO {

	public void insertUser(User user) {
		getSqlSessionTemplate().insert(getMapperKey("insertUser"), user);
	}

	public User getUserById(Long userId) {
		return getSqlSessionTemplate().selectOne(getMapperKey("getUserById"), userId);
	}
	
	public User getThinUserById(Long userId) {
		return getSqlSessionTemplate().selectOne(getMapperKey("getThinUserById"), userId);
	}

	public User getUserByMobile(String mobilePhone) {
		return getSqlSessionTemplate().selectOne(getMapperKey("getUserByMobile"), mobilePhone);
	}
	
	public User getUserByEmail(String email) {
		return getSqlSessionTemplate().selectOne(getMapperKey("getUserByEmail"), email);
	}

	protected Class<?> getBoundModelClass() {
		return User.class;
	}

}
