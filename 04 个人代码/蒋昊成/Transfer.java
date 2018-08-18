package com.scu03.bean;

import java.util.Date;

public class Transfer {
	private String out_account;
	private String in_account;
	private float funds;
	private Date date;
	public String getOut_account() {
		return out_account;
	}
	public void setOut_account(String out_account) {
		this.out_account = out_account;
	}
	public String getIn_account() {
		return in_account;
	}
	public void setIn_account(String in_account) {
		this.in_account = in_account;
	}
	public float getFunds() {
		return funds;
	}
	public void setFunds(float funds) {
		this.funds = funds;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	

}
