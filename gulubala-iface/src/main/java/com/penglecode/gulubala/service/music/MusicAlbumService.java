package com.penglecode.gulubala.service.music;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.penglecode.gulubala.common.consts.ContentType;
import com.penglecode.gulubala.common.model.MusicAlbum;
import com.penglecode.gulubala.service.url.MusicAlbumServiceURL;
/**
 * 音乐专辑服务
 * 
 * @author  pengpeng
 * @date 	 2015年8月10日 上午11:59:26
 * @version 1.0
 */
@Path("")
public interface MusicAlbumService {

	/**
	 * 创建音乐专辑
	 * @param musicAlbum
	 * @return
	 */
	@POST
	@Path(MusicAlbumServiceURL.URL_MUSIC_ALBUM_CREATE)
	@Consumes({ContentType.APPLICATION_JSON_UTF_8})
	@Produces({ContentType.APPLICATION_JSON_UTF_8})
	public Long createMusicAlbum(MusicAlbum musicAlbum);
	
	/**
	 * 根据专辑ID获取音乐专辑详情
	 * @param albumId
	 * @return
	 */
	@GET
	@Path(MusicAlbumServiceURL.URL_MUSIC_ALBUM_DETAIL)
	@Produces({ContentType.APPLICATION_JSON_UTF_8})
	public MusicAlbum getMusicAlbumById(@PathParam("albumId") Long albumId);
	
}
