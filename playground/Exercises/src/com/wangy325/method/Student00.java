/**
 * 
 */
package com.wangy325.method;

/**
 * @author wangy325
 *
 * @date Dec 7, 2017 7:16:22 PM
 *
 * @decription 创建一个学生类, 讨论[static 关键字]在静态成员变量上的影响
 * 
 *             如果类含有静态成员变量属性. 在构建多个对象的情况下, 即使利用 非静态方法[假装]对 对象静态属性分别进行了初始化
 * 
 *             但是,静态属性值并不能被当作对象属性, 因为它会带来麻烦
 *             
 *             [静态属性] 通过 [类名.静态属性] 这样的方式来访问
 * 
 *             且不说, [对象.静态属性] 这样的写法会报警告
 * 
 *             [对象.静态属性]的返回值, 都是[类.静态属性] 初始化的值(或在方法类二次初始化的值, 前面已经讨论过,
 *             引用类型在调用方法的时候,参数传递的形式)
 * 
 *             可以理解为,静态成员变量的值,是[死]的, 它不会随实例化对象多少而增加属性值
 *             
 *             这可能与静态成员变量存储的位置有关吧
 * 
 * @target TODO
 */
public class Student00 {
	String id, name, gender;
	static String address;

	public Student00(String id, String name, String gender) {
		this.id = id;
		this.name = name;
		this.gender = gender;
	}

	public void show() {
		System.out.println("id: " + this.id + "\t\tname: " + this.name + "\tgender: " + this.gender);
	}

	public  void showAddress(String address) {
		// 类名访问静态属性 进行二次[初始化]
		Student00.address = address;
		System.out.println("方法内打印: student's address is:" + Student00.address);
	}

	public static void main(String[] args) {
		Student00 student1 = new Student00("001", "allen", "male");
		Student00 student2 = new Student00("002", "ball", "male");
		System.out.println("student's info:");
		student1.show();
		System.out.println(
				"main 内打印: id: " + student1.id + "\t\tname: " + student1.name + "\tgender: " + student1.gender);
		student2.show();
		System.out.println(
				"main 内打印: id: " + student2.id + "\t\tname: " + student2.name + "\tgender: " + student2.gender);
		// 初始化静态成员变量值
		Student00.address = "beijing";
		// 打印初始化的值
		System.out.println("初始化的静态成员属性值为:" + Student00.address);
		// 调用 showAddress 方法
		student1.showAddress("tokyo");
		student2.showAddress("oykot");
		// 下面的打印信息,分别写成 student1.address 和 student2.address 得到的结果是一样的 而且会得到两份 static 警告
		System.out.println("调用方法后的静态成员属性为:" + Student00.address);

	}
}
/// :~
/*
 *  student's info:
 *  id: 001 name: allen gender: male 
 *  main 内打印: id: 001 name:allen gender: male 
 *  id: 002 name: ball gender: male 
 *  main 内打印: id: 002 name:ball gender: male 
 *  初始化的静态成员属性值为:beijing 
 *  方法内打印: student's address is:tokyo
 *  方法内打印: student's address is:oykot 
 *  调用方法后的静态成员属性为:oykot
 */
