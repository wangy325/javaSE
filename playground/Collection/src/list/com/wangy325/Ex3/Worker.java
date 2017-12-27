/**
 * 
 */
package list.com.wangy325.Ex3;

/**
 * @author wangy325
 *
 * @date Dec 19, 2017  5:38:30 PM
 *
 * @decription   重点在于重写了 Worker 的 equals 方法
 * 
 */
public class Worker {
	private String name;
	private int age, salary;

	public Worker() {
	}

	public Worker(String name, int age, int salary) {
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public void showInfo() {
		System.out.println(name + ":" + age + ":" + salary);
	}

	// 为 Worker 类重写 equals 方法
	// TODO: 判断集合元素中是否存在 Worker 对象
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Worker) { // ①
			/**
			 * instanceof 操作符就是典型的 [向下转型]啊
			 * 因为传入的参数是 Object对象, 其不存在 getName()等 Worker 类的方法
			 * 所以必须用 ①判断是否能转, 再用 ② 进行强转
			 *  * 加入 instanceof 代码更加健康
			 */
			Worker wker = (Worker) obj;// ②
			/**
			 * 为了解决 字符串成员变量为 null 导致的 [空指针] 错误, 还需要判空 式 ③
			 * 这样代码更加健康
			 */
			if (wker.getName() == null || name == null) {// ③
				return false;
			} else if (name.equals(wker.getName()) && age == wker.getAge() && salary == wker.getSalary()) {
				return true;
			}
		}
		return false;
	}
}
