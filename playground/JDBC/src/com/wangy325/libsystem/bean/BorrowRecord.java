package com.wangy325.libsystem.bean;

import java.io.Serializable;

/**
 * @author wangy325
 *
 * @date Jan 12, 2018-- 2:41:32 PM
 *
 * @description the Students borrowed books record in a List
 * 
 */
public class BorrowRecord implements Serializable  {
	private static final long serialVersionUID = 3983734483779313981L;
	
	private String borrowedBookName;
	private Integer borrowedBookNum;
	public BorrowRecord() {
		super();
	}
	public BorrowRecord(String borrowedBookName, Integer borrowedBookNUm) {
		super();
		this.borrowedBookName = borrowedBookName;
		this.borrowedBookNum = borrowedBookNUm;
	}
	public String getBorrowedBookName() {
		return borrowedBookName;
	}
	public void setBorrowedBookName(String borrowedBookName) {
		this.borrowedBookName = borrowedBookName;
	}
	public Integer getBorrowedBookNum() {
		return borrowedBookNum;
	}
	public void setBorrowedBookNum(Integer borrowedBookNUm) {
		this.borrowedBookNum = borrowedBookNUm;
	}
	@Override
	public String toString() {
		return "\t BookName=" + borrowedBookName + ", BookNum=" + borrowedBookNum ;
	}
	
	

}
