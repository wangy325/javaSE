/**
 * 
 */
package com.wangy325.collection.list.ex2;

import java.util.*;

/**
 * @author wangy325
 *
 * @date Dec 19, 2017  2:37:30 PM
 *
 * @decription  List 集合的一些操作
 * 
 * @target TODO
 */
public class UserColl {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		// User[] user = new User[4];
		// 先创建 User 对象
		// for (int i = 0; i < 4; i++) {
		// user[i] = new User();
		// }
		List userList = new ArrayList();
		/**
		 * 以下的添加集合元素的方式容易理解: 将实例化的 User 类作为 元素
		 */
		userList.add(new User("annie", 17));
		userList.add(new User("hellen", 18));
		userList.add(new User("rolex", 21));
		userList.add(new User("time", 16));

		// 无序遍历
		/**
		 * 但是 遍历输出时, userList 集合里的元素是 User 的一个引用, 它不能被 
		 * println() 转化为字符串输出, 输出形式为
		 * 		getClass().getName() + "@" + Integer.toHexString(hashCode());
		 * 具体为
		 * 		com.wangy325.Ex2.User@1218025c;
		 * 因此,
		 * 要在 User 类中重写 toString 方法, 自定义格式化输出
		 */
		System.out.println("disorder traversal:");
		userList.forEach(urs -> System.out.println(urs));

		// 按年龄大小排序
		for (int i = 0; i < userList.size(); i++) {
			for (int j = 0; j < userList.size() - 1 - i; j++) {
				Object temp = "";
				// 以下判断语句中, 想要比较年龄, 须用到 getAge() 方法, userList 元素要用此方法
				// 须转型为 User
				/** 另一种 推荐写法
				 * 	User ul1 = (User)userList.get(j);
				 *	User ul2 = (User)userList.get(j+1);
				 *	if(ul1.getAge() > ul2.getAge()) {
				 *	userList.set(j, ul2);
					userList.set(j + 1, ul1);
				*/
				if (((User) userList.get(j)).getAge() > ((User) userList.get(j + 1)).getAge()) {
					/**if(user[j].getAge() > user[j+1].getAge()){
					 * userList.set(j, user[j+1].getName() + " : " + user[j+1].getAge());  //①
					userList.set(j+1,user[j].getName() + " : " + user[j].getAge());*/
					temp = userList.get(j);
					userList.set(j, userList.get(j + 1));
					userList.set(j + 1, temp);
				}
			}
		}
		/**
		 * bug: 排序过程中第一个 [较大的元素] 只后移一位:
		 * 问题在于 是用user[] 数组进行操作,
		 * if 条件判语句的条件和后面的 ① 表达式 后面的 [element] 变量, 
		 * 它始终是相对于初始化的 user[] 进行的排序, 
		 * 而 user[] 本身在一顿操作后就没变, 变得是 userList
		 * 也即是 排序只进行了一次
		 * 
		 */

		System.out.println("sorted by age:");
		// 遍历之前,要重写 USer 的toString 方法
		userList.forEach(us -> System.out.println(us));
	}
}
