package com.feicuiedu.atm.userinfo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class CreateSaveFile {
	
	public File createFile(File file) {	//创建各种存储的文件
		//File file = new File("txt"+File.separator+"UserInfo.txt");
		if (file.exists()) {	//判断这个文件是否存在
			return file; 
		}else {
			
			//没有文件创建
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			return file;
		}
	}
}
