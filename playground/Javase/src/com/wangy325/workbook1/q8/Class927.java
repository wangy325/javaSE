/**
 * 
 */
package com.wangy325.workbook1.q8;

import java.util.Scanner;

/**
 * @author wangy325
 *
 * @date Dec 14, 2017  7:02:56 PM
 *
 * @decription  
 * 
 * @target TODO
 */
public class Class927 {
	Student[] student = new Student[42];

	Class927() {
	}

	// method
	// 添加?完整?的学生信息
	// 完整的意思是? 和最后冲重载的添加学生的方法不冲突?
	/**
	 *  一个严重的错误, 刚开始的时候写了一个 Class927 (Student stu){} 构造器, 然后
	 *  把 if...break 语句写进了构造器中,  
	 *  后续方法中, 全部写作 new Class927(student);
	 *  运行的时候发生 nullPointException 错误.
	 *  找了半天!
	 *  写进构造器,每次 addStudent(string)的时候呀, 都会新增一个class927实例的啊,难怪..
	 * @param stus
	 */

	void addStudent(Student stus) {
		for (int i = 0; i < student.length; i++) {
			if (student[i] == null) {
				student[i] = stus;
				break; // 这里的break 很重要
			}
		}
	}

	// 添加学生信息,只有名字
	void addStudent(String name) {
		Student stu = new Student(name);
		addStudent(stu);
	}

	// 添加学生信息,有名字和年龄
	void addStudent(String name, int age) {
		Student stu = new Student(name, age);
		int INDEX = findName(name);
		if (INDEX >= 0)
			student[INDEX] = stu;
		else
			addStudent(stu);
	}

	// 添加学生信息, 有名字,年龄和性别
	void addStudent(String name, int age, char gender) {
		Student stu = new Student(name, age, gender);
		int INDEX = findName(name);
		if (INDEX >= 0)
			student[INDEX] = stu;
		else
			addStudent(stu);
	}

	// 如果调用重载方法的时候,学生名字一样, 默认认为是添加一个学生信息,
	// 而不是新增一个学生实例
	// 按照名字找,找到其在 student[] 中的 index
	private int findName(String name) {
		int index = -1;
		for (int i = 0; i < student.length; i++) {
			if (student[i] != null)
				// 比较字符串, 不能用 [==] 这是比较的引用, 而 [equals] 比较的是对象
				if (student[i].name.equals(name))
					index = i;
		}
		return index;
	}

	// 修改学生信息
	// 输入学生姓名,然后选择属性进行修改;
	@SuppressWarnings("resource")
	void updateStudent(String name) {
		int INDEX = findName(name);
		if (INDEX < 0)
			System.out.println("ERR: The Student you want to revise does't exist!");
		else {
			Scanner Choices = new Scanner(System.in);
			System.out.println("Choose info you want to revise(1/2/3/0):");
			System.out.println("1.Change student name;\n2.Change student age;\n3.Change student gender(f/m);\n0.quit;");
			int UC = Choices.nextInt();
			switch (UC) {
			case 0:
				return;
			case 1:
				System.out.println("CHANGE NAME: input new name of " + name + ":");
				Scanner newName = new Scanner(System.in);
				String Name = newName.next();
				// bug:输入 [null] 的时候, 将名字改为 null 了
				// Scanner 接受键盘输入, 输入空格回车无效
				// 判断字符串是否逻辑相等,用equals()
				if ("null".equals(Name)) {
					System.out.println("input illegal, revise failed and quit.");
					return;
				} else
					student[INDEX].changeName(Name);
					System.out.println("revising success.");
				break;
			case 2:
				System.out.println("CHANGE AGE: input new age of " + name + ":");
				Scanner newAge = new Scanner(System.in);
				int Age = newAge.nextInt();
				if (Age == 0) {
					System.out.println("input illegal, revise failed and quit.");
					return;
				} else
					student[INDEX].changeAge(Age);
					System.out.println("revising success.");
				break;
			case 3:
				System.out.println("CHANDE GENDER:input new gender(f/m) of " + name + ":");
				Scanner newGender = new Scanner(System.in);
				String GenderS = newGender.next();
				if ("null".equals(GenderS) || GenderS.equals(" ") || (GenderS.length() > 1)) {
					System.out.println("input illegal, revise failed and quit.");
					return;
				} else if ("f".equals(GenderS) || "m".equals(GenderS)) {
					// 将String转换成char
					char Gender = GenderS.toCharArray()[0];
					student[INDEX].changeGender(Gender);
					System.out.println("revising success.");
				} 
			default:
				break;
			}
			Choices.close();
		}
	}

	// 删除学生 一次只能操作一个学生
	void delStudent(String name) {
		int INDEX = findName(name);
		if (INDEX < 0)
			System.out.println("ERR: The Student you want to clear does't exist!");
		else {
			for (int i = INDEX; i < student.length - 1; i++) {
				if (student[i] != null) // 防止数组 [下标] 越界, 而且 null 元素替换也没有意义
					// 这里有bug,如果数组是 [满] 的, 那么下面的代码会出现 越界 报错
					// 解决办法是 i< student.length-1
					// 然后单独处理最后的一个数组元素
					student[i] = student[i + 1];
			}
		student[student.length - 1] = null;
		System.out.println("deleting student info successful.");
		}
	}

	// 打印学生信息
	void printInfo() {
		System.out.println("Student Info: ");
		for (int i = 0; i < student.length; i++) {
			if (student[i] != null)
				student[i].showInfo();
		}

	}
}
