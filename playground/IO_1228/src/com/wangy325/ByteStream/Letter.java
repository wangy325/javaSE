package com.wangy325.ByteStream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

/**
 * @author wangy325
 *
 * @date Jan 2, 2018  8:29:09 PM
 *
 * @description   在 Desktop 新建一个目录, 然后在该目录下新建一个文件
 * @tags 
 */
public class Letter {
	private static File directory;

	public Letter() {
		super();
		directory = newDir();
	}

	// 新建目录
	public File newDir() {
		File dir = new File("/home/wangy325/Desktop/Letter");
		if (dir.isDirectory()) {
			// System.out.println("目录已经存在..");
		} else if (dir.mkdir()) {
			// System.out.println("目录创建成功");
		}
		// System.out.println(dir.mkdir() ? "目录创建成功" : "目录创建失败");
		return dir;
	}

	/**
	 * 撰写请假条内容, 输出流  --> 选择2
	 * 1. 新建文件
	 * 2. 将字符串写入文件中 使用 BufferedInputStream()
	 */
	private void writeLetter() {
		File dir = directory;
		// 建立联系 即创建文件
		File letter = new File(dir + File.separator + "letter");
		if (letter.exists()) {
			System.out.println("请假条已经存在,可选择1直接查看");
		} else {

			OutputStream fos = null;
			BufferedOutputStream bos = null;
			byte[] content = "请假人: 王宝强\n请假日期: 2016年10月1日\n事由: 新电影开拍取景..".getBytes();
			try {
				fos = new FileOutputStream(letter);
				bos = new BufferedOutputStream(fos, 2048);
				bos.write(content);
				bos.flush();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (fos != null && bos != null) {
					try {
						bos.close();
						fos.close();
						System.out.println("请假条创建成功..");
					} catch (IOException e) {
						e.printStackTrace();
					}

				}
			}
		}
	}

	/**
	 * 查看请假条内容. 输入流 --> 选择1
	 * 1. 如未创建文件, 则提示文件还未创建
	 */
	private void reviewLetter() {
		File dir = directory;
		File letter = new File(dir + File.separator + "letter");
		if (!(letter.exists())) {
			System.out.println("请假条还未创建, 请先选择2以创建请假条...");
			return;
		} else {
			InputStream fis = null;
			BufferedInputStream bis = null;
			byte[] readbuf = new byte[1024];
			int pos = 0;
			String str = "";
			try {
				fis = new FileInputStream(letter);
				bis = new BufferedInputStream(fis, 2048);
				if ((pos = bis.read(readbuf)) != -1) {
					str += new String(readbuf, 0, pos);
				}
				System.out.println(str);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				// System.out.println("请假条还没写, 请先选择2以创建请假条");
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (fis != null && bis != null) {
					try {
						fis.close();
						bis.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	// 查看或者新建文件内容
	public void newLetter() {
		System.out.println("请输入选择:(1/2)");
		System.out.println("1.查看请假条");
		System.out.println("2.撰写请假条");
		System.out.println("3.按其他键退出");
		Scanner console = new Scanner(System.in);
		/**
		 *  先选择1 而导致循环退出因为1 方法出现异常了..
		 *  错! 调用的子方法异常并不会导致父方法退出.
		 *  这里while循环退出的原因是 if 条件循环的语句写法有问题, 
		 *  不能用 if ... if...else 必须要用 if... else if ...else
		 *  区别在于,前者是依次执行, 后者是按照条件选择执行.
		 *  或者用 switch 语句
		 */
		while (true) {
			String choice = console.next();
			if (choice.equals("1")) {
				reviewLetter();
			} else if (choice.equals("2")) {
				writeLetter();
			} else {
				console.close();
				return;
			}
		}
	}

	public static void main(String[] args) {
		Letter letter = new Letter();
		letter.newLetter();
	}

}
