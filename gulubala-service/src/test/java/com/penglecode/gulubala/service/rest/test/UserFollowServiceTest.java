package com.penglecode.gulubala.service.rest.test;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.GenericType;

import com.penglecode.gulubala.common.model.UserFollow;
import com.penglecode.gulubala.common.support.PagingList;
import com.penglecode.gulubala.common.support.Result;
import com.penglecode.gulubala.common.util.JsonUtils;
import com.penglecode.gulubala.common.util.RestServiceUtils;
import com.penglecode.gulubala.service.url.UserFollowServiceURL;

public class UserFollowServiceTest {

	public static void testAddUserFollow() {
		Long[] userIds = new Long[]{2L,3L,4L,5L,6L,7L,9L,10L};
		for(Long userId : userIds){
			for(Long followId : userIds){
				if(!userId.equals(followId)){
					UserFollow userFollow = new UserFollow();
					userFollow.setUserId(userId);
					userFollow.setFollowId(followId);
					Result<Object> result = RestServiceUtils.post(UserFollowServiceURL.URL_USER_FOLLOW_ADD, userFollow, new GenericType<Result<Object>>(){});
					System.out.println(JsonUtils.object2Json(result));
				}
			}
		}
	}
	
	public static void testCancelUserFollow() {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("id", 4);
		Result<Object> result = RestServiceUtils.get(UserFollowServiceURL.URL_USER_FOLLOW_CANCEL, paramMap, new GenericType<Result<Object>>(){});
		System.out.println(JsonUtils.object2Json(result));
	}
	
	public static void testGetUserFollowListByUserId() {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("userId", 2);
		Result<PagingList<UserFollow>> result = RestServiceUtils.get(UserFollowServiceURL.URL_USER_FOLLOW_LIST, paramMap, new GenericType<Result<PagingList<UserFollow>>>(){});
		System.out.println(JsonUtils.object2Json(result));
	}
	
	public static void main(String[] args) {
		//testAddUserFollow();
		//testCancelUserFollow();
		testGetUserFollowListByUserId();
	}
	
}
