/**
 * 
 */
package com.wangy325.Enumerate;

/**
 * @author wangy325
 *
 * @date Dec 20, 2017  9:09:58 PM
 *
 * @decription  介绍了 Java 1.5 新增特性 枚举
 * 
 * @target TODO
 */
public class GetWeekEnum {
	public static void main(String[] args) {
		
		for(WeekEnum we : WeekEnum.values()){
			System.out.println(we + we.getDate());
		}
		
	}

}
