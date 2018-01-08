/**
 * 
 */
package com.wangy325.inherit.human;

/**
 * @author wangy325
 *
 * @date Dec 9, 2017  2:13:35 PM
 *
 * @decription  
 * 
 * @target TODO
 */
public class Student extends Human {
//	私有子类成员变量
	private String SN, CN;
	
	public Student() {
//		调用父类空构造器
		super();
	}
	public Student(String name, int age, String gender) {
//		调用父类含参构造器
		super(name, age, gender);
	}
	
//	利用set/get 方法 初始化成员变量值
	public String getSN() {
		return SN;
	}
	public void setSN(String sN) {
		SN = sN;
	}
	public String getCN() {
		return CN;
	}
	public void setCN(String cN) {
		CN = cN;
	}
//	重写自我介绍方法
	public String selfItroduction() {
		return super.selfItroduction()+" from class" +this.CN +" and student N0. is " + this.SN +".";
	}
	
}
