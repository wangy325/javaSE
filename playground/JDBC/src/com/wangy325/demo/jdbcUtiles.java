package com.wangy325.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author wangy325
 *
 * @date Jan 5, 2018  3:15:37 PM
 *
 * @description  1. 自动加载驱动  // Class.forName("oracle.jdbc.OracleDriver");
 * 				 2. 建立连接
 * 				 3. 关闭资源
 * @tags 
 */
public class jdbcUtiles {
	/**
	 * connect to database on win 7, hostname is ipAddress
	 * @return Connection instance
	 * @statement DriverManager.getConnection(String url,String user, String password);
	 */
	public static Connection getConn() {
		Connection conn = null;
		try {
			String url = "jdbc:oracle:thin:@192.168.3.135:1521:orcl";
			String user = "scott";
			String psw = "tiger";
			conn = DriverManager.getConnection(url, user, psw);
			 System.out.println("数据库连接成功！");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	/**
	 * close database Connection instance
	 */
	public static void close(Connection conn) {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * close all stream which implement(extends) AutoCloseable interface
	 * @param conn
	 */
	public static void closeAll(AutoCloseable... stream) {
		for (AutoCloseable ac : stream) {
			if (ac != null) {
				try {
					ac.close(); 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

}
