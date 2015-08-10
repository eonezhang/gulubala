package com.penglecode.gulubala.dao.singer.impl;

import org.springframework.stereotype.Repository;

import com.penglecode.gulubala.common.model.Singer;
import com.penglecode.gulubala.dao.BaseMybatisDAO;
import com.penglecode.gulubala.dao.singer.SingerDAO;

@Repository("singerDAO")
public class SingerDAOImpl extends BaseMybatisDAO implements SingerDAO {

	public void insertSinger(Singer singer) {
		getSqlSessionTemplate().insert(getMapperKey("insertSinger"), singer);
	}

	public Singer getSingerById(Long singerId) {
		return getSqlSessionTemplate().selectOne(getMapperKey("getSingerById"), singerId);
	}

	protected Class<?> getBoundModelClass() {
		return Singer.class;
	}

}
