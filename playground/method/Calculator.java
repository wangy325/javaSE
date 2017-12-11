/**
 * 
 */
package com.wangy325.method;

/**
 * @author wangy325
 *
 * @date Dec 7, 2017 7:56:01 PM
 *
 * @decription 讨论方法重载[method overloading]
 * 
 *             基本定义: 方法名一定相同, 参数表必须不同(参数个数,参数数据类型...反正要有个不同), 其他的 修饰符(public static), 返回值什么的都无所谓 
 * 
 *             方法的重载意义在于, 对于一个同名方法, 如果只传入一个参数, 则调用只含有一个参数的方法
 * 
 *             如果传入了两个参数,则调用 含两参数的方法
 * 
 *             同时, 方法会寻找参数数据类型匹配的方法
 * 
 * @target TODO
 */
public class Calculator {
	int para1;
	double para2;
	String para3;

	// 方法1
	public static int addtion(int para1) {
		return para1;
	}

	// 方法2
	public static String addtion(int para1, double para2) {
		// 简单的方法重载
//		 return (para1 + " ") +para2 +" ";
		// 方法重载, 返回值调用了方法1;
		// return (addtion(para1)+" ") + para2 +" ";
//		此处如果想调用方法1, 必须将方法1 也改成[静态方法]! 意即 静态方法 只能调用静态方法,不能调用非静态方法
		return (addtion(17) + " ") + para2 + " ";
	}

	// 方法3
	public String addtion(int para1, double para2, String para3) {
//		return (para1 + " ") + (para2 + " ") + para3;
//		然而,非静态方法 是可以调用静态方法的
		return addtion(para1,para2) + para3;
	}

	public static void main(String[] args) {
		Calculator cal = new Calculator();
		System.out.println(addtion(10));
		System.out.println(addtion(12, 12.4));
		System.out.println(cal.addtion(13, 14.4, "hello"));
	}
}
