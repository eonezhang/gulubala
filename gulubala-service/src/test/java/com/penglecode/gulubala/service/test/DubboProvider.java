package com.penglecode.gulubala.service.test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DubboProvider {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{
			"classpath:spring/spring-base.xml",
			"classpath:spring/spring-beans.xml",
			"classpath:spring/spring-dao.xml",
			"classpath:spring/spring-dubbo-provider.xml",
		});
		applicationContext.start();
		System.in.read(); //按任意键退出
	}
	
}
