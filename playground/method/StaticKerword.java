/**
 * 
 */
package com.wangy325.method;

/**
 * @author wangy325
 *
 * @date Dec 7, 2017 3:06:31 PM
 *
 * @decription 测试static关键字
 * 				静态属性
 * 				静态代码块
 * 				静态方法
 * 
 * @target TODO
 */
public class StaticKerword {
	// static 关键字 修饰变量, 只在内存中初始化一次
	// 想 访问 static 修饰的 成员变量, 可以用[类名.属性]的方法访问
	// static 不能修饰局部变量
	static int i = 47; // 静态属性
	int j = 6;

	public static void main(String[] args) {
		StaticKerword statictest1 = new StaticKerword();
		// 用对象访问静态属性,虽然可以成功,但是 可能会有问题(对象引用和静态属性[生命周期]冲突)??
		/*System.out.println(statictest1.i);*/
		// 直接用类名访问属性
		System.out.println(StaticKerword.i);
		// 类名也可以隐藏, 原因是访问属性的代码块在本类中
		System.out.println(i);
		// 用[对象引用.属性]的方式访问非静态属性
		System.out.println(statictest1.j);
		// 代码报错, 不能用[类名.属性]访问非静态属性
		/* System.out.println(j);*/

		StaticKerword s2 = new StaticKerword();
		System.out.println(s2.j);
		
//		利用类名访问静态方法, 类似于 访问静态属性
		method1();
//		利用[对象引用.方法名] 访问非静态方法
		s2.method2();
	}

	static {// static 静态代码块 只加载一次
		// 静态代码块主要用于 在框架中加载配置文件, 或者加载一些驱动信息
		//
		System.out.println("我是静态代码块...");
	}

	{ // 构造代码块 每次new 创建一个对象的时候 都会执行构造代码块一次
		System.out.println("我是构造代码块...");
	}

	public StaticKerword() {
		System.out.println("我是构造器..");
	}
	
	public static void method1() { // 静态方法
		System.out.println("我是静态方法");
	}
	public void method2() { // 非静态方法
		System.out.println("我是非静态方法");
	}
}
