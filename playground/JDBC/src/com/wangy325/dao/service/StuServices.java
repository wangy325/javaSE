package com.wangy325.dao.service;

import com.wangy325.dao.bean.Student;
import com.wangy325.dao.dao.StuDaoImp;
import com.wangy325.dao.exception.StuException;

/**
 * @author wangy325
 *
 * @date Jan 9, 2018  9:55:12 AM
 *
 * @description   
 * 
 * @tags 
 */
public class StuServices {
	private StuDaoImp sdi ;
	public StuServices() {
		this.sdi = new StuDaoImp();
	}

	// 添加学生
	public boolean inStudent(Student stu) throws StuException {
		try {
			return sdi.insertStu(stu);
		} catch (Exception e) {
			throw new StuException("创建学生失败");
		}
	}
	
	// 删除学生
	public boolean delStudent(String name) throws StuException {
		try {
			return sdi.deleteStu(name);
		} catch (Exception e) {
			// 自定义一个异常
			throw new StuException("删除失败, 学生不存在");
		}
	}
	// 修改学生信息
	public boolean reStudent(String name , Student stu) throws StuException{
		try {
			return sdi.updateStu(name, stu);
		} catch (Exception e) {
			throw new StuException("修改学生信息失败");
		}
	}
	
	// 查询学生信息
	public Student queryStudent(String name) throws StuException{
		
		try {
			return sdi.queryStu(name);
		} catch (Exception e) {
			throw new StuException("未查询到学生信息");
		}
		
	}
}
