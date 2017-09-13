package com.sliansoft.wechat.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sliansoft.salesys.aes.AesException;
import com.sliansoft.salesys.aes.WXBizMsgCrypt;
 
/**
 * 核心请求处理类
 * 
 * 
 */
public class CoreServlet extends HttpServlet {
    private static final long serialVersionUID = 4440739483644821986L;
    
    
    /**
     * 确认请求来自微信服务器
     * @throws IOException 
     */
    @Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//设置编码
    	response.setCharacterEncoding("utf-8");
    	request.setCharacterEncoding("utf-8");
    	String sToken = "X6id0TthEFxQEp1itanr7cSGculhYS";//这个Token是随机生成，但是必须跟企业号上的相同
        String sCorpID = "wx32cf1d824f9becbf";//这里是你企业号的CorpID
        String sEncodingAESKey = "gBoLNMxnSWjJ8nN6qB6MV7eWKuCTwcWB1rIkWxeGzaf";//这个EncodingAESKey是随机生成，但是必须跟企业号上的相同
        // 微信加密签名  
    	try {
    		WXBizMsgCrypt wxcpt = new WXBizMsgCrypt(sToken, sEncodingAESKey, sCorpID);


    		// 解析出url上的参数值如下：
    		String sVerifyMsgSig = URLDecoder.decode(request.getParameter("msg_signature"),"utf-8");
    	    // 时间戳  
    		String sVerifyTimeStamp = URLDecoder.decode(request.getParameter("timestamp"),"utf-8");
    	    // 随机数  
    		String sVerifyNonce = URLDecoder.decode(request.getParameter("nonce"),"utf-8");
    	    // 随机字符串  
    		String sVerifyEchoStr = URLDecoder.decode(request.getParameter("echostr"),"utf-8");
    	    // 打印请求地址  
    	    System.out.println("msg_signature" + sVerifyMsgSig+"timestamp"+sVerifyTimeStamp+"nonce"+sVerifyNonce+"echostr"+sVerifyEchoStr);  
    		PrintWriter out = response.getWriter();  
    		String sEchoStr; //需要返回的明文
    		try {
    		sEchoStr = wxcpt.VerifyURL(sVerifyMsgSig, sVerifyTimeStamp,sVerifyNonce, sVerifyEchoStr);
    		System.out.println("verifyurl echostr:" + sEchoStr + "__sVerifyMsgSig:"+sVerifyMsgSig+"__sVerifyTimeStamp:"+sVerifyTimeStamp+"__sVerifyNonce:"+sVerifyNonce+"__sVerifyEchoStr:"+sVerifyEchoStr);
    		// 验证URL成功，将sEchoStr返回
    		out.print(sEchoStr);  
    		out.close();  
    		   out = null; 
    		} catch (Exception e) {
    		//验证URL失败，错误原因请查看异常
    		e.printStackTrace();
    		}

    		} catch (AesException e1) {
    		// TODO Auto-generated catch block
    		e1.printStackTrace();
    		}
    		    }  
 
    /**
     * 处理微信服务器发来的消息
     */
    @Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doGet(request, response);
        // TODO 消息的接收、处理、响应
    	 // 调用核心业务类接收消息、处理消息  
//        String respMessage = CoreService.processRequest(request);  
//        System.out.println("respMessage=" + respMessage);  
//        // 响应消息  
//        PrintWriter out = response.getWriter();  
//        out.print(respMessage);  
//        out.close();  
    }
 
}