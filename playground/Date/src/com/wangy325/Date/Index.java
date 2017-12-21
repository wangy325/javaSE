/**
 * 
 */
package com.wangy325.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * @author wangy325
 *
 * @date Dec 20, 2017  2:22:42 PM
 *
 * @decription  Date 类属于 java.util.Date 包下, 主要用来表示特定的时间
 * 				精度为 秒
 * 
 */
public class Index {

	public static void main(String[] args) throws ParseException {
		/** -----------Date 类-----------*/
		// 1. 常用构造器
		System.out.println(new Date());
		/// :~ Wed Dec 20 14:35:20 CST 2017
		/**
		 * 实际上 Date 是调用了 System.currentTimeMillis() 这个方法
		 * "Returns the current value of the running Java Virtual Machine's
		 * high-resolution time source, in nanoseconds."
		 */
		System.out.println(new Date(0L));
		/// :~ Thu Jan 01 08:00:00 CST 1970
		/**
		 * 参数为一个 long 型数字, 然后计算自 1970年1月1日0点0时0分(Unix纪元)开始 加上形参之后的时间
		 * 1000L 代表时间增加1s...(因为单位是毫秒)
		 * 我们在东八区,所以上述返回是8点...
		 */
		// 2. 常用方法
		System.out.println(new Date().getTime());
		/// :~1513752441572
		/**
		 * 返回自 Unix 纪元开始到创建对象为止的毫秒数. 这个返回值和 Date(long) 方法的形参可以对应
		 * Date 还有一没什么卵用的方法--> toString(),其输出格式和直接输出无差异
		 */
		//
		/**---------Calendar 类--------*/
		/**
		 * 1.Calendar 是一个抽象基类, 不能使用构造器来创建 Calendar 对象
		 * 2.利用 getInstance() 获取一个 Calendar 的实例
		 * 3.field 是 Calendar 类变量, 如 Calendar.YEAR, Calendar.MONTH, 等等
		 * 4.MONTH 起始值是0, 最大值是11 [0,11]
		 */
		/**
		 * 常用方法:
		 * 1. void add(int field, int amount); 根据日历规则, 给指定日历字段增加或者减去时间量;
		 * 2. int get(int field); 返回日历实例 [指定字段] 的值
		 * 3. int getActualMaximum(int field); 返回指定日历字段可能拥有的最大值;
		 * 4. int getActualMinimum(int field); 返回指定日历字段可能拥有的最小值;
		 * 5. void set (int field int value); 将给定的日历字段设置为给定值;
		 * 6. void set(int year, int month, int day); 设置 Calendar 对象的年 月 日三个字段的值;
		 * 
		 */
		Calendar myCalendar = Calendar.getInstance(); // 初始化默认为当前时间

		System.out.println(myCalendar.get(Calendar.YEAR)); // 注意 field 的写法
		System.out.println(myCalendar.get(Calendar.DAY_OF_WEEK)); /// :~ 4
		// 对 myCalendar 进行操作的话, 其他的类变量的值会重新计算
		myCalendar.set(Calendar.YEAR, 1991);
		System.out.println(myCalendar.get(Calendar.DAY_OF_WEEK)); /// :~6
		myCalendar.add(Calendar.DATE, 3);
		System.out.println(myCalendar.get(Calendar.DAY_OF_WEEK));/// :~2

		/** ---------- SimpleDateFormat 类----------*/
		/**
		 * SimpleDateFormat 是一个与语言环境相关的格式化解析日期的具体类;
		 * 它定义了日期和时间的格式化编码
		 * 有一些特定的格式, 按需求查阅
		 */
		Date myDate = myCalendar.getTime();
		SimpleDateFormat myFromat = new SimpleDateFormat("yyyy年MM月dd日 hh时mm分ss秒 a E z");
		String output = myFromat.format(myDate);
		System.out.println(output);
		
//		public static Date getDate() throws ParseException {
			Scanner cal = new Scanner(System.in);
			System.out.println("please input date in yyyy-MM format");
			String format = cal.next();
//			String format = "2017-08";
			SimpleDateFormat theFormat = new SimpleDateFormat("yyyy-MM"); 
			// 以下方法必须要抛出异常 
			Date theDate = theFormat.parse(format);
			System.out.println(theDate.getTime());
			cal.close();
			
//		}

	}
}
