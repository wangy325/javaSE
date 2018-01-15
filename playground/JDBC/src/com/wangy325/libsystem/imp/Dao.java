package com.wangy325.libsystem.imp;

import java.sql.SQLException;
import java.util.List;

import com.wangy325.libsystem.bean.BorrowRecord;

public interface Dao {
	
	public  boolean loginCheckDao(String username, String passwd) throws Exception ;

	public boolean insertStu(String username, String passwd) ;

	public <T> List<T> queryData(String sql, Class<T> clazz) throws Exception;

	public void borrowBooks(String username, String bname, Integer bnum) throws SQLException;

	public void returnBook(String username, String boName, int reNum, List<BorrowRecord> newList) throws SQLException;
}
