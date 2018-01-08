/**
 * 
 */
package com.wangy325.collection.list.ex2;

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
	private int age;
	
	public User(String name , int age) {
		this.name = name;
		this.age = age;
	}
	
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
