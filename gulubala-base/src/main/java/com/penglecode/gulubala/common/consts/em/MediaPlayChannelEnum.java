package com.penglecode.gulubala.common.consts.em;
/**
 * 媒体播放渠道
 * 
 * @author  pengpeng
 * @date 	 2015年8月5日 下午5:08:49
 * @version 1.0
 */
public enum MediaPlayChannelEnum {

	PLAY_CHANNEL_ALBUMS(0, "专辑"), PLAY_CHANNEL_MUSIC_LIST(1, "歌单");
	
	private Integer channelCode;
	
	private String channelName;

	private MediaPlayChannelEnum(Integer channelCode, String channelName) {
		this.channelCode = channelCode;
		this.channelName = channelName;
	}

	public Integer getChannelCode() {
		return channelCode;
	}

	public void setChannelCode(Integer channelCode) {
		this.channelCode = channelCode;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public static MediaPlayChannelEnum getPlayChannel(Integer channelCode){
		for(MediaPlayChannelEnum em : values()){
			if(em.getChannelCode().equals(channelCode)){
				return em;
			}
		}
		return null;
	}
	
}
