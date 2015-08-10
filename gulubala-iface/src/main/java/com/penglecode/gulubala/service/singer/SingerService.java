package com.penglecode.gulubala.service.singer;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.penglecode.gulubala.common.consts.ContentType;
import com.penglecode.gulubala.common.model.Singer;
import com.penglecode.gulubala.service.url.SingerServiceURL;

/**
 * 歌手服务
 * 
 * @author  pengpeng
 * @date 	 2015年8月10日 上午10:54:00
 * @version 1.0
 */
@Path("")
public interface SingerService {

	/**
	 * 创建歌手
	 * @param singer
	 * @return
	 */
	@POST
	@Path(SingerServiceURL.URL_SINGER_CREATE)
	@Consumes({ContentType.APPLICATION_JSON_UTF_8})
	@Produces({ContentType.APPLICATION_JSON_UTF_8})
	public Long createSinger(Singer singer);
	
	/**
	 * 根据歌手ID获取歌手详情
	 * @param singerId
	 * @return
	 */
	@GET
	@Path(SingerServiceURL.URL_SINGER_DETAIL)
	@Produces({ContentType.APPLICATION_JSON_UTF_8})
	public Singer getSingerById(@PathParam("singerId") Long singerId);
	
}
