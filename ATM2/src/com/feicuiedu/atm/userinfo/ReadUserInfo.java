package com.feicuiedu.atm.userinfo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.HashMap;

// 读取userInfo 文件
public class ReadUserInfo implements Serializable{
	public HashMap<String, User> read(File file) {	//读取文件 输入流 从文件到程序
		
		try {
			FileInputStream inputStream = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(inputStream);
			
			//序列化读出文件的Map赋值到新的Map
			HashMap<String, User> userInfoMap = (HashMap<String, User> )ois.readObject();
			//关闭流
			ois.close();
			//返回这个新的Map
			return userInfoMap;
			
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
		
	}
}
