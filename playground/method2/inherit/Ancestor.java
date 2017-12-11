/**
 * 
 */
package com.wangy325.inherit;

/**
 * @author wangy325
 *
 * @date Dec 10, 2017  12:53:14 PM
 *
 * @decription   构造代码块, 静态代码块, 构造方法 的定义 以及 运行顺序
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
