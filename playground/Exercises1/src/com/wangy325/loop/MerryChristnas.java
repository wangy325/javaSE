//package myjava;
package com.wangy325.loop;

import java.util.Scanner;

/**
 * 
 * @author wangy325
 * 
 * @copy
 *
 */
public class MerryChristnas {
	// hello christmas...

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 打印圣诞树
		// 单层高度H
		
		Scanner height = new Scanner(System.in);
		System.out.println("请输入圣诞树的单层高：");
		int H = height.nextInt();
//		打印圣诞树的第一层
		for (int i = 1; i<=H; i++) {
			for (int j = 0; j <(H-i); j++) {
				System.out.print(" ");
			}
			for (int j = 0; j <(2*i -1) ; j++) {
				System.out.print("*");
			}
		System.out.println();	
		}
//		打印圣诞树的第二层
		for (int i = 1; i<=H; i++) {
			if(i <= (H/2)) {
				continue;		// 剃头用
			}
			for (int j = 0; j <(H-i); j++) {
				System.out.print(" ");
			}
			for (int j = 0; j <(2*i -1) ; j++) {
				System.out.print("*");
			}
		System.out.println();	
		}
		
//  	打印圣诞树的第三层
		for (int i = 1; i <= H; i++) {
			for (int j = 0; j < (H/2); j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < (H-1); j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		height.close();
	}

}
