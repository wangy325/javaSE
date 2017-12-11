//package Ex;
package com.wangy325.loop;

import java.util.Scanner;

/**
 * 
 * @author Administrator
 *
 */
public class Ex06 {

	public static void main(String[] args) {
		// TODO 控制台输入一个个位数，列出其所有等式
		Scanner digit = new Scanner(System.in);
		System.out.print("请输入一个个位数：");
		int n = digit.nextInt();
		System.out.println("根据这个数可以输出以下加法表：");
		for (int i = 0; i <= n; i++) {
			
			System.out.println("\t"+i+"+"+(n-i)+"="+n);
		}
		digit.close();
	}

}
