/**
 * 
 */
package com.wangy325.point;

/**
 * @author wangy325
 *
 * @date Dec 9, 2017 5:44:44 PM
 *
 * @decription
 * 
 * @target TODO
 */
public class Test {
	public static void main(String[] args) {
		Cylinder cylinder = new Cylinder();
	
		// 设置半径
		cylinder.setR(4.0d);
		// 设置高度
		cylinder.setHeight(8.0d);
		// 设置位置
		//直接调用了[爷]类的方法
		cylinder.setPosition(3.0, 4.0);
		System.out.println("----------------");
		// 打印位置
		System.out.println("the position is " + cylinder.getPosition());
		// 打印半径
		System.out.println("the radius is " + cylinder.getR());
		// 打印面积
		// 直接调用了父类的方法
		System.out.println("the area is " + cylinder.calArea());
		// 打印高度
		System.out.println("the height is " + cylinder.getHeight());

		System.out.println("the volume of cylinder is " + cylinder.calVolume());

	}

}
