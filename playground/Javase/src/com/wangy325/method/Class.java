/**
 * 
 */
package com.wangy325.method;


//import java.util.Arrays;

/**
 * @author wangy325
 *
 * @date Dec 6, 2017  7:11:59 PM
 *
 * @decription  尝试用构造器初始化对象,然后建立对象属性的方法
 * 
 * @target TODO
 */
public class Class {
	Student [] stus = new Student[42];
	
//	构造器
	public Class () {

	}
	
//	方法1 添加学生索引
	public void addStudent(Student stu) {
//		stus[i] = stus
		for (int i =0 ; i<stus.length; i++) {
//			防止元素覆盖
			if(stus[i] == null) {
//				调用一次, 添加一个元素后即退出方法
				stus[i] = stu;
				break;
			}
		}
		System.out.println("已经建立了学生索引...");
	}
//	方法2 只添加学生名字
	public void addStudent(String name) {
//		调用Student 里的构造器 创建并初始化stu对象 (只初始化了名字)
//		此句代码本应该在mian写的, 但是为了将初始化的 stu 对象 传递给 stus[],写在了此处
//		能写在此处的前提是: Student(); 构造器的访问权限修饰符是非 [private] 的
//		这里的 Student 构造器的 [name] 参数是 addStudent 传入的那个 [name]; 
		Student stu = new Student(name);
//		调用本类 addStudent 方法1 ,将 stu对象传给 stus[];
		addStudent(stu); // 省略了默认的 [this] 关键字
	}
//	方法3 只添加 名字和年龄
	public void addStudent(String name, int age) {
		Student stu = new Student(name, age);
		addStudent(stu);
	}
//	方法4 添加所有信息
	public void addStudent(String name, int age, char gender) {
		Student stu = new Student(name, age, gender);
		addStudent(stu);
	}
//	方法5 更新学生信息
	public void updateStudent(Student stu, String name) {
//		更新属性信息, 合并重复信息 若addStudent 方法传入俩个一样的 name 字段 则将其合并
		// 方法内调用方法 参数 [name] 即是 updateStudent 的第二个参数 
		int index = stuIndex(name);
		if(index != -1) {
//			将已存入的stus[i].name 属性值和传入参数 [name] 一致的学生信息替换为新传入的参数 [stu] 学生对象信息
//			此功能完全覆盖了以前的学生信息, 如果也等于更新了[同名]学生信息
			stus[index] = stu;
		}
	}
//	次方法只有本类中调用, 故修饰符用 [private]
	private int stuIndex (String name) {
		for(int i= 0; i<stus.length; i++) {
			if (stus[i] != null) {
//				找到需要更新的信息的学生(按照name找)在 stus[] 中的索引位置
				if(stus[i].name == name) {
					return i;
				}
			}
		}
		return -1;
	}

	//	方法6 输出所有学生信息
	public void printAllStudentInfo() {
		System.out.println("students info are:");
		for(int i = 0; i<stus.length; i++) {
//			Student stu = stus[i];
//			不打印班级中未初始化的学生信息
			if(stus[i] != null) {
//				stus[i] 本就是一个学生实例, 可直接调用Student 类的方法, 87 行代码无必要
				stus[i].showInfo();
			}
		}
	}
}
