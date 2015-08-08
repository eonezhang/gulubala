package com.penglecode.gulubala.service.user.impl;

import javax.annotation.Resource;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.penglecode.gulubala.common.cache.SmsCodeCacheManager;
import com.penglecode.gulubala.common.consts.em.UserRegisterTypeEnum;
import com.penglecode.gulubala.common.consts.em.UserStatusEnum;
import com.penglecode.gulubala.common.model.User;
import com.penglecode.gulubala.common.support.BusinessAssert;
import com.penglecode.gulubala.common.support.ValidationAssert;
import com.penglecode.gulubala.common.util.CommonValidateUtils;
import com.penglecode.gulubala.common.util.DateTimeUtils;
import com.penglecode.gulubala.common.util.StringUtils;
import com.penglecode.gulubala.common.util.UserPasswordUtils;
import com.penglecode.gulubala.dao.user.UserDAO;
import com.penglecode.gulubala.service.user.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource(name="smsCodeCacheManager")
	private SmsCodeCacheManager smsCodeCacheManager;
	
	@Resource(name="userDAO")
	private UserDAO userDAO;
	
	@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRED)
	public Long userRegister4App(User user) {
		ValidationAssert.notNull(user, "请求参数不能为空!");
		ValidationAssert.notNull(user.getRegisterType(), "注册方式[registerType]不能为空!");
		UserRegisterTypeEnum registerType = UserRegisterTypeEnum.getRegisterType(user.getRegisterType());
		ValidationAssert.notNull(registerType, "注册方式[registerType]无法识别!");
		if(UserRegisterTypeEnum.USER_REG_TYPE_MOBILE.equals(registerType)){ //通过手机号码注册
			ValidationAssert.notEmpty(user.getMobilePhone(), "注册手机号码不能为空!");
			ValidationAssert.isTrue(CommonValidateUtils.isMobilePhone(user.getMobilePhone()), "注册手机号码不合法!");
		}else if(UserRegisterTypeEnum.USER_REG_TYPE_EMAIL.equals(registerType)){ //通过邮箱注册
			ValidationAssert.notEmpty(user.getEmail(), "注册邮箱不能为空!");
			ValidationAssert.isTrue(CommonValidateUtils.isEmail(user.getEmail()), "注册邮箱不合法!");
		}
		ValidationAssert.notEmpty(user.getPassword(), "登录密码不能为空!");
		
		/*ValidationAssert.notEmpty(user.getSmsCode(), "验证码不能为空!");
		String smsCode = smsCodeCacheManager.getCache(user.getMobilePhone());
		ValidationAssert.notEmpty(smsCode, "验证码已过期!");
		ValidationAssert.isTrue(user.getSmsCode().equals(smsCode), "验证码不正确!");*/
		
		String nowTime = DateTimeUtils.formatNow();
		user.setCreateTime(nowTime);
		user.setEncryptedPassword(UserPasswordUtils.encryptPassword(user));
		user.setVip(Boolean.FALSE);
		user.setStatus(UserStatusEnum.USER_STATUS_ENABLED.getStatusCode());
		user.setLastLoginTime(nowTime);
		try {
			userDAO.insertUser(user);
		} catch (DuplicateKeyException e) {
			BusinessAssert.isTrue(!e.getCause().getMessage().toLowerCase().contains("uk_users_phone"), "对不起,该手机号码已注册过了!");
			BusinessAssert.isTrue(!e.getCause().getMessage().toLowerCase().contains("uk_users_email"), "对不起,该邮箱已注册过了!");
			throw e;
		}
		return user.getUserId();
	}

	public User userLogin4App(User user) {
		ValidationAssert.notNull(user, "请求参数不能为空!");
		ValidationAssert.isTrue(!(StringUtils.isEmpty(user.getMobilePhone()) && StringUtils.isEmpty(user.getEmail())), "登录手机号码或邮箱不能为空!");
		User puser = null;
		if(!StringUtils.isEmpty(user.getMobilePhone())){ //以手机号码登录
			ValidationAssert.isTrue(CommonValidateUtils.isMobilePhone(user.getMobilePhone()), "登录手机号码不合法!");
			puser = userDAO.getUserByMobile(user.getMobilePhone());
		}else if(!StringUtils.isEmpty(user.getEmail())){ //以邮箱登录
			ValidationAssert.isTrue(CommonValidateUtils.isEmail(user.getEmail()), "登录邮箱不合法!");
			puser = userDAO.getUserByEmail(user.getEmail());
		}
		ValidationAssert.notNull(puser, "登录手机号码或邮箱不存在!");
		user.setCreateTime(puser.getCreateTime());
		String inputEncryptedPassword = UserPasswordUtils.encryptPassword(user);
		ValidationAssert.isTrue(inputEncryptedPassword.equals(puser.getEncryptedPassword()), "登录密码不正确!");
		return puser;
	}

	public User getUserById(Long userId) {
		return userDAO.getUserById(userId);
	}

	public User getUserByAccountName(String accountName) {
		if(!StringUtils.isEmpty(accountName)){
			if(CommonValidateUtils.isMobilePhone(accountName)){
				return userDAO.getUserByMobile(accountName);
			}else if(CommonValidateUtils.isEmail(accountName)){
				return userDAO.getUserByEmail(accountName);
			}
		}
		return null;
	}

	public Boolean isAccountNameExists(String accountName) {
		ValidationAssert.notEmpty(accountName, "手机号码或邮箱不能为空!");
		if(CommonValidateUtils.isMobilePhone(accountName)){
			return userDAO.isMobilePhoneExists(accountName);
		}else if(CommonValidateUtils.isEmail(accountName)){
			return userDAO.isEmailExists(accountName);
		}
		return Boolean.FALSE;
	}
	
}
