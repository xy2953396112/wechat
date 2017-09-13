package com.sliansoft.wechat.util;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import com.sliansoft.wechat.auth.WechatAccessToken;

public class TokenUtil {

	 //  
    String appId = "wx8e0009f6de7e8c80";
    // 
    String appSecret = "3a0543eadafa26da347807a00e1984f1";
    
	public static AccessToken accessToken = null;
	public static String ticket = "";
	
	//通过配置文件进行初始化，多个corpId和secrets以“，”进行分割
	private String corpIds = "";
	private String secrets = "";
	
	
	
	/**
	 * 用于维护当前token，该token将按1小时更新一次
	 */
	public static Map<String ,AccessToken> mapToken= new HashMap<String ,AccessToken>();


	/**
	 * 该方法由job定时调度执行，根据配置文件中配置的corpId和secrets，获取访问微信企业的token
	 */
	//@Override
	public void refreshToken() {
		
		if("".equals(this.getCorpIds()) || "".equals(this.getSecrets()))
			return;
		
		String[] corpIdArray = corpIds.split(",");
		String[] secretArray = secrets.split(",");
		
		for(int i =0 ; i < corpIdArray.length; i ++){
			
//			System.out.println("access token refresh, the latest token is: " + WechatAccessToken.getAccessToken(corpIdArray[i], secretArray[i],1).getToken());

			mapToken.put(corpIdArray[i], WechatAccessToken.getAccessToken(corpIdArray[i], secretArray[i],1));
			
		}
//		accessToken = WechatAccessToken.getAccessToken(appId, appSecret,1);
		System.out.println("access token refresh, the latest token is: " + mapToken.get(corpIdArray[0]).getToken());
//		refreshTicket();
			
	}
	
	
	
	
	public void refreshTicket() {
		JSONObject result = JSONObject.fromObject(HttpRequestUtil.httpRequest("https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token="+accessToken.getToken()+"&type=jsapi","GET",""));
		
		ticket = result.getString("ticket");	
		System.out.println("ticket refresh, the latest is: " + ticket);
	}

	public String getCorpIds() {
		return corpIds;
	}

	public void setCorpIds(String corpIds) {
		this.corpIds = corpIds;
	}




	public String getSecrets() {
		return secrets;
	}




	public void setSecrets(String secrets) {
		this.secrets = secrets;
	}
	
}
