package com.wangy325.io.decorator.demo1;

// 定义装饰者
public abstract class Decorator implements Human {
	private Human human;
	
	public Decorator(Human human) {
		this.human = human;
	}

	@Override
	public void goHome() {
		human.goHome();
	}

	@Override
	public void watchTv() {
		human.watchTv();
	}

}
