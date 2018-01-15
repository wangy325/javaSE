package com.wangy325.libsystem.utils;

import java.util.Scanner;

import org.junit.Test;

public class InputUtil {
	private static Scanner console =new Scanner(System.in);
	/**
	 * @return Integer choice
	 */
	public static int  getInt() {
		String str =" "; 
		while(true) {
			str = console.next();
			try {
				return Integer.parseInt(str);
			} catch (NumberFormatException e) {
				System.out.println("illeagle input, please try again.");
			}
		}
	}
	
	/**
	 * @return String 
	 */
	public static String getStr() {
		String str = console.next();
		return str;
	}
	// close the console
	public static void closeConsole() {
		console.close();
	}
	
	@Test 
	public void test() {
		System.out.println(InputUtil.getInt());
	}

}
