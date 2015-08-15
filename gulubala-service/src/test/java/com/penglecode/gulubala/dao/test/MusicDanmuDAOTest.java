package com.penglecode.gulubala.dao.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.penglecode.gulubala.common.model.MusicDanmu;
import com.penglecode.gulubala.common.support.Pager;
import com.penglecode.gulubala.common.util.CollectionUtils;
import com.penglecode.gulubala.common.util.JsonUtils;
import com.penglecode.gulubala.dao.music.MusicDanmuDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/spring-base.xml","classpath:spring/spring-beans.xml","classpath:spring/spring-dao.xml","classpath:spring/spring-cache.xml"})
public class MusicDanmuDAOTest {

	@Resource(name="musicDanmuDAO")
	private MusicDanmuDAO musicDanmuDAO;
	
	@Test
	public void testGetNextMusicDanmuList(){
		List<MusicDanmu> list = musicDanmuDAO.getNextMusicDanmuList(1L, new Pager(4, 200));
		if(!CollectionUtils.isEmpty(list)){
			for(int i = 0, len = list.size(); i < len; i++){
				System.out.println("[" + i + "] ===> " + JsonUtils.object2Json(list.get(i)));
			}
		}
	}
	
}
