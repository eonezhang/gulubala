package com.penglecode.gulubala.common.consts;

import java.util.Locale;

import com.penglecode.gulubala.common.support.ConstValue;

/**
 * 全局常量
 * 
 * @author  pengpeng
 * @date 	 2015年4月18日 下午5:50:07
 * @version 1.0
 */
public class GlobalConstants extends AbstractConstants {

	/**
	 * 系统默认字符编码
	 */
	public static final String SYSTEM_DEFAULT_ENCODING = valueOf("UTF-8");
	
	/**
	 * 系统默认Locale
	 */
	public static final Locale SYSTEM_DEFAULT_LOCALE = valueOf(new Locale("zh", "CN"));
	
	/**
	 * 返回结果之成功
	 */
	public static final String RESULT_CODE_SUCCESS = valueOf("1");

	/**
	 * 返回结果之失败
	 */
	public static final String RESULT_CODE_FAILURE = valueOf("0");

	/**
	 * 针对数据库字段,诸如:'是','真','已删除',...等等由数字"1"代表的真值
	 */
	public static final String DEFAULT_YES_TRUE_FLAG = valueOf("1");

	/**
	 * 针对数据库字段,诸如:'否','假','未删除',...等等由数字"0"代表的假值
	 */
	public static final String DEFAULT_NO_FALSE_FLAG = valueOf("0");
	
	/**
	 * 默认的用户密码递归加密次数
	 */
	public static final int DEFAULT_PASSWORD_HASH_ITERATIONS = valueOf(1);
	
	/**
	 * 全局图片服务域名
	 * 注：各个应用的global.properties中需要加入global.imgserver.domain=xxxx
	 */
	@ConstValue("${global.imgserver.domain}")
	public static final String GLOBAL_IMGSERVER_DOMAIN = valueOf(null);
	
	/**
	 * 全局媒体文件服务域名(外部)
	 * 注：各个应用的global.properties中需要加入global.fileserver.external.domain=xxxx
	 */
	@ConstValue("${global.fileserver.external.domain}")
	public static final String GLOBAL_FILESERVER_EXTERNAL_DOMAIN = valueOf(null);
	
	/**
	 * 全局媒体文件服务域名(内部)
	 * 注：各个应用的global.properties中需要加入global.fileserver.internal.domain=xxxx
	 */
	@ConstValue("${global.fileserver.internal.domain}")
	public static final String GLOBAL_FILESERVER_INTERNAL_DOMAIN = valueOf(null);
	
	/**
	 * 默认的用户头像
	 */
	@ConstValue("${global.usericon.default}")
	public static final String DEFAULT_USER_ICON = valueOf(null);
	
	/**
	 * 默认的音乐评论ROOT节点ID
	 */
	public static final long DEFAULT_MUSIC_COMMENT_ROOT_ID = valueOf(0);
	
	/**
	 * 默认的音乐播放历史最大记录数
	 */
	public static final long DEFAULT_MUSIC_PLAY_HISTORY_MAX_SIZE = valueOf(100);
	
	/**
	 * 默认的歌单中歌曲的最大容量
	 */
	public static final long DEFAULT_MUSIC_LIST_MAX_SIZE = valueOf(100);
	
	/**
	 * 属于APP客户端推荐分类的ID
	 */
	@ConstValue("${global.categoryid.app}")
	public static final Integer GLOBAL_MEDIA_CATEGORY_ID_APP = valueOf(2);
	
	/**
	 * 首页轮播图所属推荐分类ID
	 */
	@ConstValue("${global.categoryid.indexadv}")
	public static final Integer GLOBAL_MEDIA_CATEGORY_ID_INDEX_ADV = valueOf(6);
	
	/**
	 * 引导页轮播图所属推荐分类ID
	 */
	@ConstValue("${global.categoryid.guideadv}")
	public static final Integer GLOBAL_MEDIA_CATEGORY_ID_GUIDE_ADV = valueOf(5);
	
}
