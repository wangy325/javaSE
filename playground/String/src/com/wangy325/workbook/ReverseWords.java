/**
 * 
 */
package com.wangy325.workbook;

import java.util.Scanner;

/**
 * @author wangy325
 *
 * @date Dec 16, 2017  3:05:55 PM
 *
 * @decription  	 要求输入一个长句字符串,然后进行翻转
 * 					 翻转长句中的单字,如 hello world 变成 olleh dlrow
 */
public class ReverseWords {
//		方法
	static String reverseSentence() {
		Scanner string = new Scanner(System.in);
		System.out.println("Please input a sentence:");
		String s = string.nextLine();
		String revS = "";
		String [] sArr= s.split(" ");  // string[] 
		for(int i = 0; i< sArr.length;i++) {
			StringBuffer sBuf = new StringBuffer(sArr[i]).reverse();
			revS += sBuf +" " ;
//			System.out.print(sBuf+" ");
		}
		string.close();
		return revS;
	}
	
	public static void main(String[] args) {
		System.out.println(ReverseWords.reverseSentence());
	}
}
