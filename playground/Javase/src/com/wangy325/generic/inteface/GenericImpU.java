package com.wangy325.generic.inteface;

import java.util.Random;

import org.junit.Test;

/**
 * @author wangy325
 *
 * @date Jan 10, 2018  11:58:45 AM
 *
 * @description   泛型接口的实现类, 传入泛型实参的情况
 * 
 */
public class GenericImpU implements GenericInterface<String> {
	/**
	 * 传入泛型实参时：
	 * 定义一个生产器实现这个接口,虽然我们只创建了一个泛型接口 GenericInterface<T>
	 * 但是我们可以为 T 传入无数个实参，形成无数种类型的 GenericInterface 接口
	 * 在实现类实现泛型接口时，如已将泛型类型传入实参类型，则所有使用泛型的地方都要替换成传入的实参类型
	 * 即：GenericInterface<T>，public T next();中的的T都要替换成传入的String类型
	 */
	private String[] fruits = new String[] { "Apple", "Banana", "Pear" };

	@Override
	public String test() {
		Random rand = new Random();
		return fruits[rand.nextInt(3)];
	}
	
	@Test
	public void test1() {
		System.out.println(test());
	}

}
