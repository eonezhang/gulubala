package com.penglecode.gulubala.dao.music;

import java.util.List;

import com.penglecode.gulubala.common.model.MusicComment;
import com.penglecode.gulubala.common.support.Pager;

/**
 * 音乐评论DAO
 * 
 * @author  pengpeng
 * @date 	 2015年8月17日 上午10:51:17
 * @version 1.0
 */
public interface MusicCommentDAO {

	/**
	 * 新增评论
	 * @param comment
	 */
	public void insertMusicComment(MusicComment comment);
	
	/**
	 * 删除评论
	 * @param id
	 */
	public void deleteMusicCommentById(Long id);
	
	/**
	 * 更新点赞
	 * @param id
	 */
	public void incrMusicCommentPraises(Long id);
	
	/**
	 * 根据评论ID获取评论点赞数
	 * @param id
	 * @return
	 */
	public Integer getMusicCommentPraisesById(Long id);
	
	/**
	 * 根据评论ID获取评论详情
	 * @param id
	 * @return
	 */
	public MusicComment getMusicCommentById(Long id);
	
	/**
	 * 根据用户ID获取用户的评论列表
	 * @param userId			- 必填
	 * @param commentType		- 必填
	 * @param pager				- 分页
	 * @return
	 */
	public List<MusicComment> getMusicCommentsByUserId(Long userId, Integer commentType, Pager pager);
	
	/**
	 * 根据用户ID获取用户的评论列表
	 * @param commentType		- 必填(评论对象类型： 1-歌曲，2-歌单)
	 * @param commentId			- 必填(当commentType=1时为歌曲的ID，当commentType=2时为歌单的ID)
	 * @param pager				- 分页
	 * @return
	 */
	public List<MusicComment> getMusicCommentsByCommentId(Integer commentType, Long commentId, Pager pager);
	
}
