package com.wangy325.interfaces.doors;

public class Brand1 extends ThiefDoor {
	final String brand = "Brand1";
	
	
	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void open() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void thiefPrevent() {
		System.out.println("the door keep thieves away.");
		
	}

	void mainFunc() {
		thiefPrevent();
	}
	
	void extFunc() {
		System.out.println("extra function of"+ brand);
	}

}
