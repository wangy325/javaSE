package com.wangy325.arrays;

import java.util.Arrays;

public class Ex01 {

	public static void main(String[] args) {
		// TODO 将数组中的0去掉,返回一个新数组
		int[] ini = { 1, 13, 34, 5, 0, 0,0, 16, 7, 24, 9, 0, 89, 37, 0, 17 };

		int count = 0;
		// 找出元素为零的项数
		for (int i = 0; i < ini.length; i++) {
			if (ini[i] == 0) {
				count++;
			}
		}
		// count 用来控制新数组的长度
		int[] fin = new int[ini.length - count];
		// System.out.println(count);
		// 重新定义一个计数器,用来控制新数组的索引号
		int time = 0;
		for (int i = 0; i < ini.length; i++) {
			for (int j = i - time; j < ini.length-count ; j++) {
				// 如果原数组元素不为0,则直接赋值给新数组
				if (ini[i] != 0) {
					fin[j] = ini[i];
				}
				// 如果元素组元素为0,则跳出当前赋值操作,并将计数器自增;
				// 用来控制新数组索引回退
				else {
					time++;
					break;

				}
			}
		}
		System.out.println(Arrays.toString(ini));
		System.out.println(Arrays.toString(fin));
	}

}
