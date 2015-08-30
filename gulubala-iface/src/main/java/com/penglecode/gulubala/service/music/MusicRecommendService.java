package com.penglecode.gulubala.service.music;

import java.util.List;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.penglecode.gulubala.common.consts.ContentType;
import com.penglecode.gulubala.common.model.MusicRecommend;
import com.penglecode.gulubala.common.support.PagingList;
import com.penglecode.gulubala.service.url.MusicRecommendServiceURL;

/**
 * 推荐音乐服务
 * 
 * @author  pengpeng
 * @date 	 2015年8月29日 下午3:12:18
 * @version 1.0
 */
@Path("")
public interface MusicRecommendService {

	/**
	 * 根据推荐分类获取音乐推荐列表(首页接口)[分页、排序]
	 * @param categoryId
	 * @param mediaType		{@link #MediaTypeEnum}
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	@GET
	@Path(MusicRecommendServiceURL.URL_MUSIC_LIST_INDEX)
	@Produces({ContentType.APPLICATION_JSON_UTF_8})
	public PagingList<MusicRecommend> getMusicList4index(
			@QueryParam("categoryId") Integer categoryId,
			@QueryParam("mediaType") Integer mediaType,
			@DefaultValue("1")@QueryParam("currentPage") Integer currentPage,
			@DefaultValue("10")@QueryParam("pageSize") Integer pageSize);
	
	/**
	 * 根据推荐分类获取音乐推荐列表(排行榜接口)[分页、排序]
	 * @param categoryId
	 * @param mediaType		{@link #MediaTypeEnum}
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	@GET
	@Path(MusicRecommendServiceURL.URL_MUSIC_LIST_HOTS)
	@Produces({ContentType.APPLICATION_JSON_UTF_8})
	public PagingList<MusicRecommend> getMusicList4hots(
			@QueryParam("categoryId") Integer categoryId,
			@QueryParam("mediaType") Integer mediaType,
			@DefaultValue("1")@QueryParam("currentPage") Integer currentPage,
			@DefaultValue("10")@QueryParam("pageSize") Integer pageSize);
	
	/**
	 * 获取首页轮播广告列表
	 * @param categoryId
	 * @return
	 */
	@GET
	@Path(MusicRecommendServiceURL.URL_INDEX_ADV_LIST)
	@Produces({ContentType.APPLICATION_JSON_UTF_8})
	public List<MusicRecommend> getIndexAdvList(@QueryParam("categoryId") Integer categoryId);
	
	/**
	 * 获取引导页广告列表
	 * @param categoryId
	 * @return
	 */
	@GET
	@Path(MusicRecommendServiceURL.URL_GUIDE_ADV_LIST)
	@Produces({ContentType.APPLICATION_JSON_UTF_8})
	public List<MusicRecommend> getGuideAdvList(@QueryParam("categoryId") Integer categoryId);
	
}
