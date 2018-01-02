package com.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Student implements Comparable<Student> {

	private String name;
	private int age, score;

	public Student() {
	}

	public Student(String name, int age, int score) {
		super();
		this.name = name;
		this.age = age;
		this.score = score;
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

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	// 获取随机年龄
	public static int generateAge() {
		Random randomAge = new Random();
		int age = randomAge.nextInt(13) + 18;
		return age;
	}

	public static void main(String[] args) {
		List<Student> sal = new ArrayList<Student>();
		sal.add(new Student("allen", generateAge(), 87));
		sal.add(new Student("bob", generateAge(), 76));
		sal.add(new Student("cris", generateAge(), 91));
		sal.add(new Student("david", generateAge(), 83));
		sal.add(new Student("ella", generateAge(), 92));

		Collections.sort(sal);

		for (Student stu : sal) {
			System.out.println(stu);
		}
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", score=" + score + "]";
	}

	@Override
	public int compareTo(Student o) {

		if (score > o.score)
			return -1;
		if (score < o.score)
			return 1;
		if (age > o.age)
			return -1;
		if (age < o.age)
			return 1;
		return 0;
	}

}
