/**
 * 
 */
package com.wangy325.workbook1.q4;

/**
 * @author wangy325
 *
 * @date Dec 13, 2017  10:19:59 AM
 *
 * @decription  
 * 
 * @target TODO
 */
// 普通类继承抽象类, 抽象类的抽象方法必须要实现, 不然
// 子类也要定义为抽象类
public class Triangle extends Shape {
	private double a, b, c ;
	
	public Triangle() {
		
	}

	public Triangle ( String color,double a, double b, double c) {
		super(color);
		setSides(a,b,c);
	}
	
	public void setSides(double a, double b, double c) {
		if ( a + b < c || a + c < b || b + c < a) {
			System.out.println("Err:不能组合成三角形");
			return ;
		}
		this.a = a;
		this.b = b;
		this.c = c;
	}
//	覆写父类(抽象类)的方法
	public double calPerimeter() {
		if(a == 0 || b == 0 || c == 0) {
			return 0 ;
		}
		return a + b + c;
	}
	
	public String getType() {
		if(a == 0 || b == 0 || c == 0) {
			return "shape dose not exist.";
		}
		return "三角形";
	}
	
//	@Override
	  static void welcome() {
		System.out.println("哈哈哈!");
	}
	
	public static void main(String[] args) {
		Shape s1 = new Triangle("black", 3,1,5);
		System.out.println("形状是:" + s1.getType());
		System.out.println("周长是:"+ s1.calPerimeter());
		Shape.welcome();
		Triangle.welcome();
		System.out.println("----------");
		Shape s2 = new Circle("red", 2);
		System.out.println("形状是:" + s2.getType());
		System.out.println("面积是:" + s2.calPerimeter());
	}
}
