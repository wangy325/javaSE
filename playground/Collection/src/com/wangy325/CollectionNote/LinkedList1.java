/**
 * 
 */
package com.wangy325.CollectionNote;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author wangy325
 *
 * @date Dec 19, 2017  10:24:11 AM
 *
 * @decription  List 接口的实现类 LinkedList, 它是一个基于链表的实现类, 对于顺序访问集合中的元素进行了优化
 * 		
 * 				优点: 删除和添加效率比较高;
 * 				缺点: 随机读取效率比较低
 * 
 *  			List 接口的实现类 ArrayList 是用数组结构实现的 List 集合 
 *				// 优缺点需要深度理解原理才能深刻理解
 * 				优点
 * 					1. 使用索引取出元素效率较高(随机读取效率高);
 * 					2. 可以使用索引来快速定位对象;
 * 				缺点:
 * 					添加和删除效率不高
 * LinkedList 新增方法:
 * 1. public void addFirst(E e);向集合头部添加数据
 * 2. public void addLast(E e);向集合尾部添加数据
 * 3. public E removeFirst();删除链表第一个数据，并返回被删除的数据
 * 4. public E removeLast();删除链表的最后一个数据，并返回被删除的数据
 */
public class LinkedList1 {
	public static void main(String[] args) {
		long l1 = System.currentTimeMillis();
		LinkedList<String> linkedList = new LinkedList<String>();
		for (int i = 0; i < 99999; i++) {
			linkedList.add("张三" + i);
		}

		long l2 = System.currentTimeMillis();
		System.out.println("LinkedList 添加时间：" + (l2 - l1));

		ArrayList<String> arrayList = new ArrayList<String>();
		for (int i = 0; i < 99999; i++) {
			arrayList.add("张三" + i);
		}
		long l3 = System.currentTimeMillis();
		System.out.println("ArrayList 添加时间：" + (l3 - l2));

		for (int i = 0; i < arrayList.size(); i++) {
			arrayList.get(i);

		}
		long l4 = System.currentTimeMillis();
		System.out.println("ArrayList 遍历时间：" + (l4 - l3));
		for (int i = 0; i < linkedList.size(); i++) {
			linkedList.get(i);
		}
		long l5 = System.currentTimeMillis();
		System.out.println("linkedList 遍历时间：" + (l5 - l4));

		while (linkedList.size() > 0) {
			linkedList.removeFirst();
		}
		long l6 = System.currentTimeMillis();
		System.out.println("linkedList 删除时间：" + (l6 - l5));

		while (arrayList.size() > 0) {
			arrayList.remove(0);
		}
		long l7 = System.currentTimeMillis();
		System.out.println("arrayList 删除时间：" + (l7 - l6));

	}

}
