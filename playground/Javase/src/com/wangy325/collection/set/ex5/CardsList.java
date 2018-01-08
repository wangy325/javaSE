package com.wangy325.collection.set.ex5;

import java.util.ArrayList;
import java.util.List;

public class CardsList {
	List<Cards> cardsList;

	public CardsList() {
		cardsList = new ArrayList<Cards>();
	}

	// 初始化一副牌
	public void iniCards() {
		Suit ss = new Suit();
		ss.iniSuit();
		Face fs = new Face();
		fs.iniFaces();
		for (int i = 0; i < ss.suits.size(); i++) {
			for (int j = 0; j < fs.faces.size(); j++) {
				// Cards cs = new Cards();
				// cs.setSuit(ss.suits.get(i));
				// cs.setFace(fs.faces.get(j));
				/**
				 * 这里用构造器初始化, 保证呢,
				 * Cards 的 face 和 value 两个属性关联起来
				 */
				cardsList.add(new Cards(ss.suits.get(i), fs.faces.get(j)));
			}
		}
		// 添加大小王
		cardsList.add(new Cards("", "JOKER"));
		cardsList.add(new Cards("", "joker"));

	}

	public static void main(String[] args) {
		CardsList cl = new CardsList();
		cl.iniCards();
		for (Cards srs : cl.cardsList) {
			System.out.println(srs.getSuit() + srs.getFace());
		}
	}

}
