/**
 * 
 */
package com.wangy325.interfaces.instru;

/**
 * @author wangy325
 *
 * @date Dec 16, 2017  7:08:55 PM
 *
 * @decription  
 * 
 * @target TODO
 */
public class Test {
	// 实现类作为参数
	static void playInstrument(Instrument ins) {
		ins.play();
		
	}
	public static void main(String[] args) {
		UrInstrument urInstrument = new UrInstrument();
		playInstrument(urInstrument);
		
	}
}
