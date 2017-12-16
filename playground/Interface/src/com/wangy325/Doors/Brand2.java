package com.wangy325.Doors;

public class Brand2 extends WaterDoor{
	final String brand = "Brand2";

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void open() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void waterPrevent() {
		System.out.println("the door keep flood away.");
		
	}
	
	void mainFunc() {
		waterPrevent();
	}
	
	void extFunc() {
		System.out.println("extra function of"+ brand);
	}
}
