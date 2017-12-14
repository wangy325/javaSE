/**
 * 
 */
package com.wangy325.wrapper;

/**
 * @author wangy325
 *
 * @date Dec 13, 2017  2:42:52 PM
 *
 * @decription  八种基本数据类型的包装器
 * 				包装类和基本数据类型之间, 有值的时候是一样的
 * 				没有值的时候, 基本数据类型的值是 0, 而包装类的值是 null
 * 				
 * 
 * @target TODO
 */
public class Int2String {

	public static void main(String[] args) {
		// Integer integer1 = new Integer(6);
		// int ----> String
		// 1.字符串拼接
		int i1 = 10;
		String s1 = i1 + "";
		s1 = s1 + 6;
		System.out.println(s1);

		// 2.通过包装类转换
		String s2 = Integer.toString(i1);
		System.out.println(s2+1);
		
		// 3.通过 [String] 类的 [静态方法] 转换
		String s3 = String.valueOf(i1);
		System.out.println(s3+7);
		
//		String ---> int
		String s4 = "100011";
//		1. 利用 [Integer] 的静态方法
		int i2 = Integer.parseInt(s4,2);
		System.out.println(i2);
//		2. 利用
		int i3 = Integer.valueOf("129");
		Integer i4 = Integer.valueOf("129");
		/**
		 *  public static Integer valueOf(String s) throws NumberFormatException {
        		return Integer.valueOf(parseInt(s, 10));
    			}
		 */
		System.out.println(i3);
		System.out.println(i3 == i4);
		
		

	}
}
