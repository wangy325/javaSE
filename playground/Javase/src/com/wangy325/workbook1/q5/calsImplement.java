/**
 * 
 */
package com.wangy325.workbook1.q5;

/**
 * @author wangy325
 *
 * @date Dec 14, 2017  4:56:25 PM
 *
 */
public class calsImplement implements Cals {
	  int m, n;

	public calsImplement(int m, int n) {
		this.m = m;
		this.n = n;
	}

	public long frac() {
//		演示了 方法重写 带参数与不带参数的写法
//		带参数则不需要构造器,
//		不带参数要用构造器初始化, 并且求阶乘的算法不能用递归
		/**if (m == 0)
			return 1;
		if (m > 0)
			return m * frac(m - 1);
		else
			return 0;*/
		if (m <0)
			return 0;
		else {
			long FracValue = 1L;
			for (int i = 1; i<=m;i++) {
				FracValue *=i;
			}
			return FracValue;
		}
	}

	public long intPower(int m, int n) {
		long VALUE = 1L;
		for (int i = 0; i < n; i++) {
			VALUE *= m;
		}
		return VALUE;
	}

	@Override
	public boolean findFactor(int m, int n) {
		if(m+n > 100)
			return true;
		else
			return false;
	}
	
	public static void main(String[] args) {
		Cals c1 = new calsImplement(-1,8);
		System.out.println(c1.frac());
		System.out.println(c1.intPower(5, 8));
		System.out.println(c1.findFactor(67,81));
	}

}
