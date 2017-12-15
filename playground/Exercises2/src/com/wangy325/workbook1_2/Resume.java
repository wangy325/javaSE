/**
 * 
 */
package com.wangy325.workbook1_2;

/**
 * @author wangy325
 *
 * @date Dec 14, 2017  10:14:40 AM
 *
 * @decription   封装类,的方法
 * 
 * @target TODO
 */
public class Resume {
	private String name,address,degree;
	private String gender;
	private int age;
	
//	构造器初始化
	public Resume (String name, String address, String degree) {
		this.name = name;
		this.address = address;
		this.degree = degree;
	}
// set get age and gender
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		if(gender == "male" || gender == "female") {
			this.gender = gender;
		}
		else
			this.gender = "male";
			return ;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if(age > 60 || age < 18 ) {
			System.out.println("rejected. too young(old) to apply for a job");
			return;
		}
		else
			this.age = age;
	}
	
	public void showInfo() {
		System.out.print("The basical information of interviwee:\n");
		System.out.print("name: "+name+"\t\tgender: "+gender+"\t\tage: "+getAge()+"\ndegree: "+degree+"\taddress: "+address);
	}
	
	public static void main(String[] args) {
		Resume resume1 = new Resume("alart", "R.craeator #178", "bachelor");
		resume1.setGender("normal");
		resume1.setAge(76);
		resume1.showInfo();
		
		
	}
	
}
