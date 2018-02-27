# 多态(Polymorphism)

Java 面向对象三大基本特征之一

1. 多态
2. 转型
3. Object 超类的常见4个方法介绍（简单）

## 8.1多态

### 8.1.1 什么是多态（具有多种形态）

在java中，一个对象的引用会有**两种类型**：1、编译时类型 2、运行时类型。

> 编译时类型由声明该变量时使用的类型决定(赋值运算符左边)

> 运行时类型由实际赋给该变量的对象决定(赋值运算符右边)

如果编译时类型和运行时类型不一致，就会出现**多态**(Polymorphism)

可以这么理解：定义一个引用变量，*编译时*是否能够通过要看赋值运算符的左边。*运行时*的实际表现要看赋值运算符的右边

### 8.1.2 多态的体现

多态只体现在 **对象的方法**中，属性(成员变量)和静态方法不具有多态性

> Java 的多态机制遵循一个原则：当父类引用变量指向子类对象时，对象的类型决定了调用谁的成员方法，但是这个被调用的方法必须是在父类中定义过的，也就是说被子类重写的方法

代码示例：

父类：

```java
public class FatherClass {
	public void  show() {
		System.out.println("父类的方法");
	}
}
```

子类：

```java
public class ChildClass extends FatherClass {
	@Override
	public void show() {
		System.out.println("子类的方法");
	}
}
```

多态：

```java
	public static void main(String[] args) {
		FatherClass fClass = new ChildClass();
		fClass.show(); //实际调用了子类中重写的 show() 方法
	}
// fClass 编译时是 FatherCLass 类型, 运行时是ChildClass 类型
// 当运行的时候, 调用引用类型(FatherClass类)的方法时, 总是表现为子类的方法的行为特征
// (前提是子类重写了父类的方法)
// 所以, 如果声明了相同类型的引用变量(Upcasting或没有), 调用相同的方法, 可能会表现不同的行为特征
// 如果子类中，未重写父类的 show() 方法， 那么将会直接调用父类的方法
// 这, 即是多态
///:~
//		子类的方法
```

### 8.1.3 动态多态和静态多态

1. 静态多态性指的是程序在编译时，系统就能决定调用哪个函数，如重载
2. 动态多态性指在运行中才能动态确定操作指针所指的对象，主要通过抽象函数和重写来实现。

## 8.2 对象转型

### 8.2.1 什么是对象转型

`基类的引用 ---> 子类的实例对象`

1. 一个基类的引用类型变量可以“指向”其子类的对象
2. 一个基类的引用不可以访问其子类对象新增加的成员（属性和方法）
3. 可以使用 `引用变量 instanceof 类名` 来判断该引用型变量所“指向”的对象是否属于该类或该类的子类
4. 子类的对象可以当做基类的对象来使用称作向上转型（upcasting）,反之成为向下转型（downcasting）

### 8.2.2 向上转型

假设，FatherClass类是ChildClass类的父类：

```java
FatherClass fClass = new ChildClass();//向上转型
```

> Java 中, 子类是一种特殊的父类, 因此 Java 允许把一个子类对象直接赋值给一个父类引用变量, 而无须任何类型转换, 这就是向上转型(Upcasting)

### 8.2.3 向下转型 （instanceOf）

假设，FatherClass类是ChildClass类的父类

即已声明 `FatherClass father = new FatherClass();`：

```java
	public void test(FatherClass father){
		if (father instanceof ChildClass) {//判定father引用指向的对象类型是否是ChildClass类型
			ChildClass child = (ChildClass) father;//向下转型。需要强制转换符
		}
	}
```

```java
package com.wangy325.demo01;

public class Son extends FatherClass {
    /**
     * 多态， 对象转型（upcasting &downcasting）
     */

    private String d = "飞花";

    @Override
    public void test() {
        System.out.println("子类重写的父类方法，什么都没有做");
    }

    public static void main(String[] args) {
        // 自动向上转型
        // 父类引用 = 子类对象
        FatherClass fs = new Son();
        // 可以访问父类的成员变量和方法
        // 如果子类覆写了方法，则访问子类覆写的方法
        fs.test();
        System.out.println(fs.s);
//        fs 不能访问子类新创建的成员变量和方法
//        System.out.println(fs.d);
//        fs.foo();
        // 如果要访问子类新建的成员变量和方法，须向下转型
        if (fs instanceof Son) {
            Son son = (Son) fs;
            System.out.println(son.d);
            son.foo();
        }
    }

    public void foo() {
        System.out.println(d);
    }
}
///:~
// 子类重写的父类方法，什么都没有做
// holo
// 飞花
// 飞花
```

> 1、父类引用可以指向子类对象，子类引用不能指向父类对象
>
> 2、把子类对象直接赋给父类引用叫upcasting向上转型，向上转型不用强制转型
>
> 　　 如Father father = new Son();
>
> 3、把指向子类对象的父类引用赋给子类引用叫向下转型（downcasting），要强制转型
>
> 　　 如father就是一个指向子类对象的父类引用，把father赋给子类引用son 即Son son =（Son）father；
>
> 　　 其中father前面的（Son）必须添加，进行强制转换
>
> 4、upcasting 会丢失子类特有的方法,但是子类overriding 父类的方法，子类方法有效
>
> 5、向上转型的作用，减少重复代码，父类为参数，调有时用子类作为参数，就是利用了向上转型。这样使代码变得简洁。体现了JAVA的抽象编程思想

### 8.2.4 什么时候需要使用对象的转型

* 当父类引用指向子类对象的时候，需要访问子类新增的属性和方法时 ----> 向下转型
* 当*形参*定义的是父类类型变量(引用)，但*实参*有可能是该形参类型的子类对象时
* 当返回值类型是父类类型，但返回的具体对象是子类对象时

## 8.3 Object类

**所有的类均直接或间接的继承自Object类**

1. 当定义一个类的时候，如果没有显式的使用extends关键字来声明继承某个类，则该类默认继承Object，所以Object类中方法，被所有的类继承过来了。
2. Object类可以看成是java中的“上帝类”或“祖宗类”。如果一个类显式的继承某个类，则该类不再直接继承Object类(Java的单继承)。但一定是间接继承Object类。

```java
public class Person {}
与
public class Person extends Object{}
是等价的
```

### 8.3.1 equals()方法

1. 该方法的返回值为boolean值。默认情况下当调用该方法的对象和参数传入的对象**是同一对象**时返回true，否则返回false。
2. 一般情况，根据实际的业务需求对该方法进行覆写，来定义自己的“相等”逻辑

> 提示：当如果需要把对象存入set集合中，需要覆写该方法(后续重点讲解)
>
> “==”和“equals”的区别：
>
> * == 比较的是两个对象是否为同一个对象(比较的内存地址是否相等)
> * equals默认也是比较的两个对象是否为同一对象。(从Objcet继承过来的)
> * 一般通过覆写equals方法来定义两个对象逻辑上是否相等。

### 8.3.2 [hashCode()方法](http://blog.csdn.net/fenglibing/article/details/8905007)

1. 该方法是一种native方法，即方法的实际实现是用c或c++写的。
2. 该方法的返回值为十进制的int值，可以理解为调用该方法的对象在堆内存中的地址值(唯一)。该方法一般在子类中进行覆写。

### 8.3.3 getClass()方法

1. 该方法是一种native方法，即方法的实际实现是用c或c++写的。

2. 该方法的返回值是调用该方法的对象所属类的类型。此方法无法在子类中被覆写。

   > 此方法到反射的时候再讲解

### 8.3.4 toString()方法

1. 该方法的返回值是String类型，描述当前对象的有关信息。默认是返回：调用该方法的对象所属类的类名+@+十六进制的hashCode值。
2. 该方法在子类中一般需要覆写，具体覆写样式根据业务需求来定。
3. Java SDK提供的一些系统类均对此方法进行了覆写：例如String、Date等(后续重点讲解)





# 作业

1. 声明一个Book类，属性有作者、书名、出版社三个属性。当两本书的作者、书名、出版社完全相同，则认为是同一本书。
   根据需要覆写hashCode、equals、toString方法

   ```java
   package com.wangy325.demo02;

   import java.util.Objects;

   public class Book {
       private String name, author, press;

       public Book(String name, String author, String press) {
           this.name = name;
           this.author = author;
           this.press = press;
       }

       public static void main(String[] args) {
           Book b1 = new Book("kite", "allen", "KLP");
           Book b2 = new Book("kite", "allen", "KLP");
           System.out.println(b1.equals(b2));
           System.out.println(b1.hashCode() == b2.hashCode());
       }

       @Override
       public boolean equals(Object o) {
           if (this == o)
               return true;
           if (o == null || getClass() != o.getClass())
               return false;
           if(!(o instanceof Book))
               return false;
           Book book = (Book) o;
           if(this.name.equals(((Book) o).name)
                   && this.author.equals(((Book) o).author)
                   && this.press.equals(((Book) o).press))
               return true;
           return false;
       }

       @Override
       public int hashCode() {

           return Objects.hash(name, author, press);
       }
   }
   ///:~
   // true
   // true
   ```

2. 完成宠物管理系统！

   1. 新建一个Pet类
      1. 属性：
         1. 名字String name
         2. 性别 char sex
         3. 年龄 int age
      2. 方法：
         1. 吃 eat
         2. 叫 howl
         3. 显示宠物信息 show
   2. 新建一个 Dog类 继承 Pet类
      1. 新增属性：
         1. 品种 kind
      2. 新增方法：
         1. 跑 run
         2. 拆家 dealer
   3. 新建一个Cat 类 继承 Pet类
      1. 新增属性
         1. 和主人的亲密度 love
      2. 新增方法
         1. 跑 run
         2. 卖萌 actingCute
   4. 新建一个类 PetShop
      1. 属性：
         1. 宠物店名字 String name
         2. 存储宠物的笼子 Pet[] pets。（宠物店最多能存储100只宠物）
      2. 方法：
         1. 进货宠物 private boolean addPet(Pet pet);//私有进货方法。
         2. 收购宠物 public boolean purchasePet(Pet pet);//公开收购宠物方法，在该方法调用 进货宠物 addPet 方法。
         3. 销售宠物 private Pet sellPet();//销售流程私有。
         4. 顾客买宠物 public Pet buyPet(int type);//1代表买 狗，2代表买猫。返回Pet。在该方法调用 销售宠物 sellPet 方法。
         5. 向顾客展示所有宠物信息 public void showPets()
   5. 测试（用户的角色是顾客）：
      1. 顾客进入宠物店。PetShop.name宠物店老板说：你是要买宠物（1）？还是要出售宠物（2）？还是随便看看然后离开（0）？
         1. 购买宠物：
            1. 需要买什么宠物？狗（1），猫（2）
               1. 选择狗：
                  1. 要什么品种的狗？

                  2. 输入完信息后查找宠物店是否存在该品种的狗，如果存在则随机出一个符合品种的狗购买，然后购买成功！输出狗的信息。

                     如果不存在该品种的狗，则提示：你选择的品种本店没有，本店有AAA、BBB、CCC等品种是否有你喜欢的？

                     有Y\没有N。如果输入有，则列出所有品种如：1、AAA;2、BBB；3、CCC，请选择？输入 2 怎随机出BBB品种的狗狗，然后购买成功，输出狗狗的信息！

                     > AAA\BBB指宠物店现有狗的品种。
                     >
                     > 注意：！！！
                     >
                     > 不要求购买交易流程等。只要能通过品种,然后从宠物店中所有该品种的狗随机出一只即可。
               2. 选择猫：
                  1. 需要多少亲密度的猫咪？(0-100)
                  2. 如果输入的亲密度为 X 则 随机出  [x-10~x+10]范围的猫咪，然后完成购买，输出猫咪信息。否则（流程参考狗的购买流程）
         2. 出售宠物：
            1. 你的宠物是？狗（1），猫（2）
               1. 选择狗：
                  1. 是什么品种的狗？
                  2. 是什么性别的狗？
                  3. 狗的年龄多大？
                  4. 狗取什么名字？
                  5. 输入完信息后完成出售，出售宠物成功！
               2. 选择猫：
                  1. 你的猫咪和主人的亲密度为多少？(0-100)
                  2. 是什么性别的猫？
                  3. 猫年龄多大？
                  4. 猫取什么名字？
                  5. 输入完信息后完成销售，销售成功！
         3. 离开！





注：[购买宠物]、[出售宠物]、[离开] 。等菜单可以循环选择！

题目只是大致的需求描述，具体的设计和可玩性 可以自由发挥设计！ 提示语句也不必跟题目要求一致。如：题目要求是 “狗的年龄多大？”，你可以自行设计，如：“您这只可爱的小狗狗今年几岁啦？”等等。

总之！结合程序的可玩性！可增加新的属性，可增加新的功能！发挥你们的想象力！


