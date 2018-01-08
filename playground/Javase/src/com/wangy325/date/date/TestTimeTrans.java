/**
 * 
 */
package com.wangy325.date.date;

/**
 * @author wangy325
 *
 * @date Dec 22, 2017  2:57:40 PM
 *
 * @decription  测试时间转换
 * 
 * @target TODO
 */
public class TestTimeTrans {

	public static void main(String[] args) {
		Time2String ttt = new Time2String();
		String strDate = ttt.long2String();
		System.out.println(strDate);
		long longTime = ttt.string2Long();
		System.out.println(longTime);
	}

}
