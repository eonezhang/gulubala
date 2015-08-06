package com.penglecode.gulubala.service.user.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.penglecode.gulubala.common.model.User;
import com.penglecode.gulubala.common.util.JsonUtils;
import com.penglecode.gulubala.service.user.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/spring-base.xml", "classpath:spring/spring-beans.xml", "classpath:spring/spring-dubbo-consumer.xml"})
public class UserServiceTest {

	@Resource(name="userService")
	private UserService userService;
	
	@Test
	public void testUserService(){
		System.out.println(userService);
	}
	
	@Test
	public void testCreateUser(){
		System.out.println("<===============testCreateUser===============>");
		User user = new User();
		user.setMobilePhone("15151887280");
		user.setPassword("123456");
		try {
			userService.userRegister4App(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("<===============testCreateUser===============>");
	}
	
	@Test
	public void testGetUserById(){
		System.out.println("<===============testGetUserById===============>");
		User user = userService.getUserById(1L);
		System.out.println(JsonUtils.object2Json(user));
		System.out.println("<===============testGetUserById===============>");
	}
	
}
