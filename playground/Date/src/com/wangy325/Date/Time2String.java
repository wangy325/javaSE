package com.wangy325.Date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 
 * @author wangy325
 *
 * @date Dec 22, 2017  2:27:19 PM
 *
 * @description  
 * 					写一个方法 long2String()
 * 					输入一个时间 格式为(xxxxL), 将其转换为字符串形式输出
 * 					再写一个 string2Long()
 * 					按照要求输入日期格式
 * 					将其转化为 Long 型数字
 */
public class Time2String {
	Scanner time = new Scanner(System.in);
	public String long2String() {
		String result = "";
		try {
			System.out.println("请输入一个 Long 整数");
			Long longTime = time.nextLong();
			Date dt = new Date(longTime);
			SimpleDateFormat mf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
			result = mf.format(dt);
			return result;
		} catch (Exception e) {
//			e.printStackTrace();
			return "错误! 请输入正确的 Long 型数字!";
		}
	}
	
	public Long string2Long() {
		Long result = 0L;
		try {
			System.out.println("请输入一个字符串(yyyy年MM月dd日):");
			String str = time.next();
			Date dt = new Date();
			SimpleDateFormat mf = new SimpleDateFormat("yyyy年MM月dd日");
			dt = mf.parse(str);
			result = dt.getTime();
			return result;
		}catch(Exception e) {
			System.out.println("没有正确输入时间格式!");
			return result;
		}
		
		
	}

}
