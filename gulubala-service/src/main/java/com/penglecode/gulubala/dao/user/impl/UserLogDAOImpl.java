package com.penglecode.gulubala.dao.user.impl;

import org.springframework.stereotype.Repository;

import com.penglecode.gulubala.common.model.UserLog;
import com.penglecode.gulubala.dao.BaseMybatisDAO;
import com.penglecode.gulubala.dao.user.UserLogDAO;

@Repository("userLogDAO")
public class UserLogDAOImpl extends BaseMybatisDAO implements UserLogDAO {

	public void insertUserLog(UserLog userLog) {
		getSqlSessionTemplate().insert(getMapperKey("insertUserLog"), userLog);
	}

	protected Class<?> getBoundModelClass() {
		return UserLog.class;
	}

}
