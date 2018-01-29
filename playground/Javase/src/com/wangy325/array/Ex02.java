package com.wangy325.array;

import java.util.Arrays;

public class Ex02 {

	public static void main(String[] args) {
		// TODO 倒序输出一个数组

		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		int temp;
		for (int i = 0; i < arr.length / 2; i++) {
			temp = arr[i];
			arr[i] = arr[arr.length - 1 - i];
			arr[arr.length - 1 - i] = temp;
		}
		System.out.println(Arrays.toString(arr));
		// 或用for循环遍历输出:
		for (int i = 0; i < arr.length; i++) {

			if (i == 0) {
				System.out.print("{" + arr[0] + ",");
			} else if (i == arr.length - 1) {
				System.out.print(arr[arr.length - 1] + "}");
			} else {
				System.out.print(arr[i] + ", ");
			}

		}
	}

}
