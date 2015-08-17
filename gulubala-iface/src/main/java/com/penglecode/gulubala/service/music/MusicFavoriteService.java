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
import com.penglecode.gulubala.common.model.MusicFavorite;
import com.penglecode.gulubala.service.url.MusicFavoriteServiceURL;

/**
 * 音乐收藏服务
 * 
 * @author  pengpeng
 * @date 	 2015年8月14日 下午1:41:04
 * @version 1.0
 */
@Path("")
public interface MusicFavoriteService {

	/**
	 * 创建收藏
	 * @param favorite
	 * @return
	 */
	@POST
	@Path(MusicFavoriteServiceURL.URL_MUSIC_FAVORITE_CREATE)
	@Consumes({ContentType.APPLICATION_JSON_UTF_8})
	@Produces({ContentType.APPLICATION_JSON_UTF_8})
	public Long createMusicFavorite(MusicFavorite favorite);
	
	/**
	 * 删除收藏
	 * @param id
	 */
	@GET
	@Path(MusicFavoriteServiceURL.URL_MUSIC_FAVORITE_DELETE)
	@Produces({ContentType.APPLICATION_JSON_UTF_8})
	public void deleteMusicFavorite(@PathParam("id") Long id);
	
	/**
	 * 获取用户的收藏列表
	 * @param userId
	 * @param favoriteType
	 */
	@GET
	@Path(MusicFavoriteServiceURL.URL_MUSIC_FAVORITE_LIST_USER)
	@Produces({ContentType.APPLICATION_JSON_UTF_8})
	public List<MusicFavorite> getMusicFavoritesByUserId(@PathParam("userId") Long userId, @QueryParam("favoriteType") Integer favoriteType);
	
}
