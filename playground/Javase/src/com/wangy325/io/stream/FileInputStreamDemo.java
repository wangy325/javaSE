
package com.wangy325.io.stream;

import java.io.*;

/**
 * @author wangy325
 *
 * @date Dec 21, 2017  4:13:53 PM
 *
 * @decription   利用 byte[] 流读取文件内容
 * 				1. 和文件建立联系
 * 				2. 选择流(File 输入流), 这里选择 byte[]
 * 				3. 将流中的内容读取到 byte[] 中
 * 				4. 释放资源 (closed())
 * 
 */
public class FileInputStreamDemo {
	public static void main(String[] args) {
		//
		String PATH = "src/readme.md";
		// 建立和文件的联系
		File file = new File(PATH);
		FileInputStream fis = null;

		try {
			fis = new FileInputStream(file);

			// 读取文件内容到byte 数组中 
			// 512 是每次读取的字节数
			byte[] buffer = new byte[512];

			//
			int POS = 0;

			while ((POS = fis.read(buffer)) != -1) {
				String str = new String(buffer, 0, POS);
				System.out.println(str);
			}
		} catch (FileNotFoundException e) {
			// 抛出文件不存在异常
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			// 释放资源
			if(fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
}
