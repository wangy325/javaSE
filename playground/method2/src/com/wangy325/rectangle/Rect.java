/**
 * 
 */
package com.wangy325.rectangle;

/**
 * @author wangy325
 *
 * @date Dec 9, 2017  4:28:41 PM
 *
 * @decription   这是基类, 对象的初始化利用构造器完成
 * 
 * @target TODO
 */
public class Rect {
	protected double length, width;
	
	public Rect() {
		this.length = 10.0d;
		this.width = 10.0d;
	}
	public Rect(double length, double width) {
		this.length = length;
		this.width = width;
	}
	
	public double getArea() {
		return length*width;
	}
	public double getPerimeter() {
		return (length+width)*2;
	}

}
