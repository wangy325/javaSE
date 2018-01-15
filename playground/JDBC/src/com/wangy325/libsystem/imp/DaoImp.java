package com.wangy325.libsystem.imp;

import java.sql.SQLException;
import java.util.List;

import com.wangy325.libsystem.bean.BorrowRecord;
import com.wangy325.libsystem.utils.BlobUtil;
import com.wangy325.libsystem.utils.LoginUtil;
import com.wangy325.libsystem.utils.QueryUtil;
import com.wangy325.libsystem.utils.UpdateUtil;

public class DaoImp implements Dao {

	@Override
	public boolean loginCheckDao(String username, String passwd) throws Exception {
		if (LoginUtil.checkUser(username, passwd))
			return true;
		else
			return false;
	}

	@Override
	public boolean insertStu(String username, String passwd) {
		String sql = "INSERT INTO STU(SNAME,SPASSWD) VALUES(? , ? )";
		if(UpdateUtil.update(sql,username,passwd))
			return true;
		return false;
	}

	@Override
	public <T> List<T> queryData(String sql, Class<T> clazz) throws Exception {
		return   QueryUtil.queryAll(sql, clazz);
	}

	@Override
	public void borrowBooks(String username, String bname, Integer bnum) throws SQLException {
		BlobUtil.borrowBody(username, bname, bnum);
		
	}

	@Override
	public void returnBook(String username, String boName, int reNum,List<BorrowRecord> newList) throws SQLException {
		BlobUtil.saveBorrowInfo(username, boName, (-reNum), newList);
		
	}

	

}
