# io

## 21.1 字符输入流

字符流（Java IO的Reader和Writer）功能与InputStream和OutputStream非常类似，InputStream和OutputStream基于字节处理，而字符流(Reader和Writer)是基于字符处理。主要用于读写文本。

### 21.1.1 Reader类的常用方法

Reader类是Java IO中所有Reader的基类。子类包括FileReader，BufferedReader，InputStreamReader，StringReader和其他Reader。

1. read() ; 读取字符输入流。读取字符输入流的下一个字符，返回一个字符，意味着这个返回值的范围在0到65535之间(当达到流末尾时，同样返回-1)。这并不意味着Reader只会从数据源中一次读取2个字节，Reader会根据文本的编码，一次读取一个或者多个字节。
2. read(char cbuf[]);读取字符输入流。读取多个字符，存入字符数组cbuf，返回实际读入的字符数。
3. read(char cbuf[], int off, int len); 方法，读取字符输入流。每次读取len个字符，存入字符数组cbuf，从off下标开始存储。
4. close(); 关闭当前流，释放与该流相关的资源，防止资源泄露。在带资源的try语句中将被自动调用。关闭流之后还试图读取字符，会出现IOException异常。

### 21.1.2 Reader类的子类:FileReader

​	**FileReader类从InputStreamReader类继承而来(间接继承了Reader)。该类按字符读取流中数据。**

### 21.1.3 FileReader构造方法和常用方法

#### 21.1.3.1 构造方法

1. FileReader(File file);通过打开一个到实际文件的连接来创建一个`FileReader`，该文件通过文件系统中的 `File` 对象 `file` 指定。

2. FileReader(String fileName) ; 通过打开一个到实际文件的连接来创建一个`FileReader`，该文件通过文件系统中的路径名 `name` 指定。

3. （了解）FileReader(FileDescriptor fd) ; 在给定从中读取数据的` FileDescriptor` 的情况下创建一个新 FileReader。

   > 提示：FileDescriptor 是“文件描述符”。
   >
   > 其中有三个属性：
   >
   > ​	
   >
   > 1. in 标准输入(键盘)的描述符(从键盘输入读取流)
   > 2. out 标准输出(屏幕)的描述符(讲流输出到控制台上)
   > 3. err 标准错误输出(屏幕)的描述符(将流以红色的字体输出到控制台上)
   >
   > 代码示例：
   >
   > ​
   >
   > ```java
   > try {
   > 	FileWriter fw = new FileWriter(FileDescriptor.out);
   > 	fw.write("我是爱你的。");
   > 	fw.flush();
   > 	fw.close();
   > }...
   > ```
   >
   > 控制台输出：
   >
   > ![](http://ojx4zwltq.bkt.clouddn.com/17-2-16/95428717-file_1487259515739_16da1.png)

#### 21.1.3.2 常用方法

test.txt 文件内容（字符长度为17）

![](http://ojx4zwltq.bkt.clouddn.com/17-2-16/66790699-file_1487259899778_293b.png)

1. read();读取字符输入流。读取字符输入流的下一个字符，返回一个字符。

   ```java
   try {
   	File file = new File("test.txt");
   	FileReader fileReader = new FileReader(file);
   	int read = fileReader.read();//默认第一次读取第一个字符
   	System.out.println((char)read);
   }...
   ```

   结果：![](http://ojx4zwltq.bkt.clouddn.com/17-2-16/36252577-file_1487260402244_630c.png)

2. read(char cbuf[]);读取字符输入流。读取多个字符，存入字符数组cbuf，返回实际读入的字符数。

   ```java
   try {
   	File file = new File("test.txt");
   	FileReader fileReader = new FileReader(file);

   	char c [] = new char[20];
   	int len = fileReader.read(c);//
   	System.out.println("读取的字符长度为："+len);
   	
   	for (char d : c) {
   		System.out.print(d);
   	}
   }...
   ```

   结果：![](http://ojx4zwltq.bkt.clouddn.com/17-2-16/57754385-file_1487260166478_3ee2.png)

3. read(char cbuf[], int off, int len);读取字符输入流。每次读取len个字符，存入字符数组cbuf，从off下标开始存储。

   ```java
   try {
   	File file = new File("test.txt");
   	FileReader fileReader = new FileReader(file);
   	
   	char c [] = new char[20];
   	int len = fileReader.read(c,2,8);//读取8个字符存入c数组，从下标2开始存储
   	System.out.println("读取的字符长度为："+len);
   	
   	for (char d : c) {
   		System.out.print(d);
   	}
   	
   }
   ```

   结果：![](http://ojx4zwltq.bkt.clouddn.com/17-2-16/36724215-file_1487260315343_48b9.png)

4. close();关闭当前流，释放与该流相关的资源，防止资源泄露。在带资源的try语句中将被自动调用。关闭流之后还试图读取字符，会出现IOException异常。

   ```java
   try {
   	File file = new File("test.txt");
   	FileReader fileReader = new FileReader(file);
   	int read = fileReader.read();//
   	System.out.println((char)read);
   	fileReader.close();//通过close()来关闭流,以释放系统资源。
   }...
   //或者在这里关闭
     ...finally {
       	if(fileReader!=null)
   			fileReader.close();
     }
   ```

   > 注意：
   >
   > 1. 通常不使用close会导致内存泄露，垃圾回收机制会回收，但是最好自己显式关闭
   > 2. OutputStream的作用是如FileOutStream，当不调用close的时候，不会将缓存刷入文件中。
   >
   > 所以：一般使用完IO流之后都要通过close()来关闭,以释放系统资源

## 21.2 字符输出流

### 21.2.1 Writer类的常用方法

1. write (String str); 将指定的字符串写入此输出流。
2. write(char[] cbuf, int off, int len); 将指定 char 数组中从偏移量 `off` 开始的 `len` 个字符写入此输出流。
3. flush();  用于清空缓存里的数据，并通知底层去进行实际的写操作。(强制把缓存区里面的数据写入到文件)
4. close();关闭当前流，释放与该流相关的资源。

### 21.2.2 Writer类的子类:FileWriter

​	**FileWriter类从OutputStreamReader类继承而来(间接继承Writer类)。该类按字符向流中写入数据。**

### 21.2.3 FileWriter构造方法和常用方法

#### 21.2.3.1 构造方法

1. FileWriter(File file);通过打开一个到实际文件的连接来创建一个`FileWriter`，该文件通过文件系统中的 `File` 对象 `file` 指定。 
2. FileWriter(File file, boolean append);通过打开一个到实际文件的连接来创建一个`FileWriter`，该文件通过文件系统中的 `File` 对象 `file` 指定。 如果第二个参数为true，则将字符写入文件末尾处，而不是写入文件开始处。
3. FileWriter(String fileName);通过打开一个到实际文件的连接来创建一个`FileWriter`，该文件通过文件系统中的路径名 `name` 指定。
4. FileWriter(String fileName, boolean append);通过打开一个到实际文件的连接来创建一个`FileWriter`，该文件通过文件系统中的路径名 `name` 指定。如果第二个参数为true，则将字符写入文件末尾处，而不是写入文件开始处。
5. FileWriter(FileDescriptor fd);在给定从中写入数据的` FileDescriptor` 的情况下创建一个新 FileReader。(可以向控制台输出文本流)。

#### 21.2.3.2 常用方法

1. write (String str); 将指定的字符串写入此输出流。

   ```java
   try {
   	File file = new File("test.txt");
   	Writer fileWriter = new FileWriter(file);
   	fileWriter.write("十年之前，我不认识你。");
   	fileWriter.flush();
   	fileWriter.close();
   }...
   ```

   结果：![](http://ojx4zwltq.bkt.clouddn.com/17-2-17/90010701-file_1487293064703_10021.png)

2. write(int c );将指定的字符写入此输出流。

   ```
   try {
   	File file = new File("test.txt");
   	Writer fileWriter = new FileWriter(file);
   	fileWriter.write('育');
   	fileWriter.flush();
   	fileWriter.close();
   }...
   ```

   结果：![](http://ojx4zwltq.bkt.clouddn.com/17-2-17/32210844-file_1487293295547_1230c.png)

3. write(char[] cbuf);将 cbuf 字符数组写入此输出流。

   ```java
   try {
   	File file = new File("test.txt");
   	Writer fileWriter = new FileWriter(file);
   	char[] charArray = "字符串转字符数组".toCharArray();
   	fileWriter.write(charArray);
   	fileWriter.flush();
   	fileWriter.close();
   }
   ```

   结果：![](http://ojx4zwltq.bkt.clouddn.com/17-2-17/41226877-file_1487295189755_184a2.png)

4. write(char[] cbuf, int off, int len);将 cbuf 字符数组，按偏移量 `off` 开始的 `len` 个字符写入此输出流。

   ```java
   try {
   	File file = new File("test.txt");
   	Writer fileWriter = new FileWriter(file);
   	char[] charArray = "字符串转字符数组".toCharArray();
   	fileWriter.write(charArray, 1, 5);//从偏移量 1 开始，写入5个字符。
   	fileWriter.flush();
   	fileWriter.close();
   }
   ```

   结果：![](http://ojx4zwltq.bkt.clouddn.com/17-2-17/94043205-file_1487295267375_2870.png)

5. write(String str, int off, int len);

   ```java
   try {
   	File file = new File("test.txt");
   	Writer fileWriter = new FileWriter(file);
   	String str ="字符串也可以制定写的内容";
   	fileWriter.write(str, 3, 5);
   	fileWriter.flush();
   	fileWriter.close();
   } 
   ```

   结果：![](http://ojx4zwltq.bkt.clouddn.com/17-2-17/96213631-file_1487295456930_1740f.png)

## 21.3 转换流(重点掌握)

​	**字节流转字符流，称作转换流，包括：**

1. InputStreamReader—> 将字节流转换为字符流。是字节流通向字符流的桥梁。如果不指定字符集编码，该解码过程将使用平台默认的字符编码，如：GBK/UTF-8。
2. OutputStreamWriter—> 将字节流转换为字符流。是字节流通向字符流的桥梁。如果不指定字符集编码，该解码过程将使用平台默认的字符编码，如：GBK/UTF-8。

### 16.3.1 InputStreamReader的构造方法

1. InputStreamReader(InputStream in);//构造一个默认编码集的InputStreamReader类。

2. InputStreamReader(InputStream in,String charsetName);构造一个指定编码集的InputStreamReader类。


### 16.3.2 InputStreamReader的使用

```java
try {
	File file = new File("test.txt");
	FileInputStream fis = new FileInputStream(file);
	InputStreamReader isr = new InputStreamReader(fis);
	int read = isr.read();
  	//char cbuf[]=new char[512];
	//isr.read(cbuf);
	System.out.println((char)read);
	isr.close();
}...
```

### 16.3.3 OutputStreamWriter的构造方法

1. OutputStreamWriter(OutputStream out);构造一个默认编码集的OutputStreamWriter类
2. OutputStreamWriter(OutputStream out,String charsetName);构造一个指定编码集的OutputStreamWriter类。

### 16.3.4 OutputStreamWriter的使用

```java
try {
	File file = new File("test.txt");
	FileOutputStream fos = new FileOutputStream(file);
	OutputStreamWriter osw = new OutputStreamWriter(fos);
	String str="育知同创";
	osw.write(str);//直接写入字符串
	//osw.write(str.toCharArray());//写入 char 数组
	osw.flush();
	osw.close();
}...
```

## 21.4 字符缓存流(BufferedReader/BufferedWriter)

(BufferedReader/BufferedWriter) 是带缓冲区的字符流，默认缓冲区大小是8Kb，能够减少访问磁盘的次数，提高文件读取性能；并且可以一次性读取一行字符。(类似管道套管道一样，不带缓冲的流只能一滴一滴流，套了管道后，可以让一滴一滴留到外面的管道后一次性流出。)

### 21.4.1 字符缓存流构造方法

#### 21.4.1.1 BufferedReader

1. BufferedReader(Reader in);创建一个默认缓冲区大小 8Kb 的字符缓冲输入流；
2. BufferedReader(Reader in, int sz);创建一个字符缓冲输入流；并分配 sz/byte 大小的缓冲区。

#### 21.4.1.1 BufferedWriter

1. BufferedWriter(Writer out); 创建一个默认缓冲区大小 8Kb 的字符缓冲输出流；
2. BufferedWriter(Writer out, int sz); 创建一个字符缓冲输出流；并分配 sz/byte 大小的缓冲区。

### 21.4.2 字符缓存流的常用方法:readLine()， newLine()  

1. BufferedReader.readLine();在字符缓冲输入流读取字符的时候，可以一次性读取一行，并将游标指向下一行。

   ```java
   try {
   	File file = new File("test.txt");
   	FileInputStream fis = new FileInputStream(file);
   	InputStreamReader isr = new InputStreamReader(fis);
   	BufferedReader br = new BufferedReader(isr);
   	String str;
   	while ((str = br.readLine())!=null) {
   		System.out.println(str);
   	}
   }...
   ```

2. BufferedWriter.newLine();在字符串缓冲输出流写入字符的时候，默认是在一行写入，当需要换行的时候，调用 newLine() 实现文本换行。

   ```java
   try {
   	File file = new File("test.txt");
   	FileOutputStream fos = new FileOutputStream(file);
   	OutputStreamWriter osw = new OutputStreamWriter(fos);
   	BufferedWriter bw = new BufferedWriter(osw);
   	bw.write("写入一行的文本");
   	bw.newLine();//换行
   	bw.write("写入第二行的文本");
   	bw.flush();//刷新缓冲区，强制写入文件中
   	bw.close();
   }...
   ```




## 22.1 内存流（重点掌握）

### 22.1.1 什么是内存流

当输出流的目的，和输入流的源是内存时，这样的流称之为内存流。（就是将数据写入RAM）

![](http://ojx4zwltq.bkt.clouddn.com/17-2-17/98846065-file_1487323529015_15de2.png)

### 22.1.2 内存流的构造方法

1. ByteArrayInputStream(byte buf[]); 创建一个 ByteArrayInputStream 并把指定该输入流的数据源buf[]
2. ByteArrayOutputStream(); 创建一个 ByteArrayOutputStream 并把分配一个32字节（默认大小）的缓冲区
3. ByteArrayOutputStream(int size); 创建一个 ByteArrayOutputStream 并分配自定 size 字节的缓冲区

### 22.1.3 读取内存数据和写入到内存数据

#### 22.1.3.1 读取内存数据

```java
try {
	String testContent = "ABCDEFG";//程序运行的时候 这数据本身就在内存，
	ByteArrayInputStream bais = new ByteArrayInputStream(testContent.getBytes());//创建内存输入流，指定要读取的数据 byte[]
	int read;
	while ((read = bais.read()) != -1) {//和普通流读取字节是一样的(也可以嵌套管道)
		System.out.println((char) read);
	}
	bais.close();//关闭流，释放内存资源
}...
```

#### 22.1.3.2 写入数据到内存

```java
try {
	String testContent = "ABCDEFG";
	ByteArrayOutputStream baos = new ByteArrayOutputStream();//创建内存输出流，把数据写入到内存中
	baos.write(testContent.getBytes());//和普通的输出流写输入一样，(也可以嵌套管道)
	baos.flush();
	baos.close();
}...
```

### 22.1.4  ByteArrayOutputStream 常用方法:toByteArray(), toString()

1. toByteArray() 方法；是将 ByteArrayOutputStream 对象所写入到内存的数据 转换成 byte[] 返回
2. toString() 方法 ；是将 ByteArrayOutputStream 对象所写入到内存的数据 转换成 String 返回

> 提示：内存流 除了 ByteArrayInputStream 与 ByteArrayOutputStream 主要处理字节数据之外，对应的还有：
>
> - CharArrayReader 与  CharArrayWriter 主要处理字符数组
> - StringReader 与 StringWriter 主要处理字符串
>
> 使用方式大同小异
>


## 22.4 RandomAccessFile类

RandomAccessFile 类可以说是Java语言中功能最为丰富的文件访问类，它提供了众多的文件访问方法。RandomAccessFile 类支持“随机访问”方式，可以跳转到文件的任意位置处读写数据。在要访问一个文件的时候，不想把文件从头读到尾，而是希望像访问一个数据库一样地访问一个文本文件，这时，使用RandomAccessFile类就是最佳选择。

RandomAccessFile对象类有个位置指示器，指向当前读写处的位置，当读写n个字节后，文件指示器将指向这n个字节后的下一个字节处。刚打开文件时，文件指示器指向文件的开头处，可以移动文件指示器到新的位置，随后的读写操作将从新的位置开始。RandomAccessFile在数据等长记录格式文件的随机（相对顺序而言）读取时有很大的优势，但该类仅限于操作文件，不能访问其它的IO 设备，如网络、内存映像等。

以读写的方式打开一个文件时，如果文件不存在，程序会自动创建此文件。

有关RandomAccessFile类中的成员方法及使用说明请参阅JDK文档。常见API如下：

| 方法名                    | 描述                                    |
| ---------------------- | ------------------------------------- |
| void close();          | 关闭此随机访问文件流并释放与该流关联的所有系统资源。            |
| long getFilePointer(); | 返回此文件中的当前偏移量。                         |
| long length();         | 返回此文件的长度。                             |
| read函数集                | 从文件读                                  |
| void seek(long pos);   | 设置到此文件开头测量到的文件指针偏移量，在该位置发生下一个读取或写入操作。 |
| int skipBytes(int n)   | 尝试跳过输入的 n 个字节以丢弃跳过的字节。                |
| write函数集               | 往文件写                                  |

### 22.4.1 RandomAccessFile 类的构造方法

1. new RandomAccessFile(f, "rw"); 	// 读写方式
2. new RandomAccessFile(f, "r");   // 只读方式

### 22.4.2 向文件中记忆写入数据

```java
	File file = new File("accessFile");
	RandomAccessFile raf = new RandomAccessFile(file, "rw");  
	  // 以下向 raf 文件中写数据  
	raf.writeInt(20);// 占4个字节  
	raf.writeDouble(8.236598);// 占8个字节  
	raf.writeShort(395);// 占2个字节  
	raf.writeUTF("这是一个UTF字符串");// 这个长度写在当前字符串指针的前两个字节处，可用readShort()读取  
	raf.writeBoolean(true);// 占1个字节  
	raf.writeLong(2325451l);// 占8个字节  
	raf.writeUTF("又是一个UTF字符串哈哈");  
	raf.writeFloat(35.5f);// 占4个字节  
	raf.writeChar('a');// 占2个字节  
	raf.close();
```

### 22.4.3 从文件中读取随机记忆的文件内容

```java
	File file = new File("accessFile");
	RandomAccessFile raf = new RandomAccessFile(file, "rw");
	System.out.println(raf.readInt());//读取Int数据，指针会往后移动4字节
	System.out.println(raf.readDouble());//读取Double数据，指针会往后移动8字节
	System.out.println(raf.readUTF());//读取字符串，指针会移到该字符串后
	raf.skipBytes(3);//跳过3个字节，也就是跳过上面例子的 boolen 和 short 值。
	System.out.println(raf.readLong());//读取long值
	short readShort = raf.readShort();//读取字符串的长度
	System.out.println("目前指针处的字符串长度为=" + readShort);
	raf.skipBytes(readShort);//跳过该字符串
	System.out.println(raf.readFloat());//读取float值
	System.out.println(raf.readChar());//读取char值

	//long length = raf.length();
	//System.out.println("文件的总字节数为："+length);

	//long filePointer = raf.getFilePointer();//当前指针的位置，定位到哪个字节了。
	//System.out.println("目前字节指针定位在："+filePointer);

	//raf.seek(4);//直接定位到第4个字节处。
	
```



## 22.5 装饰者模式

### 22.5.1 装饰者模式的定义

​	扩展类功能，(继承也能做到)。但是相比继承，装饰者模式是动态地将责任(扩展功能)附加到对象上，比继承更有弹性。

### 22.5.2装饰者模式的特点

1. 装饰者和被装饰对象**有相同的超类型**。
2. 可以用一个或多个装饰者包装一个对象。
3. 因为装饰者和被装饰者具有相同的类型，所以任何需要原始对象的场合，可以用装饰过的对象代替。
4. 装饰者可以在所委托被装饰者的行为之前/或之后，加上自己的行为，以达到特定的目的。
5. 对象可以在任何时候被装饰，所以可以在运行时动态地、不限量地用你喜欢的装饰者来装饰对象。

### 22.5.3 装饰者模式缺点

​	会在设计中加入大量的小类，如果过度使用，会让程序变得复杂。

### 22.5.4 装饰者模式在JDK中的运用

Java当中的IO是运用了装饰者模式的最典型的例子。
下面是一个简单的例子，通过BufferedReader对象来装饰InputStreamReader对象：

```java
BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
//System.in 是一个 InputStream 对象
```



# 作业：

1. 使用字符流读取一个字符文件，并把其中的所有小写字母变成大写字母，然后写入到另外一个文件中。

2. 利用ObjectOutputStream存入两个Worker 对象， 然后使用 ObjectInputStream读出这两个对象，并打印这两个对象的信息。

3. 假设一个文件中有如下内容，请把这些内容读入内存，并存入List<WorldCup>集合中。 举办时间、举办国、夺冠国

   ```java
   2002,韩国和日本,巴西
   2006,德国,意大利
   2010,南非,西班牙
   2014,巴西,德国
   ```

4. 写一个程序，记录程序在运行时出现过的错误，保存成错误日志！。如：

   * 在输入Int类型的时候输错，把这个记录写入到文件中。

   * 在String 类型 转换 int类型的时候如果出错，把错误的记录写入到文件中。

   * > 格式如下：
     >
     > err:2017年3月30日 15:26:33 字符串转换Int失败 不能把 abc 转成 int 类型。
     >
     > err:2017年3月30日 15:27:12 Scanner输入类型错误，要求输入int，却输入了"xyz"。

   ***提示：捕获程序有可能出现错误的地方，在catch语句中 将错误的信息 用自己的语言组织，写入到File中。***