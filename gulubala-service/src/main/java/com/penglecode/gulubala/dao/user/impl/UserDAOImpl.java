package com.penglecode.gulubala.dao.user.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.penglecode.gulubala.common.consts.em.UserUploadMusicCheckStatus;
import com.penglecode.gulubala.common.model.User;
import com.penglecode.gulubala.common.mybatis.EscapeFilter;
import com.penglecode.gulubala.common.util.AppResourceUtils;
import com.penglecode.gulubala.common.util.DateTimeUtils;
import com.penglecode.gulubala.common.util.StringUtils;
import com.penglecode.gulubala.dao.BaseMybatisDAO;
import com.penglecode.gulubala.dao.user.UserDAO;

@Repository("userDAO")
public class UserDAOImpl extends BaseMybatisDAO implements UserDAO {

	public void insertUser(User user) {
		getSqlSessionTemplate().insert(getMapperKey("insertUser"), user);
	}

	public void updateUser4Login(Long userId, String loginTime) {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("userId", userId);
		paramMap.put("loginTime", loginTime);
		getSqlSessionTemplate().update(getMapperKey("updateUser4Login"), paramMap);
	}

	public void updateUserProfile(User user) {
		getSqlSessionTemplate().update(getMapperKey("updateUserProfile"), user);
	}
	
	public void updateUserPassword(User user) {
		getSqlSessionTemplate().update(getMapperKey("updateUserPassword"), user);
	}

	public User getUserById(Long userId) {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("userId", userId);
		paramMap.put("tgStatus", UserUploadMusicCheckStatus.CHECK_STATUS_APPROVED.getStatusCode());
		return getSqlSessionTemplate().selectOne(getMapperKey("getUserById"), paramMap, new UserEscapeFilter());
	}
	
	public User getThinUserById(Long userId) {
		return getSqlSessionTemplate().selectOne(getMapperKey("getThinUserById"), userId);
	}

	public User getThinUserByMobile(String mobilePhone) {
		return getSqlSessionTemplate().selectOne(getMapperKey("getThinUserByMobile"), mobilePhone);
	}

	public User getThinUserByEmail(String email) {
		return getSqlSessionTemplate().selectOne(getMapperKey("getThinUserByEmail"), email);
	}

	public User getUserByMobile(String mobilePhone) {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("mobilePhone", mobilePhone);
		paramMap.put("tgStatus", UserUploadMusicCheckStatus.CHECK_STATUS_APPROVED.getStatusCode());
		return getSqlSessionTemplate().selectOne(getMapperKey("getUserByMobile"), paramMap, new UserEscapeFilter());
	}
	
	public User getUserByEmail(String email) {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("email", email);
		paramMap.put("tgStatus", UserUploadMusicCheckStatus.CHECK_STATUS_APPROVED.getStatusCode());
		return getSqlSessionTemplate().selectOne(getMapperKey("getUserByEmail"), paramMap, new UserEscapeFilter());
	}

	public User getUserBythirdAccount(String thirdAccountName, Integer registerType) {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("thirdAccountName", thirdAccountName);
		paramMap.put("registerType", registerType);
		paramMap.put("tgStatus", UserUploadMusicCheckStatus.CHECK_STATUS_APPROVED.getStatusCode());
		return getSqlSessionTemplate().selectOne(getMapperKey("getUserBythirdAccount"), paramMap, new UserEscapeFilter());
	}

	public boolean isMobilePhoneExists(String mobilePhone) {
		return getSqlSessionTemplate().selectOne(getMapperKey("isMobilePhoneExists"), mobilePhone);
	}

	public boolean isEmailExists(String email) {
		return getSqlSessionTemplate().selectOne(getMapperKey("isEmailExists"), email);
	}

	public void incrUserFollows(Long userId) {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("userId", userId);
		paramMap.put("updateTime", DateTimeUtils.formatNow());
		getSqlSessionTemplate().update(getMapperKey("incrUserFollows"), paramMap);
	}
	
	public void incrUserFas(Long userId) {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("userId", userId);
		paramMap.put("updateTime", DateTimeUtils.formatNow());
		getSqlSessionTemplate().update(getMapperKey("incrUserFas"), paramMap);
	}

	public void decrUserFollows(Long userId) {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("userId", userId);
		paramMap.put("updateTime", DateTimeUtils.formatNow());
		getSqlSessionTemplate().update(getMapperKey("decrUserFollows"), paramMap);
	}

	public void decrUserFas(Long userId) {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("userId", userId);
		paramMap.put("updateTime", DateTimeUtils.formatNow());
		getSqlSessionTemplate().update(getMapperKey("decrUserFas"), paramMap);
	}
	
	public void incrUserHots(Long userId) {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("userId", userId);
		paramMap.put("updateTime", DateTimeUtils.formatNow());
		getSqlSessionTemplate().update(getMapperKey("incrUserHots"), paramMap);
	}

	public void incrUserPraises(Long userId) {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("userId", userId);
		paramMap.put("updateTime", DateTimeUtils.formatNow());
		getSqlSessionTemplate().update(getMapperKey("incrUserPraises"), paramMap);
	}

	public static class UserEscapeFilter implements EscapeFilter<User> {

		public void doEscapeFilter(User element) {
			if(!StringUtils.isEmpty(element.getIconUrl())){
				element.setFullIconUrl(AppResourceUtils.getFullPictureUrl(element.getIconUrl()));
			}
			if(!StringUtils.isEmpty(element.getIdCardFrontUrl())){
				element.setIdCardFrontUrl(AppResourceUtils.getFullPictureUrl(element.getIdCardFrontUrl()));
			}
			if(!StringUtils.isEmpty(element.getIdCardBackUrl())){
				element.setIdCardBackUrl(AppResourceUtils.getFullPictureUrl(element.getIdCardBackUrl()));
			}
		}
		
	}
	
	protected Class<?> getBoundModelClass() {
		return User.class;
	}

}
