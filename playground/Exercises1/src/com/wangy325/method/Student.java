/**
 * 
 */
package com.wangy325.method;

/**
 * @author wangy325
 *
 * @date Dec 7, 2017  8:35:44 PM
 *
 * @decription   学生类的方法
 * 
 * @target TODO
 */
public class Student {
	String  index,name ;
	int age;
	char gender;
	
	public Student () {
	
	}
	
	public Student ( String name) {
		this.name = name;
	}
	public Student (String name, int age) {
//		重载构造方法
		this( name);
		this.age = age;
	}
	public Student (String name, int age, char gender) {
		this( name, age);
		this.gender = gender;
	}
	

	public void changeName(String name) {
		this.name = name;
	}
	public void changeGender(char gender) {
		this.gender = gender;
	}
	public void showInfo() {
		System.out.println("name: "+this.name+"\tage: "+ this.age+"\tgender: "+this.gender);
	}
}
