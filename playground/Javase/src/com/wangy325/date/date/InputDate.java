/**
 * 
 */
package com.wangy325.date.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author wangy325
 *
 * @date Dec 21, 2017  2:20:32 PM
 *
 * @decription  读取键盘输入, 将数据存入 Date 类中
 * 
 * @target TODO
 */
public class InputDate {

	public Date inputDate() throws ParseException {
		Scanner cal = new Scanner(System.in);
		System.out.println("please input date in yyyy-MM format");
		String format = cal.next();
		SimpleDateFormat theFormat = new SimpleDateFormat("yyyy-MM");
		// 以下方法必须要抛出异常
		Date theDate = theFormat.parse(format);
		cal.close();
		return theDate;
	}
}
