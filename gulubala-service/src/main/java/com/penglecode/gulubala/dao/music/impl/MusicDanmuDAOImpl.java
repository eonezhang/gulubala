package com.penglecode.gulubala.dao.music.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.penglecode.gulubala.common.model.MusicDanmu;
import com.penglecode.gulubala.common.support.Pager;
import com.penglecode.gulubala.dao.BaseMybatisDAO;
import com.penglecode.gulubala.dao.music.MusicDanmuDAO;

@Repository("musicDanmuDAO")
public class MusicDanmuDAOImpl extends BaseMybatisDAO implements MusicDanmuDAO {

	public void insertMusicDanmu(MusicDanmu danmu) {
		getSqlSessionTemplate().insert(getMapperKey("insertMusicDanmu"), danmu);
	}

	public List<MusicDanmu> getNextMusicDanmuList(Long musicId, Pager pager) {
		List<MusicDanmu> dataList = new ArrayList<MusicDanmu>();
		List<MusicDanmu> list = null;
		int start = 0, end = 0;
		int offset = pager.getPageSize() * (pager.getCurrentPage() - 1);
		int limit = pager.getPageSize();
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("musicId", musicId);
		int totalCount = getSqlSessionTemplate().selectOne(getMapperKey("getMusicDanmuListCount"), paramMap);
		
		if(totalCount > 0){
			int pageStart = offset;
			int pageEnd = offset + limit;
			
			if(pageStart < totalCount){
				start = pageStart;
			}else{
				if(totalCount > limit){
					start = pageStart % totalCount;
				}else{
					start = totalCount % pageStart;
				}
			}
			
			if(pageEnd < totalCount){
				end = pageEnd;
			}else{
				if(totalCount > limit){
					end = pageEnd % totalCount;
				}else{
					end = totalCount % pageEnd;
				}
			}
			
			if(start < end){
				offset = start;
				limit = end - start;
				if(offset >= 0 && limit > 0){
					paramMap.put("offset", offset);
					paramMap.put("limit", limit);
					list = getSqlSessionTemplate().selectList(getMapperKey("getMusicDanmuList"), paramMap);
					dataList.addAll(list);
				}
			}else{
				offset = start;
				limit = totalCount - start;
				if(offset >= 0 && limit > 0){
					paramMap.put("offset", offset);
					paramMap.put("limit", limit);
					list = getSqlSessionTemplate().selectList(getMapperKey("getMusicDanmuList"), paramMap);
					dataList.addAll(list);
				}
				
				offset = 0;
				limit = end;
				if(offset >= 0 && limit > 0){
					paramMap.put("offset", 0);
					paramMap.put("limit", end);
					list = getSqlSessionTemplate().selectList(getMapperKey("getMusicDanmuList"), paramMap);
					dataList.addAll(list);
				}
			}
		}
		return dataList;
	}

	protected Class<?> getBoundModelClass() {
		return MusicDanmu.class;
	}

}
