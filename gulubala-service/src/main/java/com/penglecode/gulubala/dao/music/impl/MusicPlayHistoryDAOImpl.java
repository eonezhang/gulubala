package com.penglecode.gulubala.dao.music.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.penglecode.gulubala.common.model.MusicPlayHistory;
import com.penglecode.gulubala.common.mybatis.EscapeFilter;
import com.penglecode.gulubala.common.support.Pager;
import com.penglecode.gulubala.common.util.AppResourceUtils;
import com.penglecode.gulubala.common.util.StringUtils;
import com.penglecode.gulubala.dao.BaseMybatisDAO;
import com.penglecode.gulubala.dao.music.MusicPlayHistoryDAO;

@Repository("musicPlayHistoryDAO")
public class MusicPlayHistoryDAOImpl extends BaseMybatisDAO implements MusicPlayHistoryDAO {

	public void insertMusicPlayHistory(MusicPlayHistory history) {
		getSqlSessionTemplate().insert(getMapperKey("insertMusicPlayHistory"), history);
	}

	public void deleteMusicPlayHistoryByUserId(Long userId) {
		getSqlSessionTemplate().delete(getMapperKey("deleteMusicPlayHistoryByUserId"), userId);
	}

	public List<Map<String, Object>> getMusicPlayHistoryByUserId(Long userId, Pager pager) {
	    return getSqlSessionTemplate().selectList(getMapperKey("getMusicPlayHistoryByUserId"), userId, new MusicPlayHistoryEscapeFilter(), pager);
	}

	public static class MusicPlayHistoryEscapeFilter implements EscapeFilter<Map<String, Object>> {
	    public void doEscapeFilter(Map<String, Object> element) {
	    	if (element.get("smallPictureUrl") != null && !StringUtils.isEmpty(element.get("smallPictureUrl").toString())) {
	    		element.put("fullSmallPictureUrl", AppResourceUtils.getFullPictureUrl(element.get("smallPictureUrl").toString()));
	    	}
	    }
	}

	protected Class<?> getBoundModelClass() {
		return MusicPlayHistory.class;
	}

}
