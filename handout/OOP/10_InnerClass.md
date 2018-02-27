内部类和单例设计模式
===

1. 内部类
2. 设计模式之单例设计模式
3. 简单工厂设计模式

## 10.1 内部类

内部类是指在一个外部类的内部再定义一个类。类名不需要和文件名相同

内部类可以是静态static的，也可用public，default，protected和private修饰。（而外部顶级类即类名和文件名相同的只能使用public和default）。

> 注意：内部类是一个编译时的概念，一旦编译成功，就会成为完全不同的两类。对于一个名为Outer的外部类和其内部定义的名为Inner的内部类。编译完成后出现Outer.class和Outer$Inner.class两类。**所以内部类的成员变量/方法名可以和外部类的相同**

### 10.1.1 成员内部类

成员内部类，就是作为外部类的成员，**可以直接使用外部类的所有成员属性和方法**，即使是private

同时外部类要访问内部类的所有成员变量/方法，则需要通过内部类的对象来获取

要注意的是，成员内部类不能含有static的变量和方法。因为成员内部类需要先创建了外部类，才能创建它自己的，而 static 关键字修饰的变量和方法在类加载到内存中就要初始化。

在成员内部类要引用外部类对象时，使用Outer.this来表示外部类对象；

而需要创建内部类对象时，可以使用Outer.Inner  inner = outerobj.new Inner();

```java
package com.wangy325.demo02;

import org.jetbrains.annotations.NotNull;

public class Out {
    /**
     * 成员内部类的定义和使用
     */
    public static final double PI = 3.14;
    // 将内部类声明为成员变量（字段）
    private  Inner inner;
    private String name;

    public Out() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void eat(){
        System.out.println(this.name+" wanna eat noodles");
    }

    public static void sleep(){
        System.out.println("all people need sleep erery day.");
    }
    // 声明成员内部类
    public class Inner{
        // 成员内部类可以有自己的成员变量和方法
        // 并且可以和主类的名字相同
        private String name;
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        void eat(){
            System.out.println("but "+this.name+" wanna eat pizza");
        }

        // 内部类可以访问外部类的所有成员变量和方法（包括私有）
        void visitOut(){
          	// 直接访问外部类的静态常量
            System.out.println(PI);
            // 如果内部类和外部类存在同名的字段和方法的时候
            // 外部类要用 外部类名.this.属性（方法） 来访问
            System.out.println(Out.this.name);
            System.out.println(this.name);
            Out.this.eat();
        }
    }

    // 写一个方法，获取一个成员内部类对象
    private Inner getInnerInstance(){
        if(inner == null){
            inner = new Inner();
        }
        return inner;
    }

    public static void main(String[] args) {
        // 实例化一个外部类对象
        Out outer = new Out();
        outer.setName("zhangfei");
        System.out.println(outer.getName());
        outer.eat();
        // 实例化一个内部类对象
        // 1. 方法1 外部类.内部类 引用名 = 外部类实例.new 内部类() 实现
        Out.Inner inner = outer.new Inner();
        inner.setName("guangyu");
        System.out.println(inner.getName());
        inner.eat();
        inner.visitOut();

        // 2. 方法2 通过方法来获取实例
        outer.getInnerInstance().setName("liubei");
        outer.getInnerInstance().eat();
    }
}
///:~
//        zhangfei
//        zhangfei wanna eat noodles
//        guangyu
//        but guangyu wanna eat pizza
//        3.14
//        zhangfei
//        guangyu
//        zhangfei wanna eat noodles
//        but liubei wanna eat pizza
```

### 10.1.2 局部内部类

　　局部内部类是定义在**一个方法**或者**一个作用域**里面的类，它和成员内部类的区别在于局部内部类的**访问仅限于方法内或者该作用域内**

```java
class People{
    public People() {   
    }
}
 
class Man{
    public Man(){   
    }
    // 方法体 
    public People getWoman(){
        class Woman extends People{   //局部内部类
            int age =0;
        }
        return new Woman();
    }
}
```

　　注意，局部内部类就像是方法里面的一个局部变量一样，是不能有public、protected、private以及static修饰符的

### 10.1.3 静态内部类

静态内部类(嵌套内部类)，就是**修饰为static**的内部类

静态内部类不能访问外部类非 static 的成员变量和方法

声明为static的内部类，不需要内部类对象和外部类对象之间的联系，就是说我们可以直接引用`Outer.Inner` 来访问静态内部类的静态方法 和 实例化静态内部类

静态内部类和普通的内部类还有一个区别：普通内部类不能有static数据和static属性，也不能包含嵌套类(静态内)，但静态内部类可以。而静态内部类不能声明为private，一般声明为public，方便调用	

```java
package com.wangy325.demo02;

public class Out2 {
    /**
     * 静态内部类的声明和使用
     */

    static final String name = "bird";
    private int num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    void fly() {
        System.out.println("birds can fly.");
    }

    // 声明静态内部类
    static class Inner {
        // 静态内部类可以有 static 成员变量和方法
        static String name = "seagull";
        private int num;

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        void fly() {
            System.out.println("a seagull flies over the sea level");
        }

        static void scene() {
            System.out.println("a group of seagulls flying over the sea is quite a scene");
        }
        // 静态内部类中 访问外部类的成员和方法
        void visitOut(){
            // 可以访问外部类的静态成员和方法
            System.out.println(Out2.name);
            // 当然可以访问内部类的成员变量和方法，无论是否 static
            System.out.println(name);
            System.out.println(num);
            // 但是不能访问外部类的非 static 成员变量和方法
            // 以下代码编译出错
            /*System.out.println(Out2.this.num);*/
        }
    }

    public static void main(String[] args) {
        // 实例化外部类对象
        Out2 outer = new Out2();
        outer.setNum(3);
        outer.fly();

        // 访问静态内部类的属性和方法
        // 1. 访问内部类的静态属性和方法不需要创建对象，直接使用 外部类名.内部类名.方法名
        System.out.println(Out2.Inner.name);
        Out2.Inner.scene();
        // 2. 访问内部类的非静态属性和方法
        // 实例化内部类对象的方法， 外部类.内部类 引用名 = new 外部类.内部类（）
        // 不依赖外部类
        Out2.Inner inner = new Out2.Inner();
        inner.setNum(999);
        inner.fly();
        inner.visitOut();

    }
}
///:~
//        birds can fly.
//        seagull
//        a group of seagulls flying over the sea is quite a scene
//        a seagull flies over the sea level
//        bird
//        seagull
//        999
```

### 10.1.4 匿名内部类

匿名内部类是简化的局部内部类，使用最多

有时候我为了免去给内部类命名，便倾向于使用匿名内部类

匿名内部类是**不能加访问修饰符的**

**要注意的是，new 匿名类，这个类是要先定义的**，看下面例子：

```java
public class Outer { 
    public static void main(String[] args) { 
      // 实例化外部类
        Outer outer = new Outer(); 
        Inner inner = outer.getInner("Inner"); 
        System.out.println(inner.getName()); 
    }
 
    public Inner getInner(final String name) { 
      // 为什么形参要加上 final 关键字？
        return new Inner(){ 
            // private String nameStr = name; 
            public String getName() { 
                return name; 
            } 
        }; 
    }
}
 
//注释后，编译时提示类Inner找不到 
 interface Inner { 
    String getName(); 
} 
```

> 注意：
>
> ​	在这个例子，留意外部类的方法的形参，**当所在的方法的形参需要被内部类里面使用时，该形参必须为final**
>
> ​	因为，为了避免引用值发生改变，例如被外部类的方法修改等，而导致内部类得到的值不一致，于是用final来让该引用不可改变

> 1. 匿名内部类是局部内部类的更深入一步
> 2. 假如只创建某类的一个对象时，就不必将该类进行命名
> 3. 匿名内部类的前提是存在一个类或者接口，且匿名内部类是写在方法中的
> 4. 只针对重写一个方法时使用，需要重写多个方法时不建议使用
>
> 格式：
>
> ```java
> new 类名或接口名(){
>
> 重写方法;
>
> }；     //注意分号
>  //以上就是内部类的格式，其实这整体就相当于是new出来的一个对象
> ```
>
> 下面举个多线程中的例子
> ```java
> new Thread(){
> 	public void run(){
>        System.out.println(getName());
>     }
> }.start();
> ```
> 上面例子，如果去除.start()就是一个线程的匿名内部类【创建匿名内部类的同时，也会创建一个
> 对象】所以上文中的.start（）就相当于调用了Thread的start方法
>
> [来源链接](https://www.zhihu.com/question/49330534/answer/212085553)
> 来源：知乎

```java
package com.wangy325.demo02.anonymousinner;

public interface Seacher {
    public void workAtNight();
}

public abstract class Doctor implements Seacher {
    public void workAtDay(){
        System.out.println("白天搞研究");
    }
}

public class Studenta extends Doctor {

    @Override
    public void workAtNight() {
        System.out.println("学生a晚上看美剧");
    }
}

public class Studentb extends Doctor {
    @Override
    public void workAtNight() {
        System.out.println("学生b晚上搞事情");
    }
}
```

以下是 Test() 方法的几种不同写法，测试编译和运行都没有问题：

#### 写法1

```java
package com.wangy325.demo02.anonymousinner;

public class Test {
    public static void main(String[] args) {
        Doctor sa = new Studenta();
        sa.workAtDay();
        sa.workAtNight();

        Doctor sb = new Studentb();
        sb.workAtDay();
        sb.workAtNight();

        // 1、new 抽象类或者接口
        // 2、后加大括号
        // 3、实现未实现方法
        // IntelliJ 可以自动补全匿名内部类
        //？？ 实例化了一个抽象类 ？？
        Doctor dc = new Doctor() {
            @Override
            public void workAtNight() {
                System.out.println("导师晚上指导女学生");
            }
        };
        dc.workAtDay();
        dc.workAtNight();
    }
}
```

#### 写法2

```java
package com.wangy325.demo02.anonymousinner;

public class Test {
    public static void main(String[] args) {
        Doctor sa = new Studenta();
        sa.workAtDay();
        sa.workAtNight();

        Doctor sb = new Studentb();
        sb.workAtDay();
        sb.workAtNight();

        Doctor sc = Test.getDoctorInstance();
        sc.workAtDay();
        sc.workAtNight();
    }
    private static Doctor getDoctorInstance(){
        return new Doctor() {
            @Override
            public void workAtNight() {
                System.out.println("导师晚上指导女学生");
            }
        };
    }
}
```

#### 写法3

```java
package com.wangy325.demo02.anonymousinner;

public class Test {
    public static void main(String[] args) {
        Doctor sa = new Studenta();
        sa.workAtDay();
        sa.workAtNight();

        Doctor sb = new Studentb();
        sb.workAtDay();
        sb.workAtNight();

        Test.getDoctorInstance();
    }
    private static void getDoctorInstance(){
         new Doctor() {
            @Override
            public void workAtNight() {
                System.out.println("导师晚上指导女学生");
            }
        }.workAtNight();
    }
}
```


```java
///:~
//        白天搞研究
//        学生a晚上看美剧
//        白天搞研究
//        学生b晚上搞事情
//        白天搞研究
//        导师晚上指导女学生
```

[内部类的更加详细介绍](http://www.cnblogs.com/dolphin0520/p/3811445.html)

至于内部内中的深层原理，上篇介绍中有讲到，有空再深入研究

## 10.2 设计模式

**什么是设计模式？**

1. 基本定义：设计模式（Design pattern）是一套被反复使用的代码设计经验的总结。使用设计模式的目的是为了可重用代码、让代码更容易被他人理解。设计模式是是软件工程的基石脉络，如大厦的结构一样
2. Design pattern的四大要素：模式名称（Name），问题（Question），解决方案（Solution），效果（Efftive）。

> java 语言有23种设计模式

### 10.2.1单例设计模式

Java中单例模式是一种常见的设计模式，单例模式的写法有好几种，这里主要介绍两种：懒汉式单例、饿汉式单例

> 在java语言中，单例带来了两大好处：
>
> 1.对于频繁使用的对象，可以省略创建对象所花费的时间，这对于那些重量级的对象而言，是非常可观的一笔系统开销
>
> 2.由于new操作的次数减少，因而对系统内存的使用频率也会降低，这将减轻GC压力，缩短GC停顿时间
>
> [来源](https://www.cnblogs.com/zhengyu940115/p/6652465.html)

#### 10.2.1.1 特点

1. 单例类只能有**一个实例**
2. 私有（private）构造方法
3. 单例类必须**自己创建自己的唯一实例**
4. 单例类必须**给所有其他对象提供**这一实例

#### 10.2.1.2 常用的单例模式写法

1. **懒汉式单例：在第一次调用的时候实例化自己；**

   1. 懒汉式1：线程不安全

      ```java
      public class Singleton {  
          private Singleton() {}//私有构造行数，避免类在外部被实例化
          private static Singleton single=null;  
          //静态工厂方法
          public static Singleton getInstance() {  
               if (single == null) {    
                   single = new Singleton();  
               }    
              return single;  
          } 
      }
      ```

   2. 懒汉式2：在getInstance方法上加同步，使得线程安全

      ```java
      public class Singleton {  
          private Singleton() {}//私有构造行数，避免类在外部被实例化
          private static Singleton single=null;  
          //静态工厂方法 加上了同步，使得线程安全
          public static synchronized Singleton getInstance() {  
               if (single == null) {    
                   single = new Singleton();  
               }    
              return single;  
          }
      }
      ```

   3. 懒汉式3：双重检查锁定，线程安全

      ```java
      public class Singleton {  
          private Singleton() {}//私有构造行数，避免类在外部被实例化
        	// volatile 关键字
          private volatile static Singleton single=null;
        
      	public static Singleton getInstance() {  
              if (single == null) {    
                  synchronized (Singleton.class) {//同步锁住，使得线程安全  
                     if (single == null) {    
                        single = new Singleton();   
                     }    
                  }    
              }
              return singleton;   
      	}
      }
      ```

   4. 懒汉式4：静态内部类，线程安全。因为内部在第一次调用的时候，类只会被加载一次

      ```java
      public class Singleton {
         // 静态内部类
          private static class LazyHolder {
            // 静态内部类的静态常量
             private static final Singleton INSTANCE = new Singleton();   
          } 
          private Singleton (){}//私有构造函数
          public static final Singleton getInstance() {    
             return LazyHolder.INSTANCE;    
          }    
      }
      ```

2. **饿汉式单例：在类初始化时，已经自行实例化**   

   ```java
   public class Singleton1 {  
       private Singleton1() {}//私有构造函数 
       private static final Singleton1 single = new Singleton1(); 
       //静态工厂方法   
       public static Singleton1 getInstance() {  
           return single;  
       }  
   }
   ```

#### 10.2.1.3 单例模式的简单实例

```java
package com.wangy325.demo02.singleton;

public class Person {
    private String name;
    private int age;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
// 将上述类修改为单例之后
package com.wangy325.demo02.singleton;

public class SinglePerson {
    private String name;
    private int age;

    // 将 SinglePerson 类修改为一个懒汉式单例
    private static SinglePerson singlePerson = null;
    private SinglePerson(){}
    public static SinglePerson getSinglePerson(){
        if(singlePerson == null){
            synchronized (SinglePerson.class){
                if (singlePerson == null){
                    singlePerson = new SinglePerson();
                }
            }
        }
        return singlePerson;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
// 测试结果
package com.wangy325.demo02.singleton;

public class Test {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.setName("david");
        p1.setAge(18);
        Person p2 = new Person();
        p2.setName("lucy");
        p2.setAge(16);

        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println(p1.hashCode() == p2.hashCode());

        //***************************//
        System.out.println("*******************");
        SinglePerson p3 = SinglePerson.getSinglePerson();
        p3.setName("david");
        p3.setAge(18);
        SinglePerson p4 = SinglePerson.getSinglePerson();
        p4.setName("lucy");
        p4.setAge(16);

        System.out.println(p3.toString());
        System.out.println(p4.toString());
        System.out.println(p3.hashCode() == p4.hashCode());

    }
}
///:~
// Person{name='david', age=18}
// Person{name='lucy', age=16}
// false
// *******************
// Person{name='lucy', age=16}
// Person{name='lucy', age=16}
// true
```

更详细的单例模式介绍

[单例设计模式](http://blog.csdn.net/qq_32736689/article/details/51082418)

[单例设计模式的几种实现方式](https://www.cnblogs.com/zhengyu940115/p/6652465.html)

### 10.2.2简单工厂设计模式

​	简单工厂模式（Simple Factory Pattern）属于类的创新型模式，又叫静态工厂方法模式（Static FactoryMethod Pattern），是**通过专门定义一个类来负责创建其他类的实例**，被**创建的实例通常都具有共同的父类（或者父接口）**。

简单工厂模式的  UML（Unified Modeling Language） 图：

![](http://ojx4zwltq.bkt.clouddn.com/17-2-8/49677992-file_1486539778651_9dec.jpg)

1. 抽象产品（Product）角色：简单工厂模式所创建的是所有对象的父类，注意，这里的父类可以是接口也可以是抽象类，它负责描述所有实例所共有的公共接口。
2. 具体产品（Concrete Product）角色：简单工厂所创建的具体实例对象，这些具体的产品往往都拥有共同的父类。
3. 工厂角色（Creator）：这是简单工厂模式的核心，由它负责创建所有的类的内部逻辑。当然工厂类必须能够被外界调用，创建所需要的产品对象。



代码示例：

代码：

1.  抽象产品角色：宠物

    ```java
    /**
    * 抽象产品角色（Product）
    * 负责描述所有实例的公共接口
    */
    public interface Pet {
       public void eat();
    }
    ```
```java

2. 具体产品角色：

   1. 猫
      public class Cat implements Pet {
        
      	protected Cat() {
      	}
        
          @Override
          public void eat() {
              System.out.println("猫咪正在吃东西...");
          }

      }
```

2.    狗

      ```java
      public class Dog implements Pet {
        
      	protected Dog() {
      	}
        
          @Override
          public void eat() {
              System.out.println("狗狗正在吃东西");
          }

      }
      ```

3. 工厂角色：

      ```java
            public class PetFactory {
                public static Pet createPet(String name){
                    if("cat".equals(name)){
                        return new Cat();
                    }else if("dog".equals(name)){
                        return new Dog();
                    }else{
                        return null;
                    }
                }
            }
      ```

4. 测试类：

      ```java
            public class Client {
                public static void main(String[] args) {
                    Pet cat = PetFactory.createPet("cat");
                    cat.eat();
                    Dog dog = PetFactory.createPet("dog");
                    dog.eat();
                }
            }
      ```

