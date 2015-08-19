package com.penglecode.gulubala.service.music;

import java.util.List;
import java.util.Map;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.penglecode.gulubala.common.consts.ContentType;
import com.penglecode.gulubala.common.model.Music;
import com.penglecode.gulubala.common.support.PagingList;
import com.penglecode.gulubala.service.url.MusicPlayHistoryServiceURL;

/**
 * 用户播放历史服务
 * 
 * @author  pengpeng
 * @date 	 2015年8月18日 下午2:17:24
 * @version 1.0
 */
@Path("")
public interface MusicPlayHistoryService {

	/**
	 * 清除播放历史
	 * @param userId
	 */
	@GET
	@Path(MusicPlayHistoryServiceURL.URL_MUSIC_PLAY_HISTORY_DEL)
	@Produces({ContentType.APPLICATION_JSON_UTF_8})
	public void deleteMusicPlayHistoryByUserId(@PathParam("userId") Long userId);
	
	/**
	 * 获取用户的播放历史列表
	 * @param userId
	 * @return
	 */
	public List<Music> getMusicPlayHistoryByUserId(Long userId);
	
	/**
	 * 获取用户的播放历史列表
	 * @param userId
	 */
	@GET
	@Path(MusicPlayHistoryServiceURL.URL_MUSIC_PLAY_HISTORY_LIST)
	@Produces({ContentType.APPLICATION_JSON_UTF_8})
	public PagingList<Map<String,Object>> getMusicPlayHistoryByUserId(@PathParam("userId") Long userId,
			@DefaultValue("1")@QueryParam("currentPage") Integer currentPage,
			@DefaultValue("10")@QueryParam("pageSize") Integer pageSize);
	
}
