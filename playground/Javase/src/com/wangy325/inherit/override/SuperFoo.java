/**
 * 
 */
package com.wangy325.inherit.override;

/**
 * @author wangy325
 *
 * @date Dec 11, 2017  7:22:30 PM
 *
 * @decription  讨论了 继承类 对象初始化的时候, 总是先初始化父类, 再初始化子类
 * 				以及 父类方法的覆写 必须要满足的条件
 * 
 * @target TODO
 */

class SuperFoo {

	SuperFoo() {
		System.out.println("父类的无参构造器");
	}

	SuperFoo doStuff(int x) {
		System.out.println("父类的doStuff方法, 返回值类型SuperFoo");
		return new SuperFoo();
	}

}
