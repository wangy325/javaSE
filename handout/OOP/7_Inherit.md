# 封装和继承

Java 面向对象的基本特征：封装、继承和多态

1. private 关键字声明成员变量，set/get访问成员属性
2. static 关键字
3. 继承
4. super 关键字
5. 继承中的构造方法
6. Java 中的访问权限
7. Override 方法的覆写

## 7.1封装性(Encapsulation)

### 7.1.1封装的概念

​	***高度概括：对属性的访问做限制***

​	在Java中**类的封装性**主要体现不能让外部随意修改一个成员变量的值，否则会引起很多逻辑上的错误，以及一些不可预知的错误

​	在定义一个类的成员（包括变量和方法），使用private关键字说明这个成员的访问权限，只能被这个类的其他成员方法调用，而不能被其他的类中的方法所调用；为实现封装性，常**将类的成员变量声明为private,再通过public的方法来对这个变量进行访问。**对一个变量的操作，一般都有 读取和赋值操作，我们一般定义两个方法来实现这两种操作，即：getXxx()与setXxx();

​	一个类就是一个模块，我们应该让模块仅仅公开必须要让外界知道的内容，而隐藏其他的一切内容。再进行程序设计时，应尽量避免一个模块直接修改或操作另一个模块的数据，模块设计追求强内聚（许多功能尽量在类的内部独立完成，不让外面干预），弱耦合（提供给外部尽量少的方法调用）

假设：有 Student 的学生类，里面有一个属性 age，年龄

```java
public class Student {
	int age;//年龄
}
```

问：这么访问属性有没有问题？

```java
public static void main(String[] args) {
		
	Student student = new Student();
	student.age = 999;
		
}
```

答：显示生活中，年龄有999岁的吗？随意访问age属性，明显问题就出现了。

*那么怎么解决这个问题？*

### 7.1.2 private

>Java中共四种权限修饰符：public、private、protected、default(默认，什么都不写，也称为包访问权限)
>>被 **private** 修饰的属性和方法的特点是：只有当前类才能访问。

*解决上面的问题，首先使用private私有age属性：*

```java
public class Student {
	private int age;//年龄	
}
```

但是，此时如果是在**其他类**中使用一下代码，会出现无法访问的问题：

```java
public static void main(String[] args) {	
	Student student = new Student();
	student.age = 999;
  //上行代码报错，找不到age属性。因为该属性，被 private 修饰，所以只有Student 本类才能访问
		
}
```

*如果解决该问题？被 private 修饰的属性，怎么在外部类去修改该属性值？*

### 7.1.3 get和set方法

使用get和set方法是为了程序的封装，为了其它的类可以使用（设置set和获取get）该类的私有属性和方法

```java
public class Student {
	private int age;//年龄	
	public int getAge() {
		return age - 3;
	}

	public void setAge(int age) {
		if (age<100&&age>0) {
			this.age = age;
		}else{
			System.out.println("设置的age不合法");
			this.age = 18;//如果设置非法年龄，自动设置age默认为18
		}	
	}
}
```

这样就可以通过 public 的 get和set 方法，让外部类去访问 Student 私有的属性 age了。*但访问受到了限制*：

```java
public static void main(String[] args) {
		
	Student student = new Student();
	student.setAge(999);
  	System.out.println("年龄为："+student.getAge());
  
  //控制台将输出： 
  //设置的age不合法
  //年龄为：18
}
```

> get 和 set 是为了程序的封装，封装是为了对 外部类访问本类属性和方法做限制

## 7.2 static关键字

### 7.2.1静态代码块

用static修饰的代码块称之为静态代码块：

```java
public class Test {
	public int a;
	
 	static{ //用static修饰的代码块称之为静态代码块
		System.out.println("我是静态代码块");
	}
  
	{  // 构造代码块
		System.out.println("我构造代码块");
	}
	
	public Test(){//构造方法
		System.out.println("我是构造方法");
	}

}
```

> 注意：
>
> 1. 静态代码块只有在类第一次加载到内存的时候执行一次
> 2. 构造代码块在每次new对象的时候都会执行一次
> 3. 构造代码块执行在构造方法前面

### 7.2.2 静态属性

用static修饰的成员变量，叫静态成员变量。(静态域、静态属性)

例如： 

```java
public  static  int  a;    //声明一个静态的整型成员变量
```

>  注意：
>
>  1. 静态变量只有在第一次加载类到内存的时候初始化一次
>  2. static只能修饰成员变量，不能修饰局部变量。

### 7.2.3 静态方法

用static修饰的方法，叫静态方法

例如：

```java
public static int fun(){
	System.out.println("我是静态方法");
}

public int fun(){
	System.out.println("非静态方法、实例方法、普通方法");
}
```

不用static修饰的方法，在很多地方也称之为非静态方法、实例方法

> 注意：静态方法内访问本类的 属性和方法 必须也是静态的

***总结：***

1. 在类中，用static声明的成员变量为静态成员变量，在类第一次使用时被初始化，对于该类的所有对象来说，static成员变量只有一份，它是该类的公用变量，也叫**类变量**或**类属性**
2. 用static声明的方法为静态方法，该方法独立于类的实例，所以也叫类方法
3. **静态方法中只能调用本类中其他的静态成员(变量和方法)**
4. 静态方法中不能使用this和super关键字 [参考](http://blog.csdn.net/tiantiandjava/article/details/42269173)
5. 静态成员(类成员)可以通过类名直接访问，也可以通过类的对象去访问。但是强烈建议通过类名访问静态成员



```java
package com.wangy325.demo01;
public class Demo03 {
    /**
     * 测试 static 关键字修饰的属性（成员变量、字段）
     * 和方法
     */
    static int num =9;
    String str = "hello china";
	// 静态方法
    public static void test(){
        int sum = num + 9;
        Demo03 t = new Demo03();
      // 直接在静态方法中访问非静态成员变量，是不可行的
      // 实需访问，可以创建类的实例化对象，再访问
        String rts = t.str.toUpperCase();
        System.out.println(sum + rts);
      // 同理，访问方法也是一样
        t.tset();
    }
  	// 普通方法
    public  void  tset() {
        int mus = num + 19;
        String niss = str.concat("!");
        System.out.println(mus + niss);
    }

    public static void main(String[] args) {
        test();
        Demo03 s = new Demo03();
        s.tset();
    }
}
```

### 7.2.4 static 内存分配：

静态区: 

1. 又叫方法区，不属于堆，也不属于栈，类似堆一样，被所有的线程共享。方法区包含所有的class和static变量
2. 方法区中包含的都是在整个程序中**永远唯一**的元素，如class，static变量

## 7.3 继承

### 7.3.1 继承的概念

​	一个类继承另一个类。实现继承的类称为子类(subclass)也叫派生类，而被继承的类称为父类，也叫超类或基类

​	通过“继承”一个现有的类，可以在子类中使用被继承的的类(父类)中的**非私有的属性和方法**

​	类的方法和属性可以被继承，但是类的构造器(构造方法)不能被继承

​	假如两个类有相同的属性和方法，那么就可以创建一个具有他们共同属性和方法的类作为父类(基类)，让子类来实现该父类，根据实际业务需求来添加新的属性和方法

### 7.3.2 类的继承的使用

#### 7.3.2.1 语法

Java中继承使用关键字 extends

```java
	[权限修饰符]  class  <类名>  extends <父类名>
	{   
		//类中代码
	}
```

在java中一个类只能有一个直接父类，即：**java只支持单继承**，不支持多继承（与C++不同）

#### 7.3.2.2 特点

1. 子类可以访问父类中**非私有的`成员变量`和`方法`**
2. java只支持单继承不支持多继承：一个类最多只能有一个直接父类

正确的示例：

```java
public class SubClass extends SuperClass{}    
```

错误的示例：

```java
public class SubClass extends SuperClass1, SuperClass2{}
```

3. java支持多层继承(继承体系)。B继承A， C可以再继承B

例如：

```java
public class A{}
public class B extends A{}
public class C extends B{}
```

#### 7.3.2.3 继承关系的初始化顺序

父类属性 ---> 父类构造方法 ----> 子类属性 ----> 子类构造

## 7.4 super关键字

使用super可以调用父类的成分：父类的成员变量、父类的方法、父类的构造方法

> 注意：使用`super`关键字和`this`关键字，均不能用在静态方法中，只能用在普通方法(实例方法)中

### 7.4.1访问属性：

父类

```java
public class FatherClass{
  public int age=18;
}
```

子类

```java
public class ChildClass extends FatherClass{
  public int age = 10;
  public void test1(){
  System.out.println(this.age);//这里将输出 10
  }
  public void test2(){
    System.out.println(super.age);//这里将输出 18
  }
  public void test3(){
  System.out.println(age);
  //这里将输出 10；默认情况，如果父类存在age属性，子类也存在age属性，直接访问age将是以 this.age 形     势访问。但如果本类不存在age属性，则将以 super.age 的形势访问
  } 
}
```

### 7.4.2 访问方法：

父类

```java
public class FatherClass{
  public void show(){
    System.out.println("Father类方法");
  }
}
```

子类

```java
public class ChildClass extends FatherClass{
  public void show(){
    System.out.println("Child类方法");
  }
  
  public void test1(){
    this.show();//这里将输出：Child类方法
  }
  public void test2(){
    super.show();//这里将输出：Father类方法
  }
  public void test3(){
  	show();//这里将输出：Child类方法；
    
  //默认情况，如果父类存在show()方法，子类也存在show()方法，直接访问show()方法将是以 this.show() 形势访问。但如果本类不存在show()方法，则将以 super.show() 的形势访问
  } 
}
```

### 7.4.3 this和super的区别

![](http://ojx4zwltq.bkt.clouddn.com/17-2-6/55232501-file_1486370808766_d5a7.png)

## 7.5 继承中的构造方法

​	由于子类和父类的类名(包括包名)肯定不同，而构造方法的名字必须和类名一致，所以**构造方法不能继承**

​	创建子类对象时，子类会继承父类的一些元素，所以子类**会先访问父类的构造方法**

### 7.5.1 调用父类的构造方法

子类实例化时，必须**首先调用父类的构造方法**，然后才是子类的构造方法。**默认情况调用的为父类的无参构造方法**

```java
public class FatherClass {
	int age;
	public FatherClass() {
		super();
	}
	public FatherClass(int age) {
		this.age = age;
	}
}
```

调用父类的构造方法：

```java
public class ChildClass extends FatherClass {	
	public ChildClass() {
		super();//默认调用无参构造方法
	}

	public ChildClass(int age) {
		super(age);//指定调用父类的具体构造方法
	}
}
```

> 注意：	
>
> 1. 有时，需要在子类的构造方法中来调用父类的某个特定的构造方法。语法：super(实参,实参,实参……)  
> 2. super()调用父类构造方法时，必须是子类该构造方法的**第一行**代码
> 3. 实参可以为空，当实参为空时表示调用的是父类的无参构造方法，此时与省略super()效果相同

## 7.6 访问权限

1、public：public表明该数据成员、成员函数是对所有用户开放的，所有用户都可以直接进行调用
 2、private：private表示私有，私有的意思就是除了class自己之外，任何人都不可以直接使用，私有财产神圣不可侵犯嘛，即便是子女，朋友，都不可以使用。
 3、protected：protected对于子女、朋友来说，就是public的，可以自由使用，没有任何限制，而对于其他的外部class，protected就变成private。   

![](http://ojx4zwltq.bkt.clouddn.com/17-2-6/69644855-file_1486369139815_11c4b.png)

## 7.7 方法覆写

方法的重写：也叫方法的覆写

其就是在子类覆写一个与父类名字一样且参数列表相同的方法

方法的返回值与修饰符也需要遵循一定规则

### 7.7.1 方法覆写的规则

方法覆写遵循规则：两同、两小、一大

> 两同： 方法名相同、参数列表相同
>
> 两小：被覆写的方法在子类中的返回值的引用类型的范围比父类小或者与父类相同
>
> ​	   *被覆写的方法子类中抛出的异常范围不得大于父类*
>
> 一大：被覆盖的方法在子类中**访问控制权限**范围不得小于父类 [参见](http://blog.csdn.net/ponnim_cs_dn/article/details/38726767)
>



# 作业

1. 定义一个人类（姓名，年龄，性别，自我介绍方法）, 
      a：学生类继承人类（新增：学号，班级）
      b：老师类继承人类（新增：工号，教龄）
      c：学生类和老师类重写自我介绍   

2. 创建两个具有继承结构的两个类，父类和子类均有自己的静态代码块、构造代码块、构造方法。
      创建多个子类对象，观察他们的运行顺序。

3. 有农民(farmer),教师(teacher),科学家(scientist),服务生(attendant) 
      a: 其中农民，服务生只有基本工资. 
      b: 教师除基本工资外,还有课酬(元/天) 
      c: 科学家除基本工资外，还有年终奖 
      d: 请你写出相关类,将各种类型的员工的全年工资打印出来 

4. 编写一个长方形(矩形)类Rect，包含：

   两个protected属性：矩形的长length；矩形的宽width。

   两个构造方法：

   1．一个带有两个参数的构造方法，用于将length和width属性初化；

   2．一个不带参数的构造方法，将矩形初始化为宽和高都为10。

   两个方法：

   求矩形面积的方法 showArea()

   求矩形周长的方法 showPerimeter()​

   再创建一个长方体类Cuboid，继承长方形，（新增属性：高height，新增方法：显示体积 showBulk）。

5. 完成如下功能 
      a: 设计一个表示二维平面上点的类Point，包含有表示坐标位置的protected 类型的
      ​		成员变量x 和y，获取和设置x 和y 值的public 方法。
      b: 设计一个表示二维平面上圆的类Circle，它继承自类Point，包含一个 static的属性 PI=3.14，还包含有表示圆半径的protected 类型的成员变量r、获取和设置r 值的public  方法、计算圆面积的public 方法。 
      c: 设计一个表示圆柱体的类Cylinder，它继承自类Circle，还包含有表示圆柱体高的
      ​		protected 类型的成员变量h、获取和设置h 值的public 方法、计算圆柱体体积的public
      ​		方法。
      d: 建立Cylinder 对象，输出其轴心位置坐标、半径、面积、高及其体积的值。 

6. 简述this和super的区别？