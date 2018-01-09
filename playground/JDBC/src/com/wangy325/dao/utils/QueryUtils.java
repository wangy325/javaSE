package com.wangy325.dao.utils;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import org.junit.Test;

import com.wangy325.dao.bean.Student;

/**
 * @author wangy325
 *
 * @date Jan 9, 2018  1:44:07 PM
 *
 * @description   
 * 
 * @tags 
 */
public class QueryUtils {
	private static Student stu = new Student();

	/**
	 * 查询指定姓名的学生
	 * @param String name
	 * @return 如果学生存在,则返回这个学生实例; 如果学生不存在, 则返回null
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static Student query(String name) throws Exception {
		Connection conn = JdbcUtils.getConn();
		String sql = "SELECT * FROM STU WHERE SNAME=" + "'" + name + "'";
		// System.out.println(sql);
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			// System.out.println(ps.executeUpdate());
			/**
			 * 这里, 由于 SQL 语句执行没有匹配项目 返回的是 0 rows selected 
			 * 并不会报错
			 * 这里要进行处理, 以免返回空对象
			 * getRow() 方法
			 * @return the current row number; 0 if there is no current row
			 * 这个方法返回的是当前正在操作的 row number
			 * 并不能实现 空对象判断
			 */
			if (ps.executeUpdate() == 0) {
				return null;
			} else {
				rs = ps.executeQuery();
				Map<String, Object> rowMap = getMap(rs);
				@SuppressWarnings("unchecked")
				Class<Student> clazz = (Class<Student>) stu.getClass();
				return reflectStudent(rowMap, clazz);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeAll(rs, conn);
		}
		return null;
	}

	/**
	 * 将指定学生的列 --> 列常量(值)存入 TreeMap 中, 并返回
	 * @param rs
	 * @return Map<String, Object>
	 * @throws SQLException
	 */
	public static Map<String, Object> getMap(ResultSet rs) throws SQLException {
		ResultSetMetaData rsmdata = rs.getMetaData();
		int colCount = rsmdata.getColumnCount();
		Map<String, Object> rowMap = new TreeMap<String, Object>();
		/**
		 * KEY --> COLNAME
		 * VALUE --> CONSTANT
		 */
		// 其实这里执行 SQL 语句之后只返回了一行数据(或者0行数据)

		while (rs.next()) {
			// System.out.println(rs.getRow());
			for (int i = 0; i < colCount; i++) {
				/** 获取列名 和 stu 的属性对应
				 *  如果想在方法执行过程中,获取 stu 类的属性, 就要用到反射
				/**
				 * 要判断 colName 和 stu 属性是否相等, 以便于给实例化 stu 对象
				 * 前面已经说了, 这里要拿到 stu 的属性, 最好的是用反射, 进行动态获取
				 * 
				 * 另外一种愚钝的方法, 用 list 将 stu 的属性封装成静态, 然后遍历比较
				 * 也是可以实现的. 这样操作的话, 代码欠缺灵活性
				 */
				String colName = rsmdata.getColumnLabel(i + 1);
				Object obj = rs.getObject(i + 1);
				rowMap.put(colName, obj);
				// 上述操作将一行的 colName --> Constant 键值对存入 rowMap 中
			}
		}
		return rowMap;
	}

	/**
	 * @param Map<String,Object> rowConstant, clazz
	 * @return  Student Instance
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 * 
	 */
	public static Student reflectStudent(Map<String, Object> rowMap, Class<Student> clazz) throws Exception {
		// 通过反射拿到一个实例化的 Student 对象
		Student newStuInstance = clazz.newInstance();
		// 获取 rowConstant 的键值对
		Set<Entry<String, Object>> entrySet = rowMap.entrySet();
		for (Entry<String, Object> es : entrySet) {
			// 通过 get() 拿到 键和值
			String KEY = es.getKey();
			Object VALUE = es.getValue();
			// 通过反射拿到 newIstance 的属性
			Field field = clazz.getDeclaredField(KEY.toLowerCase());
			// 跳过安全检查
			field.setAccessible(true);
			/**
			 * 这里就要实现之前设想的, 比对属性, 如果属性对应, 则给该属性添加值
			 */
			if (VALUE instanceof BigDecimal)
				// 如果数据库声明 NUMBER(*) 数据类型会提升为 BigDecimal
				field.set(newStuInstance, Integer.parseInt(VALUE.toString()));
			else if (VALUE instanceof String) {
				/**
				 * 每次遍历取出一个value,只需要判断其可能的数据类型, 
				 * 然后 填入通过反射拿到的属性就好了
				 */
				// if (field.toString().equals("sname"))
				field.set(newStuInstance, VALUE.toString());
				// else
				// field.set(newStuInstance, VALUE.toString());
			}
		}
		return newStuInstance;
	}

	@Test
	public void testQuery() {
		try {
			stu = QueryUtils.query("lucy");
			if (stu == null)
				System.out.println("不存在指定学生");
			else
				System.out.println(stu);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
