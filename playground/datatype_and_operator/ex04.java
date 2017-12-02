import java.util.Scanner;

public class ex04{
	public static void main (String[] args){
		Scanner rec = new Scanner(System.in);
		System.out.println("请输入网球拍的价格：");
		Double racketPrice  = rec.nextDouble();
		System.out.println("请输入网球鞋的价格：");
		Double shoesPrice  = rec.nextDouble();
		System.out.println("请输入T恤的价格：");
		Double tPrice  = rec.nextDouble();

		System.out.println("请输入要购买的网球拍的数量：");
		int racketNum = rec.nextInt(); 
		System.out.println("请输入要购买的网球鞋的数量：");
		int shoesNum = rec.nextInt(); 
		System.out.println("请输入要购买的T恤的数量：");
		int tNum = rec.nextInt(); 
		
		double racketCost = racketPrice * racketNum;
		double shoesCost = shoesPrice * shoesNum;
		double tCost = tPrice * tNum;
		
		System.out.println("------------------消费清单------------------");
		System.out.println("物品\t价格\t个数\t金额");
		System.out.println("网球拍\t"+racketPrice +"\t" + racketNum +"\t" + racketCost);
		System.out.println("网球鞋\t"+shoesPrice+ "\t" + shoesNum+ "\t"+ shoesCost);
		System.out.println("T恤\t"+tPrice+ "\t" + tNum+ "\t" + tCost);
		System.out.println("--------------------------------------------");

		System.out.println("折扣：8折");
		System.out.println("消费总金额：" + (racketCost + shoesCost + tCost));
		System.out.println("实际支付金额为："+ ((racketCost + shoesCost + tCost)* 0.8d));
	}
}

