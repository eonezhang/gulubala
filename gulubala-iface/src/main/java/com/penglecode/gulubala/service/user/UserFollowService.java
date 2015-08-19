package com.penglecode.gulubala.service.user;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.penglecode.gulubala.common.consts.ContentType;
import com.penglecode.gulubala.common.model.UserFollow;
import com.penglecode.gulubala.common.support.PagingList;
import com.penglecode.gulubala.service.url.UserFollowServiceURL;

/**
 * 用户关注服务
 * 
 * @author  pengpeng
 * @date 	 2015年8月19日 下午1:19:42
 * @version 1.0
 */
@Path("")
public interface UserFollowService {

	/**
	 * 添加关注
	 * @param userFollow
	 * @return
	 */
	@POST
	@Path(UserFollowServiceURL.URL_USER_FOLLOW_ADD)
	@Consumes({ContentType.APPLICATION_JSON_UTF_8})
	@Produces({ContentType.APPLICATION_JSON_UTF_8})
	public Long addUserFollow(UserFollow userFollow);
	
	/**
	 * 取消关注
	 * @param id
	 */
	@GET
	@Path(UserFollowServiceURL.URL_USER_FOLLOW_CANCEL)
	@Produces({ContentType.APPLICATION_JSON_UTF_8})
	public void cancelUserFollow(@PathParam("id") Long id);
	
	/**
	 * 我的关注列表
	 * @param id
	 */
	@GET
	@Path(UserFollowServiceURL.URL_USER_FOLLOW_LIST)
	@Produces({ContentType.APPLICATION_JSON_UTF_8})
	public PagingList<UserFollow> getUserFollowListByUserId(
			@PathParam("userId") Long userId,
			@DefaultValue("1") @QueryParam("currentPage") Integer currentPage,
			@DefaultValue("10") @QueryParam("pageSize") Integer pageSize);
	
}
