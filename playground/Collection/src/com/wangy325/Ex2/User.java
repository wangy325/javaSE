/**
 * 
 */
package com.wangy325.Ex2;

/**
 * @author wangy325
 *
 * @date Dec 19, 2017  2:29:56 PM
 *
 * @decription  
 * 
 * @target TODO
 */
public class User {
	
	private String name;
	public User(String name , int age) {
		this.name = name;
		this.age = age;
	}
	private int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name+" : "+age;
	}
	

}
