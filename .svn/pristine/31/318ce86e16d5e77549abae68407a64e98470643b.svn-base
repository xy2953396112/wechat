package com.sliansoft.wechat.web;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sliansoft.wechat.service.MessageService;

/**
 * 注解方式打开链接
 */
@Controller
@RequestMapping(value = "/message")
public class MessageController {
	
	@Autowired
	private MessageService messageService;


	/**
	 * test url：
	 * http://localhost:8080/sliansoft-wechat/message/sendTextMsg.do?corpId=wxa75fcc28f7f6401a&touser=xuelin|zhaok&toparty=开发部&agentid=313&content=文本消息推送测试
	 * 乱码问题解决 ： 修改server.xml 在connector 中添加  useBodyEncodingForURI="true"
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/sendTextMsg.do")
	public @ResponseBody
	Object  sendTextMsg(HttpServletRequest request) {
	
		
		
		String corpId = request.getParameter("corpId"); //企业号ID
		String touser = request.getParameter("touser"); //消息接受人
		String toparty = request.getParameter("toparty");//消息接收部门
		String agentid = request.getParameter("agentid");//应用ID
		
		String content =  request.getParameter("content");//消息内容

	
		return messageService.sendTextMsg(corpId, touser, toparty, agentid, content);//CoreServiceImpl_willdel.onload(code);
	}
}
