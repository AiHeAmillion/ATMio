package com.feicuiedu.atm.userbusiness;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

import com.feicuiedu.atm.Login;
import com.feicuiedu.atm.usercontrol.UserControl;
import com.feicuiedu.atm.userinfo.ReadUserInfo;
import com.feicuiedu.atm.userinfo.User;
import com.feicuiedu.atm.userinfo.WriteUserInfo;
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
					//输入的账号格式错误判断是否重输
					System.out.println("信息错误，重新输入(Y)或者退出(N)！");
					//下面判断 退出或者重新输入
					bb:
					do {
						String str3 = scanner.nextLine();
						if (str3.equals("Y")) {
							continue aa;
						}else if (str3.equals("N")) {
							//退出返回ATM主界面
							Login login = new Login();
							login.lin();
						}else {
							continue aa;
						}
					} while (true);	
					
				}else {
					//调用验证账号存在  存在 返回 key 键值对中该对象的键 不存在返回key="false"
					key = verifyAccount.accountExist(userInfoMap, strId);
					if (key.equals("false")) {	//不存在
						//输入的账号不存在 判断是否重输
						System.out.println("信息错误，重新输入(Y)或者退出(N)！");
						//下面判断 退出或者重新输入
						cc:
						do {
							String str3 = scanner.nextLine();
							if (str3.equals("Y")) {
								continue aa;
							}else if (str3.equals("N")) {
								//退出返回ATM主界面
								Login login = new Login();
								login.lin();
							}else {
								//输入Y/N之外的重新输入
								continue cc;
							}
						} while (true);	
					}else {
						//账号输入无误 并且存在
					}
				}
			}else if (strId.length() == 18) { // 输入号长度为18 就是身份证号
				//调用身份证账号格式  错误返回0 正确1
				int temp = verifyAccount.idNoLengeth(strId);
				if (temp == 0) { 
					//身份证号格式错误 判断是否重输
					System.out.println("信息错误，重新输入(Y)或者退出(N)！");
					//下面判断 退出或者重新输入
					dd:
					do {
						String str3 = scanner.nextLine();
						if (str3.equals("Y")) {
							continue aa;
						}else if (str3.equals("N")) {
							//退出返回ATM主界面
							Login login = new Login();
							login.lin();
						}else {
							//输入Y/N之外的重新输入
							continue dd;
						}
					} while (true);	
					
				}else {
					//调用验证身份证号存在  存在 返回 key 键值对中该对象的键 不存在返回key="false"
					key = verifyAccount.idNoExist(userInfoMap, strId);
					if (key.equals("false")) {	//不存在
						//输入的身份证不存在 判断是否重输
						System.out.println("信息错误，重新输入(Y)或者退出(N)！");
						//下面判断 退出或者重新输入
						ee:
						do {
							String str3 = scanner.nextLine();
							if (str3.equals("Y")) {
								continue aa;
							}else if (str3.equals("N")) {
								//退出返回ATM主界面
								Login login = new Login();
								login.lin();
							}else {
								//输入Y/N之外的重新输入
								continue ee;
							}
						} while (true);	
					}else {
						//身份证号输入无误 并且存在
					}
				}
			}else {
				// 输入既不是身份证又不是账号的  判断是否重输
				System.out.println("信息错误，重新输入(Y)或者退出(N)！");
				//下面判断 退出或者重新输入
				ff:
				do {
					String str3 = scanner.nextLine();
					if (str3.equals("Y")) {
						continue aa;
					}else if (str3.equals("N")) {
						//退出返回ATM主界面
						Login login = new Login();
						login.lin();
					}else {
						//输入Y/N之外的重新输入
						continue ff;
					}
				} while (true);	
			}
			
			//输入密码
			System.out.println("密码：");
			String strPassword = scanner.nextLine();
			//调用验证密码的正确
			boolean bln = verifyAccount.passwordExist(userInfoMap, key, strPassword);
			if (bln) {
				//密码正确 进入用户流程控制
				UserControl userControl = new UserControl();
				//登录流水记录
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");	//时间格式
				String str = sdf.format(new Date());	//获取当前时间按格式输出
				//存入流水信息指的是内存
				userInfoMap.get(key).setFlow(userInfoMap.get(key).getFlow().append("登录账户"+" "+str).append("\n"));	
				//写入文件
				WriteUserInfo writeUserInfo = new WriteUserInfo();
				writeUserInfo.write(userInfoMap, file);
				userControl.userFlowControl(key);
			}else {
				System.out.println("密码不正确重新输入");
				//返回ATM最初界面
				Login lin = new Login();
				lin.lin();
			}
		} while (true);
		
	}
}
