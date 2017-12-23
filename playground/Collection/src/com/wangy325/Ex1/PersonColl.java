/**
 * 
 */
package com.wangy325.Ex1;

import java.util.*;

/**
 * @author wangy325
 *
 * @date Dec 19, 2017  10:54:15 AM
 *
 * @decription   通过 person[] 创建 Person Collection 
 * 
 * @target TODO
 */
public class PersonColl {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		Scanner Attribute = new Scanner(System.in);
		System.out.println("请输入你先创建的对象个数:");
		/**
		 * Scanner 的交互缺乏多样性, 目前想不到对输入类型进行判断的好的解决方法
		 *  
		 * 	1. Java 无法对输入进行类型判断, 要求输入整形, 如若输入了其他非法字符, 如何让重复输入?
		 *  2. 对字符串的处理, 涉及到 next(), 其以分隔符为界视为输入结束, 如果字符串输入的时候,
		 *  	误输入了带空格的两个字符串,则会出现编译报错
		 */
		int COUNT = Attribute.nextInt();
		Person[] person = new Person[COUNT];
		for (int i = 0; i < COUNT; i++) {
			person[i] = new Person();
			System.out.println("请输入第" + (i + 1) + "个对象的名字:");
			String Name = Attribute.next();
			// NullPointerException ??
			// 若未在 44 行 初始话对象的的话, 才会引发空指针错误
			person[i].setName(Name);
			System.out.println("请输入第" + (i + 1) + "个对象的年龄:");
			int Age = Attribute.nextInt();
			person[i].setAge(Age);
		}
		Attribute.close();

		Collection personCollection = new ArrayList();

		for (int i = 0; i < person.length; i++) {
			personCollection.add(person[i].getName() + " @age " + person[i].getAge());
		}
		// 遍历集合中的元素
		// 方法1 直接利用Lambda 表达式遍历
		personCollection.forEach(ysl -> System.out.println("方法1: "+ysl));
		// 获取迭代器
		Iterator attri = personCollection.iterator();
		// 方法2 利用 Iterator 的 Lamdba 表达式 遍历
		attri.forEachRemaining(obj -> System.out.println("方法2: "+obj));
		// 方法3 普通迭代器遍历
		/**
		 * 需要说明的是, 方法2 和 方法3 使用的是同一个迭代器, 所以方法3的输出为空!
		 * 原因是, 迭代时候, 系统方法里有个变量 cursor(类似于index) , 方法2 迭代的时候, 实际上调用的是同样的方法,
		 * 这里把这个 cursor 变量 自增到[越界]
		 * 合理的做法是, 方法3 的时候,再重新获取一个迭代器
		 */
		System.out.println("-------------");
		/**while(attri.hasNext()) {
			Object akk = attri.next();
			System.out.println(akk);
		}*/

	}

}
