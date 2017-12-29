/**
 * 
 */
package com.wangy325.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author wangy325
 *
 * @date Dec 29, 2017  10:14:47 AM
 *
 * @decription  Comparator<T> 接口
 * 				1. 强行对某个对象 collection 进行 整体排序] 的比较函数, 可以将 Comparator 传递给
 * 				 sort 方法, (如 Collections.sort 或 Arrays.sort)
 * 				2. 某个类实现了 Comparator 接口, 并且重写了此接口的 compare(T o1, T o2) 方法
 * 				便可实现排序
 * 				3. 排序规则和 Comparable 相同
 */
public class TestComparator  {

	List<Employee> eList;
	TreeSet<Employee> etc ;
	TreeMap<Employee, String> etm;
	
	public TestComparator() {
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
		/**
		 * public static <T> void sort(List<T> list, Comparator<? super T> c) {
         *    list.sort(c);
         *  }
         *  1. 这里 Employee 实现了 Comparator 接口, 并且
         *     重写了 compare() 方法 
         *  2. 所以这里的 [比较器] 直接 写了 new Employee();
         *  3. 如果要调用外部比较器 Comparator, 建议单独写一个比较器类
         *     然后重写 compare 方法自定义比较规则, 然后如下所示,
         *     调用 Collections.sort()方法
		 */
		Collections.sort(eList, new Employee());
		
		/**
		 * 以下是匿名内部类的写法
		 */
		Collections.sort(eList, new Comparator<Employee>() {
			// 开始
			@Override
			public int compare(Employee e, Employee f) {
				if( e.getAge()> f.getAge())
					return -1;
				if(e.getAge() < f.getAge())
					return 1;
				if(e.getSal() > f.getSal())
					return -1;
				if(e.getSal() < f.getSal())
					return 1;
				return 0;
			}
			// 结束
		});
		for(Employee e : eList) {
			System.out.println(e);
		}
		System.out.println("----------------");
		
	}
	
	// 利用TreeSet 进行排序
	public void sortTreeSet() {
		etc = new TreeSet<Employee>(new Employee());
		etc.add(new Employee("alen",23,5500));
		etc.add(new Employee("tom",22,4600));
		etc.add(new Employee("mark",23,4800));
		etc.add(new Employee("alx",24,4500));
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
		etm = new TreeMap<Employee,String>(new Employee());
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
		TestComparator tc = new TestComparator();
		tc.sortList();
		tc.sortTreeSet();
		tc.sortTreeMapbyKeySet();
	}

	

}
