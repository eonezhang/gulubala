package com.penglecode.gulubala.common.util;

import com.penglecode.gulubala.common.consts.GlobalConstants;

/**
 * 应用图片工具类
 * 
 * @author  pengpeng
 * @date 	 2015年8月10日 下午3:27:26
 * @version 1.0
 */
public class AppResourceUtils {

	public static String getFullPictureUrl(String pictureUrl) {
		if(!StringUtils.isEmpty(pictureUrl)){
			if(pictureUrl.startsWith("http://")){
				return pictureUrl;
			}else{
				return GlobalConstants.GLOBAL_IMGSERVER_DOMAIN + pictureUrl;
			}
		}
		return null;
	}
	
	public static String getFullFileUrl(String fileUrl) {
		if(!StringUtils.isEmpty(fileUrl)){
			if(fileUrl.startsWith("http://")){
				return fileUrl;
			}else{
				return GlobalConstants.GLOBAL_FILESERVER_DOMAIN + fileUrl;
			}
		}
		return null;
	}
	
}
