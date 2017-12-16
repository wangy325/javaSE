/**
 * 
 */
package com.wangy325.wrapper;

/**
 * @author wangy325
 *
 * @date Dec 15, 2017  3:25:35 PM
 *
 * @decription   字符串对象 基本内涵 和基本方法
 * 
 * @target TODO
 */
public class Note {
	public static void main(String[] args) {
		/**
		 * 1. 字符串对象 [不可变];
		 * 		"abc" 仍然存在, s1 指向了一个新地址, 该地址的 [字面值] 为 "abcd"
		 * 2. 常量池
		 */
		String s1 = new String("abc");  // heap
		s1 = "abcd"; // constant pool
		String s2 = "abc" +"d"; // constant pool
		System.out.println(s1); // :~ abcd
		System.out.println(s1 ==s2); // :~ true
		String s3 = "d";	// constant pool
		String s4 = "abc" + s3; 
		System.out.println(s4 == s1);	//:~ false
		System.out.println(s4.intern()==s1); //:~ true
		
		String s5 =s1.concat("88");
		System.out.println(s5);
//		查看单个字符的ASCII 值
		System.out.println( (int)'a');
		int i ='我';
		int j = 'b';
		System.out.println(i);
		System.out.println(j);
		
		String a = "a";
		String b = "b";
		System.out.println(a.compareTo(b)); // :~ -1
		
		String he = "hello";
		String h = "he";
		System.out.println(he.indexOf("el"));
		System.out.println(he.indexOf(8));
		System.out.println(he.contains(h));
		
		int c = 9;
		System.out.println(Integer.toString(c));
	}	
}
