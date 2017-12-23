# 第19天 异常

## 19.1 异常的概念

异常是程序在运行期发生的不正常的事件，它会打断指令的正常执行流程。

设计良好的程序应该在异常发生时提供处理这些不正常事件的方法，使程序不会因为异常的发生而阻断或产生不可预见的结果。

Java语言使用异常处理机制为程序提供了异常处理的能力。

## 19.2 异常的分类

Java程序运行过程中所发生的异常事件从严重性可分为两类：

1. 错误(Error)：JVM系统内部错误或资源耗尽等严重情况－属于JVM需要负担的责任这一类异常事件无法恢复或不可能捕获，将导致应用程序中断。
2. 异常(Exception)：其它因编程错误或偶然的外在因素导致的一般性问题。这类异常得到恰当的处理时，程序有机会恢复至正常运行状况。

> 程序员通常只能处理异常(Exception)，而对错误(Error)无能为力。

### 19.2.1 Exception 

**从编程角度划分：**

1. 非受检(unchecked)异常(运行时异常 RuntimeException)：编译器不要求强制处置的异常。一般是指编程时的逻辑错误。是程序员应该积极避免其出现的异常java.lang.RuntimeException及它的子类都是非受检异常：
   * 错误的类型转换：java.lang.ClassCastException
   * 数组下标越界：java.lang.ArrayIndexOutOfBoundsException
   * 空指针访问：java.lang.NullPointerException
   * 算术异常(除0溢出)：java.lang.ArithmeticException
2. 受检(checked)异常：编译器要求必须处置的异常。指的是程序在运行时由于外界因素造成的一般性异常。
   * 没有找到指定名称的类：java.lang.ClassNotFoundException 
   * 访问不存在的文件：java.io.FileNotFoundException 
   * 操作文件时发生的异常：java.io.IOException
   * 操作数据库时发生的异常：java.sql.SQLException

## 19.3 异常的处理方式

### 19.3.1 捕获异常：try..catch..finally语句

```java
try{

  	......	//可能产生异常的代码 
	
}catch( ExceptionName1 e ){

	......	//异常的处理代码 

}catch( ExceptionName2 e ){

    ...... 	 //异常的处理代码 

}finally{

    ......	 //无论如何都会执行的语句 (finally 不是必要的语句)(除非中try-catch中虚拟机被关闭该finally才不会被执行)

}
```

说明：

1. try 代码段包含的是可能产生异常的代码 

2. try 代码段后跟一个或多个catch代码段。(catch代码段可以跟一个finally代码段)

3. 在jdk1.7之前每个catch代码段只声明一种其能处理的特定类型的异常，并提供处理的方法。 Jdk1.7之后，一个catch代码可以可以声明多个（多个异常之间不能有继承关系）能处理的特定异常的类型，多个类型之间用”|”隔开

   例如：

   ```java
   catch( ExceptionName1 | ExceptionName1 e){

     	......	//异常的处理代码 

   }
   ```


4. **当异常发生时，程序会中止当前的流程去执行相应的catch代码段**。 

5. 写catch代码时，先捕获的异常的范围不能大于后捕获的异常的范围。

   > `catch` 代码块的执行顺序,  一般来讲, 前面的 catch 代码块捕获的异常一定要是后面的 catch 代码块的子类

6. finally段的代码无论是否发生异常都执行。finally唯一不执行的情况是：**try-catch中JVN虚拟机停止**。

### 19.3.2 抛出异常：throws和throw

#### 19.3.2.1 throws

在定义一个方法的时候可以使用throws关键字声明，使用throws声明的方法表示**此方法不处理异常**，而交给方法的调用出进行处理。

Throws使用格式：

```java
public 返回值类型 方法名(参数列表) throws 异常类,异常类{
	// 这里可以写要抛出的异常
  	// 用 throw 关键字
}
```

> 注意：此时抛出的是异常类型，并且抛出的异常类型是紧跟在方法名之后。

#### 19.3.2.2 throw

异常不仅仅虚拟机可以抛，我们自己也可以抛。我们可以在代码中使用throw关键字来抛出某个具体的异常对象。很多情况下我们会手动抛出运行时异常。

throw使用格式：

例如：

```java
throw new RuntimeException("程序出现了异常");
```

## 19.4 自定义异常类

### 19.4.1 创建自定义异常类

编程过程中会出现各种问题，比如用户授权问题，用户账户金额不够等等，系统提供的异常不足以描述这些问题，因此需要自定义异常 

> 自定义异常通常继承自Exception或者Exception的子异常 

### 自定义异常的编程步骤 

Step1：编写异常类从异常结构中继承合适的父类 
Step2：添加构造方法 
Step3：在方法执行过程中，如何满足异常抛出条件，抛出该异常 
Step 4：调用者处理该自定义的异常

```java
public class MyException extends Exception {
  // 直接调用 Exception 的构造方法;
    public MyException() {        super();    } 

    public MyException(String msg) {        super(msg);    }

    public MyException(Throwable cause) {       super(cause);    }

    public MyException(String msg, Throwable cause) {     super(msg, cause);    }

}
```

### 19.4.2 使用自定义异常类

```java
public String[] createArray(int length) throws MyException {
    if (length < 0) {    
        throw new MyException("数组长度小于0,不合法");
    }
    return new String[length]; 
} 
```

# 作业：

1. 从控制台输入 5个整数，放入一整型数组，然后打印输出，要求：输入数据 为整数，要捕获Integer.parseInt()产生的异常，直至用户能够输入5个整数。（用户输入的不是整数则捕获异常，并提示）

2. 自定义异常类型 TrigonometricFunctionException extends Exception。并重写相应的构造器。

   再写一个方法void sanjiao(int a,int b,int c)，判断三个参数作为三角形的边是否能构成一个三角形， 如果不能则抛出异常 TrigonometricFunctionException ，显示异常信息"a,b,c不能构成三角 形"，如果可以构成则显示三角形三个边长，在main方法中得到命令行输入的三个整数， 调用此方法，并捕获异常。