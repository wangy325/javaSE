// receive 2 numbers from stdin, and then interchange their value.

import java.util.Scanner;

public class ex02{
	public static void main (String[] args){
	
	Scanner receive = new Scanner(System.in);

	System.out.println("Pls input the 1st number(integer or decimal):");
	double num_1 = receive.nextDouble();

	System.out.println("Pls input the 2nd number:");
	double num_2 = receive.nextDouble();

	System.out.println("the 1st number is "+num_1+", the 2nd number is "+num_2+".");
	double diff = num_1 - num_2;

	num_1 = num_1 - diff;
	num_2 = num_2 + diff;
	System.out.println("the 1st number is "+num_1+", the 2nd number is "+num_2+" after the operation.");
	}
}
//bugs report:
//	1. integer would convert to double when print it to screen;
//	2. if num_1 is an int[56 for instance(56.0 actually)], and num_2 = 2.3 for instance, 
//	   the result of num_1  will be 2.299999....
//	3. one int and one decimal may occur bug.
//
