package com.wangy325.generic;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.wangy325.generic.stu.Student;

/**
 * @author wangy325
 *
 * @date Jan 10, 2018  10:20:26 AM
 *
 * @description    泛型的简单介绍
 * 
 * @tags 
 */
public class Index {
	public static void main(String[] args) {
		/** 
		 * 实际上集合里可以添加多种类型的数据, 但是实际上不建议如此做
		// 上述代码在eclipse 编译过程中就会提示警告信息:
		// --List is a raw type. References to generic type List<E> should be parameterized
		// 而且如果 List 中数据类型 "多种多样" 的, 会给后续对集合元素的操作带来很多麻烦
		// 这就是 for..代码块中要说明的事实
		// 添加泛型, 实际上就是在程序编译过程中进行类型约束及类型检查
		*/
		List arrayList = new ArrayList<>();
		arrayList.add("hello");
		arrayList.add(1000);

		for (int i = 0; i < arrayList.size(); i++) {
			String items = (String) arrayList.get(i);
			String item = arrayList.get(i).toString();
			System.out.println(item);
		}
	}

	@Test
	public void demo() {
		/**
		 * 在集合中运用的最多的就是泛型
		 * 比如定义一个学生类,然后将其封装到一个 List 中, 这是常用操作
		 *  -- > public interface List<E> extends Collection<E>
		 *  可以看到 List 实际上是一个泛型接口, 继承自 Collection 这个接口
		 */
		ArrayList<Student> stuList = new ArrayList<>();
		stuList.add(new Student("kikyo", "female", 18));
		System.out.println(stuList.get(0));
	}
}
