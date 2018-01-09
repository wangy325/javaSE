package com.wangy325.dao.utils;

import java.util.Scanner;

import org.junit.Test;

/**
 * @author wangy325
 *
 * @date Jan 9, 2018  9:35:28 AM
 *
 * @description    读取控制台输入的方法类
 * 
 * @tags 
 */
public class InputUtils {

	private static Scanner console = new Scanner(System.in);

	public static int inputInt(String msg) {
		while (true) {
			System.out.println(msg);
			String str = console.next();
			try {
				return Integer.parseInt(str);
			} catch (NumberFormatException e) {
				// System.out.println("输入无效,请重试");
				System.exit(0);
			}
		}
	}

	public static String inputStr(String msg) {
		System.out.println(msg);
		String str = console.next();
		return str;
	}

	public static void closeConsole() {
		JdbcUtils.closeAll(console);
	}

	@Test
	public void testInput() {
		System.out.println(inputInt("请输入选择:"));
	}

}
