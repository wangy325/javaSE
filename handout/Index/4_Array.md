# 数组

## 4.1 一维数组的创建

**什么数组：**

1. 数组是用来存储一组相同类型数据的数据结构
2. 数组变量属于引用数据类型
3. 数组中的元素可以是任何数据类型(基本类型和引用类型)
4. 数组有一个对应的索引，可以通过索引访问数组中的每个元素（0...(n-1)）
5. 数组被创建好之后，它的大小（数组长度）是**不能改变**的，但是数组中的各个元素是可以被改变的

### 4.1.1 数组的声明

```java
public class Test1 {
	public static void main(String[] args) {
      	//数据类型[]  数组变量名;(java推荐用法)
		int[] scores;
      	//数据类型 	数组变量名[ ]; 
		int ages[];
	}
}
```

### 4.1.2 数组的创建

Java中使用关键字new 创建数组对象，指定数组的大小，给数组元素的存储分配空间

> 数组变量名 = new 数组元素的类型 [数组元素的个数];

```java
public class Test1 {

	public static void main(String[] args) {
		int[] scores;
		//数组变量名 = new 数组元素的类型 [数组元素的个数];
		scores = new int[5];
	}
}
```

## 4.2 数组的赋值

### 4.2.1 默认值

数组创建之后，如果没有对数组进行初始化，则系统使用**默认值**对数据进行默认初始化

1. 数字类型的默认值是0;
2. Boolean值的默认值是false;
3. 引用数据类型的默认值是null;

### 4.2.1 静态赋值

**所谓的静态初始化是指，在创建数组对象的同时对数组进行初始化。**

静态初始化有两种方式：

1、	int[] a = new int[]{1, 2, 3};  //定义并创建数组，并初始化数组的元素为 1、3、3，同时数组的长度也被限定为为3

2、	int[] a = {1, 2, 3};   //效果同上

以上两种方式均不需要定义数组的长度，数组的长度由初始化时元素的个数来决定

```java
public class Test1 {

	public static void main(String[] args) {
      	int[] scores = new int[] { 99 ,  65 , 78 , 89 , 100};
      	//效果同上
		//int[] scores = { 99 ,  65 , 78 , 89 , 100};
	}
}
```

### 4.2.2 动态赋值

**所谓动态初始化是指把数组的创建和数组的初始化分开完成**

例如：

int[] a = new int[3];  

a[0] = 3;  //通过元素索引(下标)来给数组元素赋值

a[1]=4;

a[2]=5;

```java
public class Test1 {
	public static void main(String[] args) {
		int[] scores;		
		scores = new int[5];	
		scores[0] = 88;//通过元素索引(下标从0开始)来给数组元素赋值	
		scores[4] = 99;
	}
}
```

## 4.3 数组的访问

### 4.3.1 通过下标访问指定元素

​	任何类型的数组，为了便于访问，系统为数组中的每个元素分配了一个下标(索引),可以通过下标来访问到该数组中的每个元素

​	假设一个长度为n的数组，则数组的元素下标范围为从 0 — n-1。即：第一个元素的下标为0, 第二个元素的下标为1, …  ,第n个元素的下标为n – 1。所以访问数组时，时刻注意数组的最后一个元素的下标总是比数组的长度小1，否则会出现下标越界

​	例如：

​	int[] a = {20, 30, 2, 50, 5, 66};  //定义一个int类型的数组，并初始化

​	System.out.println(a[0]);     //获得第1个元素值，并输出该值

       	System.out.println(a[3]);    //获得第 4个元素的值, 并输出改制

### 4.3.2 循环访问

利用循环可以遍历数组中的每个元素

```java
public class Test1 {

	public static void main(String[] args) {
		int[] scores= {3,4,5,6,7,12,43};
		int len = scores.length;//获得数组的长度		
		for (int i = 0; i < scores.length; i++) {
			System.out.println(scores[i]);
		}
	}
}
```

### 4.3.3 增强for循环

该循环方式是java Jdk1.5新加的特性

该种方式的最大特点是**只能遍历访问数组中的元素的值，而不能修改数组中元素的值**

**使用语法：**

for(数组中元素类型 变量名 :  数组名){

  //写访问元素的代码，其中的“变量名”就代表了数组中的每个元素

  //这种循环方式总是从数组的中的第一个元素开始遍历，直至最后一个元素

}

```java
public class Test1 {
	public static void main(String[] args) {
		int[] scores= {3,4,5,6,7,12,43};	
		for (int i : scores) {        
			System.out.println(i);
		}
	}
}
```

### 4.3.4 数组在内存中的存储机制

**介绍数组(数组引用和数组元素)在内存中的存放形式**

首先给出结论：**数组引用变量是存放在栈内存(stack)中，数组元素是存放在堆内存(heap)中**，通过栈内存中的指针指向对应元素的在堆内存中的位置来实现访问，以下图来说明数组此时的存放形式

![](http://images.cnblogs.com/cnblogs_com/hmiinyu/数组内存.jpg)

那什么是栈内存和堆内存呢？

当执行方法时，该方法都会建立自身的内存栈，以用来将该**方法内部**定义的变量逐个加入到内存栈中，当执行结束时方法的内存栈也随之销毁，我们说所有变量存放在栈内存中，即随着寄存主体的消亡而消亡；反之，当我们创建一个对象时，这个**对象被保存到运行时数据区**中，以便反复利用(因为创建成本很高)，此时不会随着执行方法的结束而消亡，同时该对象还可被其他对象所引用，只有当这个对象没有被任何引用变量引用时，才会在垃圾回收在合适的时间点回收，我们说此时变量所指向的**运行时数据**区存在堆内存中。

```java
public class TestPrimitiveArray {
    public static void main(String[] args) {
        //1.定义数组
        int[] numbers;
        //2.分配内存空间
        numbers = new int[4];
        //3.为数组元素指定值
        for(int i = 0;i < numbers.length;i++) {
            numbers[i] = i * 10;
        }
    }
}
```

**按以上步骤的内存分布示意图**



![](http://images.cnblogs.com/cnblogs_com/hmiinyu/基本类型内存分布.jpg)

从图中可看出数组元素直接存放在堆内存中，当操作数组元素时，实际上是操作基本类型的变量

## 4.4 Arrays工具类

操作数组的工具类：可以完成排序、查找、格式化等功能

### Arrays.toString(Array arr)

```java
int[] scores = { 3, 4, 7, 12, 43, 5,10, 6,1 };
String s = Arrays.toString(scores);//数组转字符串表达
System.out.println(s);

//将输出：[3, 4, 7, 12, 43, 5, 10, 6, 1]
```
### Arrays.sort(Array arr)

```java
int[] scores = { 3, 4, 7, 12, 43, 5,10, 6,1 };
Arrays.sort(scores);//对scores数组升序排列
System.out.println(Arrays.toString(scores));

//将输出：[1, 3, 4, 5, 6, 7, 10, 12, 43]
```
### Arrays.binarySearch(Array arr, int key)

```java
int[] scores = { 3, 4, 7, 12, 43, 5,10, 6,1 };
// 二分查找数组元素，数组要先排序
scores = Arrays.sort(scores);
int binarySearch = Arrays.binarySearch(scores, 12);
//在数组中找 12 这个值，并返回找到的下标位置，如果不存在，则返回 负数
System.out.println(binarySearch);
//将输出：7
```
### Arrays.fill(Array arr, int key)

```java
int[] scores = { 3, 4, 7, 12, 43, 5,10, 6,1 };
Arrays.fill(scores, 5);//将数组的所有值 替换成  5
System.out.println(Arrays.toString(scores));
//将输出：[5, 5, 5, 5, 5, 5, 5, 5, 5]
```
> 以上测试均为 int[] ；其他类型数组，数据类型不同，用法一致
>
> 注：boolean[] 不能排序

## 4.5二维数组的创建

二维数组的本质就是用一维数组作为数组元素的一维数组

实际上是一个矩阵

### 4.5.1数组的声明

```java
int[][] a;//定义一个int二维数组
```

### 4.5.2数组的创建

```java
int[][] a;//定义一个int二维数组
a = new int[3][4];//为 二维数组 a 分配一个 3行4列的连续空间大小
```

## 4.6数组的赋值

### 4.4.1静态赋值

```java
int[][] a={{2,3,4},{5,6},{7,8,9,10}};//边声明，边赋值
//int[][] a=new int[][]{{2,3,4},{5,6},{7,8,9,1}};  //效果与上面语法等同
// 数组的矩阵形式如下，一行代表一个一位数组，内容为第二层花括号的中内容
2	3	4
5	6
7	8	8	10
```

> 注：
>
> * 每个{}代表一行（一个一位数组），多个 {} 代表多行
> * 静态赋值的时候，每一列行的个数可以不一样(如上)

### 4.4.2动态赋值

```java
int[][] a = new int[3][4];
a[1][2] = 24；//第1列，第2行的位置，赋值为 24

//通过两层循环 动态赋值；
for (int i = 0; i < 3; i++) {
  	// 两种写法 
  	// for(int j = 0;j<a[i].length;j++) {
	for (int j = 0; j < 4; j++) {
		a[i][j] = 5;
	}
}
```

## 4.7二数组的访问

### 4.7.1通过下标访问指定元素

```java
int[][] a=new int[3][4];
System.out.println(a[1][2]);//访问1列，2行的数据
```

### 4.7.2循环访问数组

```java
int[][] a=new int[3][4];
for (int i = 0; i < a.length; i++) {
	for (int j = 0; j < a[i].length; j++) {
		System.out.print(a[i][j]);//访问当前列 指定下标的数据
	}
	System.out.println();//换行
}
```

### 4.7.3 增强for循环

```java
int[][] a=new int[3][4];
for (int[] b : a) {
	for (int i : b) {
		System.out.print(i);
	}
	System.out.println();
}
```

## 作业

1. 将数组中的0去掉后返回一个新数组。
   例如数组 `int[] arr={1,13,45,5,0,0,16,6,0,25,4,17,6,7,0,15};`
   要求将以上数组中的0项去掉，将不为0的值存入一个新数组，
   生成新的数组作为返回值: `int[] newArr={1,13,45,5,16,6,25,4,17,6,7,15};`

2. 把一个数组倒置输出。
   例如：`{1, 5, 7}` 倒置后为：`{7, 5, 1}`

3. 现在给出两个数组：

   * 数组A：1，7，9，11，13，15，17，19
   * 数组b：2，4，6，8，10

   两个数组合并为数组c，按升序排列。

4. 将 一组乱序的字符进行排序，然后进行升序和逆序输出。

   ![](http://ojx4zwltq.bkt.clouddn.com/17-3-2/26659785-file_1488462406159_6113.png)

5. 将原有积分进行备份，然后赠送每位会员500积分，编写程序输出积分情况

   ![](http://ojx4zwltq.bkt.clouddn.com/17-3-2/57971358-file_1488462450105_c725.png)

6. 求出4家店的最低手机价格

   ![](http://ojx4zwltq.bkt.clouddn.com/17-3-2/11773363-file_1488462511090_1776e.png)

7. 歌手打分：在歌唱比赛中，共有10位评委进行打分，在计算歌手得分时，去掉一个最高分，去掉一个最低分，然后剩余的8位评委的分数进行平均， 就是该选手的最终得分。输入每个评委的评分，求某选手的最终得分。

   ​
