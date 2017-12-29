package com.wangy325.compare;

import java.util.Comparator;

/**
 * 
 * @author wangy325
 *
 * @date Dec 29, 2017  10:21:39 AM
 *
 * @decription 一个实现 Comparable 接口的类  
 * 
 */

public class Employee implements Comparable<Employee>, Comparator<Employee>{
	
	private String name;
	private int age;
	private int sal;
	

	public Employee() {
		super();
	}
	
	public Employee(String name, int age, int sal) {
		super();
		this.name = name;
		this.age = age;
		this.sal = sal;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	
	

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", sal=" + sal + "]";
	}

	@Override
	// 实现Comparable 接口需要实现的方法
	public int compareTo(Employee e) {
		/**
		 * 1. 按照年龄大小进行排序
		 * 2. 如果年龄相同, 按照工资多少进行排序
		 */
		if(age > e.age)
			return 1;
		if(age < e.age)
			return -1;
		if(sal > e.sal)
			return 1;
		if(sal < e.sal)
			return -1;
		return 0;
	}

	@Override
	// 实现 Comparator 接口需要实现的方法
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



}
