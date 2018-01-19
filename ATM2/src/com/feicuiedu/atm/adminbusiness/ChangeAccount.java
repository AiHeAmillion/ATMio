package com.feicuiedu.atm.adminbusiness;

import java.util.HashMap;
import java.util.Scanner;

import com.feicuiedu.atm.userinfo.LookAnAccount;
import com.feicuiedu.atm.userinfo.User;
import com.feicuiedu.atm.verification.VerifyAccount;

//修改信息
public class ChangeAccount {
	public HashMap<String, User> change(HashMap<String, User> userInfoMap){
		Scanner scanner = new Scanner(System.in);
		System.out.println("*****************修改信息***************");
		System.out.println("输入修改的账号：");
		String input = scanner.nextLine();
		//验证账号
		VerifyAccount verifyAccount = new VerifyAccount();
		//长度格式验证 账号错误 返回0  正确返回1
		int temp = verifyAccount.accountLengeth(input);
		//账号存在验证
		if (temp==1) {
			//账号存在 返回该要修改的对象的键 不存在返回 key="false"
			String key = verifyAccount.accountExist(userInfoMap, input);
			if (key.equals("false")) {
				//账号不存在 重新输入
				change(userInfoMap);
				return userInfoMap;				
			}else {
				//显示要修改用户信息
				boolean bln = true;
				while(true) {
					LookAnAccount lAnAccount = new LookAnAccount();
					lAnAccount.look(userInfoMap, key);
					System.out.println("输入要修改项，5/6/7/8为不可修改修改：");
					int temp1 = Integer.valueOf(scanner.nextLine());
					if (temp1 == 1) {
						System.out.println("输入新的信息：");
						//1.姓名
						userInfoMap.get(key).setName(scanner.nextLine());
						return userInfoMap;
					}else if (temp == 2) {
						System.out.println("输入新的信息：");
						//2.密码
						userInfoMap.get(key).setPassword(scanner.nextLine());
						return userInfoMap;
					}else if (temp1 == 3) {
						System.out.println("输入新的信息：");
						//3.学历
						userInfoMap.get(key).setEducation(scanner.nextLine());
						return userInfoMap;
					}else if (temp1 == 4) {
						System.out.println("输入新的信息：");
						//4.联系地址
						userInfoMap.get(key).setAddress(scanner.nextLine());
						return userInfoMap;
					}else {
						//输入 1 2 3 4 之外的  返回重新输入
						bln = true;
					}
				}
			}
		}else {
			//账号格式长度不对
			change(userInfoMap);
			return userInfoMap;	
		}
		
	}
}
