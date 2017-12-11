/**
 * 
 */
package com.wangy325.inherit;

/**
 * @author wangy325
 *
 * @date Dec 10, 2017  12:31:57 PM
 *
 * @decription  
 * 
 * @target TODO
 */
public class Test {

	
	public static void main (String[] args) {
		Son son1 = new Son();
		son1.method();
		Son son2 = new Son();
		son2.method();
		
		
	}
}

///:~
// 祖先的的静态代码块
// 父类静态代码块
// 子类静态代码块..
// 祖先第一构造代码块
// 祖先的第二构造代码块
// 祖先的构造方法
// 父类第一构造代码块
// 父类第二构造代码块
// 父类的构造方法...
// 子类构造代码块
// 子类的构造方法
// ----------------
// 祖先第一构造代码块
// 祖先的第二构造代码块
// 祖先的构造方法
// 父类第一构造代码块
// 父类第二构造代码块
// 父类的构造方法...
// 子类构造代码块
// 子类的构造方法
// ----------------


/** 结论
 *  1. 创建子类对象时候, 子类和父类中的 [静态代码块] 最先执行, 数据会加载到静态方法区, 且静态代码块只 [执行一次];
 *  2. 创建子类对象时, [构造代码块] 先于 [构造方法] 执行;
 *  3. 创建子类对象时, 会先调用父类的 [构造方法], 然后再调用子类的 [构造方法];
 * 
 * 
 */