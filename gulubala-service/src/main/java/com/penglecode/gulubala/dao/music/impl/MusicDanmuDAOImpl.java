package com.penglecode.gulubala.dao.music.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.penglecode.gulubala.common.consts.em.MusicDanmuStatusEnum;
import com.penglecode.gulubala.common.model.MusicDanmu;
import com.penglecode.gulubala.dao.BaseMybatisDAO;
import com.penglecode.gulubala.dao.music.MusicDanmuDAO;

@Repository("musicDanmuDAO")
public class MusicDanmuDAOImpl extends BaseMybatisDAO implements MusicDanmuDAO {

	public void insertMusicDanmu(MusicDanmu danmu) {
		getSqlSessionTemplate().insert(getMapperKey("insertMusicDanmu"), danmu);
	}

	public void updateMusicDanmuStatus(MusicDanmu danmu) {
		getSqlSessionTemplate().update(getMapperKey("updateMusicDanmuStatus"), danmu);
	}

	public MusicDanmu lockNextMusicDanmu4show(Long musicId) {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("musicId", musicId);
		paramMap.put("status", MusicDanmuStatusEnum.DANMU_STATUS_NO.getStatusCode());
		return getSqlSessionTemplate().selectOne(getMapperKey("lockNextMusicDanmu4show"), paramMap);
	}

	protected Class<?> getBoundModelClass() {
		return MusicDanmu.class;
	}

}
