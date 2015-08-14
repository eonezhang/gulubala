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
import com.penglecode.gulubala.common.model.MusicList;
import com.penglecode.gulubala.common.support.PagingList;
import com.penglecode.gulubala.service.url.MusicListServiceURL;

/**
 * 歌单服务
 * 
 * @author  pengpeng
 * @date 	 2015年8月10日 上午10:54:00
 * @version 1.0
 */
@Path("")
public interface MusicListService {

	/**
	 * 创建歌单
	 * @param musicList
	 * @return
	 */
	@POST
	@Path(MusicListServiceURL.URL_MUSIC_LIST_CREATE)
	@Consumes({ContentType.APPLICATION_JSON_UTF_8})
	@Produces({ContentType.APPLICATION_JSON_UTF_8})
	public Long createMusicList(MusicList musicList);
	
	/**
	 * 根据歌单ID获取歌单详情
	 * @param listId
	 * @return
	 */
	@GET
	@Path(MusicListServiceURL.URL_MUSIC_LIST_DETAIL)
	@Produces({ContentType.APPLICATION_JSON_UTF_8})
	public MusicList getMusicById(@PathParam("listId") Long listId);
	
	/**
	 * 获取歌单列表[分页、排序]
	 * @param userId
	 * @param currentPage
	 * @param pageSize
	 * @param orderby
	 * @param order
	 * @return
	 */
	@GET
	@Path(MusicListServiceURL.URL_MUSIC_LIST_LIST)
	@Produces({ContentType.APPLICATION_JSON_UTF_8})
	public PagingList<MusicList> getMusicLists(
			@QueryParam("userId") Long userId,
			@DefaultValue("1")@QueryParam("currentPage") Integer currentPage,
			@DefaultValue("10")@QueryParam("pageSize") Integer pageSize,
			@DefaultValue("createTime")@QueryParam("orderby") String orderby,
			@DefaultValue("DESC")@QueryParam("order") String order);
	
	/**
	 * 给歌单点赞
	 * @param listId
	 * @return
	 */
	@GET
	@Path(MusicListServiceURL.URL_MUSIC_LIST_PRAISE)
	@Produces({ContentType.APPLICATION_JSON_UTF_8})
	public Integer praiseMusicList(@PathParam("listId") Long listId);
	
	/**
	 * 收藏歌单
	 * @param listId
	 * @return
	 */
	@GET
	@Path(MusicListServiceURL.URL_MUSIC_LIST_COLLECT)
	@Produces({ContentType.APPLICATION_JSON_UTF_8})
	public Integer collectMusicList(@PathParam("listId") Long listId);
	
}
