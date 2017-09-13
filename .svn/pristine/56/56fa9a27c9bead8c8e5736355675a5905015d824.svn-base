package com.sliansoft.wechat.util;

import net.sf.json.JSONObject;

import com.sliansoft.wechat.auth.WechatAccessToken;

public class Test {

	public static void main(String[] args) {
		sendTestMsg();
	}
	
	//发送文本消息接口
	public static void sendTestMsg(){
		
		//	String url = "http://localhost:8080/sliansoft-wechat/message/sendTextMsg.do?corpId=wxa75fcc28f7f6401a&touser=xuelin&toparty=开发部&agentid=313&content=文本消息推送测试";
		
		String url = "http://wechat.sliansoft.com/sliansoft-wechat/message/sendTextMsg.do?corpId=wx5cd0347fc9d6f2e4&touser=chengxl&toparty=9&agentid=6&content=文本消息推送测试";

		
		
		JSONObject jo =  WechatAccessToken.HttpRequest(url, "POST", "");
		System.out.print(jo.toString());
		//		CloseableHttpResponse resp = null;
//		CloseableHttpClient client = null;
//
//		client = HttpClientBuilder.create().build();
//
//		HttpPost post = new HttpPost(url);
//		 post.addHeader("Content-Type", "application/json");
//		 StringEntity stringEntity = new StringEntity(jsonObject.toString(),
//		 ContentType.create("application/json", "utf-8"));
//		 post.setEntity(stringEntity);
//
//		try {
//			resp = client.execute(post);
//
//		} catch (IOException e) {
//			e.printStackTrace();
//			//
//
//		}
//
//		int statusCode = resp.getStatusLine().getStatusCode();
//		// String userId = null;
//
//		if (statusCode >= 200 && statusCode < 300) {
//
//			HttpEntity entity = resp.getEntity();
//
//			String content = null;
//			try {
//				content = EntityUtils.toString(entity);
//
//				// System.out.println("content="+content);
//			} catch (ParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//
//				e.printStackTrace();
//
//			}
//
//			JSONObject.fromObject(content);
//		}

	}
	
}
