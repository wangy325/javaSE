### 抽象类和接口

  1．下列有关抽象类的叙述正确的是哪项？  B

​    A．抽象类中一定含有抽象方法  可以有都是 正常的方法

​    B．抽象类的声明必须包含abstract关键字 是

​    C．抽象类既能被实例化也能被继承    抽象类不能实例化

​    D．抽象类中不能有构造方法        错误和抽象类和正常的类一样的  可有构造

 

​    2．下列有关抽象方法叙述正确的是哪项？（选两项）BD

​    A. 抽象方法和普通方法一样，只是前面多加一个修饰符asbtract   抽象方法没有方法体

​    B．抽象方法没有方法体

​    c．抽象方法可以包含存任何类中  

​    D．包含抽象方法的类的具体子类必须提供具体的覆盖方法

   

​    3．下列有关接口的叙述错误的是哪项？

​    A.接口中只能包含抽象方法和常量

​    B．一个类可以实现多个接口

​    C．类实现接口时必须实现其中的方法       类如果实现接口  一定要实现抽象方法或者  这个类 要改成抽象类

​    D.接口不能被继承        接口和接口之间可以继承      接口和类之间是 实现



​     4．下列关于接口的定义哪项是正确的？

​    A． interface C{int a；}int a 要初始化  接口只能放常量  

​    B. public interface A implements B  {}   接口和接口之间 是继承

​    C. public interface A  {int a();}int a() 是个方法

​    D. abstract interface D  {}  写法可以  不规范  

  5．现有：

​    1． interface Animal  {

​    2.   void eat()；

​    3．    }

​    4．

​    5. // insert code here

​    6．

7. public class HouseCat implements Feline {

​    8．   public void eat()    {  }

​    9．  }

  和以下三个接口声明：C

​    interface Feline extends Animal  {}    接口和接口之间可以继承  实现

​    interface Feline extends Animal  {void eat();    }  //可以  没有意义

​    interface Feline extends Animal  {void eat()   {  }  }  //接口中只有抽象方法和常量

  分别插入到第5行，有多少行可以编译？

  A.  0

  B.  1

  C.  2

  D.  3

  

   6．现自：

​    1． interface Color {  }

​    2. interface Weight  {  }

​    3． //insert code here

  和以下足六个声明：

​    class Boat extends Color, extendsWeight  { }  // 接口是实现 

​    class Boat extends Color and Weight  {  }  

​    class Boat extends Color, Weight  {  }

​    class Boat implements Color,  implements Weight  {  }  //语法 一个imlements   多个 接口之间用 ,

​    class Boat implements Color and Weight  {  } 

​    class Boat implements Color, Weight  {  }  

  分别插入到第3行，有多少行可以编译？B

  A.  0

  B.  1

  C.  2

  D.  3

​    7．现有：

​    1. abstract class Color  {

​    2.protected abstract  String getRGB();

​    3.  }

​    4．

​    5. public class Blue extends Color  {

​    6．    ／／insert code here

​    7.  }

​    和四个声明：

​    public String getRGB()  { return "blue";  }

​    String getRGB()  { return  "blue";  )

​    private String getRGB()  {  return "blue";  }

​    protected String getRGB()  { return "blue";  )

​    分别插入到第6行，有几个可以通过编译？C

​    A.  0

​    B.  1

​    C.  2

​    D.  3

​    

​    9．现有：C

​    1．  classTop  {

​    2.   static int X=1;

​    3．   public Top()  {  x *=3; ) x = x * 3  ; x +=3

​    4．    }

​    5. class Middle extends Top  {

​    6.public Middle()    {x+=1 }

​    7.public static void main(String  [] args)  {

​    8.Middle m=new Middle();

​    9.System.out.println (x)j

​    10.   }

​    11. }

  结果是什么？

​    A.  2

​    B.  3

​    C.  4

​    D．编译失败

 

   10．现有两个文件：

​    1. package X；

​    2. public class X  {

​    3. public static void doX()  {System.out.print ("doX");  }

​    4.  }

  和：

​    1．import x.X;

​    2. class Find  {

​    3.   publiC static void main (String []  args)    {

​    4.   X myX=new X();    myX.doX();    //静态方法 直接通过 类名调用

​    5．   X.doX()；//类名调用

​    6．   x.X.doX()： // 全类名   （包名 + 类名）

​    7.    x.X myx2=new x.X();    myx2 .doX()；   

​    8．   }  

​    9．  }

​    结果为：

​    A. Find类中第4行出现一个错误，编译失败。

​    B. Find类第5行出现一个错误，编译失败。

​    C. Find类第6行出现一个错误，编译失败。

​    D. doX doX doX doX

​    11.现有: C

​     1. class Tree {

​     2.  private static String tree = "tree ";

​     3.    String getTree ()  {  return tree; }

​     4. }

​     5. class Elm extends Tree {

​     6.  private static String tree = "elm ";

​     7.     public static void main (String  [] args)  {

​     8.     new Elm() .go (new Tree())  ;

​     9.   }

​    10.    void go (Tree t)  {

​                                          “tree”       + "elm"       + elm (不能访问静态的属性) + tree

​    11.           String  s = t.getTree () +Elm.tree  +  tree +   (new

​                       Elm() .getTree ()) ;

​    12.     System.out.println (s) ;

  

​    结果为:

​               A. elm elm elm elm

​               B. tree elm elm elm

​               C. tree elm elm tree

​               D. tree elm tree elm

​            

·  13．现有：D

​    1. interface  I {  void go();  }

​    2．

​    3. abstract class A implements I { } // 这个类实现方法   或者  这个类自己抽象 

​    4．

​    5. class C extends A  {

​    6．    voidgo(){ }

​    7.  }

  结果是什么？

  A.代码通过编译

  B.由于第1行的错误导致编译失败

  C.由于笫3行的错误导致编译失败

  D.由于第6行的错误导致编译失败

 

   14．现有：

​    1. interface Data {public void load();}

​    2. abstract class Info {public abstractvoid load();}

​    下列类定义中正确使用Data和Info的是哪项？

​    A. public class Employee implements Infoextends Data  {

​    public void load()  {／*do something*／)

​    )

​    B.public class Employee extendsInf.implements Data{

​    public void load()  {／*do something*／}

​    }

​    c.public class Empl.yee implements Infextends Data{

​    public void Data.1oad()  {* do something*／}

​    public void load(){／*do something*／}

​    )

​    D.public class Employee extends Infimplements Data  {

​    public void Data.1oad()  {／*do something*／)

​    public void info.1oad(){/*do something*/)

​    )

    15. 下列代码正确的是哪项?

  A. public class Session implements Runnable,Clonable{

​       public void run ();

​            public Object clone () ;

​                    }

  B. public class Session extends Runnable,Cloneable {

​      public void run() {/*do something*/}

​      public Object clone() {/*make a copy*/}

​                 }

  C. public abstract class Session

​         implements Runnable, Clonable {

​      pu)olic void run() {/*do something*/}

​      public Object clone() {/*make a copy*/}

​       }

  D. public class Session

​         implements Runnable, implementsClonable {

​      public void run() {/*do something*/}

​      public Object clone() {/*make a copy*/}

​      }



** **

​    1．下列自‘关多态的叙述正确的是哪项？（选两项）

​    A．父类的引用指向子类的实例是一种多态

​    B. 子类的引用指向子类的实例是一种多态

​    c．接口的引用指向实现该接口类的实例是一种多态

​    D．抽象类的引用指向抽象类的实例是一种多态

   

​    2．Java中方法绑定有哪些形式？（选两项）

​    A.编译时刻绑定

​    B.运行时刻绑定

​    c．静态绑定

​    D．私有绑定

​    

​    3．表达式"hello" instance of String返回的值是哪项？

​    A.  true

​    B．  false

​    C．  1

​    D．  0

   

​    4．求平方根方法public static double sqrt (double a)可以传递的参数

​    类型有哪些？（选三项）

​    A. byte

​    B．float

​    C. String

​    D. long

   

​    5．涉及类MyClass的方法签名足public void  find(MyClass a），那么该

​    方法可接收的实际参数的类型可以是哪些？（选两项）

​    A. MyClass类的类型

​    B. MyClass子类的类型

​    C. Object类型

​    D．所有接口

​    6．使用下列哪些关键字可以判定实参的具体类型？

​    A. as

​    B. is

​    C. instanceof    

​    D. extends

 

​    7．  现有：

​    class Pencil  {

​    public void write (String content){

​    System.out.println("Write"+content);

​    }

​    }

​    class RubberPencil extends Pencil{

​    public void erase (String content){

​    System.out.println("Erase"+content);

​    }

​    }

​    执行下列代码的结果是哪项？

​    Pencil pen=new RubberPencil();

​    pen.write ("Hello")；

​    pen.erase ("Hello");

​    A. Write Hello

​       Erase Hello

​    B. Erase Hello

​       Write Hello

​    C．编译错误

​    D．运行时抛出异常

   

​    8．  现有：

​    class Pencil  {

​    public void write (String content){

​    System.out.println("Write"+content)；

​    }

​    }

​    class RubberPencil extends Pencil{

​    public void write (String content){

​    System.out.println ("RubberWrite"+content);

​    }

​    public void erase (String content){

​    System.out.println ("Erase"+content);

​    }

​    }

​    执行下列代码的结果是哪项？

​    Pencil pen=new RubberPencil()；

​    pen.write("Hello")；

​    A. Write Hello

​    B. Rubber Write Hello

​    C.编译错误

​    D.运行时抛出异常

   

​    9  下列哪些方法是在编译时刻绑定的？（选三项）

​    A．静态方法

​    B. private方法

​    C．final方法

​    D.非private方法

   

​    10．现有：

​    class Pencil  {

​    public void write (String content){

​    System.out.println("Write",+content){

​    }

​    }

​    class RubberPencil extends Pencil{

​    public void write (String content){

​    System.out.println("RubberWrite"+content)；

​    }

​    public void erase (String content){

​        System.out.println( "Erase"+content);

​    }

​    }

​    执行下列代码的结果是哪项？

​    Pencil pen=new  Pencil();

​    (( RubberPencil) pen).write("Hello");

​    A． Write Hello

​    B. Rubber Write Hello

​    c．编译失败

​    D．运行时抛出异常

​    1 1．现有：

​    class TestA {

​    public void start()  { System.out.println("TestA"); }

​    }

​    public class TestB extends TestA  {

​    public void start()  { System.out.println("TestB"); }

​    public static v.id main(string[]  args) (

​    ((TestA)new TestB()).start();

​    }

​    }

​    运行结果是哪项？

​    A．  TeStA

​    B．  TeStB

​    c．编译失败

​    D．运行时抛出异常

 

​    12．现有：

​    class A {public String name="a"}

​    classB extends A {public String name="b"}

​    执行如下代码后的结果是哪项？

​    A a=new B()；

​    System.out.println(a.name);

​    A．  a

​    B．  b

​    c．编译失败

​    D．运行时抛出异常

​    

​    13．现有：

​    1 Interface F{}

​    2 class A implements F{}

​    3 class B extends A{}

​    4 class C extends B{

​    5   public static void main(String[] args){

​    6   B b=new B()；

​    7    ／／inSert C0de here

​    8   }

​    9   }

​    下列哪行代码插入到第7行，将抛出java.lang.ClassCaseException异常7

​    A.  A a=b;

​    B．  Ff=  (C)b；

​    C．  Ff=  (A)b；

​    D．  Bbb=  (B)(A)b；

   

14．现有：

1.  class Guy {  String greet()  { return "hi";  }  j

2.  class Cowboy extends Guy  { String greet()  {  return. "howdy";}}

3.  class Wrangler  extends  Cowboy {  String  greet() {  return  "orch!"; } }

4．

5． class Greetings2  {

6.   public static void main (String  []  args) {

7.   Guy g=new Wrangler();

8．   Guy g2=new Cowboy()；

9.     Wrangler w2=new Wrangler();

10.     System. out .print (g.greet()+g2.greet()+w2.greet())；

11.     }

12.     }

​    结果是什么？

​    A. hi hi ouch!

​    B. ouch! howdy  ouch!

​    C. hi howdy ouch!

​    D．编译失败

​    E.运行的咐候有异常抛出

   

​    15．现有：

​    class ClassA  {}

​    class ClassB extends ClassA  {)

​    class ClassC extends ClassA  {)

​    以及：

​    ClassA p0=new ClassA();

​    ClassB pl=new ClassB()；

   ClassC p2=new ClassC()；

​    ClassA p3=new ClassB()；

​    ClassA p4=new ClassC()；

·    下列哪些是正确的？（选三项]

​    A．p0=pl;

​    B．p1 =p2;

​    C．p2=p4;

​    D．p2 = (ClassC)pl;

​    E．p1 = (ClassB)p3;

​    F．p2 = (Classc)p4;