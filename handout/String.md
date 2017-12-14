## 常用类

## 14.1 基本数据类型的包装类

​	Java是一种纯面向对象语言，但是java中有8种基本数据类型，破坏了java为纯面向对象的特征。为了承诺在java中一切皆对象，java又给每种基本数据类型分别匹配了一个类，这个类我们称之为包装类。

>注意：每个基本数据类型都有一个与之匹配的包装类。

### 14.1.1 基本数据类型与其包装类

![](http://ojx4zwltq.bkt.clouddn.com/17-2-9/7352646-file_1486600515802_2c5d.png)

**包装类的层次结构：**

![](http://ojx4zwltq.bkt.clouddn.com/17-2-9/3135766-file_1486600582531_13f7.png)

### 14.1.2 数据的装箱和拆箱

#### 14.1.2.1 装箱和拆箱

装箱：把基本数据类型包装为对应的包装类对象 

1. Integer i1 = new Integer(10);  // 利用构造方法
2. Integer i2 = Integer.valueOf(10); //利用包装类中的静态方法

拆箱：把包装类对象转换为对应的基本数据类型。

1. int i3= i1.intValue();  //返回包装类对象i1对应的基本数据

#### 14.1.2.2 自动装箱和自动拆箱

前面的装箱和拆箱操作，相对较麻烦。自jdk1.5开始，java增加的对基本数据类型的自动装箱和自动拆箱操作。java编译器在编译时期会根据源代码的语法来决定是否进行装箱或拆箱。

1. 自动装箱：可以直接把一个基本数据类型赋值给包装类

   例如： Double d = 3.3;  //自动装箱操作

2. 自动拆箱：可以直接把一个包装类对象，赋值给基本类型

   例如：int a = new Integer(3); //自动拆箱。

自动装箱和自动拆箱，简化了对包装类的操作。

## 14.2 String相关类

### 14.2.1 String类

#### 14.2.1.1 概述

1. String是不可变类，即一旦一个String对象被创建, 包含在这个对象中的字符序列是不可改变的, 直至该对象被销毁。 
2. String类是final类，不能有子类。

#### 14.2.1.2 创建字符串对象

1. 使用new关键字

   ```java
   String s1 = new String(“ab”);  
   ```

2. 使用字符串常量直接赋值 

   ```java
   String s2 = “abc”; 
   ```

3. 使用”+”运算符进行字符串连接

   ```java
   String s3 = “abc” + “d”;
   String s4 = s3 + 5;  //abcd5
   ```

#### 14.2.1.3 常量池概念和创建对象规则

常量池概念：

​	Java运行时会维护一个String Pool（String池）， 也叫“字符串缓冲区”。String池用来存放运行时中产生的各种字符串，并且池中的字符串的内容不重复。运行时常量池（Runtime Constant Pool）是方法区（Method Area）的一部分，是各线程共享的内存区域。

String对象的创建很讲究，关键是要明白其原理。[new String("abc")原理](http://www.cnblogs.com/justinli/p/4064128.html)

![](http://incdn1.b0.upaiyun.com/2015/04/4014f5bafd75ba0146d66de04fc880a4.png)

1. 当使用任何方式来创建一个字符串对象s时，Java运行时（运行中JVM）会拿着这个s在String池中找是否存在内容相同的字符串对象，如果不存在，则在池中创建一个字符串s，否则，不在池中添加。

2. 使用直接指定或者使用纯字符串**(常量)**串联来创建String对象，则仅仅会检查维护String池中的字符串，池中没有就在池中创建一个，有则不创建！但绝不会在堆区再去创建该String对象。

   ```java
   public static void main(String[] args){
   	String a = "a1";
       String b = "a"+ 1;
       System.out.println(a==b);
   }//true
   ```

3. 使用包含变量的表达式来创建String对象，则不仅会检查维护String池，而且还会在堆区创建一个String对象。最后指向堆内存中的对象

   ```java
   public static void main(String[] args){
   	String a = "ab";
       String k = "b";
       String b = "a"+ k;//编译器不能确定为常量(会在堆区创建一个String对象)
       System.out.println(a==b);
   }//false
   ```

4. ```java
   public static void main(String[] args){
   	String a = "ab";
   	final String k = "b";
       String b = "a"+ k;    //k加final后是常量，可以在编译器确定b
       System.out.println(a==b);
   }//true
   ```

5. ```java
   public static void main(String[] args){
   	String a = "ab";
   	final String k = getK();
       String b = "a"+ k;//k是通过函数返回的，虽然我们知道它是final的，但程序不能确定具体返回啥，所以要到运行期才知道bb的值。理论上，整个方法的返回值也变成了一个变量。
   	System.out.println(a==b);
   }//false

   private static String getK(){
   	return "b"; 
   }
   ```

6. ```java
   private static String a = "ab";
   public static void main(String[] args){
   	String s1 = "a";
       String s2 = "b";
       String s = s1 + s2;//+的用法
       System.out.println(s == a);
       System.out.println(s.intern() == a);//intern的含义(将字符串堆对象放入常量池，并返回指向放入常量池后的引用)
   }//flase true
   ```

7. Java中，只要使用new关键字来创建对象，则一定会（在堆区）创建一个新的对象。并且让引用指向堆中的对象。

   ```java
   private static String a = new String("ab");//只要使用new关键字来创建对象，则一定会（在堆区）创建一个新的对象。
   public static void main(String[] args){
   	String s1 = "a";
       String s2 = "b";
       String s = s1 + s2;
       System.out.println(s == a);
       System.out.println(s.intern() == a);
       System.out.println(s.intern() == a.intern());
   }//flase false true 
   ```
   ​


#### 14.2.1.4 字符串常用方法

##### 14.2.1.4.1 获得新字符串对象的常用方法

1. public String  concat(String str)   在原有字符串的尾部添加参数字符串，返回一个新的字符串（总是堆内存中的对象），如果str的长度为0，则返回原字符串。str不能为空null。

2. public String  subString(int beginIndex) 获得从beginIndex开始到结束的子字符串。（ 包括beginIndex位置的字符）

3. public String  subString(int beginIndex,int endIndex) 获得从beginIndex开始到endIndex的子字符串。（ 包括beginIndex位置的字符,但不包含endIndex）

4. public String toLowerCase()  把字符串中的英文字符全部转换为小写字符，返回值为转换后的新的字符串。

5. public String toUpperCase()   把字符串中的英文字符全部转换为大写字符，返回值为转换后的新的字符串。

6. public String trim()  把字符串中的首尾的空白字符去掉，返回去掉首尾空白字符的新字符串

7. public String replace(CharSequence target,  CharSequence replacement) 使用指定的字面值替换序列替换此字符串所有匹配字面值目标序列的子字符串

   ```java
   String src = new String("ab43a2c43d");
   System.out.println(src.replace("3","f")); =>ab4f2c4fd
   ```

8. public String replace(char oldChar, char newChar) 返回一个新的字符串，它是通过用 newChar 替换此字符串中出现的所有 oldChar 得到的。

   ```java
   　String src = new String("ab43a2c43d");
   　System.out.println(src.replace('3','f')); =>ab4f2c4fd
   ```

##### 14.2.1.4.2 计算字符串长度的方法

​	public int length();  //返回字符串字符的个数。

##### 14.2.1.4.3 字符串比较

1. ”==”表示判断该两个字符串是否为同一对象，即在内存中的地址是否一样。如果一样则返回true 否则返回false;  和我们通常的是否为同一对象的是一样的。

2. boolean equals(Object anObject)   将此字符串与指定的对象比较。注意此时比较的是内容是否相等(字符串类对此方法进行了覆写)。 

   例如：

   ```java
   String s1 = new String(“abc”);  
   String s2 = “abc”
   ```

   则：

   ```java
   s1==s2  //false
   s1.equals(s2);  //true
   ```

3. boolean equalsIgnoreCase(String anotherString) 将此 String 与另一个 String 比较，不考虑大小写。

   例如：

   ```java
   ”abc”. equalsIgnoreCase(“AbC”); // true
   ```

4. int compareTo(String value)  返回参与比较的前后两个字符串的asc码的差值

   1. ```java
      String a="a",b="b";
      System.out.println(a.compareto.b);
      则输出-1；
      若a="a",b="a"则输出0；
      若a="b",b="a"则输出1；
      ```

   2. 单个字符这样比较，若字符串比较长呢？

      ```java
      若a="ab",b="b",则输出-1；
      若a="abcdef",b="b"则输出-1；
      ```

      > 也就是说，如果两个字符串首字母不同，则该方法返回首字母的asc码的差值；

   3. 如果首字母相同呢？

      ```java
      若a="ab",b="a",输出1；
      若a="abcdef",b="a"输出5；
      若a="abcdef",b="abc"输出3；
      若a="abcdef",b="ace"输出-1；
      ```

   > 即：参与比较的两个字符串如果首字符相同，则比较下一个字符，直到有不同的为止，返回该不同的字符的asc码差值，如果两个字符串不一样长，可以参与比较的字符又完全一样，则返回两个字符串的长度差值。
   >
   > 提示：查看单个字符的asc码的值(使用int 接收 char字符，再打印输出即可)
   >
   > ```java
   > int i ='我';
   > int j = 'b';
   > System.out.println(i);
   > System.out.println(j);
   > ```

   ​

5. int compareToIgnoreCase(String val) 按字典顺序比较两个字符串，不考虑大小写 

6. boolean startsWith(String value)  检查一个字符串是否以参数字符串开始。

7. boolean endsWith(String value)  检查一个字符串是否以参数个字符串结束。

##### 14.2.1.4.4 字符串查找

1. public int indexOf(String str); 返回 str 在字符串中的第一次出现的下标的位置，如果不存在，返回-1
2. public int lastIndexOf(String str);返回 str 在字符串中的最后一次出现的下标的位置，如果不存在，返回-1
3. public char charAt(int index) ;返回字符串的 index 下标位置的字符。
4. public boolean contains(CharSequence s); 判断字符串中是否包含 s 。

##### 14.2.1.4.5 其他类型转换成字符串

在String类中定义了一些静态的重载方法

```java
public static String valueOf(…);
```

可以将基本类型数据、Object类型转换为字符串。如：

```java
public static String valueOf(double d);//把double类型数据转成字符串

public static String valueOf(Object obj);//调用obj的toString()方法得到它的字符串表示形式。
```

***还有一种最简单的方法：***

* 把任意对象、基本数据类型与一个空字符串相连接则可以直接转换成字符串，与上面效果相同。

  如：

  ```java
  int i = 18;

  String str = i + "";
  ```

##### 14.2.1.4.6 String 与 char[] 的 转换

1. char[] toCharArray()；拷贝一份String中的所有字符。返回char[]
2. new String(c);根据默认编码，将char[]转成String
3. new String(c,"UTF-8");根据UTF-8编码，将char[]转成String
4. new String(value, offset, count);根据默认编码，将value(char[])，从offset(包含offset)位置开始，截取count个字符，转成String。

##### 14.2.1.4.7 String  与 byte[] 的 转换

1. byte[] getBytes()；根据系统默认的编码，得到字符串的byte[]。
2. byte[] getBytes("UTF-8");根据UTF-8编码， 得到的字符串的byte[]。
3. new String(bytes);根据默认编码，将byte[]转成String。
4. new String(bytes,"UTF-8");根据UTF-8编码，将byte[]转成String。
5. new String(bytes, offset, length);根据默认编码，将bytes(byte[])，从offset(包含offset)位置开始，取count个字节转成String。
6. new String(bytes, offset, length,"UTF-8");根据UTF-8编码，将bytes(byte[])，从offset(包含offset)位置开始，取count个字节转成String。

### 14.2.2 StringBuffer类

#### 14.2.2.1 概述

StringBuffer代表可变的字符序列。

StringBuffer称为字符串缓冲区，它的工作原理是：预先申请一块内存，存放字符序列，如果字符序列满了，会重新改变缓存区的大小，以容纳更多的字符序列。

StringBuffer 与 String 最大的不同是，String是不可变字符串。而StringBuffer是可变字符串对象。

#### 14.2.2.2 创建StringBuffer对象

​	StringBuffer可以理解为一个字符串容器，可以动态的改变容器中的内容。

​	StringBuffer类的常用构造方法：

* StringBuffer()。构造一个其中不带字符的字符串缓冲区，初始容量为 16 个字符；
* StringBuffer(String str)。构造一个字符串缓冲区，并将其内容初始化为指定的字符串内容

> 熟悉 StringBuffer 常用的方法...

Typora 编辑 代码写法：http://www.jianshu.com/p/092de536d948

### 14.2.3 StringBuilder类

StringBuilder与StringBuffer的用法完全一致，唯一的区别是StringBuffer是线程安全的，而StringBuilder不是线程安全的。所以StringBuilder的性能要比StringBuffer要好。单线程推荐使用StringBuilder，多线程使用StringBuffer。

## 15.3 正则表达式       

### 15.3.1 概念

正则表达式使用单个字符串来描述、匹配一系列符合某个句法规则。在很多文本编辑器里，正则表达式通常被用来检索、替换那些符合某个模式的文本。

### 15.3.2 字符串使用正则表达式的方法

1. matches(String regex) 

           告知此字符串是否匹配给定的正则表达式。

   如：匹配邮箱

   ```java
   String emial = "xyd@163.com";

   boolean matches = emial.matches("^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$");
   		
   System.out.println(matches);//true
   ```

2. public String replaceAll(String regex, String replacement) 使用给定的 replacement 替换此字符串所有匹配给定的正则表达式的子字符串。

   ```java
   　　String src = new String("ab43a2c43d");
   　　System.out.println(src.replaceAll("\\d","f")); =>abffafcffd
   　　System.out.println(src.replaceAll("a","f")); =>fb43fc23d
   ```

3. public String replaceFirst(String regex, String replacement) 使用给定的 replacement 替换此字符串匹配给定的正则表达式的第一个子字符串。

   ```java
   　　String src = new String("ab43a2c43d");
   　　System.out.println(src.replaceFirst("\\d,"f")); =>abf32c43d
   　　System.out.println(src.replaceFirst("4","h")); =>abh32c43d
   ```

4. split(String regex) ; 根据给定正则表达式的匹配拆分此字符串。

   ```java
   String mime = "12:2E:D2:4F:14:EE";
   		
   String[] split = mime.split(":");
   		
   for (String str : split) {
   	System.out.println(str);
   }
   //将输出:
   //12
   //2E
   //D2
   //4F
   //14
   //EE
   ```

### 15.3.3 常用正则表达式

| \           | 将下一个字符标记为一个特殊字符、或一个原义字符、或一个 向后引用、或一个八进制转义符。例如，'n' 匹配字符 "n"。'\n' 匹配一个换行符。序列 '\\' 匹配 "\" 而 "\(" 则匹配 "("。 |
| ----------- | ---------------------------------------- |
| ^           | 匹配输入字符串的开始位置。如果设置了 RegExp 对象的 Multiline 属性，^ 也匹配 '\n' 或 '\r' 之后的位置。 |
| $           | 匹配输入字符串的结束位置。如果设置了RegExp 对象的 Multiline 属性，$ 也匹配 '\n' 或 '\r' 之前的位置。 |
| *           | 匹配前面的子表达式零次或多次。例如，zo* 能匹配 "z" 以及 "zoo"。* 等价于{0,}。 |
| +           | 匹配前面的子表达式一次或多次。例如，'zo+' 能匹配 "zo" 以及 "zoo"，但不能匹配 "z"。+ 等价于 {1,}。 |
| ?           | 匹配前面的子表达式零次或一次。例如，"do(es)?" 可以匹配 "do" 或 "does" 。? 等价于 {0,1}。 |
| {n}         | n 是一个非负整数。匹配确定的 n 次。例如，'o{2}' 不能匹配 "Bob" 中的 'o'，但是能匹配 "food" 中的两个 o。 |
| {n,}        | n 是一个非负整数。至少匹配n 次。例如，'o{2,}' 不能匹配 "Bob" 中的 'o'，但能匹配 "foooood" 中的所有 o。'o{1,}' 等价于 'o+'。'o{0,}' 则等价于 'o*'。 |
| {n,m}       | m 和 n 均为非负整数，其中n <= m。最少匹配 n 次且最多匹配 m 次。例如，"o{1,3}" 将匹配 "fooooood" 中的前三个 o。'o{0,1}' 等价于 'o?'。请注意在逗号和两个数之间不能有空格。 |
| ?           | 当该字符紧跟在任何一个其他限制符 (*, +, ?, {n}, {n,}, {n,m}) 后面时，匹配模式是非贪婪的。非贪婪模式尽可能少的匹配所搜索的字符串，而默认的贪婪模式则尽可能多的匹配所搜索的字符串。例如，对于字符串 "oooo"，'o+?' 将匹配单个 "o"，而 'o+' 将匹配所有 'o'。 |
| .           | 匹配除 "\n" 之外的任何单个字符。要匹配包括 '\n' 在内的任何字符，请使用像"**(.\|\n)**"的模式。 |
| (pattern)   | 匹配 pattern 并获取这一匹配。所获取的匹配可以从产生的 Matches 集合得到，在VBScript 中使用 SubMatches 集合，在JScript 中则使用 $0…$9 属性。要匹配圆括号字符，请使用 '\(' 或 '\)'。 |
| (?:pattern) | 匹配 pattern 但不获取匹配结果，也就是说这是一个非获取匹配，不进行存储供以后使用。这在使用 "或" 字符 (\|) 来组合一个模式的各个部分是很有用。例如， 'industr(?:y\|ies) 就是一个比 'industry\|industries' 更简略的表达式。 |
| (?=pattern) | 正向预查，在任何匹配 pattern 的字符串开始处匹配查找字符串。这是一个非获取匹配，也就是说，该匹配不需要获取供以后使用。例如，'Windows (?=95\|98\|NT\|2000)' 能匹配 "Windows 2000" 中的 "Windows" ，但不能匹配 "Windows 3.1" 中的 "Windows"。预查不消耗字符，也就是说，在一个匹配发生后，在最后一次匹配之后立即开始下一次匹配的搜索，而不是从包含预查的字符之后开始。 |
| (?!pattern) | 负向预查，在任何不匹配 pattern 的字符串开始处匹配查找字符串。这是一个非获取匹配，也就是说，该匹配不需要获取供以后使用。例如'Windows (?!95\|98\|NT\|2000)' 能匹配 "Windows 3.1" 中的 "Windows"，但不能匹配 "Windows 2000" 中的 "Windows"。预查不消耗字符，也就是说，在一个匹配发生后，在最后一次匹配之后立即开始下一次匹配的搜索，而不是从包含预查的字符之后开始。 |
| x\|y        | 匹配 x 或 y。例如，'z\|food' 能匹配 "z" 或 "food"。'(z\|f)ood' 则匹配 "zood" 或 "food"。 |
| [xyz]       | 字符集合。匹配所包含的任意一个字符。例如， '[abc]' 可以匹配 "plain" 中的 'a'。 |
| [^xyz]      | 负值字符集合。匹配未包含的任意字符。例如， '[^abc]' 可以匹配 "plain" 中的'p'、'l'、'i'、'n'。 |
| [a-z]       | 字符范围。匹配指定范围内的任意字符。例如，'[a-z]' 可以匹配 'a' 到 'z' 范围内的任意小写字母字符。 |
| [^a-z]      | 负值字符范围。匹配任何不在指定范围内的任意字符。例如，'[^a-z]' 可以匹配任何不在 'a' 到 'z' 范围内的任意字符。 |
| \b          | 匹配一个单词边界，也就是指单词和空格间的位置。例如， 'er\b' 可以匹配"never" 中的 'er'，但不能匹配 "verb" 中的 'er'。 |
| \B          | 匹配非单词边界。'er\B' 能匹配 "verb" 中的 'er'，但不能匹配 "never" 中的 'er'。 |
| \cx         | 匹配由 x 指明的控制字符。例如， \cM 匹配一个 Control-M 或回车符。x 的值必须为 A-Z 或 a-z 之一。否则，将 c 视为一个原义的 'c' 字符。 |
| \d          | 匹配一个数字字符。等价于 [0-9]。                      |
| \D          | 匹配一个非数字字符。等价于 [^0-9]。                    |
| \f          | 匹配一个换页符。等价于 \x0c 和 \cL。                  |
| \n          | 匹配一个换行符。等价于 \x0a 和 \cJ。                  |
| \r          | 匹配一个回车符。等价于 \x0d 和 \cM。                  |
| \s          | 匹配任何空白字符，包括空格、制表符、换页符等等。等价于 [ \f\n\r\t\v]。 |
| \S          | 匹配任何非空白字符。等价于 [^ \f\n\r\t\v]。            |
| \t          | 匹配一个制表符。等价于 \x09 和 \cI。                  |
| \v          | 匹配一个垂直制表符。等价于 \x0b 和 \cK。                |
| \w          | 匹配包括下划线的任何单词字符。等价于'[A-Za-z0-9_]'。        |
| \W          | 匹配任何非单词字符。等价于 '[^A-Za-z0-9_]'。           |
| \xn         | 匹配 n，其中 n 为十六进制转义值。十六进制转义值必须为确定的两个数字长。例如，'\x41' 匹配 "A"。'\x041' 则等价于 '\x04' & "1"。正则表达式中可以使用 ASCII 编码。 |
| \num        | 匹配 num，其中 num 是一个正整数。对所获取的匹配的引用。例如，'(.)\1' 匹配两个连续的相同字符。 |
| \n          | 标识一个八进制转义值或一个向后引用。如果 \n 之前至少 n 个获取的子表达式，则 n 为向后引用。否则，如果 n 为八进制数字 (0-7)，则 n 为一个八进制转义值。 |
| \nm         | 标识一个八进制转义值或一个向后引用。如果 \nm 之前至少有 nm 个获得子表达式，则 nm 为向后引用。如果 \nm 之前至少有 n 个获取，则 n 为一个后跟文字 m 的向后引用。如果前面的条件都不满足，若 n 和 m 均为八进制数字 (0-7)，则 \nm 将匹配八进制转义值 nm。 |
| \nml        | 如果 n 为八进制数字 (0-3)，且 m 和 l 均为八进制数字 (0-7)，则匹配八进制转义值 nml。 |
| \un         | 匹配 n，其中 n 是一个用四个十六进制数字表示的 Unicode 字符。例如， \u00A9 匹配版权符号 (?)。 |

1. 验证用户名和密码：（"^[a-zA-Z]\w{5,15}$"）正确格式："[A-Za-z]_[0-9]"组成,并且第一个字必须为字母6~16位；

2. 验证电话号码：（"^(\\d{3,4}-)\\d{7,8}$"）正确格式：xxx/xxxx-xxxxxxx/xxxxxxxx；

3. 验证手机号码："^1[3|4|5|7|8]\[0-9\]\\d{8}$"；

4. 验证身份证号（15位或18位数字）："\\d{14}[[0-9],0-9xX]"；

5. 验证Email地址：("^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$")；

6. 只能输入由数字和26个英文字母组成的字符串：("^[A-Za-z0-9]+$") ;

7. 整数或者小数：^[0-9]+([.][0-9]+){0,1}$

8. 只能输入数字："^[0-9]*$"。

9. 只能输入n位的数字："^\d{n}$"。

10. 只能输入至少n位的数字："^\d{n,}$"。

11. 只能输入m~n位的数字："^\d{m,n}$"。

12. 只能输入零和非零开头的数字："^(0|[1-9]\[0-9]*)$"。

13. 只能输入有两位小数的正实数："^[0-9]+(\.[0-9]{2})?$"。

14. 只能输入有1~3位小数的正实数："^[0-9]+(\.[0-9]{1,3})?$"。

15. 只能输入非零的正整数："^\+?[1-9]\[0-9]*$"。*

16. 只能输入非零的负整数："^\-[1-9]\[0-9]*$"。

17. 只能输入长度为3的字符："^.{3}$"。

18. 只能输入由26个英文字母组成的字符串："^[A-Za-z]+$"。

19. 只能输入由26个大写英文字母组成的字符串："^[A-Z]+$"。

20. 只能输入由26个小写英文字母组成的字符串："^[a-z]+$"。

21. 验证是否含有^%&',;=?$\"等字符："[%&',;=?$\\^]+"。

22. 只能输入汉字："^[\u4e00-\u9fa5]{0,}$"。

23. 验证URL："^http://([\w-]+\.)+[\w-]+(/[\w-./?%&=]*)?$"。

24. 验证一年的12个月："^(0?[1-9]|1[0-2])$"正确格式为："01"～"09"和"10"～"12"。

25. 验证一个月的31天："^((0?[1-9])|((1|2)[0-9])|30|31)$"正确格式为；"01"～"09"、"10"～"29"和“30”~“31”。

26. 获取日期正则表达式：\\d{4}[年|\-|\.]\d{\1-\12}[月|\-|\.]\d{\1-\31}日?

   评注：可用来匹配大多数年月日信息。

27. 匹配双字节字符(包括汉字在内)：[^\x00-\xff]

   评注：可以用来计算字符串的长度（一个双字节字符长度计2，ASCII字符计1）

28. 匹配空白行的正则表达式：\n\s*\r

   评注：可以用来删除空白行

29. 匹配HTML标记的正则表达式：<(\S*?)[^>]*>.*?</>|<.*? />

   评注：网上流传的版本太糟糕，上面这个也仅仅能匹配部分，对于复杂的嵌套标记依旧无能为力

30. 匹配首尾空白字符的正则表达式：^\s*|\s*$

   评注：可以用来删除行首行尾的空白字符(包括空格、制表符、换页符等等)，非常有用的表达式

31. 匹配网址URL的正则表达式：[a-zA-z]+://[^\s]*

   评注：网上流传的版本功能很有限，上面这个基本可以满足需求

32. 匹配帐号是否合法(字母开头，允许5-16字节，允许字母数字下划线)：^[a-zA-Z]\[a-zA-Z0-9_]{4,15}$

   评注：表单验证时很实用

33. 匹配腾讯QQ号：[1-9]\[0-9]{4,}

   评注：腾讯QQ号从10 000 开始

34. 匹配中国邮政编码：[1-9]\\d{5}(?!\d)

   评注：中国邮政编码为6位数字

35. 匹配ip地址：([1-9]{1,3}\.){3}[1-9]。

   评注：提取ip地址时有用

36. 匹配MAC地址：([A-Fa-f0-9]{2}\:){5}[A-Fa-f0-9]

# 作业



1. 》》》已知字符串："this is a test of java"
   按要求执行以下操作：
   (1) 统计该字符串中字母s出现的次数
   (2) 取出子字符串"test"
   (3) 将本字符串复制到一个字符数组Char[] str中.
   (4) 将字符串中每个单词的第一个字母变成大写， 输出到控制台。
   (5) 用两种方式实现该字符串的倒序输出。(用StringBuffer和for循环方式分别实现)

2. 》》》初始化一个字符串“ABCDEFG”,然后分别在后面跟上自己的小写字母.
   A(a)B(b)C(c)D(d)E(e)F(f)G(g)

3. 给定字符串数组：
   String strings[]= {“string”,”starting”,”strong”,”street”, “stir”,”studeng”,”soft”,”sting”}
   要求：分别统计以st开头的字符串有多少个，以ng结尾的字符串有多少个

4. 》》》用户输入一个字符串 String str=”123dsgfadsgjlafdjhladDWAdlfgjalDSFADSFDASnhsdaf!@$%@#45324rdsf” 统计字符串大写字母,小写字母,数字，其他字符的个数。

5. 》》》如下字符串:
   01#张三#20*02#李四#30*03#王五#40。。。。。。，解析每个人分数多少。
   输出样式如下：
   01 张三 20
   02 李四 30
   03 王五 40

6. 写一个方法，判断一个字符串是否对称。比如： abcba就是一个对称字符串。

7. 》》编写一个程序，将下面的一段文本中的各个单词的字母顺序翻转。例如: “To be or not to be"，将变成"oT eb ro ton ot eb"。
