package com.wangy325.libsystem.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @author wangy325
 *
 * @date Jan 13, 2018-- 2:37:23 PM
 *
 * @description Combo pool util  for establishing connection and release resources.
 * 
 */
public class C3p0Util {
	// Create Connection Pool
	private static ComboPooledDataSource conPool = new ComboPooledDataSource("Oracle");

	// Create a Connection from Connection Pool
	public static Connection getConn() throws SQLException {
		try {
			return conPool.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException("Failed to connect database!");
		}
	}

	// Release resources
	public static void close(ResultSet rs) {
		close(rs, null, null);
	}

	public static void close(Statement st) {
		close(null, st, null);
	}

	// Release Connection Instance back to Connection Pool
	// NOTICE: Connection is also established
	public static void close(Connection conn) {
		close(null, null, conn);
	}

	public static void close(Statement st, Connection conn) {
		close(null, st, conn);
	}

	public static void close(ResultSet rs, Statement st, Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				// Restore AutoCommit to default setting
				conn.setAutoCommit(true);
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Test
	public void test() {
		Connection conn = null;
		try {
			conn = getConn();
		} catch (SQLException e) {
			e.printStackTrace();
			if (conn == null) {
				System.out.println("Connect to database failed.");
			}
		} finally {
			close(conn);
		}
	}
}
