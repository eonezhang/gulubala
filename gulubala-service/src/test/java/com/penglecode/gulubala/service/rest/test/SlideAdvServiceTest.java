package com.penglecode.gulubala.service.rest.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.GenericType;

import com.penglecode.gulubala.common.model.SlideAdv;
import com.penglecode.gulubala.common.support.Result;
import com.penglecode.gulubala.common.util.JsonUtils;
import com.penglecode.gulubala.common.util.RestServiceUtils;
import com.penglecode.gulubala.service.url.SlideAdvServiceURL;

public class SlideAdvServiceTest {

	public static void testCreateSlideAdv() {
		
		String[] imgs = new String[]{
			"2308f7d3d2.jpg", "13fb90e91d7.jpg", "82d1584f75.jpg", "93d70cf5091.jpg",
			"510fd8f9a1d5.jpg", "9ea15cebf7c.jpg", "2397dd8c30.jpg", "703908fc1d2.jpg"
		};
		for(int i = 0; i < imgs.length; i++){
			SlideAdv adv = new SlideAdv();
			adv.setImgUrl("/img/adv/20150821/" + imgs[i]);
			adv.setTitle("测试广告图片" + (i + 1));
			adv.setOrderIndex(i + 1);
			Result<Object> result = RestServiceUtils.post(SlideAdvServiceURL.URL_SLIDE_ADV_CREATE, adv, new GenericType<Result<Object>>(){});
			System.out.println(JsonUtils.object2Json(result));
		}
	}
	
	public static void testGetSlideAdvList() {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("status", 1);
		Result<List<SlideAdv>> result = RestServiceUtils.get(SlideAdvServiceURL.URL_SLIDE_ADV_LIST, paramMap, new GenericType<Result<List<SlideAdv>>>(){});
		System.out.println(JsonUtils.object2Json(result));
	}
	
	public static void main(String[] args) {
		//testCreateSlideAdv();
		testGetSlideAdvList();
	}

}
