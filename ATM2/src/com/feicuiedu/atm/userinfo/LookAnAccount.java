package com.feicuiedu.atm.userinfo;

import java.util.HashMap;

//显示一个用户的信息 便于修改 与 删除
public class LookAnAccount {
	public void look(HashMap<String, User> userInfoMap,String key) {
		System.out.println("1.姓名："+userInfoMap.get(key).getName());
		System.out.println("2.密码："+userInfoMap.get(key).getPassword());
		System.out.println("3.学历："+userInfoMap.get(key).getEducation());
		System.out.println("4.联系地址："+userInfoMap.get(key).getAddress());
		System.out.println("5.账号："+userInfoMap.get(key).getAccount());
		System.out.println("6.密码："+userInfoMap.get(key).getPassword());
		System.out.println("7.余额："+userInfoMap.get(key).getBalance());
		System.out.println("8.身份证号："+userInfoMap.get(key).getIdNo());
	}
}
