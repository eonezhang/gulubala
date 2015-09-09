package com.penglecode.gulubala.common.util;

import com.penglecode.gulubala.common.consts.GlobalConstants;
import com.penglecode.gulubala.common.consts.em.MediaSource;

/**
 * 应用图片工具类
 * 
 * @author  pengpeng
 * @date 	 2015年8月10日 下午3:27:26
 * @version 1.0
 */
public class AppResourceUtils {

	public static final String PROTOCOL_HTTP = "http://";
	
	public static String getFullPictureUrl(String pictureUrl) {
		if(!StringUtils.isEmpty(pictureUrl)){
			if(pictureUrl.startsWith(PROTOCOL_HTTP)){
				return pictureUrl;
			}else{
				String fullUrl = GlobalConstants.GLOBAL_IMGSERVER_DOMAIN + pictureUrl;
				fullUrl = fullUrl.replace(PROTOCOL_HTTP, "");
				return PROTOCOL_HTTP + FileUtils.formatFilePath(fullUrl);
			}
		}
		return null;
	}
	
	public static String getFullFileUrl(String fileUrl, MediaSource mediaSource) {
		if(!StringUtils.isEmpty(fileUrl)){
			if(fileUrl.startsWith(PROTOCOL_HTTP)){
				return fileUrl;
			}else{
				String fullUrl = mediaSource.getDomainUrl() + fileUrl;
				fullUrl = fullUrl.replace(PROTOCOL_HTTP, "");
				return PROTOCOL_HTTP + FileUtils.formatFilePath(fullUrl);
			}
		}
		return null;
	}
	
}
