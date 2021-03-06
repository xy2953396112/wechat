package com.sliansoft.wechat.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

/**
 * 定义返回到微信端的消息
 * 
 * @author chengxl@cst.zju.edu.cn
 * @Date: 2014年10月5日
 * 
 */
public class RespMessageUtil {

	public static class Type {
		// 关注时返回的消息
		public final static  int RESP_SUBCRIBE_00 = 00;

		//菜单最新任务click key=21
		public final static int RESP_DRIVER_21 = 21;
		//菜单历史任务click key=22
		public final static int RESP_DRIVER_22 = 22;
		//菜单帐户绑定click key=22
		public final static int RESP_DRIVER_23 = 23;
		//菜单帐户绑定click key=22
		public final static int RESP_DRIVER_24 = 24;

		public final static int RESP_CLIENT_31 = 31;

		public final static int RESP_CLIENT_32 = 32;

		public final static int RESP_CLIENT_33 = 33;
		
		public final static int RESP_CLIENT_34 = 34;
		//返回错误点击事件的编号
		public final static int RESP_ERROR_FOR_CLICKEVENT_88 = 88;
		//返回错误文本消息的编号
		public final static int RESP_ERROR_FOR_TEXTMESSAGE_99 = 99;
		
	}

	public static class Content {
		
	

		// 关注时返回的消息
		public static String RESP_SUBCRIBE_00 = "将您手机号关联到你托我算系统.\n <a href='http://"+CommonUtil.IP_OR_DNS+"/wxlogin.html?openId=#fromUserName#'>帐号绑定</a>";

		
		public static String RESP_DRIVER_21 = "点击下面链接接受任务:\n[1]<a href='http://"+CommonUtil.IP_OR_DNS+"/receiveTask.do?openId=#fromUserName#&sendTimeStamp=#sendTimeStamp#&phone=#fromPhone#&businessId=#businessId#'>任务接收</a>;"
				+ "\n[2]<a href='http://"+CommonUtil.IP_OR_DNS+"/replycontainerno.html?phone=#fromPhone#&businessId=#businessId#&sendTimeStamp=#sendTimeStamp#'>回复箱封号</a>";
		
		public static String RESP_DRIVER_211 = "哎呀，最新任务没有找到啊，确认你绑定了手机号，要么你不是我们的司机，非常抱歉！";
		
		public static String RESP_DRIVER_22 = "请点击下面的历史任务查询链接:\n <a href='http://"+CommonUtil.IP_OR_DNS+"/queryContainerInfo.html?openId=#fromUserName#'>历史任务查询</a>";
		//"将您手机号关联到一洲货运系统.\n <a href='http://"+CommonUtil.IP_OR_DNS+"/wxlogin.html?openId=#fromUserName#&type=DRIVER'>帐号帮定</a>";
		public static String RESP_DRIVER_23 = RESP_SUBCRIBE_00 + "\n 绑定账号后就可以查询最新任务和历史任务了.";
		
		public static String RESP_CLIENT_31 = "";
		
		public static String RESP_CLIENT_32 = "请点击下面的历史运单查询链接.\n <a href='http://"+CommonUtil.IP_OR_DNS+"/queryContainerInfo.html?openId=#fromUserName#'>历史运单查询</a>";
		
		//"将您手机号关联到一洲货运系统.\n <a href='http://"+CommonUtil.IP_OR_DNS+"/wxlogin.html?openId=#fromUserName#&type=DRIVER'>帐号帮定</a>";
		public static String RESP_CLIENT_33 = RESP_SUBCRIBE_00  + "\n 绑定账号后就可以查询最新业务了.";;
		
		public static String RESP_ERROR_FOR_CLICKEVENT_88 = "哎呀,好像业务系统执行遇到了点问题,可以与管理员联系一下解决,非常抱歉!";
		
		public static String RESP_ERROR_FOR_TEXTMESSAGE_99 = "哎呀,我不是太理解的问题,你可以通过绑定你的手机号后,通过菜单来完成你需要的任务,非常抱歉!\n";
	}

	public static void main(String[] arg) {
		// System.out.print(RESP_SUBCRIBE.replace("#fromUserName#", "aaaa"));

	}

}
