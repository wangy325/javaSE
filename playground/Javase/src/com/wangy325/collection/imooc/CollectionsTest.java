/**
 * 
 */
package com.wangy325.collection.imooc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @author wangy325
 *
 * @date Dec 26, 2017  11:53:36 AM
 *
 * @decription  介绍了 collection 工具类 对集合的一些操作
 * 
 * @target TODO 1. 对 Integer 类型的泛型 List 集合进行排序;
 * 				2. 对 String 类型的泛型 List 集合进行排序;
 * 				3. 对其他类型泛型的 List 集合进行排序
 */
public class CollectionsTest {

	/**
	 * 对存放 Integer 型对象的 List 集合进行排序 
	 * 1. 要求生成 10 个 大小不同的数
	 * 2. 利用 Collections 工具类进行排序
	 * 3. 输出
	 */
	public void testSortIntegerList() {
		List<Integer> inteList = new ArrayList<Integer>();
		Random random = new Random();
		int k;
		for (int i = 0; i < 10; i++) {
			// do...while 保证添加到集合中的元素不重合
			do {
				k = random.nextInt(100);
			} while (inteList.contains(k));
			inteList.add(k);
		}
		System.out.print("未排序的数据是:");
		for (Integer list : inteList) {
			System.out.print(list + " ");
		}
		Collections.sort(inteList);
		System.out.println();
		System.out.print("排序后的数据是:");
		for (Integer list : inteList) {
			System.out.print(list + " ");
		}
		System.out.println("--------------");
	}

	/**
	 * 1. 随机向一个 String 泛型的 List 中添加 10 个随机字符串
	 * 2. 要求 字符串长度为10 以内
	 * 3. 要求 每个字符串的每个字符都是随机生成的字符, 字符可以重复
	 * 4. 随机字符串不可以重复
	 * 5. 规定字符串的内容为任意数字或者大小写字母
	 */
	public void testSortStringList() {
		List<String> strList = new ArrayList<String>();
		// 外层循环控制字符串数量
		// 内层循环控制字符串长度
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			String str = "";
			do {
				for (int j = 0; j < random.nextInt(10) + 1; j++) {
					// 1. 随机生成数字
					char ele = (char) (random.nextInt(10) + 48);
					// 2. 随机生成字母
					char elem = (char) (random.nextInt(26) + 65);
					if (random.nextBoolean()) {
						/*
						 * int low = elem; int up = low + 32; elem = (char) up;
						 */
						elem += 32;
					}
					// 生成字符串
					if (random.nextBoolean()) {
						str += ele;
					} else {
						str += elem;
					}
				}
			} while (strList.contains(str));
			strList.add(str);
		}
		/**
		 * 方法2 利用 StringBuffer 或者 StringBulilder 生成字符串
		 */
		String sup = "abcde3fghijkl1mn0opqr4stuv8wxyzA5BCDEF9GHIJKL7MNOPQRS2TUV6WXYZ";
		for (int j = 0; j < 10; j++) {
			int strLen = random.nextInt(10) + 1;
			// 初始化一个 StringBuffer 对象
			StringBuffer sb = new StringBuffer("");
			do {
				for (int i = 0; i < strLen; i++) {
					sb = sb.append(sup.charAt(random.nextInt(sup.length())));
				}
			} while (strList.contains(sb.toString()));
			strList.add(sb.toString());
		}
		System.out.println("-------排序前-------");
		for (String st : strList) {
			System.out.println(st);
		}
		Collections.sort(strList);
		System.out.println("-------排序后-------");
		for (String st : strList) {
			System.out.println(st);
		}
	}

	public static void main(String[] args) {
		CollectionsTest cu = new CollectionsTest();
		cu.testSortIntegerList();
		cu.testSortStringList();
	}

}
