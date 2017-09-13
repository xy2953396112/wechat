package com.sliansoft.wechat.web;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sliansoft.wechat.service.CoreService;

/**
 * 注解方式打开链接
 */
@Controller
@RequestMapping(value = "/core")
public class CoreController {
	
	@Autowired
	private CoreService coreService;


	@RequestMapping(value = "/getUserId.do")
	public String getUserId(HttpServletRequest request) {
	
		String corpId = request.getParameter("corpId");
		String code =  request.getParameter("code");

		if(StringUtils.isEmpty(corpId) || StringUtils.isEmpty(code))
			return "";
		
		return coreService.getUserId(corpId, code);//CoreServiceImpl_willdel.onload(code);
	}
	

	@RequestMapping(value = "/getUser.do")
	public @ResponseBody Object  getUser(HttpServletRequest request) {
	
		String corpId = request.getParameter("corpId");
		String code =  request.getParameter("code");

		if(StringUtils.isEmpty(corpId) || StringUtils.isEmpty(code))
			return "";
		
		return coreService.getUser(corpId, code);//CoreServiceImpl_willdel.onload(code);
	}
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/getUserByuserId.do")
	public @ResponseBody
	Object  getUserByuserId(HttpServletRequest request) {
	
		String corpId = request.getParameter("corpId");
		String userId =  request.getParameter("userId");

		if(StringUtils.isEmpty(corpId) || StringUtils.isEmpty(userId))
			return "";
		
		return coreService.getUserByUserId(corpId, userId);//CoreServiceImpl_willdel.onload(code);
	}
	
	

}
