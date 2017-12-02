//package myjava;
package loop_stat;

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int H = 884800, initial_t = 1, i = 1,count=0;
		double acc_t ;
		do {
			acc_t = initial_t * Math.pow(2, i);
			 i++;
			 count++;
		} while (acc_t < H);
//		System.out.println("折叠"+(i-1)+"次之后高度超过喜马拉雅山的高度");
		System.out.println("折叠"+count+"次之后高度超过喜马拉雅山的高度");
	}

}
// do...while 循环的特征是不管判断条件，do 内的语句会先执行一次；

// 这里有个细节，就是执行了最后一次循环，i=20的时候，acc_t的值已经
// 超过884800cm了，但是还是执行了一次i++，所以后面输出的时候i-1；

// 这里i并不是计数器，也就是说，i 并不是真正意义上的符合原题的解，
// i最好的理解是 2的x次方的值> 884800,求x的值；

// 此程序的最优解还是在循环语句里面插入计数器,这才是循环真正执行的次数；