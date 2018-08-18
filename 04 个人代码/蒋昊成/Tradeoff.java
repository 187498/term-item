package com.scu03.bean;
/**
 * 交易记录类
 */

import java.util.Date;


public class Tradeoff {
	private Date date;
	private float trade_funds;
	private String user_account;
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public float getTrade_funds() {
		return trade_funds;
	}
	public void setTrade_funds(float trade_funds) {
		this.trade_funds = trade_funds;
	}
	public String getUser_account() {
		return user_account;
	}
	public void setUser_account(String user_account) {
		this.user_account = user_account;
	}
	

}
