package com.feicuiedu.atm.ui;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

//管理员主界面
public class AdminXmb {
	public int showAdminXmb() {	
		Scanner sc = new Scanner(System.in);
		//创建存储UI文件
		File file = new File("txt"+File.separator+"AdminXmb.txt");
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
		//接受 管理员输入判断正确并返回
		int input = Integer.valueOf(sc.nextLine());
		boolean temp = (input==1)||(input==2)||(input==3)||(input==4)||(input==5);
		if (temp) {
			return input;
		}else {
			System.out.println("输入错误！重新输入");
			showAdminXmb();
			return 0;
		}
		
		
	}
}
