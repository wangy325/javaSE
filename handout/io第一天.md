# File、IO流

## 10.1 File类

### 20.1.1 File类作用

1. 文件可认为是相关记录或放在一起的数据的集合。文件一般存放在存储介质上：硬盘、u盘、光盘、软盘、云盘等。
2. java.io.File 类是专门对文件进行操作的类。(只能对文件本身进行操作，不能对文件内容操作)
3. File类是“文件和目录路径名的抽象**表示**”。 而不是指文件的内容(IO)。
4. File类定义了一些与平台无关的方法操作，如：创建、删除文件和重命名等。
5. Java中目录被看成是一个特殊的文件。 File.listFiles()方法可以返回目录中所有的子目录和文件。
6. 在unix下路径分隔符为(/)，而在windos中则是为(\\)，在java中可以正确的处理不同系统中的分隔符。注意：从1.5开始在java中可以统一使用(/)来作为路径分隔符。

### 20.1.2 File类的构造方法

1. public File(String pathname)，**以`pathname为`路径创建File对象**，如果pathname是相对路径，则是相对于Java的系统属性user.dir中的路径。（对eclipse创建的java工程来说，就是该工程的根目录。）

### 20.1.3 File类文件属性

#### 20.1.3.1 属性：

1. public static final String separator　存储了当前系统的名称分隔符，在 UNIX 和Mac系统上，此字段的值为 '/'；在 Windows 系统上，它为 '\\'；为了程序的跨平台特性，文件的路径应该用这个属性值来代表。
2. public static final char pathSeparator 存储了当前系统默认路径分割符号，在 UNIX 和Mac系统上，此字段的值为':'，Windows系统是';'。

### 20.1.4 使用File类对文件进行访问

| 方法名                                 | 描述                      |
| ----------------------------------- | ----------------------- |
| public boolean canRead()            | 是否可读                    |
| public boolean canWrite()           | 是否可写                    |
| public boolean exists()             | 文件或目录是否存在               |
| public boolean isDirectory()        | 是否是目录(文件夹)              |
| public boolean isFile()             | 是否是文件(非目录)              |
| public boolean isHidden()           | 是否是隐藏文件                 |
| public long lastModified()          | 最后一次修改的时间               |
| public long length()                | 返回文件大小，以字节为单位           |
| public String getName()  ·          | 返回文件的名字(不包含路径)          |
| public String getPath()   ·         | 返回创建File时使用指定的路径；[^提示] |
| public String getAbsolutePath()   · | 返回此File对象的绝对路径名         |
| public File getAbsoluteFile()   ·   | 返回该文件的绝对路径的文件对象。        |
| public String getParent()           | 返回该文件所在的目录的路径。          |
| public File getParentFile()         | 返回该文件所在的目录对象。           |

[^提示]: 创建文件的时候是相对路径就返回相对路径，是绝对路径就返回绝对路径。

### 20.1.5 使用File类对文件进行操作

| 方法名                                | 描述                               |
| ---------------------------------- | -------------------------------- |
| public boolean createNewFile()     | 当文件不存在时，则创建一个空文件                 |
| public boolean delete()            | 删除文件。如果是目录必须是空目录才能删除             |
| public boolean mkdir()             | 创建此抽象路径名指定的目录                    |
| public boolean mkdirs()            | 创建此抽象路径名指定的目录，包括所有**必需但不存在**的父目录 |
| public boolean renameTo(File dest) | 重新命名此抽象路径名表示的文件                  |

### 20.1.6 使用File类浏览目录中的文件和子目录

| 方法名                                      | 描述                    |
| ---------------------------------------- | --------------------- |
| public String[] list()                   | 返回此目录中的文件名和目录名的数组     |
| public File[] listFiles()                | 返回此目录中的文件和目录的File实例数组 |
| public File[] listFiles(FilenameFilter filter) | 返回此目录中满足指定过滤器的文件和目录   |



> 课堂练习：使用 递归算法 打印出目录(文件夹)中所有文件与目录(包括目录内部的文件和目录)。
>
> ```java
> private static void listChilds(File f){
> 		if (f==null)  
> 			return;
> 		System.out.println(f.getPath());
> 		if (f.isFile()) 
> 			return;
> 		File[] files = f.listFiles();
> 		if (files==null||files.length<=0)  
> 			return;
> 		for (File file : files)  
> 			listChilds(file);
> 	}
> ```

## 20.2 IO概念和种类:

### 20.2.1 什么是IO流？

IO指的是 Input/Output，IO流：输入输出流。 统称为数据流。(IO Stream)

在Java程序中，对于数据的输入 / 输出操作以流的方式进行；流是从起源到接收的有序数据。JDK提供了各种各样的Stream 类，用以获取不同种类的数据；

IO流的作用就是对文件数据的读和写。

### 20.2.2 流的作用和原理？

![](http://ojx4zwltq.bkt.clouddn.com/17-2-15/67548515-file_1487125441328_bdbc.png)

## 20.3 IO流的种类:

### 20.3.1 输入流、输出流

1. 输入流：程序可以从中读取数据的流（流入程序的流）
2. 输出流：程序能向其中写入数据的流 （从程序流出的流）

### 20.3.2 字节流、字符流

1. 字节流：以字节为单位传输数据的流 
2. 字符流：以字符为单位传输数据的流 

### 20.3.3 节点流、处理流

1. 节点流：用于直接操作目标设备的流 
2. 处理流：是对一个已存在的流的连接和封装，通过对数据的处理为程序提供更为强大、灵活的读写功能。

### 20.3.4 IO流的分类图：

![](http://ojx4zwltq.bkt.clouddn.com/17-2-15/77129940-file_1487125824060_621f.png)

## 20.4 字节输入流:

###  20.4.1 InputStream 抽象基类

1. available() 方法，可以获取与之关联的文件的字节数。

2. int read() 方法，读取输入流。读取输入流的下一个字节，返回一个0-255之间的int类型整数。如果到达流的末端，返回-1。

3. int read(byte[] b) 方法，读取输入流。读取多个字节，存入字节数组b，返回实际读入的字节数。如果到达流的末端，返回-1。

   > 需要说明的是，一般来讲，返回实际读入的字节数值 和 b.length 的值是一样的，除了最后一次读取返回 -1

4. int read (byte[] b, int off, int len); 方法，读取输入流。每次读取len个字节，存入字节数组b，从off下标开始存储。返回值为每次读取的字节数 len, 如果到达流的末端，返回-1。

   >记住这个参数表

5. close() 方法，关闭当前流，释放与该流相关的资源，防止资源泄露。在带资源的try语句中将被自动调用。关闭流之后还试图读取字节，会出现`IOException`异常。


### 20.4.2 FileInputStream 文件输入流

**FileInputStream 用于读取本地文件中的字节数据，继承自InputStream类**

#### 20.4.2.1 FileInputStream构造方法和常用方法

##### 20.4.2.1.1构造方法

1. FileInputStream(File file); 通过打开一个到实际文件的连接来创建一个`FileInputStream`，该文件通过文件系统中的 `File` 对象 `file` 指定。
2. FileInputStream(String name); 通过打开一个到实际文件的连接来创建一个`FileInputStream`，该文件通过文件系统中的路径名 `name` 指定。

##### 20.4.2.1.2 常用方法

1. read() 方法，读取输入流。读取输入流的**下一个字节**，返回一个0-255之间的int类型整数。如果到达流的末端，返回-1。

   ```java
   is = new FileInputStream("test.txt");  
   int i; 
   while ((i = is.read()) != -1) {
       System.out.println("out: " + (char)i);  
   } 
   ```

2. read(byte[] b) 方法，读取输入流。读取多个字节，存入字节数组b，返回实际读入的字节数。

   > 如前所述, 这里的**多个字节**是指先定义的 byte[] 的长度

   ```java
   InputStream is = null;  
   byte[] buffer = new byte[4];//每次读取4个字节
   try {
       is = new FileInputStream("test.txt");  
       is.read(buffer);  
       System.out.println("available: " + is.available());
     		// Returns an estimate of the number of remaining bytes that can be read (or
        	// skipped over) from this input stream.
       for (byte b : buffer) {  
           System.out.println((char)b);  
       }
   }...
   ```

3. read (byte[] b, int off, int len); 方法，读取输入流。每次读取len个字节，存入字节数组b，从off下标开始存储。

4. close() 方法，关闭当前流，释放与该流相关的资源，防止资源泄露。在带资源的try语句中将被自动调用。关闭流之后还试图读取字节，会出现IOException异常。

5. skip(long n) 方法，跳过(放弃)当前流的n个字节，返回实际跳过的字节数。

## 20.5 字节输出流:

### 20.5.1 OutputStream类的常用方法

1. write (int b); 将指定的字节写入此输出流。
2. write(byte[] b); 将 `b.length` 个字节从指定的 byte 数组写入此输出流。
3. write(byte[] byte, int off, int len); 将指定 byte 数组中从偏移量 `off` 开始的 `len` 个字节写入此输出流。
4. flush();  用于清空缓存里的数据，并通知底层去进行实际的写操作。(强制把缓存区里面的数据写入到文件)
5. close();关闭当前流，释放与该流相关的资源。

### 20.5.2 OuputStream类的子类:文件输出类FileOutputStream

**提供了文件的基本写入能力，继承自 OuputStream类**

> 注意：
>
> 1. 如果进行写操作的文件不存在，则自动创建该文件。
> 2. 如果文件所在的路径也不存在则报错。

#### 20.5.2.1 FileOutputStream构造方法和常用方法

##### 20.5.2.1.1 构造方法

1. public FileOutputStream(String name); 通过打开一个到实际文件的连接来创建一个`FileOutputStream`，该文件通过文件系统中的路径名 `name` 指定。
2. public FileOutputStream(String name,boolean append);通过打开一个到实际文件的连接来创建一个`FileOutputStream`，该文件通过文件系统中的路径名 `name` 指定。如果第二个参数为true，则将字节写入文件末尾处，而不是写入文件开始处。
3. public FileOutputStream(File file)：通过打开一个到实际文件的连接来创建一个`FileOutputStream`，该文件通过文件系统中的 `File` 对象 `file` 指定。 
4. public FileOutputStream(File file,boolean append);通过打开一个到实际文件的连接来创建一个`FileOutputStream`，该文件通过文件系统中的 `File` 对象 `file` 指定。如果第二个参数为true，则将字节写入文件末尾处，而不是写入文件开始处。

##### 20.5.2.1.1 常用方法

1. write (int b); 将指定的字节写入此输出流。

   ```java
   try {
   	File file = new File("test.txt");
   	OutputStream fos = new FileOutputStream(file);  // 通过 File 创建一个输出流
   	byte b = 'a'; // 注意 byte 和 char 的区别
   	fos.write(b);
   	fos.flush();
   	fos.close();
   }
   ```

   结果：![](http://ojx4zwltq.bkt.clouddn.com/17-2-16/21332407-file_1487215376635_92a0.png)

2. write(byte[] byte); 将 `b.length` 个字节从指定的 byte 数组写入此输出流。

   ```java
   try {
   	File file = new File("test.txt");
   	OutputStream fos = new FileOutputStream(file);
   	byte b[]= "abcdefg".getBytes();
   	fos.write(b);
   	fos.flush();
   	fos.close();
   }...
   ```

   结果：![](http://ojx4zwltq.bkt.clouddn.com/17-2-16/3808416-file_1487215353004_102a3.png)

3. write(byte[] byte, int off, int len); 将指定 byte 数组中从偏移量 `off` 开始的 `len` 个字节写入此输出流。

   ```java
   try {
   	File file = new File("test.txt");
   	OutputStream fos = new FileOutputStream(file);
   	byte b[]= "abcdefg".getBytes();
   	fos.write(b,1,3);
   	fos.flush();
   	fos.close();
   }...
   ```

   结果：![](http://ojx4zwltq.bkt.clouddn.com/17-2-16/67983629-file_1487215263373_34ea.png)

4. flush();  用于清空缓存里的数据，并通知底层去进行实际的写操作。(强制把缓存区里面的数据写入到文件)

5. close();关闭当前流，释放与该流相关的资源。

## 20.6 字节缓冲流

BufferedInputStream与BufferedOutputStream分别是FilterInputStream类和FilterOutputStream类的子类，实现了**装饰设计模式**。提高了读写性能。

### 20.6.1字节输入缓冲流 BufferedInputStream

BufferedInputStream是带缓冲区的输入流，默认缓冲区大小是8Kb，能够减少访问磁盘的次数，提高文件读取性能；

使用方式：

```java
try {
	File file = new File("test.txt");
	InputStream fos = new FileInputStream(file);
	BufferedInputStream bis = new BufferedInputStream(fos,2*1024);//2*1024设置需要的缓冲区大小
	byte b[] =new byte[1024];
	while (bis.read(b)!=-1) {
		for (byte c : b) {
			System.out.println((char)c);
		}
	}
	bis.close();
}
```

### 20.6.2 字节输出缓冲流 BufferedOutputStream

BufferedOutputStream是带缓冲区的输出流，能够提高文件的写入效率。

使用方式：

```java
try {
	File file = new File("test.txt");
	OutputStream fos = new FileOutputStream(file);
	BufferedOutputStream bos =new BufferedOutputStream(fos,2*1024);//2*1024设置需要的缓冲区大小
	byte b = "a";
	bos.write(b);
	bos.flush();//带有缓冲区，所以必须刷新。
	bos.close();
}
```

# 作业

1. 从键盘输入一个文件名，在 D:盘查找这个文件，如果找到就输出这个文件的绝对路径，如果找不到则输出找不到这个文件。
2. 编写程序来实现如下功能
   1. 在D盘下创建一个目录Letter
   2. 在控制台显示下列选项：1 查看请假条 2 撰写请假条
      1. 如果用户选择2，则提示用户撰写请假条，并把撰写的内容保存位文件，存入到Letter文件夹下。
         * 格式如下：
           * 请假人：王宝强
           * 请假日期：2016年8月15日
           * 请假原因：向法院起诉马蓉离婚.....先请假一天等等
      2. 如果用户选择1，则在控制台输出请假条的内容。
3. 将JAVA LOGO 图片 通过鼠标右键保存到 D盘(D:\\logo.png)中，然后使用java程序 实现：
   1. 剪切该图片到E盘(E:\\logo.png)中。
   2. 再从E盘把该图片复制到D盘中。

   ![](http://ojx4zwltq.bkt.clouddn.com/17-3-23/81360244-file_1490258509259_58a7.png)



