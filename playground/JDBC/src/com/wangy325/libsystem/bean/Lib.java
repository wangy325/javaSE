package com.wangy325.libsystem.bean;

public class Lib {
	private Integer bid;
	private String bname;
	private Integer bnumber;

	public Lib() {
		super();
	}

	public Lib(Integer bid, String bname, Integer bnumber) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.bnumber = bnumber;
	}

	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public Integer getbnumber() {
		return bnumber;
	}

	public void setbnumber(Integer bnumber) {
		this.bnumber = bnumber;
	}

	@Override
	public String toString() {
		return "bookid=" + bid + "\t name=" + bname + "\t number=" + bnumber;
	}

}
