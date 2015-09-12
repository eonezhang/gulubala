package com.penglecode.gulubala.dao.music.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.penglecode.gulubala.common.consts.em.MusicCommentTypeEnum;
import com.penglecode.gulubala.common.model.MusicComment;
import com.penglecode.gulubala.common.mybatis.EscapeFilter;
import com.penglecode.gulubala.common.support.Pager;
import com.penglecode.gulubala.common.util.AppResourceUtils;
import com.penglecode.gulubala.common.util.StringUtils;
import com.penglecode.gulubala.dao.BaseMybatisDAO;
import com.penglecode.gulubala.dao.music.MusicCommentDAO;

@Repository("musicCommentDAO")
public class MusicCommentDAOImpl extends BaseMybatisDAO implements MusicCommentDAO {

	public void insertMusicComment(MusicComment comment) {
		getSqlSessionTemplate().insert(getMapperKey("insertMusicComment"), comment);
	}

	public void deleteMusicCommentById(Long id) {
		getSqlSessionTemplate().delete(getMapperKey("deleteMusicCommentById"), id);
	}

	public void incrMusicCommentPraises(Long id) {
		getSqlSessionTemplate().update(getMapperKey("incrMusicCommentPraises"), id);
	}

	public Integer getMusicCommentPraisesById(Long id) {
		return getSqlSessionTemplate().selectOne(getMapperKey("getMusicCommentPraisesById"), id);
	}
	
	public MusicComment getMusicCommentById(Long id) {
		return getSqlSessionTemplate().selectOne(getMapperKey("getMusicCommentById"), id, new MusicCommentEscapeFilter());
	}

	public List<MusicComment> getMusicCommentsByUserId(Long userId, Integer commentType, Pager pager) {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("userId", userId);
		paramMap.put("musicCommentType", MusicCommentTypeEnum.COMMENT_TYPE_MUSIC.getTypeCode());
		paramMap.put("musicListCommentType", MusicCommentTypeEnum.COMMENT_TYPE_MUSIC_LIST.getTypeCode());
		paramMap.put("commentType", commentType);
		return getSqlSessionTemplate().selectList(getMapperKey("getMusicCommentsByUserId"), paramMap, new MusicCommentEscapeFilter(), pager);
	}

	public List<MusicComment> getMusicCommentsByCommentId(Integer commentType, Long commentId, Pager pager) {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("commentType", commentType);
		paramMap.put("commentId", commentId);
		return getSqlSessionTemplate().selectList(getMapperKey("getMusicCommentsByCommentId"), paramMap, new MusicCommentEscapeFilter(), pager);
	}
	
	public static class MusicCommentEscapeFilter implements EscapeFilter<MusicComment> {

		public void doEscapeFilter(MusicComment element) {
			if(!StringUtils.isEmpty(element.getUserIconUrl())){
				element.setUserIconUrl(AppResourceUtils.getFullPictureUrl(element.getUserIconUrl()));
			}
		}
		
	}

	protected Class<?> getBoundModelClass() {
		return MusicComment.class;
	}

}
