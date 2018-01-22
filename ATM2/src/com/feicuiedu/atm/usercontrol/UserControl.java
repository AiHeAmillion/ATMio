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
import com.feicuiedu.atm.userbusiness.DealFlow;
import com.feicuiedu.atm.userbusiness.DrawMoney;
import com.feicuiedu.atm.userbusiness.Query;
import com.feicuiedu.atm.userbusiness.SaveMoney;
import com.feicuiedu.atm.userbusiness.TransferBussiness;
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
				//对数据无操作 不需要写入文件
				continue aa;//返回管理员界面
			}else if (input == 2) {
				//转账
				TransferBussiness transferBussiness = new TransferBussiness();
				//转账这里的方法直接操作的集合 的键与值 所以不需要创建一个新的集合接受与其他业务不同
				transferBussiness.userTransfer(userInfoMap, key);
				//写入文件
				writeUserInfo.write(userInfoMap, file);
				continue aa;//返回管理员界面
			}else if (input == 3) {
				//存款
				SaveMoney saveMoney = new SaveMoney();
				userInfoMap = saveMoney.userSave(userInfoMap,key);
				//写入文件
				writeUserInfo.write(userInfoMap, file);
				continue aa;//返回管理员界面
			}else if (input == 4) {
				//取款
				DrawMoney drawMoney = new DrawMoney();
				userInfoMap = drawMoney.userDraw(userInfoMap, key);
				//写入文件
				writeUserInfo.write(userInfoMap, file);
				continue aa;//返回管理员界面
			}else if (input == 5) {
				//流水
				DealFlow dealFlow =new DealFlow();
				dealFlow.userFlow(userInfoMap.get(key));
				//流水只是查看 并不操作 不需要写入  可以做个删除流水
				//返回管理员界面
				continue aa;
			}else if (input == 6) {
				//退出
				Login login = new Login();
				login.lin();
			}
		} while (true);
	}
}
