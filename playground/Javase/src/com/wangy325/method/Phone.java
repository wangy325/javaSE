/**
 * 
 */
package com.wangy325.method;

/**
 * @author wangy325
 *
 * @date Dec 7, 2017  7:40:31 PM
 *
 * @decription  接着创建一个手机类, 为其创建方法
 * 
 * @target TODO
 */
public class Phone {
	String brand, os, battery;
	
	public Phone(String brand, String os, String battery) {
		this.brand = brand;
		this.os = os;
		this.battery = battery;
	}
	public void mediaPlay() {
		System.out.println("follow steps below to play media:");
		
	}
	public void docDownload() {
		System.out.println("how to find the document you download from internet:");
	}
	public void charging() {
		System.out.println("please use offical charging suit to extend battery life.");
	}
	
	public static void main (String[] args) {
		Phone phone = new Phone("Apple","ios","1800mA");
		phone.mediaPlay();
		phone.docDownload();
		phone.charging();
	}
}
