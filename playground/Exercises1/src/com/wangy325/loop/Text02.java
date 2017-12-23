//package myjava;
package com.wangy325.loop;

import java.util.Scanner;

/** 
 * @author wangy325
 *
 * 试图打印几个三角形，利用for循环嵌套
 */
public class Text02 {
	public static void main(String[] args) {
		for (int i = 0; i < 6; i++) {
			
			for (int j = 6; j > i; j--) {
//				 输出不换行
				System.out.print("*"); 
			}
//			外层for循环换行
			System.out.println();
		}
		System.out.println("--------------");
//再一个
		
		for (int i = 0; i < 6; i++) {
//			打印奇数个星星，呵呵
			for (int j = 0; j < (2*i -1); j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	
// 再一个 打印一个行数为奇数的菱形
		/**  5行
		 *   #####*			5 1 
		 *   ####***		4 3
		 *   ###*****		3 5
		 *   ##*******		2 7
		 *   #*********		1 9 
		 *   ##*******		2 7 		4行
		 *   ###*****
		 *   ####***
		 *   #####*
		 */
		Scanner height = new Scanner(System.in);
		System.out.println("请输入菱形形行数：");
		int H = height.nextInt();
		if (H%2 != 0) {  // 行高为奇数
//			上部分
				for (int i = 0; i <= (H/2+1 ); i++) {
					for (int j = 0; j <= ((H/2 +1)-i); j++) {
						System.out.print(" ");
					}
					for (int j = 0; j < (2*i -1); j++) {
						System.out.print("*");
						
					}
					System.out.println();		
				}
			
//		下部的
				for (int i = 1; i <=(H/2); i++) {
					for (int j =0; j <=(i); j++) {
						System.out.print(" ");
					}
					for (int j = 0; j <(H-2*i); j++) {
						System.out.print("*");
					}
					System.out.println();
				}
		}	//end if
		else { 		// 如果输入的行高为偶数
			for (int i = 0; i <= (H/2); i++) {
				for (int j = 0; j <= ((H/2 +1)-i); j++) {
					System.out.print(" ");
				}
				for (int j = 0; j < (2*i -1); j++) {
					System.out.print("*");
					
				}
				System.out.println();		
			}
		
//	下部的
			for (int i = 1; i <=(H/2); i++) {  // 下面减一行
				for (int j =0; j <=(i+1); j++) {
					System.out.print(" ");
				}
				for (int j = 1; j <(H-2*i); j++) {
					System.out.print("*");
				}
				System.out.println();
			}
		} //end else
		height.close();
	}	
}
