package com.wangy325.exception.index;

/**
 * @author wangy325
 *
 * @date Dec 21, 2017  3:25:02 PM
 *
 * @decription Java 中的异常体系
 * 
 * 		Throwable 类
 * 			--- Error JVM 虚拟机错误
 * 			--- Exception 编码, 环境, 用户等其他问题
 * 				--- RuntimeException
 * 					--- NullPointerException
 * 					--- ArrayIndexOutOfBoundsException
 * 					---	ClassCastException
 * 					--- ArithmeticException
 * 				--- CheckedException
 * 					---- ClassNotFoundException 
- 					---- FileNotFoundException 
- 					---- IOException
- 					---- SQLException

 * 		处理异常
 * 			try - catch 或者 try-catch-finally
 */
/**
 * try{
 * 		// 可能会抛出异常的代码块(可能有多个不同的异常)
 * }catch{
 * 		// 处理可能出现的异常1的代码块
 * }catch{
 * 		// 处理可能出现的异常2 的代码块	
 * }finally{
 * 		//最终将要执行的代码
 * }
 */
public class Index {
	public static void main(String[] args) {
		Index index = new Index();
		/*int result1 = index.test();
		System.out.println("test() 方法调用完毕, 返回值是:" + result1);
		*//** ///:~
		 *  循环抛出异常了!	// test() 方法调用成功
			test() 方法调用完毕, 返回值是:-1  //返回catch代码块的输出信息
			java.lang.ArithmeticException: / by zero  // 说明抛出算术异常
			at com.wangy325.Index.Index.test(Index.java:51) // 代码位置 51行
			at com.wangy325.Index.Index.main(Index.java:37)
		 *//*
		int result2 = index.test2();
		System.out.println("test2()执行完毕...返回值是" + result2);*/
		
		int result3 = index.test3();
				System.out.println("test3()执行完毕,返回值是:"+ result3);
				
	}

	public int test() {
		/**
		 * try-catch 捕获错误
		 */
		int devide = 10;
		int result = 100;
		try {
			while (devide > -1) {
				devide--;
				result = result + result / devide;
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("循环抛出异常了!");
			return -1;
		}
	}
	/**
	 * 探讨 finally 语句块的执行顺序
	 * 		异常被 catch 语句块捕获之后, 会执行 finally 语句块的内容
	 * 		关于方法的返回值, 如果抛出异常, catch 块中有返回值, 则返回catch中的返回值,
	 * 		如果catch 中没有返回值, 则返回 try-catch 块之外的return 值
	 * @return
	 */
	public int test2() {
		int devide = 10;
		int result = 100;
		try {
			while (devide > -1) {
				devide--;
				result = result + result / devide;
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("循环抛出异常了!");
			return result = 999;
		}finally {
			System.out.println("这是 finally 语句块的输出.");
			System.out.println("result的值是:"+result);
		}
	}
	public int test3() {
		int devide = 10;
		int result = 100;
		try {
			while (devide > -1) {
				devide--;
				result = result + result / devide;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("循环抛出异常了!");
		}finally {
			System.out.println("这是 finally 语句块的输出.");
			System.out.println("result的值是:"+result);
			
		}
		System.out.println("这是test3()的输出代码");
		return 1111;
	}
}
