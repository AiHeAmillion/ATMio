package com.feicuiedu.atm.userbusiness;

import java.util.Scanner;

import com.feicuiedu.atm.userinfo.User;

//流水信息
public class DealFlow {
	public void userFlow(User user){	//显示流水
		System.out.println("交易流水");
		System.out.println(user.getFlow());
		System.out.println("1.返回上一级");
		Scanner sc = new Scanner(System.in);
		int input = Integer.valueOf(sc.nextLine());
		if (input !=1 ) {	//判断输入的是不是 1
			System.out.println("输入错误！重新输入");
			userFlow(user);
		}
	}
}
