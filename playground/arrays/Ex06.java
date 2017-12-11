package com.wangy325.arrays;

//import java.util.Arrays;
import java.util.Scanner;

public class Ex06 {

	public static void main(String[] args) {
		// TODO 求最小值
		Scanner price = new Scanner(System.in);
		System.out.println("请输入四家店的价格:");
		int[] prices = new int[4];
		for (int i = 0; i < 4; i++) {
			System.out.print("第" + (i + 1) + "家店的价格是:");
			int ps = price.nextInt();
			prices[i] = ps;
		}
		// System.out.println(Arrays.toString(prices));
//		求最小值
		int min = prices[0];
		for(int i = 0; i<prices.length;i++) {
			if (prices[i] < min ) {
				min = prices[i];
			}	
		}
		System.out.println("最低的价格是:"+min);
		price.close();
	}

}
