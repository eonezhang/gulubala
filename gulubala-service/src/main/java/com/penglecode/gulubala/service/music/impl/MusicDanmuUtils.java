package com.penglecode.gulubala.service.music.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.penglecode.gulubala.common.exception.BusinessException;
import com.penglecode.gulubala.common.model.MusicDanmu;
import com.penglecode.gulubala.common.support.DanmuMessageItem;
import com.penglecode.gulubala.common.support.DanmuMessageTemplate;
import com.penglecode.gulubala.common.support.Pager;
import com.penglecode.gulubala.common.util.CollectionUtils;
import com.penglecode.gulubala.common.util.XmlUtils;
/**
 * 弹幕工具类
 * 
 * @author  pengpeng
 * @date 	 2015年8月14日 下午11:11:25
 * @version 1.0
 */
public class MusicDanmuUtils {

	private static final DanmuMessageTemplate danmuTemplate;
	
	static {
		Resource resource = new ClassPathResource("danmu-template.xml");
		try {
			String template = IOUtils.toString(resource.getInputStream());
			danmuTemplate = XmlUtils.xml2Object(template, DanmuMessageTemplate.class);
		} catch (IOException e) {
			throw new BusinessException("读取弹幕模板失败!");
		}
	}
	
	public static DanmuMessageTemplate createDanmuMessage(List<MusicDanmu> dataList, Pager pager) {
		DanmuMessageTemplate danmuMessage = new DanmuMessageTemplate();
		danmuMessage.setChatServer(danmuTemplate.getChatServer());
		danmuMessage.setChatId(danmuTemplate.getChatId());
		danmuMessage.setMission(danmuTemplate.getMission());
		danmuMessage.setMaxLimit(danmuTemplate.getMaxLimit());
		danmuMessage.setSource(danmuTemplate.getSource());
		List<DanmuMessageItem> items = new ArrayList<DanmuMessageItem>();
		
		if(!CollectionUtils.isEmpty(dataList)){
			List<DanmuMessageItem> templateItems = danmuTemplate.getItems();
			int templateItemsSize = templateItems.size();
			int start = 0, end = 0;
			int dataSize = dataList.size();
			
			int pageStart = dataSize * (pager.getCurrentPage() - 1);
			int pageEnd = pageStart + dataSize - 1;
			
			if(pageStart < templateItemsSize){
				start = pageStart;
			}else{
				start = pageStart % templateItemsSize;
			}
			
			if(pageEnd < templateItemsSize){
				end = pageEnd;
			}else{
				end = pageEnd % templateItemsSize;
			}
			
			int count = 0;
			if(start < end){
				for(int i = start; i <= end; i++){
					DanmuMessageItem item = new DanmuMessageItem();
					item.setPosition(templateItems.get(i).getPosition());
					item.setContent(dataList.get(count++).getContent());
					items.add(item);
				}
			}else{
				for(int i = start; i <= templateItemsSize - 1; i++){
					DanmuMessageItem item = new DanmuMessageItem();
					item.setPosition(templateItems.get(i).getPosition());
					item.setContent(dataList.get(count++).getContent());
					items.add(item);
				}
				for(int i = 0; i <= end; i++){
					DanmuMessageItem item = new DanmuMessageItem();
					item.setPosition(templateItems.get(i).getPosition());
					item.setContent(dataList.get(count++).getContent());
					items.add(item);
				}
			}
		}
		danmuMessage.setItems(items);
		return danmuMessage;
	}
	
	public static void test1() {
		DanmuMessageTemplate template = danmuTemplate;
		if(template != null && template.getItems() != null){
			for(DanmuMessageItem item : template.getItems()){
				item.setContent("");
			}
		}
		System.out.println(XmlUtils.object2Xml(template));
	}
	
	public static void main(String[] args) {
		List<MusicDanmu> dataList = new ArrayList<MusicDanmu>();
		int currentPage = 6;
		int pageSize = 400;
		int dataSize = 198;
		for(int i = 0; i < dataSize; i++){
			MusicDanmu danmu = new MusicDanmu();
			danmu.setContent("弹幕内容" + i);
			dataList.add(danmu);
		}
		
		Pager pager = new Pager(currentPage, pageSize);
		
		DanmuMessageTemplate danmuMessage = createDanmuMessage(dataList, pager);
		System.out.println(XmlUtils.object2Xml(danmuMessage));
	}
	
}
