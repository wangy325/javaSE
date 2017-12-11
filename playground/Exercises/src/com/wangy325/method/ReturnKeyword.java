/**
 * 
 */
package com.wangy325.method;

/**
 * @author wangy325
 *
 * @date Dec 7, 2017 10:54:18 AM
 *
 * @decription return 关键字 与方法的递归调用 多说一句:类名用标准的驼峰命名法, 如 TestValue 方法名用首字母小写的驼峰命名法
 *             如 testAttribute
 * @target TODO
 */
public class ReturnKeyword {

	public static int test(int para1, int para2) {
		if (para1 > para2) {
			return 1;
		} else {
			return -1;
		}
	}
//	 递归求和
	public int getSum(int i) {
		if (i == 1) {
			return 1;
		}
		return i + getSum(i - 1);
	}
	// 方法执行顺序
	// 1.执行41行,先进入 main 方法
	// 2.调用 getSum 方法,传入参数 i=6,
	// 3.进入 if 判断,不满足,进入29行, 从这里开始递归调用...return 6 + getSum(5);
	//		 4.进入 if 判断,接着进入29行,return 5 + getSum(4) ; ...
	// 			...
	// 				5. 当调用5次之后, return 2 + getSum(1);
	// 					6. 再进行调用, 此时进入 if 判断, 进入 if 语句,
	// 					6. return 1; 并退出当前方法
	// 				5. return 2+1,退出方法;
	// 			...
	// 		4.return 5 +10 , 退出方法;
	// 3.return 6+ 15; 退出方法;
	// 4. 返回main方法, 执行打印语句
	
//	递归打印 乘法表
	public void mutipleTable(int i) {
		if (i ==1) {
			System.out.println(i + "*"+i +"=" + i);
			return ;
		}
//			mutipleTable(i-1);
//			递归打印乘法表的行
			for(int j = 1; j<=i; j++) {
				System.out.print(j+"*"+i+"="+(j*i)+"\t");
			}
			System.out.println();
			mutipleTable(i-1);
	}
//		这里要注意递归语句在代码块中的位置, 它会影响代码的执行
//			第 58 行的 递归语句打印出来的是倒置的乘法表
//			用 debug 查看递归方法的运行过程
//			如果递归语句放置在第 52 行,那么, 程序运行会直接循环调用9次 mutipleTable方法,而不执行后面的 for(j) 循环语句
//			调用完成之后,再依次执行 for(j) 循环语句, 并按照顺序退出 方法 
//			姑且称之为 "套娃模式"
			
//			如果递归语句放在 第58行, 那么, 程序会先 运行 for(j)循环,打印乘法表最后一行,
//			再调用mutipleTable(8) 方法,再打印 乘法表倒数第 2 行
//			.i..
//			打印完成之后, 程序运行到 [域] 尾的反花括号, 所有加载的方法,同时终止
//			这就类似于一个循环

	public static void main(String[] args) {
		// 下面的print语句直接调用了方法, 并没有初始化对象
		// 这里在方法声明中加入了 [static 关键字]
		System.out.println(test(12, 8));

		// 调用递归求和方法
		ReturnKeyword sum = new ReturnKeyword();
		System.out.println(sum.getSum(6));
		
//		调用 打印乘法表的方法
		ReturnKeyword table = new ReturnKeyword();
		table.mutipleTable(9);
	}
}
