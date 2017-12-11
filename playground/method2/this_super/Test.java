/**
 * 
 */
package com.wangy325.this_super;

/**
 * @author wangy325
 *
 * @date Dec 10, 2017  2:30:09 PM
 *
 * @decription  
 * 
 * @target TODO
 */
public class Test {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Son son = new Son( "Gates", 46,5647);
		
		System.out.println(Father.showInfo());  // alen 45
		
		System.out.println(Son.showInfo());  // 
		
		son.showDetails();
		
		System.out.println("--------------");
		
		Son son1 = new Son( "Kevin", 28,6754);
		
		System.out.println(Father.showInfo());  // alen 45
		
		System.out.println(Son.showInfo());  // 
		
		son1.showDetails();

	}

}
