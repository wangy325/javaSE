/**
 * 
 */
package com.wangy325.workbook1.q7;

/**
 * @author wangy325
 *
 * @date Dec 14, 2017  5:52:51 PM
 *
 * @decription  
 * 
 * @target TODO
 */
public class Worker extends Human {
	private String depart;
	private int Eyear;
	
	public Worker(String name, String nation, int age, int gender ,String depart,int Eyear) {
		super(name, nation,age,gender);
		this.depart = depart;
		this.Eyear = Eyear;
	}

	@Override
	public void work() {
		System.out.println("the essential job of worker is flatter to superior.");
		
	}

	@Override
	public String showInfo() {
		return super.showInfo()+" from "+depart+", working experiences is "+Eyear+" years";
	}
	
	
}
