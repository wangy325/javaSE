package com.wangy325.arrays;

import java.math.BigDecimal;
import java.util.Scanner;

public class Ex07 {

	public static void main(String[] args) {
		// TODO 求平均值

		Scanner score = new Scanner(System.in);
		double[] scores = new double[10];
		for (int i = 0; i < 10; i++) {
			System.out.print("请输入第" + (i + 1) + "个评委的打分:");
			// 打印不写在前面,控制台调用不出来!!
			double mk = score.nextDouble();
			scores[i] = mk;
		}

		double max = 0d, min = scores[0], sum = 0d;
		for (int i = 0; i < 10; i++) {
			if (scores[i] > max) {
				max = scores[i];
			}
		
			if (scores[i] < min) {
				min = scores[i];
			}
		
			sum += scores[i];
		}
		sum = sum -(max +min);
//		试着保存两位有效位
		BigDecimal fixed = new BigDecimal(sum);
		sum = fixed.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
		System.out.println("去掉一个最高分"+max+",去掉一个最低分"+min+"平均分是:" + (sum / 8));
		score.close();
	}

}
