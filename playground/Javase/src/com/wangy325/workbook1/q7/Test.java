/**
 * 
 */
package com.wangy325.workbook1.q7;

/**
 * @author wangy325
 *
 * @date Dec 14, 2017  5:41:14 PM
 *
 * @decription  
 * 
 * @target TODO
 */
public class Test {
	
	public static void main(String[] args) {
		Human s1 = new Student("alen","us",19, 0,"victorial high school","176562");
		s1.work();
		System.out.println(s1.showInfo());
		System.out.println("---------");
		
		Human w1 = new Worker("jobs","US",35,0,"apple.inc",6);
		w1.work();
		System.out.println(w1.showInfo());
		System.out.println("---------");
		
		StudentCadre sd1 = new StudentCadre("richile","us",19, 1,"victorial high school","176562","president");
		sd1.conference();
		System.out.println(sd1.showInfo());
		
		
		
		
		
	}

}
