package com.wangy325.condition;

import java.util.Scanner;

public class if_stat02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// zhanghao wanna purchase a vehicle,
		// what is it precisely depends on his deposit.
		System.out.println("pls input your deposit(million):");
		Scanner dpt = new Scanner(System.in);
		int deposit = dpt.nextInt();
		if(deposit > 500) {
			System.out.print("you can purchase a Cadillac.\n");
		}
		else if(deposit > 100 && deposit < 500) {
			System.out.print("you can purchase a Passat.\n");
		}
		else if(deposit < 100 && deposit >50) {
			System.out.print("you can purchase a Atenza.\n");
		}
		else if (deposit < 50 && deposit > 10) {
			System.out.print("you can purchase a Civic.\n");
		}
		else {
			System.out.print("you can purchase a Giant.\n");
		}
		
		dpt.close();
		

	}

}
