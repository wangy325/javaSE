package com.wangy325.libsystem.utils;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

import org.junit.Test;

import com.wangy325.libsystem.bean.Stu;

public class LoginUtil {

	/**
	 * login check
	 * @param username
	 * @param passwd
	 * @return if account exists, return true, else return false. 
	 */
	public static boolean checkUser(String username, String passwd) throws Exception {
		Connection conn = null;
		String sql = "SELECT SPASSWD FROM STU WHERE SNAME='" + username + "'";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = C3p0Util.getConn();
			ps = conn.prepareStatement(sql);
			if (ps.executeUpdate() == 0)
				return false;
			rs = ps.executeQuery();
			if (isExist(rs, passwd))
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			C3p0Util.close(rs, ps, conn);
		}
		return false;
	}

	private static boolean isExist(ResultSet rs, String passwd) throws Exception {
		ResultSetMetaData rsmdata = null;
		try {
			rsmdata = rs.getMetaData();
			Object value = null;
			while (rs.next()) {
				value = rs.getObject(rsmdata.getColumnCount());
			}
			if (value.equals(passwd)) {
				return true;
			}
			// no need to override equals() of object.
			/*
			 * if(passwd.equals(value.toString()))
			 * return true;
			 */
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return false;
	}

	@Override
	public boolean equals(Object obj) {
		return super.toString().equals(obj);
	}

	@Test
	public void test() {
		try {
			System.out.println(checkUser("kagome", "passwd") ? "yes" : "no");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	///////////////// ABONDANDED CODE/////////////////////////////////

	public static boolean isExist(ResultSet rs, String username, String passwd) throws Exception {
		ResultSetMetaData rsmdata = null;
		Map<String, Object> user = new TreeMap<>();
		List<Stu> stuList = new ArrayList<>();
		try {
			rsmdata = rs.getMetaData();
			while (rs.next()) {
				for (int i = 0; i < rsmdata.getColumnCount(); i++) {
					String key = rsmdata.getColumnName(i + 1);
					Object value = rs.getObject(i + 1);
					user.put(key, value);
				}
				@SuppressWarnings("unchecked")
				Class<Stu> clazz = (Class<Stu>) new Stu().getClass();
				stuList.add(toList(user, clazz));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (Stu stu : stuList) {
			if (stu.getSname().equals(username) && stu.getSpasswd().equals(passwd))
				return true;
		}
		return false;
	}

	public static Stu toList(Map<String, Object> user, Class<Stu> clazz) throws Exception {
		Stu stu = clazz.newInstance();
		Set<Entry<String, Object>> entrySet = user.entrySet();
		for (Entry<String, Object> es : entrySet) {
			Field attri = clazz.getDeclaredField(es.getKey().toLowerCase());
			attri.setAccessible(true);
			if (es.getValue() instanceof String)
				attri.set(stu, es.getValue().toString());
		}
		return stu;
	}
	/////////////// ABONDANDED CODE ///////////////////
}
