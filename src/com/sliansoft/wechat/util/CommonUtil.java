package com.sliansoft.wechat.util;


public class CommonUtil {
	
	public static String IP_OR_DNS = "sliansoft.ticp.io/wechat";
	
	//任务接收的最大时间间隔
	public static long INTERVAL_TIME_OF_RECEIVE_TASK = 1000 * 60 *60;//1小时
	
	//回复箱单最大时间间隔
	public static long INTERVAL_TIME_OF_REPLY_CONTAINERNO = 1000 * 60 *60 *24;//1天
	
	//发送模板消息URL
	public static String POST_URL = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";

	//任务接收的URL
	//public static String RECEIVE_TASK_URL = "http://60.190.26.162/fleet-welive/container/receiveTask.do?sendTimeStamp=TIME_STAMP&phone=PHONE&businessId=BUSINESS_ID";

	//任务模板消息ID 司机从业资格证到期提醒
	public static String LICENSE_INSPRCTION_ID = "vRDnXsB8sFHhHUR4goRtd3Y7fsecnsg9I4d21AfQe2o";
	
	public static String  appid ="wx65706b1910bb4356";
	
	//app秘钥
	public static String appsecret ="f1224a48570a256bde7ee9dda471fbd6";

	public static AccessToken accessToken = null;
	

}
