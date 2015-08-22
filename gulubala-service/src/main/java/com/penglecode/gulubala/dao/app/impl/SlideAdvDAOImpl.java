package com.penglecode.gulubala.dao.app.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.penglecode.gulubala.common.model.SlideAdv;
import com.penglecode.gulubala.common.mybatis.EscapeFilter;
import com.penglecode.gulubala.common.util.AppResourceUtils;
import com.penglecode.gulubala.common.util.StringUtils;
import com.penglecode.gulubala.dao.BaseMybatisDAO;
import com.penglecode.gulubala.dao.app.SlideAdvDAO;

@Repository("slideAdvDAO")
public class SlideAdvDAOImpl extends BaseMybatisDAO implements SlideAdvDAO {

	public void insertAdv(SlideAdv adv) {
		getSqlSessionTemplate().insert(getMapperKey("insertAdv"), adv);
	}

	public List<SlideAdv> getSlideAdvList(Integer status) {
		return getSqlSessionTemplate().selectList(getMapperKey("getSlideAdvList"), Collections.singletonMap("status", status), new SlideAdvEscapeFilter());
	}
	
	public static class SlideAdvEscapeFilter implements EscapeFilter<SlideAdv> {

		public void doEscapeFilter(SlideAdv element) {
			if(!StringUtils.isEmpty(element.getImgUrl())){
				element.setFullImgUrl(AppResourceUtils.getFullPictureUrl(element.getImgUrl()));
			}
		}
		
	}

	protected Class<?> getBoundModelClass() {
		return SlideAdv.class;
	}

}
