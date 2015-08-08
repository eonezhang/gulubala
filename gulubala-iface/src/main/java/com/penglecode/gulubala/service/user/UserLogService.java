package com.penglecode.gulubala.service.user;

import javax.ws.rs.Path;

import com.penglecode.gulubala.common.model.UserLog;
/**
 * 用户操作日志服务
 * 
 * @author  pengpeng
 * @date 	 2015年8月7日 下午2:39:40
 * @version 1.0
 */
@Path("")
public interface UserLogService {

	public void createLog(UserLog userLog);
	
}
