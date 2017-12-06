package com.wangy325.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Ex05 {

	public static void main(String[] args) {
		// TODO 会员积分备份与赠送
		
		Scanner points = new Scanner(System.in);
		System.out.println("请输入5位会员的积分:");
		int [] pts = new int [5];
		for(int i = 0 ; i<5; i++) {
			System.out.print("请输入第"+(i+1)+"位会员的积分:");
			int pt = points.nextInt();
			pts[i] = pt;
		}
//		System.out.println(Arrays.toString(pts));
//		备份原积分
		int [] pts_bak = new int [5];
		for(int i = 0; i<pts_bak.length;i++) {
			pts_bak[i] = pts[i];
		}
//		System.out.println(Arrays.toString(pts_bak));
//		赠送积分
		for(int i =0; i<pts.length;i++) {
			pts[i]+=500;
		}
//		打印
		System.out.println("序号\t历史积分\t\t新年积分");
		for(int i = 0; i<pts.length;i++) {
			System.out.println((i+1)+"\t"+pts_bak[i]+"\t\t"+pts[i]);
		}
		
		points.close();
	}

}
