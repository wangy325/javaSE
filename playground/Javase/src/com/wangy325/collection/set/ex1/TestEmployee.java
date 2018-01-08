package com.wangy325.collection.set.ex1;

import java.util.HashSet;
import java.util.Set;

public class TestEmployee {
	Set<Employee> setEmployee;

	public TestEmployee() {
		this.setEmployee = new HashSet<Employee>();
	}

	/**
	 * 添加 Employee 对象到HashSet 中
	 * 初始化一个 Set 集合
	 */
	public void testInitializeSet() {
		Employee e1 = new Employee("jack", "18", "1500");
		setEmployee.add(e1);
		Employee e2 = new Employee("Mike", "18", "1600");
		setEmployee.add(e2);
		Employee e3 = new Employee("Marry", "17", "2000");
		setEmployee.add(e3);
		Employee e4 = new Employee(null, null, null);
		setEmployee.add(e4);
	}

	/**
	 * 试图添加新 Employee 元素到 HashSet 中
	 * 规定: 如果对象的姓名和年龄字段相同, 则认为添加的是重复对象
	 * 1. 先写一个判断是否存在该对象的方法 testContains(Employee)
	 * 2. 再写一个添加元素的方法 testAddElement2Set(Employee)
	 * 
	 * * 判断 Set 集合中元素是否相等 要重写 hashCode 和equals 方法!
	 * @param args
	 */
/*	public boolean testContains(Employee e) {

		if (e.getName() == null) {
			System.out.println("别这样...");
			return true;
		}
		for (Employee em : setEmployee) {
			if (e.getName().equals(em.getName()) && e.getAge().equals(em.getAge()))
				return true;
		}
		return false;
	}*/

	public void testAddElement2Set(Employee e) {
		if (setEmployee.contains(e))
			System.out.println("testAddElement2Set:"+e.getName() +" : "+ "该员工信息已经存在!");
		else
			setEmployee.add(e);
	}

	/**
	 * 打印员工信息
	 * @param args
	 */
	public void testShowEmployee() {
		for (Employee e : setEmployee) {
			System.out.println(e.getName() + "," + e.getAge() + "," + e.getSalary());
		}
		System.out.println("-----------------");
	}

	public static void main(String[] args) {
		TestEmployee te = new TestEmployee();
		te.testInitializeSet();
		te.testShowEmployee();
		Employee employee = new Employee("jack", "18", "6700");
		te.testAddElement2Set(employee);
		te.testShowEmployee();
		Employee employee2 = new Employee(null, null, null);
		te.testAddElement2Set(employee2);
		te.testShowEmployee();

	}

}
