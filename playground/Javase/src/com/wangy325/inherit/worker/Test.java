/**
 * 
 */
package com.wangy325.inherit.worker;

/**
 * @author wangy325
 *
 * @date Dec 9, 2017  3:19:24 PM
 *
 * @decription  
 * 
 * @target TODO
 */
public class Test {
	public static  void main (String[] args) { 
	Farmer farmer = new Farmer(3500.0d);
	System.out.println("the income of a year of farmer is "+ farmer.showSalary() + " yuan.");
	System.out.println("-------------");
	Attendant attendant = new Attendant(4500.0d);
	System.out.println("the income of a year of attendant is "+ attendant.showSalary() + " yuan.");
	System.out.println("-------------");
	Teacher teacher = new Teacher(7652.0d);
	teacher.setClassReward(98.0);
	teacher.setNofDays(144);
	System.out.println("the income of a year of teacher is "+ teacher.showSalary() + " yuan.");
	System.out.println("-------------");
	Scientist scientist = new Scientist(14500.0d);
	scientist.setYeB(80000.0d);
	System.out.println("the income of a year of scientist is "+ scientist.showSalary() + " yuan.");
	}

}
