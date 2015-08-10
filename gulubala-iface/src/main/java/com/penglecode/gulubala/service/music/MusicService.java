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
	 * 根据分类ID获取音乐列表(首页接口)[分页、排序]
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
			@QueryParam("categoryId") Integer categoryId,
			@DefaultValue("1")@QueryParam("currentPage") Integer currentPage,
			@DefaultValue("10")@QueryParam("pageSize") Integer pageSize,
			@DefaultValue("createTime")@QueryParam("orderby") String orderby,
			@DefaultValue("DESC")@QueryParam("order") String order);
	
}
