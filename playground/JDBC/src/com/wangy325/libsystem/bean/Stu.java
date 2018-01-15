package com.wangy325.libsystem.bean;

public class Stu {
	private String sname,spasswd,sbname;
	private Integer sbnum;
	
	public Stu() {
		super();
	}

	public Stu(String sname, String spasswd, String sbname, Integer sbnum) {
		this.sname = sname;
		this.spasswd = spasswd;
		this.sbname = sbname;
		this.sbnum = sbnum;
	}

	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSbname() {
		return sbname;
	}
	public void setSbname(String sbname) {
		this.sbname = sbname;
	}
	public Integer getSbnum() {
		return sbnum;
	}
	public void setSbnum(Integer sbnum) {
		this.sbnum = sbnum;
	}
	
	public String getSpasswd() {
		return spasswd;
	}

	public void setSpasswd(String spasswd) {
		this.spasswd = spasswd;
	}

	@Override
	public String toString() {
		return "Stu [sname=" + sname + ", sbname=" + sbname + ", sbnum=" + sbnum +",spasswd="+spasswd+ "]";
	}
	
	

}
