package com.penglecode.gulubala.service.rest.test;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.GenericType;

import com.penglecode.gulubala.common.model.Music;
import com.penglecode.gulubala.common.support.PagingList;
import com.penglecode.gulubala.common.support.Result;
import com.penglecode.gulubala.common.util.JsonUtils;
import com.penglecode.gulubala.common.util.RestServiceUtils;
import com.penglecode.gulubala.service.url.MusicServiceURL;

public class MusicServiceTest {

	public static void testCreateMusic() {
		Long singerId = 3L;
		Result<Object> result = null;
		Music album = null;
		album = new Music();
		album.setMusicName("算什么男人");
		album.setZuoqu("周杰伦");
		album.setZuoci("周杰伦");
		album.setBianqu("周杰伦");
		album.setSingerId(singerId);
		album.setAlbumId(13L);
		album.setOriginalSong(true);
		album.setOverrideSong(false);
		album.setMv(false);
		album.setPublisher("杰威尔音乐有限公司");
		album.setPublishTime("2015-07-03");
		album.setCategoryId(3);
		album.setLrcUrl("/file/music/20150810/2163441.lrc");
		album.setSmallPictureUrl("/img/album/20150810/4024f1a40.jpg");
		album.setPictureUrl("/img/album/20150810/4024f1a40.jpg");
		album.setMusicUrl("/file/music/20150810/2163441.mp3");
		result = RestServiceUtils.post(MusicServiceURL.URL_MUSIC_CREATE, album, new GenericType<Result<Object>>(){});
		System.out.println(result);
		
		album = new Music();
		album.setMusicName("手写的从前");
		album.setZuoqu("周杰伦");
		album.setZuoci("周杰伦");
		album.setBianqu("周杰伦");
		album.setSingerId(singerId);
		album.setAlbumId(13L);
		album.setOriginalSong(true);
		album.setOverrideSong(false);
		album.setMv(false);
		album.setPublisher("杰威尔音乐有限公司");
		album.setPublishTime("2015-05-01");
		album.setCategoryId(3);
		album.setLrcUrl("/file/music/20150810/2163441.lrc");
		album.setSmallPictureUrl("/img/album/20150810/4024f1a40.jpg");
		album.setPictureUrl("/img/album/20150810/4024f1a40.jpg");
		album.setMusicUrl("/file/music/20150810/2163441.mp3");
		result = RestServiceUtils.post(MusicServiceURL.URL_MUSIC_CREATE, album, new GenericType<Result<Object>>(){});
		System.out.println(result);
		
		album = new Music();
		album.setMusicName("鞋子特大号");
		album.setZuoqu("周杰伦");
		album.setZuoci("周杰伦");
		album.setBianqu("周杰伦");
		album.setSingerId(singerId);
		album.setAlbumId(13L);
		album.setOriginalSong(true);
		album.setOverrideSong(false);
		album.setMv(false);
		album.setPublisher("杰威尔音乐有限公司");
		album.setPublishTime("2015-03-22");
		album.setCategoryId(3);
		album.setLrcUrl("/file/music/20150810/2163441.lrc");
		album.setSmallPictureUrl("/img/album/20150810/4024f1a40.jpg");
		album.setPictureUrl("/img/album/20150810/4024f1a40.jpg");
		album.setMusicUrl("/file/music/20150810/2163441.mp3");
		result = RestServiceUtils.post(MusicServiceURL.URL_MUSIC_CREATE, album, new GenericType<Result<Object>>(){});
		System.out.println(result);
		
		album = new Music();
		album.setMusicName("阳明山");
		album.setZuoqu("周杰伦");
		album.setZuoci("周杰伦");
		album.setBianqu("周杰伦");
		album.setSingerId(singerId);
		album.setAlbumId(13L);
		album.setOriginalSong(true);
		album.setOverrideSong(false);
		album.setMv(false);
		album.setPublisher("杰威尔音乐有限公司");
		album.setPublishTime("2015-02-01");
		album.setCategoryId(3);
		album.setLrcUrl("/file/music/20150810/2163441.lrc");
		album.setSmallPictureUrl("/img/album/20150810/4024f1a40.jpg");
		album.setPictureUrl("/img/album/20150810/4024f1a40.jpg");
		album.setMusicUrl("/file/music/20150810/2163441.mp3");
		result = RestServiceUtils.post(MusicServiceURL.URL_MUSIC_CREATE, album, new GenericType<Result<Object>>(){});
		System.out.println(result);
		
		album = new Music();
		album.setMusicName("窃爱");
		album.setZuoqu("周杰伦");
		album.setZuoci("周杰伦");
		album.setBianqu("周杰伦");
		album.setSingerId(singerId);
		album.setAlbumId(13L);
		album.setOriginalSong(true);
		album.setOverrideSong(false);
		album.setMv(false);
		album.setPublisher("杰威尔音乐有限公司");
		album.setPublishTime("2015-01-01");
		album.setCategoryId(3);
		album.setLrcUrl("/file/music/20150810/2163441.lrc");
		album.setSmallPictureUrl("/img/album/20150810/4024f1a40.jpg");
		album.setPictureUrl("/img/album/20150810/4024f1a40.jpg");
		album.setMusicUrl("/file/music/20150810/2163441.mp3");
		result = RestServiceUtils.post(MusicServiceURL.URL_MUSIC_CREATE, album, new GenericType<Result<Object>>(){});
		System.out.println(result);
		
		album = new Music();
		album.setMusicName("天涯过客");
		album.setZuoqu("周杰伦");
		album.setZuoci("周杰伦");
		album.setBianqu("周杰伦");
		album.setSingerId(singerId);
		album.setAlbumId(13L);
		album.setOriginalSong(true);
		album.setOverrideSong(false);
		album.setMv(false);
		album.setPublisher("杰威尔音乐有限公司");
		album.setPublishTime("2014-11-23");
		album.setCategoryId(3);
		album.setLrcUrl("/file/music/20150810/2163441.lrc");
		album.setSmallPictureUrl("/img/album/20150810/4024f1a40.jpg");
		album.setPictureUrl("/img/album/20150810/4024f1a40.jpg");
		album.setMusicUrl("/file/music/20150810/2163441.mp3");
		result = RestServiceUtils.post(MusicServiceURL.URL_MUSIC_CREATE, album, new GenericType<Result<Object>>(){});
		System.out.println(result);
		
		album = new Music();
		album.setMusicName("怎么了");
		album.setZuoqu("周杰伦");
		album.setZuoci("周杰伦");
		album.setBianqu("周杰伦");
		album.setSingerId(singerId);
		album.setAlbumId(13L);
		album.setOriginalSong(true);
		album.setOverrideSong(false);
		album.setMv(false);
		album.setPublisher("杰威尔音乐有限公司");
		album.setPublishTime("2015-07-06");
		album.setCategoryId(3);
		album.setLrcUrl("/file/music/20150810/2163441.lrc");
		album.setSmallPictureUrl("/img/album/20150810/4024f1a40.jpg");
		album.setPictureUrl("/img/album/20150810/4024f1a40.jpg");
		album.setMusicUrl("/file/music/20150810/2163441.mp3");
		result = RestServiceUtils.post(MusicServiceURL.URL_MUSIC_CREATE, album, new GenericType<Result<Object>>(){});
		System.out.println(result);
		
		album = new Music();
		album.setMusicName("一口气全念对");
		album.setZuoqu("周杰伦");
		album.setZuoci("周杰伦");
		album.setBianqu("周杰伦");
		album.setSingerId(singerId);
		album.setAlbumId(13L);
		album.setOriginalSong(true);
		album.setOverrideSong(false);
		album.setMv(false);
		album.setPublisher("杰威尔音乐有限公司");
		album.setPublishTime("2014-12-06");
		album.setCategoryId(3);
		album.setLrcUrl("/file/music/20150810/2163441.lrc");
		album.setSmallPictureUrl("/img/album/20150810/4024f1a40.jpg");
		album.setPictureUrl("/img/album/20150810/4024f1a40.jpg");
		album.setMusicUrl("/file/music/20150810/2163441.mp3");
		result = RestServiceUtils.post(MusicServiceURL.URL_MUSIC_CREATE, album, new GenericType<Result<Object>>(){});
		System.out.println(result);
		
		album = new Music();
		album.setMusicName("我要夏天");
		album.setZuoqu("周杰伦");
		album.setZuoci("周杰伦");
		album.setBianqu("周杰伦");
		album.setSingerId(singerId);
		album.setAlbumId(13L);
		album.setOriginalSong(true);
		album.setOverrideSong(false);
		album.setMv(false);
		album.setPublisher("杰威尔音乐有限公司");
		album.setPublishTime("2014-08-02");
		album.setCategoryId(3);
		album.setLrcUrl("/file/music/20150810/2163441.lrc");
		album.setSmallPictureUrl("/img/album/20150810/4024f1a40.jpg");
		album.setPictureUrl("/img/album/20150810/4024f1a40.jpg");
		album.setMusicUrl("/file/music/20150810/2163441.mp3");
		result = RestServiceUtils.post(MusicServiceURL.URL_MUSIC_CREATE, album, new GenericType<Result<Object>>(){});
		System.out.println(result);
		
		album = new Music();
		album.setMusicName("听爸爸的话");
		album.setZuoqu("周杰伦");
		album.setZuoci("周杰伦");
		album.setBianqu("周杰伦");
		album.setSingerId(singerId);
		album.setAlbumId(13L);
		album.setOriginalSong(true);
		album.setOverrideSong(false);
		album.setMv(false);
		album.setPublisher("杰威尔音乐有限公司");
		album.setPublishTime("2015-01-03");
		album.setCategoryId(3);
		album.setLrcUrl("/file/music/20150810/2163441.lrc");
		album.setSmallPictureUrl("/img/album/20150810/4024f1a40.jpg");
		album.setPictureUrl("/img/album/20150810/4024f1a40.jpg");
		album.setMusicUrl("/file/music/20150810/2163441.mp3");
		result = RestServiceUtils.post(MusicServiceURL.URL_MUSIC_CREATE, album, new GenericType<Result<Object>>(){});
		System.out.println(result);
		
		album = new Music();
		album.setMusicName("美人鱼");
		album.setZuoqu("周杰伦");
		album.setZuoci("周杰伦");
		album.setBianqu("周杰伦");
		album.setSingerId(singerId);
		album.setAlbumId(13L);
		album.setOriginalSong(true);
		album.setOverrideSong(false);
		album.setMv(false);
		album.setPublisher("杰威尔音乐有限公司");
		album.setPublishTime("2015-05-16");
		album.setCategoryId(3);
		album.setLrcUrl("/file/music/20150810/2163441.lrc");
		album.setSmallPictureUrl("/img/album/20150810/4024f1a40.jpg");
		album.setPictureUrl("/img/album/20150810/4024f1a40.jpg");
		album.setMusicUrl("/file/music/20150810/2163441.mp3");
		result = RestServiceUtils.post(MusicServiceURL.URL_MUSIC_CREATE, album, new GenericType<Result<Object>>(){});
		System.out.println(result);
		
		album = new Music();
		album.setMusicName("听见下雨的声音");
		album.setZuoqu("周杰伦");
		album.setZuoci("周杰伦");
		album.setBianqu("周杰伦");
		album.setSingerId(singerId);
		album.setAlbumId(13L);
		album.setOriginalSong(true);
		album.setOverrideSong(false);
		album.setMv(false);
		album.setPublisher("杰威尔音乐有限公司");
		album.setPublishTime("2015-04-06");
		album.setCategoryId(3);
		album.setLrcUrl("/file/music/20150810/2163441.lrc");
		album.setSmallPictureUrl("/img/album/20150810/4024f1a40.jpg");
		album.setPictureUrl("/img/album/20150810/4024f1a40.jpg");
		album.setMusicUrl("/file/music/20150810/2163441.mp3");
		result = RestServiceUtils.post(MusicServiceURL.URL_MUSIC_CREATE, album, new GenericType<Result<Object>>(){});
		System.out.println(result);
	}
	
	public static void testGetMusicById() {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("musicId", 1);
		Result<Music> result = RestServiceUtils.get(MusicServiceURL.URL_MUSIC_DETAIL, paramMap, new GenericType<Result<Music>>(){});
		System.out.println(JsonUtils.object2Json(result));
	}
	
	public static void testPlayMusic() {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("musicId", 3);
		paramMap.put("userId", 2);
		Result<Music> result = RestServiceUtils.get(MusicServiceURL.URL_MUSIC_PLAY, paramMap, new GenericType<Result<Music>>(){});
		System.out.println(JsonUtils.object2Json(result));
	}
	
	public static void testGetMusicList4index() {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("categoryId", 200);
		paramMap.put("mediaType", 1);
		Result<PagingList<Music>> result = RestServiceUtils.get(MusicServiceURL.URL_MUSIC_LIST_INDEX, paramMap, new GenericType<Result<PagingList<Music>>>(){});
		System.out.println(JsonUtils.object2Json(result));
	}
	
	public static void main(String[] args) {
		//testCreateMusic();
		//testGetMusicById();
		//testGetMusicList4index();
		testPlayMusic();
	}

}
