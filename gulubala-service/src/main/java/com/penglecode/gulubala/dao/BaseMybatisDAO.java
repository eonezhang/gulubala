package com.penglecode.gulubala.dao;

import javax.annotation.Resource;

import com.penglecode.gulubala.common.mybatis.EnhancedSqlSession;
import com.penglecode.gulubala.common.mybatis.MybatisUtils;

/**
 * DAO基类
 * 
 * @author	  	pengpeng
 * @date	  	2014年10月31日 下午1:18:55
 * @version  	1.0
 */
public abstract class BaseMybatisDAO {

	@Resource(name="defaultSqlSessionTemplate")
	private EnhancedSqlSession sqlSessionTemplate;

	protected EnhancedSqlSession getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}
	
	protected String getMapperKey(Class<?> modelClass, String key) {
		return MybatisUtils.getMapperKey(modelClass, key);
	}
	
	protected String getMapperKey(String key) {
		return getMapperKey(getBoundModelClass(), key);
	}
	
	/**
	 * 获取绑定在当前DAO上的实体Class
	 * @return
	 */
	protected abstract Class<?> getBoundModelClass();
	
}
