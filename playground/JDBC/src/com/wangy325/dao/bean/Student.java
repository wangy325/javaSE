package com.wangy325.dao.bean;

/**
 * @author wangy325
 *
 * @date Jan 9, 2018  9:55:33 AM
 *
 * @description   
 * 
 * @tags 
 */
public class Student {
	private String sname;
	private Integer sage;
	private String sgender;
	
	public Student() {}
	/**
	 * @param sname
	 * @param sage
	 * @param sgender
	 */
	public Student(String sname, Integer sage, String sgender) {
		super();
		this.sname = sname;
		this.sage = sage;
		this.sgender = sgender;
	}
	
	
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public Integer getSage() {
		return sage;
	}
	public void setSage(Integer sage) {
		this.sage = sage;
	}
	public String getSgender() {
		return sgender;
	}
	public void setSgender(String sgender) {
		this.sgender = sgender;
	}
	@Override
	public String toString() {
		return "Student: name=" + sname + ", age=" + sage + ", gender=" + sgender ;
	}
	
	
	

}
