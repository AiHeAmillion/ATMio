package com.feicuiedu.atm;

//运行测试
public class Test {
	public static void main(String[] args) {
		Login login = new Login();
		login.lin();
		
		/*//创建文件
		CreateUserinfo cUserinfo = new CreateUserinfo();
		File file = cUserinfo.userInfoFile();
		
		//测试Map是否存在，不存在创建
		CreateHashMap cHashMap = new CreateHashMap();
		HashMap<String, User> userInfoMap = cHashMap.createHp(file);
		
		//调用开户
		OpenAccount oAccount = new OpenAccount();
		userInfoMap = oAccount.createAccount(userInfoMap);
		
		//输出流 写入文件
		WriteUserInfo wUserInfo = new WriteUserInfo();
		wUserInfo.write(userInfoMap, file);
		
		//输入流 读取文件
		ReadUserInfo rUserInfo = new ReadUserInfo();
		userInfoMap = rUserInfo.read(file);
		
		//显示信息
		ShowUserInfo sUserInfo = new ShowUserInfo();
		sUserInfo.show(userInfoMap);
		
		//销户
		CloseAccount closeAccount = new CloseAccount();
		closeAccount.AccountCancellation(userInfoMap);
		
		//显示
		sUserInfo.show(userInfoMap);
		//存入文件
		wUserInfo.write(userInfoMap, file);*/
	}
}
