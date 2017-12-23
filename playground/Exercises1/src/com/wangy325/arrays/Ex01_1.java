package com.wangy325.arrays;

import java.util.Arrays;

public class Ex01_1 {

	public static void main(String[] args) {
		// TODO 将数组中的0去掉,返回一个新数组
		int [] ini = {1,13,34,5,0,0,0,16,7,24,9,0,89,37,0,17};
//		定义一个长度为5的新数组,取出原数组强5个非0的元素
		int [] fin = new int [5] ;
		int n = 0;
//		boolean flag = false;
		for (int i = 0; i < ini.length;i++) {
//			for(int j = 0; j< ini.length;j++) {
				if (ini[i] != 0) {
//					ini[j] = ini[j+1];
					fin[n] = ini[i];  
					n++;	
				}
//			}
				if (n>4) {break;}   // 超出 fin 数组长度即break,防止下标越界
//			if (flag) {break;}	
		}
		System.out.println(Arrays.toString(fin));
	}
// 两层for循环遍历,只是将0元素替换掉,并没有改变数组的长度
// 数组的索引数一定要对应,不然出现越界报错
}
