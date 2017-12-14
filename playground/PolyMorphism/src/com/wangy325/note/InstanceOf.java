/**
 * 
 */
package com.wangy325.note;

/**
 * @author wangy325
 *
 * @date Dec 11, 2017 4:09:58 PM
 *
 * @decription	多态二 之强制类型转换
 *             <li>1. note 里面已经说过了, 将子类 [对象] 赋值给父类 [引用类型] 的时候
 *             		  直接向上转型就可以完成
 *             <li>2. 如果要将 [父类对象] 赋值给子类 [引用类型] ,那么就需要强制类型转换了
 *             <li>3. 引用类型的强制类型转换只能在 [具有继承关系] 的两个类型之间进行转换, 
 *             		  如果是两个没有任何继承 关系的类型, 则无法进行类型转换
 *             <li>4. 出现 ClassCastException 不要慌, 是类型转换错误
 * @target TODO 什么情况下, 需要父类向子类转型?
 * 				1. 父类需要访问子类的成员变量属性;
// * 以下两项没有代码实例!
				2. 当形参定义的是父类类型变量(引用)，但实参有可能是该形参类型的子类对象时
				3. 当返回值类型是父类类型，但返回的具体对象是子类对象时
 */
public class InstanceOf {
	public static void main(String[] args) {
		double dou = 13.4;
		long lo = (long) dou;// 强制类型转换
		System.out.println(lo);
		/**
		 * int in = 5;
		 * <li>boolean boo = (boolean)in;
		 * <li>// 编译出错, int 不能强制转换为 boolean !
		 */
		Object obj = "hello";
		// Object 类是所有类的父类
		String str = (String) obj;
		System.out.println(str);
		// 利用向上转型 创建一个 Object 类
		/**
		 * 它编译的时候是 Object 类, 运行的时候是 Integer 类
		 */
		Object objint = new Integer(6);

		/**	// 下面的代码出现 java.lang.ClassCastException: 错误
			String strint = (String) objint;
			System.out.println(strint);
		*/
		// 为了使代码显得更健康, 可以用 [instanceof] 关键字

		if (objint instanceof String) {
			String strint = (String) objint;
			System.out.println(strint);
		}

	}

}
