package com.penglecode.gulubala.dao.user.impl;

import org.springframework.stereotype.Repository;

import com.penglecode.gulubala.common.model.UserMessage;
import com.penglecode.gulubala.dao.BaseMybatisDAO;
import com.penglecode.gulubala.dao.user.UserMessageDAO;

@Repository("userMessageDAO")
public class UserMessageDAOImpl extends BaseMybatisDAO implements UserMessageDAO {

	public void insertUserMessage(UserMessage message) {
		getSqlSessionTemplate().insert(getMapperKey("insertUserMessage"), message);
	}

	protected Class<?> getBoundModelClass() {
		return UserMessage.class;
	}

}
