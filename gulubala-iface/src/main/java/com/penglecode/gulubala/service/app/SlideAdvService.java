package com.penglecode.gulubala.service.app;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.penglecode.gulubala.common.consts.ContentType;
import com.penglecode.gulubala.common.model.SlideAdv;
import com.penglecode.gulubala.service.url.SlideAdvServiceURL;

/**
 * 轮播广告服务
 * 
 * @author  pengpeng
 * @date 	 2015年8月21日 下午5:22:05
 * @version 1.0
 */
@Path("")
public interface SlideAdvService {

	/**
	 * 创建轮播广告
	 * @param adv
	 * @return
	 */
	@POST
	@Path(SlideAdvServiceURL.URL_SLIDE_ADV_CREATE)
	@Consumes({ContentType.APPLICATION_JSON_UTF_8})
	@Produces({ContentType.APPLICATION_JSON_UTF_8})
	public Long createAdv(SlideAdv adv);
	
	/**
	 * 获取广告列表
	 * @param status	- 如果为空则获取全部
	 * @return
	 */
	@GET
	@Path(SlideAdvServiceURL.URL_SLIDE_ADV_LIST)
	@Produces({ContentType.APPLICATION_JSON_UTF_8})
	public List<SlideAdv> getSlideAdvList(@DefaultValue("1")@QueryParam("status") Integer status);
	
}
