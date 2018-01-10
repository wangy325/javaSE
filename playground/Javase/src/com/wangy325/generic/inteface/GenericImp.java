package com.wangy325.generic.inteface;

/**
 * @author wangy325
 *
 * @date Jan 10, 2018  11:45:27 AM
 *
 * @description   泛型接口的实现类, 没有传入泛型实参的情况
 * 
 * @tags generic
 */
public class GenericImp<T> implements GenericInterface<T>{
	/**
	 * 未传入泛型实参时，与泛型类的定义相同，在声明类的时候，需将泛型的声明也一起加到类中
	 * 即：class FruitGenerator<T> implements Generator<T>{
	 * 如果不声明泛型，如：class FruitGenerator implements Generator<T>，编译器会报错："Unknown class"
	 */
	@Override
	public T test() {
		return null;
	}

	
	
}
