/**
 * 
 */
package com.wangy325.Date;

import java.text.ParseException;
import java.util.Calendar;

/**
 * @author wangy325
 *
 * @date Dec 21, 2017  2:31:07 PM
 *
 * @decription   输出日历内容
 * 
 */
public class OutputCanlendar {
	public static void main(String[] args) throws ParseException {
		
		MonthlyCalendar mc = new MonthlyCalendar();
//		System.out.println(mc.getDateInstance().get(Calendar.MONTH)+1);
		// 迭代错误
		System.out.println("======================" + mc.getDateInstance().get(Calendar.YEAR) + "年"
				+ (mc.getDateInstance().get(Calendar.MONTH) + 1) + "月月历=====================");
//		System.out.println("Sun\tMon\tThu\tWed\tTur\tFri\tSat");
		/*for (int i = 1; i < 7; i++) {
			if (i <= mc.getDayofWeek()) {
				System.out.print(" \t");
			} else
				System.out.print(" " + (i - mc.getDayofWeek()) + "\t");
		}
		for (int i = (7 - mc.getDayofWeek()); i <= mc.getDayofMonth(); i++) {
			if ((i - (7 - mc.getDayofWeek())) % 7 == 1) {
				System.out.println();
			}
			System.out.print(" " + i + "\t");
		}*/
	}


}
