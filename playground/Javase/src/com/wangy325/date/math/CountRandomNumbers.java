/**
 * 
 */
package com.wangy325.date.math;

import java.util.Arrays;
import java.util.Random;

/**
 * @author wangy325
 *
 * @date Dec 22, 2017  3:50:34 PM
 *
 * @decription  随机生成 400 个 区间数字, 然后统计相同的数字的个数
 */
public class CountRandomNumbers {
	/**
	 * 写一个方法 generateIntArray(), 生成一个长度为400的整形数组;
	 * 数组元素值介于 [6,50]
	 * 
	 * 迭代比较数组元素, 
	 * 输出
	 */
	public static void main(String[] args) {
		CountRandomNumbers crn = new CountRandomNumbers();
		int[] arr = crn.generateIntArray();
		// 先将数组排序
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		int COUNT = 1; //计数器
		int SUM = 0; // 统计长度以供验证
		for (int j = 0; j < arr.length; j += COUNT) {
			COUNT = 1;
			for (int i = j; i < arr.length - 1; i++) {
				if (arr[i] == arr[i + 1]) 
					COUNT++;
				else
					break;
			}
			SUM += COUNT;
			System.out.println(arr[j] + " : " + COUNT +"个");
		}
		System.out.println("所有整数个数为: "+SUM);

	}

	public int[] generateIntArray() {
		int[] arr = new int[400];
		int index = 6;
		Random random = new Random();
		for (int i = 0; i < arr.length; i++) {
			int element = index + random.nextInt(45);
			arr[i] = element;
		}
		return arr;
	}

}
