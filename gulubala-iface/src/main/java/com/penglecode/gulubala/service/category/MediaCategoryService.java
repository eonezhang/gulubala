package com.penglecode.gulubala.service.category;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

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
	 * 根据条件获取媒体通用分类列表
	 * @param parentCategoryId		- 如果不为空则获取该父分类下的子分类,否则获取所有分类列表
	 * @param loadAll				- 在parentCategoryId不为空的情况下:如果为true则获取所有子分类,否则获取parentCategoryId下的直接子分类
	 * @return
	 */
	@GET
	@Path(MediaCategoryServiceURL.URL_MEDIA_CATEGORY_LIST)
	@Produces({ContentType.APPLICATION_JSON_UTF_8})
	public List<MediaCategory> getCategoryList(@QueryParam("parentCategoryId") Integer parentCategoryId, @QueryParam("loadAll") boolean loadAll);
	
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
