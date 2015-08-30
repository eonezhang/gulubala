package com.penglecode.gulubala.service.music.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.penglecode.gulubala.common.consts.GlobalConstants;
import com.penglecode.gulubala.common.consts.em.MediaTypeEnum;
import com.penglecode.gulubala.common.model.MusicRecommend;
import com.penglecode.gulubala.common.support.Pager;
import com.penglecode.gulubala.common.support.PagingList;
import com.penglecode.gulubala.common.support.ValidationAssert;
import com.penglecode.gulubala.dao.music.MusicRecommendDAO;
import com.penglecode.gulubala.service.music.MusicRecommendService;

@Service("musicRecommendService")
public class MusicRecommendServiceImpl implements MusicRecommendService {

	@Resource(name="musicRecommendDAO")
	private MusicRecommendDAO musicRecommendDAO;
	
	public PagingList<MusicRecommend> getMusicList4index(Integer categoryId, Integer mediaType, Integer currentPage, Integer pageSize) {
		Pager pager = new Pager(currentPage, pageSize);
		return new PagingList<MusicRecommend>(getRecommendList(categoryId, mediaType, pager), pager);
	}

	public PagingList<MusicRecommend> getMusicList4hots(Integer categoryId, Integer mediaType, Integer currentPage, Integer pageSize) {
		Pager pager = new Pager(currentPage, pageSize);
		return new PagingList<MusicRecommend>(getRecommendList(categoryId, mediaType, pager), pager);
	}
	
	public List<MusicRecommend> getIndexAdvList(Integer categoryId) {
		if(categoryId == null){
			categoryId = GlobalConstants.GLOBAL_MEDIA_CATEGORY_ID_INDEX_ADV;
		}
		return getRecommendList(categoryId, null, null);
	}
	
	public List<MusicRecommend> getGuideAdvList(Integer categoryId) {
		if(categoryId == null){
			categoryId = GlobalConstants.GLOBAL_MEDIA_CATEGORY_ID_GUIDE_ADV;
		}
		return getRecommendList(categoryId, null, null);
	}
	
	protected List<MusicRecommend> getRecommendList(Integer categoryId, Integer mediaType, Pager pager) {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("categoryId", categoryId);
		if(mediaType != null){
			MediaTypeEnum mediaTypeEm = MediaTypeEnum.getMediaType(mediaType);
			ValidationAssert.notNull(mediaTypeEm, "无法识别的媒体类型mediaType");
			paramMap.put("mediaType", mediaType);
		}
		return musicRecommendDAO.getRecommendList(paramMap, pager);
	}

}
