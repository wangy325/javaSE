/**
 * 
 */
package com.wangy325.Ex;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author wangy325
 *
 * @date Dec 22, 2017  9:36:57 AM
 *
 * @decription  读取键盘输入, 要求输入整数,并抛出输入异常
 * 
 */
public class ReadInput {

	/**
	 * 新建一个Scanner 要求输入整数, 
	 * 添加一个数组(集合), 来接收输入
	 * 添加一个计数器, 如果输入为整数, 则计数器 自增1;
	 * 否则,抛出 "非法输入异常"
	 * 直至键盘输入了5个整数
	 */
	public static void main(String[] args) {
		ReadInput ri = new ReadInput();
		int[] arr = ri.genIntArray();
		System.out.println(Arrays.toString(arr));
	}

	// 方法1 利用 nextInt() 接收
	public int[] genIntArray() {
		Scanner inte = new Scanner(System.in);
		int[] arr = new int[5];
		int count = 0;
		while (count < 5) {
			try {
				System.out.println("请输入第" + (count + 1) + "个整数:");
				int rec = inte.nextInt();
				// InputMismatchException
				arr[count] = rec;
				count++;
			} catch (Exception e) {
				// e.printStackTrace();
				/**
				 * 这里, nextInt() 发生异常, 键盘输入并没有被读取到 rec 中,
				 * 也没有被其他接收器接收
				 * 进入到 catch 块中, 输出异常信息,
				 * 然后进行下次循环,
				 * 然后 nextInt() 再次尝试接收上次的非法输入...
				 * 如此...
				 * 进入死循环
				 * 所以 用一个 String trash = inte.next(); 
				 * 接收键盘的非法输入
				 */
				@SuppressWarnings("unused")
				String trash = inte.next();
				System.out.println("必须要输入整数");
			}
		}
		inte.close();
		return arr;
	}

	// 方法2 利用 next() 接收,
	// 避免方法1 中如果不接收非法输入, 则出现的死循环问题
	public int[] genIntArray2() {
		Scanner inte = new Scanner(System.in);
		int[] arr = new int[5];
		int count = 0;
		while (count < 5) {
			try {
				/**
				 * 先接收字符串, 然后将字符串转换为整型
				 * 利用 try-catch 接收 NumberFormatException
				 */
				System.out.println("请输入第" + (count + 1) + "个整数:");
				String rec = inte.next();
				// JDK 自动拆箱
				int num = Integer.parseInt(rec);
				arr[count] = num;
				count++;
			} catch (NumberFormatException e) {
				// e.printStackTrace();
				System.out.println("数据格式错误: 必须要输入整数!");
			}
		}
		inte.close();
		return arr;
	}
}
