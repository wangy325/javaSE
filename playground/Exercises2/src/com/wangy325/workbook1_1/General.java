package com.wangy325.workbook1_1;

public class General {
	// 接口作为方法参数
	void makeCry(CanCry c) {
		// 同包中, 没有关系的两个类, 只要修饰符不是private 方法都可以调用
		c.cry();
	}

	public static void main(String[] args) {
		// 多态
		CanCry cat = new Cat();
		cat.cry();
		// 非多态
		Dog dog = new Dog();
		// general 调用方法
		General general = new General();
		general.makeCry(dog);
		general.makeCry(cat);

	}

}
