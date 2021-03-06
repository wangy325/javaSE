# Generic

# 1. 概述

泛型在java中有很重要的地位，在面向对象编程及各种设计模式中有非常广泛的应用

什么是泛型？为什么要使用泛型？

> **泛型，即“参数化类型”**
>
> 一提到参数，最熟悉的就是定义方法时有形参，然后调用此方法时传递实参。那么参数化类型怎么理解呢？顾名思义，就是将类型由原来的**具体的类型参数化**，类似于方法中的变量参数，此时类型也定义成参数形式（可以称之为类型形参），然后在使用/调用时传入具体的类型（类型实参）
>
> 泛型的本质是为了参数化类型（在不创建新的类型的情况下，通过泛型指定的不同类型来控制形参具体限制的类型）
>
> 也就是说在泛型使用过程中，操作的数据类型被指定为一个参数，这种参数类型可以用在类、接口和方法中，分别被称为泛型类、泛型接口、泛型方法

# 2. 一个栗子

一个被举了无数次的例子：

```java
List arrayList = new ArrayList();
arrayList.add("aaaa");
arrayList.add(100);

for(int i = 0; i< arrayList.size();i++){
    String item = (String)arrayList.get(i);
}
// 实际上集合里可以添加多种类型的数据, 但是实际上不建议如此做
// 上述代码在eclipse 编译过程中就会提示警告信息:
// --List is a raw type. References to generic type List<E> should be parameterized
// 而且如果 List 中数据类型 "多种多样" 的, 会给后续对集合元素的操作带来很多麻烦
// 这就是 for..代码块中要说明的事实
// 添加泛型, 实际上就是在程序编译过程中进行类型约束及类型检查
```

毫无疑问，程序的运行结果会以崩溃结束：

```
java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String
```

ArrayList可以存放任意类型，例子中添加了一个String类型，添加了一个Integer类型，再使用时都以String的方式使用，因此程序崩溃了。为了解决类似这样的问题（在编译阶段就可以解决），泛型应运而生

我们将第一行声明初始化list的代码更改一下，编译器会在编译阶段就能够帮我们发现类似这样的问题

```java
List<String> arrayList = new ArrayList<String>();
...
//arrayList.add(100); 在编译阶段，编译器就会报错
```

# 3. 特性

***泛型只在编译阶段有效***

看下面的代码：

```java
List<String> strList = new ArrayList<String>();
List<Integer> intList = new ArrayList<Integer>();

Class strList = stringArrayList.getClass();
Class intList = integerArrayList.getClass();

if(classStringArrayList.equals(classIntegerArrayList)){
     System.out.println("泛型测试,类型相同");
}
输出结果：泛型测试: 类型相同。
```

测试发现，在编译之后程序会**去泛型化**

也就是说Java中的泛型，只在编译阶段有效。在编译过程中，正确检验泛型结果后，会将泛型的相关信息擦除，并且在对象进入和离开方法的边界处添加类型检查和类型转换的方法。也就是说，**泛型信息不会进入到运行时阶段**

**对此总结成一句话：泛型类型在逻辑上看以看成是多个不同的类型，实际上都是相同的基本类型**



# 4. 泛型的使用

泛型有三种使用方式，分别为：泛型类、泛型接口、泛型方法

## 4.1 泛型类

泛型类型用于类的定义中，被称为泛型类。通过泛型可以完成对一组类的操作对外开放相同的接口。最典型的就是各种容器类，如：List、Set、Map。

泛型类的最基本写法（这么看可能会有点晕，会在下面的例子中详解）：

```
class 类名称 <泛型标识：可以随便写任意标识号，标识指定的泛型的类型>{
  private 泛型标识 /*（成员变量类型）*/ var; 
  .....

  }
}
```

一个最普通的泛型类：

```java
//此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型
//在实例化泛型类时，必须指定T的具体类型
public class Generic<T>{ 
    //key这个成员变量的类型为T,T的类型由外部指定  
    private T key;
	//泛型构造方法形参key的类型也为T，T的类型由外部指定
    public Generic(T key) { 
        this.key = key;
    }

    public T getKey(){ //泛型方法getKey的返回值类型为T，T的类型由外部指定
        return key;
    }
}
```

```java
//泛型的类型参数只能是类类型（包括自定义类），不能是简单类型
//传入的实参类型需与泛型的类型参数类型相同，即为Integer.
Generic<Integer> genericInteger = new Generic<Integer>(12);

//传入的实参类型需与泛型的类型参数类型相同，即为String.
Generic<String> genericString = new Generic<String>("aa");
System.out.println("key is "+genericInteger.getKey());
System.out.println("key is "+genericString.getKey());
```

```
key is 12
key is aa
```

定义的泛型类，就一定要传入泛型类型实参么？

>  在使用泛型的时候如果传入泛型实参，则会根据传入的泛型实参做相应的限制，此时泛型才会起到本应起到的限制作用
>
> 如果不传入泛型类型实参的话，在泛型类中使用泛型的方法或成员变量定义的类型**可以为任何的类型**

看一个例子：

```java
Generic generic = new Generic("111111");
Generic generic1 = new Generic(4444);
Generic generic2 = new Generic(55.55);
Generic generic3 = new Generic(false);

System.out.println("泛型测试key is " + generic.getKey());
System.out.println("泛型测试key is " + generic1.getKey());
System.out.println("泛型测试key is " + generic2.getKey());
System.out.println("泛型测试key is " + generic3.getKey());
```

```java
泛型测试: key is 111111
泛型测试: key is 4444
泛型测试: key is 55.55
泛型测试: key is false
```

> 注意：
>
> - 泛型的类型参数只能是类类型，不能是简单类型
>
> - 不能对确切的泛型类型使用`instanceof`操作。下面的操作是非法的，编译时会出错
>
>   ```
>   if(ex_num instanceof Generic<Number>){   
>   } 
>   ```

## 4.2 泛型接口

泛型接口与泛型类的定义及使用基本相同

泛型接口常被用在各种类的生产器中，可以看一个例子：

```java
//定义一个泛型接口
public interface Generator<T> {
    public T next();
}
```

当实现泛型接口的类，未传入泛型实参时：

```java
/**
 * 未传入泛型实参时，与泛型类的定义相同，在声明类的时候，需将泛型的声明也一起加到类中
 * 即：class FruitGenerator<T> implements Generator<T>{
 * 如果不声明泛型，如：class FruitGenerator implements Generator<T>，编译器会报错："Unknown class"
 */
class FruitGenerator<T> implements Generator<T>{
    @Override
    public T next() {
        return null;
    }
}
```

当实现泛型接口的类，传入泛型实参时：

```java
/**
 * 传入泛型实参时：
 * 定义一个生产器实现这个接口,虽然我们只创建了一个泛型接口Generator<T>
 * 但是我们可以为T传入无数个实参，形成无数种类型的Generator接口。
 * 在实现类实现泛型接口时，如已将泛型类型传入实参类型，则所有使用泛型的地方都要替换成传入的实参类型
 * 即：Generator<T>，public T next();中的的T都要替换成传入的String类型。
 */
public class FruitGenerator implements Generator<String> {

    private String[] fruits = new String[]{"Apple", "Banana", "Pear"};

    @Override
    public String next() {
        Random rand = new Random();
        return fruits[rand.nextInt(3)];
    }
}
```



## 4.3 泛型方法

在java中，泛型类的定义非常简单，但是泛型方法就比较复杂了

> 尤其是我们见到的大多数泛型类中的成员方法也都使用了泛型，有的甚至泛型类中也包含着泛型方法，这样在初学者中非常容易将泛型方法理解错了。

**泛型类，是在实例化类的时候指明泛型的具体类型**

**泛型方法，是在调用方法的时候指明泛型的具体类型** 

```java
/**
 * 泛型方法的基本介绍
 * @param t Class 传入的泛型实参
 * @return T 返回值为T类型
 * 说明：
 *     1）public 与 返回值中间<T>非常重要，可以理解为声明此方法为泛型方法
 *     2）只有声明了<T>的方法才是泛型方法，泛型类中的使用了泛型的成员方法并不是泛型方法
 *     3）<T>表明该方法将使用泛型类型T，此时才可以在方法中使用泛型类型T
 *     4）与泛型类的定义一样，此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型
 */
public <T> T genericMethod(Class<T> tClass)throws InstantiationException ,
  IllegalAccessException{
        T instance = tClass.newInstance();
        return instance;
}
```

```
Object obj = genericMethod(Class.forName("com.test.test"));
```

### 4.5.1 泛型方法的基本用法

光看上面的例子有的同学可能依然会非常迷糊，我们再通过一个例子，把我泛型方法再总结一下。

```java
public class GenericTest {
   //这个类是个泛型类，在上面已经介绍过
   public class Generic<T>{     
        private T key;

        public Generic(T key) {
            this.key = key;
        }

        //我想说的其实是这个，虽然在方法中使用了泛型，但是这并不是一个泛型方法。
        //这只是类中一个普通的成员方法，只不过他的返回值是在声明泛型类已经声明过的泛型。
        //所以在这个方法中才可以继续使用 T 这个泛型。
        public T getKey(){
            return key;
        }

        /**
         * 这个方法显然是有问题的，在编译器会给我们提示这样的错误信息"cannot reslove symbol E"
         * 因为在类的声明中并未声明泛型E，所以在使用E做形参和返回值类型时，编译器会无法识别。
        public E setKey(E key){
             this.key = keu
        }
        */
    }

    /** 
     * 这才是一个真正的泛型方法。
     * 首先在public与返回值之间的<T>必不可少，这表明这是一个泛型方法，并且声明了一个泛型T
     * 这个T可以出现在这个泛型方法的任意位置.
     * 泛型的数量也可以为任意多个 
     *    如：public <T,K> K showKeyName(Generic<T> container){
     *        ...
     *        }
     */
    public <T> T showKeyName(Generic<T> container){
        System.out.println("container key :" + container.getKey());
        //当然这个例子举的不太合适，只是为了说明泛型方法的特性。
        T test = container.getKey();
        return test;
    }

    //这也不是一个泛型方法，这就是一个普通的方法，只是使用了Generic<Number>这个泛型类做形参而已。
    public void showKeyValue1(Generic<Number> obj){
        System.out.println("泛型测试key value is " + obj.getKey());
    }

    //这也不是一个泛型方法，这也是一个普通的方法，只不过使用了泛型通配符?
    //同时这也印证了泛型通配符章节所描述的，?是一种类型实参，可以看做为Number等所有类的父类
    public void showKeyValue2(Generic<?> obj){
        System.out.println("泛型测试","key value is " + obj.getKey());
    }

     /**
     * 这个方法是有问题的，编译器会为我们提示错误信息："UnKnown class 'E' "
     * 虽然我们声明了<T>,也表明了这是一个可以处理泛型的类型的泛型方法。
     * 但是只声明了泛型类型T，并未声明泛型类型E，因此编译器并不知道该如何处理E这个类型。
    public <T> T showKeyName(Generic<E> container){
        ...
    }  
    */

    /**
     * 这个方法也是有问题的，编译器会为我们提示错误信息："UnKnown class 'T' "
     * 对于编译器来说T这个类型并未项目中声明过，因此编译也不知道该如何编译这个类。
     * 所以这也不是一个正确的泛型方法声明。
    public void showkey(T genericObj){

    }
    */
}
```

### 4.5.2 类中的泛型方法

当然这并不是泛型方法的全部，泛型方法可以出现杂任何地方和任何场景中使用。但是有一种情况是非常特殊的，当泛型方法出现在泛型类中时，我们再通过一个例子看一下

```java
public class GenericFruit {
    class Fruit{
        @Override
        public String toString() {
            return "fruit";
        }
    }

    class Apple extends Fruit{
        @Override
        public String toString() {
            return "apple";
        }
    }

    class Person{
        @Override
        public String toString() {
            return "Person";
        }
    }

    class GenerateTest<T>{
        public void show_1(T t){
            System.out.println(t.toString());
        }

        //在泛型类中声明了一个泛型方法，使用泛型E，这种泛型E可以为任意类型。可以类型与T相同，也可以不同。
        //由于泛型方法在声明的时候会声明泛型<E>，因此即使在泛型类中并未声明泛型，编译器也能够正确识别泛型方法中识别的泛型。
        public <E> void show_3(E t){
            System.out.println(t.toString());
        }

        //在泛型类中声明了一个泛型方法，使用泛型T，注意这个T是一种全新的类型，可以与泛型类中声明的T不是同一种类型。
        public <T> void show_2(T t){
            System.out.println(t.toString());
        }
    }

    public static void main(String[] args) {
        Apple apple = new Apple();
        Person person = new Person();

        GenerateTest<Fruit> generateTest = new GenerateTest<Fruit>();
        //apple是Fruit的子类，所以这里可以
        generateTest.show_1(apple);
        //编译器会报错，因为泛型类型实参指定的是Fruit，而传入的实参类是Person
        //generateTest.show_1(person);

        //使用这两个方法都可以成功
        generateTest.show_2(apple);
        generateTest.show_2(person);

        //使用这两个方法也都可以成功
        generateTest.show_3(apple);
        generateTest.show_3(person);
    }
}
```

### 4.5.3 泛型方法与可变参数

再看一个泛型方法和可变参数的例子：

```
public <T> void printMsg( T... args){
    for(T t : args){
        System.out.println("泛型测试t is " + t);
    }
}
```

```
printMsg("111",222,"aaaa","2323.4",55.55);
```

### 4.5.4 静态方法与泛型

静态方法有一种情况需要注意一下，那就是在类中的静态方法使用泛型：**静态方法无法访问类上定义的泛型；如果静态方法操作的引用数据类型不确定的时候，必须要将泛型定义在方法上。**

即：**如果静态方法要使用泛型的话，必须将静态方法也定义成泛型方法** 。

```java
public class StaticGenerator<T> {
    ....
    ....
    /**
     * 如果在类中定义使用泛型的静态方法，需要添加额外的泛型声明（将这个方法定义成泛型方法）
     * 即使静态方法要使用泛型类中已经声明过的泛型也不可以。
     * 如：public static void show(T t){..},此时编译器会提示错误信息：
          "StaticGenerator cannot be refrenced from static context"
     */
    public static <T> void show(T t){

    }
}
```

### 4.5.5 泛型方法总结

泛型方法能使方法独立于类而产生变化，以下是一个基本的指导原则：

> 无论何时，如果你能做到，你就该尽量使用泛型方法。也就是说，如果使用泛型方法将整个类泛型化，那么就应该使用泛型方法。另外对于一个static的方法而已，无法访问泛型类型的参数。所以如果static方法要使用泛型能力，就必须使其成为泛型方法。

## 4.4泛型通配符

我们知道`Ingeter`是`Number`的一个子类，同时在特性章节中我们也验证过`Generic<Ingeter>`与`Generic<Number>`实际上是相同的一种基本类型。那么问题来了，在使用`Generic<Number>`作为形参的方法中，能否使用`Generic<Ingeter>`的实例传入呢？在逻辑上类似于`Generic<Number>`和`Generic<Ingeter>`是否可以看成具有父子关系的泛型类型呢？

为了弄清楚这个问题，我们使用`Generic<T>`这个泛型类继续看下面的例子：

```
public void showKeyValue1(Generic<Number> obj){
    System.out.println("泛型测试:key value is " + obj.getKey());
}
```

```java
Generic<Integer> gInteger = new Generic<Integer>(123);
Generic<Number> gNumber = new Generic<Number>(456);

showKeyValue(gNumber);

// showKeyValue这个方法编译器会为我们报错：Generic<java.lang.Integer> 
// cannot be applied to Generic<java.lang.Number>
// showKeyValue(gInteger);
```

通过提示信息我们可以看到`Generic<Integer>`不能被看作为`Generic<Number>`的子类。由此可以看出:**同一种泛型可以对应多个版本（因为参数类型是不确定的），不同版本的泛型类实例是不兼容的**

回到上面的例子，如何解决上面的问题？总不能为了定义一个新的方法来处理`Generic<Integer>`类型的类，这显然与java中的多态理念相违背。因此我们需要一个在逻辑上可以表示**同时**是`Generic<Integer>`和`Generic<Number>`父类的引用类型。由此类型通配符应运而生。

我们可以将上面的方法改一下：

```
public void showKeyValue1(Generic<?> obj){
    System.out.println("泛型测试key value is " + obj.getKey());
}
```

类型通配符一般是使用？代替具体的类型实参，注意了，**此处’？’是类型实参，而不是类型形参** 

直白点讲，此处的`？`和Number、String、Integer一样都是一种**实际的类型**，可以把`？`看成所有类型的父类

可以解决当具体类型不确定的时候，这个通配符就是` ?  `

当操作类型时，不需要使用类型的具体功能时，只使用Object类中的功能。那么可以用 ? 通配符来表未知类型

## 4.5 泛型上下边界(了解)

### **1.上界< ? extends Class>**

在使用泛型的时候，我们还可以为传入的泛型类型实参进行上下边界的限制，如：类型实参只准传入某种类型的父类或某种类型的子类。

- 为泛型添加上边界，即传入的类型实参必须是指定类型的子类型


```
public void showKeyValue1(Generic<? extends Number> obj){
    System.out.println("泛型测试","key value is " + obj.getKey());
}
```

```
Generic<String> generic1 = new Generic<String>("11111");
Generic<Integer> generic2 = new Generic<Integer>(2222);
Generic<Float> generic3 = new Generic<Float>(2.4f);
Generic<Double> generic4 = new Generic<Double>(2.56);

//这一行代码编译器会提示错误，因为String类型并不是Number类型的子类
//showKeyValue1(generic1);

showKeyValue1(generic2);
showKeyValue1(generic3);
showKeyValue1(generic4);
```

如果我们把泛型类的定义也改一下:

```
public class Generic<T extends Number>{
    private T key;

    public Generic(T key) {
        this.key = key;
    }

    public T getKey(){
        return key;
    }
}
```

```
//这一行代码也会报错，因为String不是Number的子类
Generic<String> generic1 = new Generic<String>("11111");
```



### **2.下界< ? super Class>**

```
class Fruit{}
class Apple extends Fruit{}
class Apple1 extends Apple{}
class Orange extends Fruit{}

public class Test<T>{

    public static void main(String[] args) {
        List<? super Apple> list = new ArrayList<>();
        list.add(new Apple());
        list.add(new Apple1());
        //list.add(new Fruit());

        Object apple = list.get(0);
    }
}
```

这里可以看到，list.add(new Fruit())这句不能编译成功，这是因为，List< ? super Apple>表示“具有Apple的父类的列表”。但是为什么add(new Fruit())不能成功呢？正是因为？代表Apple的父类，但是编译器不知道你要添加哪种Apple的父类，因此不能安全地添加。 
对于super，get返回的是Object，因为编译器不能确定列表中的是Apple的哪个子类，所以只能返回Object。 
**有人不能理解这里， 重新再解释一下：**

1. List < ? super Apple>， 代表容器内存放的是Apple的所有父类，所以有多态和上转型，这个容器时可以接受所有Apple父类的子类的。（多态的定义：父类可以接受子类型对象）Apple和Apple1都直接或间接继承了Fruit，所以Apple和Apple1是能够加入List < ? super Apple>这个容器的。
2. list.add(new Fruit())不能添加，正是因为第1点解释的，容器内存放的是Apple的**所有父类**，注意 **所有** 这个词，正是因为能存放所有，Apple的父类可能有Fruit1， Fruit2， Fruit3 ， 所以编译器根本不能识别你要存放哪个Apple的父类，因为这不能保证类型安全的原则。这从最后的Object apple = list.get(0)可以看出。

# 5. 最后

上面的例子主要是为了阐述泛型中的一些思想而简单举出的，并不一定有着实际的可用性。另外，一提到泛型，相信大家用到最多的就是在集合中，其实，在实际的编程过程中，自己可以使用泛型去简化开发，且能很好的保证代码质量。