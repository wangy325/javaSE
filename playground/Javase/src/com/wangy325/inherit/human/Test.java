/**
 * 
 */
package com.wangy325.inherit.human;

/**
 * @author wangy325
 *
 * @date Dec 9, 2017  2:27:57 PM
 *
 * @decription  
 * 
 * @target TODO
 */
public class Test {
	public static void main (String[] args) {
		
		Student stu1 = new Student("lily", 17,"female");
		stu1.setCN("06");
		stu1.setSN("057517");
		System.out.println(stu1.selfItroduction());
		System.out.println("-----------------------");
		Teacher tea1 = new Teacher("kevin",32,"male");
		tea1.setJN("04321");
		tea1.setYoT(5);
		System.out.println(tea1.selfItroduction());
		
	}

}
