package com.wangy325.collection.set.ex1;

/**
 * 
 * @author wangy325
 *
 * @date Dec 25, 2017  2:02:28 PM
 *
 * @decription  
 * 
 */
public class Employee {
	private String name, age, salary;

	public Employee() {
	}

	public Employee(String name, String age, String salary) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/*@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Employee))
			return false;
		Employee other = (Employee) obj;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}*/

	@Override
	/**
	 * 重写 equals 方法来判断 Set 中是否已经存在 Employee 对象
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Employee))
			return false;
		Employee employee = (Employee) obj;
		// 判断名字和年龄
		if (this.name == null && this.age == null) {
			if (employee.name == null && employee.age == null)
				return true;
			else
				return false;
		}
		if (this.age == null) {
			if (employee.age.equals(this.name) && employee.age == null)
				return true;
			else
				return false;
		}
		if (this.name == null) {
			if (employee.name == null && employee.age.equals(this.age))
				return true;
			else
				return false;
		}
		else {
			if (employee.name.equals(this.name) && employee.age.equals(this.age))
				return true;
			else
				return false;
		}
	}

	
	}


