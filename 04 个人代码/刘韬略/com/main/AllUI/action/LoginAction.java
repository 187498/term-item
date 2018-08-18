package com.cjg.bank.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.cjg.bank.domain.UserInfo;
import com.cjg.bank.service.UserFacade;
import com.cjg.bank.service.UserFacadeImpl;


public class LoginAction {

	private String userNO;

	private String password;

	private UserFacade userFacade;

	public LoginAction() {
		userFacade = new UserFacadeImpl();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserNO() {
		return userNO;
	}

	public void setUserNO(String userNO) {
		this.userNO = userNO;
	}

	public String login() {
		boolean flag = false;
		UserInfo user = new UserInfo();
		user.setUserNO(getUserNO());
		user.setPassword(getPassword());
		try {
			flag = userFacade.login(user);
			// flag==true说明从数据库中查询出了与页面获得的帐号密码相匹配的结果
			if (flag == true) {
				UserInfo userInfo = userFacade.selectUser(userNO);
				HttpServletRequest request = ServletActionContext.getRequest();
				HttpSession session = request.getSession();
				// 将登录用户信息存入session
				session.setAttribute("user", userInfo);
				return "loginSuccess";
			} else {
				return "loginError";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "Error";
		}
	}

	public String logout() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		// 销毁session
		session.invalidate();
		return "logout";
	}
}
