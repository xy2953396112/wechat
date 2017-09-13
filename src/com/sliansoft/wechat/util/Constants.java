package com.sliansoft.wechat.util;


/**
 * 常量类
 * @author Apple
 *
 */

public class Constants {
	/**
	 * 常量说明：
	 * 此处定义的常量需要持久化，可以保存在数据库中，在需要的地方读取。
	 * 在多企业号中，最好以每个应用来定义。
	 */
	public static final int AGENTID = 1;
	public static final String encodingAESKey = "gBoLNMxnSWjJ8nN6qB6MV7eWKuCTwcWB1rIkWxeGzaf";
	
	
	//crm上层套件的suiteId
//	public static final String CRMSUITEID = "tj37d849d1f6c65194";
	//crm应用套件的secret
//	public static final String CRMSUITESECRET = "eAZosQzHWmMjvkB3HoR-zaKUiocZeBlBT_gaXu31vaW4LrUkfo4eDxXc3MWaTjtv";
	
	
	
	// 这两个参数都是在创建套件的时候随机生成的，用于对应用收到的信息进行解码，这几个参数只在验证回调地址的时候有用
	public static final String TOKEN = "f5HSLpijhzUrpHQKxRLbIRMSZVbp35";
	public static final String ENCOGINGAESKEY = "mVbWSBluUkVrKO23PltBPd4S3ql6WLmVgVDt1qcd5TN";
	public static final String CORPID = "wxa75fcc28f7f6401a";
    
	//获取成员信息URL
	public static final String URL_GETUSERINFO = "https://qyapi.weixin.qq.com/cgi-bin/user/getuserinfo?access_token=ACCESS_TOKEN&code=CODE";
	
	//获取成员URL
	public static final String URL_GETUSER = "https://qyapi.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN&userid=USERID";
	
	
	//消息推送URL
	public static final String URL_SEND = "	https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token=ACCESS_TOKEN";
			
	public static final String URL_GETCODE = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=CORPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect";

	//public static List<Object> CURRENT_USER_LIST = new ArrayList<Object>();
	
	//public static Map<String,String> CURRENT_USER_MAP = new HashMap<String,String>();

}
