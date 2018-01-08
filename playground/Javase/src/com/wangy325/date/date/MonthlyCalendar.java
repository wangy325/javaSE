/**
 * 
 */
package com.wangy325.date.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author wangy325
 *
 * @date Dec 20, 2017  9:11:55 PM
 *
 * @decription  利用日历类输出指定月的月历
 * 
 * TODO: 读取键盘输入的字符串 "yyyy-MM", 将字符串转为 Date实例
 * 		 然后将Date 实例转换为 Calendar 实例
 * 		 获取 Calendar 的 YEAR 和 MONTH 字段信息, 并将Calendar 的 DATE 字段信息设置为当月1日
 * 		 调用 Calendar get field  方法, 获取 1日是星期几
 * 		 判断 YEAR 年 MONTH 月的天数 
 * 		 格式化输出日日历
 * 		
 * 
 */
public class MonthlyCalendar {
	public static void main(String[] args) {
		// 获取Date 实例
		Scanner input = new Scanner(System.in);
		System.out.println("请输入年月(yyyy-MM):");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM");
		Date theDate = new Date();
		boolean flag = true;
		while (flag) {
			try {
				String date = input.next();
				theDate = df.parse(date);
				flag = false;
			} catch (ParseException e) {
				// e.printStackTrace();
				System.out.println("请输入正确的格式!");
			}
		}
		input.close();
		// 将Date 转化为 Calendar
		Calendar theCanlendar = Calendar.getInstance();
		theCanlendar.setTime(theDate);
		// 添加 Calendar 的 DATE 字段信息
		theCanlendar.set(Calendar.DATE, 1);
		// 判断 MONTH 字段, 获取月份的天数
		int DayofMonth = 0;
		switch (theCanlendar.get(Calendar.MONTH) + 1) {
		case 1:
			DayofMonth = 31;
			break;
		case 3:
			DayofMonth = 31;
			break;
		case 5:
			DayofMonth = 31;
			break;
		case 7:
			DayofMonth = 31;
			break;
		case 8:
			DayofMonth = 31;
			break;
		case 10:
			DayofMonth = 31;
			break;
		case 12:
			DayofMonth = 31;
			break;
		case 4:
			DayofMonth = 30;
			break;
		case 6:
			DayofMonth = 30;
			break;
		case 9:
			DayofMonth = 30;
			break;
		case 11:
			DayofMonth = 30;
			break;
		case 2:
			if (theCanlendar.get(Calendar.YEAR) % 400 == 0
					|| (theCanlendar.get(Calendar.YEAR) % 4 == 0 && theCanlendar.get(Calendar.YEAR) % 100 != 0))
				DayofMonth = 29;
			else
				DayofMonth = 28;
			break;
		}
		// 获取 1 号是这个星期的第几天
		/**
		 * Calendar 中, 将周天设置为一周的第一天, 周六设置为一周的第7天
		 *  所以下列代码的返回值是 1-7;
		 */
		int DayofWeek = theCanlendar.get(Calendar.DAY_OF_WEEK);

		// 格式化输出

		System.out.println(DayofWeek);
		System.out.println(DayofMonth);
		System.out.println("======================" + theCanlendar.get(Calendar.YEAR) + "年"
				+ (theCanlendar.get(Calendar.MONTH) + 1) + "月月历=====================");
		System.out.println("Sun\tMon\tThu\tWed\tTur\tFri\tSat");
		for (int i = 1; i <= 7; i++) {
			if (i <= (DayofWeek - 1)) {
				System.out.print(" \t");
			} else
				System.out.print(" " + (i - DayofWeek + 1) + "\t");
		}
		for (int i = (7 - (DayofWeek - 1) + 1); i <= DayofMonth; i++) {
			if ((i - (7 - (DayofWeek - 1) + 1)) % 7 == 0) {
				System.out.println();
			}
			System.out.print(" " + i + "\t");
		}

	}
}
