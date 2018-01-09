package com.wangy325.dao.exception;

/**
 * @author wangy325
 *
 * @date Jan 9, 2018  11:10:57 AM
 *
 * @description   自定义学生异常类
 * 
 * @tags  Exception
 */
@SuppressWarnings("serial")
public class StuException extends Exception {

	public StuException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 */
	public StuException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public StuException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
