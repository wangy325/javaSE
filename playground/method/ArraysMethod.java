/**
 * 
 */
package com.wangy325.method;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author wangy325
 *
 * @date Dec 6, 2017  4:47:26 PM
 *
 * @decription  写几个数组常用算法的方法
 * 
 * @target TODO 1. 数组元素求和
 * 				2. 求最大(小)元素
 * 				3. 排序操作
 * 				
 */
public class ArraysMethod {
	// 求数组元素和的方法
	public int getSum(int arr[]) {
		int sum = 0;
		for(int i = 0; i<arr.length;i++) {
			sum += arr[i];
		}
		return sum;
	}
//	求最大(最小)值的方法
	public int getMax(int arr[]) {
		int max = arr[0];
		for(int i = 0; i<arr.length;i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		return max;
	}
//	排序
	public void getSort(int arr[]) {
		for(int i = 0;i<arr.length;i++) {
			for(int j = 0;j<arr.length -i-1;j++) {
				if (arr[j]>arr[j+1]) {
					int temp = arr[j];
					arr[j]= arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
	
	
	public static void main (String[] args) {
//		要求用户输入一个任意长度的整型数组
		System.out.println("请输入数组的长度");
		Scanner element = new Scanner(System.in);
		int length = element.nextInt();
		System.out.println("请输入整型数组元素值(回车键确认):");
		int [] arr = new int [length];
		for(int i =0 ; i<length;i++) {
			int ele = element.nextInt();
			arr[i] = ele;
		}
		System.out.println("输入的数组是:"+Arrays.toString(arr));
//		求和开始
		ArraysMethod sum = new ArraysMethod();
//		这里传参只要输入数组名就可以了;
		sum.getSum(arr);
		System.out.println("数组元素的和是:"+sum.getSum(arr));
//		求和 结束
//		求最大元素开始
		ArraysMethod max = new ArraysMethod();
		max.getMax(arr);
		System.out.println("数组中最大元素是:"+sum.getMax(arr));
//		求最大值结束
//		排序开始
		ArraysMethod arr_sort = new ArraysMethod();
		arr_sort.getSort(arr);
		System.out.println("升序排序后的数组是:"+Arrays.toString(arr));
//		排序结束
		element.close();
	}
	
}

