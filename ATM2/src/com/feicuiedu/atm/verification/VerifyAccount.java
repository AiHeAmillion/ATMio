package com.feicuiedu.atm.verification;

import java.util.HashMap;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.feicuiedu.atm.userinfo.User;

/**
 * @author 宁强
 * 账号正确返回1
 * 身份证号正确返回2
 * 账号身份证号都正确返回3
 * 都不正确返回0
 */
//可以同时验证账号或者密码
public class VerifyAccount {
	//验证账号长度以及格式
	public int accountLengeth(String strAccount) {
		
		Pattern pattern = Pattern.compile("[0-9]{21}");//正则表达式  0-9数字组成 19位
		Matcher matcher = pattern.matcher(strAccount);
		
		if (matcher.matches() == false) {	//验证账号长度
			System.out.println("账号错误！重新输入");
			return 0;
		}else{
			return 1;	//正确返回1
		}
	}
	
	//验证账号存在  返回值可以是 键值对的键
	public String accountExist(HashMap<String, User> userInfoMap,String strAccount) {
		//获取Map键的Set集
		boolean bln = false;
		String key = "false";
		Set<String> keys = userInfoMap.keySet();
		for(String i : keys) {
			bln = strAccount.equals(userInfoMap.get(i).getAccount());
			if (bln) {	//当bln 变为true 找到账号
				key = i;//key为此对象在键值对的键
			}
		}
		
		if (key.equals("false")) {	//如果key值一直是false那么账号不存在
			System.out.println("账号不存在，请重新输入！");
			return key; //账号不存在返回 key = "false"
		}else{
			return key;  //账号存在返回赋值键的key
		}
	}
	
	//验证身份证号长度与格式
	public int idNoLengeth(String strIdNo) {
		
		Pattern pattern = Pattern.compile("^(\\d{6})(\\d{4})(\\d{2})(\\d{2})(\\d{3})([0-9]|X)$");//正则表达式身份证号
		Matcher matcher = pattern.matcher(strIdNo);
		
		if (matcher.matches() == false) {	//验证身份证号长度或者格式
			System.out.println("身份证号错误！重新输入");
			return 0;	//错误返回0
		}else{
			return 1;	//正确返回1
		}
	}
	
	//验证身份证存在  返回值可以是 键值对的键
	public String idNoExist(HashMap<String, User> userInfoMap,String strIdNo) {
		//获取Map键的Set集
		boolean bln = false;
		String key = "false";
		Set<String> keys = userInfoMap.keySet();
		for(String i : keys) {
			bln = strIdNo.equals(userInfoMap.get(i).getIdNo());
			if (bln) {	//当bln 变为true 找到身份证号
				key = i;//key为此对象在键值对的键
			}
		}
		
		if (key.equals("false")) {	//如果key值一直是false那么身份证号不存在
			System.out.println("身份证号不存在！");
			return key; //身份证号不存在返回 key = "false
		}else{
			return key;  //身份证号存在返回赋值键的key
		}
	}
	
	//特别验证，同时验证账号和身份证号都正确
	public String specialVerify(HashMap<String, User> userInfoMap,String strAccount,String strIdNo) {
		//验证账号是否存在 存在返回该账号（对象）的键
		String key = accountExist(userInfoMap, strAccount);
		
		if (key.equals("false")) {
			return key; //账号不存在 就不用在验证身份证号了
		}else { 
			//账号存在 验证对应键的身份证号是否存在
			boolean bln = strIdNo.equals(userInfoMap.get(key).getIdNo());
			if (bln) {
				//身份证号存在 返回true
				return key;
			}else {
				return key;
			}
		}
		
	}
	
	//验证密码的格式以及长度
/*	public void passwordLength(String strPassword) {
		
		Pattern pattern = Pattern.compile("[0-9]{21}");//正则表达式  0-9数字组成 19位
		Matcher matcher = pattern.matcher(strAccount);
		
		if (matcher.matches() == false) {	//验证账号长度
			System.out.println("账号错误！重新输入");
			return 0;
		}else{
			return 1;	//正确返回1
		}
	}*/
	
	//验证密码的正确性
	public boolean passwordExist(HashMap<String, User> userInfoMap,String key,String strPassword) {
		boolean temp = strPassword.equals(userInfoMap.get(key).getPassword());
		if (temp) {
			//密码正确
			return true;
		}
		//密码错误
		return false;
		
	}
}
