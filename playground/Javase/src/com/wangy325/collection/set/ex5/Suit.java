/**
 * 
 */
package com.wangy325.collection.set.ex5;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangy325
 *
 * @date Dec 27, 2017  5:50:07 PM
 *
 * @decription   这是牌的花色
 * 
 */
public class Suit {
	
	List<String> suits ;
	
	public Suit() {
		suits = new ArrayList<String>();
	}
	
	// 初始化牌的花色
	public void iniSuit() {
		suits.add("♠");
		suits.add("♥");
		suits.add("♣");
		suits.add("♦");
	}

}
