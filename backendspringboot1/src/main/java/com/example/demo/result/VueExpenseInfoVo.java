package com.example.demo.result;

import javax.validation.constraints.NotNull;

/** 
 * @description Vue登录页面demo信息对象实体
 * @author WANGJIHONG
 * @date 2018年4月5日 下午10:57:53 
 * @Copyright 版权所有 (c) www.javalsj.com
 * @memo 备注信息
 */
public class VueExpenseInfoVo {
    private String username;
    private String password;
    private String requestNo;
    private String requestType;
    private String expenseType;
    private String requesterId;
    private String requestDate;
    private String fromDate;
    private String endDate;
    private String currency;
    private String account;
    private String attachReceipt;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRequestNo() {
		return requestNo;
	}
	public void setRequestNo(String requestNo) {
		this.requestNo = requestNo;
	}
	public String getRequestType() {
		return requestType;
	}
	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}
	public String getExpenseType() {
		return expenseType;
	}
	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}
	public String getRequesterId() {
		return requesterId;
	}
	public void setRequesterId(String requesterId) {
		this.requesterId = requesterId;
	}
	public String getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getAttachReceipt() {
		return attachReceipt;
	}
	public void setAttachReceipt(String attachReceipt) {
		this.attachReceipt = attachReceipt;
	}
}
