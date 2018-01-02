package com.wangy325.Stream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author wangy325
 *
 * @date Dec 30, 2017  2:32:06 PM
 *
 * @description  字节输出流 OutputStream 的子类 文件输出流 
 * 				FileOutputStream
 * 
 */
public class WriteFile {

	public static void main(String[] args) {
		// writeSingleByte();
		// writeByteArray();
		writeByteArrayPartly();
	}

	/**
	 * 1. 如果文件不存在, 则会创建文件
	 * 2. 如果路径不存在, 则会报错
	 * 以下是向文件中写入单个字符的情况
	 */
	public static void writeSingleByte() {
		// File file = new File("src/readme.md");
		/**
		 * byte b = char a;
		 * 这样的运算操作, 会将 char 和 byte 都转成 int 
		 * 再进行操作 这在 Java 中叫做 [自动类型提升] 
		 */
		byte b = 'a';
		FileOutputStream fos = null;
		try {
			/**
			 * 添加第二个参数就是追加文件, 相当于 >>
			 * 不添加就是重写 相当于 > 
			 * 初始化文件流的参数既可以是 File类型 也可以是 字符串类型(文件的字符串表示)
			 */
			fos = new FileOutputStream("readme.md", true);
			/**
			 * 注意这里的方法参数 write(int b), 传入的是 int
			 * 而 API 里解释说的是 b is the byte to be written.
			 * 这里的意思就是, 将int(本是字符的ascii码)转成了byte数据
			 * 而一个ASCII的大小就是 1 byte.
			 */
			fos.write(b);
			fos.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 方法2 读取整个字节数组 byte[] 并写入到文件中 \
	 * 1. 可以在字符串中添加特殊字符比如换行符 \n 等
	 */
	public static void writeByteArray() {
		byte[] b = "\ni wanna go no where.".getBytes();
		FileOutputStream fos = null;

		try {
			fos = new FileOutputStream("src/readme.md", true);
			fos.write(b);
			fos.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
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
		}
	}

	/**
	 * 方法3. [最常用] 读取部分字符串并写入到指定文件中
	 * 1. 特殊字符 [\n] [\t] 等等在字符串中只占用一个 [index]
	 */
	public static void writeByteArrayPartly() {
		byte[] b = "\ni w\tanna go no where.".getBytes();
		FileOutputStream fos = null;

		try {
			fos = new FileOutputStream("src/readme.md", true);
			/**
			 * write(byte[] , off, len)
			 */
			fos.write(b, 5, 4); // 读取 anna
			fos.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
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
		}
	}

}
