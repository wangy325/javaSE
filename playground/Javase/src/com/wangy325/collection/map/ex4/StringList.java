package com.wangy325.collection.map.ex4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author wangy325
 *
 * @date Dec 27, 2017  4:28:50 PM
 *
 * @decription   完成对控制台输入的字符串的排序
 */

public class StringList {
	
	List<Character> charList ;
	
	public StringList() {
		charList = new ArrayList<Character>();
	}
	
	// 获取从键盘输入的字符串, 将其排序后输出
	/**
	 * 1. 获取字符串
	 * 2. 将字符串以 char 的形式保存在 List 中
	 * 3. 利用Collections 工具类 进行字符排序
	 * 4. 将排序好的List<Character> 生成排序的字符串
	 * 
	 * ?. 排序之后是否可以直接进行统计呢?
	 */
	public String getSortedString() {
		Scanner console = new Scanner(System.in);
		System.out.println("请输入字符串:");
		String str = console.next();
		for(int i= 0; i< str.length();i++) {
			charList.add(str.charAt(i));
		}
		console.close();
		Collections.sort(charList);
		String strSorted = "";
		for(Character cha: charList) {
			strSorted += cha;
		}
		return strSorted;
	}
}
