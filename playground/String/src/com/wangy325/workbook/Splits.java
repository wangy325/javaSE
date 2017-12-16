/**
 * 
 */
package com.wangy325.workbook;

/**
 * @author wangy325
 *
 * @date Dec 16, 2017  1:13:04 PM
 *
 * @decription  字符串拆分与拼接的简单处理
 * 
 * @target TODO
 */
public class Splits {
	static String mark = "01#张三#8702#李四#6503#王五#40";
	static String[] splitStr = mark.split("#");
	public static void main(String[] args) {
	
	String mark1 = splitStr[2].substring(0, 2);
	String index2 = splitStr[2].substring(2);
	String mark2 = splitStr[4].substring(0,2);
	String index3 = splitStr[4].substring(2);
	System.out.println(splitStr[0]+" "+splitStr[1]+" "+mark1);
	System.out.println(index2+" "+splitStr[3]+" "+mark2);
	System.out.println(index3+" "+splitStr[5]+" "+splitStr[6]);
	
	}
}
