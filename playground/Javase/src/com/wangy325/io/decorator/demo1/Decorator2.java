package com.wangy325.io.decorator.demo1;


// 装饰2
public class Decorator2 extends Decorator{

	public Decorator2(Human human) {
		super(human);
	}

	
	public void highway() {
		System.out.println("走高速回家");
	}
	
	public void sports() {
		System.out.println("用电视看足球..");
	}
	@Override
	public void goHome() {
		super.goHome();
		highway();
	}

	@Override
	public void watchTv() {
		super.watchTv();
		sports();
	}

	

}
