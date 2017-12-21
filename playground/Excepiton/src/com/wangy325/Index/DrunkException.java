/**
 * 
 */
package com.wangy325.Index;

/**
 * @author wangy325
 *
 * @date Dec 21, 2017  7:55:16 PM
 *
 * @decription  介绍Java中的抛出异常
 * 				throws:
 * 					声明简要抛出何种类型的异常
 * 					public void 方法名 (参数列表) throws 异常, 异常2{
 * 						// 方法体中抛出异常
 * 						throw new Exception();
 * 					}
 * 				自定义异常
 */	

@SuppressWarnings("serial")
public class DrunkException extends Exception{
	/**
	 * 我们试图抛出一个"喝大了异常"
	 * 1. 自定义异常 一般继承自 Exception(基类) 或者Exception的子类
	 * 2. 只需要写两个构造器, 分别继承父类的构造就写成了一个自定义异常
	 */ 
	public DrunkException() { super();}
	
	public DrunkException(String msg) {
		super(msg);
	}
	public DrunkException(String msg, Throwable cause) { // Throwable 是什么
		super(msg,cause);
	}
	
	
}
