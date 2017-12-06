/**
 * 
 */
package com.wangy325.oop;

/**
 * @author wangy325
 *
 * @date Dec 6, 2017  11:08:52 AM

 * @decription  定义一个qq类
 * 
 * @target TODO
 */
public class QQ {
	// 属性
		String NickName,ID,PassWd;
		int Age;
//		无参数方法
		public void NickName() {
			System.out.println("NickName is tony");
		}
		public void ID() {
			System.out.println("ID is 20171203");
		}
		public void PassWd() {
			System.out.println("password is abcdef123");
		}
		public void Age() {
			System.out.println("Age is 17");
		}
		
//		有参数方法 称为形参
		public void NickName(String name) {
			System.out.println("NickName is "+name);
		}
		public void ID(String id) {
			System.out.println("ID is "+id);
		}
		public void PassWd(String passwd) {
			System.out.println("password is "+passwd);
		}
		public void Age(int age) {
			System.out.println("Age is "+age);
		}
		
}
