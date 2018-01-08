/**
 * 
 */
package com.wangy325.exception.index;

import java.util.Scanner;

/**
 * @author wangy325
 *
 * @date Dec 21, 2017  9:14:11 PM
 *
 * @decription  测试登录异常
 */
public class TestLogin {

	public static void main(String[] args) {
		// 录入用户名和密码
		Scanner userinfo = new Scanner(System.in);
		System.out.println("请输入用户名");
		String un = userinfo.next();
		System.out.println("请输入密码:");
		String passwd = userinfo.next();
		
		// 调用login 方法
		boolean flag =false;
		try {
			 flag = login(un, passwd);
		} catch (LoginException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// 处理异常
			System.out.println(e.getMessage());
		}
		System.out.println(flag?"登录成功":"登录失败");
		userinfo.close();
	}

	private static boolean login(String username, String passwd) throws LoginException {
		
		if(!(username.equals("canglaoshi") && passwd.equals("1024"))) {
			throw new LoginException("用户名或密码错误");
		}
		return true;
	}

}
