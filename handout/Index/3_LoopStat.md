# 循环语句

## 3.1 循环

### 3.1.1 while循环语句

while是最基本的循环，它的结构为：

```java
while( 判断条件语句 ) {
  循环体语句;
}

/**扩展格式**/
   初始化语句;
 while(判断条件语句) {
    循环体语句;
    控制条件语句;
 }
```

> **注意：**只要布尔表达式(判断条件语句)为 true，循环体会一直执行下去
>
> **特点：**先判断，再执行

**执行流程：**

1. 执行初始化语句
2. 执行判断条件语句，看其结果是true还是false：如果是false，循环结束；如果是true，继续执行。
3. 执行循环体语句
4. 执行控制条件语句
5. 回到2继续

**流程图：**

![](http://ojx4zwltq.bkt.clouddn.com/17-1-20/87903307-file_1484892509537_11974.jpg)

**代码举例：**

```java
/**
* 实现：从控制台输出100遍 "好好学习，天天向上！"
**/
public class Test {
   public static void main(String args[]) {
      int x = 1;
      while( x <= 100 ) {
         System.out.println("第" + x +"遍：好好学习，天天向上！");
         x++;
      }
   }
}
```

####  for循环 与 while循环 的区别

*for循环语句和while循环语句可以等价转换，但还是有些细微差别

1. 使用区别：

   * 控制条件语句所控制的那个变量，在for循环结束后，就不能再被访问到了，而while循环结束还可以继续使用，如果你想继续使用，就用while，否则推荐使用for
   * for循环结束，该变量就从内存中消失，能够提高内存的使用效率

2. 场景区别：

   * for循环适合针对一个范围判断进行操作（循环次数固定的情况）
   * while循环适合判断次数不明确操作（循环次数不固定的情况）

3. 代码举例：

   问：我国最高山峰是珠穆朗玛峰：8848m，我现在有一张**足够大**的纸张，厚度为：0.01m。请问，我折叠多少次，就可以保证厚度不低于珠穆朗玛峰的高度?

   ```java
   /*
     我国最高山峰是珠穆朗玛峰：8848m，我现在有一张足够大的纸张，厚度为：0.01m。
     请问，我折叠多少次，就可以保证厚度不低于珠穆朗玛峰的高度?
     分析：
       A:定义一个统计折叠次数的变量，默认值是0
       B:最高山峰是珠穆朗玛峰：8848m这是最终的厚度
        我现在有一张足够大的纸张，厚度为：0.01m这是初始厚度
       C:我折叠多少次，就可以保证厚度不低于珠穆朗玛峰的高度?
        折叠一次有什么变化呢?就是厚度是以前的2倍。
       D:只要每次变化的厚度没有超过珠穆朗玛峰的高度，就折叠，统计变量++
       E:输出统计变量。
       
       提示！此时循环次数不明确，所以选择 while循环比较合适。
   */
   class WhileTest {
     public static void main(String[] args) {
       //定义一个统计变量，默认值是0
       int count = 0;
       //最高山峰是珠穆朗玛峰：8848m这是最终的厚度
       int end = 884800;
       int start = 1;
       while(start<end) {
         //只要每次变化的厚度没有超过珠穆朗玛峰的高度，就折叠，统计变量++
         count++;
         //折叠一次有什么变化呢?就是厚度是以前的2倍。
         start *= 2;
         System.out.println("第"+count+"次厚度是"+start);
       }
       //输出统计变量。
       System.out.println("要叠"+count+"次，高度才能不低于珠穆朗玛峰的高度");
     }
   }
   ```

### 3.1.2 do-while循环语句

对于 while 语句而言，如果不满足条件，则不能进入循环

但有时候我们需要即使不满足条件，也至少执行一次

 *do…while 循环和 while 循环相似，不同的是，do…while 循环至少会执行一次*

```java
//基本格式：
do {
	循环体语句;
}while( 判断条件语句 );

//扩展格式：
初始化语句;
do {
	循环体语句;
	控制条件语句;
} while( 判断条件语句 );
```

> 布尔表达式在循环体的后面，所以语句块在检测布尔表达式之前已经执行了一次
>
>  如果布尔表达式的值为 true，则语句块一直执行，直到布尔表达式的值为 false
>
> **特点：**先执行，再判断

**执行流程：**

1. 执行初始化语句
2. 执行循环体语句
3. 执行控制条件语句
4. 执行判断条件语句，看其结果是true还是false：如果是false，循环结束；如果是true，继续执行
5. 回到2继续

**流程图：**

![](http://ojx4zwltq.bkt.clouddn.com/17-1-20/6776642-file_1484903156631_76b3.jpg)

## 3.2 跳转语句

### 3.2.1 break 语句的使用

break 语句用于终止某个语句块的执行，循环终止

> break 可用于 循环结构和switch选择结构中；

### 3.2.2 continue 语句的使用

continue语句用于跳过某个循环语句块的一次执行，然后执行下轮的循环。

> continue 只能用于 循环结构中...

**注意： 循环体内break 与 continue 语句后面的代码不会被执行，故 break 与 continue 后面不能写代码**

## 3.3循环的嵌套

### 3.3.1从控制台打印直角三角形

![](http://ojx4zwltq.bkt.clouddn.com/17-3-1/7407377-file_1488356057608_6daa.png)

### 3.3.2从控制台打印倒直角三角形

![](http://ojx4zwltq.bkt.clouddn.com/17-3-1/75030980-file_1488356158286_7112.png)

### 3.3.3从控制台打印直角三角形(每行星星数量为奇数个1、3、5、7、9...)

![![img](http://ojx4zwltq.bkt.clouddn.com/17-3-1/44114340-file_1488356237874_109dc.png)](http://ojx4zwltq.bkt.clouddn.com/17-3-1/41985765-file_1488356700961_2de8.png)

### 3.3.4从控制台打印等腰三角形

![](http://ojx4zwltq.bkt.clouddn.com/17-3-1/44114340-file_1488356237874_109dc.png)

### 3.3.5从控制台打印菱形

![](http://ojx4zwltq.bkt.clouddn.com/17-3-1/49178173-file_1488357278002_11667.png)

### 3.3.6从控制台打印九九乘法表

![](http://ojx4zwltq.bkt.clouddn.com/17-3-1/6964226-file_1488358316383_91fd.png)

3.3.7 打印出圣诞树🎄（挑战，不要求）

![](http://ojx4zwltq.bkt.clouddn.com/17-3-1/16057359-file_1488358958723_11ad7.png)

## 作业：          

1. 比较 while 和 do-while 的区别

2. 计算100以内（包括100）的偶数之和（使用 while循环）

3. 输入一个正整数，将该数的各位左右反转输出，即输入123，输出321（使用while循环实现）


   ```java
   import java.util.Scanner;
   /**
    * 
    * @author anonymity
    *	一个多位数，对10取模，必然得到其个位数，
    *	其商 对10 取模，必得到原多位数的十位数...
    *	int mun = 0;	
    *  while(num != 0){
    *     mun =  num % 10 + mun * 10;
    *     num /= 10;
    *  }
    * 下面的代码利用字符串实现
    */
   public class Ex03 {

   	public static void main(String[] args) {
   		// TODO 输入一个整数，然后将其倒序输出
   		System.out.println("请输入一个整数：");
   		Scanner integer = new Scanner(System.in);
   		int i = integer.nextInt();
   // 		将数字转为字符串
   		String SI = ""+i;
   //		System.out.println(SI);
   //		计算字符串长度
   		int sLength = SI.length();
   //		将数字的个位数赋值给字符串变量
   		int j = 1;
   		String jString = "", nti = "";
   		while (j<= sLength) {
   //			将倒数第n个数字赋值给第n个数字，以字符串的形式操作
   			jString = SI.substring((sLength-j), (sLength-j+1));
   //			连接字符串
   			nti +=jString;
   			j++;
   		}
   		System.out.println(nti);
   		integer.close();
   	}
   }
   ```

4. ### 求s=a+aa+aaa+aaaa+aa...a的值，其中a是一个数字。例如2+22+222+2222+22222(此时共有5个数相加)，几个数相加由键盘控制。

5. 循环录入某学生5门课的成绩并计算平均分，如果某分数录入为负，停止录入并提示录入错误（结合break或continue）

   ![](http://ojx4zwltq.bkt.clouddn.com/17-2-23/4781419-file_1487779392443_291c.png)

   ![](http://ojx4zwltq.bkt.clouddn.com/17-2-23/85853894-file_1487779380577_1129b.png)

6. 从控制台输入一个个位数，并列出这个数的所有加法等式

   ![](http://ojx4zwltq.bkt.clouddn.com/17-2-23/73828040-file_1487779407249_14c8d.png)

7. 3个班级各4名学员参赛，计算每个班级参赛学员平均分，统计成绩大于85分学员数 

   ![](http://ojx4zwltq.bkt.clouddn.com/17-2-23/45017825-file_1487839112313_e9c2.png)

8. 在题目7的基础上，增加要求：如果录入的分数大于100，则重新录入该学员的成绩。如果录入的分数为负数，则停止一切录入，程序结束