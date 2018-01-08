/**
 * 
 */
package com.wangy325.inherit.human;

/**
 * @author wangy325
 *
 * @date Dec 9, 2017  11:52:49 AM
 *
 * @decription   人类父类 包含学生和教师两个子类
 * 				 
 * 
 * @target TODO
 */
public class Human {
	String name, gender;
	int age;
	
	public Human() {
		
	}
	public Human(String name, int age, String gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	public String selfItroduction() {
		return "Here is " + this.name +", age "+ this.age;
	}
}
