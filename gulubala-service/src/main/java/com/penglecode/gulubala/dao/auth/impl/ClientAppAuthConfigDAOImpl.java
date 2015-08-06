package com.penglecode.gulubala.dao.auth.impl;

import org.springframework.stereotype.Repository;

import com.penglecode.gulubala.common.support.ClientAppAuthConfig;
import com.penglecode.gulubala.dao.BaseMybatisDAO;
import com.penglecode.gulubala.dao.auth.ClientAppAuthConfigDAO;

@Repository("clientAppAuthConfigDAO")
public class ClientAppAuthConfigDAOImpl extends BaseMybatisDAO implements ClientAppAuthConfigDAO {

	public void insertClientAppAuthConfig(ClientAppAuthConfig config) {
		getSqlSessionTemplate().insert(getMapperKey("insertClientAppAuthConfig"), config);
	}

	public void updateClientAppAuthConfig(ClientAppAuthConfig config) {
		getSqlSessionTemplate().update(getMapperKey("insertClientAppAuthConfig"), config);
	}

	public void deleteClientAppAuthConfigById(String appId) {
		getSqlSessionTemplate().delete(getMapperKey("deleteClientAppAuthConfigById"), appId);
	}

	public ClientAppAuthConfig getClientAppAuthConfigById(String appId) {
		return getSqlSessionTemplate().selectOne(getMapperKey("getClientAppAuthConfigById"), appId);
	}

	protected Class<?> getBoundModelClass() {
		return ClientAppAuthConfig.class;
	}

}
