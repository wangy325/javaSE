/**
 * 
 */
package com.wangy325.note;

/**
 * @author wangy325
 *
 * @date Dec 11, 2017 2:23:56 PM
 *
 * @decription
 * 
 * @target TODO
 */
public class Son extends Father {

	public String number = "number";

	public void sonM1() {
		System.out.println("子类的普通方法 sonM1()");
	}

	public void test() {
		System.out.println("子类覆写的父类的方法 test()");
	}

	/**
	 * <li>eclipse 此处没有出现 方法覆写标记啊 //
	 * <li>实际上, 静态方法不能被覆写, 有趣的是, 子类和父类中出现 同名静态方法不会编译错误
	 */

	// public static void stable() {
	// System.out.println("子类覆写的父类的静态方法stable()");
	// }

	public static void main(String[] args) {
		// TODO 测试多态

		Father father = new Father();

		// 标准的向上转型 (Upcasting)
		Father fatherx = new Son();

		Son son = new Son();

		// 父类对象
		father.fatherM1();
		father.test();
		System.out.println(father.number);
		Father.stable();
		System.out.println("-----------");

		// 父类引用类型, 子类对象 多态
		fatherx.fatherM1(); /// :~ 父类的普通方法 fatherM1
		fatherx.test(); /// :~ 子类覆写的父类的方法 test()
		// 成员变量不具备多态性
		System.out.println(fatherx.number); // :~ 6
		/** fatherx.sonM1(); */
		/**
		 * <li>上面的代码编译时候会报错, 因为虽然 fatherx 引用变量包含了sub() 方法,
		 * <li>(还可以利用反射来执行方法), 但是它编译时候的类型是 Father, 故无法调用
		 * <li>子类的sonM1() 方法
		 */
		/** fatherx.stable(); */
		/**
		 * ///:~ 父类的被覆写的静态方法stable()
		 * <li>静态方法也不具有多态性 因为静态方法是用 [类名.方法名] 调用的
		 * <li>上行代码编译时会报警告, 但是可以执行
		 */
		System.out.println("------------------");

		// 子类对象
		son.fatherM1(); // 子类调用父类的普通方法 没问题
		son.sonM1(); // 子类调用子类的普通方法 更没问题
		son.test(); // 子类调用子类 覆写的父类的方法
		System.out.println(son.number);
		/**
		 * <li>下面的代码会调用静态方法 stable(), 子类中存在即调用子类的,
		 * <li>子类中不存在则去调用父类的该方法
		 * <li>也就是说, 静态方法不能被覆写, 但是可以继承
		 */
		Son.stable();
	}
}
