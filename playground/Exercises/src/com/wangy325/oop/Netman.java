/**
 * 
 */
package com.wangy325.oop;

/**
 * @author wangy325
 *
 * @date Dec 6, 2017  3:26:00 PM
 *
 * @decription  
 * 
 * @target TODO
 */
public class Netman {
	String ID,PassWd,Email_Address;
	
	public Netman() {
//		构造器重载
		this(null,null,null);
	}
	
	public Netman(String ID,String PassWd,String Email_Address ) {
//		this.ID = ID;
//		this.PassWd = PassWd;
//		this.Email_Address = Email_Address;
		if ((ID == null||ID == "") || (PassWd == "" ||PassWd == null)) {
			System.out.println("ID 或 PassWd 不能为空!");
			return;
		}
		else if (Email_Address == null||Email_Address == "") {
			Email_Address = ID + "@mail.yztcedu.com";
		}
		System.out.println("ID:"+ID+"\tpassword:"+PassWd+"\temail:"+Email_Address);
	}
	public static void main (String[] args) {
//		创建对象 调用构造器
		Netman netman = new Netman("a","aa","");
		System.out.println(netman.ID);
		/**
		 * 输出结果:
		 * ID:a	password:aa	email:a@mail.yztcedu.com
		 * null
		 * 原因: 在没有用 this 访问成员属性时,构造器内的ID变量是局部变量 
		 * 		对象 netman 的 ID 属性自然为空
		 */
		
		
	}

}
