/**
 * 
 */
package com.wangy325.Index;

/**
 * @author wangy325
 *
 * @date Dec 21, 2017  9:12:03 PM
 *
 * @decription  自定义一个登录异常
 */
public class LoginException extends Exception {

	public LoginException() {
		super();
	}
	public LoginException(String message, Throwable cause) {
		super(message, cause);
	}
	public LoginException(String message) {
		super(message);
	}

	public LoginException(Throwable cause) {
		super(cause);
	}
	
}
