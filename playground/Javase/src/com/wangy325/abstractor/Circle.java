/**
 * 
 */
package com.wangy325.abstractor;

/**
 * @author wangy325
 *
 * @date Dec 13, 2017  10:47:32 AM
 *
 * @decription  
 * 
 * @target TODO
 */
public class Circle extends Shape {
	private double PI = 3.14;
	private double r;
	
	public Circle(String color, double r) {
		super(color);
		setR(r);
	}
	
	public void setR(double r) {
		this.r =r;
	}
	
	@Override
	public double calPerimeter() {
		return PI * r * r;
	}
	@Override
	public String getType() {
		return "圆形";
	}
	
	
	
}
