/**
 * 
 */
package com.wangy325.inherit.rectangle;

/**
 * @author wangy325
 *
 * @date Dec 9, 2017  4:34:49 PM
 *
 * @decription  
 * 
 * @target TODO
 */
public class Cubiod extends Rect {
	private double height;
	
	public Cubiod() {
		super();
		this.height = 10.0d;
	}
	public Cubiod (double length, double width) {
		super(length,width);
	}
	
//	public Cubiod (double height) {
////		super(length,width);
//		this.height = height;
//	}
	
	
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getVolumn() {
		return super.getArea()* height;
	}
}
