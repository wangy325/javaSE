package com.wangy325.io.stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
 * 
 * @author wangy325
 *
 * @date Dec 30, 2017  2:34:54 PM
 *
 * @decription  字节输入流(InputStream) 的子类 --> 文件输入流
 * 
 * @target TODO
 */
public class ReadFile {

	// 读取文件 将其赋值给变量 str
	/**
	 * 1. 先创建文件对象
	 * 2. 选择输入流  FileInputStream byte[] 
	 * 3. 读取流中的数据 到 byte[] 中
	 * 4. 关闭流
	 */
	public void readFile() {
		File testfile = new File("src/readme.md");
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(testfile);
			byte[] buffer = new byte[256];
			int pointer = 0 ;
			
//			System.out.println(buffer.length);
			String  str = "";
			/**
			 * 这里要说明的是:
			 * 0. 文件读取, 一般都是在循环体里面执行
			 * 1. pointer 这个返回值,只能在 while 循环体里面赋值
			 * 		因为 pointer 是一个固定长度的整型数值
			 * 		直接用 pointer != -1 进行判定 是一个死循环
			 * 2.  再研究一下 读取机制..
			 * 		2.1 inpuptStrream 会按照字节数读取文件的内容, 
			 * 			理论上来讲, 单次读取后 返回值 pointer 和 buffer.length 值
			 * 			应该是相等的.pointer 代表读取的字节数, 这里由用户决定, 而
			 * 			buffer.length 是byte数组的长度, 这里由于 byte[] 单个元素
			 * 			的长度就是 1B 所以 pointer == buffer.length
			 * 		2.2 但是, read() 方法规定, 如果读取到文件末尾的时候, 返回值为-1,
			 * 			也就是说, 除了读取到文件末尾的那一次, 其他的读取次数, 2.1 上面
			 * 			结论是正确的
			 * 		2.3 关于最后一次读取, 其字节数不足规定的每次读取的字节数, (本例中该
			 * 			规定的字节数为256B) ,那么,如前所述, pointer = -1, 但是, 
			 * 			buffer.length 依然等于 256, 这时, 它会循环读取文件内容. 
			 * 		2.4 所以, 最后的字符串拼接过程中, 要取 String 的子字符串, 而不能取整个
			 * 			buffer 的长度
			 * 		2.5 多说一句, String 类型有一个含参构造方法 String(byte[] ,int off, int length)
			 * 			这个方法法直接获取从 off开始(含) 长度为 length 的数组元素, 将其拼接成字符串 
			 * 			不难想像, String 还可以把很多其他类型的数组,直接转换成字符串
			 * 		 
			 */
			
			while((pointer = fis.read(buffer,0,100)) != -1 /*true*/){
//				pointer = fis.read(buffer);
				str += new String(buffer, 0, pointer);
				System.out.println(str);
				System.out.println("pointer = "+pointer);
				System.out.println("buffer.length = "+buffer.length);
				System.out.println("---------");
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			/**
			 *  关闭流之前, 要先进行判空, fis 声明时候为null
			 *  如果文件名不存在, 那么fis 可能持续为空
			 */
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
	public static void main(String[] args) {
		ReadFile rf = new ReadFile();
		rf.readFile();
	}

}
