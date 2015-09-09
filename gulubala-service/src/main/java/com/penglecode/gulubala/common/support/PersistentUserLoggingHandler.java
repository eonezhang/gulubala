package com.penglecode.gulubala.common.support;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.penglecode.gulubala.common.resteasy.AbstractUserLoggingHandler;
import com.penglecode.gulubala.common.model.UserLog;
import com.penglecode.gulubala.common.util.JsonUtils;
import com.penglecode.gulubala.service.user.UserLogService;

@Component
public class PersistentUserLoggingHandler extends AbstractUserLoggingHandler {

	private static final Logger logger = LoggerFactory.getLogger(PersistentUserLoggingHandler.class);

	@Resource(name="userLogService")
	private UserLogService userLogService;
	
	public void handleUserLogging(UserLog userLog) {
		logger.info(">>>[PersistentUserLoggingHandler] 记录用户操作日志：" + JsonUtils.object2Json(userLog));
		userLogService.createLog(userLog);
	}

}
