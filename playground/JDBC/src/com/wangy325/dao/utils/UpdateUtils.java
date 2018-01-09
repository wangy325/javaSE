package com.wangy325.dao.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author wangy325
 *
 * @date Jan 9, 2018  10:13:13 AM
 *
 * @description   
 * 
 * @tags 
 */
public class UpdateUtils {
	/**
	 * 执行 SQL 语句的工具方法类
	 */

	public static int update(String sql, Object...obj) {
		Connection conn = JdbcUtils.getConn();
		PreparedStatement ps = null;
		try {
			 ps = conn.prepareStatement(sql);
			 /**
			  * 执行 sql 语句
			  * 可变参数列表可以直接获取长度
			  */
			 for(int i= 0; i< obj.length;i++) {
				 ps.setObject((i+1), obj[i]);
			 }
			 // 执行完毕 获取返回值
			 return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.closeAll(ps,conn);
		}
		// 失败 返回 0
		return 0;
		
	} 
}
