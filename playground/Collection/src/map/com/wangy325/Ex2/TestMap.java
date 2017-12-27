/**
 * 
 */
package map.com.wangy325.Ex2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

/**
 * @author wangy325
 *
 * @date Dec 26, 2017  4:48:02 PM
 *
 * @decription  创建老师 --教授课程的 Map 集合, 进行一些操作
 * 
 */
public class TestMap {

	Map<Teacher, Course> courseMap;
	Scanner console;

	public TestMap() {
		courseMap = new HashMap<Teacher, Course>();
		console = new Scanner(System.in);
	}

	// 先初始化老师与课程的映射关系
	public void iniCourseMap() {
		TeacherList tl = new TeacherList();
		tl.iniTeachers();
		CourseList cl = new CourseList();
		cl.IniCourses();
		courseMap.put(tl.teachers.get(0), cl.courses.get(0));
		courseMap.put(tl.teachers.get(1), cl.courses.get(1));
		courseMap.put(tl.teachers.get(2), cl.courses.get(1));
		courseMap.put(tl.teachers.get(3), cl.courses.get(2));
		courseMap.put(tl.teachers.get(4), cl.courses.get(3));
		courseMap.put(tl.teachers.get(5), cl.courses.get(4));
		courseMap.put(tl.teachers.get(6), cl.courses.get(4));
	}

	// 老师选课完成, 输出 Map 中的老师--> 课程的映射关系
	public void testPrintMap() {
		Set<Entry<Teacher, Course>> entrySet = courseMap.entrySet();
		for (Entry<Teacher, Course> es : entrySet) {
			System.out.println("老师 " + es.getKey().getId() + " " + es.getKey().getName() + " 选择了课程 "
					+ es.getValue().getId() + " " + es.getValue().getName());
		}
	}

	// 老师选课
	/**
	 * 0. 获取初始化的数据
	 * 1. 是否新增老师? 
	 * 		是: 输入新增老师ID,并准备为新老师选课;
	 * 			id 是否存在,
	 * 				是, 提示信息: id 已经存在 请重新输入..
	 * 				否, 输入的老师名字是否已经存在?
	 * 					是, 提示信息, 名字已经存在, 请重新输入
	 * 					否, 添加老师,并开始为老师选课
	 * 						输入课程ID是否存在?
	 * 							是, 选课成功,
	 * 							否, 重来
	 * 					  
	 * 		否, 询问是否修改现有老师-->课程映射?
	 * 			是..修改当前映射
	 * 			否..退出
	 */
	public void seletectCourses() {
		// 导入初始化数据
		// iniCourseMap();
		TeacherList tl = new TeacherList();
		System.out.println("是否新增老师?(y/n)");
		String judge = console.next();
		if (judge.equalsIgnoreCase("y")) {
			/**
			 * 新增老师并为其选课
			 * 调用 addTeacher() 方法
			 */
			// addTeacher() 返回一个 Map..
			courseMap = tl.addTeacher();
			System.out.println("新增老师后的老师信息");
			tl.showTeacherInfo();
		} else {
			System.out.println("是否修改现有老师的选课信息?(y/n)");
			String juddge = console.next();
			if (juddge.equalsIgnoreCase("y")) {

				/**
				 * 修改信息
				 */
				courseMap = tl.modifySelection();

			} else
				return;
		}
		System.out.println("修改后的老师课程映射表为:");
		testPrintMap();
	}

	public static void main(String[] args) {
		TestMap tm = new TestMap();
		tm.iniCourseMap();
		tm.testPrintMap();
		tm.seletectCourses();

	}

}
