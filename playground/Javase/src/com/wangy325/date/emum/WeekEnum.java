/**
 * 
 */
package com.wangy325.date.emum;

/**
 * @author wangy325
 *
 * @date Dec 22, 2017  2:07:24 PM
 *
 * @decription  
 * 
 * @target TODO
 */
public enum WeekEnum {
	MON("星期一",1),THU("星期二",2),WED("星期三",3),
	THR("星期四",4),FRI("星期五",5),SAT("星期六",6),SUN("星期天",7);
	
	private String date;
	private int index;
	
	private WeekEnum(String date, int index) {
		this.date = date;
		this.index = index;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
}
