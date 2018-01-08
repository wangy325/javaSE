/**
 * 
 */
package com.wangy325.collection.set.ex5;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangy325
 *
 * @date Dec 27, 2017  5:53:51 PM
 *
 * @decription  这是牌的面值
 * 
 */
public class Face {
	
	List<String> faces;
	
	public Face() {
		faces = new ArrayList<String>();
	}
	// 初始化牌的面值
	public void iniFaces() {
		faces.add("2");
		faces.add("3");
		faces.add("4");
		faces.add("5");
		faces.add("6");
		faces.add("7");
		faces.add("8");
		faces.add("9");
		faces.add("10");
		faces.add("J");
		faces.add("Q");
		faces.add("K");
		faces.add("A");
	}

}
