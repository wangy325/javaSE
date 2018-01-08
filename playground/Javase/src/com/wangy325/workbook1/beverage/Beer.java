/**
 * 
 */
package com.wangy325.workbook1.beverage;

/**
 * @author wangy325
 *
 * @date Dec 12, 2017  7:23:50 PM
 *
 * @decription  
 * 
 * @target TODO
 */
class Beer extends Beverage {

	public static void main(String [] args) {

       Beer b = new Beer (14) ;
       System.out.print(b.toString());

  }

//	public int Beer(int x) { // x
	public Beer(int x ) {

		this();

		System.out.print("beerl\n");

	}

	public Beer() {
		System.out.print("beer2 ");
	}

	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.getClass().getName() + " @ wangy325";
	}
	

}
