package com.wangy325.junitdemo;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author wangy325
 *
 * @date Jan 8, 2018  9:59:28 AM
 *
 * @description   JUnit 测试单元  用于测试方法返回值是否符合预期
 */
public class CalTest {
	private Cal cal = new Cal();
	/**
	 * private Cal cal;
	 * 
	 * publc CalTest(){
	 * 		cal = new Cal();
	 * }
	 */
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// 
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		
	}

	/**
	 * Test method for {@link com.wangy325.junitdemo.Cal#add(int, int)}.
	 */
	@Test
	public void testAdd() {
		Assert.assertEquals(5, cal.add(3, 2));
	}

	/**
	 * Test method for {@link com.wangy325.junitdemo.Cal#div(int, int)}.
	 */
	@Test
	public void testDiv() {
		Assert.assertEquals(1, cal.div(3, 2));
	}

}
