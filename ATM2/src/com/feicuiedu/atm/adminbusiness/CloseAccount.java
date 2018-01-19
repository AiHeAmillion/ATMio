package com.feicuiedu.atm.adminbusiness;

import java.util.HashMap;
import java.util.Scanner;

import com.feicuiedu.atm.userinfo.LookAnAccount;
import com.feicuiedu.atm.userinfo.User;
import com.feicuiedu.atm.verification.VerifyAccount;

//销户
public class CloseAccount {
	public HashMap<String, User> AccountCancellation(HashMap<String, User> userInfoMap) {
		Scanner sc = new Scanner(System.in);
		System.out.println("*****************销户*******************");
		System.out.println("输入账号：");
		String strAccount = sc.nextLine();
		System.out.println("输入身份证号：");
		String strIdNo = sc.nextLine();
		
		//调用验证账号及身份证号
		VerifyAccount verifyAccount = new VerifyAccount();
		String key = verifyAccount.specialVerify(userInfoMap, strAccount, strIdNo);
		
		if (key.equals("false")) {
			//账号  身份证号错误 重新输入
			AccountCancellation(userInfoMap);
			return userInfoMap;
		}else {
			//正确查看一下信息
			LookAnAccount lookAnAccount = new LookAnAccount();
			lookAnAccount.look(userInfoMap, key);
			//信息无误 删除
			userInfoMap.remove(key);
			return userInfoMap;
		}
		
		
		
	}
}
