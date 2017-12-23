//package Train;
package com.wangy325.loop;

public class MultiplicationTable {

	public static void main(String[] args) {
		// TODO 打印乘法表啊，js里面已经打印过了
		
		for(int i = 1; i<10;i++) {
			for(int j = 1; j<(i+1); j++) {
				System.out.print(j+"x"+i+"="+(j*i)+"\t");
			}
			System.out.println();
		}

	}

}
