package com.wangy325.MyCollection;

import java.util.*;

/**
 * @author wangy325
 *
 * @date Dec 18, 2017  8:22:25 PM
 *
 * @decription  几种不同的遍历集合的方法
 * 				介绍了 Iterator 中 4 种常用的方法
 */
public class Coll2 {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		// 方法1 了解 利用 1.8 新增的 Lambda 表达式遍历集合 (Lambda 表达式也可以遍历数组元素)
		Collection books = new ArrayList();
		books.add("the man who steals shadow");
		books.add("another you in the world");
		books.add(23.21);
		// 调用 Iterable 的 forEach() 方法 遍历集合
		books.forEach(obj -> System.out.println("Lamdba 表达式遍历集合: " + obj));

		/** -------------------------------------*/
		// 方法 2 利用 1.8 的增强 Iterator 遍历集合元素
		/**
		 * Iterator 接口也是 Java 集合框架的成员之一, 其与 Collection 和 Map 不一样
		 * 它不用来盛装对象, 而是专门用来遍历(迭代访问) Collection 集合中的元素的
		 *  Iterator 接口定义了4个方法
		 *  boolean hasNext(); 如果集合还未被迭代完, 则返回 true;
		 *  Object next(); 返回集合里的下一个元素;
		 *  	/*这里注意, 返回的是 Object 类型
		 *  void remove(); 删除集合中上次 next 方法返回的元素;
		 *  void forEachRemaining(Consumer action); 1.8新增, 可以用 Lambda 表达式遍历集合元素;
		 */
		// 获取 books 集合对应的迭代器
		Iterator bookIt = books.iterator();
		while (bookIt.hasNext()) {
			// 这里的 hasNext() 和 next() 返回的是 ? next() 看起来很别扭
			Object bookName = bookIt.next();
			System.out.println("使用 Iterator 遍历集合元素: " + bookName);
			/**String book = (String)bookIt.next();
			 * 如果想输出 String 类型的数据, 则必须要进行强制类型转换(如果可以转换的话)
			 * 实践证明, double 不能转成 String 
			System.out.println("String book is: " + book);*/

			//
			if (bookName.equals("another you in the world")) {
				// 这里已经删除了 "another you in the world" 这个元素
				bookIt.remove();
				/**books.remove(bookname);*/ // ①
				// System.out.println(books);
			}
			// 试图通过 Iterator 接口的方法改变原集合的元素值
			// bookname = "aaaa"; //②
		}
		// 并且删除操作已经保存了, 但是 "aaaa" 并没生效
		/**
		 * 1. 不能在迭代器内部使用 Collection 的方法对集合进行操作 (①式),
		 * 		不然会引发 ConcurrentModificationException 错误
		 * 		这是由 Iterator 执行机制引起的
		 * 2. Iterator 迭代操作过程中, 只能用迭代器的 remove 方法删除
		 * 		next 方法返回的元素值, ②式无效
		 */
		System.out.println("迭代器代码块中进行 remove 操作后: " + books);

		/**--------------------------------*/
		// 方法3 利用 Lambda 表达式遍历 Iterator
		// 获取迭代器
		Iterator nameBook = books.iterator();
		// Lamdba 表达式
		nameBook.forEachRemaining(obj -> System.out.println("利用 Iterator 的 forEachRemaining() 迭代后的集合: " + obj));

		/**-----------------------------*/
		// 方法4 利用 Java 1.5 foreach 遍历
		/**
		 * foreach 语法:
		 * 	for(对象类型 变量名（随便取） :　数组名｜集合名)
		 */
		for (Object objjkji : books) {
			Object bk = objjkji;
			System.out.println("利用 foreach 遍历集合元素: " + bk);
		}

	}
}
