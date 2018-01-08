/**
 * 
 */
package com.wangy325.exception.index;

/**
 * @author wangy325
 *
 * @date Dec 21, 2017  8:42:19 PM
 *
 * @decription  测试在方法中抛出自定义异常
 */
public class TestDrunkException {

	/**
	 * 有两个方法 test1() 和 test2()
	 * 前者作一个普通的异常抛出;
	 * 后者作为 if 语句的条件执行语句进行抛出
	 */
	public static void main(String[] args) {
			TestDrunkException te = new TestDrunkException();
			try {
				te.test1();
			} catch (DrunkException e) {
				e.printStackTrace();
			}
			
			try {
				te.test2(-4);
			} catch (DrunkException e) {
				e.printStackTrace();
			}
			
	}
	
	public void test1() throws DrunkException{
		throw new DrunkException("喝车不开酒");
	}
	public void test2(int a) throws DrunkException {
		if(a <0) {
			throw new DrunkException("喝大了吧,告诉你要输入正数");
		}else
			return;
		
	}

}
