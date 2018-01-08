/**
 * 
 */
package com.wangy325.interfaces.interfaces;

/**
 * @author wangy325
 *
 * @date Dec 13, 2017  7:32:43 PM
 *
 * @decription  实现类 既可以实现接口(必须), 还可以继承父类
 * 
 * @target TODO
 */
public class DoorLock extends Material implements Door, Lock {

	// 实现类必须要实现(覆写)接口的所有抽象方法!
	@Override
	public void locked() {
		System.out.println("the door's locked.");
	}

	@Override
	public void unlocked() {
		System.out.println("unlock the door.");
	}

	@Override
	public void open() {
		System.out.println("the door is unlocked, open it.");
	}

	@Override
	public void close() {
		System.out.println("donot forget to lock the door while close it.");
	}

	// 构造器
	public DoorLock() {
	}

	public DoorLock(String material) {
		super(material);
	}

	// 实现类自己的方法
	public void openDoor() {
		unlocked();
		open();
	}

	public void closeDoor() {
		close();
		locked();
	}

	// 继承父类的属性
	public void showM() {
		System.out.println("the material of door is " + super.material);
	}

	public static void main(String[] args) {
		DoorLock door = new DoorLock("oak");
		door.showM();
		door.openDoor();
		System.out.println("---------");
		door.closeDoor();

		System.out.println("----下面的是接口的真正内涵-----");
		// 下面的是接口的真正内涵, 多态 向上转型
		// 这里没法向下转型, 因为上层是接口, 无法实例化
		Door door1 = new DoorLock();
		door1.close();
		door1.open();
		System.out.println("---------");
		Lock lock1 = new DoorLock();
		lock1.locked();
		lock1.unlocked();

	}

}
