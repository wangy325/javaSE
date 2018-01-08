package com.wangy325.condition;
import java.util.Scanner;

/**
 * 
 * @author wangy325
 *
 * @date Nov 30, 2017  7:54:59 PM
 */
public class If_state01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("input the mark of ZhangHao:");
		Scanner sc = new Scanner(System.in);
		double score = sc.nextDouble();
		if(score > 98) {
			System.out.println("张浩获得一个MVP作为奖励");
		}	
		else {
			System.out.println("好好学习，天天向上");
		}
		
		System.out.println("input the mark again:");
		int mark = sc.nextInt();
		// mark > 60 ? "成绩合格" : "成绩不合格";
		// why Err?
		String QR = (mark > 60)? "qualified" : "unqualified";
		System.out.println(QR);
		/*if(mark>60) {
			System.out.println("qualified");
		}
		else {
			System.out.println("unqualified");
		}*/
		// resource leak: 'sc' is never closed
		sc.close();
	}

}
