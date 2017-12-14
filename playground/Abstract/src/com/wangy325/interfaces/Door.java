/**
 * 
 */
package com.wangy325.interfaces;

/**
 * @author wangy325
 *
 * @date Dec 13, 2017  7:07:15 PM
 *
 * @decription   声明一个接口
 * 
 * @target TODO
 */
public interface Door {
	// 接口中可以声明变量, 但是, 会被自动转换成常量
	int MAX_VALUE = 127;
	// 等效于
	/* static final int MAX_VALUE = 127; */
	// 也就是说, 接口内都是常量

	// 同理, 接口中的方法 必须是 [抽象方法], 声明的时候可以省略 [public] [abstract] 关键字
	void open();

	// 等同于
	/*
	 * public abstract void open();
	 */ void close();

	public static void main(String[] args) {
	}

}
