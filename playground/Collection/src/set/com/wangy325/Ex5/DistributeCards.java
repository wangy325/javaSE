/**
 * 
 */
package set.com.wangy325.Ex5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author wangy325
 *
 * @date Dec 27, 2017  5:41:47 PM
 *
 * @decription  生成一个随机发牌的斗地主游戏
 * 				1. 手牌要排序
 * 				2. 牌堆放在一个 List 中
 */
public class DistributeCards {

	List<Cards> cardsForPlayer;
	List<Cards> cardsForPlayer2;
	List<Cards> cardsForPlayer3;

	public DistributeCards() {
		cardsForPlayer = new ArrayList<Cards>();
		cardsForPlayer2 = new ArrayList<Cards>();
		cardsForPlayer3 = new ArrayList<Cards>();
	}

	// 生成一个发牌程序1, 每个玩家一次拿牌
	public void disCards() {
		CardsList cl = new CardsList();
		cl.iniCards();
		Collections.shuffle(cl.cardsList);
		for (int j = 0; j < cl.cardsList.size() - 3; j += 3) {
			cardsForPlayer.add(cl.cardsList.get(j));
			cardsForPlayer2.add(cl.cardsList.get(j + 1));
			cardsForPlayer3.add(cl.cardsList.get(j + 2));

		}
		// 输出玩家的手牌
		 Collections.sort(cardsForPlayer);
		System.out.println("玩家1的手牌为:");
		for (Cards cs : cardsForPlayer) {
			System.out.print(" " + cs.getSuit() + cs.getFace());
		}
		System.out.println();
		 Collections.sort(cardsForPlayer2);
		System.out.println("玩家2的手牌为:");
		for (Cards cs : cardsForPlayer2) {
			System.out.print(" " + cs.getSuit() + cs.getFace());
		}
		System.out.println();
		 Collections.sort(cardsForPlayer3);
		System.out.println("玩家3的手牌为:");
		for (Cards cs : cardsForPlayer3) {
			System.out.print(" " + cs.getSuit() + cs.getFace());
		}

		// 底牌
		System.out.println();
		System.out.println("底牌为:");
		for (int k = cl.cardsList.size() - 3; k < cl.cardsList.size(); k++) {
			System.out.print(" " + cl.cardsList.get(k).getSuit() + cl.cardsList.get(k).getFace());
		}
	}

	// 生成发牌程序2 每个玩家一次拿 17 张牌
	public void disCards2() {
		int i = 0;
		CardsList cl = new CardsList();
		cl.iniCards();
		// 牌只洗一次
		Collections.shuffle(cl.cardsList);
		Scanner console = new Scanner(System.in);
		while (i < 3) {
			System.out.println("请输入玩家" + (i + 1) + "的名字:");
			String player = console.next();

			// 给玩家发牌
			/**
			 * 1. 洗牌  Comparator 的shuffle(List) 方法
			 * 2. 将获取的牌添加到 cardsForPlayer 中
			 */
			for (int j = 17 * i; j < 17 * (i + 1); j++) {
				cardsForPlayer.add(cl.cardsList.get(j));
			}
			// 输出玩家的手牌
			/**
			 * 要对玩家手牌进行排序, 必须要 Cards 实现 comparable 接口
			 * 而且要重写 conpareTo() 方法
			 * 并且可以自定义排序规则
			 */
			 Collections.sort(cardsForPlayer);
			 System.out.println("玩家 " + player + " 的手牌为:");
			for (Cards cs : cardsForPlayer) {
				System.out.print(" " + cs.getSuit() + cs.getFace());
			}
			// 玩家获得牌之后 清空 List 去获取第二位玩家的手牌
			cardsForPlayer.clear();
			System.out.println();

			i++;
		}
		console.close();
		// 底牌
		System.out.println();
		System.out.println("底牌为:");
		for (int k = cl.cardsList.size() - 3; k < cl.cardsList.size(); k++) {
			System.out.print(" " + cl.cardsList.get(k).getSuit() + cl.cardsList.get(k).getFace());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DistributeCards dc = new DistributeCards();
		dc.disCards2();

	}

}
