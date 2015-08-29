package com.penglecode.gulubala.dao.music.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.penglecode.gulubala.common.model.MusicRecommend;
import com.penglecode.gulubala.common.support.Pager;
import com.penglecode.gulubala.dao.BaseMybatisDAO;
import com.penglecode.gulubala.dao.music.MusicRecommendDAO;

@Repository("musicRecommendDAO")
public class MusicRecommendDAOImpl extends BaseMybatisDAO implements MusicRecommendDAO {

	public List<MusicRecommend> getRecommendList(Map<String,Object> paramMap, Pager pager) {
		return getSqlSessionTemplate().selectList(getMapperKey("getRecommendList"), paramMap, pager);
	}

	protected Class<?> getBoundModelClass() {
		return MusicRecommend.class;
	}

}
