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

	EXTERNAL(GlobalConstants.GLOBAL_FILESERVER_EXTERNAL_DOMAIN, "外部资源domain"), INTERNAL(GlobalConstants.GLOBAL_FILESERVER_INTERNAL_DOMAIN, "内部资源domain");
	
	private String domainUrl;
	
	private String description;

	private MediaSource(String domainUrl, String description) {
		this.domainUrl = domainUrl;
		this.description = description;
	}

	public String getDomainUrl() {
		return domainUrl;
	}

	public void setDomainUrl(String domainUrl) {
		this.domainUrl = domainUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
