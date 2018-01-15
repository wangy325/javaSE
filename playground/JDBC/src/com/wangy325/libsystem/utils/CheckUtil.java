package com.wangy325.libsystem.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;


/**
 * @author wangy325
 *
 * @date Jan 10, 2018 2:17:40 PM
 *
 * @description Check weather a user name or a bookID exists or not
 * 
 */
public class CheckUtil {
	private static ArrayList<Object> obj = new ArrayList<>();
	
	public static <E> boolean check(E e) {
		obj = fetchStuName(e);
		for (Object str : obj) {
			if (e.toString().equals(str.toString()) )
				return true;
		}
		return false;
	}

	public static <E> ArrayList<Object> fetchStuName(E e) {
		Connection conn = null;
		String sql = null;
		if (e instanceof String)
			sql = "SELECT SNAME FROM STU ";
		if (e instanceof Integer)
			sql = "SELECT BID FROM LIBRARY";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = C3p0Util.getConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				obj.add(rs.getString(1));
			}
			return obj;
		} catch (SQLException exp) {
			exp.printStackTrace();
		} finally {
			C3p0Util.close(rs, ps, conn);
		}
		return obj;
	}

	@Test
	public void test() {
		System.out.println((check(1001) ? "exist" : "oops"));
	}
}
