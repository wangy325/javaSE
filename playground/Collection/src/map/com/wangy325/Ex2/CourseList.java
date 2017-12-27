package map.com.wangy325.Ex2;

import java.util.ArrayList;
import java.util.List;

public class CourseList {
	
	List<Course> courses;
	
	public CourseList() {
		super();
		courses = new ArrayList<Course>();
	}
	
	// 初始化课程信息
		public void IniCourses() {
			courses.add(new Course("1", "CoreJava"));
			courses.add(new Course("2", "Oracle"));
			courses.add(new Course("3", "JDBC"));
			courses.add(new Course("4", "Unix"));
			courses.add(new Course("5", "JSP"));
		}
		
		public void showCoursesInfo() {
			for(Course crs:courses) {
				System.out.println("课程ID: "+ crs.getId()+", 课程名字"+crs.getName());
			}
		}

}
