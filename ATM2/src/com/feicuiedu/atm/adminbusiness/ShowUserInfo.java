package com.feicuiedu.atm.adminbusiness;

import java.util.HashMap;
import java.util.Set;

import com.feicuiedu.atm.userinfo.User;

//显示所有开户信息
public class ShowUserInfo {
	public void show(HashMap<String, User> userInfoMap){
		System.out.println("***************显示信息*****************");
		//获取Map键的Set集
		Set<String> keys = userInfoMap.keySet();
		//键集遍历
		for(String i :keys ) {
			//通过键获取到值，值为user
			System.out.println("姓名："+userInfoMap.get(i).getName());
			System.out.println("性别："+userInfoMap.get(i).getGender());
			System.out.println("学历："+userInfoMap.get(i).getEducation());
			System.out.println("身份证号："+userInfoMap.get(i).getIdNo());
			System.out.println("联系地址："+userInfoMap.get(i).getAddress());
			System.out.println("账号："+userInfoMap.get(i).getAccount());
			System.out.println("密码："+userInfoMap.get(i).getPassword());
			System.out.println("余额："+userInfoMap.get(i).getBalance());
		}
				
	}
}
