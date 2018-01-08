package com.wangy325.io.stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author wangy325
 *
 * @date Dec 30, 2017  6:09:40 PM
 *
 * @description  利用字节流-->文件输入(出)流实现文件拷贝
 * 
 */
public class CopyFile {
	/**
	 * 原始文件对象 --> 输入流 --> 字节对象 --> 输入流 -- >拷贝文件拷贝 
	 *  1. 同名文件拷贝
	 *  	1.  文件名, 目录名  --> 将当前目录下的某个文件拷贝至指定目录下
	 *  		// 将 readme.md 拷贝至 /home/wangy325/Documents
	 *  2. 异名文件拷贝
	 *  	2.1 文件a , 文件b --> 覆写(false) 追加(true)
	 *  		// 只要保证路径正确 就ok 了
	 */

	public static void copy(String filestr, String dirstr) {
		/**
		 * 基本实现:
		 * 	1. 参数1 为指定文件, 参数2 为指定目录
		 * 	2. 将文件拷贝到指定目录
		 * 	3. 如果文件存在, 则提示是否要覆盖原文件..
		 *  4. 不能拷贝 jpg png 图像等..
		 *  5. 此外, docx 等带格式文档 (非纯文本文档) 在数据传输过程中会出现数据损坏
		 *  2018.1.3 更新:
		 *  	出现上述4. 5 问题的原因在于, 输入流将源文件读取到 str 中, 转化为字符串,
		 *  	数据出现了格式转换.
		 */
		// 初始化过程
		File file = new File(filestr);
		File dir = new File(dirstr + File.separator + file.getName());
		FileInputStream fis = null;
		FileOutputStream fos = null;
		boolean flag = true;
		try {
			/**
			 * 0. 建立 fos 和文件的联系的时候, 如果目录名正确,
			 * 	  就会直接与文件建立联系:
			 * 1. 如果我文件不存在, 则会创建一个空文件 (file.length = 0L)
			 * 	  这导致,后面的 if 语句判断 文件是否存在的时候出现问题.
			 * 2. debug 显示, 建立 FileOutputStream 的时候, 会先把
			 *    已经存在的文件内容清空.
			 *    // FileOutputStream(file, boolean append)
			 * 3. 2 结论正确的前提是, fos 的第二个参数 boolean 初始值为 false 
			 * 
			 * 4. 如果 append 为 true, 那么原文件的内容不会被清除.
			 * 
			 * 5. 这里把 FileOutputStream() 初始化语句放在 if 语句内
			 */
			// 文件输入流
			fis = new FileInputStream(file);
			byte[] buffer = new byte[1024];
			int POS = 0;
			// String str = "";
			if (dir.exists()) {
				System.out.println("文件已经存在,是否覆盖已有文件(y/n)?");
				Scanner console = new Scanner(System.in);
				String choice = console.next();
				if (choice.equalsIgnoreCase("y")) {
					while ((POS = fis.read(buffer)) != -1) {
						// str += new String(bufferin, 0, POS);
						// 输入完成, 输出流开始
						// byte[] bufferout = str.getBytes();
						// 先不链接 fos 和 文件, 而判断文件在运行之前是否存在
						flag = false;
						fos = new FileOutputStream(dir, flag);
						fos.write(buffer, 0, POS);
						fos.flush();
					}
					console.close();
				}
			}
			// 文件不存在
			else {
				fos = new FileOutputStream(dir, flag);
				while ((POS = fis.read(buffer)) != -1) {
					fos.write(buffer, 0, POS);
					fos.flush();
				}
			}

		} catch (FileNotFoundException e) {
			// e.printStackTrace();
			System.out.println("Err: 不存在指定文件名或者路径名..");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// /home/wangy325/Desktop:readme.me
	public static void main(String[] args) {
		// copy("src/readme.md", "/home/wangy325/Desktop");
		copy("/home/wangy325/Documents/1173857931.jpg", "src");

	}

}
