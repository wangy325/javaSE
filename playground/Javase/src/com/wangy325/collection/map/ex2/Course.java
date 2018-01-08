/**
 * 
 */
package com.wangy325.collection.map.ex2;

/**
 * @author wangy325
 *
 * @date Dec 26, 2017  4:46:36 PM
 *
 * @decription  
 * 
 * @target TODO
 */
public class Course {
	private String name;
	private String id;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Course (String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	
	public Course(String id, String name) {
		super();
		this.name = name;
		this.id = id;
	}
	
	 

}
