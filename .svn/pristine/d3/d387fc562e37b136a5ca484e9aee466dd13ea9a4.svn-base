package com.sliansoft.wechat.service.impl;

import com.sliansoft.wechat.service.WinxinTokenService;
import com.sliansoft.wechat.util.CommonUtil;
import com.sliansoft.wechat.util.WeixinUtil;




public class WinxinTokenServiceImpl implements WinxinTokenService {

	//public static AccessToken accessToken = null;

	@Override
	public void refreshToken() {
		// TODO Auto-generated method stub
		
		try {

			CommonUtil.accessToken = WeixinUtil.getAccessToken(CommonUtil.appid, CommonUtil.appsecret);

			//System.out.println(accessToken.getTimeOfGetToken());
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			// log.error("{}", e);
		}

	}

}
