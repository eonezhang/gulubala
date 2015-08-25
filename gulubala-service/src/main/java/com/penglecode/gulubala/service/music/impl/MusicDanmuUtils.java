package com.penglecode.gulubala.service.music.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;

import com.penglecode.gulubala.common.exception.BusinessException;
import com.penglecode.gulubala.common.model.MusicDanmu;
import com.penglecode.gulubala.common.support.DanmuMsgItem4Andriod;
import com.penglecode.gulubala.common.support.DanmuMsgItem4IOS;
import com.penglecode.gulubala.common.support.DanmuMsgTpl4Andriod;
import com.penglecode.gulubala.common.support.DanmuMsgTpl4IOS;
import com.penglecode.gulubala.common.support.Pager;
import com.penglecode.gulubala.common.util.CollectionUtils;
import com.penglecode.gulubala.common.util.Jaxb2Utils;
import com.penglecode.gulubala.common.util.StringUtils;
/**
 * 弹幕工具类
 * 
 * @author  pengpeng
 * @date 	 2015年8月14日 下午11:11:25
 * @version 1.0
 */
public class MusicDanmuUtils {

	private static final DanmuMsgTpl4Andriod danmuTemplate4Andriod;
	
	private static final DanmuMsgTpl4IOS danmuTemplate4IOS;
	
	static {
		try {
			String template = null;
			template = IOUtils.toString(new ClassPathResource("danmu-tpl-andriod.xml").getInputStream());
			danmuTemplate4Andriod = Jaxb2Utils.xml2Object(template, DanmuMsgTpl4Andriod.class);
			
			template = IOUtils.toString(new ClassPathResource("danmu-tpl-ios.xml").getInputStream());
			danmuTemplate4IOS = Jaxb2Utils.xml2Object(template, DanmuMsgTpl4IOS.class);
		} catch (IOException e) {
			throw new BusinessException("读取弹幕模板失败!");
		}
	}
	
	public static DanmuMsgTpl4Andriod createDanmuMsg4Andriod(List<MusicDanmu> dataList, Pager pager) {
		DanmuMsgTpl4Andriod danmuMessage = new DanmuMsgTpl4Andriod();
		danmuMessage.setChatServer(danmuTemplate4Andriod.getChatServer());
		danmuMessage.setChatId(danmuTemplate4Andriod.getChatId());
		danmuMessage.setMission(danmuTemplate4Andriod.getMission());
		danmuMessage.setMaxLimit(danmuTemplate4Andriod.getMaxLimit());
		danmuMessage.setSource(danmuTemplate4Andriod.getSource());
		List<DanmuMsgItem4Andriod> items = new ArrayList<DanmuMsgItem4Andriod>();
		
		if(!CollectionUtils.isEmpty(dataList)){
			List<DanmuMsgItem4Andriod> templateItems = danmuTemplate4Andriod.getItems();
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
					DanmuMsgItem4Andriod item = new DanmuMsgItem4Andriod();
					item.setPosition(templateItems.get(i).getPosition());
					item.setContent(StringUtils.defaultIfEmpty(dataList.get(count++).getContent(), ""));
					items.add(item);
				}
			}else{
				for(int i = start; i <= templateItemsSize - 1; i++){
					DanmuMsgItem4Andriod item = new DanmuMsgItem4Andriod();
					item.setPosition(templateItems.get(i).getPosition());
					item.setContent(StringUtils.defaultIfEmpty(dataList.get(count++).getContent(), ""));
					items.add(item);
				}
				for(int i = 0; i <= end; i++){
					DanmuMsgItem4Andriod item = new DanmuMsgItem4Andriod();
					item.setPosition(templateItems.get(i).getPosition());
					item.setContent(StringUtils.defaultIfEmpty(dataList.get(count++).getContent(), ""));
					items.add(item);
				}
			}
		}
		danmuMessage.setItems(items);
		return danmuMessage;
	}
	
	public static DanmuMsgTpl4IOS createDanmuMsg4IOS(List<MusicDanmu> dataList, Pager pager) {
		DanmuMsgTpl4IOS danmuMessage = new DanmuMsgTpl4IOS();
		List<DanmuMsgItem4IOS> items = new ArrayList<DanmuMsgItem4IOS>();
		
		if(!CollectionUtils.isEmpty(dataList)){
			List<DanmuMsgItem4IOS> templateItems = danmuTemplate4IOS.getItems();
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
					DanmuMsgItem4IOS item = new DanmuMsgItem4IOS();
					item.setString(templateItems.get(i).getString());
					item.setMvalue(StringUtils.defaultIfEmpty(dataList.get(count++).getContent(), ""));
					items.add(item);
				}
			}else{
				for(int i = start; i <= templateItemsSize - 1; i++){
					DanmuMsgItem4IOS item = new DanmuMsgItem4IOS();
					item.setString(templateItems.get(i).getString());
					item.setMvalue(StringUtils.defaultIfEmpty(dataList.get(count++).getContent(), ""));
					items.add(item);
				}
				for(int i = 0; i <= end; i++){
					DanmuMsgItem4IOS item = new DanmuMsgItem4IOS();
					item.setString(templateItems.get(i).getString());
					item.setMvalue(StringUtils.defaultIfEmpty(dataList.get(count++).getContent(), ""));
					items.add(item);
				}
			}
		}
		danmuMessage.setItems(items);
		return danmuMessage;
	}
	
	public static void testCreateTpl4Andriod() {
		DanmuMsgTpl4Andriod template = danmuTemplate4Andriod;
		if(template != null && template.getItems() != null){
			for(DanmuMsgItem4Andriod item : template.getItems()){
				item.setContent("");
			}
		}
		System.out.println(Jaxb2Utils.object2Xml(template));
	}
	
	public static void testCreateDanmuMsg4Andriod() {
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
		
		DanmuMsgTpl4Andriod danmuMessage = createDanmuMsg4Andriod(dataList, pager);
		System.out.println(Jaxb2Utils.object2Xml(danmuMessage));
	}
	
	public static void testCreateTpl4IOS() {
		DanmuMsgTpl4IOS template = danmuTemplate4IOS;
		if(template != null && template.getItems() != null){
			for(DanmuMsgItem4IOS item : template.getItems()){
				item.setMvalue("");
			}
		}
		System.out.println(Jaxb2Utils.object2Xml(template));
	}
	
	public static void testCreateDanmuMsg4IOS() {
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
		
		DanmuMsgTpl4IOS danmuMessage = createDanmuMsg4IOS(dataList, pager);
		System.out.println(Jaxb2Utils.object2Xml(danmuMessage));
	}
	
	public static void main(String[] args) {
		//testCreateDanmuMsg4Andriod();
		//testCreateTpl4IOS();
		testCreateDanmuMsg4IOS();
	}
	
}
