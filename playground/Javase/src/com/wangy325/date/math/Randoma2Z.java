/**
 * 
 */
package com.wangy325.date.math;

import java.util.Random;

/**
 * @author wangy325
 *
 * @date Dec 22, 2017  3:22:17 PM
 *
 * @decription  尝试随机生成一个英文字母, 大小写均可
 * 
 */
public class Randoma2Z {

	/**
	 *  写一个方法 randomNumber(),随机一个 65-90 之间的 数字
	 *  写另一个方法,randomNumberPlus(),随机将数字加上 32 (小写字母的 ascii 码值比大写字母大 32)
	 *  在main 方法中调用 randomNumberPlus() 方法, 将获得的数字转换成 char
	 *  输出 
	 */
	public static void main(String[] args) {
		Randoma2Z r2z = new Randoma2Z();
		int num = r2z.randomNumberPlus();
		char lin = (char)num;
		System.out.println(lin);
	}

	public int randomNumber() {
		Random random = new Random();
		int num = 65;
		num = num + random.nextInt(15);
		return num;
	}
	public int randomNumberPlus() {
		int num = randomNumber();
		Random random = new Random();
		// 随机生成一个 boolean 值 true 和 false 的概率是 50%
		boolean flag = random.nextBoolean();
		if (flag)
			num += 32;
		return num;

	}

}
