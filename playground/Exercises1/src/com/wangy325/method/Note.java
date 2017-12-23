/**
 * 
 */
package com.wangy325.method;

/**
 * @author wangy325
 *
 * @date Dec 6, 2017  10:15:35 AM

 * @decription   方法的定义和调用
 * 
 * @target TODO
 */
public class Note {	
//	定义(声明)
// 	修饰符(public) 返回值 (没有返回值的情况下用 void) 方法名称(参数1,参数2...){}
/** 有返回值的方法	
 * 修饰符(public) 返回值(数据类型 int,double...) 方法名称(参数1,参数2..){
	return 返回值类型;
//	return的作用:
 * 	1. 返回结果
 * 	2. 结束方法
}*/ 
	
//	调用
//	对象.方法名称(参数1,参数2..)
	int  age;
	String name;
	
	public void eat() {
		System.out.println("eat...");
	}
	public void run() {
		System.out.println("running..");
	}
//	带参数的方法
	public void dinner(String food,String drink) {
		System.out.println("dinner:"+food+"and"+drink);
	}
	
	public static void main (String[] args) {
//		创建对象一定会调用构造器
//		没有创建构造器的话,系统会有一个隐式(空)构造器
//		创建对象
		Note N1 = new Note();
//		调用方法
		N1.eat();
		N1.run();
//		实参
		String food = "多春鱼";
		String drink = "可乐";
//		形参
		N1.dinner(food,drink);
		
		System.out.println("------分割线-------");
	}
}
