package com.sliansoft.wechat.web;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sliansoft.salesys.aes.AesException;
import com.sliansoft.salesys.aes.WXBizMsgCrypt;
import com.sliansoft.wechat.service.CoreService;
import com.sliansoft.wechat.util.Constants;

/**
 * 注解方式打开链接
 */
@Controller
@RequestMapping(value = "/controller")
public class CoreController_willdel {
	private String token = Constants.TOKEN;
	private String encodingAESKey = Constants.encodingAESKey;
	private String corpId = Constants.CORPID;
	private String msg = "";

	@Autowired
	private CoreService coreservice;

	@RequestMapping(value = { "/coreJoin.do" }, method = RequestMethod.GET)
	public void coreJoinGet(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// 微信加密签名
		String msg_signature = request.getParameter("msg_signature");
		// 时间戳
		String timestamp = request.getParameter("timestamp");
		// 随机数
		String nonce = request.getParameter("nonce");
		// 随机字符串
		String echostr = request.getParameter("echostr");

		System.out.println("request=" + request.getRequestURL());

		PrintWriter out = response.getWriter();
		// ͨ通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
		String result = null;
		try {
			WXBizMsgCrypt wxcpt = new WXBizMsgCrypt(token, encodingAESKey,
					corpId);
			result = wxcpt.VerifyURL(msg_signature, timestamp, nonce, echostr);
		} catch (AesException e) {
			e.printStackTrace();
		}
		if (result == null) {
			result = token;
		}
		out.print(result);
		out.close();
		out = null;
	}

	@RequestMapping(value = { "/coreJoin.do" }, method = RequestMethod.POST)
	public void coreJoinPost(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// 将请求、响应的编码均设置为UTF-8（防止中文乱码）
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		// 微信加密签名
		String msg_signature = request.getParameter("msg_signature");
		// 时间戳
		String timestamp = request.getParameter("timestamp");
		// 随机数
		String nonce = request.getParameter("nonce");

		// 从请求中读取整个post数据
		InputStream inputStream = request.getInputStream();
		String postData = IOUtils.toString(inputStream, "UTF-8");
		System.out.println(postData);

		// String msg = "";
		WXBizMsgCrypt wxcpt = null;
		try {
			wxcpt = new WXBizMsgCrypt(token, encodingAESKey, corpId);
			// 解密消息
			msg = wxcpt.DecryptMsg(msg_signature, timestamp, nonce, postData);
		} catch (AesException e) {
			e.printStackTrace();
		}
		System.out.println("msg=" + msg);
		// 调用核心业务类接收消息、处理消息
		String respMessage = "";// CoreServiceImpl_willdel.processRequest(msg);
		System.out.println("respMessage=" + respMessage);

		String encryptMsg = "";
		try {
			// 加密回复消息
			encryptMsg = wxcpt.EncryptMsg(respMessage, timestamp, nonce);
		} catch (AesException e) {
			e.printStackTrace();
		}
		// 响应消息
		PrintWriter out = response.getWriter();
		out.print(encryptMsg);
		out.close();
	}

	// @SuppressWarnings("unchecked")
	// @RequestMapping(value = "/insert.do")
	// public @ResponseBody String insert(HttpServletRequest request) throws
	// UnsupportedEncodingException {
	//
	// try {
	// request.setCharacterEncoding("UTF-8");
	// } catch (UnsupportedEncodingException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// /*JSONObject jAuthInfo = JSONObject.fromObject(
	// request.getParameter("inspectionrecord"));
	// InspectionRecord inspectionrecord =
	// (InspectionRecord)JSONObject.toBean(jAuthInfo,InspectionRecord.class);
	// */
	//
	// HttpJson j = new HttpJson();
	// InspectionRecord inspectionrecord = new InspectionRecord();
	// inspectionrecord.setStatus(request.getParameter("status"));
	// inspectionrecord.setEquipmentId(Integer.valueOf(request.getParameter("equipmentId")));
	// inspectionrecord.setEquipmentName(request.getParameter("equipmentName"));
	// inspectionrecord.setFromUserName(request.getParameter("fromUserName"));
	// inspectionrecord.setParameter1(request.getParameter("parameter1"));
	// inspectionrecord.setParameter10(request.getParameter("parameter10"));
	// inspectionrecord.setParameter11(request.getParameter("parameter11"));
	// inspectionrecord.setParameter12(request.getParameter("parameter12"));
	// inspectionrecord.setParameter13(request.getParameter("parameter13"));
	// inspectionrecord.setParameter14(request.getParameter("parameter14"));
	// inspectionrecord.setParameter15(request.getParameter("parameter15"));
	// inspectionrecord.setParemeter16(request.getParameter("parameter16"));
	// inspectionrecord.setParameter17(request.getParameter("parameter17"));
	// inspectionrecord.setParameter2(request.getParameter("parameter2"));
	// inspectionrecord.setParameter3(request.getParameter("parameter3"));
	// inspectionrecord.setParameter4(request.getParameter("parameter4"));
	// inspectionrecord.setParameter5(request.getParameter("parameter5"));
	// inspectionrecord.setParameter6(request.getParameter("parameter6"));
	// inspectionrecord.setParameter7(request.getParameter("parameter7"));
	// inspectionrecord.setParameter8(request.getParameter("parameter8"));
	// inspectionrecord.setParameter9(request.getParameter("parameter9"));
	// inspectionrecord.setPressure(request.getParameter("pressure"));
	// inspectionrecord.setRecordLatitude(Double.valueOf(request.getParameter("recordLatitude")));
	// inspectionrecord.setRecordLongtitude(Double.valueOf(request.getParameter("recordLongtitude")));
	// inspectionrecord.setRecordStatus(request.getParameter("recordStatus"));
	// inspectionrecord.setTemperatureIn(request.getParameter("temperatureIn"));
	// inspectionrecord.setTemperatureOut(request.getParameter("temperatureOut"));
	//
	// int imgnum = Integer.parseInt(request.getParameter("photoNum"));
	//
	// // do insert
	// /*if (coreservice.insert(inspectionrecord)) {
	// j.setSuccess(true);
	// j.setMsg("记录新增成功");
	// } else {
	// j.setSuccess(false);
	// j.setMsg("记录新增失败");
	// }
	//
	//
	// return j;*/
	// return coreservice.insert(inspectionrecord,imgnum);
	// }
	// @SuppressWarnings("unchecked")
	// @RequestMapping(value = "/getParameterById.do")
	// public @ResponseBody Object getParameterById(HttpServletRequest request){
	//
	// try {
	// request.setCharacterEncoding("UTF-8");
	// } catch (UnsupportedEncodingException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// String sid = request.getParameter("equipmentId");
	// int id = Integer.parseInt(sid);
	// return coreservice.getParameterById(id);
	// }
	// @SuppressWarnings("unchecked")
	// @RequestMapping(value = "/getParams.do")
	// public @ResponseBody Object getParams(HttpServletRequest request){
	//
	// try {
	// request.setCharacterEncoding("UTF-8");
	// } catch (UnsupportedEncodingException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// String url = request.getParameter("url");
	// return coreservice.getParam(url);
	// }

	// @SuppressWarnings("unchecked")
	// @RequestMapping(value = "/downloadMedia.do")
	// public @ResponseBody Object downloadMedia(HttpServletRequest request){
	// System.out.println("以进入downloadMedia.do");
	// try {
	// request.setCharacterEncoding("UTF-8");
	// } catch (UnsupportedEncodingException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// System.out.println("以进入downloadMedia.do");
	// String mediaId = request.getParameter("serverIds");
	// System.out.println("mediaId="+mediaId);
	// String
	// basePath=request.getSession().getServletContext().getRealPath("/").substring(0,
	// request.getSession().getServletContext().getRealPath("/").lastIndexOf("bspheis-wechat"))+"/bspheis-uploads/images/";
	// return coreservice.downloadMedia(mediaId,basePath);
	// }

	@RequestMapping(value = "/onload.do")
	public JSONObject Onload(HttpServletRequest request) {
	
		String code = "";
		try {
			code = request.getParameter("code");
		} catch (Exception e) {
			e.printStackTrace();
		}
		// String equipmentId = request.getParameter("equipmentId");

		return null;//CoreServiceImpl_willdel.onload(code);
	}

}
