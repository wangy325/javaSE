/**
 * 
 */
package com.wangy325.Ex3;

import java.util.*;

/**
 * @author wangy325
 *
 * @date Dec 19, 2017  5:43:17 PM
 *
 * @decription   调用集合元素的方法, 是多态中的向下转型
 * 
 */
public class wList {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		// 创建集合元素
		List workList = new ArrayList();
		workList.add(new Worker("zhang3", 18, 3000));
		workList.add(new Worker("li4", 20, 3500));
		workList.add(new Worker("wang5", 19, 3200));

		// 打印集合元素
		for (Object li : workList) { // 增强for 循环遍历
			if (li instanceof Worker) { // instance(实例a) instanceof class [多态中的向下转型啊]
				Worker list = (Worker) li; // 为了调用 Worker 的方法,此处将 遍历中的 集合元素强转成 Worker 类
				list.showInfo();
			}
		}
		System.out.println("-------------------");
		// 插入一个集合元素, 顺便删除 wang5 的信息
		workList.add(1, new Worker("zhao6", 24, 3300));
		workList.remove(3);
		for (int i = 0; i < workList.size(); i++) {
			// 普通的 for 循环遍历
			// 注意instanceof 表达式的写法
			if (workList.get(i) instanceof Worker) {
				Worker list = (Worker) workList.get(i);
				list.showInfo();
			}
		}
		System.out.println("-----------------");
		// 利用迭代器 Iterator 获取对象再调用 showInfo方法
		Iterator ite = workList.iterator();
		while (ite.hasNext()) {
			// ite.next() 返回一个 Object 需要 类型转换
			// if (ite.next() instanceof Worker) { //①
			Worker wok = (Worker) ite.next();
			wok.showInfo();
			// }
			/**
			 * 说明: 这里如果加入了①式 中的 instanceof 语句, 会导致 NullSuchElementException 错误
			 * 这个错误, 与 Exercises2/com.wangy325.workbook1_8/Test.java 中使用 Scanner 的next()
			 * 读取控制台输入出现的错误一样
			 * 
			 *  原因在于, if 判断语句里面迭代一次, 然后类型强制转换里面又迭代了一次,
			 *  这导致了 cousor 值越界, 而集合对象对应的 Worker 对象并不存在
			 */
		}
		// 测试为 Worker 类重写的 equals 方法:
		// 新建两个worker 对象
		Worker worker1 = new Worker("li4", 20, 3500);// 存在
		Worker worker2 = new Worker("wang5", 19, 3200);// 不存在
		Worker worker3 = new Worker(null,19,3200);//  ① 不存在  
		/**
		 * 如果没有重写 equals 方法, 两个表达式返回的都是 false
		 * 利用equals 可以进行判断之后的增加操作, 若已经存在, 则不添加, 否则添加....
		 * 
		 * contains() 方法依次比较的是 workList.get(index).eauqals(worker) 是否
		 * 逻辑相等, 只要有一个相等, 便返回 true
		 * 
		 * 对于①表达式, 如果判断出现 NullPointerException 错误, 这是由于重写的 equals 方法
		 * 不够健康, 没有判空!
		 */
		System.out.println("集合中是否包含 worker1? " + workList.contains(worker1));
		System.out.println("集合中是否包含 worker2? " + workList.contains(worker2));
		System.out.println("集合中是否包含 worker3? " + workList.contains(worker3));
	}
}
