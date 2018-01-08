/**
 * 
 */
package com.wangy325.workbook1.q8p;

/**
 * @author scott
 * @date 2017年12月7日下午5:15:39
 * @version
 * @description
 */
public class Student {

	String name;

	int age;

	// 'n' 男 ！n 女
	char sex;

	public Student(String name) {
		this.name = name;
	}

	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public void changeName(String name) {

		this.name = name;

	}

	public void changeAge(int age) {

		this.age = age;

	}

	public void changeSex(char sex) {

		this.sex = sex;

	}

	public Student(String name, int age, char sex) {
		this.name = name;
		this.age = age;
		this.sex = sex;
	}

	/**
	 * 打印个人信息
	 */
	public void showInfo() {
		System.out.println("个人信息: name" + this.name + ",age" + this.age + ","+(this.sex == 'n' ? "男" : "女"));
	}

}
