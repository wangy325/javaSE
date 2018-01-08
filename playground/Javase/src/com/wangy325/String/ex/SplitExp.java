/**
 * 
 */
package com.wangy325.String.ex;

import java.util.Arrays;

/**
 * @author wangy325
 *
 * @date Dec 16, 2017  1:13:04 PM
 *
 * @decription  
 * 
 * @target TODO
 */
public class SplitExp {
	static String mark = "01#张三#2002#李四#3003#王五#40";
	static String[] splitStr = mark.split("#");

	/**
	 * ["01","张三","2002","李四","3003","王五","40"]
	 */
	void printTab() {
		int Count = 0;
		for (int i = 0; i < splitStr.length; i++) {
			if (splitStr[i].length() == 4) {
				Count++;
			}
		}

		String[] splitStrNew = new String[splitStr.length + Count];
		for (int i = 0; i < splitStr.length; i++) {
			splitStrNew[i] = splitStr[i];
		}
		// 数组的移位
		/**
		 * 	
		 */
		for(int j = 0;j<splitStrNew.length-Count;j++) {
//			int COUNT = 0;
			
				int INDEX1 = 0;
				for (int i = j; i < splitStrNew.length-Count; i++) {
					if (splitStrNew[i].length() == 4) {
						INDEX1 = i;
//						COUNT++;
						break;
					}
				}
				String[] subSplit = new String[splitStrNew.length - INDEX1 - Count];
				for (int i = 0; i < subSplit.length - 1; i++) {
					subSplit[i] = splitStrNew[INDEX1 + i + 1];
					
				}
				String temp = subSplit[subSplit.length-1];
				for (int i = subSplit.length-1; i >0; i--) {
					subSplit[i] = subSplit[i-1];
				}
				subSplit[0] = temp;
				
				subSplit[0] = splitStrNew[INDEX1].substring(2);
				System.out.println(Arrays.toString(subSplit));
		}

		System.out.println(Arrays.toString(splitStrNew));
	}

	public static void main(String[] args) {
		SplitExp splitExp = new SplitExp();
		splitExp.printTab();

	}

}
