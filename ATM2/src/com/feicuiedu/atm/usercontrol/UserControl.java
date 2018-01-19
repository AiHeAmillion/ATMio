package com.feicuiedu.atm.usercontrol;

import java.io.File;
import java.util.HashMap;

import com.feicuiedu.atm.Login;
import com.feicuiedu.atm.adminbusiness.ChangeAccount;
import com.feicuiedu.atm.adminbusiness.CloseAccount;
import com.feicuiedu.atm.adminbusiness.OpenAccount;
import com.feicuiedu.atm.adminbusiness.ShowUserInfo;
import com.feicuiedu.atm.ui.AdminXmb;
import com.feicuiedu.atm.ui.UserXmb;
import com.feicuiedu.atm.userbusiness.Query;
import com.feicuiedu.atm.userinfo.CreateHashMap;
import com.feicuiedu.atm.userinfo.CreateSaveFile;
import com.feicuiedu.atm.userinfo.ReadUserInfo;
import com.feicuiedu.atm.userinfo.User;
import com.feicuiedu.atm.userinfo.WriteUserInfo;

/**
 * 
 * @author 宁强
 * 	1.查询
 *	2.转账
 *	3.存款
 *	4.取款
 *	5.流水
 *	6.退出
 * 用户业务流程控制
 *
 */
public class UserControl {
	public void userFlowControl(String key) {
/*		//用户需要从 HashMap<String,User>集合提取出自己的对象，没有就创建，有了就读取出来用于操作
		File file = new File("txt"+File.separator+"UserInfo.txt");
		//检测文件是否存在以及创建
		CreateSaveFile createSaveFile = new CreateSaveFile();
		file = createSaveFile.createFile(file);
		//检测文件中是否有HashMap<String,User>集合，有就读取，没有就创建
		CreateHashMap createHashMap = new CreateHashMap();
		HashMap<String,User> userInfoMap = createHashMap.createHp(file); */
		
		
		aa:
		do {
			//创建写入文件类的对象
			WriteUserInfo writeUserInfo = new WriteUserInfo();
			//创建读取文件类对象
			ReadUserInfo readUserInfo = new ReadUserInfo();
			File file = new File("txt"+File.separator+"UserInfo.txt");
			//获取文件里的集合Map
			HashMap<String, User> userInfoMap= readUserInfo.read(file);
			
			// 用户业务主界面
			UserXmb userXmb = new UserXmb();
			//显示完界面并返回用户输入的下一步
			int input = userXmb.showUserXmb();
			
			if (input == 1) {
				//查询
				Query query = new Query();
				query.userQuery(userInfoMap.get(key));
				continue aa;//返回管理员界面
			}else if (input == 2) {
				//销户
				CloseAccount closeAccount = new CloseAccount();
				closeAccount.AccountCancellation(userInfoMap);
				//写入文件
				writeUserInfo.write(userInfoMap, file);
				continue aa;//返回管理员界面
			}else if (input == 3) {
				//显示信息
				ShowUserInfo showUserInfo = new ShowUserInfo();
				showUserInfo.show(userInfoMap);
				//对数据无操作不需要 写入
				continue aa;//返回管理员界面
			}else if (input == 4) {
				//修改信息
				ChangeAccount changeAccount = new ChangeAccount();
				changeAccount.change(userInfoMap);
				//写入文件
				writeUserInfo.write(userInfoMap, file);
				continue aa;//返回管理员界面
			}else if (input == 5) {
				//退出
				Login login = new Login();
				login.lin();
			}
		} while (true);
	}
}
