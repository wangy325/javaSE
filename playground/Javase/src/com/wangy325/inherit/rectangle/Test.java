/**
 * 
 */
package com.wangy325.inherit.rectangle;

/**
 * @author wangy325
 *
 * @date Dec 9, 2017  4:38:31 PM
 *
 * @decription  
 * 
 * @target TODO
 */
public class Test {
	public static void main (String[] args) {
		Cubiod cubiod0 = new Cubiod();
		System.out.println("the default aera is "+cubiod0.getArea());
		System.out.println("the default perimeter is "+ cubiod0.getPerimeter());
		System.out.println("the default volumn is "+cubiod0.getVolumn());
		System.out.println("-----------------");
		
		Cubiod cubiod1 = new Cubiod(1.0d,1.0d);
		cubiod1.setHeight(8.0d);
		System.out.println("the aera is "+cubiod1.getArea());
		System.out.println("the perimeter is "+ cubiod1.getPerimeter());
		System.out.println("the volumn is "+cubiod1.getVolumn());
		
		
	}

}
