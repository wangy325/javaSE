package com.wangy325.CollectionNote;

import java.util.*; // 这个包一定要导入, Collection 和 ArrayList 工具在里面

/**
 * 
 * @author wangy325
 *
 * @date Dec 18, 2017  5:06:44 PM
 *
 * @decription 集合中 Collection 接口的基本方法 概述  
 * 	
 * Java 中的集合框架
 * 	Collection 接口------> 迭代器 [Iterator, ListIrerator]
 * 		---List 接口 有序集合 元素可以重复
 * 			!-- ArrayList 实现类
 * 			!-- LinkedList 实现类
 * 			--- Vector 实现类
 * 		---Set 接口 无序集 元素不可重复
 * 			!-- HashSet 实现类
 * 				--- LinkedHashSet
 * 			--- SortedSet 接口
 * 				!-- TreeSet 实现类
 * 		---Queue 接口 队列 有序队列, 元素可重复
 * 			--- Deque 接口
 * 				---ArrayDeque
 * 				--- LinkedList
 * 			--- PriorityQueue
 * 	Map 接口
 * 		---HashTable 实现类
 * 			---Properties
 * 		!--HashMap 实现类
 * 			---LinkedHashMap
 * 		---SortedMap 实现类
 * 			!--TreeMap
 * 对象排序接口:	Comparable   Comparator
 * 容器类工具: Collections
 * 
 */

public class Coll {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		// 创建一个新 ArrayList 对象, 它继承于 Collection 接口, 它是一个集合对象
		Collection myColl = new ArrayList();
		// 给集合添加一个元素 add();
		myColl.add("我是谁?"); // ①
		myColl.add(12); // ②
		/**
		 * 集合和数组的区别之一: 集合里面自能存放对象(实际上引用类型);而数组里面可以存放对象和基本数据类型;
		 * ① 中的 "我是谁?" 是 String 类型,没问题
		 * ② 中的 12 是整型数据, 实际上, java 1.5 之后对其进行了自动装箱, 实际上为 new Integer(12);
		 * 意思就是说, 集合中不能存放基本数据类型, 但是基本数据类型可以用包装器自动装箱 
		 */
		System.out.println("集合的元素个数为:" + myColl.size());
		myColl.add("M");
		System.out.println(myColl);
		System.out.println("集合中包含元素\"我是谁?\"吗:" + myColl.contains("我是谁?"));

		Collection urColl = new ArrayList();

		urColl.add("from HB");
		urColl.add("what");

		// 将集合 urColl 的元素全部添加到 myColl 中 addAll(Collection c)
		myColl.addAll(urColl);
		System.out.println("myColl contains: " + myColl);
		// 将集合转换成一个数组
		Object[] obj = new Object[0];
		/**
		 * 将集合转为一个对象数组, 返回类型为一个 Object[], 其长度等于集合元素的个数;
		 * 值得一提的是,数组的长度在初始化的时候可以任意赋值(上述初始化中给定长度0,即为一个空数组)
		 * 		但是, 最后进行 toArray() 操作后的长度为5
		 * 特别要说明的是, 如果存在已经定义并且初始化的 Object[] 数组, 集合的 toArray() 操作
		 * 		会将原数组重置, 并返回集合转化而成的数组
		 */
		Object[] obj2 = new Object[1];
		obj2[0] = "bonjour";
		obj = myColl.toArray();
		obj2 = myColl.toArray();
		// System.out.println(Arrays.toString(myColl.toArray()) + " @line 45");
		System.out.println(Arrays.toString(obj) + " @line 57");
		System.out.println("obj[] 数组的长度是:" + obj.length);
		System.out.println(Arrays.toString(obj2) + " @line 59");
		System.out.println(obj[1] == obj2[1]);
		/**
		 * 关于 Collection 接口中定义的方法的返回值, 有几点需要说明:
		 * 1.除了 clear() size() iterator() 和 Object[] toArray() 
		 * 	4个方法之外,其他方法的返回值均为 boolean 类型!
		 * 2. 
		 */
		// 将集合 urColl 中的远不全部清除, void clear()

		urColl.clear();
		System.out.println("is urColl Empty? " + urColl.isEmpty());
		// 判断 myColl 中是否包含 urColl 中的所有元素
		// 因为已经把 urColl 清空了
		System.out.println("is urColl contained by myColl? " + myColl.containsAll(urColl));
		urColl.add("lilian");

		// 从 myColl 中移除指定元素
		myColl.remove("what");
		System.out.println("myColl contains: " + myColl);
		urColl.add("13");
		urColl.add(12);
		// 删除 myColl 中的非 urColl中元素
		myColl.retainAll(urColl);
		System.out.println("myColl is after del E in urCOll: " + myColl);
		// 从 myColl 中删除 urColl 所包含的元素
		myColl.removeAll(urColl);
		System.out.println("myColl is after del E in urCOll: " + myColl);
	}
}
