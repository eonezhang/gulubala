package com.penglecode.gulubala.service.music.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.penglecode.gulubala.common.model.MusicAlbum;
import com.penglecode.gulubala.common.support.ValidationAssert;
import com.penglecode.gulubala.common.util.DateTimeUtils;
import com.penglecode.gulubala.dao.music.MusicAlbumDAO;
import com.penglecode.gulubala.service.music.MusicAlbumService;

@Service("musicAlbumService")
public class MusicAlbumServiceImpl implements MusicAlbumService {

	@Resource(name="musicAlbumDAO")
	private MusicAlbumDAO musicAlbumDAO;
	
	@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRED)
	public Long createMusicAlbum(MusicAlbum album) {
		ValidationAssert.notNull(album, "请求参数不能为空!");
		ValidationAssert.notNull(album.getSingerId(), "所属歌手ID不能为空!");
		album.setPlays(0);
		album.setCreateTime(DateTimeUtils.formatNow());
		musicAlbumDAO.insertMusicAlbum(album);
		return album.getAlbumId();
	}

	public MusicAlbum getMusicAlbumById(Long albumId) {
		return musicAlbumDAO.getMusicAlbumById(albumId);
	}

}
