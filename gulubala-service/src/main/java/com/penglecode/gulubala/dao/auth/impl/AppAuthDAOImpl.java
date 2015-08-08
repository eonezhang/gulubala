package com.penglecode.gulubala.dao.auth.impl;

import org.springframework.stereotype.Repository;

import com.penglecode.gulubala.common.support.AppAuth;
import com.penglecode.gulubala.dao.BaseMybatisDAO;
import com.penglecode.gulubala.dao.auth.AppAuthDAO;

@Repository("appAuthDAO")
public class AppAuthDAOImpl extends BaseMybatisDAO implements AppAuthDAO {

	public void insertAppAuth(AppAuth appAuth) {
		getSqlSessionTemplate().insert(getMapperKey("insertAppAuth"), appAuth);
	}

	public void updateAppAuth(AppAuth appAuth) {
		getSqlSessionTemplate().update(getMapperKey("insertAppAuth"), appAuth);
	}

	public void deleteAppAuthById(String appId) {
		getSqlSessionTemplate().delete(getMapperKey("deleteAppAuthById"), appId);
	}

	public AppAuth getAppAuthById(String appId) {
		return getSqlSessionTemplate().selectOne(getMapperKey("getAppAuthById"), appId);
	}

	protected Class<?> getBoundModelClass() {
		return AppAuth.class;
	}

}
