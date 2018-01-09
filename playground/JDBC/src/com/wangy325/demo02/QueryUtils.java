package com.wangy325.demo02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author wangy325
 *
 * @date Jan 8, 2018  7:24:42 PM
 *
 * @description   封装数据库的查询为一个工具类
 * 基本实现:
 * 			1. 读取表的数据, 存入 ResultSetMetaData 中, 这其中本封装了一些表的信息
 * 最终实现:	
 * 			2. 将表的一行数据作为一个对象, 其中 列名作为对象属性, 存入一个 LIST 中
 * 
 * HOWTO:
 * 			1. RSMD 可获取列名和元素, 将其作为 KEY-VALUE 存入 MAP 中
 * 			2. 遍历 MAP 获取 VALUE 值, 通过反射拿到 [行对象] 的 [列名]属性,
 * 				并将 VALUE 值给这个属性
 * 			3. 遍历输出 LIST
 * 
 */
public class QueryUtils {

	/**
	 * 获取 RSMD
	 * @param sql
	 */
	public static void query(String sql) {
		Connection conn = JUnitsPLus.getConn();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsmdata = rs.getMetaData();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @throws SQLException 
	 * 
	 */
	public static void addDataToElement(ResultSetMetaData rsmdata, ResultSet rs) throws SQLException {
		// 获取表格列数 cc
		//
		int cc = rsmdata.getColumnCount();
//		String[] colname = new String[cc];
		Element element = new Element();

		while (rs.next()) {
			for (int i = 1; i <= cc; i++) {
				try {
					// 列名
					Object colname = rsmdata.getColumnName(i);
					rsmdata.getColumnTypeName(i)
					// 通过列名拿到该列的常量值
					Object obj = rs.getObject(colname.toString());
					 element.colname.setColname(obj);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
