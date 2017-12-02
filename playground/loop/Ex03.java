package loop_stat;

import java.util.Scanner;

//import jdk.nashorn.internal.scripts.JS;
/**
 * 
 * @author anonymity
 *	一个多位数，对10取模，必然得到其个位数，
 *	其商 对10 取模，必得到原多位数的十位数...
 *  while(paraNum != 0){
 *     revNum =  paraNum % 10 + revNum * 10;
 *     paraNum /= 10;
 *  }
 * 下面的代码利用字符串实现
 */
public class Ex03 {

	public static void main(String[] args) {
		// TODO 输入一个整数，然后将其倒序输出
		System.out.println("请输入一个整数：");
		Scanner integer = new Scanner(System.in);
		int i = integer.nextInt();
// 		将数字强转为字符串
		String SI = ""+i;
//		System.out.println(SI);
//		计算字符串长度
		int sLength = SI.length();
//		将数字的个位数赋值给字符串变量
		int j = 1;
		String jString = "", nti = "";
		while (j<= sLength) {
//			将倒数第n个数字赋值给第n个数字，以字符串的形式操作
			jString = SI.substring((sLength-j), (sLength-j+1));
//			连接字符串
			nti +=jString;
			j++;
		}
		System.out.println(nti);
		integer.close();
	}

}