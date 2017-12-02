// 

import java.util.Scanner;

public class ex03{
	public static void main (String[] args){
		Scanner vc = new Scanner(System.in);
		System.out.println("Pls input a four-digits number:");
		int vipCode = vc.nextInt();
		int iT = (vipCode / 1000) % 10;
		int iH = (vipCode / 100) % 10;
		int iD = (vipCode / 10) % 10;
		int iU = (vipCode / 1) % 10;	// int iI = (vipCode  / 10^I) % 10 
		int iSum = iT + iH + iD + iU;
		System.out.println("the sum of each digit is " + iSum+".");
	}
}
