package com.feicuiedu.atm;

import java.io.File;
import java.util.Scanner;

import com.feicuiedu.atm.adminbusiness.AdminLogin;
import com.feicuiedu.atm.ui.ReadUi;
import com.feicuiedu.atm.userbusiness.UserLogin;

//主登录界面
public class Login {
	public void lin(){
		File file = new File("txt"+File.separator+"Login.txt");
		
		aa:
		do {
			//读取文本
			ReadUi readUi = new ReadUi();
			readUi.rUi(file);
			//接受用户输入选项
			Scanner scanner = new Scanner(System.in);
			int input = Integer.valueOf(scanner.nextLine());
			if (input == 1) {
				//管理员登录
				AdminLogin adminLogin = new AdminLogin();
				adminLogin.adminLin();
			}else if(input == 2){
				//用户登录
				UserLogin userLogin = new UserLogin();
				userLogin.userLin();
			}else{
				System.out.println("输入错误，重新输入！");
				continue aa;
			}
		} while (true);

		
	}
}
