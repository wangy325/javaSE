package com.wangy325.io.decorator.demo1;

// 装饰3
public class Decorator3 extends Decorator {

	public Decorator3(Human human) {
		super(human);
	}

	public void free() {
		System.out.println("今天高速不收费");
	}
	public void championship() {
		System.out.println("今晚英超联赛决赛");
	}
	@Override
	public void goHome() {
		super.goHome();
		free();
	}

	@Override
	public void watchTv() {
		super.watchTv();
		championship();
	}

	
}
