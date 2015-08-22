package com.penglecode.gulubala.service.category;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.penglecode.gulubala.common.consts.ContentType;
import com.penglecode.gulubala.common.model.MediaCategory;
import com.penglecode.gulubala.service.url.MediaCategoryServiceURL;

/**
 * 媒体通用分类服务
 * 
 * @author  pengpeng
 * @date 	 2015年8月9日 下午2:03:02
 * @version 1.0
 */
@Path("")
public interface MediaCategoryService {

	/**
	 * 创建媒体通用分类
	 * @param category
	 * @return
	 */
	@POST
	@Path(MediaCategoryServiceURL.URL_MEDIA_CATEGORY_CREATE)
	@Consumes({ContentType.APPLICATION_JSON_UTF_8})
	@Produces({ContentType.APPLICATION_JSON_UTF_8})
	public Integer createCategory(MediaCategory category);
	
	/**
	 * 获取媒体通用分类列表(首页接口)
	 * @param category {@link #MediaCategoryEnum}
	 * @return
	 */
	@GET
	@Path(MediaCategoryServiceURL.URL_MEDIA_CATEGORY_LIST_INDEX)
	@Produces({ContentType.APPLICATION_JSON_UTF_8})
	public List<MediaCategory> getCategoryList4index(@PathParam("category") Integer category);
	
}
