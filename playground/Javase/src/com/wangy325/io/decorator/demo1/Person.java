package com.wangy325.io.decorator.demo1;
// 定义被装饰者
public class Person  implements Human{

	@Override
	public void goHome() {
		System.out.println("肥家了");
	}

	@Override
	public void watchTv() {
		System.out.println("看会直播");
		
	}
	
	
 
}
