package com.wangy325.libsystem.utils;

import org.junit.Test;

import com.wangy325.libsystem.service.LibServices;

/**
 * @author wangy325
 *
 * @date Jan 11, 2018-- 3:44:53 PM
 *
 * @description 1st user interface of library manager system
 */
public class FirstClassMenu {

	public static void getStart() {
		while (true) {
			System.out.println("welcom to our library, sign in or sign up to borrow/return book(s):");
			System.out.println("\t 1. sign in with an existed account");
			System.out.println("\t 2. sign up a new account");
			System.out.println("\t 0. exit system");
			int choice = InputUtil.getInt();
			switch (choice) {
			case 1:
				// query database with fields: SNAME and SPASSWD
				// Account verify process
				String username = null;
				while (true) {
					System.out.println("please input username:");
					username = InputUtil.getStr();
					if (username.equals("e"))
						return;
					System.out.println("please input passwd:");
					String passwd = InputUtil.getStr();
					if (LibServices.loginCheck(username, passwd)) {
						System.out.println("log in successful");
						break;
					} else {
						System.out.println("username or passwd incorrect, try again(or input 'e' to exit).");
					}
				}
				// Verifying process done, 2nd menu entry
				SecondClassMenu.getStart(username);
				break;
			case 2:
				// insert 1 row into table STU
				// before that you need to execute student check
				System.out.println("please input new username:");
				String newuser = null;
				while (true) {
					newuser = InputUtil.getStr();
					if (CheckUtil.check(newuser))
						System.out.println("username has been used, please input another one: ");
					else
						break;
				}
				// confirm password
				String newpasswd = null;
				while (true) {
					System.out.println("please input passwd:");
					newpasswd = InputUtil.getStr();
					System.out.println("confirm passwd:");
					String newpasswdagain = InputUtil.getStr();
					if (!(newpasswdagain.equals(newpasswd)))
						System.out.println("passwd isn't match, reinput your passwd please.");
					else
						break;
				}
				// create a new account
				if (LibServices.creatAccount(newuser, newpasswd))
					System.out.println("account created successful.");
				else {
					System.out.println("account created failed");
				}
				break;
			case 0:
				 InputUtil.closeConsole();
				return;
			default:
				System.out.println("oooooops! please input follow the instruction, and try again.");
				break;
			}
		}
	}

	@Test
	public void test() {
		getStart();
	}
}
