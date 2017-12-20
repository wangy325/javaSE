# 第15天常用类

## 15.1 Date类

java.util.Date 类表示特定的瞬间，精确到秒。

**常用构造方法：**

1. Date();使用系统当前的时间创建 一个Date实例，内部就是使用System. currentTimeMillis()获取系统当前时间的毫秒数来创建Date对象。
2. Date(long dt); 使用自1970年1月1日00:00:00 GMT以来的指定毫秒数创建 一个Date实例

**常用方法：**

1. getTime();返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数。 

2. toString()   把此 Date 对象转换为以下形式的 String：

   Sun Feb 12 10:06:43 GMT+08:00 2017

> 注：Date 类中的方法API不易于实现国际化，大部分被废弃了。

## 15.2 Calendar类

Calendar(日历)类是一个抽象基类，主要用于完成日期字段之间相互操作的功能。即可以设置和获取日期数据的特定部分。

获取Calendar类的实例的方法：

1. 使用Calendar.getInstance();
2. 调用它的子类GregorianCalendar的构造方法

**常用方法：**

1. public int get(int field); 根据给定的日历字段获得当前时间中相应字段的值。如：年、月、日，时、分、秒等；
2. public final void setTime(Date date); 定位日历到指定的时间。
3. public final void setTimeMillis(long millis); 定位日历到指定的时间。
4. c.getActualMaximum(Calendar.DATE);获取当前日期所在月份的天数

## 15.3 SimpleDateFormat类

SimpleDateFormat 是一个以与语言环境有关的方式来格式化和解析日期的具体类。

它允许进行格式化（时间 -> 文本）、解析（文本 -> 日期）和规范化。 

* 时间 -> 文本：

  ```java
  Date date = new Date(1486866084000L);
  SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒", Locale.CHINA);
  String result = simpleDateFormat.format(date);//格式化时间
  System.out.println(result);
  //将输出：2017年02月12日 10时21分24秒
  ```

* 文本 -> 时间：

  ```java
  String time = "2017年02月12日 10时21分24秒";
  SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒", Locale.CHINA);
  Date result = simpleDateFormat.parse(time);//解析文本，(格式不对解释会异常，此处需要处理异常)
  System.out.println(result.getTime());
  //将输出：1486866084000
  ```

## 15.4 Timestamp类

此类与 java.sql.Date 相似。具体优势体现在操作数据库中。

包含年、月、日、时、分、秒、纳秒（nano）信息。

继承自java.util.Date。比java.sql.Date包含更多信息。一般在数据库相关操作中使用，如rs.getTimestamp，ps.setTimeStamp等。例如：若数据库中某字段hireDate为Oracle的Date类型，则使用getTimestamp时能够将年、月、日、时、分、秒信息取出；但使用getDate时则只能取出年、月、日信息。因此，在操作是数据库的时候一般推荐使用getTimestamp。

> 具体使用方式数据库中再认识。

## 15.5 Math类

### **简介**

**java.lang.Math** 类包含的方法进行基本的数字操作，如基本的指数，对数，平方根和三角函数等。

### 类声明

以下是java.lang.Math类的声明：

```
public final class Math extends Object
```

### 字段

以下是java.lang.Math类的字段：

- **static double E **-- 这就是double值，该值是比任何其他更近到e，自然对数的基础上。
- **static double PI **-- 这就是双值，该值是比任何其他更接近到pi，一个圆的圆周比其直径。

### 常用的方法

1. static double abs(double a) ;返回一个double值的绝对值。
2. static double sqrt(double a) ;返回一个double值的正平方根.
3. static double cbrt(double a) ;返回一个double值的立方根。
4. static double ceil(double a) ;向大取整。如：32.1—>33.0
5. static double floor(double a);向小取整。如：32.9—>32.0
6. static double max(double a, double b) ;取最大值。
7. static double min(double a, double b) ;取最小值。
8. static double pow(double a, double b) ;返回的第一个参数的值提升到第二个参数的幂。
9. static double random() ;返回一个随机的double值，(范围：0.0<= x < 1.0 )
10. static double rint(double a) ;就近取整。如:4.6—>5；4.5—>4。
11. static long round(double a) ;四舍五入。

> 提示：更多属性、方法等使用方式请翻阅 java API 。

## NumberFormat（了解）

NumberFormat 是所有数值格式的抽象基类。 该类提供了格式化和分析数值的接口。

```
 public static void main(String[] args) {

        double myNum = 2344.3345566;

        double test = 0.3456;

        //获取NumberFormat 的格式化百分比
        NumberFormat instance = NumberFormat.getPercentInstance();

        System.out.println(instance.format(test));

        //获取  NUmberFormat
        NumberFormat format = NumberFormat.getInstance();

        //setMaximumFractionDigits(int) 设置数值的小数部分允许的最大位数.
        //setMaximumIntegerDigits(int)  设置数值的整数部分允许的最大位数.
        //setMinimumFractionDigits(int) 设置数值的小数部分允许的最小位数.
        //setMinimumIntegerDigits(int)  设置数值的整数部分允许的最小位数.

        format.setMaximumFractionDigits(3);
        System.out.println(format.format(myNum));
        
 }
```

### DecimalFormat

DecimalFormat 是 NumberFormat 的一个具体子类，用于格式化十进制数字。该类设计有各种功能，使其能够分析和格式化任意语言环境中的数，包括对西方语言、阿拉伯语和印度语数字的支持。它还支持不同类型的数，包括整数 (123)、定点数 (123.4)、科学记数法表示的数 (1.23E4)、百分数 (12%) 和金额 ($123)。所有这些内容都可以本地化。 

DecimalFormat 包含一个模式 和一组符号:

| **符号**        | **位置** | **本地化？** | **含义**                                   |
| ------------- | ------ | -------- | ---------------------------------------- |
| `0`           | 数字     | 是        | 阿拉伯数字                                    |
| `#`           | 数字字    | 是        | 阿拉伯数字，如果不存在则显示为空                         |
| `.`           | 数字     | 是        | 小数分隔符或货币小数分隔符                            |
| `-`           | 数字     | 是        | 减号                                       |
| `,`           | 数字     | 是        | 分组分隔符                                    |
| `E`           | 数字     | 是        | 分隔科学计数法中的尾数和指数。*在前缀或后缀中无需加引号。*           |
| `;`           | 子模式边界  | 是        | 分隔正数和负数子模式                               |
| `%`           | 前缀或后缀  | 是        | 乘以 100 并显示为百分数                           |
| `/u2030`      | 前缀或后缀  | 是        | 乘以 1000 并显示为千分数                          |
| `¤`(`/u00A4`) | 前缀或后缀  | 否        | 货币记号，由货币符号替换。如果两个同时出现，则用国际货币符号替换。如果出现在某个模式中，则使用货币小数分隔符，而不使用小数分隔符。 |
| `'`           | 前缀或后缀  | 否        | 用于在前缀或或后缀中为特殊字符加引号，例如 `"'#'#"` 将 123 格式化为 `"#123"`。要创建单引号本身，请连续使用两个单引号：`"# o''clock"`。 |

### 例子1：

```
DecimalFormat df1 = new DecimalFormat("0.0");   
DecimalFormat df2 = new DecimalFormat("#.#");   
DecimalFormat df3 = new DecimalFormat("000.000");   
DecimalFormat df4 = new DecimalFormat("###.###");   
System.out.println(df1.format(12.34));   
System.out.println(df2.format(12.34));   
System.out.println(df3.format(12.34));   
System.out.println(df4.format(12.34));   
```

运行结果： 

```
12.3 
12.3 
012.340 
12.34  
```

### 例子2:

```
//数字格式化  
DecimalFormat format = new DecimalFormat("###,####.000");   
System.out.println(format.format(111111123456.1227222));   
   
//科学计数法    分隔科学计数法中的尾数和指数。在前缀或后缀中无需加引号。
DecimalFormat zhiFormat = new DecimalFormat();   
zhiFormat.applyPattern("0.000E0000");   
System.out.println(zhiFormat.format(10000));   
System.out.println(zhiFormat.format(12345678.345));   

//百分号格式化
DecimalFormat percentFormat = new DecimalFormat();   
percentFormat.applyPattern("#0.000%");   
System.out.println(percentFormat.format(0.3052222));   
```

运行结果 ：

```
1111,1112,3456.123 
1.000E0004 
1.235E0007 
30.522% 
```



# BigDecimal类

借用《Effactive [Java](http://lib.csdn.net/base/java)》这本书中的话，float和double类型的主要设计目标是为了科学计算和工程计算。他们执行二进制浮点运算，这是为了在广域数值范围上提供较为精确的快速近似计算而精心设计的。然而，它们没有提供完全精确的结果，所以不应该被用于要求精确结果的场合。但是，商业计算往往要求结果精确，这时候BigDecimal就派上大用场啦。

## BigDecimal简介

BigDecimal 由任意精度的整数*非标度值* 和32 位的整数*标度* (scale) 组成。如果为零或正数，则标度是小数点后的位数。如果为负数，则将该数的非标度值乘以 10 的负scale 次幂。因此，BigDecimal表示的数值是`(unscaledValue × 10-scale)`。

## 举个栗子

在进行数字运算时，如果有double或float类型的浮点数参与计算，偶尔会出现计算不准确的情况。如以下示例代码：

```
    System.out.println(0.05+0.01);  
    System.out.println(1.0-0.42);  
    System.out.println(4.015*100);  
    System.out.println(123.3/100);  
```

上述代码执行结果如下：

```
    0.060000000000000005  
    0.5800000000000001  
    401.49999999999994  
    1.2329999999999999  
```

float和double只能用来作科学计算或者是工程计算，但在商业计算中我们要用java.math.BigDecimal，通过使用BigDecimal类我们可以解决上述问题，

```

加法:
public static double add(double d1,double d2){  
        BigDecimal b1=new BigDecimal(Double.toString(d1));  
        BigDecimal b2=new BigDecimal(Double.toString(d2));  
        return b1.add(b2).doubleValue();  
          
}  

减法:
public static double sub(double d1,double d2){  
        BigDecimal b1=new BigDecimal(Double.toString(d1));  
        BigDecimal b2=new BigDecimal(Double.toString(d2));  
        return b1.subtract(b2).doubleValue();       
}  

乘法:
public static double mul(double d1,double d2){ 

        BigDecimal b1=new BigDecimal(Double.toString(d1));  
        BigDecimal b2=new BigDecimal(Double.toString(d2));  
        return b1.multiply(b2).doubleValue();    
}  

除法:
scale  保留几位小数
BigDecimal.ROUND_HALF_UP    四舍五入
public static double div(double d1,double d2,int scale){  
        BigDecimal b1=new BigDecimal(Double.toString(d1));  
        BigDecimal b2=new BigDecimal(Double.toString(d2));  
        return b1.divide(b2,scale,BigDecimal.ROUND_HALF_UP).doubleValue();  
          
}  
```

### 总结

*   商业计算使用BigDecimal。
*   尽量使用参数类型为String的构造函数。
*   BigDecimal都是不可变的（immutable）的，在进行每一步运算时，都会产生一个新的对象，所以在做加减乘除运算时千万要保存操作后的值

## 15.6 Random类

Random类 (java.util) ，生成随机数的类。

Random 类中实现的随机算法是伪随机，也就是有规则的随机。在进行随机时，随机算法的起源数字称为种子数(seed)，在种子数的基础上进行一定的变换，从而产生需要的随机数字。

相同种子数的Random对象，相同次数生成的随机数字是完全相同的。也就是说，两个种子数相同的Random对象，第一次生成的随机数字完全相同，第二次生成的随机数字也完全相同。这点在生成多个随机数字时需要特别注意。

**1、Random对象的生成**

Random类包含两个构造方法：

1. public Random();  该构造方法使用一个和当前系统时间对应的相对时间有关的数字作为种子数，然后使用这个种子数构造Random对象。

   ```java
   Random r = new Random();
   ```

2. public Random(long seed);  该构造方法可以通过制定一个种子数进行创建。

   ```java
   Random r1 = new Random(10010);
   ```

> 再次强调：
>
> * 种子数只是随机算法的起源数字，和生成的随机数字的区间无关。
> * 且相同的种子数生成的随机数相同。

**2、Random类中的常用方法**

Random类中的方法比较简单，每个方法的功能也很容易理解。需要说明的是，Random类中各方法生成的随机数字都是均匀分布的，也就是说区间内部的数字生成的几率是均等的：

1. public boolean nextBoolean(); 该方法的作用是生成一个随机的boolean值，生成true和false的值几率相等，也就是都是50%的几率。
2. public double nextDouble();该方法的作用是生成一个随机的double值，数值介于[0,1.0)之间。
3. public int nextInt();该方法的作用是生成一个随机的int值，该值介于int的区间，也就是-2^31到2^31-1之间。
4. public int nextInt(int n);该方法的作用是生成一个随机的int值，该值介于[0,n-1]的区间。

## 15.7 Runtime类

RunTime类代表Java程序的运行时环境，每一个Java程序都有一个与之对应的Runtime实例，应用程序通过该对象与运行时环境相连，应用程序不能创建自己的Runtime实例，但可以通过getRuntime()方法获得与之关联的Runtime对象。

Runtime代表Java程序的运行时环境，可以访问JVM的相关信息，如处理器数量，内存信息。

```java
//获取Java运行时相关的运行时对象
Runtime rt = Runtime.getRuntime();
System.out.println("处理器数量：" + rt.availableProcessors()+" byte");
System.out.println("Jvm总内存数 ："+ rt.totalMemory()+" byte");
System.out.println("Jvm空闲内存数： "+ rt.freeMemory()+" byte");
System.out.println("Jvm可用最大内存数： "+ rt.maxMemory()+" byte");
```

## 15.8 System类

java.lang.System 类代表系统，系统级的很多属性和控制方法都放置在该类的内部。

由于该类的构造方法是private的，所以无法创建该类的对象，也就是无法实例化该类。其内部的成员变量和成员方法都是static的，所以也可以很方便的进行调用。

**成员变量：**

1. in 标准输入流(键盘输入)

   ```java
   Scanner input = new Scanner(System.in);//键盘输入流
   ```

2. out 标准输出流(显示器)

   ```java
   System.out.println(“Test”);//该行代码的作用是将字符串”Test”输出到系统的标准输出设备上(控制台)
   ```

3. err  标准错误输出流(显示器)

   ```java
   System.err.println(“Test”);//该行代码的作用是将字符串”Test”输出到系统的标准错误输出设备上(控制台)
   ```

**成员方法：**

1. public static void *arraycopy*(Object src, int srcPos, Object dest, int destPos, int length); 该方法的作用是数组拷贝，也就是将一个数组中的内容复制到另外一个数组中的指定位置，由于该方法是native方法，所以性能上比使用循环高效。

   ```java
   int[] a = {1,2,3,4};
   int[] b = new int[5];
   System.arraycopy(a,1,b,3,2);
   //该代码的作用是将数组a中，从下标为1开始，复制到数组b从下标3开始的位置，总共复制2个。也就是将a[1]复制给b[3]，将a[2]复制给b[4]，这样经过复制以后数组a中的值不发生变化，而数组b中的值将变成{0,0,0,2,3}。
   ```

2. public static long *currentTimeMillis*();该方法的作用是返回当前的计算机时间，时间的表达格式为当前计算机时间和GMT时间(格林威治时间)1970年1月1号0时0分0秒所差的毫秒数。

   ```
   注：在开发中，时间的存储更多都是使用 long 长整形 毫秒数保存，需要显示的时候再转换成文本展示。
   ```

3. public static void *exit*(int status)该方法的作用是退出程序。其中status的值为0代表正常退出，非零代表异常退出。

4. public static void *gc*()该方法的作用是请求系统进行垃圾回收。至于系统是否立刻回收，则取决于系统中垃圾回收算法的实现以及系统执行时的情况。

5. public static String getProperty(String key);该方法的作用是获得系统中属性名为key的属性对应的值。

   系统中常见的属性名以及属性的作用如下表所示：

   | key          | 说明           |
   | ------------ | ------------ |
   | java.version | Java 运行时环境版本 |
   | java.home    | Java安装目录     |
   | os.name      | 操作系统的名称      |
   | os.version   | 操作系统的版本      |
   | user.name    | 用户的账户名称      |
   | user.home    | 用户的主目录       |
   | user.dir     | 用户的当前工作目录    |

   代码示例：

   ```java
   		String osVersion = System.getProperty("os.version");
   		String osName = System.getProperty("os.name");
   		String userHome = System.getProperty("user.home");
   		String userDir = System.getProperty("user.dir");
   		String userName = System.getProperty("user.name");
   		String javaVersion = System.getProperty("java.version");
   		String javaHome = System.getProperty("java.home");
   		System.out.println("当前操作系统版本是：" + osVersion);
   		System.out.println("当前操作系统是：" + osName);
   		System.out.println("当前用户主目录是：" + userHome);
   		System.out.println("当前用户的工作目录是：" + userDir);
   		System.out.println("当前用户明是：" + userName);
   		System.out.println("当前Java运行时环境版本是：" + javaVersion);
   		System.out.println("当前Java安装目录是：" + javaHome);
   	
   ```

## 15.9 枚举的简单使用

​	**枚举（enum）类型是Java 5新增的特性，它是一种新的类型，允许用常量来表示特定的数据片断，而且全部都以类型安全的形式来表示。**

### 15.9.1常量的使用

​	**在JDK1.5之前，我们定义常量都是：public static fianl....。现在好了，有了枚举，可以把相关的常量分组到一个枚举类型里，而且枚举提供了比常量更多的方法。**

```java
public enum Color {
     
     RED, GREEN, BLANK, YELLOW 
 
}
```

　　使用

```java
public class B {
 
    public static void main(String[] args) {
        System.out.println( isRed( Color.BLANK ) ) ;  //结果： false
        System.out.println( isRed( Color.RED ) ) ;    //结果： true
    }
 
    static boolean isRed( Color color ){
        if ( Color.RED.equals( color )) {
            return true ;
        }
        return false ;
    }
 
}
```

　　或者 switch 的使用

```java
public class B {
 
    public static void main(String[] args) {
        showColor( Color.RED );
    }
 
    static void showColor(Color color){
        switch ( color ) {
        case BLANK:
            System.out.println("黑色");
            break;
        case RED :
            System.out.println( "红色" );
            break;
        default:
            System.out.println( "没有找到该颜色" );
            break;
        }
    }
}
```

### 15.9.2 自定义函数

```java
public enum Color {
     
     RED("红色", 1), GREEN("绿色", 2), BLANK("白色", 3), YELLO("黄色", 4);
     
    private String name ;
    private int index ;
     
    private Color( String name , int index ){
        this.name = name ;
        this.index = index ;
    }
     
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }
     
}
```

　　使用

```java
public class B {
 
    public static void main(String[] args) {
        //输出某一枚举的值
        System.out.println( Color.RED.getName() );
        System.out.println( Color.RED.getIndex() );
        //遍历所有的枚举
        for( Color color : Color.values()){
            System.out.println( color + "  name: " + color.getName() + "  index: " + color.getIndex() );
        }
    }
 
}
```

　　结果

```java
红色
1
RED name: 红色 index: 1
GREEN name: 绿色 index: 2
BLANK name: 白色 index: 3
YELLO name: 黄色 index: 4
```

### 15.9.2 总结

1. 枚举的本质是类，在没有枚举之前，仍然可以按照java最基本的编程手段来解决需要用到枚举的地方。枚举屏蔽了枚举值的类型信息，不像在用public static final定义变量必须指定类型。枚举是用来构建常量数据结构的模板，这个模板可扩展。枚举的使用增强了程序的健壮性，比如在引用一个不存在的枚举值的时候，编译器会报错。枚举的更多用法还需要在开发中去研究创造，Java5、Java6增加了不少新的特性，技术在升级，对程序员来说就要学习，如果你热爱java的话。否则别人用到新特性的代码你看不懂，那才叫郁闷。
2. 枚举在Java家族中只占了很小的一块比重，所以我们在项目中用枚举的地方不是很多，毕竟，一个项目是很多人开发维护的，用一个陌生的东西，会给其他的同事造成阅读困难。所以，开发中，常量大部分还是用public static final 来定义的。



# 作业



1. 输出指定年月的月历，年月从键盘输入。每星期一行，从星期日开始，到星期六结束。
   * 比如：2016年9月的月历。![](http://ojx4zwltq.bkt.clouddn.com/17-3-14/89321934-file_1489472823722_658c.png)

2. 写一个表示一周7天的枚举类。并提供一个方法，这个方法输出 星期x 这样的字符串。

3. 要求，

   1. 写一个方法，传入long 时间，返回String时间格式。

   2. 再写一个方法，传入String时间格式，返回long时间。

      > 时间格式为：yyyy年M月d日 H：m：s

4. 对 Math类、Random类、Runtime类、System类 的各个类的每一个方法进行测试。

5. 随机生成400 个 [6,50]的整数，统计出生成的每个整数的个数s。输出入格式如下：
   数字：个数
   例如：
   40：4
   50：6

6. 已知[a-z]的asc码值是：97-122，[A-Z]的asc码值是:65-90,随机打印一个英文字符，可以是大写，可以是小写