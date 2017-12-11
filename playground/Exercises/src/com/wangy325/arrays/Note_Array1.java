package com.wangy325.arrays;

import java.util.Arrays;

public class Note_Array1 {

	public static void main(String[] args) {
		// 创建及初始化数组
		// 数组类型 [] 数组变量名 (推荐) 或 数组类型 数组变量名字 []
		// 数组声明 = new 数组类型[数组长度]
		int[] arr01 = new int[3];
		// 动态初始化
		arr01[0] = 1;
		arr01[1] = 2;
		arr01[2] = 3;

		// 静态初始化 下面两种方法等效
		// int [] arr2 = {12,23,34,45};
		int[] arr2 = new int[] { 12, 23, 34, 45 };
		// 利用for 循环枚举数组内容
		for (int i = 0; i < arr2.length; i++) {
			System.out.println(arr2[i]);
		}
		System.out.println("*********cut off line********");
		// 利用增强for循环枚举数组内容,jdk 1.5以上版本新特性
		// 不能操作数组!!!
		// 语法:
		/*
		 * for (数组类型 变量名: 数组名) { statement; }
		 */
		for (int element : arr2) {
			System.out.println("arr2's elements are:" + element);
		}

		System.out.println("***********cut off line*********");

		// 数据对象的方法

		// 1. Arrays.toString()
		String str = Arrays.toString(arr2);
		System.out.println("str = " + str);
		System.out.println("************ cut off line***********");

		// 2. Arrays.sort()
		// 按照数字大小顺序进行排序
		int[] arr3 = { 12, 123, 213, 23, 56, 234, 89, 765 };
		Arrays.sort(arr3);
		System.out.println(Arrays.toString(arr3));
		// [12, 23, 56, 89, 123, 213, 234, 765]
		System.out.println("************ cut off line***********");

		// 3. Arrays.binarySearch()
		// 查找一个值是否在数组中一个元素的值,如是,则返回该元素的在数组中的位置;
		// 如不是,则返回一个负值
		// 利用 for 循环枚举
		int[] arr4 = { 3, 5, 2, 11, 9, 8 };
		int element = 11, index = 0;
		for (int i = 0; i < arr4.length; i++) {
			if (arr4[i] == element) {
				index = i;
				break;
			}
		}
		System.out.println(element + "在数组 arr4中的位置是:" + index);
		// ! 利用 Arrays.binarySearch()的话,要先对数组进行排序操作
		// 二分查找是基于二分排序算法的;
		Arrays.sort(arr4);
		int eindex = Arrays.binarySearch(arr4, 11);
		System.out.println("元素在数组中的索引是" + eindex);
		int eindex1 = Arrays.binarySearch(arr3, 78);
		System.out.println("元素在数组中的索引是:" + eindex1);
		System.out.println("************ cut off line***********");

		// 格式化数组

		Arrays.fill(arr4, 6);
		System.out.println(Arrays.toString(arr4));
		// [6,6,6,6]

		// Bubble Sort 冒泡排序 !!!
		// 两两比较,将大(小)的元素往前移动(冒泡)
		/**
		 * 第一轮,两两比较,将最大(最小)的元素排到最后; 
		 * 第二轮,将剩余的元素中最大(最小)的排到最后; 
		 * ...
		 * 第(arr.length-1)轮比较,将最大(最下)的元素排到最后;
		 */
		int[] bubble = { 5, 2, 7, 9, 6, 4, 8, 1 };
		int temp = 0;
		// 外层循环控制比较回合数
		for (int i = 0; i < bubble.length; i++) {
			// 内层循环,控制元素比较
			for (int j = 0; j < bubble.length-1-i ; j++) {
				if (bubble[j] > bubble[j + 1]) { // 升序排序
				// if (bubble[j] < bubble[j + 1]) { // 降序排序
					// 元素值交换操作
					temp = bubble[j];
					bubble[j] = bubble[j + 1];
					bubble[j + 1] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(bubble));

		int[] arr = { 12, 23, 34, 45 };

		String a = Arrays.toString(arr);

		System.out.println(a);

	}

}
