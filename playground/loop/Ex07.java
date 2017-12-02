//package Ex;
package loop_stat;

import java.util.Scanner;

public class Ex07 {

	public static void main(String[] args) {
		// TODO 3个班级各4名学员参赛，计算每个班级参赛学员平均分，统计成绩大于85分学员数
		Scanner mark = new Scanner(System.in);
		int count = 0,mk= 0, sum = 0;
		boolean flag = false;
		for (int i = 0; i < 3; i++) {
			System.out.println("开始录入"+(i+1)+"班学员的成绩：");
			for (int j = 0; j < 4; j++) {
				System.out.print("请录入"+(i+1)+"班学员"+(j+1)+"的成绩：");
				mk = mark.nextInt();
				sum +=mk;
				if (mk<100 && mk >85) {
					count++;
					
				}
				else if (mk >100) {
					System.out.println("成绩爆表，请重新输入：");
					j-=1;
				}
				else if (mk < 0) {
//					System.out.println("你在胡闹，我要退出了");
					flag = true;
					break;
				}	
			}
			if (flag) {break;}
			System.out.println((i+1)+"班的学员平均成绩为："+(sum*1.0d/4));
			System.out.println();
			
		}
		if(flag) {
			System.out.println("由于你的失误，程序意外终止！");
		}
		else {
		System.out.println("成绩大于85分的学员数为："+count);
		}
		mark.close();
	}

}
