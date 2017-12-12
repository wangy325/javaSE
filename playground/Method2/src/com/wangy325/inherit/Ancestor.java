/**
 * 
 */
package com.wangy325.inherit;

/**
 * @author wangy325
 *
 * @date Dec 10, 2017  12:53:14 PM
 *
 * @decription   讨论了构造代码块, 静态代码块, 构造方法 的定义 以及 在继承中代码块的运行顺序
 * 				 子类扩展父类时, 子类可以从父类继承到成员变量和方法, 如果权限允许的话,
 * 				 (public protected 甚至 default), 子类可以直接访问父类的成员变量和方法
 * 
 * @target TODO
 */
public class Ancestor {
	
	{
		System.out.println("祖先第一构造代码块");
	}

	static {
		System.out.println("祖先的的静态代码块");
	}
	
	public Ancestor() {
		System.out.println("祖先的构造方法");
	}
	
	{
		System.out.println("祖先的第二构造代码块");
	}
	
	public void method () {
		System.out.println("-----------------");
	}
}
