/**
 * 
 */
package com.wangy325.workbook1.beverage;

/**
 * @author wangy325
 *
 * @date Dec 12, 2017  7:47:38 PM
 *
 * @decription   讨论子类和父类中出现同名方法（非覆写）的情况
 * 				 子类和父类可以出现同名方法，调用方法的时候，必须用 [关键字] 或
 * 				 [对象引用] 指明调用的是谁的方法, 
 * 				 这样做没什么意义, 反而引起混乱
 * @target TODO
 */
class Over  {
	int dolt (long x)  { 
		System.out.println("------");
		return 3;
	}
}