## 面向对象编程习题



### 选择

1．下列关于继承优点的叙述正确的是哪几项？（选三项）

  - [x] A．可以创建更为特殊的类 (抽象类)
  - [x] B．消除重复代码
  - [ ] C．执行效率高
  - [x] D．便于维护    

2．现有

  ```java
	public class Parent{
    	public void change (int x){ }
     }
  ```

```java
    public class Child extends Parent{
    //覆盖父类change方法
    }
```

   下列哪个声明是正确的覆盖了父类的change方法？

- [ ] A. protected void change (int x){}
- [ ] B. public void change(int x,  int y){}
- [x] C. public void change (int x){}
- [ ] D. public void change (String s){}

3．如果想要一个类不能被任何类继承的话，需要使用哪个关键字来修饰该类？

- [ ] A. abstract
- [ ] B.  new
- [ ] C. static
- [x] D. final

4．为了使得`System.out.println()`输出对象引用的时候得到有意义的信息我们应该覆盖Object 的哪个方法？

- [ ] A．equals
- [x] B．toString
- [ ] C．hashCode
- [ ] D．notify


5．现有：

```java
	public class Pet{}
```
```java
    public class Cat extends Pet{}
   		//执行代码
	public sattic void main(String[] args){
    	Cat c = new Cat()；
    	Pet p=  (Pet)c；
    }
```
   后下列哪项是正确的？

- [ ] A. Pet p=(Pet)c运行错误
- [ ] B. Pet p=(Pet)c编译错误
- [x] C. Pet p= (Pet)c正常执行
- [ ] D．以上都不对


6．程序：
```java
public class Pet{
    public void speak(){
    	System.out.print（"pet"）；
    }
}
```
```java
public class Cat extends Pet{
    public void  speak(){
    	System.out.print("Cat")；
    }
}
```
```java
public class Dog extends Pet(
    public void  speak(){
	   System.out.print("Dog");
   }
}
```
```java
public static void main(String[] args){
    Pet[] p=  {new Cat (),new Dog(),new Pet()};
    for (int i=O;i<p.length;i++)
    p[i] .speak()；
}
```
后输出的内容是哪项？

- [ ] B. Cat Cat Cat
- [ ] C. Cat Dog Dog
- [x] D. Cat Dog Pet


7．现有： 

```java
   class Dog{ }

   class Harrier extends Dog  { }

   class DogTest{
       public static void main (String  []  args) {
            Dog dl=new Dog()；
            Harrier hl=new Harrier()；
            Dog d2=hl;//upcasting
            Harrier h2=  (Harrier) d2; // downcasting
            Harrier h3=d2; // ClassCastException
       }
   }
```

下面哪一项是正确的？

- [ ] A.2个Dog对象被创建
- [ ] B.2个Harrier对象被创建
- [ ] C.3个Harrier对象被创建
- [x] D．编译失败    

8．现有：

```java
    class Cat  {
       Cat (int c)  {
          System.out.print("cat"+c);  
       }
    }

    class SubCat extends Cat  {
    	SubCat (int c){
          super (5);
          System.out.print ("cable");
       }
     	SubCat(){  
          this (4)；  
     }

     public static void main (String  [] args)  {
          SubCat s= new SubCat();
       }
    }
```
结果为：
- [ ] A. cat5
- [ ] B. cable
- [x] C. cat5 cable
- [ ] D. cable cat5



9．现有：

```java
   class Guy {
      String  greet() {
           return "hi";  
      }  
   }
   class Cowboy extends Guy  ( 
       String greet(){
            return "howdy;   
       } 
   }
   
   class Surfer extends Guy{ 
       String greet(){
           return "dude! "; 
       } 
   }

   class Greetings  {
      public static voidmain (String  []  args)   {
          Guy  [] guys = {new Guy(), new Cowboy(),new Surfer() };
         for (Guy g：  guys){
           System.out.print(g.greet());
         }
    }
 }

```

结果为：

- [x] A. hi howdy dude!

- [ ] B.运行时异常被抛出。

- [ ] c．第7行出现一个错误，编译失败。

- [ ] D．第8行出现一个错误，编译失败。


10．现有：

```java
 class Over  {
	int dolt (long x)  { return 3;  }
}

class Under extends Over  {
	//insert code here
}
```

和四个方法：

```java
short dolt (int y)  { return 4;  } 	// 可以通过编译，子类和父类允许存在同名方法
```

```java
int dolt(long X long y)  { return 4;  }	// √ 但是这种写法, 除了在选项中释放干扰
```

```java
private int dolt(short y)  { return 4;  }	// √  还有什么用, 编程这么写怕不是要被打死哦!
```

```java
protected int dolt (long x)  { return 4;  }		// √
```

分别插入到第6行，有几个可以**通过编译**？

- [ ] A.  1

- [ ] B.  2

- [ ] C.  3

- [x] D.  4

> 子类和父类出现同名方法, 可参见[Over](/playground/Exercises2/src/com/wangy325/beverage)

11. 现有
```java
class Beverage {
    Beverage ()  {  System.out.print ("beverage");  }
}

class Beer extends Beverage {
    public static void main(String [] args) {
         Beer b = new Beer (14) ;
    }
    public int Beer(int x) {	// x  这一行既不是构造器也不是方法, 删除 int
        this () ; n
        System.out.print ("beerl") ;
    }
    public Beer() { System.out.print("beer2 "); }
}
```
结果是什么?

-[ ] A.beerl beverage

-[ ] B. beer2 beverage

-[ ] C. beverage beer2 beerl

-[x] D.编译失败

12．现有：
```java
class SuperFoo{
	SuperFoo doStuff (int x)  {
		return new SuperFoo();
	}
}

class Foo extends SuperFoo  {
// insert code here
}
```
和四个声明：

```java
Foo doStuff (int x)  { return new Foo()；  }  // √
```

```java
Foo doStuff (int x)  { return new SuperFoo()；  } // x
```

```java
SuperFoo doStuff(int x)  { return new Foo();  } // x
```

```java
SuperFoo doStuff(int y)  { return new SuperFoo();  } // √
```

分别插入到第7行，有几个可以通过编泽？

- [ ] A.1

- [x] B.2

- [ ] C.3

- [ ] D.4

> 此题考察了父类方法的覆写, 此题的详细分析参见 [override](/playground/Method2/src/com/wangy325/override)

13．现有：

```java
class HorseRadish  {
	// insert code here
	protected HorseRadish (int x)    {
 		System.out.println ("bokchoy");
	}
}

class Wasabi extends HorseRadish  {
	public static void main (String  [] args)    (
		Wasabi w = new Wasabi();
	}
}
```

分别插入到第2行，哪两项允许代码编译并产生”bok choy”输出结果？（选

两项）

- [x] A. protected HorseRadish()  {this (42)；}

- [ ] B. protected HorseRadish()  {}

- [ ] C.  //just a comment

- [x] D. protected  HorseRadish()  {  new HorseRadish (42);}


 ### 写出运行结果

1、写出运行结果:

```java
public classComputer{     
       String mainbord,cpu;
       public Computer(String s1,String s2){  
              mainbord=s1;
              cpu=s2;        
       }

       public static void main(String[]args){    
              Computer c=new Computer("华硕","Intel");
              System.out.println("mainbord:"+c.mainbord+",cpu:"+c.cpu);         
       }     
}     
///:~ 
// mainboard:华硕,cpu:Intel
```

2、写出运行结果：               。

```java
public class ExamA{
    private static int arr[] = new int[5];
    public static void main(String args[]) {
        for(int i=arr.length-1;i>=0;i--)
            arr[i] = 2*i+1;
		// for done
        String output = "0";
        int sum = 0;
        for(int i=0;i<arr.length;i++){
            sum += arr[i];
            output += " + " + arr[i];
        }

        output +=sum;
        System.out.println(output);

    }

}
///:~
// 0 + 1 + 3 + 5 + 7 + 925
```

3、写出运行结果：

```java
public class Person{   
       String name;
       int age;
      public Person(String name,int age){      
             this.name=name;
             this.age=age;
      }

    public static void main(String[]args){    
           Person c=new Person("Peter",17);
           System.out.println(c.name+" is "+c.age+" years old!");
    }
}
///:~
// Peter is 17 years old!
```

4、写出运行结果：               。

```java
public class abc{
      public static void main(String  args[]) {
            SubSubClass  x = new  SubSubClass(10 , 20 , 30);
            x.show();
      }
}

class  SuperClass{    
    int   a,b;
    SuperClass(int aa , int   bb){   
   		 a=aa;   
   		 b=bb;   
	}
	void show(){   
     	 System.out.println("a="+a+"  b="+b);  
	}
}

class SubClass extends SuperClass{   
    int c;
    SubClass(int aa,int bb,int cc){
         super(aa,bb);
          c=cc;
     }
 }

class SubSubClass extends SubClass{    
	int a;
	SubSubClass(int aa,int bb,int cc){    
		super(aa,bb,cc);
		a=aa+bb+cc;
	}

	void show(){ 
     System.out.println("a="+a+"  b="+b+"  c="+c);   
}
}
///: ~
// a=60 b=20 c=30
```

5．下面是一个类的定义，请将其补充完整

```java
 class Student{

      String name;
      int age;
      Student(String name, int a){
         this.name=name;
         age=a;
      }
}

  class A{
      String s;
      static int a=3;
      A(String s){
         this.s=s;
      }

    static int getA(){
         return a;
    }
}
```

### 编程题

> 所有题目的代码写在[workbook1](/playground/Exercises2/src/com/wangy325)中

1．按要求编写一个Java应用程序：

(1)定义一个接口CanCry，描述会吼叫的方法public void cry()。

(2)分别定义狗类（Dog）和猫类（Cat），实现CanCry接口。实现方法的功能分别为：打印输出“我是狗，我的叫声是汪汪汪”、“我是猫，我的叫声是喵喵喵”。

(3)定义一个主类G， 

​       ①定义一个void makeCry(CanCry c)方法，其中让会吼叫的事物吼叫。

​       ②在main方法中创建狗类对象（dog）、猫类对象（cat）、G类对象（g），用g调用makecry方法，让狗和猫吼叫。

2．某公司正进行招聘工作，被招聘人员需要填写个人信息，编写“个人简历”的封装类。包括如下属性和对属性**进行操作**的方法。

​    String xm;// 姓名

​    String xb;// 性别

​    int nl;// 年龄

​    String jtzz;// 家庭住址

​    String xl;// 学历

3．编写程序，提供实现各种数学计算的方法。包括如下几项。

（1）两个数的加、减、乘、除。

（2）求某数的相反数、倒数、绝对值。

（3）取两数中较大的和较小的。

（4）对浮点数（double型）的计算功能。如：给定浮点数d，取大于或等于d的最小整数，取小于或等于d的最大整数，计算最接近d的整数值，计算d的平方根、自然对数ln(d)等。

（5）计算以double型数a为底数，b为指数的幂。

 

4．编写一个**抽象类**Shape，声明计算图形面积的抽象方法。再分别定义Shape的子类Circle（圆）和Rectangle（矩形），在两个子类中按照不同图形的面积计算公式，实现Shape类中计算面积的方法。

 

5．定义一个接口，接口中有3个抽象方法如下。

（1）“long fact(int m);”方法的功能为求参数的阶乘。

（2）“longintPower(int m,int n);”方法的功能为求参数m的n次方。

（3）“booleanfindFactor(int m,int n);”方法的功能为判断参数m加上参数n的和是否大于100。

定义类实现该接口，编写应用程序，调用接口中的3个方法，并将调用方法所得的结果输出。

 

6．创建一个接口IShape，接口中有一个求取面积的抽象方法“public double area()”。定义一个正方形类Square，该类实现了IShape接口。Square类中有一个属性a表示正方形的边长，在构造方法中初始化该边长。定义一个主类，在主类中，创建Square类的实例对象，求该正方形对象的面积。

 

7．定义一个人类，包括属性：姓名、性别、年龄、国籍；包括方法：吃饭、睡觉，工作。

（1）根据人类，派生一个学生类，增加属性：学校、学号；重写工作方法（学生的工作是学习）。

（2）根据人类，派生一个工人类，增加属性：单位、工龄；重写工作方法（工人的工作是……自己想吧）。

（3）根据学生类，派生一个学生干部类，增加属性：职务；增加方法：开会。

（4）编写主函数分别对上述3类具体人物进行测试。

8.编写一个班级类 Class927，以及学生类Student

1. 学生类：
   1. 属性：名字name(String)，年龄age(int)，性别sex(char)
   2. 添加适当的构造方法
   3. 方法：修改名字changeName，修改年龄changeAge，修改性别changeSex，显示学生信息showInfo

- 班级类：
  - 属性：有42个学生的容量，Student[] stus = new Student[42];。
  - 添加适当的构造方法
  - 方法：
    - 添加学生  addStudent(Student stu)
    - 添加学生信息，只有名字 addStudent(String name)
    - 添加学生信息，只有名字和年龄 addStudent(String name,int age)
    - 添加学生信息，有名字和年龄和性别 addStudent(String name,int age,char sex)
    - 修改学生信息 updateStudent(Student stu,String name);//参数二为需要修改的学生的姓名
    - 控制台输出所有学生的信息 printAllStudentInfo()。