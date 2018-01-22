package com.feicuiedu.atm.adminbusiness;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

import com.feicuiedu.atm.userinfo.User;
import com.feicuiedu.atm.verification.VerifyAccount;

//管理员开户
public class OpenAccount {
	public HashMap<String, User> createAccount(HashMap<String, User> userInfoMap) {	
		//管理员输入的部分
		Scanner sc = new Scanner(System.in);
		User user = new User();
		System.out.println("***************开通账号*****************");
		System.out.println("输入用户的信息");
		System.out.println("序号(年份+0001开始)：");
		String number = (sc.nextLine());
		System.out.println("姓名：");
		user.setName(sc.nextLine());
		System.out.println("性别(输入1/2,1代表男，2代表女)：");
		user.setGender(Integer.valueOf(sc.nextLine()));
		System.out.println("学历(输入1/2/3/4,1代表小学 2代表中学3代表大学 4代表其他)：");
		user.setEducation(sc.nextLine());
		
		// 加个验证 验证输入身份证号是否正确和唯一
		aa:
		do {
			System.out.println("身份证号："); 
			String strIdNo = sc.nextLine();
			VerifyAccount verifyAccount = new VerifyAccount();
			//验证长度格式是否正确
			int temp = verifyAccount.idNoLengeth(strIdNo);
			if (temp == 0) {
				//身份证号输入格式错误
				continue aa;
			}else {
				//验证身份证号是否已经存在
				String temp1 = verifyAccount.idNoExist(userInfoMap, strIdNo);
				if (temp1.equals("false")) {
					//账号不存在存入user 跳出输入下面
					user.setIdNo(strIdNo);
					break;
				}else {
					System.out.println("身份证号已经存在，重新输入！");
					continue aa;
				}
			}
		} while (true);
		
		System.out.println("联系地址(不得超过50位)：");
		user.setAddress(sc.nextLine());
		
		//判断密码的正则
		System.out.println("密码：");
		user.setPassword(sc.nextLine());
		
		//下面应该是生成账号
		//账号 系统自动生成  规则  37+(如果是男01,如果是女02)+当前时间(年月日时分秒毫秒)
		Date date = new Date();	//获取时间
				
		//格式化输出时间，有没更好方式？
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmsssss");
		String str = "370"+user.getGender()+sdf.format(date);
		user.setAccount(str);
				
		//显示账号信息
		System.out.println("账号：");
		System.out.println(str);
		//是否加个验证账号密码的正确性
		
		userInfoMap.put(number, user);
		System.out.println("开户成功！");
		return userInfoMap;
	
	}
}
