package com.feicuiedu.atm.userinfo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

public class WriteUserInfo implements Serializable {		//从程序到文件 输出流 
	public void write(HashMap<String, User> userInfoMap,File file) {
		
		try {
			FileOutputStream outputStream = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(outputStream);
			// 序列化对象，写入输出流 从程序到文件
			oos.writeObject(userInfoMap);
			//刷新流
			//关闭流
			oos.flush();
			oos.close();
		} catch ( IOException e) {
			e.printStackTrace();
		}
		
	}
}
