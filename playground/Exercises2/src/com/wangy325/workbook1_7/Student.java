/**
 * 
 */
package com.wangy325.workbook1_7;

/**
 * @author wangy325
 *
 * @date Dec 14, 2017  5:34:21 PM
 *
 * @decription  
 * 
 * @target TODO
 */
public class Student extends Human {
	private String school, sn;
	
	public Student(String name, String nation, int age, int gender ,String school,String sn) {
		super(name, nation,age,gender);
		this.school = school;
		this.sn = sn;
	}
	@Override
	public void work() {
		System.out.println("the essential job of student is study."); 
		
	}
	
	@Override
	public String showInfo() {
		// TODO Auto-generated method stub
		return super.showInfo()+" from "+school+", student NO. is "+sn;
	}
	
	
	
	
	
	
}
