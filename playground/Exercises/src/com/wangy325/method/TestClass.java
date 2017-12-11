/**
 * 
 */
package com.wangy325.method;
/**
 * @author wangy325
 *
 * @date Dec 7, 2017  8:51:40 PM
 *
 * @decription  
 * 
 * @target TODO
 */
public class TestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student stu0 = new Student("james",18,'m');
		Class class302 = new Class();
		/*for(int i = 1; i< class302.stus.length; i++) {
			class302.addStudent(stus);
			if(i == 5) {
				break;
			}
		}*/
		
		class302.addStudent("king");
		class302.addStudent("allen",27);
		class302.printAllStudentInfo();
		System.out.println("-------------------");
		class302.updateStudent(stu0, "allen");
		class302.printAllStudentInfo();
		System.out.println("-------------------");
		stu0.changeName("harden");
		class302.printAllStudentInfo();
		
	}
}

///:~
//已经建立了学生索引...
//已经建立了学生索引...
//students info are:
//name: king	age: 0	gender: 
//name: allen	age: 27	gender: 
//-------------------
//students info are:
//name: king	age: 0	gender: 
//name: james	age: 18	gender: m
//-------------------
//students info are:
//name: king	age: 0	gender: 
//name: harden	age: 18	gender: m
	