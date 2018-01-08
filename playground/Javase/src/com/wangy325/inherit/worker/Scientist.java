/**
 * 
 */
package com.wangy325.inherit.worker;

/**
 * @author wangy325
 *
 * @date Dec 9, 2017  3:18:36 PM
 *
 * @decription  
 * 
 * @target TODO
 */
public class Scientist extends Worker {
	private double yeB;
	
	public Scientist () {
		super();
	}
	public Scientist(double salary) {
		super(salary);
	}
	public double getYeB() {
		return yeB;
	}
	public void setYeB(double yeB) {
		this.yeB = yeB;
	}
	public double showSalary() {
		return super.showSalary() + yeB;
	}
	

}
