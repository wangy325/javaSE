//package myjava;
package loop_stat;

public class WelcomeHome {

	public static void main(String[] args) {
		// 茴香豆的回字有几种写法？
		
		for (int i = 0; i <10; i++) {

			if(i>1 && i<8) {
				for (int j = 0; j < 20; j++) {
					if (j>2 && j< 6) {
//					将第2到第8行的 第4个到第6个星号换成空格
						System.out.print(" ");
									
					}
					else if (j>13 &&j<17) {
//					将第2到第8行的 第15个到第17个星号换成空格	
						System.out.print(" ");
									
					}
					else {
//						注意这里的两层if 语句的条件限制
						if(i>3 && i<6) {
//						准备掏空内层的星号
							if (7<j && j<12) {
//								将内层第8 到第12个星号换成空格						
								System.out.print(" ");
							}
							else {
								System.out.print("*");
							}
						}	
						else {
							System.out.print("*");
						}
					}		
				}
				System.out.println();
			}
			else {
				for (int j = 0; j < 20; j++) {
					
					System.out.print("*");
					
				}
				System.out.println();
			}	
		}
//		茴香豆的回字真的很难
	}

}
