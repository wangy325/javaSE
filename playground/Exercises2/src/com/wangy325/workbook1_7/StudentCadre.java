/**
 * 
 */
package com.wangy325.workbook1_7;

/**
 * @author wangy325
 *
 * @date Dec 14, 2017  5:59:25 PM
 *
 * @decription  
 * 
 * @target TODO
 */
public class StudentCadre extends Student {
	
	private String position;
	
	public StudentCadre(String name, String nation, int age, int gender ,String school,String sn,String position) {
		super(name, nation,age,gender, school, sn);
		this.position = position;
	}
	
	public void conference() {
		System.out.println("orgnize a meeting conference.");
	}


	@Override
	public String showInfo() {
		return super.showInfo()+". and who's the "+ position +" of student union.";
	}
	
	

}
