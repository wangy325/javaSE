package com.wangy325.dao.dao;

import com.wangy325.dao.bean.Student;
import com.wangy325.dao.utils.CheckUtils;
import com.wangy325.dao.utils.QueryUtils;
import com.wangy325.dao.utils.UpdateUtils;

/**
 * @author wangy325
 *
 * @date Jan 9, 2018  10:11:37 AM
 *
 * @description   
 * 
 * @tags 
 */
public class StuDaoImp implements StuDao {

	@Override
	/**
	 * 读取键盘输入插入学生
	 */
	public boolean insertStu(Student stu) throws Exception {
		if (UpdateUtils.update("insert into stu(sname,sage,sgender) values(?,?,?)", stu.getSname(), stu.getSage(),
				stu.getSgender()) > 0)
			return true;
		return false;
	}

	@Override
	/**
	 * 通过名字删除学生
	 */
	public boolean deleteStu(String name) throws Exception {

		if (UpdateUtils.update("delete from stu where sname = ?", name) > 0)
			return true;

		return false;
	}

	@Override
	/**
	 * 输入学生名字, 更新学生属性
	 */
	public boolean updateStu(String name, Student stu) throws Exception {
		int i = UpdateUtils.update("update stu set sage=?,sgender=? where sname=?", stu.getSage(), stu.getSgender(),
				name);
		if (i > 0)
			return true;

		return false;
	}

	/**
	 * 通过学生名字查询学生信息
	 * 执行 SQL 语句, 查询到指定name的学生信息, 并返回学生对象
	 */
	@Override
	public Student queryStu(String name) throws Exception {
		return QueryUtils.query(name);
	}

	/**
	 *  检查名字输入, 用来判断学生是否存在
	 *  学生名字具有唯一性
	 * @param name
	 * @return boolean
	 */
	public boolean check(String name) {
		if (CheckUtils.check(name))
			return true;
		return false;

	}

}
