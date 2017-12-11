/**
 * 
 */
package com.wangy325.this_super;

/**
 * @author wangy325
 *
 * @date Dec 10, 2017  2:29:55 PM
 *
 * @decription   比较 this 和 super 作为关键字的差异
 * 
 * @target TODO
 */
public class Father {
	protected static int age;
	protected static String name;
	
	public Father() {
		super();
	}
	public Father(String name, int age) {
		Father.name = name;
		Father.age = age;
	}
	
	public static String showInfo() {
//		写成静态方法 是为了方便 Test 类中验证 Father.showInfo() 是否 已经初始化成功
		return "name: "+ name +" age "+ age;
	}

}
