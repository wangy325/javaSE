package com.wangy325.operator;

/**
 * @author wangy325
 *
 * @date Jan 29, 2018-- 1:40:59 PM
 *
 * @description Java 中的位运算举例
 */
public class BinaryOperator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(leftMove(-1));
		System.out.println(Integer.toBinaryString(12));
		// 期望得到 63
		int x =  0b11111110;
		int y = -2;
		System.out.println(rightMove(x)); //:~ 63
		System.out.println(rightMove(y)); //:~ 1073741823
		System.out.println(0b00111111); //:~ 63
		// 强转溢出
		System.out.println((byte)1209);
		int a = 1, b = 2;
		  a = a^b &b;
		  b = -(~a+a);
		  System.out.println("a =" +a +", b="+b);
	}
	
	public static int leftMove(int num) {
		num = num<<10;
		return num;
	}
	public static int rightMove(int num) {
		// 无符号右移运算
		num =   (num >>> 2);	
		return num;
	}

}
