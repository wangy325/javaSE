package com.wangy325.LoveLetters;

public class Test {
	
	static void showLetter(LoveLetter lv) {
		System.out.println(lv.writeTitle());
		System.out.println(lv.writeHello());
		System.out.println(lv.writeBody());
	}
	
	public static void main(String[] args) {
		LetterImp letterImp = new LetterImp();
		Test.showLetter(letterImp);
		
	}
	

}
