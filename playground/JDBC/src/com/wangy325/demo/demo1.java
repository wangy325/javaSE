package com.wangy325.demo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.sql.Timestamp;
//import java.util.ArrayList;
//import java.util.List;
import java.util.Date;
import java.util.Scanner;

/**
 * @author wangy325
 *
 * @date Jan 5, 2018  2:39:56 PM
 *
 * @description   JDBC-- Java database connection
 * 
 * TODO 1. query the info of TABLE stu where name = 'lucy'
 * 		2. add 1 row to TABLE stu.
 * 
 */
public class demo1 {
	private static Scanner console;
	
	/**
	 * close Scanner console
	 */
	public static void consoleShut() {
		console.close();
	}
	public static void main(String[] args) {
		// build connection
		addRow();
		readTable();
	}

	/**
	 * Read data form a Table, the data was chosen by
	 * SQL statement within the method
	 */
	public static void readTable() {
		Connection conn = jdbcUtiles.getConn();
		// create Statement instance
		Statement st = null;
		try {
			st = conn.createStatement();
			// create SQL statement, no ';' need here in SQL
			String sql = "select * from stu";
			// execute SQL statement
			boolean exist = st.execute(sql);
			// check if there is data or not in TABLE stu
			System.out.println(exist ? "data exist" : "no data");
			// out put row data to console
			ResultSet rs = st.executeQuery(sql);
			// ResultSet.get(index), get data in a row
			while (rs.next()) {
				String name = rs.getString(1);
				int age = rs.getInt(2);
				Date birth = rs.getDate(4);
				System.out.println(name + "\t" + age + "\t" + birth);
			}
			/**
			while (rs.next()) {
				/**
				 * 1. 在 JDBC 中怎么知道表一行有几列?
				 * 2. 在 JDBC 中怎么知道表每列的数据类型?
				 * 3. resultSet 有一个 getMetaData 方法, 里面封装了一些获取表格信息的方法
				 <*>/
				List<Object> obj = new ArrayList<Object>();
				try {
					for (int i = 1;; i++) {
						obj.add(rs.getObject(i));
						rs.getMetaData();
					}
				} catch (SQLException e) {
					for (Object ob : obj) {
						System.out.print(ob+"\t");
					}
					System.out.println();
					// e.printStackTrace();
				}
			}
			*/
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// close resources
			jdbcUtiles.closeAll(st, conn);
		}
	}

	/**
	 * insert [1] row of data into a particular TABLE
	 */
	private static void addRow() {
		Connection conn = jdbcUtiles.getConn();
		Statement st = null;
		System.out.println("请输入学生名字:");
		String name = getInput();
		System.out.println("请输入学生年龄:");
		Integer age = 0;
		boolean flag = true;
		while (flag) {
			try {
				age = Integer.parseInt(getInput());
				if (age > 0 && age < 40)
					flag = false;
				else
					System.out.println("学生年龄不能为负数,也不能大于40");
			} catch (NumberFormatException e1) {
				System.out.println("非法输入,请输入数字");
				// e1.printStackTrace();
			}
		}
		System.out.println("请输入学生性别(female/male):");
		String gender = getInput();
		System.out.println("请输入学生生日(yyyy-mm-dd):");
		String birth = getInput();
		consoleShut();
		/**
		 * 日期验证: 1.输入指定格式 19911106 或者 1991-11-12 添加成功
		 * 			2.输入其他非指定格式还要验证
		 */
		try {
			st = conn.createStatement();
			String sql = "insert into stu(sname,sage,sgender,sbirth) values" + "('" + name + "'," + age + ",'" + gender
					+ "'," + "to_date('" + birth + "','yyyy-mm-dd'))";
			/**
			 * 利用 SQL 语句像数据表中添加 Date 类型的数据
			 * 用到了 SQL 中的 to_date('string','format')函数
			 * executeUpdate() 方法会执行SQL语句对数据表的 [添加] [删除] 和 [更新] 
			 * 操作, 并且会返回一个 int 值, 这个值是 [对SQL语句操作作出响应的行数]
			 */
			// System.out.println(sql);
			int rows = st.executeUpdate(sql);
			System.out.println("响应行数:" + rows);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbcUtiles.closeAll(st, conn);
		}
	}

	/**
	 * @return the data of each column, in the form of STRING.
	 */
	private static String getInput() {
		console = new Scanner(System.in);
		String getIn = console.next();
		// 不能关闭?
		// console.close();
		// 如果没有输入, 如何默认为该单行单列的值为null?
		// console.next() 不能接收 null ...
		return getIn;
	}
}
