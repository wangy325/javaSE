/**
 * 
 */
package com.wangy325.workbook1.q7;

/**
 * @author wangy325
 *
 * @date Dec 14, 2017  5:30:15 PM
 *
 * @decription  抽象类的继承(x)
 * 				这里父类方法太多, 子类并不需要全部实现父类的方法, 不要用抽象类
 * 				因为抽象类如果父类的抽象方法没有完全覆写的话,
 * 				子类也要定义为抽象类
 * 				抽象类不能被实例化
 *  * @target TODO
 */
public class Human {
	
	private String name, nation;
	private int age, gender;
	
	public Human(String name, String nation, int age, int gender) {
		this.name = name;
		this.nation = nation;
		this.age = age;
		this.gender = gender;
	}
//	method
	public  void eat() {};
	public void sleep() {};
	public  void work() {};
	
	public String showInfo() {
		return name+", from "+nation+", "+age+", "+((gender==0)?"male":"female");
		
	}
}
