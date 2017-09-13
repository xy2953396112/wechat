package com.sliansoft.wechat.util;
/**
 * 响应消息之文本消息
 * @author dean
 *
 */
public class TextMessage extends BaseMessage {
/**
 * 回复的文本消息内容 
 */
	private String Content;

public String getContent() {
	return Content;
}

public void setContent(String content) {
	Content = content;
}
	
}
