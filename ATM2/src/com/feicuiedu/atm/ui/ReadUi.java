package com.feicuiedu.atm.ui;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//读取 UI 界面
public class ReadUi {
	public void rUi(File file) {
		//输入流 文件到程序 
		try {
			FileInputStream inputStream = new FileInputStream(file);
			FileInputStream fis = new FileInputStream(file);
			byte[] b = new byte[1024];
			int count = 0;
			while((count = fis.read(b)) != -1) {
				String str = new String(b,0,count);
				System.out.println(str);	
			}
			
			//关闭流
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
