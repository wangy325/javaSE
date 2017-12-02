//package Ex;
package loop_stat;


public class Ex01 {

	public static void main(String[] args) {
		// 比较do..while 和while的区别
		
		int i= 0;
		
		while (i<1) {
			System.out.println("i= "+i);
			i++;
		}
		System.out.println("跳出while 之后，i= "+i);
		int j = 10;
		do {
			System.out.println("j= "+j+".");
			j++;
		} while (j<1);
		System.out.println("跳出do...while 之后，j= "+j);
	}
//  while 循环执行一次，i= 1 跳出循环
//	do while循环 初始值为j= 10， 判断条件为j<1 ;
//	但是循环执行了一次，跳出循环时，j=11；
	
//	意即 即使初始值不满足条件，do...while 循环还是会执行一次；
// 编码的问题啊
}
