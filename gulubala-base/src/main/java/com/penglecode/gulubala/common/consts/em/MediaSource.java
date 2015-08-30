package com.penglecode.gulubala.common.consts.em;

import com.penglecode.gulubala.common.consts.GlobalConstants;

/**
 * 媒体资源来源
 * 
 * @author  pengpeng
 * @date 	 2015年8月29日 下午4:31:58
 * @version 1.0
 */
public enum MediaSource {

	EXTERNAL(){
		public String getDomainUrl() {
			return GlobalConstants.GLOBAL_FILESERVER_EXTERNAL_DOMAIN;
		}
		public String getDescription() {
			return "外部资源domain";
		}
	}, INTERNAL(){
		public String getDomainUrl() {
			return GlobalConstants.GLOBAL_FILESERVER_INTERNAL_DOMAIN;
		}
		public String getDescription() {
			return "内部资源domain";
		}
	};
	
	public String getDomainUrl() {
		return null;
	}

	public String getDescription() {
		return null;
	}

}
