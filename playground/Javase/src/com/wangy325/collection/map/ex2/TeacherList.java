package com.wangy325.collection.map.ex2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TeacherList {

	List<Teacher> teachers;

	public TeacherList() {
		teachers = new ArrayList<Teacher>();
	}

	// 初始化老师信息
	public void iniTeachers() {
		teachers.add(new Teacher("1", "Tom"));
		teachers.add(new Teacher("2", "John"));
		teachers.add(new Teacher("3", "Susan"));
		teachers.add(new Teacher("4", "Jerry"));
		teachers.add(new Teacher("5", "Jim"));
		teachers.add(new Teacher("6", "Kevin"));
		teachers.add(new Teacher("7", "Lucy"));
	}

	// 将老师的选课信息 保存到老师的 teacherCourse 属性中
	public void teacherCourseInfo() {
		iniTeachers();
		CourseList cls = new CourseList();
		cls.IniCourses();

		teachers.get(0).setTeacherCourse(cls.courses.get(0));
		teachers.get(1).setTeacherCourse(cls.courses.get(1));
		teachers.get(2).setTeacherCourse(cls.courses.get(1));
		teachers.get(3).setTeacherCourse(cls.courses.get(2));
		teachers.get(4).setTeacherCourse(cls.courses.get(3));
		teachers.get(5).setTeacherCourse(cls.courses.get(4));
		teachers.get(6).setTeacherCourse(cls.courses.get(4));

	}

	// 判断输入ID是否存在对应老师的方法:
	public boolean isTeacherThere(String id) {
		// 调用方法之前已经初始化了..
		iniTeachers();
		for (Teacher teacher : teachers) {
			if (id.equals(teacher.getId()))
				return true;
		}
		return false;
	}

	// 添加新老师 并且为老师选课 返回一个老师选课的映射关系
	public Map<Teacher, Course> addTeacher() {
		/**
		 * 1. 输入老师ID, 进行判断
		 * 2. ID 没被占用, 则要求输入老师名字
		 * 3. 将老师信息添加到 teacherList中
		 */

		Scanner console = new Scanner(System.in);
		while (true) {
			System.out.println("请输入要添加的老师的ID:");
			String tid = console.next();
			boolean flag = isTeacherThere(tid);
			if (flag) {
				System.out.println("该ID已经被占用!请重新输入..");
				// break;
			} else {
				System.out.println("请输入老师姓名:");
				String tname = console.next();
				teachers.add(new Teacher(tid, tname));
				// 为老师选课
				System.out.println("请为老师 " + tname + " 选择课程:");
				System.out.println("有如下课程备选:");
				CourseList cs = new CourseList();
				cs.IniCourses();
				cs.showCoursesInfo();
				boolean flag2 = true;
				while (flag2) {
					System.out.println("请输入课程ID:");
					String csid = console.next();
					for (Course course : cs.courses) {
						if (csid.equals(course.getId())) {
							// 存在对应课程, 将其添加到老师的属性中
							teachers.get(teachers.size() - 1).setTeacherCourse(course);
							System.out.println("老师" + tname + "选择了课程" + course.getName());
							TestMap testMap = new TestMap();
							testMap.iniCourseMap();
							testMap.courseMap.put(teachers.get(teachers.size() - 1), course);
							// testMap.testPrintMap();
							flag2 = false;
							console.close();
							return testMap.courseMap;
						} else {
							continue;
						}
					}
				}
			}
		}
	}

	// 修改已存在的老师映射信息
	public Map<Teacher, Course> modifySelection() {
		/**
		 * 1. 输入老师ID进行判断
		 * 2. 存在老师, 则获取老师的选课信息
		 * 3. 输入课程ID 
		 * 		1. 课程存在且和原课程Id 相等, 则重新选择
		 * 		2. 新课程代号
		 * 			则remove 原来的课程信息, 然后添加新的课程信息
		 */
		teacherCourseInfo();
		Scanner console = new Scanner(System.in);
		while (true) {
			System.out.println("请输入要修改教授课程的老师ID:");
			String tid = console.next();
			// 判断老师是否存在
			boolean flag = isTeacherThere(tid);
			if (flag) {
				String name = "";
				int index = Integer.parseInt(tid) - 1;
				String courseName = "";
				String courseId = "";
				// 通过id拿到老师的名字和课程信息
				for (Teacher teacher : teachers) {
					if (tid.equals(teacher.getId())) {
						name = teacher.getName();
						// indexOf = teachers.indexOf(); // -1
						courseName = teachers.get(index).getTeacherCourse().getName();
						courseId = teachers.get(index).getTeacherCourse().getId();
						// System.out.println("..." + tid + index + courseId + courseName);
					}
				}
				System.out.println("老师 " + name + "已经选择了课程" + courseName + ", 请输入新的课程ID:");
				// 没有清除老师的选课信息
				System.out.println("有如下课程备选:");
				CourseList cs = new CourseList();
				cs.IniCourses();
				cs.showCoursesInfo();
				boolean flag2 = true;
				while (flag2) {
					System.out.println("请输入课程ID:");
					String csid = console.next();
					for (Course course : cs.courses) {
						if (csid.equals(course.getId()) && !(csid.equals(courseId))) {
							// 课程Id 有效且不是老师的已选课程
							// remove 掉老师的选课信息
							teachers.get(index).setTeacherCourse(course);
							System.out.println("老师" + name + "重新选择了课程" + course.getName());
							TestMap testMap = new TestMap();
							testMap.iniCourseMap();
							// 移除之前的键值对, 但是为什么会失败呢?
							testMap.courseMap.remove(teachers.get(index));
							testMap.courseMap.put(teachers.get(index), course);
							// testMap.testPrintMap();
							flag2 = false;
							console.close();
							return testMap.courseMap;
						} else {
							continue;
						}
					}
				}
			} else
				System.out.println("不存在对应老师,请重新输入!..");
		}
	}

	// 输出老师信息
	public void showTeacherInfo() {
		for (Teacher te : teachers) {
			System.out.println("老师ID: " + te.getId() + ", 老师名字:" + te.getName());
		}
	}
}
