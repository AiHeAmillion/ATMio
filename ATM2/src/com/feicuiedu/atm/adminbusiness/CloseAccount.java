package com.feicuiedu.atm.adminbusiness;

import java.util.HashMap;
import java.util.Scanner;

import com.feicuiedu.atm.admincontrol.AdmainControl;
import com.feicuiedu.atm.usercontrol.UserControl;
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
			aa:
				do{			//do while循环+标签 处理 输入 1 2 3之外其他东西时重新输入
					System.out.println("     1.确认删除");
					System.out.println("     2.重新输入");
					System.out.println("     3.返回菜单");
					int temp = Integer.valueOf(sc.nextLine());
					if (temp == 1) {
						//确认无误 删除 并返回更新后的userInfo
						userInfoMap.remove(key);
						System.out.println("删除成功！");
						return userInfoMap;
					}else if (temp == 2) {
						//重新输入
						AccountCancellation(userInfoMap);
					}else if (temp == 3) {
						//返回菜单
						AdmainControl admainControl = new AdmainControl();
						admainControl.adminFlowControl();
					}else {
						System.out.println("输入错误，重新输入！");
						continue aa;
					}
				}while(true);
			
		}
		
		
		
	}
}
