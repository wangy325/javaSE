/**
 * 
 */
package com.wangy325.collection.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author wangy325
 *
 * @date Dec 29, 2017  9:53:07 AM
 *
 * @decription  Comparable <T> 接口 
 * 				1. 此接口强行对 [实现它] 的每个类的对象进行整体排序. 称作自然排序, 实现该接口的类
 * 				必须实现它的 compareTo<T> 方法
 * 				2. 实现此接口的对象列表(和数组)可以通过 Collections.sort(或者Arrays.sort) 进行
 * 				自动排序
 * 				3. 实现此接口的对象如果是有序映射 [TreeMap] 或者有序集合 [TreeSet] 中的元素, 也
 * 				可用此接口实现排序, 无须指定比较器
 * 				4. 自然排序, 通俗规则是, (e1 > e2) ? 1 :((e1 == e2) ? 0:-1)
 * 					其具体实现方法(究竟是如何判断大小), 得空再研究
 * 				5. 此接口的已知实现类: Integer, String, Date, Long, Character, File... 
 * @target TODO
 */
public class TestComparable {
	List<Employee> eList;
	TreeSet<Employee> etc ;
	TreeMap<Employee, String> etm;
	
	public TestComparable() {
		super();
		this.eList = new ArrayList<Employee>();
		etc = new TreeSet<Employee>();
		etm = new TreeMap<Employee, String>();
	}
	
	// 直接用 List 进行排序
	public void sortList() {
		eList.add(new Employee("alen",23,5500));
		eList.add(new Employee("tom",22,4600));
		eList.add(new Employee("mark",23,4800));
		eList.add(new Employee("alx",24,4500));
		
		Collections.sort(eList);
		for(Employee e : eList) {
			System.out.println(e);
		}
		System.out.println("----------------");
		
	}
	// 利用TreeSet 进行排序
	public void sortTreeSet() {
		etc.add(new Employee("alen",23,5500));
		etc.add(new Employee("tom",22,4600));
		etc.add(new Employee("mark",23,4800));
		etc.add(new Employee("alx",24,4500));
		
//		Collections.sort(etc);
		/**
		 * 需要说明的是, 有序集合 Set 的元素实现了 Comparable 接口
		 * 就意味着, 它已经被排序好了
		 * 无须调用比较器, 直接输出即可
		 */
		for(Employee e : etc) {
			System.out.println(e);
		}
		System.out.println("----------------");
	}
	
	// 利用 TreeMap 中的 KeySet 进行排序
	public void sortTreeMapbyKeySet() {
		etm.put(new Employee("alen",23,5500),"hello");
		etm.put(new Employee("tom",22,4600),"world");
		etm.put(new Employee("mark",23,4800),"of");
		etm.put(new Employee("alx",24,4500),"java");
		
		// 获取 keySet
		/**
		 * 需要说明的是, 这个keySet 是TreeMap 重写的 keySet方法,
		 * 它返回的是一个  --> navigableKeySet() 方法 
		 * TreeSet 实现了这个 navigableKeySet 接口
		 * 所以, 可以认为, TreeMap 的 keySet 方法返回的是有序的Set集合
		 * 代码太复杂了...
		 */
		Set<Employee> ts =   etm.keySet();
		for(Employee e : ts) {
			System.out.println(e);
		}
	}
	
	public static void main(String[] args) {
		TestComparable tc = new TestComparable();
		tc.sortList();
		tc.sortTreeSet();
		tc.sortTreeMapbyKeySet();
		
	}

}
