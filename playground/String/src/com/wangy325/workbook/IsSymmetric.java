/**
 * 
 */
package com.wangy325.workbook;

/**
 * @author wangy325
 *
 * @date Dec 16, 2017  2:56:52 PM
 * 
 * @decription  判断一个字符串是否对称
 */
public class IsSymmetric {
	static String isSymmetric(String s) {
		int COUNT = 0;
		for(int i= 0; i< s.length()/2;i++) {
			if(s.charAt(i) == s.charAt(s.length()-1-i)) {
				COUNT ++;
			}
		}
		return (COUNT == s.length()/2)?"String is Symmetric.":"String is not Symmetric.";
	}
	public static void main(String[] args) {
		System.out.println(IsSymmetric.isSymmetric("helloolleha"));
	}

}
