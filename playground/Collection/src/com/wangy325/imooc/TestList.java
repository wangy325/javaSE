package com.wangy325.imooc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
/**
 * @author wangy325
 *
 * @date Dec 23, 2017  9:06:30 PM
 *
 * @decription  本例测试了对集合元素进行 [增删改查] 的操作;
 */
public class TestList {
	/**
	 * 泛型的意义是规定集合元素的的数据类型, 如此规定之后, 以后获取集合元素
	 * 的属性时候, 不需要类型转换,
	 * 因为一旦泛型规定, 取出的集合元素就不再是 obj 了
	 */
	List <Course> courses2Select;
	// constructor
	public TestList() {
		this.courses2Select = new ArrayList<Course>();
	}

	/**
	 * 添加课程方法 testAdd()
	 * 介绍了向集合中添加元素的集中方法:
	 * 1. add();
	 * 2. add(index,element);
	 * 		* 注意, 这里如果 index 大于当前集合的长度的话, 会出现 IndexOutOfBoundsException 异常
	 * 		* 如果 index 不大于集合的长度, 则会 [追加] 或者 [插入] 元素到指定 index 的位置
	 * 3. addAll(Collection);
	 * 4. addAll(index,Collection)
	 * 
	 */
	public void testAdd() {
		Course course1 = new Course("数据结构", "1");
		courses2Select.add(course1);
		/**
		 * 调用 Course 的 getName() 和 getId() 方法的时候, 必然要将
		 * 取出的集合元素(Obj) 转型为 Course
		 */
		System.out.println(((Course) (courses2Select.get(0))).getName());
		
		Course course2 = new Course("算法导论", "2");
		courses2Select.add(course2);
		/**
		 * 这里 instanceof 操作符用来判断集合中的元素是不是 Course 的实例
		 * 实际上, 我们创建元素的时候将 Course 实例添加到集合中
		 * 因此, instanceof 的返回值必然是 true
		 */
		if (courses2Select.get(1) instanceof Course) {
			Course temp = (Course) courses2Select.get(1);
			System.out.println(temp.getId() + ":" + temp.getName());
		}
		
		Course course3 = new Course("TIC", "3");
		courses2Select.add(0, course3);
		Course temp = (Course) courses2Select.get(0);
		System.out.println(temp.getId() + ":" + temp.getName());
		
		/**
		 * 几点说明:
		 * 1. 利用数组批量添加元素到数组;
		 * 2. Arrays.asList(arr); 方法将数组转换为集合
		 */
		Course[] cur1 = new Course[]{new Course("高等数学","4"),new Course("大学英语","5")};
		courses2Select.addAll(Arrays.asList(cur1));
		Course temp4 = (Course) courses2Select.get(3);
		Course temp5 = (Course) courses2Select.get(4);
		System.out.println(temp4.getId() + ":" + temp4.getName());
		System.out.println(temp5.getId() + ":" + temp5.getName());
		
		Course [] cur2 = new Course[] {new Course("网络基础","6"),new Course("开源导论","7")};
		courses2Select.addAll(2, Arrays.asList(cur2));
		Course temp6 = (Course) courses2Select.get(2);
		Course temp7 = (Course) courses2Select.get(3);
		System.out.println(temp6.getId() + ":" + temp7.getName());
		System.out.println(temp7.getId() + ":" + temp7.getName());

	}
	/**
	 * 遍历集合元素的方法: 
	 * 1. for 循环直接遍历;
	 * 2. Iterator 迭代器遍历;
	 * 3. for each 遍历;
	 * 4. 通过 Lambda 表达式遍历;
	 * 5. 通过 Iteator 的 Lambda 表达式;(少用)
	 */
	public void testGetBySize() {
		System.out.println("--------通过 for 循环取得集合元素------");
		int length = courses2Select.size();
		for(int i = 0 ; i<length;i++) {
			Course temp = (Course)courses2Select.get(i);
			System.out.println(temp.getId()+" @ "+temp.getName());
		}
	}
	public void testGetByIterator() {
		System.out.println("--------通过 Iterator 迭代器取得集合元素------");
		Iterator<Course> it = courses2Select.iterator() ;
		while(it.hasNext()) {
			Course temp = it.next();
			System.out.println(temp.getId()+" @ "+temp.getName());
		}
	}
	public void testGetByForeach() {
		System.out.println("--------通过 foreach 取得集合元素------");
		for(Course cur: courses2Select) {
//			Course temp = (Course)obj;
			System.out.println(cur.getId()+" @ "+cur.getName());
		}
	}
	public void testGetByLambda() {
		System.out.println("--------通过 Lambda 表达式器取得集合元素------");
		/**
		 * 这里 Lambda 表达式中, obj 作为集合元素, 直接传入
		 * sout 方法中, 打印出来是 className@Hex HashCode 的形式
		 * 因为要打印的是 Course 类的 Name 和 Int 属性, 
		 * 因此, 只需要重写 Course 的 toString 方法就行了
		 * 
		 * o(╯□╰)o list 重写方法好像有点难...
		 */
		courses2Select.forEach(obj -> System.out.println(obj));
	}
	/**
	 * 修改集合中的元素的方法 testSet()
	 * 
	 * 利用 set(index,element) 方法指定 index 处的元素, 将其替换为 element 
	 */
	public void testSet() {
		courses2Select.set(2, new Course("ubuntu系统管理员手册","8"));
	}
	/**
	 * 删除集合中的元素, remove(object) 或者 remove(index)
	 */
	public void testRemove() {
		courses2Select.remove(1);
//		courses2Select.remove(courses2Select.get(1));
	}
	
	public static void main(String[] args) {
		TestList lt1 = new TestList();
		lt1.testAdd();
		lt1.testGetBySize();
		lt1.testGetByIterator();
		lt1.testGetByForeach();
		lt1.testGetByLambda();
		lt1.testSet();
		lt1.testGetByLambda();
		lt1.testRemove();
		lt1.testGetByLambda();
	}
}
