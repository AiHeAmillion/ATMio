package com.feicuiedu.atm.userinfo;

import java.io.Serializable;

public class User implements Serializable {
	private String account;	//账号
	private String password;
	private String name;
	private int gender;		//存储 1 / 2  1代表男，2代表女
	private String idNo;	//身份证号
	private String education;//学历
	private double balance = 0; // 余额
	private String address;	//联系地址
	private StringBuffer flow = new StringBuffer(); //流水
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getIdNo() {
		return idNo;
	}
	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	} 
	public StringBuffer getFlow() {
		return flow;
	}
	public void setFlow(StringBuffer flow) {
		this.flow = flow;
	}
	
}

/*账号
密码
姓名
性别
身份证号
学历
余额
联系地址*/
