/**
 * 
 */
package com.wangy325.inherit.worker;

/**
 * @author wangy325
 *
 * @date Dec 9, 2017  3:17:27 PM
 *
 * @decription  
 * 
 * @target TODO
 */
public class Worker {
	double salary;
	
	public Worker () {
		super();
	}
	public Worker (double salary) {
		this.salary = salary;
	}
	
	public double showSalary() {
		return salary * 12;
	}
}
