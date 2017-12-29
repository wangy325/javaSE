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
		 * 两种不同的构造器
		 * 1. 直接给出文件 [路径] : File(String pathname)
		 * 		这里的路径可以是绝对路径, 也可以是相对路径
		 * 		如果是相对路径, 于 eclipse 而言, 相对的是 /src 目录
		 * 2. File(String parent, String child)
		 * 		parent 指的是父目录
		 * 		child 指的是(子目录)文件?
		 */
		File file1 = new File("Sino_jp_relationship" + File.separator + " canglaoshi.avi" + File.pathSeparator);
		System.out.println(file1);
		// 1.2
		File dir1 = new File("/home/wangy325/git/");
		File file2 = new File(dir1, "javaSE");
		 System.out.println(file2);

		// System.out.println(Arrays.toString(file2.listFiles()));

		// 调用 showFiles() 方法
		ClassFile cf = new ClassFile();
	cf.showFiles("/home/wangy325/git/javaSE/handout/");

		// 2. 方法
		/**
		 * 1. 判断权限 canRead(); canWrite() ; isHidden()
		 * 2. 判断属性 isDirectory(); isFile(); exists();
		 * 3. 返回最后修改时间 Long lastModified();
		 * 4. 返回文件大小  Long length(); 单位为字节
		 * 5. 获取属性  String getName() // 返回文件名(不含路径)
		 * 6. 获取属性 String getPath() // 返回创建 File 对象时使用的路径的字符串表示
		 * 7. 获取属性 String getAbsolutePath(); // 返回 File 对象的绝对路径名的字符串表示
		 * 8. 获取属性 String getParent(); // 返回 File 对象所在目录的字符串表示
		 * 9. 获取文件对象 File getAbsoluteFile(); // 返回 File 对象的绝对路径的文件对象表示
		 * 10. 获取文件对象 File getParentFile() // 返回 File 对象所在目录的文件对象表示
		 */

		// 3.文件操作方法
		/**
		 * 1. 创建文件 boolean creatNewFile(); 当 File 对象不存在对应文件时, 创建该文件
		 * 2. 删除文件 boolean delete(); 删除文件, 文件夹为空时方可删除文件夹
		 * 3. 创建目录 boolean mkdir(s)(); 创建文件夹, [复数] 形式可以递归创建
		 * 4. 重命名   boolean renameTo(File dest); 重命名此抽象路径名表示的文件 重命名成功返回 true 否则返回 false
		 */

	}

	// 方法 : 递归打印文件夹中的所有内容
	public void showFiles(String str) {
		/**
		 * 1. 判断对象是否存在
		 * 		2. 存在, 判断是文件还是文件名
		 * 			2.1 文件, 直接过去文件路径 结束
		 * 			2.2 文件夹, 
		 * 3. 不存在, 结束
		 */
		File file = new File(str);
		if (file.isFile()) {
			 System.out.println(file.getAbsolutePath());
		}
		// 如果是目录
		else if (file.isDirectory()) {
			/**
			 * file.List(); 返回文件(目录)名的字符串表示形式
			 * 递归的时候, 字符串的表示形式为 相对路径, 程序运行就出问题了
			 * 
			 * 1. 这里要说明的是传参数的问题, 这里选择参数为字符串,
			 * 2. 如果选择参数为 File 可以简单
			 */
			File[] files = file.listFiles();
			for (File st : files) {
				/**
				 * 传参为字符串的麻烦, 这里一定要获取到绝对路径
				 * 不然, isdir 和 isfile 判断出现异常 
				 */
				showFiles(st.getAbsolutePath());
			}
		}
		else {
			System.out.println("路径名无效");
		}
	}
}
