/**
 * 
 */
package com.wangy325.String.ex;

/**
 * @author wangy325
 *
 * @date Dec 16, 2017  12:21:23 PM
 *
 * @decription  统计字符串中的以特定字符开头或结尾的字符数字
 * 				另一种思路:
 * 					1. 变为 char[];
 * 					2. 进行条件判断
 * @target TODO
 */
public class RegExpression {
	static String strings[] = { "string", "starting", "strong", "street", "stir", "studeng", "soft", "sting" };

	static int howManyStartWith() {
		int COUNT = 0;
		for (int i = 0; i < strings.length; i++) {
			// 匹配 以st开头的元素
			if (strings[i].matches("^st.+$")) {
				COUNT++;
			}
		}
		return COUNT;
	}
	static int howManyEndWith() {
		int COUNT = 0;
		for (int i = 0; i < strings.length; i++) {
			// 匹配 以ng结尾的元素
			if (strings[i].matches("^.+ng$")) {
				COUNT++;
			}
		}
		return COUNT;
	}

	public static void main(String[] args) {
		System.out.println(RegExpression.howManyStartWith());
		System.out.println(RegExpression.howManyEndWith());
		
	}
}
