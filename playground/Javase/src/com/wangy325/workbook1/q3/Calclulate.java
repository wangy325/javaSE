/**
 * 
 */
package com.wangy325.workbook1.q3;

//import java.util.Arrays;

/**
 * @author wangy325
 *
 * @date Dec 14, 2017  11:01:03 AM
 *
 * @decription  
 * 
 * @target TODO
 */
public class Calclulate {
	/*
	private double a , b;
	
	public Calclulate(double a , double b) {
		this.a = a ;
		this.b = b;
	}*/
	
//   四则运算
	public static double plus(int a , int b) {return a+b;}
	public static double minus(int a , int b) {return a-b;}
	public static double multiple(int a , int b) {return a*b;}
	public static double devide(int a , int b) {return a /b;}
	
//	求相反数,倒数 和绝对值
	public static double oppsiteNumber(int a) {return -a;}
	public static double reciprocal(int a ) {return 1/a;}
	public static double absoluteValue(int a) {return a > 0? a :-a;}
	
//	比较大小
	public static double max(int a , int b) {return a>b?a:b;}
	public static double min(int a , int b) {return a>b?b:a;}

// 浮点运算
//	取大于等于a的最小整数
	public static int minInt(double a) {
		int temp = (int)a;
//		double diff = a -
		if(temp -a == 0d)
			return temp;
		else
			return temp+1;
	}
//	取小于等于a的最大整数
	public static int maxInt(double a ) {
		int temp = (int)a;
		return temp;
	}
//	取最接近a的整数
	public static int closeInt(double a) {
		int temp = (int)a;
		double diff = (a-temp);
		if(diff > 0.5) {
			return temp +1;
		}
		else
			return temp;
	}
//	牛顿迭代法求算术平方根
	public static double sqrt(double a ) {
		if (a < 0) {
			System.out.println(" a must bigger than 0 !");
			return 0 ;
		}
		if (a == 0d) {return 0;}
		else {
			double temp = 1.0d; 
			double check = 0d;
			do {
				temp = (a/temp + temp)/2;
				check = temp * temp -a;
//				0.001是精度
			}while ((check >= 0 ? check: -check) > 0.001d);
			return temp;
		}
	}
// 计算自然对数 ln 未完成
//	if a^x =N, then log(double a ,Radix N) = x; 
//	e^x = 1+x+(x^2/2)+(x^3/3!)+..+(x^n/n!)
//	ln(x+1) = ∑(-1)^(n+1)/n*x^n, n=1
/**	public static double ln(double a) {
//		final double e= 2.718d;
//		double x =0d;
//		double check = 0d;
		if (a <=0) {
			System.out.println("a must bigger than 0 ! ");
			return 0;
		}
		double RADIX = 0d;
		double[] an = new double[101];
		if (a>0) {
//		给10次迭代, 即令 e^x 中n = 10
			for(int i = 0; i<101;i++) {
				 an[i]= (Math.pow(-1,(i+2))/(i+1))*Math.pow((a-1), (i+1));
				 RADIX += an[i]; 
//				return RADIX;
			}
//			System.out.println(Arrays.toString(an));
		}
		return RADIX;
	}*/
//	求阶乘算法
	private static double factorial(int num) {
		if (num == 0)
			return 1d;
		if (num > 0) 
			return num * factorial(num - 1);
		else 
			return 0d;
	}

	public static void main (String[] args) {
		System.out.println(minInt(4.1d));
		System.out.println(maxInt(3.9d));
		System.out.println(closeInt(3.3d));
		System.out.println(Calclulate.factorial(5));
		System.out.println(Calclulate.sqrt(5));
	} 
}
