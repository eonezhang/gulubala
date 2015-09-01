package com.penglecode.gulubala.service.user.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.penglecode.gulubala.common.cache.ValidateCodeCacheManager;
import com.penglecode.gulubala.common.consts.GlobalConstants;
import com.penglecode.gulubala.common.consts.em.UserRegisterTypeEnum;
import com.penglecode.gulubala.common.consts.em.UserStatusEnum;
import com.penglecode.gulubala.common.model.User;
import com.penglecode.gulubala.common.model.UserMessage;
import com.penglecode.gulubala.common.support.BusinessAssert;
import com.penglecode.gulubala.common.support.ValidationAssert;
import com.penglecode.gulubala.common.util.CommonValidateUtils;
import com.penglecode.gulubala.common.util.DateTimeUtils;
import com.penglecode.gulubala.common.util.StringUtils;
import com.penglecode.gulubala.common.util.UserPasswordUtils;
import com.penglecode.gulubala.dao.user.UserDAO;
import com.penglecode.gulubala.dao.user.UserMessageDAO;
import com.penglecode.gulubala.service.user.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource(name="validateCodeCacheManager")
	private ValidateCodeCacheManager validateCodeCacheManager;
	
	@Resource(name="userDAO")
	private UserDAO userDAO;
	
	@Resource(name="userMessageDAO")
	private UserMessageDAO userMessageDAO;
	
	@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRED)
	public Long userRegister4App(User user) {
		ValidationAssert.notNull(user, "请求参数不能为空!");
		ValidationAssert.notNull(user.getRegisterType(), "注册方式[registerType]不能为空!");
		UserRegisterTypeEnum registerType = UserRegisterTypeEnum.getRegisterType(user.getRegisterType());
		ValidationAssert.notNull(registerType, "注册方式[registerType]无法识别!");
		String recipient = null;
		if(UserRegisterTypeEnum.USER_REG_TYPE_MOBILE.equals(registerType)){ //通过手机号码注册
			ValidationAssert.notEmpty(user.getMobilePhone(), "注册手机号码不能为空!");
			ValidationAssert.isTrue(CommonValidateUtils.isMobilePhone(user.getMobilePhone()), "注册手机号码不合法!");
			user.setEmail(null);
			recipient = user.getMobilePhone();
		}else if(UserRegisterTypeEnum.USER_REG_TYPE_EMAIL.equals(registerType)){ //通过邮箱注册
			ValidationAssert.notEmpty(user.getEmail(), "注册邮箱不能为空!");
			ValidationAssert.isTrue(CommonValidateUtils.isEmail(user.getEmail()), "注册邮箱不合法!");
			user.setMobilePhone(null);
			recipient = user.getEmail();
		}
		ValidationAssert.notEmpty(user.getPassword(), "登录密码不能为空!");
		ValidationAssert.notEmpty(user.getValidateCode(), "验证码不能为空!");
		String validateCode = validateCodeCacheManager.getCache(recipient);
		ValidationAssert.notEmpty(validateCode, "验证码已过期!");
		ValidationAssert.isTrue(user.getValidateCode().equals(validateCode), "验证码不正确!");
		
		String nowTime = DateTimeUtils.formatNow();
		user.setCreateTime(nowTime);
		user.setEncryptedPassword(UserPasswordUtils.encryptPassword(user.getPassword()));
		user.setVip(Boolean.FALSE);
		user.setStatus(UserStatusEnum.USER_STATUS_ENABLED.getStatusCode());
		user.setLastLoginTime(nowTime);
		user.setIconUrl(GlobalConstants.DEFAULT_USER_ICON);
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
		String inputEncryptedPassword = UserPasswordUtils.encryptPassword(user.getPassword());
		ValidationAssert.isTrue(inputEncryptedPassword.equals(puser.getEncryptedPassword()), "登录密码不正确!");
		userDAO.updateUser4Login(puser.getUserId(), DateTimeUtils.formatNow());
		return puser;
	}
	
	@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRED)
	public User thirdUserLogin4App(User user) {
		ValidationAssert.notNull(user, "请求参数不能为空!");
		ValidationAssert.notEmpty(user.getThirdAccountName(), "第三方账号不能为空!");
		ValidationAssert.notEmpty(user.getRegisterType(), "第三方账号类型不能为空!");
		String nowTime = DateTimeUtils.formatNow();
		User puser = userDAO.getUserBythirdAccount(user.getThirdAccountName(), user.getRegisterType());
		if(puser == null){ //首次使用第三方账号登录
			user.setCreateTime(nowTime);
			user.setVip(Boolean.FALSE);
			user.setStatus(UserStatusEnum.USER_STATUS_ENABLED.getStatusCode());
			user.setLastLoginTime(nowTime);
			user.setIconUrl(StringUtils.defaultIfEmpty(user.getIconUrl(), GlobalConstants.DEFAULT_USER_ICON));
			userDAO.insertUser(user);
			puser = userDAO.getUserById(user.getUserId());
		}
		userDAO.updateUser4Login(puser.getUserId(), nowTime);
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
		}else{
			ValidationAssert.isTrue(false, "无法识别的账户名!");
		}
		return Boolean.FALSE;
	}

	public void incrUserFollows(Long userId) {
		ValidationAssert.notNull(userId, "用户ID不能为空!");
		userDAO.incrUserFollows(userId);
	}

	public void incrUserHots(Long userId) {
		ValidationAssert.notNull(userId, "用户ID不能为空!");
		userDAO.incrUserHots(userId);
	}

	public void incrUserPraises(Long userId) {
		ValidationAssert.notNull(userId, "用户ID不能为空!");
		userDAO.incrUserPraises(userId);
	}

	@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRED)
	public void updateUserProfile(User user) {
		ValidationAssert.notNull(user, "请求参数不能为空!");
		userDAO.updateUserProfile(user);
	}

	@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRED)
	public void updateUserPassword(Map<String, String> parameter) {
		ValidationAssert.notNull(parameter, "请求参数不能为空!");
		ValidationAssert.notEmpty(parameter.get("userId"), "用户ID不能为空!");
		ValidationAssert.notEmpty(parameter.get("oldPassword"), "旧密码不能为空!");
		ValidationAssert.notEmpty(parameter.get("newPassword"), "新密码不能为空!");
		Long userId = Long.parseLong(parameter.get("userId"));
		String oldPassword = parameter.get("oldPassword");
		String newPassword = parameter.get("newPassword");
		
		User puser = userDAO.getThinUserById(userId);
		ValidationAssert.notNull(puser, "该用户已不存在!");
		
		User user = new User();
		user.setUserId(puser.getUserId());
		user.setPassword(oldPassword);
		user.setCreateTime(puser.getCreateTime());
		String encryptedOldPassword = UserPasswordUtils.encryptPassword(user.getPassword());
		ValidationAssert.isTrue(encryptedOldPassword.equals(puser.getEncryptedPassword()), "旧密码输入不正确!");
		
		user.setPassword(newPassword);
		String encryptedNewPassword = UserPasswordUtils.encryptPassword(user.getPassword());
		user.setEncryptedPassword(encryptedNewPassword);
		user.setUpdateTime(DateTimeUtils.formatNow());
		userDAO.updateUserPassword(user);
	}

	@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRED)
	public void restUserPassword(Map<String, String> parameter) {
		ValidationAssert.notNull(parameter, "请求参数不能为空!");
		ValidationAssert.notEmpty(parameter.get("validateCode"), "验证码不能为空!");
		ValidationAssert.notEmpty(parameter.get("newPassword"), "新密码不能为空!");
		ValidationAssert.notEmpty(parameter.get("accountName"), "手机号码或邮箱不能为空!");
		String validateCode = parameter.get("validateCode");
		String accountName = parameter.get("accountName");
		String newPassword = parameter.get("newPassword");
		User user = null;
		if(CommonValidateUtils.isMobilePhone(accountName)){
			user = userDAO.getThinUserByMobile(accountName);
		}else if(CommonValidateUtils.isEmail(accountName)){
			user = userDAO.getThinUserByEmail(accountName);
		}else{
			ValidationAssert.isTrue(false, "无法识别的账户名!(必须是手机号或Email)");
		}
		ValidationAssert.notNull(user, "该用户已不存在!");
		
		String recipient = accountName;
		String realValidateCode = validateCodeCacheManager.getCache(recipient);
		ValidationAssert.notEmpty(realValidateCode, "验证码已过期!");
		ValidationAssert.isTrue(validateCode.equals(realValidateCode), "验证码不正确!");
		
		user.setPassword(newPassword);
		String encryptedNewPassword = UserPasswordUtils.encryptPassword(user.getPassword());
		user.setEncryptedPassword(encryptedNewPassword);
		user.setUpdateTime(DateTimeUtils.formatNow());
		userDAO.updateUserPassword(user);
	}

	@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRED)
	public Long submitUserMessage(UserMessage message) {
		ValidationAssert.notNull(message, "请求参数不能为空!");
		message.setCreateTime(DateTimeUtils.formatNow());
		userMessageDAO.insertUserMessage(message);
		return message.getId();
	}
	
}
