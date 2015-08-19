package com.penglecode.gulubala.service.music.impl;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.penglecode.gulubala.common.consts.GlobalConstants;
import com.penglecode.gulubala.common.consts.em.MusicCommentTypeEnum;
import com.penglecode.gulubala.common.model.MusicComment;
import com.penglecode.gulubala.common.support.Pager;
import com.penglecode.gulubala.common.support.PagingList;
import com.penglecode.gulubala.common.support.ValidationAssert;
import com.penglecode.gulubala.common.util.DateTimeUtils;
import com.penglecode.gulubala.dao.music.MusicCommentDAO;
import com.penglecode.gulubala.service.music.MusicCommentService;

@Service("musicCommentService")
public class MusicCommentServiceImpl implements MusicCommentService {

	@Resource(name="musicCommentDAO")
	private MusicCommentDAO musicCommentDAO;
	
	@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRED)
	public Long createMusicComment(MusicComment comment) {
		ValidationAssert.notNull(comment, "请求参数不能为空!");
		ValidationAssert.notNull(comment.getUserId(), "用户ID不能为空!");
		ValidationAssert.notNull(comment.getCommentId(), "评论对象ID不能为空!");
		ValidationAssert.notEmpty(comment.getContent(), "评论不能为空!");
		MusicCommentTypeEnum commentType = MusicCommentTypeEnum.getCommentType(comment.getCommentType());
		ValidationAssert.notNull(commentType, "评论对象类型[commentType]无法解析!!");
		comment.setCommentTime(DateTimeUtils.formatNow());
		comment.setCommentPraises(0);
		if(comment.getParentId() == null || comment.getParentId() < 0){
			comment.setParentId(GlobalConstants.DEFAULT_MUSIC_COMMENT_ROOT_ID);
		}
		musicCommentDAO.insertMusicComment(comment);
		return comment.getId();
	}

	@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRED)
	public void deleteMusicComment(Long id) {
		ValidationAssert.notNull(id, "id不能为空!");
		musicCommentDAO.deleteMusicCommentById(id);
	}

	@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRED)
	public Integer praiseMusicComment(Long id) {
		ValidationAssert.notNull(id, "id不能为空!");
		musicCommentDAO.incrMusicCommentPraises(id);
		return musicCommentDAO.getMusicCommentPraisesById(id);
	}

	public PagingList<MusicComment> getMusicCommentsByUserId(Long userId, Integer commentType, Integer currentPage, Integer pageSize) {
		ValidationAssert.notNull(userId, "用户ID不能为空!");
		ValidationAssert.notNull(commentType, "评论对象类型[commentType]不能为空!");
		List<Integer> commentTypes = Arrays.asList(0,1,2);
		ValidationAssert.isTrue(commentTypes.contains(commentType), "评论对象类型[commentType]无法解析!");
		Pager pager = new Pager(currentPage, pageSize);
		return new PagingList<MusicComment>(musicCommentDAO.getMusicCommentsByUserId(userId, commentType, pager), pager);
	}

	public PagingList<MusicComment> getMusicCommentsByCommentId(Integer commentType, Long commentId, Integer currentPage, Integer pageSize) {
		ValidationAssert.notNull(commentId, "评论对象commentId不能为空!");
		ValidationAssert.notNull(commentType, "评论对象类型[commentType]不能为空!");
		MusicCommentTypeEnum commentTypeEm = MusicCommentTypeEnum.getCommentType(commentType);
		ValidationAssert.notNull(commentTypeEm, "评论对象类型[commentType]无法解析!");
		Pager pager = new Pager(currentPage, pageSize);
		return new PagingList<MusicComment>(musicCommentDAO.getMusicCommentsByCommentId(commentType, commentId, pager), pager);
	}

}
