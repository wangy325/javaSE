/**
 * 
 */
package com.wangy325.workbook1.q8p;

/**
 * @author scott
 * @date 2017年12月7日下午5:33:46
 * @version 
 * @description 
 */
public class Client {

	public static void main(String[] args) {
		
		//创建对象
		ClassJava06 classJava06 = new ClassJava06();
		
		//添加3个学生
		classJava06.addStudent("马化腾");
		
		Student stu = new Student("雷军", 46, 'n');
		
		classJava06.addStudent(stu);
		
		classJava06.addStudent("乔峰", 40);

		System.out.println("**********************");
		
		classJava06.printAllStuInfo();
		System.out.println("***************修改*****************");
		
		Student student = new Student("史玉柱", 50, 'n');
		
		classJava06.updateStudent(student, "乔峰");
		
		classJava06.printAllStuInfo();
		
	}
}
