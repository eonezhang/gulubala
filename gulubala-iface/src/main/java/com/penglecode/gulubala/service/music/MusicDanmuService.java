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
import com.penglecode.gulubala.common.model.MusicDanmu;
import com.penglecode.gulubala.common.support.DanmuMessageTemplate;
import com.penglecode.gulubala.service.url.MusicDanmuServiceURL;

/**
 * 音乐弹幕服务
 * 
 * @author  pengpeng
 * @date 	 2015年8月13日 下午8:34:27
 * @version 1.0
 */
@Path("")
public interface MusicDanmuService {

	/**
	 * 创建弹幕
	 * @param danmu
	 * @return
	 */
	@POST
	@Path(MusicDanmuServiceURL.URL_MUSIC_DANMU_CREATE)
	@Consumes({ContentType.APPLICATION_JSON_UTF_8})
	@Produces({ContentType.APPLICATION_JSON_UTF_8})
	public Long createMusicDanmu(MusicDanmu danmu);
	
	/**
	 * 获取下一批弹幕数据给Android客户端
	 * @param musicId			- 必填
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	@GET
	@Path(MusicDanmuServiceURL.URL_MUSIC_DANMU_LIST_ANDROID)
	@Produces({ContentType.APPLICATION_XML_UTF_8})
	public DanmuMessageTemplate getNextMusicDanmuList4Andriod(@PathParam("musicId")Long musicId, 
			@DefaultValue("1")@QueryParam("currentPage") Integer currentPage,
			@DefaultValue("100")@QueryParam("pageSize") Integer pageSize);
	
	/**
	 * 获取下一批弹幕数据给IOS客户端
	 * @param musicId			- 必填
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	@GET
	@Path(MusicDanmuServiceURL.URL_MUSIC_DANMU_LIST_IOS)
	@Produces({ContentType.APPLICATION_XML_UTF_8})
	public DanmuMessageTemplate getNextMusicDanmuList4IOS(@PathParam("musicId")Long musicId, 
			@DefaultValue("1")@QueryParam("currentPage") Integer currentPage,
			@DefaultValue("100")@QueryParam("pageSize") Integer pageSize);

}
