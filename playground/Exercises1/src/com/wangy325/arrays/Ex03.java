package com.wangy325.arrays;

import java.util.Arrays;

public class Ex03 {

	public static void main(String[] args) {
		// TODO 合并两个数组,按照升序排列
		int [] odd = {1,3,5,7,9,11,13,15};
		int [] even = {2,4,6,8};
		int len = odd.length + even.length;
		int [] conj = new int [len];
		
		for(int i = 0; i<len;i++) {
			if(i<odd.length) {
				conj[i] = odd[i];
			}
			else {
				conj[i] = even[i-odd.length];
			}
		}
		System.out.println(Arrays.toString(conj));
		Arrays.sort(conj);
		System.out.println(Arrays.toString(conj));
		
	}

}
