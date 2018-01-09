package com.wangy325.dao.dao;

import com.wangy325.dao.bean.Student;

/**
 * @author wangy325
 *
 * @date Jan 9, 2018  9:55:23 AM
 *
 * @description   DAO 层是进行数据库操作的代码区
 * 
 * @tags 
 */
public interface StuDao {

	// insert by student instance
	public boolean insertStu(Student stu) throws Exception;

	// delete by name
	public boolean deleteStu(String name) throws Exception;

	// revice by name
	public boolean updateStu(String name, Student stu) throws Exception;

	// query by student name
	public Student queryStu(String name) throws Exception ;
}
