package com.feicuiedu.atm.userbusiness;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

import com.feicuiedu.atm.userinfo.User;

//用户存钱
public class SaveMoney {
	public HashMap<String, User> userSave(HashMap<String, User> userInfoMap,String key){		//存款方法 无返回值 参数为要操作的User对象
		//获取指定键的值 = 要操作的对象
		User user = userInfoMap.get(key);
		System.out.println("*****存款业务*****");
		System.out.println("请输入存款金额：");	
		Scanner sc = new Scanner(System.in);
		double input = Double.valueOf(sc.nextLine()); //接受输入的存钱数
		
		aa:
		do{		//do while循环+标签 处理 输入 1 2 3之外其他东西时重新输入
			System.out.println("     1.确认");
			System.out.println("     2.重新输入");
			System.out.println("     3.返回菜单");
			int temp = Integer.valueOf(sc.nextLine());
			if (temp == 1) {
				user.setBalance(user.getBalance()+input);	//余额为钱数 + 存钱数

				String s_temp = Double.toString(input);	//把取钱数转成字符串
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");	//时间格式
				String str = sdf.format(new Date());	//获取当前时间按格式输出
				//存入流水信息
				user.setFlow(user.getFlow().append("存款业务"+" "+"存款"+s_temp+"元"+" "+str).append("\n"));	

				System.out.println("操作成功，自动返回主界面！");
				//更新Map里此键对应的值（对象）
				userInfoMap.put(key, user);
				//返回这个更新后的Map集合
				return userInfoMap;
			}else if (temp == 2) {
				userSave(userInfoMap,key);
			}else if (temp == 3) {
				break;
			}else{
					System.out.println("输入错误，请重新输入！");
					continue aa;
			}
		}
		while(true);
		//这里 永远取值不到
		return userInfoMap;
	}
}
