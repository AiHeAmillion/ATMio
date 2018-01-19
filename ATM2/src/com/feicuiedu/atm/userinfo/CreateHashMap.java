package com.feicuiedu.atm.userinfo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *1.先判断文件是否存在 已在createuserinfo实现
 *2.文件空创建Map不空取出Map用
 *3.开户把user存储到Map
 *4.把Map写入文件
 */

//从文件到程序 输入流 没有Map创建  有了取出来用
public class CreateHashMap implements Serializable{			
	public HashMap<String, User> createHp(File file){
		
		
		if (file.length()==0) {	//文件是否为空
			//文件空里面没有Map , 新建一个Map
			HashMap<String, User> userInfoMap= new HashMap<String, User>();
			return userInfoMap;
		}
		try {	// 已经有Map读出这个Map并返回，将要操作此Map
			//输入流
			FileInputStream inputStream = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(inputStream);
			
			HashMap<String, User> userInfoMap = (HashMap<String, User>) ois.readObject();
			ois.close();
			return userInfoMap;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;	//注意这里不能用try里的东西
	}
}
