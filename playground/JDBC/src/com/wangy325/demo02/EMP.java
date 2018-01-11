package com.wangy325.demo02;

/**
 * @author wangy325
 *
 * @date Jan 10, 2018  10:32:58 PM
 *
 * @description   
 * 
 * @tags  
 */
public class EMP {
	private String ename, job;
	private Double sal;

	public EMP() {
		super();
	}

	public EMP(String ename, String job, Double sal) {
		super();
		this.ename = ename;
		this.job = job;
		this.sal = sal;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Double getSal() {
		return sal;
	}

	public void setSal(Double sal) {
		this.sal = sal;
	}

	@Override
	public String toString() {
		return "EMP [ename=" + ename + ", job=" + job + ", sal=" + sal + "]";
	}

}
