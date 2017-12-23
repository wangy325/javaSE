package com.wangy325.loop;

import java.util.Scanner;

public class Ex05 {

	public static void main(String[] args) {
		// TODO 系统知道你犯了错！
		Scanner mark = new Scanner(System.in);
		int mk = 0 , sum = 0;
		for (int i = 1; i <= 5; i++) {
			System.out.print("请录入第"+i+"门的成绩:");
			mk = mark.nextInt();
			if (mk <0 || mk >150) {
				System.out.println("出现了不可能出现的成绩，请重新录入：");
				/*i =1;
				for(; i<=5; i++) {
					System.out.print("请录入第"+i+"门的成绩:");
					int mk1 = mark.nextInt();
				}*/	
				i -=1;
				continue;
			}
			sum += mk;
		}
		mark.close();
		System.out.println("平均成绩为："+(sum*1.0d/5));
	}

}
// 此题的思想可能在于，如果输入有误，程序做出如何响应？ 合理的应该是让用户再一次输入该课程成绩；
// 或者让用户重新输入所有成绩，而不是单纯的break 或continue，
// 这里最理想的是跳出循环而重新执行循环，或者从单前循环回退一步从新执行，如何操作？ 已解决
// 
// 
