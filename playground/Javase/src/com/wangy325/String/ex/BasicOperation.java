package com.wangy325.String.ex;

/**
 * @author wangy325
 *
 * @date Dec 15, 2017  8:35:43 PM
 *
 * @decription   字符串的基本操作
 */
public class BasicOperation {
	// 成员变量
	// 实例化对象
	// 构造器(参数)
	// 方法(参数)
	static final String str = "this is a test of java.";
	static char[] buf = str.toCharArray(); // 字符串转换为 char[]

	/**求单个字符的个数 */
	static int howManyPreciseChar(char s) {
		int COUNT = 0;
		for (int i = 0; i < str.length(); i++) {
			// char 是基本数据类型
			// 静态方法只能访问静态成员变量， 只能调用静态方法 ？
			if (buf[i] == s) {
				COUNT++;
			}
		}
		return COUNT;
	}

	/**取出指定子字符串*/
	static String getPreciseSubString(String s) {
		// indexOf(String) 方法返回字符串 s 在原字符串的下标开始位置, 即第一个字符的位置
		// 前提是,所有字符都要相同
		// 不符合,则返回 -1
		int a = str.indexOf(s);
		if (a < 0) {
			return "substring do not exist.";
		} else
			return str.substring(a, (s.length() + a));
	}

	/** 将字符串每个单词首字母变成大写*/
	static String turn2Uppercase() {
		String[] buf = str.split(" "); // 字符串数组 元素为字符串 string[]
		String reStr = "";
		/** 方法1: 直接对字符进行操作*/
		/**for (int i = 0; i < buf.length; i++) {
			// 获取 char[]
			char[] subBuf = buf[i].toCharArray(); // 将 String[] 元素变成字符数组 char[]
			// 对单个字符进行 toUpperCase 操作
			subBuf[0] = Character.toUpperCase(subBuf[0]);
			// 将 char[] 转化为 string, 转化的String 为 Sting[] 的元素 buf[i]
			buf[i] = new String(subBuf);
			// 拼接成原字符串
			reStr += buf[i] + " ";
		}*/

		// 方法2: 尝试利用ASCII码值进行操作
		for (int i = 0; i < buf.length; i++) {
			// 获取 char[]
			char[] subBuf = buf[i].toCharArray(); // 将 String[] 元素变成字符数组 char[]
			// 对单个字符的ASCII码进行操作
			int temp = subBuf[0] - 32; // char 可直接转为int 对应为其ASCII码值
			subBuf[0] = (char) temp; // int to char 要强制转换

			buf[i] = new String(subBuf);
			reStr += buf[i] + " ";
		}
		return reStr;
	}

	/** 将字符串倒序输出*/
	static String reverseString() {
		String revStr = "";
		/** 方法1 转换成 char[] 进行操作*/

		/**for (int i = 0; i < buf.length; i++) {
			if (i < buf.length / 2) {
				char temp = buf[i];
				buf[i] = buf[(buf.length - 1) - i];
				buf[(buf.length - 1) - i] = temp;
			}
			revStr += buf[i];
		}*/

		/** 方法2 利用 StringBuffer 类*/

		// 先创建一个 StringBuffer 类, 是一个可变的字符串容器
		// 这意味着可以直接进行字符串操作,而不需要转为 char[]
		StringBuffer strBuf = new StringBuffer(str);
		for (int i = (strBuf.length()); i > 0; i--) {
			revStr += strBuf.substring(i - 1, i);
		}

		/** 方法 3 利用 StringBuffer 的 reverse 方法 反转 字符串*/

		// 返回值是 StringBuffer 类, 不带参数;
		/**
		 * StringBuffer revStrBuf = strBuf.reverse();
		// 将 StringBuffer 转化为 String
		revStr = revStrBuf.substring(0, revStrBuf.length());
		*/
		return revStr;
	}

	/** 字符串替换*/
	static String replaceStr() {
		String repStr = "";
		for (int i = 0; i < buf.length; i++) {
			// 当为空格或标点的时候, 不进行变动
			if ((int) buf[i] == 32 || buf[i] == '.') {
				buf[i] = buf[i];
				repStr += buf[i];
			}
			// 当为普通字符的时候, 将其转化为所需求的格式
			else {
				String temp = buf[i] + "(" + (char) (buf[i] - 32) + ")";
				repStr += temp;
			}
		}
		// 方法2 for 枚举取出子单个字符的字符串, 再用 toUpperCase() 方法转为大写
		// 再进行拼接
		return repStr;
	}

	public static void main(String[] args) {
		System.out.println(BasicOperation.howManyPreciseChar('s'));
		System.out.println(BasicOperation.getPreciseSubString("java"));
		System.out.println(BasicOperation.turn2Uppercase());
		System.out.println(BasicOperation.reverseString());
		System.out.println(BasicOperation.replaceStr());
	}
}
