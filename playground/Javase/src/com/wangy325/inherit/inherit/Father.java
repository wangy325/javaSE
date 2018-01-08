/**
 * 
 */
package com.wangy325.inherit.inherit;

/**
 * @author wangy325
 *
 * @date Dec 10, 2017  12:19:16 PM
 *
 * @decription  
 * 
 * @target TODO
 */
public class Father extends Ancestor {

	{ // 构造代码块
		System.out.println("父类第一构造代码块");
	}
	
	
	public Father (){ 
		super();
		System.out.println("父类的构造方法...");
	}
	
	{
		System.out.println("父类第二构造代码块");
	}
	static { //静态代码块
		System.out.println("父类静态代码块");
	}
}
