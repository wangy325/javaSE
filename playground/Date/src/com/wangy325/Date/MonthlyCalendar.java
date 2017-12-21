/**
 * 
 */
package com.wangy325.Date;

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
 */
public class MonthlyCalendar {
		// 获取 Date 实例
	public Calendar getDateInstance() throws ParseException {
		Date theDate = inputDate();
		Calendar theCalendar = Calendar.getInstance();
		theCalendar.setTime(inputDate());
		theCalendar.set(Calendar.DATE, 1);
		return theCalendar;
	}
	// 获取月份天数
	public int getDayofMonth() throws ParseException {
		int theMonth = getDateInstance().get(Calendar.MONTH);
		int theYear = getDateInstance().get(Calendar.YEAR);
		int DayofMonth = 0;
		switch (theMonth + 1) {
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
			if (theYear % 400 == 0 || (theYear % 4 == 0 && theYear % 100 != 0))
				DayofMonth = 29;
			else
				DayofMonth = 28;
			break;
		}
		return DayofMonth;
	}

	// 获取当前月份的1号是星期几
	public int getDayofWeek() throws ParseException {
		int DayofWeek = getDateInstance().get(Calendar.DAY_OF_WEEK);
		return DayofWeek;
	}

	
}
