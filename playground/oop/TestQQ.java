/**
 * 
 */
package com.wangy325.oop;

/**
 * @author wangy325
 *
 * @date Dec 6, 2017 11:16:55 AM
 * 
 * @decription
 * 
 * @target TODO
 */
public class TestQQ {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 创建对象
		QQ qq = new QQ();
		// 调用无参数方法
		System.out.println("user info of object qq is(no paras):");
		qq.NickName();
		qq.ID();
		qq.PassWd();
		qq.Age();
		System.out.println("----------分割线-----------");

		// 调用含参数方法
		// 先给参数进行初始化(赋值),称为实参
		String name = "allen", id = "20170987", passwd = "abcdef342";
		int age = 20;

		System.out.println("user info of object qq is(with paras):");
		qq.NickName(name);
		qq.ID(id);
		qq.PassWd(passwd);
		qq.Age(age);
		System.out.println("----------分割线-----------");
	}
}
