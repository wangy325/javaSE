package map.com.wangy325.Ex2;


/**
 * 
 * @author wangy325
 *
 * @date Dec 26, 2017  4:43:36 PM
 *
 * @decription 创建一个老师类 封装属性  
 */


public class Teacher {
	
	private String  name;
	private String id;
	private Course teacherCourse;
	
	public Teacher() {
		
	}
	
	public Teacher(String id,String name) {
		this.id = id;
		this.name = name;
//		teacherCourse = new HashSet<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public Course getTeacherCourse() {
		return teacherCourse;
	}

	public void setTeacherCourse(Course teacherCourse) {
		this.teacherCourse = teacherCourse;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	

}
