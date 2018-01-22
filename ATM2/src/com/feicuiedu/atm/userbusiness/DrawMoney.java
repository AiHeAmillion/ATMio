package com.feicuiedu.atm.userbusiness;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

import com.feicuiedu.atm.usercontrol.UserControl;
import com.feicuiedu.atm.userinfo.User;

//用户取钱
public class DrawMoney {
	Scanner scanner = new Scanner(System.in);
	public HashMap<String, User> userDraw(HashMap<String, User> userInfoMap,String key){		//取钱方法 返回值 参数为 User类的一个user对象
		//获取指定键的值 = 要操作的对象
		User user = userInfoMap.get(key);
		System.out.println("*****取款业务*****");
		System.out.println("请输入取款金额：");	
		double input = Double.valueOf(scanner.nextLine()); //接受输入的取钱数

		if (user.getBalance()<input) {	
			//判断余额是否足够 不足的话返回主界面暗示用户查询余额或其他操作
			System.out.println("余额不足！");
			UserControl userControl = new UserControl();
			userControl.userFlowControl(key);
		}

		aa:
		do{			//do while循环+标签 处理 输入 1 2 3之外其他东西时重新输入
			System.out.println("     1.确认");
			System.out.println("     2.重新输入");
			System.out.println("     3.返回菜单");
			int temp = Integer.valueOf(scanner.nextLine());
			if (temp == 1) {
				user.setBalance(user.getBalance()-input);	// 余额为 钱数 - 取钱数

				String s_temp = Double.toString(input);	//把取钱数转成字符串
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");	//时间格式
				String str = sdf.format(new Date());	//获取当前时间按格式输出
				//存入流水信息
				user.setFlow(user.getFlow().append("取款业务"+" "+"取款"+s_temp+"元 "+" "+str).append("\n"));	
				
				System.out.println("操作成功，返回主界面！");
				//更新这个Map集合
				userInfoMap.put(key, user);
				//返回这个新Map
				return userInfoMap;
			}else if (temp == 2) {
				userDraw(userInfoMap,key);
			}else if (temp == 3) {
				break;
			}else{
				System.out.println("输入错误，请重新输入！");
				continue aa;
			}
		}
		while(true);
		//永远不会运行这段
		return userInfoMap;
	}
}
