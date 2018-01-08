package com.wangy325.array;

import java.util.Arrays;

public class Ex04 {

	public static void main(String[] args) {
		// TODO 一组乱序的字母,进行分别进行升序降序排序
		char[] chara = { 'c', 'v', 's', 'l', 'q', 'p', 'i', 'e', 't', 'h', 'g', 'r' };

		// 对排序数组进行倒序输出
		for (int i = 0; i < chara.length; i++) {
			for (int j = 0; j < chara.length - i - 1; j++) {
				if (chara[j] < chara[j + 1]) {
					char temp = chara[j];
					chara[j] = chara[j + 1];
					chara[j + 1] = temp;
				}
			}
		}

		System.out.println("冒泡倒序输出:" + Arrays.toString(chara));
		Arrays.sort(chara);
		System.out.println("sort方法排序:" + Arrays.toString(chara));

	}

}
