// THIS PROGRAM READ STDIN FORM KEYBOARD INPUT

import java.util.Scanner;		// import class Scanner , for building Object of Scanner.

public class Read {
	public static void main (String[] args){
		System.out.println("THIS PROGRAM READ STDIN FORM KEYBOARD INPUT/这个java程序会读取键盘输入");
		// creat a scanner
		Scanner sc = new Scanner(System.in);

		// read int from stdin, and assign it to a declared int
		System.out.println("Pls input your age");
		int num = sc.nextInt();
		System.out.println("ur age is "+num+".");

		// read double from stdin, and assign it to a Double type variable
		System.out.println("How far you away from home(km)?");
		double sal = sc.nextDouble();
		System.out.println("u r " +sal+" kilo meters away from home.");

		// read string from stdin ,and assign it to a new string
		System.out.println("What do you want to say 2 her?");
		String str = sc.next();
		System.out.println("you just said "+str);

		
	}

}

