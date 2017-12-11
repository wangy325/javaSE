/**
 * 
 */
package com.wangy325.point;

/**
 * @author wangy325
 *
 * @date Dec 9, 2017 5:44:13 PM
 *
 * @decription
 * 
 * @target TODO
 */
public class Cylinder extends Circle {
	protected double height;
/* 一下代码块不用设置, 最底层子类可以直接调用父类的方法
	// 设置圆柱半径
	public void setCylinderR(double r) {
		super.setR(r);

	}

	public double getCylinderR() {
		return super.getR();
	}*/

	// 设置位置
	/* 虽然感觉这里写的很高端, 也没问题
	 * 但是代码还可以更简单
	 * public void setPosition(double x, double y) {
		// 可以越级调用基类的方法
		super.setX(x);
		super.setY(y);
	}
	public String getPosition() {
		return "(" + super.getX() + ", " + super.getY() + ")";
	}
*/
	// 设置高
	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double calVolume() {
		return super.calArea() * height;
	}

}
