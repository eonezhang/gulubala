package com.penglecode.gulubala.service.music;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.penglecode.gulubala.common.consts.ContentType;
import com.penglecode.gulubala.common.model.MusicComment;
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
	 * @param favoriteType
	 */
	@GET
	@Path(MusicCommentServiceURL.URL_MUSIC_COMMENT_LIST_USER)
	@Produces({ContentType.APPLICATION_JSON_UTF_8})
	public List<MusicComment> getMusicCommentsByUserId(@PathParam("userId") Long userId, @QueryParam("commentType") Integer commentType);
	
}