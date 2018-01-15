package com.wangy325.libsystem.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

/**
 * 
 * @author wangy325
 *
 * @date Jan 11, 2018-- 6:51:44 PM
 *
 * @description update database
 *              1. create new user/password
 *              2. borrow/return book(s)
 *
 */
public class UpdateUtil {
	// create new account
	public static boolean update(String sql, Object... obj) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = C3p0Util.getConn();
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < obj.length; i++) {
				ps.setObject((i + 1), obj[i]);
			}
			if (ps.executeUpdate() > 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			C3p0Util.close(ps, conn);
		}
		return false;
	}

	@Test
	public void test() {
		System.out.println(update("INSERT INTO STU(SNAME,SPASSWD) VALUES(? , ? )", "ka", "ka") ? "yes" : "opps");
	}

	//////////////////// ABONDANDED CODE ///////////////////
	public static boolean createNew(String username, String passwd) {
		Connection conn = null;
		String sql = "INSERT INTO STU(SNAME,SPASSWD) VALUES('" + username + "','" + passwd + "')";
		PreparedStatement ps = null;
		try {
			conn = C3p0Util.getConn();
			ps = conn.prepareStatement(sql);
			if (ps.executeUpdate() > 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			C3p0Util.close(ps, conn);
		}
		return false;
	}
	////////////////////// ABONDANDED CODE /////////////////////
}
