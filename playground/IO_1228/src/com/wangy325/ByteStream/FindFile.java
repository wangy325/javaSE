package com.wangy325.ByteStream;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author wangy325
 *
 * @date Jan 2, 2018  5:29:00 PM
 *
 * @description    在指定目录下查找指定文件
 * 					---> 找到, 输出文件的绝代路径
 * 					---> 找不到, 提示文件不存在
 * @tags File 
 */
public class FindFile {

	// 初始化文件
	public File initialPath() {
		Scanner console = new Scanner(System.in);
		System.out.println("请输入文件名");
		String fileName = console.next();
		console.close();
		File file = new File(fileName);
		return file;
	}

	// 递归查找目录下的文件, 返回一个文件集合
	ArrayList<File> files = new ArrayList<File>();

	public ArrayList<File> listFiles(File dir) {
		// File[] list = dir.listFiles();
		for (File f : dir.listFiles()) {
			if (f.isFile()) {
				files.add(f);
			} else {
				listFiles(f);
			}
		}
		return files;
	}

	// 判断指定文件是否存在
	public boolean isExist() {
		File file = initialPath();
		ArrayList<File> files = listFiles(new File("/home/wangy325/playground"));
		// 集合中的 file 元素是带绝对路径的
		// System.out.println(files);
		for (File f : files) {
			if (f.getName().equals(file.getName())) {
				System.out.println(f);
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		FindFile ff = new FindFile();
		if (!(ff.isExist())) {
			System.out.println("在指定目录中找不到文件..");
		}

	}

}
