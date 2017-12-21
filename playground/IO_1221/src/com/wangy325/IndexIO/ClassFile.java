package com.wangy325.IndexIO;

import java.io.File;

/**
 * 
 * @author wangy325
 *
 * @date Dec 21, 2017  2:48:45 PM
 *
 * @decription    File 类
 * 
 */
public class ClassFile {
	public static void main(String[] args) {
		// 1. File 类的创建
		/**
		 * 3 种不同的构造器
		 */
		// 1.1 
		File file1 = new File("Sino_jp_relationship/canglaoshi.avi");
		System.out.println(file1);
		// 1.2 
		File dir1 = new File ("Sino_jp_relationship");
		File file2 = new File(dir1, "bolaoshi.avi");
		System.out.println(file2);
		// 1.3
		File file3 = new File("Sino_jp_relationship","longzelaoshi.avi");
		System.out.println(file3);
		
		// 2. 增删文件
		
		// 3. 增删文件夹
		
	}

}
