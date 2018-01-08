package com.wangy325.collection.imooc;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class TestMap {

	public Map<String, Student> students;
	Scanner console;

	public TestMap() {
		this.students = new HashMap<String, Student>();
		this.console = new Scanner(System.in);
	}

	/**
	 * 输入学生ID, 判断ID是否被占用;
	 * 若没有被占用, 则提示输入学生姓名,
	 * 并利用 put(key, value) 方法创建学生信息
	 */
	public void testPut() {
		int i = 0;
		while (i < 3) {
			System.out.println("请输入学生ID:");
			String sId = console.next();
			// 获取 Map 中 key 值的 value 用get(Object key) 方法
			Student st = students.get(sId);
			if (st == null) {
				System.out.println("请输入学生姓名:");
				String sName = console.next();
				Student student = new Student(sId, sName);
				/**
				 * put (key,value) 方法将键值对添加到 Map 中
				 */
				students.put(sId, student);
				System.out.println("成功添加学生" + students.get(sId).getName());
				i++;
			} else {
				System.out.println("该学生ID已被占用!");
				continue;
			}
		}
		// 这里关闭 Scanner 会导致下面的方法运行出错!
		// console.close();
	}

	/**
	 * 测试Map的 keySet() 方法:
	 * 返回所有"键"的类型的集合
	 * 并利用 键 的集合来遍历 Map 中的元素
	 */
	public void testKeySet() {
		// key 值不可重复, 用 Set 集合接收 keySet 方法的返回值
		Set<String> keySet = students.keySet();
		System.out.println("总共添加了" + students.size() + "个学生");
		for (String ks : keySet) {
			Student st = students.get(ks);
			if (st != null)
				System.out.println(st.getName() + " @ID= " + st.getId());
		}
	}

	/**
	 * 删除 Map 中的学生信息
	 * @param args
	 */
	public void testRmElementOfMap() {
		while (true) {
			System.out.println("请输入要删除的学生的ID:");
			String id = console.next();
			Student st = students.get(id);
			if (st == null) {
				System.out.println("该ID的学生不存在");
			} else {
				students.remove(id);
				System.out.println("成功删除学生" + st.getName());
				break;
			}
		}
		// console.close();

	}

	/**
	 * 通过 EntrySet() 方法返回 Map 键值对的集合
	 * 来遍历 Map 中的元素
	 * @param args
	 */
	public void testEntrySet() {
		Set<Entry<String, Student>> entrySet = students.entrySet();
		for (Entry<String, Student> es : entrySet) {
			System.out.println("key@ " + es.getKey() + "---->" + "value@ " + es.getValue().getName());
		}
	}

	/**
	 * 利用 put(key value) 方法修改 Map 中的已有映射
	 * @param args
	 */
	public void testModifyMap() {
		System.out.println("请输入要修改的学生ID:");
		while (true) {
			String sid = console.next();
			Student st = students.get(sid);
			if (st == null) {
				System.out.println("该id不存在映射关系,请重新输入:");
				continue;
			} else {
				System.out.println("请输入新的学生姓名以替换旧名字 " + st.getName());
				String sname = console.next();
				Student newStudent = new Student(sid, sname);
				students.put(sid, newStudent);
				System.out.println("修改成功...");
				break;
			}
		}
	}

	/**
	 * 利用 containsKey(Object key) 方法判断 Map 集合中是否存在 指定学生的键值对
	 * 1. 输入一个key值 判断 该key值是否存在对应的 value值
	 * 2. 如果存在, 则判断value 是否为空,
	 * 3. 要清楚 对象为空 和对象属性为空的情况
	 */
	public void testMapContainsKey() {
		System.out.println("请输入一个Key值(学生id)");
		while (true) {
			String sid = console.next();
			if (students.containsKey(sid)) {
				Student stu = students.get(sid);
				if (stu == null) {
					System.out.println("该 Key 值不存在对应的映射关系(对象为空)..");
					break;
				}
				if (stu.getName() == null) {
					System.out.println("该 Key 值的映射对象的属性为 null..");
				} else {
					System.out.println("key值 "+sid + " 对应的学生为 " + stu.getName());
				}
				break;
			} else
				System.out.println("输入的Key值不存在..请重新输入");
		}
	}
	/**
	 * 利用 contains(Object value) 方法 判断 Map 中是都存在指定的键值对
	 * 1. 输入学生姓名, 判断该名称 组成的 "value" 值 是否存在
	 * 2. 由于只用 student 的 name 属性判断是否存在该学生, 
	 * 	  如果不重写 比较规则 (equals() 方法) 的话, containsValue() 
	 *    的返回值必然是 false
	 * 3. 重写 Student 类的 equals 方法, 只比较 name 属性
	 * 
	 * @param args
	 */
	public void testMapContainsValue() {
		System.out.println("请输入待判断的学生姓名");
		String name = console.next();
		Student student = new Student(null,name);
		if(students.containsValue(student)) {
			// 如何通过 value 值获得 key 值呢?
			System.out.println("映射表中存在该学生 "+name);
		}
		else {
			System.out.println("该学生不存在于名单中...");
		}
		
	}
	public static void main(String[] args) {
		TestMap tm = new TestMap();
		tm.testPut();
		// tm.testKeySet();
		// tm.testRmElementOfMap();
		// tm.testEntrySet();
		// tm.testModifyMap();
		// tm.testEntrySet();
		 Student student = new Student(null,null);
		tm.students.put("4", student);
		tm.testKeySet();

		tm.testMapContainsKey();
		tm.testMapContainsValue();
	}

}
