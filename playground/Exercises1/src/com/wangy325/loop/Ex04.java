package com.wangy325.loop;

import java.util.Scanner;

public class Ex04 {

	public static void main(String[] args) {
		// TODO 键盘能控制一切，尝试输入一个整数，然后嘿嘿
		
		Scanner integer = new Scanner(System.in);
		System.out.println("请输入一个要运算的数，记为a：");
		int a = integer.nextInt();
		System.out.println("请输入一个运算数的个数，记为n：");
		int n = integer.nextInt();
		int sum=0;
		for (int i = 1; i <= n; i++) { // 求和循环
			double aj=0; int ai=0;
			for (int j = 1; j <= i; j++) { // 求单个运算值循环
				aj = a*Math.pow(10,(j-1));
				ai +=aj;
			}
//			System.out.println(ai);
			sum +=ai;
		}
		System.out.println("奇怪的和[a+aa+aaa+a..(n-2)个a..a]为："+sum+"。");
		integer.close();
	}

}
