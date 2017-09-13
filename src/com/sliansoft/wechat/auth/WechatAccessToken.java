package com.sliansoft.wechat.auth;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import com.sliansoft.wechat.util.AccessToken;
import com.sliansoft.wechat.util.EnumMethod;
import com.sliansoft.wechat.util.HttpRequestUtil;

/**
 * 公众平台通用接口工具类
 * @author dean
 *
 */
public class WechatAccessToken {
	// 获取微信公众号：access_token的接口地址（GET） 限2000（次/天）
	public final static String access_token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	//获取企业号access_token
	public final static String company_access_token_url = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=CORPID&corpsecret=CORPSECRET";
	
	 /** 
     * 发起https请求并获取结果 
     *  
     * @param requestUrl 请求地址 
     * @param requestMethod 请求方式（GET、POST） 
     * @param outputStr 提交的数据 
     * @return JSONObject(通过JSONObject.get(key)的方式获取json对象的属性值) 
     */  
	public static JSONObject HttpRequest(String request , String RequestMethod , String output ){
		@SuppressWarnings("unused")
		JSONObject jsonObject = null;
		StringBuffer buffer = new StringBuffer();
		try {
			//建立连接
			URL url = new URL(request);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setUseCaches(false);
			connection.setRequestMethod(RequestMethod);
			if(output!=null){
				OutputStream out = connection.getOutputStream();
				out.write(output.getBytes("UTF-8"));
				out.close();
			}
			//流处理
			InputStream input = connection.getInputStream();
			InputStreamReader inputReader = new InputStreamReader(input,"UTF-8");
			BufferedReader reader = new BufferedReader(inputReader);
			String line;
			while((line=reader.readLine())!=null){
				buffer.append(line);
			}
			//关闭连接、释放资源
			reader.close();
			inputReader.close();
			input.close();
			input = null;
			connection.disconnect();
			jsonObject = JSONObject.fromObject(buffer.toString());
		} catch (Exception e) {
		}
		return jsonObject;
	} 
	/**
	 * 获取access_token
	 * 
	 * @param appid
	 *            凭证
	 * @param appsecret
	 *            密钥
	 * @return
	 */
	public static AccessToken getAccessToken(String appid,String appsecret,int type){
		AccessToken accessToken = null;
		String requestUrl = access_token_url.replace("APPID", appid).replace("APPSECRET", appsecret);
		if (type == 1) {
			 //替换企业号中的参数
			 requestUrl = company_access_token_url.replace("CORPID", appid).replace("CORPSECRET", appsecret);
			System.err.println(requestUrl);
		}
		JSONObject jsonObject = HttpRequestUtil.httpRequest(requestUrl, EnumMethod.GET.name(), null);
		if(jsonObject==null){
			jsonObject = HttpRequestUtil.httpRequest(requestUrl, EnumMethod.GET.name(), null);
		}
		// 如果请求成功
		if (null != jsonObject) {
			try {
				accessToken = new AccessToken();
				accessToken.setToken(jsonObject.getString("access_token"));
				accessToken.setExpiresIn(jsonObject.getInt("expires_in"));
			} catch (JSONException e) {
				accessToken = null;
				// 获取token失败
			}
		}
		return accessToken;
	}
	/**
	 * 数据提交与请求通用方法
	 * @param access_token 凭证
	 * @param RequestMt 请求方式
	 * @param RequestURL 请求地址
	 * @param outstr 提交json数据
	 * */
    public static int PostMessage(String access_token ,String RequestMt , String RequestURL , String outstr){
    	int result = 0;
    	RequestURL = RequestURL.replace("ACCESS_TOKEN", access_token);
    	JSONObject jsonobject = WechatAccessToken.HttpRequest(RequestURL, RequestMt, outstr);
//    	System.out.println("============" + jsonobject);
    	 if (null != jsonobject) {  
 	        if (0 != jsonobject.getInt("errcode")) {  
 	            result = jsonobject.getInt("errcode");  
 	            String error = String.format("操作失败 errcode:{} errmsg:{}", jsonobject.getInt("errcode"), jsonobject.getString("errmsg"));  
// 	            System.out.println(error); 
 	        }  
 	    }
    	return result;
    }
}
