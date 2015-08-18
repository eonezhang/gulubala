package com.penglecode.gulubala.dao.music.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.penglecode.gulubala.common.model.MusicPlayHistory;
import com.penglecode.gulubala.common.util.DateTimeUtils;
import com.penglecode.gulubala.dao.BaseMybatisDAO;
import com.penglecode.gulubala.dao.music.MusicPlayHistoryDAO;

@Repository("musicPlayHistoryDAO")
public class MusicPlayHistoryDAOImpl extends BaseMybatisDAO implements MusicPlayHistoryDAO {

	public void insertMusicPlayHistory(MusicPlayHistory history) {
		getSqlSessionTemplate().insert(getMapperKey("insertMusicPlayHistory"), history);
	}

	public void updateMusicIds(Long userId, String musicIds) {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("userId", userId);
		paramMap.put("musicIds", musicIds);
		paramMap.put("updateTime", DateTimeUtils.formatNow());
		getSqlSessionTemplate().update(getMapperKey("updateMusicIds"), paramMap);
	}

	public void deleteMusicPlayHistoryByUserId(Long userId) {
		getSqlSessionTemplate().delete(getMapperKey("deleteMusicPlayHistoryByUserId"), userId);
	}

	public MusicPlayHistory getMusicPlayHistoryByUserId(Long userId) {
		return getSqlSessionTemplate().selectOne(getMapperKey("getMusicPlayHistoryByUserId"), userId);
	}

	protected Class<?> getBoundModelClass() {
		return MusicPlayHistory.class;
	}

}
