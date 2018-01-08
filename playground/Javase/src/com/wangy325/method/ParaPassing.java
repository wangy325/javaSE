/**
 * 
 */
package com.wangy325.method;

/**
 * @author wangy325
 *
 * @date Dec 7, 2017  6:32:57 PM
 *
 * @decription  方法参数的传递
 * 
 * @target TODO
 */
public class ParaPassing {
	
	public static void m1(int para) {
		para = 100;
	}
	public static void m2(String [] arr) {
		arr[0] = "hello world";
	}
	
	public static void m3(String str) {
		str = "hello kitty";
	}
	public static void main(String[] args) {
		int a = 20;
		System.out.println("调用方法之前的a值为:"+a);
		m1(a);
		System.out.println("调用方法之后的a值为:"+a);
		
		String [] arr = {"hello"};
		System.out.println("调用方法之前的arr[0]值为:"+ arr[0]);
		m2(arr);
		System.out.println("调用方法之前的arr[0]值为:"+ arr[0]);
		
		String string = "kongfu panda";
		System.out.println("调用方法之前的String值为:"+ string);
		m3(string);
		System.out.println("调用方法之后的String值为:"+ string);
	}
}
///~: 
/*		调用方法之前的a值为:20
		调用方法之后的a值为:20
		调用方法之前的arr[0]值为:hello
		调用方法之前的arr[0]值为:hello world
		调用方法之前的String值为:kongfu panda
		调用方法之后的String值为:kongfu panda
*/
// 解释:
// 基本数据类型 存放与栈(stack) 中, 作为方法参数的时候,是按照值传递的
// 引用数据类型 存放在堆(heap) 中,作为方法参数的时候, 是按照[引用值]传递的, 这个[引用值] 是指存放在栈中的指向堆内存的[指针]
// 虽然在 java 中尽量不使用[指针]这个术语, 而倾向认为 栈中存放的是其的一个[引用]
// 值得一提的是,虽然 String 在java中不是基本类型, 而是一个对象,但是, 其在方法中的参数传递过程中, 是和基本数据类型一致的 


