/**
 * 
 */
package com.wangy325.human;

/**
 * @author wangy325
 *
 * @date Dec 9, 2017  2:48:59 PM
 *
 * @decription  
 * 
 * @target TODO
 */
public class Teacher extends Human {
	private String JN;
	private int YoT;
	
	public Teacher() {
		super();
	}
	public Teacher (String name, int age, String gender) {
		super(name, age, gender);
	}
	public String getJN() {
		return JN;
	}
	public void setJN(String jN) {
		JN = jN;
	}
	public int getYoT() {
		return YoT;
	}
	public void setYoT(int yoT) {
		YoT = yoT;
	}
	
	public String selfItroduction() {
		return super.selfItroduction() +" job NO. is "+this.JN+ "with a " + (this.YoT +"") +" years teaching experice.";  
	}
	
	

}
