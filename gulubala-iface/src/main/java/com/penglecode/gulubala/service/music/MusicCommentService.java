package com.penglecode.gulubala.service.music;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.penglecode.gulubala.common.consts.ContentType;
import com.penglecode.gulubala.common.model.MusicComment;
import com.penglecode.gulubala.common.support.PagingList;
import com.penglecode.gulubala.service.url.MusicCommentServiceURL;

/**
 * 音乐评论服务
 * 
 * @author  pengpeng
 * @date 	 2015年8月17日 上午10:29:01
 * @version 1.0
 */
@Path("")
public interface MusicCommentService {

	/**
	 * 创建评论
	 * @param comment
	 * @return
	 */
	@POST
	@Path(MusicCommentServiceURL.URL_MUSIC_COMMENT_CREATE)
	@Consumes({ContentType.APPLICATION_JSON_UTF_8})
	@Produces({ContentType.APPLICATION_JSON_UTF_8})
	public Long createMusicComment(MusicComment comment);
	
	/**
	 * 删除评论
	 * @param id
	 */
	@GET
	@Path(MusicCommentServiceURL.URL_MUSIC_COMMENT_DELETE)
	@Produces({ContentType.APPLICATION_JSON_UTF_8})
	public void deleteMusicComment(@PathParam("id") Long id);
	
	/**
	 * 点赞评论
	 * @param id
	 * @param 返回最新的点赞数
	 */
	@GET
	@Path(MusicCommentServiceURL.URL_MUSIC_COMMENT_PRAISE)
	@Produces({ContentType.APPLICATION_JSON_UTF_8})
	public Integer praiseMusicComment(@PathParam("id") Long id);
	
	/**
	 * 获取用户的评论列表
	 * @param userId
	 * @param commentType	- 0代表音频歌曲评论,1代表MV歌曲评论,2代表歌单评论
	 */
	@GET
	@Path(MusicCommentServiceURL.URL_MUSIC_COMMENT_LIST_USER)
	@Produces({ContentType.APPLICATION_JSON_UTF_8})
	public PagingList<MusicComment> getMusicCommentsByUserId(
			@PathParam("userId") Long userId,
			@PathParam("commentType") Integer commentType,
			@DefaultValue("1") @QueryParam("currentPage") Integer currentPage,
			@DefaultValue("10") @QueryParam("pageSize") Integer pageSize);
	
	/**
	 * 获取歌曲/歌单的评论列表
	 * @param commentType
	 * @param commentId
	 * @return
	 */
	@GET
	@Path(MusicCommentServiceURL.URL_MUSIC_COMMENT_LIST_MUSIC)
	@Produces({ContentType.APPLICATION_JSON_UTF_8})
	public PagingList<MusicComment> getMusicCommentsByCommentId(
			@PathParam("commentType") Integer commentType,
			@PathParam("commentId") Long commentId,
			@DefaultValue("1") @QueryParam("currentPage") Integer currentPage,
			@DefaultValue("10") @QueryParam("pageSize") Integer pageSize);
	
}