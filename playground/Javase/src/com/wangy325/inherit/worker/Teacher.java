/**
 * 
 */
package com.wangy325.inherit.worker;

/**
 * @author wangy325
 *
 * @date Dec 9, 2017  3:18:16 PM
 *
 * @decription  
 * 
 * @target TODO
 */
public class Teacher extends Worker {
	private double classReward;
	private int nofDays;
	
	public Teacher() {
		super();
	}
	public Teacher (Double salary) {
		super(salary);
	}
	public double getClassReward() {
		return classReward;
	}
	public void setClassReward(double classReward) {
		this.classReward = classReward;
	}
	public int getNofDays() {
		return nofDays;
	}
	public void setNofDays(int nofDays) {
		this.nofDays = nofDays;
	}
	
	public double showSalary() {
		return super.showSalary() + classReward * nofDays*1.0d;
	}
	
	
	
}
