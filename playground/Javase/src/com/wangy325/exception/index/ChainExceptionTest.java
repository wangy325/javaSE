/**
 * 
 */
package com.wangy325.exception.index;

/**
 * @author wangy325
 *
 * @date Dec 22, 2017  9:08:30 AM
 *
 * @decription  Java 中的异常链
 * 				把捕获的异常包装成新的异常,在新的异常中添加对原始异常的引用, 然后把新的异常抛出.
 */
public class ChainExceptionTest {

	/**
	 * TODO
	 * test1() 抛出"喝大了"异常;
	 * test2() 尝试捕获 test1() 抛出的 "喝大了" 异常, 将其包装成新的 RuntimeException
	 * 在 main 方法调用test2(), 尝试捕获 test2() 抛出的异常
	 */
	public static void main(String[] args) {
		ChainExceptionTest cet = new ChainExceptionTest();
		try {
			cet.test2();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}
	private void test1() throws DrunkException {
		throw new DrunkException("喝车不开酒");
	}

	private void test2() throws RuntimeException {
		try {
			test1();
		} catch (DrunkException e) {
//			RuntimeException rEx = new RuntimeException("司机一滴酒,亲人两行泪~~");
//			rEx.initCause(e);
			RuntimeException rEx = new RuntimeException(e);
			throw rEx;
		}
	}
}
