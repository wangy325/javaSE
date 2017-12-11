/**
 * 
 */
package com.xyd.lecture;

/**
 * @author scott
 * @date 2017年12月7日下午5:18:44
 * @version
 * @description
 */
public class ClassJava06 {

	Student[] stus = new Student[40];

	public ClassJava06() {
	}

	/**
	 * 把 学生 添加到 数组中
	 */
	public void addStudent(Student stu) {

		// stus[0] = stu;

		for (int i = 0; i < stus.length; i++) {

			// 判断
			if (stus[i] == null) {

				stus[i] = stu;
				// 添加完毕以后要 break 防止后面的空位置 都添加了同一学生
				break;

			}
			System.out.println("学生添加成功...");
		}
	}

	/**
	 * 添加学生信息，只有名字
	 */
	public void addStudent(String name) {

		Student stu = new Student(name);
		this.addStudent(stu);

	}

	/*
	 * 添加学生信息，只有名字和年龄
	 */
	public void addStudent(String name, int age) {

		Student stu = new Student(name, age);
		this.addStudent(stu);
	}

	/**
	 * 修改学生的 内容
	 */
	public void updateStudent(Student stu,String name) {

		int index = selectforName(name);
		if (index != -1) {
			
			// 用 stu 覆盖  之前的 那个 学生 
			stus[index] = stu;
		}else {
			System.out.println("学生不存在 ...");
		}
	}
	
	/**
	 * 通过名字 找到  对应的 学生 在数组中下标的位置
	 */
	private int selectforName(String name) {

		for (int i = 0; i < stus.length; i++) {
			
			//学生不能为空
			if (stus[i] != null) {
				
				//找到  学生的 名字 和name一样   字符串  是否内容一样要用equals 来判断
				if (stus[i].name.equals(name)) {
					
					return i;
				}
			}
		}
		//学生不存在 
		return -1;
	}

	/**
	 * 打印所有的学生信息
	 */
	public void printAllStuInfo() {

		for (int i = 0; i < stus.length; i++) {

			// 拿到每个学生
			Student stu = stus[i];

			if (stu != null) {
				stu.showInfo();
			}

		}

	}

}
