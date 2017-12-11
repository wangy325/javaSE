/**
 * 
 */
package com.wangy325.inherit_constructor;

/**
 * @author wangy325
 *
 * @date Dec 11, 2017  7:23:48 PM
 *
 * @decription  
 * 
 * @target TODO
 */
class Foo extends SuperFoo {
	// insert code here
	Foo() {
		System.out.println("----");
	}

	// 子类覆写的父类方法
	/**
	 * 1. 方法名, 参数表必须要相同
	 * 2. 子类方法的返回值 范围不能大于父类的返回值范围
	 *    也就是说, 要么类型相同, 要么是父类返回值类型的子类
	 * 3. 子类中覆写的方法的权限不能小于父类中被覆写方法的权限
	 * 		 overrides com.wangy325.inherit_constructor.SuperFoo.doStuff
	 * 		 Cannot reduce the visibility of the inherited method from 
	 * 		SuperFoo
	 */

	SuperFoo dostuff(int x) {
		System.out.println("1");
		// return new Foo();
		return new SuperFoo();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wangy325.inherit_constructor.SuperFoo#doStuff(int)
	 */
//	@Override
	/*public double doStuff(int x) {
		// TODO Auto-generated method stub
		return 12;
	}*/

	public static void main(String[] args) {
		new Foo().dostuff(6);
		System.out.println("----------");
		new SuperFoo().doStuff(5);
	}
}

/**
 *  ///:~
 *  hello  // 初始化对象的时候总是先初始化父类
 * 	----	// 再初始化子类
 *	1		// 再调用子类的 dostuff() 方法
 *	hello	//返回值重新初始化了父类
 *	-----------
 *	hello	
 *	2
 *	hello
 * 
 */
