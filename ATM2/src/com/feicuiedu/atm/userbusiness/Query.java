package com.feicuiedu.atm.userbusiness;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.feicuiedu.atm.userinfo.User;

//用户查询
public class Query {
	public int userQuery(User user){   			// 显示用户信息 返回值为用户在此输入值 参数为user类的一个对象 
		System.out.println("账户姓名:"+user.getName());
		System.out.println("账户余额:"+user.getBalance());
		System.out.println("1.返回上一级");
		//Date date = new Date();

/*		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");	//时间格式
		String str = sdf.format(new Date());	//获取当前时间按格式输出
		DealFlow df = new DealFlow();
		df.buildFlow(user,"查询业务"+" "+str);	//调用创建流水  把这次流水存入
*/
		Scanner sc = new Scanner(System.in);
		int input = Integer.valueOf(sc.nextLine());
		if (input !=1 ) {	//判断输入的是不是 1
			System.out.println("输入错误！重新输入");
			userQuery(user);
		}
		return input;
	}
}
