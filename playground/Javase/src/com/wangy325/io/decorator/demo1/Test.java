package com.wangy325.io.decorator.demo1;

public class Test {

	public static void main(String[] args) {
		Human p = new Person();
		
		Decorator d = new Decorator3(new Decorator2(new Decorator1(p)));
		
		d.goHome();
		d.watchTv();
	}

}
