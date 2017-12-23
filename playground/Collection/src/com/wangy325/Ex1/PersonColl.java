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
		PersonColl pc = new PersonColl();
		Collection personCollection = new ArrayList();
		Person[] person = pc.generatePersonInstance();
		for (int i = 0; i < person.length; i++) {
			personCollection.add(person[i].getName() + " @age " + person[i].getAge());
		}
		// 遍历集合中的元素
		// 方法1 直接利用Lambda 表达式遍历
		personCollection.forEach(ysl -> System.out.println("方法1: " + ysl));
		System.out.println("-------------");
		// 获取迭代器
		Iterator attri = personCollection.iterator();
		// 方法2 利用 Iterator 的 Lambda 表达式 遍历
		attri.forEachRemaining(obj -> System.out.println("方法2: " + obj));
		// 方法3 普通迭代器遍历
		/**
		 * 需要说明的是, 方法2 和 方法3 使用的是同一个迭代器, 所以方法3的输出为空!
		 * 原因是, 迭代时候, 系统方法里有个变量 cursor(类似于index) , 方法2 迭代的时候, 实际上调用的是同样的方法,
		 * 这里把这个 cursor 变量 自增到[越界]
		 * 合理的做法是, 方法3 的时候,再重新获取一个迭代器
		 */
		/**while(attri.hasNext()) {
			Object akk = attri.next();
			System.out.println(akk);
		}*/

	}

	/**
	 * 12.22 修改:
	 * 		1. 将生成 Person 实例的代码写进方法 generatePersonInstance() 中
	 * 		2. 处理 next() 迭代器 mismatch 异常
	 * 		3. next() 迭代器的问题并没有完全解决, 还有很多值得讨论的地方
	 * @return
	 */
	/**
	 * Scanner 的交互缺乏多样性, 目前想不到对输入类型进行判断的好的解决方法
	 *  
	 * 	1. Java 无法对输入进行类型判断, 要求输入整形, 如若输入了其他非法字符, 如何让重复输入?
	 * @Date 12/22 reply
	 * 		可以利用 try-catch 代码块对异常进行处理， 如果想要重复输入，可将代码放入循环体中
	 * 		（一般是while循环），利用 flag 进行条件判断；
	 *     
	 *  2. 对字符串的处理, 涉及到 next(), 其以分隔符(空格)为界视为输入结束, 如果字符串输入的时候,
	 *  	误输入了带空格的两个字符串,则会出现编译报错
	 *  	// InputMismatchException
	 *  	// 这里涉及到 next() 的迭代机制
	 */
	public Person[] generatePersonInstance() {
		Scanner Attribute = new Scanner(System.in);
		System.out.println("请输入你想创建的对象个数:");
		int COUNT = 0;
		Person[] person = null;
		boolean flag = true;
		while (flag) {
			try {
				COUNT = Attribute.nextInt();
				person = new Person[COUNT];
				flag = false;
//				 System.out.println(person.length);
				int i = 0;
				while (i < COUNT) {
					try {
						System.out.println("请输入第" + (i + 1) + "个对象的名字和年龄, 以空格键分开:");
						String Name = Attribute.next();
						/**
						 * 关于没有 person[i] = new Person() 出现 NullPointerException 的解释
						 * 	1. 初始化的 person[] 数组长度为 COUNT, 里面的内容全部为 null;
						 * 	2. 这句代码的意思在于将person[i]的元素初始化成一个 Person 对象;
						 */
						person[i] = new Person();
						person[i].setName(Name);
						int Age = Attribute.nextInt();
						person[i].setAge(Age);
						i++;
					} catch (IndexOutOfBoundsException e) {
						// e.printStackTrace();
						System.out.println("数组下标越界异常");
						break;
					} catch (NullPointerException e) {
						System.out.println("空指针异常");
						e.printStackTrace();
						break;
					} catch (Exception e) {
						System.out.println("错误: 输入对象名或年龄非法!");
					}
				}
			} catch (Exception e) {
				@SuppressWarnings("unused")
				String Trash = Attribute.next();
				System.out.println("错误: 请输入正整数以表示对象数!");
			}
		}
		Attribute.close();
		return person;

	}

}
