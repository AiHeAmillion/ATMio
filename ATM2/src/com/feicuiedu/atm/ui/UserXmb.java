package com.feicuiedu.atm.ui;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

//用户主界面
public class UserXmb {
	public int showUserXmb() {
		Scanner sc = new Scanner(System.in);
		//创建存储UI文件
		File file = new File("txt"+File.separator+"UserXmb.txt");
		ReadUi readUi = new ReadUi();
		if (file.exists()) {	//判断这个文件是否存在
			//已经存在直接读取
			readUi.rUi(file);
		}else {
			//没有文件创建
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			//读取
			readUi.rUi(file);
		}
		//接受 用户输入判断正确并返回
		int input = Integer.valueOf(sc.nextLine());
		boolean temp = (input==1)||(input==2)||(input==3)||(input==4)||(input==5)||(input==6);
		if (temp) {
			return input;
		}else {
			System.out.println("输入错误！重新输入");
			showUserXmb();
			return 0;
		}
	}
}
