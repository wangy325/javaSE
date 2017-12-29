/**
 * 
 */
package com.wangy325.StreamDemo;

import java.io.*;

/**
 * @author wangy325
 *
 * @date Dec 21, 2017  4:50:40 PM
 *
 * @decription   输出流 (byte)
 * 				1. 建立联系
 * 				2. 选择流
 * @target TODO
 */
public class FileOutputSteramDemo {
	public static void main(String[] args) {
		String dest = new String("src/readme.md");
		
		File file = new File(dest);
		
		try {
			FileOutputStream fos = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
