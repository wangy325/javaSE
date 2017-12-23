package com.wangy325.loop;

//import sun.security.util.Length;

public class Ex02 {

	public static void main(String[] args) {
		//  TODO 利用while循环计算100以内（含）的偶数和
		int i= 0, sum = 0;
		while (i<=100) {
			if(i%2 == 0) {
				sum +=i;
			}
			i++;
		}
		System.out.println("一百以内（含）的偶数和是 "+sum+".");
		
		
	}

}
