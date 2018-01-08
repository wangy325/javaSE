/**
 * 
 */
package com.wangy325.inherit.this_super;

/**
 * @author wangy325
 *
 * @date Dec 10, 2017  2:30:01 PM
 *
 * @decription   ??如何理解 [this] 作为参数?
 * 
 * @target TODO
 */
public class Son extends Father {
	private int salary;
	
	public Son (String name, int age,int salary) {
//		[super] 关键字调用父类 构造器
		super(name,age);
//		[this] 关键字 初始化对象属性, 最常用用法
		this.salary = salary;
	}
	
	public void showDetails() {
//		[this] 和 [super] 都访问了父类的属性, [this] 会先在本类中寻找, 没找到 [name] 属性则去父类中寻找,
//		而 [super] 直接访问父类的 [age] 属性
//		需要说明的是, [this] 和 [super] 关键字都可以省略, 因为默认有个隐式的 [this]
		System.out.println("A:name: "+ name +" age "+ age + " salary $" + salary);
		
//		[this] 关键字调用了父类的 showInfo() 方法, [this] 调用方法的顺序和 [this] 访问属性的步骤一样, 先本类, 后父类
		System.out.println("B:"+showInfo() + " salary $"+salary) ;
		
//		[super] 关键字 直接调用了父类的 showInfo() 方法
		System.out.println("C:"+super.showInfo() + " salary $"+salary) ;
	}
}


