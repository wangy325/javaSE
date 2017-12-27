package com.wangy325.imooc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TestSet {

	List<Course> courses2Select;
	Scanner console;

	// private Student student;
	// constructor
	public TestSet() {
		this.courses2Select = new ArrayList<Course>();
		this.console = new Scanner(System.in);
	}

	/**
	 * 初始化课程信息
	 */
	public void testAddCourse() {
		Course course1 = new Course("数据结构", "1");
		courses2Select.add(course1);
		Course course2 = new Course("算法导论", "2");
		courses2Select.add(course2);
		Course course3 = new Course("TIC", "3");
		courses2Select.add(0, course3);
		Course[] cur1 = new Course[] { new Course("高等数学", "4"), new Course("大学英语", "5") };
		courses2Select.addAll(Arrays.asList(cur1));

		Course[] cur2 = new Course[] { new Course("网络基础", "6"), new Course("开源导论", "7") };
		courses2Select.addAll(2, Arrays.asList(cur2));
	}

	/**
	 * 利用 contains(Object) 方法判断 List 集合中 是否存在指定元素
	 * 指定课程是否在初始化的备选课程中
	 * 1. 要求从控制台输入课程名字
	 * 2. 如果课程名字相等, 则认为 该课程已经存在于备选课程名单中
	 * 3. 否则,课程不在备选课程中
	 * 
	 * * 说明, contains(Object) 方法的内涵就是 遍历比较参数 和集合元素是否
	 * * 逻辑相等, 这里调用的就是 equals 方法
	 * * 如果想自定义比较规则, 就要重写 equals 方法
	 * 
	 * *list.com.wangy325.Ex3 中就简单地重写了 Worker 类的 equals 方法
	 */
	public void testContains() {
		// 要求输入一个课程
		System.out.println("请输入课程名字以判断其是否在备选课程中:");
		String cName = console.next();
		Course course = new Course();
		course.setName(cName);
		System.out.println("备选课程中是否包含 " + cName + " :" + (courses2Select.contains(course) ? "是" : "否"));
	}

	/**
	 * 打印课程信息
	 */
	public void testGetCourseByForeach() {
		System.out.println("--------通过 foreach 取得集合元素------");
		for (Course cur : courses2Select) {
			System.out.println(cur.getId() + " @ " + cur.getName());
		}
	}

	/**
	 * 学生选课
	 * @param args
	 */
	public void testSelectCourses(Student student) {
		System.out.println("请输入学生ID: ");
		String sId = console.next();
		// 如果与 id 对应的学生存在, 添加对应的课程到学生
		if (sId.equals(student.getId())) {
			System.out.println("欢迎" + student.getName() + "来选课!");
			int i = 0;
			while (i < 3) {
				System.out.println("请选择第" + (i + 1) + "门课程:");
				String sCur = console.next();
				for (Course crs : courses2Select) {
					// int CourseId = Integer.parseInt(crs.getId());
					if (sCur.equals(crs.getId())) {
						student.getCourses().add(crs);
						// Set 集合中不能存在相同的元素
						// student.Courses.add(crs);
						i++;
						break;
					} else {
						// System.out.println("所选课程不存在!请重新选择");
						continue;
					}
				}
			}
			printSelectionCourse(student);
		} else {
			System.out.println("学生不存在");
			return;
		}
	}

	/**
	 * 打印学生的选课信息
	 * @param args
	 */
	public void printSelectionCourse(Student student) {
		System.out.println("选择了课程:");
		for (Course cr : student.getCourses()) {
			System.out.println(cr.getId() + ":" + cr.getName());
		}
	}

	/**
	 * 写一个方法, 判断学生所选课程中是否存在指定课程
	 * 因为学生所选课程存放在 Set 集合中, 
	 * 而判断 Set 集合中是否存在元素 contains 方法 
	 * 需要重写 equals 和 hashCode 方法
	 */
	public void testContainSet(Student student) {
		System.out.println("请输入课程名字以判断学生是否选择该课程:");
		String courseName = console.next();
		Course course = new Course();
		course.setName(courseName);
		System.out.println("学生" + student.getName() + "是否选择了" + course.getName() + "?"
				+ (student.getCourses().contains(course) ? "是" : "否"));
	}

	public static void main(String[] args) {
		TestSet ts = new TestSet();
		ts.testAddCourse();
		ts.testGetCourseByForeach();
		Student student = new Student("1", "tony");
		ts.testSelectCourses(student);
		ts.testContains();
		ts.testContainSet(student);
	}

}
