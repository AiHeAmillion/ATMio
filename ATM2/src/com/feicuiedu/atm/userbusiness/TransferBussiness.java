package com.feicuiedu.atm.userbusiness;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

import com.feicuiedu.atm.usercontrol.UserControl;
import com.feicuiedu.atm.userinfo.User;
import com.feicuiedu.atm.verification.VerifyAccount;

//用户转账
public class TransferBussiness {
	Scanner sc = new Scanner(System.in);
	//转账
	public void userTransfer(HashMap<String, User> userInfoMap,String key){	

		System.out.println("*****转账业务*****");
		System.out.println("请输入对方银行卡号：");		
		String number = sc.nextLine();				//对方卡号
		System.out.println("请输入转账金额：");	
		double temp = Double.valueOf(sc.nextLine());//转账的金额

		String key2 = "";  // 2号用户的键
		//调用验证 输入的2号User账号是否存在
		VerifyAccount verifyAccount = new VerifyAccount();
		//不存在返回“false” 存在返回该账号对应User对应的键
		key2 = verifyAccount.accountExist(userInfoMap, number);
		if (key2.equals("false")) {	
			//账号不存在 
			userTransfer(userInfoMap, key);		
		}else{

		}

		if (userInfoMap.get(key).getBalance()<temp) { //检测余额是否足够转账
			System.out.println("余额不足！");
			//跳转到菜单 暗示查询
			UserControl userControl = new UserControl();
			userControl.userFlowControl(key);
		}else{

		}
		
		aa:
		do{
			System.out.println("     1.确认");
			System.out.println("     2.重新输入");
			System.out.println("     3.返回菜单");
			int temp2 = Integer.valueOf(sc.nextLine());
			if (temp2 == 1) {				// 1 确认
/*				if ( !(number.equals(account[idx].getNumber())) ) {		//判断输入卡号是否正确
					System.out.println("*****转账业务 - 显示对方信息*****");
					System.out.println("输入账号有误请重新输入！");
					transfer(user,account);													//不正确返回转账界面
				}*/

					showInformation(userInfoMap,key,key2,temp);		//弹出显示对方信息界面
					break;
			}else if (temp2 == 2) {		// 2 重新输入
				//重新调用转账界面
				userTransfer(userInfoMap, key);			
			}else if (temp2 == 3) {
				// 3 返回菜单
				break;				
			}else{
				System.out.println("输入错误，请重新输入！");
				continue aa;
			}
		}
		while(true);
	}	
	//显示对方卡号信息方法 
	public void	showInformation(HashMap<String, User> userInfoMap,String key,String key2,double temp){	
		aa:
		do{	
			System.out.println("对方卡号："+userInfoMap.get(key2).getAccount());
			System.out.println("对方姓名："+userInfoMap.get(key2).getName());
			System.out.println("转账金额："+temp);	
			System.out.println("     1.确认转账");
			System.out.println("     2.返回上一级");
			System.out.println("     3.退卡");
			int temp5 = Integer.valueOf(sc.nextLine());
			if (temp5 == 1) {	// 1确认转账
				// 1卡余额为余额-转账金额
				userInfoMap.get(key).setBalance(userInfoMap.get(key).getBalance()-temp);
				// 转账账户加钱
				userInfoMap.get(key2).setBalance(userInfoMap.get(key2).getBalance()+temp);
				
				String s_temp = Double.toString(temp);	//把取钱数转成字符串
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");	//时间格式
				String str = sdf.format(new Date());	//获取当前时间按格式输出
				//1号用户存入流水信息
				userInfoMap.get(key).setFlow(userInfoMap.get(key).getFlow().append("转账业务"+" "+"向"+userInfoMap.get(key2).getAccount()+"转"+s_temp+"元"+" "+str).append("\n"));	
				//2号用户存入流水信息
				userInfoMap.get(key2).setFlow(userInfoMap.get(key2).getFlow().append("转账业务"+" "+"收到"+userInfoMap.get(key).getAccount()+"转"+s_temp+"元"+" "+str).append("\n"));
				
				System.out.println("操作成功！");
				break;
			}else if (temp5 == 2) {		// 2返回上一级
				userTransfer(userInfoMap, key);	//返回转账界面
			}else if (temp5 == 3) {		// 3返回菜单
				//跳转到菜单界面 即到流程控制从头开始
				UserControl userControl = new UserControl();
				userControl.userFlowControl(key);
			}else{
				//输入 1 2 3之外的东西还在显示界面
				System.out.println("输入错误，请重新输入！");
				showInformation(userInfoMap,key,key2,temp);
			}
		}
		while(true);
	}
}
