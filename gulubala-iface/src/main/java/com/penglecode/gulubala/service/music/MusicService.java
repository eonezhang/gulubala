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
import com.penglecode.gulubala.common.model.Music;
import com.penglecode.gulubala.common.support.PagingList;
import com.penglecode.gulubala.service.url.MusicServiceURL;

/**
 * 音乐服务
 * 
 * @author  pengpeng
 * @date 	 2015年8月10日 上午10:54:00
 * @version 1.0
 */
@Path("")
public interface MusicService {

	/**
	 * 创建音乐
	 * @param music
	 * @return
	 */
	@POST
	@Path(MusicServiceURL.URL_MUSIC_CREATE)
	@Consumes({ContentType.APPLICATION_JSON_UTF_8})
	@Produces({ContentType.APPLICATION_JSON_UTF_8})
	public Long createMusic(Music music);
	
	/**
	 * 根据音乐ID获取音乐详情
	 * @param musicId
	 * @return
	 */
	@GET
	@Path(MusicServiceURL.URL_MUSIC_DETAIL)
	@Produces({ContentType.APPLICATION_JSON_UTF_8})
	public Music getMusicById(@PathParam("musicId") Long musicId);
	
	/**
	 * 根据音乐ID播放音乐
	 * @param musicId
	 * @param userId	- 如果不为空,则需要记录用户的播放历史记录
	 * @param listId	- 如果不为空,则被认为是来自歌单的音乐播放
	 * @param albumId	- 如果不为空,则被认为是来自专辑的音乐播放
	 * @return
	 */
	@GET
	@Path(MusicServiceURL.URL_MUSIC_PLAY)
	@Produces({ContentType.APPLICATION_JSON_UTF_8})
	public Music playMusic(@PathParam("musicId") Long musicId,
			@QueryParam("userId") Long userId,
			@QueryParam("listId") Long listId,
			@QueryParam("albumId") Long albumId);
	
	/**
	 * 根据媒体类型获取音乐列表(首页接口)[分页、排序]
	 * @param mediaType		{@link #MediaTypeEnum}
	 * @param categoryId
	 * @param currentPage
	 * @param pageSize
	 * @param orderby
	 * @param order
	 * @return
	 */
	@GET
	@Path(MusicServiceURL.URL_MUSIC_LIST_INDEX)
	@Produces({ContentType.APPLICATION_JSON_UTF_8})
	public PagingList<Music> getMusicList4index(
			@PathParam("mediaType") Integer mediaType,
			@QueryParam("categoryId") Integer categoryId,
			@DefaultValue("1")@QueryParam("currentPage") Integer currentPage,
			@DefaultValue("10")@QueryParam("pageSize") Integer pageSize,
			@DefaultValue("createTime")@QueryParam("orderby") String orderby,
			@DefaultValue("DESC")@QueryParam("order") String order);
	
	/**
	 * 根据音乐名字关键字模糊搜索(首页接口)[分页、排序]
	 * @param musicName
	 * @param currentPage
	 * @param pageSize
	 * @param orderby
	 * @param order
	 * @return
	 */
	@GET
	@Path(MusicServiceURL.URL_MUSIC_LIST_SEARCH)
	@Produces({ContentType.APPLICATION_JSON_UTF_8})
	public PagingList<Music> getMusicList4search(
			@QueryParam("musicName") String musicName,
			@DefaultValue("1")@QueryParam("currentPage") Integer currentPage,
			@DefaultValue("10")@QueryParam("pageSize") Integer pageSize,
			@DefaultValue("createTime")@QueryParam("orderby") String orderby,
			@DefaultValue("DESC")@QueryParam("order") String order);
	
	/**
	 * 根据分类ID获取排行榜列表(排行榜接口)[分页]
	 * @param mediaType		{@link #MediaTypeEnum}
	 * @param categoryId
	 * @param hotType		- hots,dayHots,threeDayHots,weekHots；默认hots
	 * @param currentPage
	 * @param pageSize
	 * @param orderby
	 * @param order
	 * @return
	 */
	@GET
	@Path(MusicServiceURL.URL_MUSIC_LIST_HOTS)
	@Produces({ContentType.APPLICATION_JSON_UTF_8})
	public PagingList<Music> getMusicList4hots(
			@PathParam("mediaType") Integer mediaType,
			@QueryParam("categoryId") Integer categoryId,
			@DefaultValue("hots")@QueryParam("hotType") String hotType,
			@DefaultValue("1")@QueryParam("currentPage") Integer currentPage,
			@DefaultValue("10")@QueryParam("pageSize") Integer pageSize);
	
	/**
	 * 给音乐点赞
	 * @param musicId
	 * @return
	 */
	@GET
	@Path(MusicServiceURL.URL_MUSIC_PRAISE)
	@Produces({ContentType.APPLICATION_JSON_UTF_8})
	public Integer praiseMusic(@PathParam("musicId") Long musicId);
	
}
