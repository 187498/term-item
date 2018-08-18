package com.cjg.bank.action.validateAction;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class LoginValidate extends ActionSupport{
	private String userNO;

	private String password;

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

}
