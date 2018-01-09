package com.wangy325.demo02;

import java.util.ArrayList;

/**
 * @author wangy325
 *
 * @date Jan 8, 2018  10:09:24 PM
 *
 * @description   这个 Element 对象用于盛装表的一行数据
 * 
 * @tags 
 */
public class Element {
	/**
	 * Element 对象的属性就是所查询的表的列名
	 * 
	 * 试图属性 [columnName] 用一个 ArrayList 封装起来
	 * 但是结果并不理想, array作为一个属性
	 * 不能设置列名所对应行的值
	 */
	// private static ArrayList<Object> colname;
	private String sname;
	private int sage;
	public Element() {}
	public Element(String sname, int sage) {
		this.sname = sname;
		this.sage = sage;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getSage() {
		return sage;
	}
	public void setSage(int sage) {
		this.sage = sage;
	}
	@Override
	public String toString() {
		return "Element [sname=" + sname + ", sage=" + sage + "]";
	}
	
	
	

}
