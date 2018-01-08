/**
 * 
 */
package com.wangy325.inherit.worker;

/**
 * @author wangy325
 *
 * @date Dec 9, 2017  3:19:06 PM
 *
 * @decription  
 * 
 * @target TODO
 */
public class Attendant extends Worker {
	public Attendant () {
		super();
	}
	public Attendant (double salary) {
		super(salary);
	}
	
	public double showSalary() {
		return super.showSalary();
	}

}
