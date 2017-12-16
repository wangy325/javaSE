/**
 * 
 */
package com.wangy325.USB;

/**
 * @author wangy325
 *
 * @date Dec 16, 2017  6:46:39 PM
 *
 * @decription  
 * 
 * @target TODO
 */
public class Test {
	public static void main(String[] args) {
		UDisk uDisk = new UDisk();
		UFan uFan = new UFan();
		UMouse uMouse = new UMouse();
		uDisk.services();
		uFan.services();
		uMouse.services();
	}
}
