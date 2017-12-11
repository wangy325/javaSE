package com.wangy325.condition;


public class for_stat01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// do u know the sum of all evens within 100?
		int i = 1, sum =0 ;
		for (;i <=100;) {
//		int sum = 0;
//		for(int i =1;i<=100;i++) {
			if(i%2 == 0) {
				sum += i;
			}
			i++;
		}
		System.out.println("the sum of all evens within 100 is "+ sum+".");
	}

}
