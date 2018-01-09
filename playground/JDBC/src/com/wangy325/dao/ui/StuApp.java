package com.wangy325.dao.ui;

import com.wangy325.dao.bean.Student;
import com.wangy325.dao.exception.StuException;
import com.wangy325.dao.service.StuServices;
import com.wangy325.dao.utils.InputUtils;
import com.wangy325.dao.utils.MenuUtils;

/**
 * @author wangy325
 *
 * @date Jan 9, 2018  9:33:01 AM
 *
 * @description   学生信息修改的主界面
 * 
 * @tags 
 */
public class StuApp {
	private static StuServices ss = new StuServices();
	private static Student stu = new Student();

	public static void main(String[] args) {
		// 显示开始菜单
		MenuUtils.start();
		int choice = InputUtils.inputInt("请选择要进行的操作:");
		switch (choice) {
		case 1: // 新建学生
			String name = InputUtils.inputStr("请输入新建学生的姓名:");
			stu.setSname(name);
			Integer age = InputUtils.inputInt("请输入新建学生的年龄:");
			stu.setSage(age);
			String gender = InputUtils.inputStr("请输入新建学生的性别:");
			stu.setSgender(gender);
			InputUtils.closeConsole();
			try {
				System.out.println(ss.inStudent(stu) ? "新建成功" : "新建失败");
			} catch (StuException e1) {
				e1.printStackTrace();
			}
			break;
		case 2: // 删除学生
			String str = InputUtils.inputStr("请输入要删除的学生名字:");
			InputUtils.closeConsole();
			try {
				System.out.println(ss.delStudent(str) ? "删除成功" : "删除失败");
			} catch (StuException e) {
				e.printStackTrace();
			}
			break;
		case 3: // 修改学生
			String sname = "";
			System.out.println("请输入要修改信息的学生名字");
			while(true) {
				sname = InputUtils.inputStr("");
				try {
					if (ss.queryStudent(sname) == null)
						System.out.println("学生不存在,请重新输入");
					else
						break;
				} catch (StuException e) {
					e.printStackTrace();
				}
			}
			/**
			 * 请试图解决输入学生不存在的问题
			 * 1. 输入学生名字进行判断
			 * 2. 不存在直接推出方法, 不执行后续操作.
			 */
			Integer newage = InputUtils.inputInt("请输入修改后的学生年龄:");
			stu.setSage(newage);
			String newgender = InputUtils.inputStr("请输入修改后的学生性别:");
			stu.setSgender(newgender);
			InputUtils.closeConsole();
			try {
				System.out.println(ss.reStudent(sname, stu) ? "修改成功" : "修改失败..");
			} catch (StuException e) {
				e.printStackTrace();
			}
			break;
		case 4: // 查询学生信息
			String qname = InputUtils.inputStr("请输入要查询的学生名字:");
			InputUtils.closeConsole();
			try {
				/**
				 * 存在 null 值问题
				 * 1. 获取学生对象
				 * 2. 由于方法的原因, 当输入的学生名字不存在的时候, 返回的是一个空 Student 对象
				 */
				 if (ss.queryStudent(qname) == null)
				 System.out.println("不存在指定学生");
				 else
				 System.out.println(ss.queryStudent(qname));
			} catch (StuException e) {
				e.printStackTrace();
			}
			break;
		default:
			return;
		}
	}

}
