/**
 * 
 */
package com.wangy325.Ex4;

import java.util.*;

/**
 * @author wangy325
 *
 * @date Dec 20, 2017  10:28:11 AM
 *
 * @decription  集合元素的排序操作
 * 
 * @target TODO
 */
public class Sort {
//	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		List<Integer> A = new ArrayList<>();
		List<Integer> B = new ArrayList<>();
		List<Integer> C = new ArrayList<>();

		A.add(1);
		A.add(7);
		A.add(9);
		A.add(11);
		A.add(13);
		A.add(15);
		A.add(17);
		A.add(19);
		B.add(2);
		B.add(4);
		B.add(6);
		B.add(8);
		B.add(10);
		C.addAll(A);
		C.addAll(B);

		/** 直接利用 比较器进行排序, 后续再补充
		 * Collections.sort(C);
		 * System.out.println(C);
		 */

		// 对元素进行冒泡排序
		System.out.println(C);
		for (int i = 0; i < C.size(); i++) {
			for (int j = 0; j < C.size() - 1 - i; j++) {
				if (C.get(j) instanceof Integer) {
					int a = (Integer) C.get(j);
					int b = (Integer) C.get(j + 1);
					if (a > b) {
						C.set(j, b);
						C.set(j+1, a);
					}
				}
			}
		}
		for(Object obj: C) {
			System.out.print(obj +" ");
		}
	}

}
