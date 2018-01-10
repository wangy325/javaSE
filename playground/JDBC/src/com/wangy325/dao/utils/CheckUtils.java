package com.wangy325.dao.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;


/**
 * @author wangy325
 *
 * @date Jan 10, 2018  2:17:40 PM
 *
 * @description   查询数据库,将获取的学生名字添加到 stuName 集合中
 * 
 */
public class CheckUtils {
	private static ArrayList<String> stuName = new ArrayList<>();

	public static boolean check(String name) {
		stuName = fetchStuName();
		for(String str :stuName) {
			if(name.equals(str))
				return true;
		}
		return false;
	}

	public static ArrayList<String> fetchStuName() {
		Connection conn = JdbcUtils.getConn();
		String sql = "SELECT SNAME FROM STU";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				stuName.add(rs.getString(1));
			}
			return stuName;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stuName;
	}

	@Test
	public void test() {
		System.out.println((check("alan")?"exist":"oops"));
	}
	
}
