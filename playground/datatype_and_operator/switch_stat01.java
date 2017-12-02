package condition_stat;

import java.util.Scanner;
public class switch_stat01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// HanY attends coding competition,
		// you are the jugde, so HanY's ranking
		//depends on your mood.
		System.out.println("pls input HanY's ranking");
		Scanner rnk = new Scanner(System.in);
		int rank = rnk.nextInt();
		switch(rank) { 
			case 1:
				System.out.println("1 month summer camp arranged by MIT.");
				break;
			case 2:
				System.out.println("a HP laptop for rewarding.");
				break;
			case 3:
				System.out.println("a mobile hard disk for rewarding.");
				break;
			default:
				System.out.println("sorry your ranking is too low.");
				break;
				
		}
		rnk.close();
		

	}

}
