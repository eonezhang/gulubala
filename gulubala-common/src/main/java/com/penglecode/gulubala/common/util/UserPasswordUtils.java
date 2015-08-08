package com.penglecode.gulubala.common.util;

import com.penglecode.gulubala.common.consts.GlobalConstants;
import com.penglecode.gulubala.common.model.User;
import com.penglecode.gulubala.common.support.SimpleHash;
import com.penglecode.gulubala.common.support.ValidationAssert;

/**
 * 账户密码加密工具类
 * 
 * @author  pengpeng
 * @date 	 2015年7月29日 上午10:45:27
 * @version 1.0
 */
public class UserPasswordUtils {

	public static String encryptPassword(User user) {
		ValidationAssert.notNull(user, "参数user不能为空!");
		return UserPasswordUtils.encryptPassword(user.getPassword(), UserPasswordUtils.generateSalt(user));
	}
	
	public static String encryptPassword(String password, String salt) {
		ValidationAssert.notEmpty(password, "参数password不能为空!");
		SimpleHash hash = new SimpleHash("md5", password, salt, GlobalConstants.DEFAULT_PASSWORD_HASH_ITERATIONS);
		String encodedPassword = hash.toHex();
		return encodedPassword;
	}
	
	public static String generateSalt(User user) {
		ValidationAssert.notNull(user, "参数user不能为空!");
		ValidationAssert.notEmpty(user.getCreateTime(), "参数user[createTime]不能为空!");
		return user.getCreateTime();
	}
	
}
