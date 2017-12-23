package com.wangy325.condition;

import java.util.Scanner;
public class solving_equations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// solving equation aX^2+bX+c=0
		Scanner coefficent = new Scanner(System.in);
		System.out.println("pls input dual coefficient a :");
		int a = coefficent.nextInt();
		System.out.println("pls input unitary coefficient b :");
		int b = coefficent.nextInt();
		System.out.println("pls input constant c :");
		int c = coefficent.nextInt();
		double x,x1, x2;
		if (a == 0) {
			// linear equation in one unknown
			x = (-c/b);
			System.out.println("if a =0, x= "+x+".");
		}
		else {
			double delta = (Math.pow(b, 2) - (4*a*c));   
			if (delta < 0) {
				System.out.println("equation has one imaginary root");
			}
			else {
				x1 = ((-b)+ Math.sqrt(delta))/(2*a);
				x2 = ((-b)- Math.sqrt(delta))/(2*a);
				System.out.println("1st real root of eauqtion is x1="+x1+".");
				System.out.println("2nd real root of eauqtion is x2="+x2+".");
			}
		}
		coefficent.close();
	}

}
