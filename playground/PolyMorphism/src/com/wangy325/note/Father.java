/**
 * 
 */
package com.wangy325.note;

/**
 * @author wangy325
 *
 * @date Dec 11, 2017  2:23:48 PM
 *
 * @decription   试着理解 [多态] 之一, 向上转型 Upcasting
 * 
 * @target TODO
 */
public class Father {
	public int number = 6;
	
	public void fatherM1() {
		System.out.println("父类的普通方法 M1");
	}
	
	public void test() {
		System.out.println("父类的被覆写的方法test()");
	}
	
	public static void stable() {
		System.out.println("父类的被覆写的静态方法stable()");
	}
	
}