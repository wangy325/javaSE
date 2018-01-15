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
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import org.junit.Test;

import com.wangy325.libsystem.bean.Lib;
import com.wangy325.libsystem.bean.Stu;

/**
 * 
 * @author wangy325
 *
 * @date Jan 13, 2018-- 3:52:03 PM
 *
 * @description
 *
 */

public class QueryUtil {

	public static <T> List<T> queryAll(String sql, Class<T> clazz) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = C3p0Util.getConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			return addData(rs,clazz);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			C3p0Util.close(rs, ps, conn);
		}
		return null;
	}

	public static <T> List<T> addData(ResultSet rs, Class<T> clazz) throws Exception {
		T t = clazz.newInstance();
		List<T> eleList = new ArrayList<>();
		ResultSetMetaData rsmdata = rs.getMetaData();
		Map<String, Object> rowData = new TreeMap<>();
		while (rs.next()) {
			for (int i = 0; i < rsmdata.getColumnCount(); i++) {
				try {
					String colName = rsmdata.getColumnName(i + 1);
					Object rowConstant = rs.getObject(colName.toString());
					rowData.put(colName, rowConstant);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			@SuppressWarnings("unchecked")
			Class<T> clas = (Class<T>) t.getClass();
			try {
				eleList.add(genElement(rowData, clas));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return eleList;
	}

	/**
	 * @param rowData
	 * @param clazz
	 * @return
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public static <T> T genElement(Map<String, Object> rowData, Class<T> clazz) throws Exception {
		T t = clazz.newInstance();
		Set<Entry<String, Object>> entrySet = rowData.entrySet();
		for (Entry<String, Object> es : entrySet) {
			String key = es.getKey();
			Object value = es.getValue();
			Field attri;
			try {
				attri = clazz.getDeclaredField(key.toLowerCase());
				attri.setAccessible(true);
				if (value instanceof Number)
					attri.set(t, Integer.valueOf(value.toString()));
				else if (value instanceof String)
					attri.set(t, value.toString());
			} catch (Exception e) {
				// ignore the no need fields
			}
		}
		return t;
	}

	@Test
	public <T>void test() {
		try {
//			queryAll("SELECT * FROM Stu", Stu.class);
			queryAll("SELECT * FROM Library", Lib.class);
			
			@SuppressWarnings("unchecked")
			List<T> eleList = (List<T>) queryAll("SELECT * FROM Stu", Stu.class);
			for (T ele : eleList) {
				System.out.println(ele);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
