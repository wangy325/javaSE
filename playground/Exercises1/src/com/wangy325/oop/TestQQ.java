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
		String id = "20170987", passwd = "abcdef342";
		int age = 20;

		System.out.println("user info of object qq is(with paras):");
		qq.NickName("allen");
		qq.ID(id);
		qq.PassWd(passwd);
		qq.Age(age);
//		上述有两种不用类型的调用方法, 参数的写法
		System.out.println("----------分割线-----------");
//		还可以用一个方法 传入多个参数
//		调用getAttribute方法
		qq.setAttribute("alx", "20170567", "abcdef7", 19);
		System.out.println("----------分割线-----------");
//		打印对象实例[qq]的属性值
		System.out.println(qq.NickName);
		System.out.println(qq.ID);
		System.out.println(qq.PassWd);
		System.out.println(qq.Age);
		System.out.println("----------分割线-----------");

		
		
	}
}
