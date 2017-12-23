/**
 * 
 */
package com.wangy325.Ex;

import java.util.Scanner;

/**
 * @author wangy325
 *
 * @date Dec 22, 2017  10:49:59 AM
 *
 * @decription  测试自定义异常抛出
 * 
 */
public class TriangleTest {

	/**
	 * 定义三个 double 型变量, 读取键盘输入,将其保存到数组中
	 * 写一个方法 cTriangle(double a,double b,double c), 判断整形数组的三个元素能否组成三角形
	 * 并抛出不能组成三角形的异常
	 * 在main 方法中调用该方法, 如果能组成,则, 输出"能组成三角形"
	 * 否则, 捕获异常信息
	 */
	public static void main(String[] args) {
		Scanner inte = new Scanner(System.in);
		double[] arr = new double[5];
		int count = 0;
		while (count < 3) {
			try {
				System.out.println("请输入三角形的第" + (count + 1) + "条边:");
				double rec = inte.nextDouble();
				// InputMismatchException
				arr[count] = rec;
			} catch (Exception e) {
				// e.printStackTrace();
				@SuppressWarnings("unused")
				String trash = inte.next();
				System.out.println("错误: 必须要输入数字!");
				count--;
			}
			count++;
		}
		inte.close();
		TriangleTest tc = new TriangleTest();
		try {
			if (tc.cTriangle(arr[0], arr[1], arr[2]))
				System.out.println(arr[0] + ","+arr[1] + ","+arr[2]+" 能组成三角形");
				;
		} catch (TriangleExceptin e) {
			// e.printStackTrace();
			System.out.println("提示:"+arr[0] + ","+arr[1] + ","+arr[2] + e.getMessage());
		}
	}

	private boolean cTriangle(double a, double b, double c) throws TriangleExceptin {
		if ((a + b) > c && (a + c) > b && (b + c) > a) {
			return true;
		} else {
			throw new TriangleExceptin(" 不能组成三角形");
		}
	}

}
