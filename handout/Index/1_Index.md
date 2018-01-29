# Index

## 1.1 基础常识

### 1.1.1 什么是软件开发

软件开发是根据用户要求建造出软件系统或者系统中的软件部分的过程。软件开发是一项包括需求捕捉、需求分析、设计、实现和测试的系统工程。软件一般是用某种程序设计语言来实现的。通常采用软件开发工具可以进行开发

如：手机应用 是使用 AndroidStudio/Xcode软件开发；java应用 是使用eclipse,[IntelliJ *IDEA](http://www.baidu.com/link?url=ODVV0vzYwLDE2IfpciRoFyAwXCHxloyWavSkmlsWfFanVvdmwF66xRSojxlEByxp),NetBean,开发等...

### 1.1.2 常用的DOS命令

DOS（磁盘操作系统）命令，是[DOS操作系统](http://baike.baidu.com/item/DOS%E6%93%8D%E4%BD%9C%E7%B3%BB%E7%BB%9F)的命令，是一种面向磁盘的操作命令，主要包括目录操作类命令、磁盘操作类命令、文件操作类命令和其它命

dos，是[磁盘操作系统](http://baike.baidu.com/item/%E7%A3%81%E7%9B%98%E6%93%8D%E4%BD%9C%E7%B3%BB%E7%BB%9F)的缩写，是[个人计算机](http://baike.baidu.com/item/%E4%B8%AA%E4%BA%BA%E8%AE%A1%E7%AE%97%E6%9C%BA)上的一类[操作系统](http://baike.baidu.com/item/%E6%93%8D%E4%BD%9C%E7%B3%BB%E7%BB%9F)。从1981年直到1995年的15年间，磁盘操作系统在[IBM PC](http://baike.baidu.com/item/IBM%20PC)兼容机市场中占有举足轻重的地位。而且，若是把部分以DOS为基础的[Microsoft Windows](http://baike.baidu.com/item/Microsoft%20Windows)版本，如[Windows 95](http://baike.baidu.com/item/Windows%2095)、[Windows 98](http://baike.baidu.com/item/Windows%2098)和[Windows Me](http://baike.baidu.com/item/Windows%20Me)等都算进去的话，那么其商业寿命至少可以算到2000年。[微软](http://baike.baidu.com/item/%E5%BE%AE%E8%BD%AF)的所有后续版本中，磁盘操作系统仍然被保留着

[微软](http://baike.baidu.com/item/%E5%BE%AE%E8%BD%AF)图形界面操作系统 Windows NT 问世以来，DOS就是一个后台[程序](http://baike.baidu.com/item/%E7%A8%8B%E5%BA%8F)的形式出现的。可以通过点击运行-[CMD](http://baike.baidu.com/item/CMD)进入运行

进入Dos命令的方法：

> md 中插入图片把图片上传到仓库中, 利用下载链接, 生成https外链

![](https://raw.githubusercontent.com/wangy325/javaSE/master/meterial/img1/cmd.png)

Dos命令界面：

![](https://raw.githubusercontent.com/wangy325/javaSE/master/meterial/img1/dos.png)

md : 创建目录
cd : 进入指定目录      如：C:\Users\Administrator> cd dosTest     则会进入 C:\Users\Administrator\dosTest>
dir : 列出当前目录下的文件以及文件夹
cd.. : 退回到上一级目录
cd/ : 退回到根目录
rd : 删除目录
del : 删除文件
cls：清空窗口
exit : 推出dos命令行

**绝对路径和相对相对的理解**   

比如当前路径为 C:\Users\Administrator>  ，这时候要进入C:\Users\Administrator\dosTest\test目录   则：

绝对路径：从根目录开始，即：C:\Users\Administrator\dosTest\test

相对路径：从当前目录开始：即：.\dosTest\test

> 注意：  . 代表当前目录；  .. 代表上级目录  

### 1.1.3 JAVA简介

#### Java发展简史

* 1995年5月23日，Java语言诞生
* 1996年1月，第一个JDK-JDK1.0诞生
* 1996年4月，10个最主要的操作系统供应商申明将在其产品中嵌入JAVA技术
* 1996年9月，约8.3万个网页应用了JAVA技术来制作
* 1997年2月18日，JDK1.1发布
* 1997年4月2日，JavaOne会议召开，参与者逾一万人，创当时全球同类会议规模之纪录
* 1997年9月，JavaDeveloperConnection社区成员超过十万
* 1998年2月，JDK1.1被下载超过2,000,000次
* 1998年12月8日，JAVA2企业平台J2EE发布
* 1999年6月，SUN公司发布Java的三个版本：标准版(java se)、企业版（java2ee java ee）和微型版(java me)
* 2000年5月8日，JDK1.3发布
* 2000年5月29日，JDK1.4发布
* 2001年6月5日，NOKIA宣布，到2003年将出售1亿部支持Java的手机
* 2001年9月24日，J2EE1.3发布
* 2002年2月26日，J2SE1.4发布，自此Java的计算能力有了大幅提升
* 2004年9月30日18:00PM，J2SE1.5发布，成为Java语言发展史上的又一里程碑。为了表示该版本的重要性，J2SE 1.5更名为Java SE 5.0
* 2005年6月，JavaOne大会召开，SUN公司公开Java SE 6。此时，Java的各种版本已经更名，以取消其中的数字“2”：J2EE更名为Java EE，J2SE更名为Java SE，J2ME更名为Java ME
* 2006年12月，SUN公司发布JRE6.0
* 2009年4月7日Google App Engine开始支持Java
* 2009年04月20日，甲骨文74亿美元收购Sun。取得java的版权 
* 2010年11月，由于甲骨文对于Java社区的不友善，因此Apache扬言将退出JCP
* 2011年7月28日，甲骨文发布java7.0的正式版
* 2014年3月19日，甲骨文公司发布java8.0的正式版。(拉姆达表达式)  

#### Java可以做什么

* 开发桌面应用程序(没有人用)(现在网站主流:HTML5+CSS+Javascirp,PHP)
* 银行软件、商场结算软件
* 开发面向Internet的web应用程序(服务器)
* Android端应用程序开发(Android手机，车载系统，乐视电视等...)
* 提供各行业的解决方案...

#### Java特点

**优点**

1. 一种纯面向对象的编程语言。（java中一切皆对象！）
2. 一种与平台无关的语言。(它提供了在不同平台下运行的解释环境  jvm) 一次编译，到处运行
3. 一种健壮的语言，吸收了C/C++语言的优点。（完善异常）(JAVA有自动异常检查)
4. 有较高的安全性。(自动回收垃圾，强制类型检查，取消指针) (GC自动回收垃圾)

**缺点**

1. 相对于C和C++ 效率比较低   

#### Java体系架构

* JavaSE：Java Platform，Standard Edition  (我们学习的基础版本)

  标准版：各应用平台的基础，桌面开发和低端商务应用的解决方案。

* JavaEE：Java Platform，Enterprise Edition

  企业版：以企业为环境而开发应用程序的解决方案(WEB(JSP+Servlet+JDBC(数据库操作))

* JavaME ：Java Platform, Micro Edition

  微型版：致力于消费产品 和嵌入式设备的最佳解决方案

#### Java跨平台原理

![](https://raw.githubusercontent.com/wangy325/javaSE/master/meterial/img1/cross_platform.png)

#### JVM(Java Virtual Machine)

JVM可以理解成一个可运行Java字节码的虚拟计算机系统 它有一个解释器组件，可以实现Java字节码和计算机操作系统之间的通信,对于不同的运行平台，有不同 的JVM。

#### GC(garbage collection)垃圾回收

**垃圾回收：将不再使用的内存空间应当进行回收**

* 在C/C++等语言中，由程序员负责回收无用内存；
* Java语言消除了程序员回收无用内存空间的责任；
* JVM提供了一种系统线程跟踪存储空间的分配情况。并在JVM的空闲时，检查并释放那些可以被释放的存储空间；
* 垃圾回收器在Java程序运行过程中自动启用，程序员无法精确控制和干预

#### Java SE组成

![](https://raw.githubusercontent.com/wangy325/javaSE/master/meterial/img1/javaLang.png)

## 1.2 win下 JAVA环境的搭建

JDK下载地址：

*   [JDK1.8官网](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)

安装JDK 选择安装目录 安装过程中会出现两次 安装提示 。第一次是安装 jdk ，第二次是安装 jre 。建议两个都安装在同一个java文件夹中的不同文件夹中。（不能都安装在java文件夹的根目录下，jdk和jre安装在同一文件夹会出错）

* 如下图所示

  ![](https://raw.githubusercontent.com/wangy325/javaSE/master/meterial/img1/install_jdk01.png)

2. 安装jdk 随意选择目录 只需把默认安装目录 \java 之前的目录修改即可
   安装jre→更改→ \java 之前目录和安装 jdk 目录相同即可
   > 注：若无安装目录要求，可全默认设置。无需做任何修改，两次均直接点下一步

![](https://raw.githubusercontent.com/wangy325/javaSE/master/meterial/img1/install_jdk02.png)

![](https://raw.githubusercontent.com/wangy325/javaSE/master/meterial/img1/install_jdk03.png)

3. 安装完JDK后配置环境变量>>> 计算机→属性→高级系统设置→高级→环境变量

   ![](https://raw.githubusercontent.com/wangy325/javaSE/master/meterial/img1/install_jdk04.png)

4. 系统变量→新建 JAVA_HOME 变量 

   变量值填写jdk的安装目录（默认是 C:\Program Files\Java\jdk1.8.0_92)

5. 系统变量→找到 Path 变量→编辑

   在变量值最后输入 %JAVA_HOME%\bin;%JAVA_HOME%\jre\bin;

   （注意原来Path的变量值末尾有没有;号，如果没有，先输入;号再输入变量值）

![](https://raw.githubusercontent.com/wangy325/javaSE/master/meterial/img1/install_jdk05.png)

6. 系统变量 → 新建 CLASSPATH 变量

   变量值填写   .;%JAVA_HOME%\lib;%JAVA_HOME%\lib\tools.jar  

   > 注意最前面有一点

![](https://raw.githubusercontent.com/wangy325/javaSE/master/meterial/img1/install_jdk06.png)

​    **系统变量配置完毕**

7. 检验是否配置成功 进入dos命令 输入 java -version 

   若如图所示 显示版本信息 则说明安装和配置成功

   >（注：java 和 -version 之间有空格）

![](https://raw.githubusercontent.com/wangy325/javaSE/master/meterial/img1/install_jdk07.png)

## 1.3 第一个 JAVA 程序 

### 1.3.1在记事本编写程序

1. 创建一个文本文档 名字叫做  MyFist.java

2. 在文本文档中写入如下代码：

   ```java
   public class MyFirst {

   	public static void main(String[] args) {
   		System.out.println("你好世界!");
   	}
   }
   ```

3. 保存该文件

### 1.3.2 在DOS命令窗口编译执行

1. 打开dos命令窗口，使当前目录问 MyFirst.java 所在的目录

2. 在dos命令窗口输入 javac MyFirst.java

3. 上述命令执行成功后，再在命令窗口输入 java MyFirst

4. 如果命令窗口正常输出 “你好世界! ”，则该程序正常运行

   **恭喜你！第一个Java程序运行成功！**

   > 如果控制台提示：编码XXX编码是不可映射的字符。解决办法是把代码的编码改成 ANSI 
   >
   > 1. 记事本可以直接另存为的时候，选中ANSI编码；
   > 2. 如果是Notepad++ 直接在格式中选择 ANSI编码；

### 1.3.3 源程序的编译执行

* Java代码编译是由Java源码编译器来完成，流程图如下所示：

  ![](https://raw.githubusercontent.com/wangy325/javaSE/master/meterial/img1/compail.gif)

* Java字节码的执行是由JVM执行引擎来完成，流程图如下所示：

  ![](https://raw.githubusercontent.com/wangy325/javaSE/master/meterial/img1/execute.gif)

## 1.4 关键字、标识符

### 1.4.1 什么是标识(zhì)符

  标识符：Java对包、类、方法、参数和变量等要素命名时使用的字符序列

  **有了标识符，就可以对这些元素进行访问和操作**

### 1.4.2 标识符的命名规范

1.   由字母、数字、下划线（ _ ）和美元符号（ $ ）组成

2. 不能以数字开头

3. 区分大小写

4. 长度无限制（简短易懂即可，尽量不要太长）

5. 不能是Java中的保留字和关键字

     > 命名标示符的时候尽量有意义！！！规则必须要执行！！！
     >
     > **如：getName、showTime、_number、Student 等**


```
// 以下都是合法的标识符
a  	￥a	$a#12	Public	public	_3	3aa		a_4
```

### 1.4.3 JAVA关键字

> 51个关键字 + 2个保留字
>
> 全部小写

包含:

1. 访问修饰符(3个)
   > private 		public 	protected

2. 包的关键字(2个)
  > import	package

3. 数据类型关键字 (12-3个)
  > 基本数据类型 8 个 + void	~~null~~		~~true~~		~~false~~

4. 流程控制语句关键字(12个)
  > if		else		while	for		switch	case 	default		
  > do		break		continue	return		instanceof	

5. 修饰方法/类/属性/变量的关键字(9个)
  > static		final		super		this		native
  > stricfp		synchronized(线程,同步)		transient	volatile

6. 定义类/接口/抽象和实现接口/继承类,实例化对象的关键字(6个)
  > class		interface		abstract		implements
  > extends		new
7. 异常处理(5个)
  > try		catch		finally		throw		throws
8. 其他(2个)
  > enum(枚举)		assert
9. 保留字(2个)
  > const		goto

| abstract |  default  |     if     |   private    |    this     |
| :------: | :-------: | :--------: | :----------: | :---------: |
| boolean  |    do     | implements |  protected   |    throw    |
|  break   |  double   |   import   |    public    |   throws    |
|   byte   |   else    | instanceof |    return    |    case     |
|  extend  |    int    |   short    |     try      |    catch    |
|  final   | interface |   static   |     void     |    char     |
| finally  |   long    |   class    |    float     |   native    |
|  super   |   while   |    for     |     new      |   switch    |
| ~~null~~ | continue  |  package   | synchronized |  transient  |
| strictfp | volatile  | const(保留字) |  goto(保留字)   | enum/assert |

> 另外，根据 Java官方文档，false/true/null 不属于Java 关键字，但是属于Java默认的标识符

## 1.5 进制转换

### 1.5.1 二进制与十进制的转换


1. 正整数转二进制
   * 要点：除二取余，倒序排列

   * 解释：将一个十进制数除以二，得到的商再除以二，以此类推直到商等于1或0为止，倒取 除得的余数，即为二进制的结果

     **例如：把52换算成二进制数，计算结果如图：**

     ![](file:///home/wangy325/git/javaSE/meterial/img/decimal2binary.gif)

     52除以2得到的余数依次为：0、0、1、0、1、1，倒序排列，所以52对应的二进制数为：110100。

     由于计算机内部表示数的字节单位都是定长的，都是2的幂次方展开，如8位，16位，或32位…。

     于是，一个二进制数用计算机表示时，位数不足2的幂次方时，高位上要补足若干个0

     即：
     $$
     (52)_{10}=(00110100)_2
     $$

2. 负整数转二进制

   * 要点：取反加一

   * 解释：将该负数整数对应的正整数先转换成二进制，然后对其取反，再对取反后的结果加1即可

     **例如：把-52换算成二进制：**

     1. 先取得52的二进制：00110100

     2. 对所得到的二进制数取反：11001011

     3. 将取反后的数值加一即可：11001100

        > (-128 ) = (1000 0000)  最前面的 1 是符号位, 限长度8位
        >
        >  (128)  = (1000 0000)  最前面不是符号位, 长度必须>8位

     即：
     $$
     (-52)_{10}=(11001100)_2
     $$

3. 二进制转十进制

   * 解释：二进制用数值乘以2的幂次方依次相加

     **将二进制110换算成十进制：**

     1. 首位补齐位数：00000110

     2. 首位为0，则为整数，那么将二进制中的三位数分别于下边对应的值相乘后再相加得到的值为换算为十进制的结果：

        ![](file:///home/wangy325/git/javaSE/meterial/img/bin2dec.jpg)

     3. 如果二进制补足位数之后首位为1，那么其对应的十进制为负数，那么需要先对二进制减1，再取反然后再换算。

        * 比如：11111010，首位为1，那么需要先减1，为：11111001，再取反，即：-00000110；
        * 那么00000110 对应的十进制为6，因此 11111010 对应的十进制为-6；

        即：
        $$
        (11111010)_2=(-6)_{10}
        $$






## 1.6 变量名的命名规范

### 1.6.1 JAVA中的命名规范

1. 包名：多单词组成时所有字母都小写

   xxx.yyy.zzz    --->  com.公司简写.包名      ----->  com.xyd.demo

2. 类名接口名：多单词组成时，所有单词的首字母大写

   XxxYyyZzz           HelloWorld

3. 变量名和方法名：多单词组成时，第一个单词首字母小写，第二个单词开始每个单词首字母大写

   xxxYyyZzz              nameAge

   常量名：所有字母都大写，多单词时每个单词用下划线连接

   XXX_YYY_ZZZ       CURRENT_DATE

### 1.6.2 基本数据类型

##### 内置数据类型

Java语言提供了八种基本类型。六种数字类型（四个整数型，两个浮点型），一种字符类型，还有一种布尔型

* int     
* long
* float
* double
* boolean
* char
* byte
* short

### 1.6.3 引用数据类型

* 类 (Class/String等)
* 接口(Interface)
* 数组(Array)

> 所有的对象都属于引用数据类型，也可以说除了基本数据类型外的所有的类型都是引用数据类型

### 1.6.3 什么是变量

* 变量    ：程序执行中数值可变的数据
* 变量名：定义变量的标识符
* 变量值：内存单元中所装载的数据

> 变量其实是内存中的一小块区域，使用变量名来访问这块区域
>
> 因此，每一个变量使用前必须要先申请(声明)(强类型语言的特点)，然后必须进行赋值(初始化)，才能使用

​	true/false如：

* int i = 100;     声明且初始化

* int y;  变量的声明

  y = i +10;  赋值(初始化)



## 1.7 基本数据类型有哪些，数据类型的取值范围

| 数据类型    | 内存大小       | 取值范围                                     |
| :------ | :--------- | :--------------------------------------- |
| byte    | 1 字节(8bit) | -128 ~ 127                               |
| short   | 2 字节       | -2^15 ~ (2^15-1)    -32768~32767         |
| char    | 2 字节       | 0 ~ 2^16-1   0~65535  每个字符能表示一个汉字        |
| int     | 4 字节       | -2^31 ~ 2^31-1 即：-2147483648 ~ 2147483647 |
| float   | 4 字节       | ???[参见](http://blog.csdn.net/shareus/article/details/51436693) |
| long    | 8 字节       | -2^63 ~ 2^63-1                           |
| double  | 8 字节       | ??? // 后续bigDecimal再考虑精度问题               |
| boolean | 1/8 字节     | true/false                               |

**byte：**

- byte 数据类型是8位、有符号的，以二进制补码表示的整数
- 最小值是 -128（-2^7）
- 最大值是 127（2^7-1）
- 默认值是 0
- byte 类型用在大型数组中节约空间，主要代替整数，因为 byte 变量占用的空间只有 int 类型的四分之一
- 例子：byte a = 100，byte b = -50

**short：**

- short 数据类型是 16 位、有符号的以二进制补码表示的整数
- 最小值是 -32768（-2^15）
- 最大值是 32767（2^15 - 1）
- Short 数据类型也可以像 byte 那样节省空间。一个short变量是int型变量所占空间的二分之一
- 默认值是 0
- 例子：short s = 1000，short r = -20000

**int：**

- int 数据类型是32位、有符号的以二进制补码表示的整数
- 最小值是 -2,147,483,648（-2^31）
- 最大值是 2,147,483,647（2^31 - 1）
- 一般地整型变量默认为 int 类型
- 默认值是 0 
- 例子：int a = 100000, int b = -200000

**long：**

- long 数据类型是 64 位、有符号的以二进制补码表示的整数
- 最小值是 -9,223,372,036,854,775,808（-2^63）
- 最大值是 9,223,372,036,854,775,807（2^63 -1）
- 这种类型主要使用在需要比较大整数的系统上
- 默认值是 0L
- 例子： long a = 100000L，Long b = -200000L
  "L"理论上不分大小写，但是若写成"l"容易与数字"1"混淆，不容易分辩。所以最好大写

> 以下浮点数只用于科学计算, 其再计算机中的表示也是科学表示法, 如1.301e10
>
> 直接用浮点数进行数学运算, 可能会出现精度丢失问题

**float：**

- float 数据类型是单精度、32位、符合IEEE 754标准的浮点数
- float 在储存大型浮点数组的时候可节省内存空间
- 默认值是 0.0f
- 浮点数不能用来表示精确的值，如货币
- 例子：float f1 = 234.5f

**double：**

- double 数据类型是双精度、64 位、符合IEEE 754标准的浮点数
- 浮点数的默认类型为double类型
- double类型同样不能表示精确的值，如货币
- 默认值是 0.0d
- 例子：double d1 = 123.4[d]
- d可省略,编译器默认为double类型,但是单精度float 的`f`不可省略

**boolean：**

- boolean数据类型表示一位的信息；
- 只有两个字面值(量)：true 和 false
- 这种类型只作为一种标志来记录 true/false 情况
- **默认值是 false**
- 例子：boolean one = true

**char：**

- char类型是一个单一的 16 位 Unicode 字符
- 最小值是 \u0000（即为0）
- 最大值是 \uffff（即为65,535）
- char 数据类型可以储存任何字符
- 例子：char letter = 'A'   如果是能用ascii 表示的字符, 此时存储的值是字符的ascii码

### 1.7.9 基本数据类型转换

#### 1.7.9.1 自动类型转换

**容量小的类型自动转换成容量大的数据类型**

* byte,short,char < int < long < float < double

* byte,short,char之间不会互相转换,它们三个计算时首先转成int类型 (运算的时候回自动类型提升)

* > byte short char 进行运算的时候类型自动提升为 int

  ![](file:///home/wangy325/git/javaSE/meterial/img/type_convert.png)

如：

​	int a = 4 ; 

​	double b = a ;

#### 1.7.9.2 强制类型转换

**容量大的类型转换成容量小的数据类型时，要加上强制转换符，但可能造成精度降低或溢出，使用时要格外注意**

如：

​	float f =14.8f;

​	int i = (int)f;

> boolean值不能与其他任何类型之间进行强制类型转换


## 1.8 运算符

### 1.8.1 赋值运算符

| 运算符  | 名称   | 用法          | 描述                   |
| ---- | ---- | ----------- | -------------------- |
| =    | 赋值   | int a = 3 ; | 将 = 右边的值 赋值给 = 左边的变量 |

### 1.8.2 算术运算符

| 名称   | 运算符  | 用法     | 结果   |
| ---- | ---- | ------ | ---- |
| 加    | +    | 5 +  2 | 7    |
| 减    | -    | 5-2    | 3    |
| 乘    | *    | 5*2    | 10   |
| 除    | /    | 5/2    | 2    |
| 取模   | %    | 5%2    | 1    |

### 1.8.3 一元运算符

| 运算符  | 用法               | 描述   |
| :--- | :--------------- | ---- |
| ++   | (先加)++x 或x++(先用) | 自增1  |
| --   | (先减)--x或x--(先用)  | 自减1  |

### 1.8.4 关系(比较)运算符

| 运算符  | 名称   | 用法   | 结果(Boolean值) |
| ---- | ---- | ---- | ------------ |
| >    | 大于   | 2>1  | true         |
| <    | 小于   | 2<1  | false        |
| >=   | 大于等于 | 2>=1 | true         |
| <=   | 小于等于 | 2<=1 | flase        |
| ==   | 等于   | 2==1 | false        |
| !=   | 不等于  | 2!=1 | true         |

### 1.8.5 逻辑运算符(只能比较 boolean值，结果也为 boolean值)

| 运算符  |  名称   |      用法      |        描述        |
| :--: | :---: | :----------: | :--------------: |
|  &&  | (短路)与 |  条件1 && 条件2  | 只要两个条件有一个为假，结果为假 |
|  &   |   与   |  条件1 & 条件2   | 只要两个条件有一个为假，结果为假 |
| \|\| | (短路)或 | 条件1 \|\| 条件2 | 只要两个条件有一个为真，结果为真 |
|  \|  |   或   |  条件1 \| 条件2  | 只要两个条件有一个为真，结果为真 |
|  !   |   非   |     !条件      | 条件为真时，结果为假，反之亦然  |
|  ^   |  异或   |  条件1 ^ 条件2   | 两个条件结果相同时为假，不同为真 |

> 解释：短路
>
> 当  条件1 && 条件2   如果条件1为false，结果明显为false，所以条件2不会再判断
>
> 当  条件1  &  条件2   如果条件1为false，结果明显为false，但条件2语句一样会被运算

### 1.8.6 位运算符(2进制运算符)

| 运算符  | 名称    | 用法                             | 描述                           |
| :--- | ----- | ------------------------------ | :--------------------------- |
| &    | 按位与   | 00001001&00001110 -> 00001000  | 按位比较，只要有0，则取0                |
| \|   | 按位或   | 00001001\|00001110 -> 00001111 | 按位比较，只要有1，则取1                |
| ^    | 按位异或  | 00001001^00001110 -> 00000111  | 按位比较，相同取0，不同取1               |
| ~    | 按位非   | ~00000010 -> 11111101          | 对位取反                         |
| <<   | 左移    | 01000011 << 2  -> 00001100     | 向左移动2位，右边补0，超出位数范围则舍去        |
| >>   | 带符号右移 | 11111110 >> 2 -> 11111111      | 右移2位，左边补**符号位**，超出位数范围则舍去    |
| >>>  | 无符号右移 | 11111110 >>> 2 -> 00111111     | 右移2位，左边补0，超出位数范围则舍去(非常危险的运算) |

> 经典案例1：用最快的速度计算2的3次方；  
>
> ```java
> public static void main(String[] args){
>   int num = 2;
>   num = num << 2;
>   System.out.print(num);
> }
> ```
>
> 经典案例2：int a =1;int b =2;不借助第三个变量，交换两个数的值； 提示：  使用^
>
> ```java
> public static void main(String[] args){
>   int a = 1, b = 2;
> 	a = a^b &b;
> 	b = -(~a+a);
> 	System.out.println("a =" +a +", b="+b);
> }
> ```
>
> ```java
> public static void main(String [] args){
>
> 		int num = 10;
> 		printInfo(num);
> 	    num = num<<1;
> 	    printInfo(num);
> 	    
> 	    num = 10;
> 	    num = num >>1;
> 	    printInfo(num);
> 	}
> 	
> 	public static void printInfo(int num){
> 		System.out.println("num:"+num);
>       // Integer.toBinaryString(int) 
>       // 将int 转成二进制数 字符串
>       // int 可以是十,十六(0x),八进制(0)表示的整数
> 		System.out.println("二进制"+Integer.toBinaryString(num));
> 	}
> ```

### 1.8.7 三目(三元)运算符

| 运算符  | 名称   |
| ---- | ---- |
| ?    | 吗    |
| :    | 否则   |

**用法：**

* zhangSanScore > 98 ? "奖励Iphone 8 " : "没有任何奖励" ;

  > 语法解释：张三的成绩大于98吗？如果大于"奖励Iphone 8 "，否则"没有任何奖励"；

### 1.8.8 字符串连接运算符

| 运算符  | 名称    | 用法                    | 结果          |
| ---- | ----- | --------------------- | ----------- |
| +    | 字符串追加 | String s="张三"+"是个男孩"; | s -> 张三是个男孩 |

> 注：只要+的两端有一端是字符串，则这个时候+就变成了字符串连接符

## 1.9 表达式的值和类型

**表达式是符合一定语法规则的运算符和操作数的序列**

1. 表达式的类型和值

   * 类型：表达式的值的数据类型即为表达式的类型

   * 值：对表达式中操作数进行运算得到的结果称为表达式的值

     > 实数常量，(如:1.5)默认类型为 double
     >
     > 整数常量，(如:123)默认类型为 int

2. 表达式的运算顺序

   * 首先应按照运算符的优先级从高到低的顺序进行
   * 优先级相同的运算符按照事先约定的结合方向进行(一般从左到右)

## 1.10 变量的作用域

```java
public class MyFirst {
	int a = 1;	
	public void xxx() {
		int b = 2;
      System.out.println(a); //:~ 1
	}
  	public void yyy() {
		int a = 3;
      	System.out.println(a); //:~ 3
	}
}
```

上述代码中a变量是在class的 { } 中定义的，它的作用域就是这个class内，任意位置都可以访问,而变量b是在方法xxx的 { } 中声明的，它作用域就只限于xxx方法中；

在两个不同作用域范围下如果出现同名称变量时；则作用范围小的变量在其作用域内会覆盖作用范围大的变量，上述例子中方法yyy的 { } 中的变量和类中的变量同名，都为a，那么在方法yyy内，a变量的值以方法内声明为准

### 获取键盘输入

```java
import java.util.Scanner;//这句代码不能少
public clsss Test{
    public static void main(String[] args){
        //创建一个可以从键盘读取数据的扫描器
        Scanner sc = new Scanner(System.in);
        // 从键盘读取输入的int型的整数。并把读取到整数存储到变量num中
        int num = sc.nextInt();
        // 从键盘读取输入的String类型。并把读取到整数存储到变量name中
        String name = sc.next();
         //从键盘读取输入的Double类型。并把读取到整数存储到变量salary中
         double salary = sc.nextDouble();
        System.out.println(num);
    }
}
```

Scanner的练习：

1，获取键盘输入，输入姓名，年龄，性别

![](https://raw.githubusercontent.com/wangy325/javaSE/master/meterial/img1/scanner01.png)

2, 吃饭 点了2个菜   西红柿鸡蛋，  16d    红烧鱼   24d  

   打折: 0.8折   打印总价多少，实际结算给多少钱？

![](https://raw.githubusercontent.com/wangy325/javaSE/master/meterial/img1/scanner01.png)



练习：

1. *初始化a=3，b=4;计算下：*

   ```java
   a = a-b;
   b = a+b;
   a = a-b;
   ```

2. *初始化a=3,b=4;交换a,和b的数值*

   ​

3. *用户输入四位会员号：计算四位会员号的之和（个位，十位，百位，千位上数字求和)*

   ​

