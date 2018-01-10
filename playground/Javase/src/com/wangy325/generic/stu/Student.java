package com.wangy325.generic.stu;

/**
 * @author wangy325
 *
 * @date Jan 10, 2018  11:34:07 AM
 *
 * @description   
 * 
 * @tags 
 */
public class Student {
	
	private String name,gender;
	private Integer age;
	/**
	 * @param name
	 * @param gender
	 * @param age
	 */
	public Student(String name, String gender, Integer age) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", gender=" + gender + ", age=" + age + "]";
	}
	
	
	

}
