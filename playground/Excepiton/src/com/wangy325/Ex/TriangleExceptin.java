/**
 * 
 */
package com.wangy325.Ex;

/**
 * @author wangy325
 *
 * @date Dec 22, 2017  10:47:27 AM
 *
 * @decription  自定义一个三角形构成异常
 * 
 */
@SuppressWarnings("serial")
public class TriangleExceptin extends Exception {

	public TriangleExceptin() {
		super();
	}

	
	public TriangleExceptin(String message, Throwable cause) {
		super(message, cause);
	}

	
	public TriangleExceptin(String message) {
		super(message);
	}

	
	public TriangleExceptin(Throwable cause) {
		super(cause);
	}

	
}
