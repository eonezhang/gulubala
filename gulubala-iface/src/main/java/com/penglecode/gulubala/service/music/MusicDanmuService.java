package com.penglecode.gulubala.service.music;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.penglecode.gulubala.common.consts.ContentType;
import com.penglecode.gulubala.common.model.MusicDanmu;
import com.penglecode.gulubala.service.url.MusicDanmuServiceURL;

/**
 * 弹幕服务
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
	 * 显示下一个弹幕
	 * @param danmu
	 * @return
	 */
	@GET
	@Path(MusicDanmuServiceURL.URL_MUSIC_DANMU_SHOW_NEXT)
	@Produces({ContentType.APPLICATION_JSON_UTF_8})
	public MusicDanmu showNextMusicDanmu(@PathParam("musicId")Long musicId);
	
}
