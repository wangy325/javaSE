/**
 * 
 */
package map.com.wangy325.Ex4;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author wangy325
 *
 * @date Dec 27, 2017  4:25:24 PM
 *
 * @decription  统计一个任意字符串中的每个字符出现的个数, 
 * 				并且将 字符-->个数 这个键值对存储到 Map 中
 * 
 */
public class MapChar {

	Map<Character, Integer> charMap;

	public MapChar() {
		charMap = new HashMap<Character, Integer>();
	}

	/**
	 * 1. 调用 getSortedString() 方法, 获取排序好的字符串
	 * 2. 可以将字符串转换为 char[] 进行操作
	 * 3. 也可以直接利用 字符串 charAt 进行操作
	 * 4. 思考能不能在 charList 里面直接统计呢?
	 */

	public void writeMap() {
		StringList sl = new StringList();
		String str = sl.getSortedString();
		// 把 字符串转换成 char[]
		char[] charArr = str.toCharArray();
		int COUNT = 1;
		for (int i = 0; i < charArr.length; i += COUNT) {
			COUNT = 1;
			for (int j = i; j < charArr.length - 1;j++) {
				if (charArr[j] == charArr[j + 1]) {
					COUNT++;
				} else
					break;
			}
			charMap.put(charArr[i], COUNT);
		}
	}

	// 遍历输出 Map 内容 为了练习利用 key 值遍历
	// 一般利用 entrySet
	public void printMap() {
		// 利用 keySet 方法获取 "键" 的 Set 集合
		Set<Character> keySet = charMap.keySet();
		for (Character key : keySet) {
			int value = charMap.get(key);
			if (value != 0)
				System.out.println("键: " + key + " 值: " + value);
		}
	}

	public static void main(String[] args) {
		MapChar mc = new MapChar();
		mc.writeMap();
		mc.printMap();

	}

}
