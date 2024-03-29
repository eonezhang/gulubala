package com.penglecode.gulubala.service.user;

import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.penglecode.gulubala.common.consts.ContentType;
import com.penglecode.gulubala.common.model.User;
import com.penglecode.gulubala.common.model.UserMessage;
import com.penglecode.gulubala.service.url.UserServiceURL;

/**
 * 用户服务
 * 
 * @author  pengpeng
 * @date 	 2015年7月29日 上午9:49:45
 * @version 1.0
 */
@Path("")
public interface UserService {

	/**
	 * APP端用户注册
	 * @param user
	 * @return 返回用户ID
	 */
	@POST
	@Path(UserServiceURL.URL_USER_REGISTER_APP)
	@Consumes({ContentType.APPLICATION_JSON_UTF_8})
	@Produces({ContentType.APPLICATION_JSON_UTF_8})
	public Long userRegister4App(User user);
	
	/**
	 * APP端用户登录
	 * @param user
	 */
	@POST
	@Path(UserServiceURL.URL_USER_LOGIN_APP)
	@Consumes({ContentType.APPLICATION_JSON_UTF_8})
	@Produces({ContentType.APPLICATION_JSON_UTF_8})
	public User userLogin4App(User user);
	
	/**
	 * APP端用户登录(第三方登录)
	 * @param user
	 */
	@POST
	@Path(UserServiceURL.URL_THIRD_USER_LOGIN_APP)
	@Consumes({ContentType.APPLICATION_JSON_UTF_8})
	@Produces({ContentType.APPLICATION_JSON_UTF_8})
	public User thirdUserLogin4App(User user);
	
	/**
	 * 根据用户id获取用户详情信息
	 * @param userId
	 * @return
	 */
	@GET
	@Path(UserServiceURL.URL_USER_DETAIL_USERID)
	@Produces({ContentType.APPLICATION_JSON_UTF_8})
	public User getUserById(@PathParam("userId") Long userId);
	
	/**
	 * 根据手机号或邮箱获取用户详情信息
	 * @param accountName
	 * @return
	 */
	@GET
	@Path(UserServiceURL.URL_USER_DETAIL_ACCOUNTNAME)
	@Produces({ContentType.APPLICATION_JSON_UTF_8})
	public User getUserByAccountName(@PathParam("accountName") String accountName);
	
	/**
	 * 判断手机号或邮箱是否已存在
	 * @param accountName
	 * @return
	 */
	@GET
	@Path(UserServiceURL.URL_USER_ACCOUNTNAME_EXISTS)
	@Produces({ContentType.APPLICATION_JSON_UTF_8})
	public Boolean isAccountNameExists(@PathParam("accountName") String accountName);
	
	/**
	 * 自增用户的被关注数
	 * @param userId
	 */
	@GET
	@Path(UserServiceURL.URL_USER_INCR_FOLLOWS)
	@Produces({ContentType.APPLICATION_JSON_UTF_8})
	public void incrUserFollows(@PathParam("userId") Long userId);
	
	/**
	 * 自增用户的人气数
	 * @param userId
	 */
	@GET
	@Path(UserServiceURL.URL_USER_INCR_HOTS)
	@Produces({ContentType.APPLICATION_JSON_UTF_8})
	public void incrUserHots(@PathParam("userId") Long userId);
	
	/**
	 * 自增用户的点赞数
	 * @param userId
	 */
	@GET
	@Path(UserServiceURL.URL_USER_INCR_PRAISES)
	@Produces({ContentType.APPLICATION_JSON_UTF_8})
	public void incrUserPraises(@PathParam("userId") Long userId);
	
	/**
	 * 修改用户基本信息
	 * @param user
	 */
	@POST
	@Path(UserServiceURL.URL_USER_PROFILE_UPDATE)
	@Consumes({ContentType.APPLICATION_JSON_UTF_8})
	@Produces({ContentType.APPLICATION_JSON_UTF_8})
	public void updateUserProfile(User user);
	
	/**
	 * 用户修改密码
	 * @param parameter
	 */
	@POST
	@Path(UserServiceURL.URL_USER_PASSWORD_UPDATE)
	@Consumes({ContentType.APPLICATION_JSON_UTF_8})
	@Produces({ContentType.APPLICATION_JSON_UTF_8})
	public void updateUserPassword(Map<String,String> parameter);
	
	/**
	 * 重置用户密码
	 * @param parameter
	 */
	@POST
	@Path(UserServiceURL.URL_USER_PASSWORD_RESET)
	@Consumes({ContentType.APPLICATION_JSON_UTF_8})
	@Produces({ContentType.APPLICATION_JSON_UTF_8})
	public void restUserPassword(Map<String,String> parameter);
	
	/**
	 * 用户提交留言信息
	 * @param message
	 */
	@POST
	@Path(UserServiceURL.URL_USER_MESSAGE_SUBMIT)
	@Consumes({ContentType.APPLICATION_JSON_UTF_8})
	@Produces({ContentType.APPLICATION_JSON_UTF_8})
	public Long submitUserMessage(UserMessage message);
	
}
