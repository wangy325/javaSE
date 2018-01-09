package com.wangy325.demo02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.junit.Test;

/**
 * @author wangy325
 *
 * @date Jan 8, 2018  5:54:16 PM
 *
 * @description   升级 demo 中的JUtils 工具, 利用 config 文件获取对数据库的连接
 */
public class JUnitsPLus {
	// 设置静态属性
	private static String ORACLEDRIVER, URL, USERNAME, PASSWD;
	/**
	 * 读取配置文件, 获取连接数据库的几个变量
	 * 驱动和配置文件只加载一次, 可以写在静态代码块里面
	 */
	static {
		// class Properties extends Hashtable<Object,Object>
		Properties config = new Properties();
		try {
			config.load(new BufferedReader(new FileReader(new File("src/com/wangy325/demo02/conn.config"))));
			// 获取属性
			ORACLEDRIVER = config.getProperty("oracleDriver");
			URL = config.getProperty("url");
			USERNAME = config.getProperty("username");
			PASSWD = config.getProperty("passwd");
			// load drivers
			Class.forName(ORACLEDRIVER);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

	}

	/**
	 * @return a Connection instance
	 */
	public static Connection getConn() {
		try {
			return  DriverManager.getConnection(URL, USERNAME, PASSWD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * close all stream which implement(extends) AutoCloseable interface
	 * @param AutoCloseable implements class
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

	/**
	 * Test 方法区利用 JUnit 4 来验证上述方法中获取的变量是否符合预期
	 */
	@Test
	/**
	 * 测试是否获取正确的变量, 能够连接数据库
	 */
	public void readConfigTest() {
		System.out.print(ORACLEDRIVER + "\n" + URL + "\n" + USERNAME + "\n" + PASSWD);
	}

	@Test
	/**
	 * 测试数据库是否能正常连接
	 */
	public void connTest() {
		// 只要 getConn() 返回值不为空, 说明连接正常
		if (!(getConn() != null))
			System.out.println("connecting failed");

	}
}
