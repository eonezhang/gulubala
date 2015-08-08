package com.penglecode.gulubala.service.user.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.penglecode.gulubala.common.model.UserLog;
import com.penglecode.gulubala.dao.user.UserLogDAO;
import com.penglecode.gulubala.service.user.UserLogService;

@Service("userLogService")
public class UserLogServiceImpl implements UserLogService {

	@Resource(name="userLogDAO")
	private UserLogDAO userLogDAO;
	
	@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRED)
	public void createLog(UserLog userLog) {
		userLogDAO.insertUserLog(userLog);
	}

}
