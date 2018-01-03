package com.wangy325.ByteStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author wangy325
 *
 * @date Jan 3, 2018  8:07:44 PM
 *
 * @description   尝试利用字节流实现图片的剪切和复制
 * 
 */
public class Cc {
	// target : /home/wangy325/Desktop/logo.png
	// 剪切 target 到 /tmp 目录
	static String fileName = "logo.png";
	
	public static File pic() {
		File pic = new File("/home/wangy325/Desktop"+File.separator+fileName);
		return pic;
	}
	public static File cip() {
		File cip = new File("/tmp"+File.separator+fileName);
		return cip;
	}
	public static void cutPic(File o, File d) {
		// 复制过程
		cp(o,d);
		// 删除源文件
		if(o.getName().equals(d.getName()) && d.length() == o.length()) 
			o.delete();
		else if (o.exists())
			System.out.println("wrong...");
	}
	
	// 恢复被剪切的文件
	public static void cp(File o , File d) {
		InputStream fis = null;
		OutputStream fos = null;
		byte[] bis = new byte[1024];
		int pos = 0;
		try {
			fis = new FileInputStream(o);
			fos = new FileOutputStream(d);
			while((pos = fis.read(bis)) != -1) {
				// 将 非文本形式的文件以字节流的形式读取, 
				// 不能进行任何形式的格式转换,不然数据会损坏
				// 亦即,以字节读取, 以字节写入
				fos.write(bis, 0, pos);
			}
			fos.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			if(fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static void main(String[] args) {
		cutPic(pic(),cip());
		cp(cip(),pic());
	}

}
