package com.wangy325.oop;
/**
 * 
 * @author wangy325
 *
 * @date Dec 6, 2017  1:46:29 PM
 *
 * @decription  构造器和对象初始化,this关键字
 * 
 * @target TODO
 */

public class Student { // 类①

	// 定义属性
	String ID;
	int Sex; // 0 for male; 1 for female;
	String Name;

	// 空构造器
	public Student() {

	}

	// 含参数构造器1
	public Student(String name, String id, int sex) {
		// this 关键字, 访问 本类成员的属性(前提是类中先声明属性)
		this.Name = name;
		this.ID = id;
		this.Sex = sex;
		// 上述三行代码指明了类的实例(对象)属性和参数的对应关系,但是并没初始化,初始化在调用构造器时完成

		// 需要说明的是,也可以在构造器内直接初始化对象的属性
		/**
		 * this.Name = "Ray"; this.ID = "007"; this.Sex = 0
		 */
		// 但是!!!这样做之后,类中[所有对象]的属性值就这样被设置了...
		// 再也就没有[调用构造器]什么卵事了
		System.out.println("name:" + this.Name + "\tid:" + this.ID + "\tgender:" + (this.Sex == 1 ? "female" : "male"));

		// 如果没有类① 中没有声明类的属性,同样可以利用构造器初始化对象
		/**
		 * public Student(String name, int id, int sex){
		 * System.out.println("name:"+name+"\tid"+id+"\tgender"+sex); }
		 */
	}
	
//	含参构造器2
	public Student(String name, int sex) {
		System.out.println("name:"+name+"\tgender:"+(sex==0?"male":"female"));
		
	}
/**
 * @date 12.09 10:24
 * @author wangy325
 * @param stu
 * @return
 */
	public static int testConstructor(Student stu) {
		if (stu.Name == null || stu.ID == null) {
			System.out.print("对象初始化不完整...");
			return -1;
		}
		System.out.print("对象初始化完整...");
		return 0;
	}
	public static void main(String[] args) {
		// 创建对象
		// 调用构造器,将参数传给构造器, 可以初始化对象属性
		Student student0 = new Student("HanMeiMei", "001", 1);
		Student student1 = new Student("LiLei", "002", 9);
		System.out.println("------------分割线①----------");
		Student student2 = new Student("XiaBing",0);
		
		System.out.println(testConstructor(student0));
		System.out.println(testConstructor(student1));
		System.out.println(testConstructor(student2));
	}
}
