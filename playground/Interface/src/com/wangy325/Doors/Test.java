package com.wangy325.Doors;

public class Test {
	public static void main(String[] args) {
		
		Brand1 brand1 = new Brand1();
		Brand2 brand2 = new Brand2();
		
//		brand1.brand = "hello"; //	The final field Brand1.brand cannot be assigned
		brand1.mainFunc();
		brand1.extFunc();
		brand2.mainFunc();
		brand2.extFunc();
		
		
	}
}
