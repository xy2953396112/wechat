package com.sliansoft.wechat.main;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sliansoft.wechat.pojo.Button;
import com.sliansoft.wechat.pojo.CommonButton;
import com.sliansoft.wechat.pojo.ComplexButton;
import com.sliansoft.wechat.pojo.Menu;
import com.sliansoft.wechat.util.WeixinUtil;

/**
 * 菜单管理器类
 * 目前自定义菜单最多包括3个一级菜单，每个一级菜单最多包含5个二级菜单。一级菜单最多4个汉字，二级菜单最多7个汉字，多出来的部分将会以“...”代替。
 */
public class MenuManager {
	private static Logger log = LoggerFactory.getLogger(MenuManager.class);

	public static void main(String[] args) {
		// 第三方用户唯一凭证
		String appId = "wx65706b1910bb4356";
		// 第三方用户唯一凭证密钥
		String appSecret = "f1224a48570a256bde7ee9dda471fbd6";

		int tt = WeixinUtil
				.createMenu(
						getMenu(),
						"CgKBFgwIn0lnYpryq02Z2f_99AKRBMGwubO5OCG3hPtO6HQSYG_AP8Si-rUQsHuhESYG2vhkr8pVlcaryhCzWFjGFgB-smkHO6Gko7Z6KBBBeSxUdjE2SFF9WrAhpD4yKCZdAHABTQ");
	}

	private static Menu getMenu() {

		CommonButton btn11 = new CommonButton();
		btn11.setName("找项目");
		btn11.setType("view");
		btn11.setUrl("http://www.sliansoft.com");

		CommonButton btn12 = new CommonButton();
		btn12.setName("申请算客");
		btn12.setType("view");
		btn12.setUrl("http://www.sliansoft.com");

		CommonButton btn13 = new CommonButton();
		btn13.setName("申请企业");
		btn13.setType("view");
		btn13.setUrl("http://www.sliansoft.com");
		CommonButton btn14 = new CommonButton();
		btn14.setName("我参与的项目");
		btn14.setType("view");
		btn14.setUrl("http://www.sliansoft.com");
		CommonButton btn15 = new CommonButton();
		btn15.setName("认证考试");
		btn15.setType("view");
		btn15.setUrl("http://www.sliansoft.com");

		CommonButton btn21 = new CommonButton();
		btn21.setName("发项目");
		btn21.setType("view");
		btn21.setUrl("http://www.sliansoft.com");

		CommonButton btn22 = new CommonButton();
		btn22.setName("找算师");
		btn22.setType("view");
		btn22.setUrl("http://www.sliansoft.com");

		CommonButton btn23 = new CommonButton();
		btn23.setName("找企业");
		btn23.setType("view");
		btn23.setUrl("http://www.sliansoft.com");

		CommonButton btn24 = new CommonButton();
		btn24.setName("咨询");
		btn24.setType("view");
		btn24.setUrl("http://www.sliansoft.com");

		CommonButton btn31 = new CommonButton();
		btn31.setName("访问我们");
		btn31.setType("view");
		btn31.setUrl("http://www.sliansoft.com");
		CommonButton btn32 = new CommonButton();
		btn32.setName("关于我们");
		btn32.setType("view");
		btn32.setUrl("http://www.sliansoft.com");

		CommonButton btn33 = new CommonButton();
		btn33.setName("帐户绑定");
		btn33.setType("click");
		btn33.setKey("33"); 

		CommonButton btn34 = new CommonButton();
		btn34.setName("项目订阅");
		btn34.setType("view");
		btn34.setUrl("http://www.sliansoft.com");

		ComplexButton mainBtn1 = new ComplexButton();
		mainBtn1.setName("你托");
		mainBtn1.setSub_button(new CommonButton[] { btn11, btn12, btn13, btn14,	btn15 });

		ComplexButton mainBtn2 = new ComplexButton();
		mainBtn2.setName("我算");
		mainBtn2.setSub_button(new CommonButton[] { btn21, btn22, btn23, btn24 });

		ComplexButton mainBtn3 = new ComplexButton();
		mainBtn3.setName("我的");
		mainBtn3.setSub_button(new CommonButton[] { btn31, btn32, btn33, btn34 });

		/**
		 * 一级菜单下没有二级菜单的情况，menu定义： menu.setButton(new Button[] { mainBtn1,
		 * mainBtn2, btn33 });
		 */
		Menu menu = new Menu();
		menu.setButton(new Button[] { mainBtn1, mainBtn2, mainBtn3 });

		return menu;
	}
}
