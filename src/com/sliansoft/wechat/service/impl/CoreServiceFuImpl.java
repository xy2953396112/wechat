package com.sliansoft.wechat.service.impl;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.sliansoft.wechat.service.CoreServiceFu;
import com.sliansoft.wechat.util.MessageUtil;
import com.sliansoft.wechat.util.RespMessageUtil;
import com.sliansoft.wechat.util.TextMessage;

public class CoreServiceFuImpl implements CoreServiceFu {


	/**
	 * 处理微信发来的请求
	 * 
	 * @param request
	 * @return
	 */
	public String processRequest(HttpServletRequest request) {
		String respMessage = null;
		try {
			// 默认返回的文本消息内容
			String respContent = "请求处理异常，请稍后尝试";

			// xml请求解析
			Map<String, String> requestMap = MessageUtil.parseXml(request);
            //requestMap包含了消息类型（有两大类消息类型）
			String msgType = requestMap.get("MsgType");
			// 文本消息
			if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {

				return processTextMessage(requestMap);

			}

			// 事件消息，包括关注、取消关注、click事件
			if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {

				return processEventMessage(requestMap);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return respMessage;
	}

	/**
	 * 处理文本消息
	 * 
	 * @author chengxl@cst.zju.edu.cn at 2014年10月4日
	 * 
	 * @param requestMap
	 * @param ctx
	 * @return
	 */
	private String processTextMessage(Map<String, String> requestMap) {
		// TODO Auto-generated method stub

		//文本消息处理,暂时统一回复一条内容
		return this.createTextMessage(requestMap, RespMessageUtil.Type.RESP_ERROR_FOR_TEXTMESSAGE_99);
	
	}

	/**
	 * 处理事件消息，包括关注、取消关注和菜单click等事件
	 * 
	 * @author chengxl@cst.zju.edu.cn at 2014年10月4日
	 * 
	 * @param requestMap
	 * @param ctx
	 * @return
	 */
	private String processEventMessage(Map<String, String> requestMap) {
		// TODO Auto-generated method stub
		String respContent = "";

		// 事件类型
		String eventType = requestMap.get("Event");
        //返回的是事件类型，还要细化为几个时间
		// 订阅
		if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
			//return this.createSubscribeMessage(requestMap);
			return this.createTextMessage(requestMap, RespMessageUtil.Type.RESP_SUBCRIBE_00);
		}

		// 菜单click事件处理
		if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
			return this.processClickEvent(requestMap);

		}

		// 取消订阅
		if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
			// TODO 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息

		}

		return "";

	}
	
	private String processClickEvent(Map<String, String> requestMap) {
		// 事件KEY值，与创建自定义菜单时指定的KEY值对应
		String eventKey = requestMap.get("EventKey");

		Integer key = Integer.parseInt(eventKey == null ? "0" : eventKey);

	//	String respContent = "";
		switch (key) {
		// 获取最新箱单信息
		case 33:
			return this.createTextMessage(requestMap, RespMessageUtil.Type.RESP_CLIENT_33);

		default:
			
			return "";

		}
	}


	private String createTextMessage(Map<String, String> requestMap,int type) {

		// 发送方帐号（open_id)
		String fromUserName = requestMap.get("FromUserName");

		// 公众帐号
		String toUserName = requestMap.get("ToUserName");

		TextMessage textMessage = new TextMessage();
		textMessage.setToUserName(fromUserName);
		textMessage.setFromUserName(toUserName);
		textMessage.setCreateTime(new Date().getTime());
		textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
		textMessage.setFuncFlag(0);
		
		
		// 回复文本消息
		switch(type){
		case RespMessageUtil.Type.RESP_SUBCRIBE_00:
			// 回复文本消息
			textMessage.setContent(RespMessageUtil.Content.RESP_SUBCRIBE_00.replace(
					"#fromUserName#", fromUserName));
			break;
		case RespMessageUtil.Type.RESP_DRIVER_22:
			textMessage.setContent(RespMessageUtil.Content.RESP_DRIVER_22);
			break;
		case RespMessageUtil.Type.RESP_DRIVER_23:
			textMessage.setContent(RespMessageUtil.Content.RESP_DRIVER_23);
			break;
			
		case RespMessageUtil.Type.RESP_CLIENT_32:
			textMessage.setContent( RespMessageUtil.Content.RESP_CLIENT_32);
			break;
		case RespMessageUtil.Type.RESP_CLIENT_33:
			textMessage.setContent( RespMessageUtil.Content.RESP_CLIENT_33.replace(
					"#fromUserName#", fromUserName));
			break;
		case RespMessageUtil.Type.RESP_ERROR_FOR_CLICKEVENT_88:
			textMessage.setContent(RespMessageUtil.Content.RESP_ERROR_FOR_CLICKEVENT_88);
			break;
		case RespMessageUtil.Type.RESP_ERROR_FOR_TEXTMESSAGE_99:
			textMessage.setContent(RespMessageUtil.Content.RESP_ERROR_FOR_TEXTMESSAGE_99+RespMessageUtil.Content.RESP_SUBCRIBE_00);
			break;
		default:
		
		}

		return MessageUtil.textMessageToXml(textMessage);
	}

	
}
