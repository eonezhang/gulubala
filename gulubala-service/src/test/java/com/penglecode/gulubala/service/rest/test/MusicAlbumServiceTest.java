package com.penglecode.gulubala.service.rest.test;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.GenericType;

import com.penglecode.gulubala.common.model.MusicAlbum;
import com.penglecode.gulubala.common.support.Result;
import com.penglecode.gulubala.common.util.JsonUtils;
import com.penglecode.gulubala.common.util.RestServiceUtils;
import com.penglecode.gulubala.service.url.MusicAlbumServiceURL;

public class MusicAlbumServiceTest {

	public static void testCreateMusicAlbum() {
		Long singerId = 2L;
		Result<Object> result = null;
		MusicAlbum album = null;
		album = new MusicAlbum();
		album.setAlbumName("流年啊,你奈我何");
		album.setAlbumPictureUrl("/img/album/20150810/0f4bfb0548.jpg");
		album.setPublisher("北京丰华秋实文化传媒有限公司");
		album.setSingerId(singerId);
		album.setRemark("在这颇有纪念意义的第20年，汪峰第11张新专辑第一首主打歌《流年啊 你奈我何》既是阶段性个人心声，又是时下聆听者的心理映射，时间流去多少年，你有了怎样的改变？生活正在从你的指间流逝，你眼睁睁却什么也抓不住");
		result = RestServiceUtils.post(MusicAlbumServiceURL.URL_MUSIC_ALBUM_CREATE, album, new GenericType<Result<Object>>(){});
		System.out.println(result);
		
		album = new MusicAlbum();
		album.setAlbumName("咱们结婚吧");
		album.setAlbumPictureUrl("/img/album/20150810/f95ca5fb8.jpg");
		album.setPublisher("北京丰华秋实文化传媒有限公司");
		album.setSingerId(singerId);
		album.setRemark(null);
		result = RestServiceUtils.post(MusicAlbumServiceURL.URL_MUSIC_ALBUM_CREATE, album, new GenericType<Result<Object>>(){});
		System.out.println(result);
		
		album = new MusicAlbum();
		album.setAlbumName("Song Of Redemption");
		album.setAlbumPictureUrl("/img/album/20150810/134294126.jpg");
		album.setPublisher("北京丰华秋实文化传媒有限公司");
		album.setSingerId(singerId);
		album.setRemark("汪峰个人首支英文单曲献唱电影《狼图腾》无边的原野上，远传传来一声声的嚎叫。");
		result = RestServiceUtils.post(MusicAlbumServiceURL.URL_MUSIC_ALBUM_CREATE, album, new GenericType<Result<Object>>(){});
		System.out.println(result);
		
		album = new MusicAlbum();
		album.setAlbumName("生来彷徨");
		album.setAlbumPictureUrl("/img/album/20150810/116003450.jpg");
		album.setPublisher("北京丰华秋实文化传媒有限公司");
		album.setSingerId(singerId);
		album.setRemark("我们的生命是彷徨的，我们的命运亦然；似乎我们全部的恐惧与哀愁都因为：反正象我们...");
		result = RestServiceUtils.post(MusicAlbumServiceURL.URL_MUSIC_ALBUM_CREATE, album, new GenericType<Result<Object>>(){});
		System.out.println(result);
		
		album = new MusicAlbum();
		album.setAlbumName("一起摇摆");
		album.setAlbumPictureUrl("/img/album/20150810/1f3a297970.jpg");
		album.setPublisher("北京丰华秋实文化传媒有限公司");
		album.setSingerId(singerId);
		album.setRemark(null);
		result = RestServiceUtils.post(MusicAlbumServiceURL.URL_MUSIC_ALBUM_CREATE, album, new GenericType<Result<Object>>(){});
		System.out.println(result);
		
		album = new MusicAlbum();
		album.setAlbumName("怒放的生命");
		album.setAlbumPictureUrl("/img/album/20150810/115426801.jpg");
		album.setPublisher("北京丰华秋实文化传媒有限公司");
		album.setSingerId(singerId);
		album.setRemark("《怒放的生命》延续了汪峰一贯大气、成熟的曲风。专辑中的主打歌。");
		result = RestServiceUtils.post(MusicAlbumServiceURL.URL_MUSIC_ALBUM_CREATE, album, new GenericType<Result<Object>>(){});
		System.out.println(result);
	}
	
	public static void testGetMusicAlbumById() {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("albumId", 1);
		Result<MusicAlbum> result = RestServiceUtils.get(MusicAlbumServiceURL.URL_MUSIC_ALBUM_DETAIL, paramMap, new GenericType<Result<MusicAlbum>>(){});
		System.out.println(JsonUtils.object2Json(result));
	}
	
	public static void main(String[] args) {
		//testCreateMusicAlbum();
		testGetMusicAlbumById();
	}

}
