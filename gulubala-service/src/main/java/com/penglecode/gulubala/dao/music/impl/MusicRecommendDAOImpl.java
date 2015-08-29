package com.penglecode.gulubala.dao.music.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.penglecode.gulubala.common.model.MusicRecommend;
import com.penglecode.gulubala.common.mybatis.EscapeFilter;
import com.penglecode.gulubala.common.support.Pager;
import com.penglecode.gulubala.common.util.AppResourceUtils;
import com.penglecode.gulubala.common.util.StringUtils;
import com.penglecode.gulubala.dao.BaseMybatisDAO;
import com.penglecode.gulubala.dao.music.MusicRecommendDAO;

@Repository("musicRecommendDAO")
public class MusicRecommendDAOImpl extends BaseMybatisDAO implements MusicRecommendDAO {

	public List<MusicRecommend> getRecommendList(Map<String,Object> paramMap, Pager pager) {
		if(pager == null){
			return getSqlSessionTemplate().selectList(getMapperKey("getRecommendList"), paramMap, new MusicRecommendEscapeFilter());
		}else{
			return getSqlSessionTemplate().selectList(getMapperKey("getRecommendList"), paramMap, new MusicRecommendEscapeFilter(), pager);
		}
	}
	
	public static class MusicRecommendEscapeFilter implements EscapeFilter<MusicRecommend> {

		public void doEscapeFilter(MusicRecommend element) {
			if(!StringUtils.isEmpty(element.getUrl())){
				element.setUrl(AppResourceUtils.getFullFileUrl(element.getUrl()));
			}
			if(!StringUtils.isEmpty(element.getImgUrl())){
				element.setImgUrl(AppResourceUtils.getFullPictureUrl(element.getImgUrl()));
			}
		}
		
	}

	protected Class<?> getBoundModelClass() {
		return MusicRecommend.class;
	}

}
