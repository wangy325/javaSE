package com.wangy325.demo02;

import java.lang.reflect.Field;
import java.math.BigDecimal;
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
		Connection conn = JUnitsPlus.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			ResultSetMetaData rsmdata = rs.getMetaData();
			List<Element> eleList = addData(rsmdata, rs);
			for(Element ele : eleList) {
				System.out.println(ele);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JUnitsPlus.close(rs, ps, conn);
		}
	}

	/**
	 * @return 
	 * @throws SQLException 
	 * 
	 */
	public static List<Element> addData(ResultSetMetaData rsmdata, ResultSet rs) throws SQLException {
		// 获取表格列数 cc
		Element element = new Element();
		List<Element> eleList = new ArrayList<>();
		while (rs.next()) {
			Map<String, Object> rowData = new TreeMap<>();
			for (int i = 0; i < rsmdata.getColumnCount(); i++) {
				try {
					String colName = rsmdata.getColumnName(i+1);
					// 通过列名拿到该列的常量值
					Object rowConstant = rs.getObject(colName.toString());
					rowData.put(colName, rowConstant);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			// 一行操作完成
			/**
			 * 这个方法将一行中的数据存入 List<Element> 中
			 */
			@SuppressWarnings("unchecked")
			Class<Element> clazz = (Class<Element>) element.getClass();
			// element =genElement(rowData, clazz);
			try {
				eleList.add(genElement(rowData, clazz));
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
	public static Element genElement(Map<String, Object> rowData, Class<Element> clazz) throws Exception {

		Element element = clazz.newInstance();

		Set<Entry<String, Object>> entrySet = rowData.entrySet();
		for (Entry<String, Object> es : entrySet) {
			String key = es.getKey();
			Object value = es.getValue();
			// 获取属性
			Field attri;
			try {
				attri = clazz.getDeclaredField(key.toLowerCase());
				/**
				 * <// 检查属性
				 * System.out.println(attri.toString());
				 */
				// Element 成员变量的属性私有了, setAccessible(true) 保证私有属性能够被访问
				attri.setAccessible(true);
				// 设置属性
				if(value instanceof BigDecimal) 
					attri.set(element, Integer.valueOf(value.toString()));
				else
					attri.set(element, value.toString());
			} catch (Exception e) {
				// 拿不到属性异常 不管他
				//因为只要拿到需要的属性
			}
		}
		return element;
	}
	
	@Test
	public void test() {
		query("SELECT * FROM stu");
	}

}
