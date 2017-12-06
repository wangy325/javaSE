/**
 * 
 */
package com.wangy325.oop;

/**
 * @author wangy325
 *
 * @date Dec 6, 2017 1:45:45 PM
 *
 * @decription 试着编写一个手机类
 * 
 * @tarset TODO
 */
public class cellPhone {
	String Brand, OS, Battery_Capacity;

	// 不含返回值方法 [?获取]对象属性值
	public void setBrand(String brand) {
//		this.Brand = brand;			// ③
		System.out.println("Cellphone brand is " + brand);
	}

	// 含返回值方法 [获取?]对象属性值
	public String setOs(String os) {
//		 OS = os;					// ④
		System.out.println("Cellphone OS is(from method): " + os); // ①
		return os;
	}

	// 构造器初始化
	public cellPhone(String brand, String os, String bc) {
		this.Brand = brand;
		this.OS = os;
		this.Battery_Capacity = bc;
		System.out.println("brand:" + brand + "\tos:" + os + "\tbc:" + bc);
	}

	public static void main(String[] args) {
		// 创建对象 并调用构造器
		cellPhone cellPhone0 = new cellPhone("Apple", "ios", "1800mA");
		// 调用setBrand方法
		cellPhone0.setBrand("google");
		// 调用setOs方法
		// cellPhone0.setOs("android");
		// 直接打印setOs返回值
		System.out.println("Cellphone OS is(from main):" + cellPhone0.setOs("android")); // ②

		/**
		 * ①和②是两种不同的获取对象属性的方法,①是传参初始化,②是调用方法返回值;
		 */

		System.out.println("--------------分割线----------");
		System.out.println(cellPhone0.Brand);
		System.out.println(cellPhone0.OS);
		System.out.println(cellPhone0.Battery_Capacity);
		// 运行结果 是构造器初始化的值:
		// Apple
		// ios
		// 1800mA
		/**
		 * ③ 和④ 的意义在于,将方法参数赋值给实例对象的属性,有无[this]关键字都是可以的
		 * 如果取消 ③和 ④的注释,则上述运行结果变为:
		 * 		google
		 * 		android
		 * 		1800mA
		 */

	}
}
