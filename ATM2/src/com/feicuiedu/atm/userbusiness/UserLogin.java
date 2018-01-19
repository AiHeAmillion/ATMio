package com.feicuiedu.atm.userbusiness;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

import com.feicuiedu.atm.userinfo.ReadUserInfo;
import com.feicuiedu.atm.userinfo.User;
import com.feicuiedu.atm.verification.VerifyAccount;

//用户登录
public class UserLogin {
	public User userLin() {
		//用户信息文件肯定已经存在可以直接读取
		ReadUserInfo readUserInfo = new ReadUserInfo();
		File file = new File("txt"+File.separator+"UserInfo.txt");
		HashMap<String, User> userInfoMap = readUserInfo.read(file);
		
		//调用验证方法
		VerifyAccount verifyAccount = new VerifyAccount();
		String key  = "";
		aa:
		do {
			//输入账号/身份证号
			Scanner scanner = new Scanner(System.in);
			System.out.println("账户/身份证号：");
			String strId = scanner.nextLine();
			if (strId.length() == 21) {   // 输入号长度为21 就是账号
				//调用验证账号格式  错误返回0 正确1
				int temp = verifyAccount.accountLengeth(strId);
				if (temp == 0) { // 错误
					continue aa; //重新输入
				}else {
					//调用验证账号存在  存在 返回 key 键值对中该对象的键 不存在返回key="false"
					key = verifyAccount.accountExist(userInfoMap, strId);
					if (key.equals("false")) {	//不存在
						continue aa;
					}else {
						//账号输入无误 并且存在
					}
				}
			}else if (strId.length() == 18) { // 输入号长度为18 就是身份证号
				//调用身份证账号格式  错误返回0 正确1
				int temp = verifyAccount.idNoLengeth(strId);
				if (temp == 0) { // 错误
					continue aa; //重新输入
				}else {
					//调用验证身份证号存在  存在 返回 key 键值对中该对象的键 不存在返回key="false"
					key = verifyAccount.idNoExist(userInfoMap, strId);
					if (key.equals("false")) {	//不存在
						continue aa;
					}else {
						//身份证号输入无误 并且存在
					}
				}
			}
			
			//输入密码
			System.out.println("密码：");
			String strPassword = scanner.nextLine();
			//调用验证密码的正确
			boolean bln = verifyAccount.passwordExist(userInfoMap, key, strId);
			if (bln) {
				//密码正确返回此键值对的对象
				return userInfoMap.get(key);
			}else {
				System.out.println("密码不正确重新输入");
				continue aa;
			}
		} while (true);
		
	}
}
