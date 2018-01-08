/**
 * 
 */
package com.wangy325.workbook1.q8;

/**
 * @author wangy325
 *
 * @date Dec 14, 2017  7:03:03 PM
 *
 * @decription  
 * 
 * @target TODO
 */
class Student {

	 String name;
	 int age;
	 char gender;

	// constructor
	Student() {
	}

	Student(String name) {
		this.name = name;
	}

	Student(String name, int age) {
		this(name);
		this.age = age;
	}

	Student(String name, int age, char gender) {
		this(name, age);
		this.gender = gender;
	}

	// method
	void changeName(String name) {
		this.name = name;
	}

	void changeAge(int age) {
		this.age = age;
	}

	void changeGender(char gender) {
		this.gender = gender;
	}

	void showInfo() {
		System.out.println("name: " + name + "\tage: " + age + "\tgender: " + gender);
	}

}
