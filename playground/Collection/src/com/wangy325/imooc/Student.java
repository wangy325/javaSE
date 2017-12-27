package com.wangy325.imooc;

import java.util.HashSet;
import java.util.Set;

public class Student {
	private String id;
	private String name;
	// 利用 Set 存放学生的课程信息 是因为学生的选课不能重复
	private Set<Course> Courses;

	public Student(String id, String name) {
		super();
		this.id = id;
		this.name = name;
		// 初始化课程信息, Set 接口的初始化方式
		this.Courses = new HashSet<Course>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Course> getCourses() {
		return Courses;
	}

	public void setCourses(Set<Course> courses) {
		Courses = courses;
	}

	/**
	 * 以下系 eclipse 自动生成的 重写 equals 和 hasdCode 方法的代码
	 */
	/**
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Student))
			return false;
		Student other = (Student) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	*/

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Student))
			return false;
		Student stu = (Student) obj;
		if (name == null) {
			if (stu.name == null)
				return true;
		} else if (name.equals(stu.name))
			return true;

		return false;
	}

}
