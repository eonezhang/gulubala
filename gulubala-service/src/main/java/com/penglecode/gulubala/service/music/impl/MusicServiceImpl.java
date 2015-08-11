package com.penglecode.gulubala.service.music.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.penglecode.gulubala.common.consts.em.MediaTypeEnum;
import com.penglecode.gulubala.common.model.Music;
import com.penglecode.gulubala.common.support.Pager;
import com.penglecode.gulubala.common.support.PagingList;
import com.penglecode.gulubala.common.support.ValidationAssert;
import com.penglecode.gulubala.common.util.DateTimeUtils;
import com.penglecode.gulubala.dao.music.MusicDAO;
import com.penglecode.gulubala.service.music.MusicService;

@Service("musicService")
public class MusicServiceImpl implements MusicService {

	@Resource(name="musicDAO")
	private MusicDAO musicDAO;
	
	@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRED)
	public Long createMusic(Music music) {
		ValidationAssert.notNull(music, "请求参数不能为空!");
		ValidationAssert.notNull(music.getSingerId(), "所属歌手ID不能为空!");
		ValidationAssert.notNull(music.getAlbumId(), "所属专辑ID不能为空!");
		ValidationAssert.notNull(music.getCategoryId(), "所属分类ID不能为空!");
		music.setHots(0);
		music.setPlays(0);
		music.setPraises(0);
		music.setCollects(0);
		music.setCreateTime(DateTimeUtils.formatNow());
		musicDAO.insertMusic(music);
		return music.getMusicId();
	}

	public Music getMusicById(Long musicId) {
		return musicDAO.getMusicById(musicId);
	}

	public PagingList<Music> getMusicList4index(Integer mediaType,
			Integer categoryId, Integer currentPage, Integer pageSize,
			String orderby, String order) {
		MediaTypeEnum em = MediaTypeEnum.getMediaType(mediaType);
		ValidationAssert.notNull(em, "无法识别的mediaType类型!");
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("mediaType", em.getTypeCode());
		paramMap.put("categoryId", categoryId);
		paramMap.put("orderby", orderby);
		paramMap.put("order", order);
		Pager pager = new Pager(currentPage, pageSize);
		return new PagingList<Music>(musicDAO.getMusicList4index(paramMap, pager), pager);
	}

}
