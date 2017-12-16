/**
 * 
 */
package com.wangy325.workbook;

/**
 * @author wangy325
 *
 * @date Dec 16, 2017  12:41:08 PM
 *
 * @decription   统计字符串中 特定规则的字符出现的次数
 * 					两种方法,1.正则表达式 和 
 * 							2. 字符 char 比较 
 * 								如果  ASCII 值位于 65-90 和 97-122 
 * 									Character.toUpperCase() = Character; 则为大写, 否则为小写 
 * 
 */
public class StatisticChar {
	static String str = "123dsgfadsgjlafdjhladDWAdlfgjalDSFADSFDASnhsdaf!@$%@#45324rdsf";
	static char[] buf = str.toCharArray();

	static int howManyUpper() {
		int COUNT = 0;
		for (int i = 0; i < buf.length; i++) {
			// mathchs() 是字符串操作, 这里要将 char[] 转为字符串形式
			if (Character.toString(buf[i]).matches("^[A-Z]$")) {
				COUNT++;
			}
		}
		return COUNT;
	}

	static int howManyLower() {
		int COUNT = 0;
		for (int i = 0; i < buf.length; i++) {
			if (Character.toString(buf[i]).matches("^[a-z]$")) {
				COUNT++;
			}
		}
		return COUNT;
	}

	static int howManyNumeric() {
		int COUNT = 0;
		for (int i = 0; i < buf.length; i++) {
			if (Character.toString(buf[i]).matches("^\\d$")) {  //  \d 匹配任意一个数字, 要加转义字符
				COUNT++;
			}
		}
		return COUNT;
	}

	static int howManySpecialCharacter() {
		int COUNT = 0;
		for (int i = 0; i < buf.length; i++) {
			if (Character.toString(buf[i]).matches("^[^A-z0-9]$")) {
				COUNT++;
			}
		}
		return COUNT;
	}

	public static void main(String[] args) {
		System.out.println(buf.length);
		System.out.println(StatisticChar.howManyUpper());
		System.out.println(StatisticChar.howManyLower());
		System.out.println(StatisticChar.howManyNumeric());
		System.out.println(StatisticChar.howManySpecialCharacter());

	}

}
