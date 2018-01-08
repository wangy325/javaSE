/**
 * 
 */
package com.wangy325.inherit.inherit;

/**
 * @author wangy325
 *
 * @date Dec 10, 2017  12:19:26 PM
 *
 * @decription  
 * 
 * @target TODO
 */
public class Son extends Father{
	
	{
		System.out.println("子类构造代码块");
	}
	static{
		System.out.println("子类静态代码块..");
	}
	
	public Son() {
		super();
		System.out.println("子类的构造方法");
	}
}
