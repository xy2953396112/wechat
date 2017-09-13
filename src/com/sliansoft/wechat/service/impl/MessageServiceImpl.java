package com.sliansoft.wechat.service.impl;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;

import com.sliansoft.wechat.auth.WechatAccessToken;
import com.sliansoft.wechat.service.MessageService;
import com.sliansoft.wechat.util.Constants;
import com.sliansoft.wechat.util.TokenUtil;

public class MessageServiceImpl implements MessageService {
    //给特定微信企业号用户推送文本消息
	@Override
	public Object sendTextMsg(String corpId, String touser, String toparty,
			String agentid, String content) {

		JSONObject result = new JSONObject();
		
		
		if(StringUtils.isEmpty(corpId) ||
				StringUtils.isEmpty(touser) ||  StringUtils.isEmpty(toparty) || StringUtils.isEmpty(agentid) ||StringUtils.isEmpty(content)){
			
			result.put("errcode", -1);
			result.put("errmsg", "参数不正确，请规定参数提交请求");
			
			return result;
			
		}
		
		//消息推送URL   替换其中的参数      corpId  企业号
		String url = Constants.URL_SEND.replace("ACCESS_TOKEN",
				TokenUtil.mapToken.get(corpId).getToken());
        //msg为给URL提供的参数
		String msg = this._formatMsg(touser, toparty, agentid, content);
 
		return  WechatAccessToken.HttpRequest(url, "POST", msg);

	}
	
	
	/**
	 * text消息
	 * 
	 * @param touser
	 *            UserID列表（消息接收者，多个接收者用‘|’分隔）。特殊情况：指定为@all，则向关注该企业应用的全部成员发送————
	 *            "touser": "UserID1|UserID2|UserID3"
	 * @param toparty
	 *            PartyID列表，多个接受者用‘|’分隔。当touser为@all时忽略本参数————"toparty":
	 *            " PartyID1 | PartyID2 "
	 * @param totag
	 *            TagID列表，多个接受者用‘|’分隔。当touser为@all时忽略本参数————"totag":
	 *            " TagID1 | TagID2 "
	 * @param msgtype
	 *            消息类型，此时固定为：text
	 * @param agentid
	 *            企业应用的id，整型。可在应用的设置页面查看
	 * @param content
	 *            消息内容
	 * @param safe
	 *            表示是否是保密消息，0表示否，1表示是，默认0
	 * */
	private String _formatMsg(String touser, String toparty,
			String agentid, String content) {
		String PostData = "{\"touser\": \"%s\",\"toparty\": \"%s\",\"msgtype\": \"text\",\"agentid\": %s,\"text\": {\"content\": \"%s\"},\"safe\":\"0\"}";
		return String.format(PostData, touser, toparty, agentid, content);
	}
}
