package com.sliansoft.wechat.service;

import net.sf.json.JSONObject;

public interface CoreService {

	// public Map onload(String msg);
//	String getUserId(String access_token, String code);
	
	String getUserId(String corpId, String code);
	
	JSONObject getUser(String corpId, String code);
	
	JSONObject getUserByUserId(String corpId, String userId);



	void requestCode(String corpId);

//	JSONObject getWechatUser(String corpId, String secret);

}
