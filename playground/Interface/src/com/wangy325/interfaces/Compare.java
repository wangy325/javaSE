/**
 * 
 */
package com.wangy325.interfaces;

/**
 * @author wangy325
 *
 * @date Dec 13, 2017  7:13:12 PM
 *
 * @decription  在类中的 初始化的变量 仍是变量
 * 
 * @target TODO
 */
public class Compare {
	// 在类中声明变量 并初始化
	static int MAX_VALUE = 127;

	public static void main(String[] args) {
		// 在 main 方法中再次对变量赋值
		MAX_VALUE = 128;
		System.out.println(MAX_VALUE);
	}
}
/// :~
// 128
// 上述代码若将类改为接口, 编译会报错: the final field Compare.MAX_VALUE cannot be assigned
