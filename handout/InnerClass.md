内部类
===

## 12.1内部类

内部类是指在一个外部类的内部再定义一个类。类名不需要和文件名相同。

内部类可以是静态static的，也可用public，default，protected和private修饰。（而外部顶级类即类名和文件名相同的只能使用public和default）。

> 注意：内部类是一个编译时的概念，一旦编译成功，就会成为完全不同的两类。对于一个名为Outer的外部类和其内部定义的名为Inner的内部类。编译完成后出现Outer.class和Outer$Inner.class两类。所以内部类的成员变量/方法名可以和外部类的相同。

### 12.1.1成员内部类

​	成员内部类，就是作为外部类的成员，可以直接使用外部类的所有成员属性和方法，即使是private的。同时外部类要访问内部类的所有成员变量/方法，则需要通过内部类的对象来获取。

      要注意的是，成员内部类不能含有static的变量和方法。因为成员内部类需要先创建了外部类，才能创建它自己的。

      在成员内部类要引用外部类对象时，使用Outer.this来表示外部类对象；

      而需要创建内部类对象时，可以使用Outer.Inner  inner = outerobj.new Inner();

```java
public class Outer { 
    public class Inner {//成员内部类
        public void print(String str) { 
            System.out.println(str); 
        } 
    } 
}
```

```java
    public static void main(String[] args) { 
        Outer outer = new Outer(); 
        Outer.Inner inner = outer.new Inner(); //创建成员内部类对象
        inner.print("Outer.new"); 
    } 
```

### 12.1.2静态内部类（嵌套内部类）

​	静态内部类(嵌套内部类)，就是修饰为static的内部类。声明为static的内部类，不需要内部类对象和外部类对象之间的联系，就是说我们可以直接引用Outer.Inner，即不需要创建外部类对象，也不需要创建内部类。

      静态内部类和普通的内部类还有一个区别：普通内部类不能有static数据和static属性，也不能包含嵌套类(静态内)，但静态内部类可以。而静态内部类不能声明为private，一般声明为public，方便调用。	

### 12.1.3匿名内部类

有时候我为了免去给内部类命名，便倾向于使用匿名内部类，因为它没有名字。

匿名内部类是不能加访问修饰符的。**要注意的是，new 匿名类，这个类是要先定义的**，看下面例子：

```java
public class Outer { 
    public static void main(String[] args) { 
        Outer outer = new Outer(); 
        Inner inner = outer.getInner("Inner", "gz"); 
        System.out.println(inner.getName()); 
    }
 
    public Inner getInner(final String name, String city) { 
        return new Inner() { 
            private String nameStr = name; 
 
            public String getName() { 
                return nameStr; 
            } 
        }; 
    }
}
 
//注释后，编译时提示类Inner找不到 
/* interface Inner { 
    String getName(); 
} */ 
```

> 注意：在这个例子，留意外部类的方法的形参，**当所在的方法的形参需要被内部类里面使用时，该形参必须为final**。因为，为了避免引用值发生改变，例如被外部类的方法修改等，而导致内部类得到的值不一致，于是用final来让该引用不可改变。

## 12.2设计模式

**什么是设计模式？**

1. 基本定义：设计模式（Design pattern）是一套被反复使用的代码设计经验的总结。使用设计模式的目的是为了可重用代码、让代码更容易被他人理解。设计模式是是软件工程的基石脉络，如大厦的结构一样。
2. Design pattern的四大要素：模式名称（Name），问题（Question），解决方案（Solution），效果（Efftive）。

> java 语言有23种设计模式

### 12.2.1单例设计模式

Java中单例模式是一种常见的设计模式，单例模式的写法有好几种，这里主要介绍两种：懒汉式单例、饿汉式单例。

#### 12.2.1.1 特点

1. 单例类只能有一个实例。
2. 私有构造方法
3. 单例类必须自己创建自己的唯一实例。
4. 单例类必须给所有其他对象提供这一实例。

#### 12.2.1.2 常用的单例模式写法

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
          private static Singleton single=null;
        
      	public static Singleton getInstance() {  
              if (singleton == null) {    
                  synchronized (Singleton.class) {//同步锁住，使得线程安全  
                     if (singleton == null) {    
                        singleton = new Singleton();   
                     }    
                  }    
              }
              return singleton;   
      	}
      }
      ```

   4. 懒汉式4：静态内部类，线程安全。因为内部在第一次调用的时候，类只会被加载一次。

      ```java
      public class Singleton {
          private static class LazyHolder {
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

### 12.2.2简单工厂设计模式

​	简单工厂模式（Simple Factory Pattern）属于类的创新型模式，又叫静态工厂方法模式（Static FactoryMethod Pattern），是**通过专门定义一个类来负责创建其他类的实例**，被**创建的实例通常都具有共同的父类（或者父接口）**。

简单工厂模式的  UML 图：

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

