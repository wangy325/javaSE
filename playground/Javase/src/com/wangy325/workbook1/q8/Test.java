/**
 * 
 */
package com.wangy325.workbook1.q8;

import java.util.Scanner;

/**
 * @author wangy325
 *
 * @date Dec 14, 2017  8:18:07 PM
 *
 * @decription   测试班级类中各种方法的可行性
 * 
 * @target TODO
 */
public class Test {

	public static void main(String[] args) {
		Class927 Class = new Class927();
		// 测试添加学生,name
		Class.addStudent("lily");
		System.out.println(Class.student[0].name);
		Class.printInfo();
		System.out.println("--------");
		// 添加学生信息,name . age
		Class.addStudent("lily", 19);
		// System.out.println(Class.student[0].age);

		Class.addStudent("lucy", 18);
		// Class.printInfo();
		// 添加学生信息,name,age,gender
		// 添加lily 的性别
		Class.student[0].changeGender('f');
		Class.addStudent("lucy", 18, 'f');
		Class.addStudent("alen", 20, 'm');
		Class.addStudent("Fox", 19, 'm');
		Class.printInfo();
		System.out.println("----学生信息操作----");
		Scanner Name = new Scanner(System.in);
		System.out.println("please input student name to revise info:");
		String reviseStu = Name.next();
		System.out.println("please input student name to delete info:");
		String delStu= Name.next();
//		next() 的用法还需要进一步学习
		System.out.println("----revising student info-----");
		Class.updateStudent(reviseStu);
		System.out.println("----deleting student info----");
		Class.delStudent(delStu);
		System.out.println("-------show ultimate student info---------");
		Class.printInfo();
		Name.close();
		
		
		
	}

}
