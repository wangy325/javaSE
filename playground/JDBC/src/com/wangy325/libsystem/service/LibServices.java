package com.wangy325.libsystem.service;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.wangy325.libsystem.bean.BorrowRecord;
import com.wangy325.libsystem.bean.Lib;
import com.wangy325.libsystem.imp.Dao;
import com.wangy325.libsystem.imp.DaoImp;

public class LibServices {
	private static Dao dao = new DaoImp();

	// login verify
	public static boolean loginCheck(String username, String passwd) {
		try {
			if (dao.loginCheckDao(username, passwd))
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	// create a new account (w=insert a new row into table STU)
	// insert fields are SNAME and SPASSWD
	public static boolean creatAccount(String username, String passwd) {
		if (dao.insertStu(username, passwd))
			return true;
		return false;
	}

	// query all books' info of library
	public static <T> void queryAll() {
		String sql = "SELECT * FROM LIBRARY ORDER BY BID ";
		@SuppressWarnings("unchecked")
		Class<T> clazz = (Class<T>) Lib.class;
		System.out.println("All books info is displayed below: ");
		try {
			List<T> eleList = dao.queryData(sql, clazz);
			for (T ele : eleList) {
				System.out.println("\t"+ele);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// borrows book
	public static <T> void borrowBooks(String username, String bname, Integer bnum) throws SQLException {
		dao.borrowBooks(username, bname, bnum);

	}

	// return book
	public static void returnBook(String username, String boName, int reNum, List<BorrowRecord> newList) throws SQLException{
		dao.returnBook(username,boName,reNum,newList);

	}

	@Test
	public void test() {
		// queryAll();
		// borrowBooks(1002);
	}

}
