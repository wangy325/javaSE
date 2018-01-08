/**
 * 
 */
package com.wangy325.inherit.point;

/**
 * @author wangy325
 *
 * @date Dec 9, 2017  5:43:31 PM
 *
 * @decription  这是基类, 对象的初始化利用方法完成,
 * 
 * @target TODO
 */
public class Point {
	protected double x ,y;
	
	public Point() {
		
	}

	public String getPosition() {
		return "(" + x + ", " + y + ")";
	}

	public void setPosition(double x, double y) {
		this.x = x;
		this.y = y;
	}

}
