/**
 * 
 */
package com.wangy325.workbook1_4;

/**
 * @author wangy325
 *
 * @date Dec 13, 2017  10:13:28 AM
 *
 * @decription  
 * 
 * @target TODO
 */
public abstract class Shape {
	{
		System.out.println("抽象类的初始代码块");
	}
	
	private String color;
//	抽象类可以有抽象方法
	public abstract double calPerimeter();
	
	public abstract String getType();
//	抽象类可以有构造器
	public Shape() {
		
	}
	public Shape(String color) {
		super();
		this.color = color;
		System.out.println("抽象类的 Shape 构造器");
		System.out.println("形状的颜色是:" + this.color);
	}

// 抽象类可以有非抽象方法
	static void welcome() {
		System.out.println("欢迎调用抽象类的非抽象方法!");
	}
}
