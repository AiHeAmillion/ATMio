package com.feicuiedu.atm.adminbusiness;

import java.util.Scanner;

import com.feicuiedu.atm.Login;
import com.feicuiedu.atm.admincontrol.AdmainControl;

//管理员登录界面
public class AdminLogin {
	public void adminLin() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("管理员账户：");
		String str = scanner.nextLine();
		System.out.println("账户密码：");
		String str1 = scanner.nextLine();
		System.out.println("账户姓名：");
		String str2 = scanner.nextLine();
		
		//验证三条信息是否正确
		if (str.equals("370120180104")&&str1.equals("123456")&&str2.equals("翡翠侠")) {
			//信息正确 进入管理员业务的流程控制
			AdmainControl admainControl = new AdmainControl();
			admainControl.adminFlowControl();
		}else {
			System.out.println("信息错误，重新输入(Y)或者退出(N)！");
			//下面判断 退出或者重新输入
			aa:
			do {
				String str3 = scanner.nextLine();
				if (str3.equals("Y")) {
					adminLin(); // 重新输入
				}else if (str3.equals("N")) {
					//退出返回ATM主界面
					Login login = new Login();
					login.lin();
				}else {
					continue aa;
				}
			} while (true);	
		}
		

	}
}
