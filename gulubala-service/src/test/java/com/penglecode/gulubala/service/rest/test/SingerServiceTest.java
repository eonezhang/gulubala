package com.penglecode.gulubala.service.rest.test;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.GenericType;

import com.penglecode.gulubala.common.model.Singer;
import com.penglecode.gulubala.common.support.Result;
import com.penglecode.gulubala.common.util.JsonUtils;
import com.penglecode.gulubala.common.util.RestServiceUtils;
import com.penglecode.gulubala.service.url.SingerServiceURL;

public class SingerServiceTest {

	public static void testCreateSinger() {
		Result<Object> result = null;
		Singer singer = null;
		/*singer = new Singer();
		singer.setSingerName("G.E.M.邓紫棋");
		singer.setSingerProfile("邓紫棋（G.E.M.），原名邓诗颖，1991年8月16日生于中国上海，4岁移居香港，中国香港创作型女歌手[1]  。\r\n2009年1月，获得叱咤乐坛流行榜“叱咤乐坛生力军女歌手金奖”[2]  。2011年5月，19岁的邓紫棋在香港红馆举行5场的个人演唱会[3]  。2012年，获得IPFI香港唱片销量大奖“全年最高销量女歌手奖”；创作的专辑《Xposed》获得“最高销量国语唱片奖”。2014年，参加中国内地湖南卫视歌唱类综艺节目《我是歌手第二季》[4]  ，获得总决赛亚军[5]  。3月，获第27届KCA美国儿童选择奖“最受欢迎亚洲艺人”[6]  。12月10日，邓紫棋在香港杜莎夫人蜡像馆为自己的蜡像揭幕[7]  。2015年2月18日晚，邓紫棋参加2015年中央电视台春节联欢晚会，自弹自唱其自创的歌曲《多远都要在一起》[8]  。截至北京时间2015年5月31日，《G.E.M.X.X.X.Live”世界巡回演唱会》已经完成60场。");
		singer.setSex(0);
		singer.setBirthday("1991-08-16");
		singer.setCountry("中国.大陆");
		singer.setXingzuo("狮子座");
		singer.setXuexing("O型");
		singer.setShengao("160cm");
		singer.setTizhong("47kg");
		singer.setZhiye("歌手");
		result = RestServiceUtils.post(SingerServiceURL.URL_SINGER_CREATE, singer, new GenericType<Result<Object>>(){});
		System.out.println(result);*/
		
		singer = new Singer();
		singer.setSingerName("汪峰");
		singer.setSingerProfile("汪峰，男，祖籍江苏常州[1]  ，1971年6月29日出生于北京。中国大陆摇滚歌手、音乐创作人、作词人、作曲人，鲍家街43号乐队发起人。汪峰自幼在中央音乐学院附小、附中学习小提琴，大学考入中央音乐学院小提琴中提琴专业，大学期间在专业音乐学习和训练之余就开始进行摇滚乐创作并组建乐队。完成本科学业后，进入中央芭蕾舞团任副首席小提琴师，后辞职后转型为职业歌手。1994年11月“鲍家街43号”乐队在中央音乐学院成立，汪峰担任灵魂主唱。[2]  1997年发表第一张专辑《鲍家街43号》。1998年发表第二张专辑《风暴来临》。2000年发表第三张专辑《花火》。2002年发表第四张专辑《爱是一颗幸福的子弹》。2004年发表第五张专辑《笑着哭》。2005年发表第六张专辑《怒放的生命》。2007年，汪峰发表第七张专辑《勇敢的心》。2009年，汪峰发表第八张专辑《信仰在空中飘扬》。2011年，汪峰发表专辑《生无所求》。2012年4月，小说《晚安北京》问世[3]  。2013年6月加盟《中国好声音第二季》担任导师并留任第三季。2013年12月2日发行专辑《生来彷徨》。[4-5]  2014年开展“汪峰2014峰暴来临演唱会”超级巡演[6]  。2015年2月7日晚，在章子怡生日派对上，汪峰惊喜浪漫求婚。");
		singer.setSex(1);
		singer.setBirthday("1971-06-29");
		singer.setCountry("中国.大陆");
		singer.setXingzuo("巨蟹座");
		singer.setXuexing("A型");
		singer.setShengao("176cm");
		singer.setTizhong("76kg");
		singer.setZhiye("歌手、音乐人");
		result = RestServiceUtils.post(SingerServiceURL.URL_SINGER_CREATE, singer, new GenericType<Result<Object>>(){});
		System.out.println(result);
	}
	
	public static void testGetSingerById() {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("singerId", 1);
		Result<Singer> result = RestServiceUtils.get(SingerServiceURL.URL_SINGER_DETAIL, paramMap, new GenericType<Result<Singer>>(){});
		System.out.println(JsonUtils.object2Json(result));
	}
	
	public static void main(String[] args) {
		//testCreateSinger();
		testGetSingerById();
	}

}
