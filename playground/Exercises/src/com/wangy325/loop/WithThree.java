package com.wangy325.loop;

public class WithThree{
	public static void main (String[] args){
	System.out.println("This java program calculate the sum of numbers with '3' in it's digit(s) within 100");
		int sum = 0;
	for (int i = 1; i < 100; i++){
		int iU = i % 10;
		int iD = (i/10)%10;
		//int sum = 0;
		if ((iU == 3) || (iD == 3)){
			sum = sum + i ;
		}
	}// end for loop
	System.out.println("the sum is " + sum+".");
	}
}
