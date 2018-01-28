package com.wangy325.io.decorator.demo1;

// 装饰1
public class Decorator1 extends Decorator {

	public Decorator1(Human human) {
		super(human);
	}

	public void vehicle() {
		System.out.println("开车回家");
	}

	public void tv() {
		System.out.println("看55寸的索尼高清彩电");
	}

	@Override
	public void goHome() {
		super.goHome();
		vehicle();
	}

	@Override
	public void watchTv() {
		super.watchTv();
		tv();
	}

}
