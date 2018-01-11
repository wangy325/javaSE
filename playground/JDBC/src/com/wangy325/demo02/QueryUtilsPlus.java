package com.wangy325.demo02;

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

/**
 * @author wangy325
 *
 * @date Jan 8, 2018 7:24:42 PM
 *
 * @description 封装数据库的查询为一个工具类
 *              升级为泛型方法, 方便查询任意表格的数据
 *              基本实现:
 *              1. 读取表的数据, 存入 ResultSetMetaData 中, 这其中本封装了一些表的信息
 *              最终实现:
 *              2. 将表的一行数据作为一个对象, 其中 列名作为对象属性, 存入一个 LIST 中
 * 
 *              HOWTO:
 *              1. RSMD 可获取列名和元素, 将其作为 KEY-VALUE 存入 MAP 中
 *              2. 遍历 MAP 获取 VALUE 值, 通过反射拿到 [行对象] 的 [列名]属性,
 *              并将 VALUE 值给这个属性
 *              3. 遍历输出 LIST
 * 
 */
public class QueryUtilsPlus {

	public static <T> void query(String sql, Class<T> clazz) throws Exception {
		Connection conn = JUnitsPlus.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			List<T> eleList = addData(rs, clazz);
			for (T ele : eleList) {
				System.out.println(ele);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JUnitsPlus.close(rs, ps, conn);
		}
	}

	public static <T> List<T> addData(ResultSet rs, Class<T> clazz) throws Exception {
		/**
		 * 通过反射获取实例化对象的时候, 调用的是类的隐式构造器
		 *  @class Creates a new instance of the class represented by this {@code Class}
         * 				   object.  The class is instantiated as if by a {@code new}
         *				   expression with an empty argument list.  The class is initialized if it
         * 				   has not already been initialized
         * 所以, 要实例化的类, 必然需要一个无参构造器
         * 不然会出现实例化异常 InstantiationException
		 */
		T t = clazz.newInstance();
		List<T> eleList = new ArrayList<>();
		ResultSetMetaData rsmdata = rs.getMetaData();
		Map<String, Object> rowData = new TreeMap<>();
		while (rs.next()) {
			for (int i = 0; i < rsmdata.getColumnCount(); i++) {
				try {
					String colName = rsmdata.getColumnName(i + 1);
					// 通过列名拿到该列的常量值
					Object rowConstant = rs.getObject(colName.toString());
					rowData.put(colName, rowConstant);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			// 一行操作完成
			/**
			 * 这个方法将一行中的数据存入 List<T> 中
			 */
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
			// 获取属性
			Field attri;
			try {
				attri = clazz.getDeclaredField(key.toLowerCase());
				/*
				 * <// 检查属性
				 * System.out.println(attri.toString());
				 * // Element 成员变量的属性私有了, setAccessible(true) 保证私有属性能够被访问
				 */
				attri.setAccessible(true);
				/**
				 * 设置属性
				 * 数据库数据属性 : NUMBER(7,2)
				 * 转换成 java 数据类型: Number -- > Double
				 * instanceof 操作符后面不能写 Double , 否则取出 null
				 */
				if (value instanceof Number)
					attri.set(t, Double.valueOf(value.toString()));
				else
					attri.set(t, value.toString());
			} catch (Exception e) {
				// 拿不到属性异常 不管他
				// 因为只要拿到需要的属性
			}
		}
		return t;
	}

	@Test
	public void test() {
		try {
			query("SELECT * FROM emp", EMP.class);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
