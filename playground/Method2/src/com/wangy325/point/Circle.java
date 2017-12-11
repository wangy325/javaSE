/**
 * 
 */
package com.wangy325.point;

/**
 * @author wangy325
 *
 * @date Dec 9, 2017  5:43:46 PM
 *
 * @decription  
 * 
 * @target TODO
 */
public class Circle extends Point {
	
	static double PI = 3.14;
	protected double r ;
	

//	设置半径
	public double getR() {
		return r;
	}
	public void setR(double r) {
		this.r = r;
	}
	
	public double calArea() {
		return PI*r*r;
	}
	

}
