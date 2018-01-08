/**
 * 
 */
package com.wangy325.workbook1.q6;

/**
 * @author wangy325
 *
 * @date Dec 14, 2017  5:23:43 PM
 *
 * @decription  
 * 
 * @target TODO
 */
public class Square implements IShape{

	double a ;
	
	public Square(double a ) {
		this.a = a;
	}
	@Override
	public double aera() {
		return 4*a;
	}
	public static void main(String[] args) {
		
		IShape IS1 = new Square(7.8d);
		System.out.println(IS1.aera());
	}
	
}
