# Servlet (容器)

Sun（Oracle）公司制定的一种用来**扩展Web服务器功能的组件规范** 

## 扩展web服务器功能

 在BS(Browser Server)架构中，早期的Web服务器只能处理静态资源的请求，**也就是说无法根据请求进行计算后再生成相应的HTML内容**

servlet可以处理动态资源的请求。web服务器收到请求之后，可以调用servlet来动态处理、生成动态页面并响应结果

## 组件规范

组件规范是依靠一套API来实现的，也就是说开发中只要基于Sun公司提供的这套API，按照一定的规则来编写程序，那么就可以实现针对Web服务器的功能扩展

组件只是对部分功能的一个实现，不能单独运行，必须放在一定的环境中才能运行。而这个针对各个组件进行管理、创建、销毁的运行环境称为**Web容器**

这个 Web 容器是`tomcat`

Servlet的作用是处理请求 ，服务器会把接收到的请求交给Servlet来处理，如下图

![](http://otgx4owbp.bkt.clouddn.com/18-1-21/14311982.jpg)

例如客户端发出登录请求，或者输出注册请求，这些请求都应该由Servlet来完成处理

在Servlet中，通常是这样来处理请求的：

* 接收请求数据；

* 处理请求；

* 完成响应；


为啥说 通常是这三个步骤呢？以注册 和 查询功能为例

![](http://otgx4owbp.bkt.clouddn.com/18-1-21/36974319.jpg)

**注意：**

进行JavaWeb服务器端开发时，程序员的主要工作就是编写这些Servlet模块，即 Servlet需要我们自己来编写，且 每个Servlet必须实现`javax.servlet.Servlet`**接口**

如何来编写这些Servlet代码呢？要严格按照要求来写。

实现Servlet**有三种方式：**

* 实现javax.servlet.Servlet接口；
* 继承javax.servlet.GenericServlet类；
* 继承**javax.servlet.http.HttpServlet**类；（重点）

通常我们会去继承HttpServlet类来完成我们的Servlet，前面两种用起来不方便

> 实际上 `HttpServlet` 类继承了`GenericServlet`类，而后者实现了`Servlet`接口

打开JavaEE的API:

![](http://otgx4owbp.bkt.clouddn.com/18-1-21/66842882.jpg)

这三者的关系是**Servlet**是接口**，**GenericServlet是接口的实现类**，**HttpServlet继承于GenericServlet

若实现一个自己的Servlet还是继承于HttpServlet，比较简单

学习Servlet从**javax.servlet.Servlet**接口开始

打开JavaEE API中的Servlet,看方法

![](http://otgx4owbp.bkt.clouddn.com/18-1-21/20904882.jpg)

```java
public interface Servlet {
  	// 初始化
    public void init(ServletConfig config) throws ServletException;
  	//  
    public ServletConfig getServletConfig();
    public void service(ServletRequest req, ServletResponse res)
            throws ServletException, IOException;
    public String getServletInfo();
    public void destroy();
}
```

注:

Servlet中的方法大多数不由我们来调用，而是由Tomcat来调用

并且Servlet的对象也不由我们来创建，由Tomcat来创建

我们需要做的 还是按照自己的业务需求来编写Servlet

到底如何来定义一个Servlet呢？看代码:

```java
public class AServlet implements Servlet{
  @Override
  public void destory(){
    
  }
  @Override
  public ServletConfig getServletConfig(){
    return null;
  }
  @Override
  public String getServletInfo(){
    return null;
  }
  @Override
  public void init(ServletConfig sc) throws ServletException{
    
  }
  @Override
  public void services(ServletRequest request,ServletResponse response)
    throws ServletException,IOException{
    
  }
}
```

> **注：**
>
> **Tomcat**是JavaWeb服务器，Tomcat会调用我们编写的Servlet；若使用了其他的JavaWeb服务器  则会由这个服务器来调用我们编写的Servlet
>
> **也就是说，编写的这些Servlet**功能模块只是整个JavaWeb项目中的一部分，和Tomcat和在一起才是一个完整的JavaWeb项目。
>
> Tomcat是所有的JavaWeb项目中不变的地方，抽象出来了，称为了公用的服务器；而JavaWeb项目中变化的地方，则需要我们根据业务需求来编写Servlet**功能模块**

那到底是如何访问一个Servlet的呢？？？

若是一个网页html，咱们就可以直接通过这个html的网址来访问。但是这个Servlet是一个类，如何通过浏览器来访问呢？如何才能通过浏览器访问一个类Servlet呢？

1. **第一步，给这个Servlet类**指定一个Servlet路径（让Servlet与一个路径绑定在一起)
2. **第二步，浏览器访问Servlet**路径，即可访问这个Servlet类

*具体做法需要在Tomcat服务器的web.xml中进行配置*

对于每一个Servlet类和网址进行绑定一般在web.xml文件中需要这两个标签

`web.xml`配置文件位于项目下面的 `WebContent/WEB-INF`文件夹中

```xml
<!--先配置servlet信息-->
<servlet>
    <!--配置Servlet信息 必须唯一-->
	<servlet-name>Demo01</servlet-name>
	<!--配置Serlvet的完全路劲-->
	<servlet-class>com.servlet.ServletDemo01</servlet-class>
</servlet>
<!--配置servlet的映射-->
<servlet-mapping>
    <!--配置servlet名称和上面要一样-->
	<servlet-name>Demo01</servlet-name>
	<!--虚拟路径-->
 	<!--'/'代表的意思是什么-->
	<url-pattern>/demo01</url-pattern>
</servlet-mapping>  
```

在web.xml中配置Servlet的目的其实只有一个，就是把访问路径与一个Servlet绑定到一起，上面配置是把访问路径：“/demo01”与“com.servlet.ServletDemo01”绑定到一起

* <servlet>：指定ServletDemo01这个Servlet的<servlet-name>名称为Demo01
* <servlet-mapping>指定/demo01访问路径的<servlet-name>名为Demo01

<servlet>和<servlet-mapping>通过<servlet-name>把这个元素关联在一起了！

然后启动Tomcat，在浏览器中访问：`http://localhost:8080/WebProjectName/url-pattern`即可在控制台上看到输出

servlet 执行的过程如下:

![](http://otgx4owbp.bkt.clouddn.com/18-1-21/75145689.jpg)



查看打印结果:

多次访问这个Servlet,看服务器端控制台打印.....，发现

* void init(ServletConfig)；    只执行一次
* void service(ServletRequest,ServletResponse)；  每次访问，都会执行这个方法
* void destroy()；只执行一次，当关闭Tomcat服务器的时候



这里就涉及到另一个概念：生命周期。生命周期 是编程语言中一个常见的概念，如 Android编程中的Activity等组件也有自己的生命周期。Servlet也有生命周期这个概念。



# Servlet接口 

## 1.Servlet的生命周期

所谓生命周期，就是说Servlet的创建、服务，以及销毁过程，与Servlet的生命周期相关的方法有：

> * void init(ServletConfig)；
> * void service(ServletRequest,ServletResponse)；
> * void destroy()；
>
>

 ### 1.1 初始化 Servlet 

```java
void init(ServletConfig)
```

服务器会在Servlet第一次被访问时创建Servlet，或者是在服务器启动时创建Servlet。如果服务器启动时就创建Servlet，那么还需要在web.xml文件中配置

也就是说默认情况下，Servlet是在第一次被访问时由服务器创建的

而且**一个Servlet**类型，服务器只创建一个实例对象

> 例如在我们首次访问http://localhost:8080/demo01时，服务器通过“/demo01”找到了绑定的Servlet名称为com.servlet.ServletDemo01，然后服务器查看这个类型的Servlet是否已经创建过，如果没有创建过，那么服务器才会通过**反射**来创建HelloServlet的实例
>
> 当我们再次访问http://localhost:8080/demo01时，服务器就不会再次创建ServletDemo01实例了，而是直接使用上次创建的实例
>
> 在Servlet被创建后，服务器会马上调用Servlet的void init(ServletConfig)方法
>
> 请记住， **Servlet**被创建后马上就会调用init()方法，而且一个**Servlet这个方法只会被调用一次**
>
> 我们可以把一些对Servlet的初始化工作放到init方法中

**事实上，这个方法并不是用于创建Servlet的，而是当Tomcat第一次创建某个Servlet时，会触发这个Servlet的这个方法**



### 1.2 Servlet服务

``` java
void service(ServletRequest,ServletResponse)
```

当服务器每次接收到请求时，都会去调用Servlet的service()方法来处理请求

服务器接收到一次请求，就会调用service() 方法一次，所以service()方法是会被调用多次的

正因为如此，所以我们才需要**把处理请求的代码写到service()方法**中

### 1.3 销毁 Servlet 

```java
void destory();
```

在服务器被关闭时，服务器会去销毁Servlet，在销毁Servlet之前服务器会先去调用Servlet的destroy()方法

可以把Servlet的"临终遗言"放到`destroy()`方法中，例如对某些资源的释放等代码放到destroy()方法中，当然 在实际写代码时几乎不会在这里写代码

一个Servlet的一个生命周期只会调用一次destroy方法

**注：这个方法并不是用于销毁Servlet的，而是当Tomcat关闭时，会触发这个Servlet的这个方法**

> 在Tomcat服务器中，某个类Servlet只会被创建一次对象，说明类Servlet是**单例**，一个项目中有N个Servlet类，这些Servlet类只会被创建一个对象
>
> 还有一个问题：
>
> Servlet不是线程安全的。若多个客户端同时访问 这个Servlet，即 多条线程同时访问这个Servlet，会造成线程安全问题。
>
> ？？？

总结：

servlet生命周期方法：

* void init(ServletConfig)：（调用1次）；
* void service(ServletRequest request, ServletResponseresponse)：每次处理请求时都会被调用；
* void destroy()：（调用1次）；



特性：

* 单例，一个类只有一个对象；当然可能存在多个Servlet类
* 线程不安全的，所以它的效率是高的 ？？？

### 1.4 测试生命周期方法

修改ServletDemo01如下，然后再去访问http://localhost:8080/demo01

```java
public class ServletDemo01 implements Servlet {
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Servlet被创建了！");
	}
	
	public ServletConfig getServletConfig() {return null;}
	
	public void destroy() {
		System.out.println("Servlet要离去了！");
	}
	
	public String getServletInfo() {return null;}

	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		System.out.println("hello servlet!");
	}
}
```

在首次访问HelloServlet时，init方法会被执行，而且也会执行service方法。再次访问时，只会执行service方法，不再执行init方法。在关闭Tomcat时会调用destroy方法。

看到这5个方法中的形参有三个之前没见过的类：

ServletRequest, ServletResponse, ServletConfig.

## 2 Servlet接口相关类型

在Servlet接口中还存在三个我们不熟悉的类型

* ServletRequest：service() 方法的参数，它表示请求对象，它封装了所有与请求相关的数据，它是由服务器创建的
* ServletResponse：service()方法的参数，它表示响应对象，在service()方法中完成对客户端的响应需要使用这个对象
* ServletConfig：init()方法的参数，它表示Servlet配置对象，它对应Servlet的配置信息，那对应web.xml文件中的`<servlet>`元素

### 2.1 ServletConfig

打开web.xml配置文件..... 若想获取其中的数据怎么办呢？当然你可以来解析这个XML，但咱们还可以轻松的通过ServletConfig的对象来获取

ServletConfig对象对应web.xml文件中的`<servlet>`元素，一个ServletConfig对象对应一个`<servlet>`元素。例如你想获取当前Servlet在web.xml文件中的配置名，那么可以使用servletConfig.getServletName()方法获取

**ServletConfig对象是由服务器创建的**，然后传递给Servlet的init()方法，你可以在init()方法中使用它

ServletConfig 有如下方法：

* String  getServletName()：获取Servlet在web.xml文件中的配置名称，即`<servlet-name>`指定的名称；（用到不多）
* ServletContext  getServletContext()：用来获取ServletContext对象
* String  getInitParameter(String name)：用来获取在web.xml中配置的**初始化参数**，通过参数名来获取参数值
* Enumeration  getInitParameterNames()：用来获取在web.xml中配置的所有初始化参数名称；（返回值是一个迭代器（集合），很少使用）

什么是Servlet的初始化参数呢？

在`<servlet>`元素中还可以配置初始化参数：

```xml
<servlet>
    <servlet-name>One</servlet-name>
    <servlet-class>com.xyd.servlet.OneServlet</servlet-class>
    <init-param>
      	<param-name>username</param-name>
    	<param-value>scott</param-value>
    </init-param>
    <init-param>
    	 <param-name>password</param-name>
    	 <param-value>tiger</param-value>
    </init-param> ------  配置了两个初始化参数
  </servlet>
```

以使用ServletConfig对象的getInitParameter()方法来获取初始化参数，例如：

String value1 =servletConfig.getInitParameter(“paramName1”);//获取到paramValue1

```java
// 获取 初始化的参数
		
String username = servletConfig.getInitParameter("username");
String password = servletConfig.getInitParameter("password");
		
System.out.println("username:"+username);
System.out.println("password:"+password);

//获取初始化参数
Enumeration<String> initParameterNames = servletConfig.getInitParameterNames();
		
		while (initParameterNames.hasMoreElements()) {
			
			String nextElement = initParameterNames.nextElement();
			System.out.println(nextElement + " : " +     servletConfig.getInitParameter(nextElement));
}
```

### 2.2 ServletRequest和ServletResponse

[后文详述](#reqResp.md)

# GenericServlet 抽象类

* GenericServlet概述

  1. 有两个init方法

  2. 有一个获取ServletConfig 对象的方法

  3. 一个抽象方法Service  

     `public abstract void service(ServletRequestreq, ServletResponse res)`

  4. GenericServlet还实现了ServletConfig接口，拥有与ServletConfig同名且功能相同的getInitParameter()、getServletContext()等ServletConfig的方法。



* 编写自己的MyServlet继承于GenericServlet的时候，有一点需要特别注意：

  > 当需要在服务器创建这个Servlet的时候 进行一些初始化操作，此时你肯定会重写init方法；但是不能重写init(ServletConfig config)，而应该重写init()。原因如下：
  >
  > GenericServlet的init()方法:
  >
  > 在GenericServlet中，定义了一个ServletConfigconfig实例变量，并在init(ServletConfig)方法中把参数ServletConfig赋给了实例变量。然后在该类的很多方法中使用了实例变量config。
  >
  > 如果子类覆盖了GenericServlet的init(StringConfig)方法，那么this.config=config这一条语句就会被覆盖了，也就是说GenericServlet的实例变量config的值为null，那么所有依赖config的方法都不能使用了。如果真的希望完成一些初始化操作，那么去覆盖GenericServlet提供的init()方法，它是没有参数的init()方法，它会在init(ServletConfig)方法中被调用

* 实现了ServletConfig接口

   GenericServlet还实现了ServletConfig接口，所以可以直接调用getInitParameter()、getServletContext()等ServletConfig的方法

实现Servlet**有三种方式：**

* 实现javax.servlet.Servlet接口；
* 继承javax.servlet.GenericServlet类；
* 继承javax.servlet.http.HttpServlet类；（重点掌握）



# HttpServlet 抽象类

* HttpServlet类是GenericServlet的子类，它提供了对HTTP请求的特殊支持能够非常方便的操作HTTP请求和返回中的一些参数**，所以**通常我们都会通过继承HttpServlet来完成自定义的Servlet

* 这些方法中，咱们需要重点关注的是 doGet和 doPost方法。还有一点需要注意，虽然这个类中  没有抽象方法，但HttpServlet是抽象类，只能被继承 使用。一般定义自己Servlet都是继承于HttpServlet，具体代码是这样的，只需重写 doGet 和  doPost 方法即可：

* HttpServlet重写了Servlet的生命周期方法service，这个生命周期方法最终实现是调用HttpServlet自己的service方法，而这个service具体的实现又是通过方法doGet（对应get请求） 和 doPost（对应post请求）。所以，当继承于HttpServlet来定义自己的MyServlet的时候，只需要重写doGet（对应get请求） 或者  doPost（对应post请求） 即可

  源码查看:

  ```java
  public abstract class HttpServlet extends GenericServlet {

       //doGet  这个方法默认是给客户端返回"http.method_get_not_supported"，
       //客户端会显示 405。
       //所以 客户端若是get请求，Servlet必须重写这个方法
       protected void doGet(HttpServletRequest req, HttpServletResponse resp)
          throws ServletException, IOException
      {
          String protocol = req.getProtocol();
          String msg = lStrings.getString("http.method_get_not_supported");
          if (protocol.endsWith("1.1")) {
              resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, msg);
          } else {
              resp.sendError(HttpServletResponse.SC_BAD_REQUEST, msg);
          }
      }
       
     //doPost   这个方法默认是给客户端返回"http.method_get_not_supported"，
     //客户端会显示 405。
     //所以 客户端若是post请求，Servlet必须重写这个方法
      protected void doPost(HttpServletRequest req, HttpServletResponse resp)
          throws ServletException, IOException {

          String protocol = req.getProtocol();
          String msg = lStrings.getString("http.method_post_not_supported");
          if (protocol.endsWith("1.1")) {
              resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, msg);
          } else {
              resp.sendError(HttpServletResponse.SC_BAD_REQUEST, msg);
          }
      }

  //HttpServlet自己定义的方法，生命周期方法service 会调用这个service方法
  //这个方法的形参HttpServletRequest 和 HttpServletResponse ，都是与HTTP协议相关    
  //的，处理网络请求 更加方便。
      protected void service(HttpServletRequest req, HttpServletResponse resp)
          throws ServletException, IOException {
          ……
          if(...){
              doGet.....
          }
          ...
          else if(){
             doPost.....
          }
  }

      //重写Servlet的生命周期方法,Tomcat会自动调用这个方法
      @Override
      public void service(ServletRequest req, ServletResponse res)
          throws ServletException, IOException {

          HttpServletRequest  request;
          HttpServletResponse response;

          try {
              //强转
              request = (HttpServletRequest) req;
              response = (HttpServletResponse) res;
          } catch (ClassCastException e) {
              throw new ServletException("non-HTTP request or response");
          }
          //调用上面service()方法
          service(request, response);//是httpServlet中自己的方法
  }
  ……
  }
  ```

  ​

   HttpServlet类中提供了service(HttpServletRequest,HttpServletResponse)方法，这个方法是HttpServlet自己的方法，不是从Servlet继承来的。在HttpServlet的service(ServletRequest,ServletResponse)(来自Servlet的生命周期方法)方法中会把ServletRequest和ServletResponse强转成HttpServletRequest和HttpServletResponse，然后调用service(HttpServletRequest,HttpServletResponse)方法。

  ​

* doGet()和doPost()

  在HttpServlet的service(HttpServletRequest,HttpServletResponse)方法会去判断当前请求是GET还是POST，如果是GET请求，那么会去调用本类的doGet()方法，如果是POST请求会去调用doPost()方法，这说明我们在子类中去覆盖doGet()或doPost()方法即可。

```
public class HelloServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("hello doGet()...");
	}
}

public class HelloServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("hello doPost()...");
	}
}
```



* 具体的HttpServlet的流程

![](http://otgx4owbp.bkt.clouddn.com/18-1-22/55802809.jpg)

所以，为了既可以通过get 又可以通过post请求访问某个Servlet，一般同时给这个Servlet添加doGet 和 doPost 方法，

测试1:

只实现了doPost方法，即只允许客户端通过post方式访问。

在浏览器中直接访问这个Servlet，此请求方式为get请求，而服务器端的Servlet没有重写doGet，所以会报出 405

写个界面，通过post请求服务器端的这个Servlet。查看打印结果



## Servlet细节

#### 1.Servlet与线程安全

因为**一个类型的Servlet只有一个实例对象**，那么就有可能会现时出一个Servlet同时处理多个请求（即 多条线程同时访问这个Servlet），那么Servlet是否为线程安全的呢？答案是：“不是线程安全的”

这说明Servlet的工作效率很高，但也存在线程安全问题！所以我们不应该在Servlet中随便创建成员变量，因为可能会存在一个线程对这个成员变量进行写操作，另一个线程对这个成员变量进行读操作

解决：

* 不要在Servlet中创建成员！创建局部变量即可！
* 可以创建无状态成员！
* 可以创建有状态的成员，但状态必须为只读的！



#### 2.让服务器在启动时就创建Servlet

默认情况下，服务器会在某个Servlet第一次**收到请求**时创建它

也可以在`web.xml`中对Servlet进行配置，使服务器启动时就创建Servlet

```xml
    <servlet>
		<servlet-name>hello1</servlet-name>
		<servlet-class>com.servlet.Hello1Servlet</servlet-class>
		<load-on-startup>0</load-on-startup>
         <!--在<servlet>中配置<load-on-startup>，其中给出一个非负整数！-->
	</servlet>
	<servlet-mapping>
		<servlet-name>hello1</servlet-name>
		<url-pattern>/hello1</url-pattern>
	</servlet-mapping>
      
	<servlet>
		<servlet-name>hello2</servlet-name>
		<servlet-class>com.servlet.Hello2Servlet</servlet-class>
		<load-on-startup>1</load-on-startup>
	</servlet>
	<servlet-mapping>
		<servlet-name>hello2</servlet-name>
		<url-pattern>/hello2</url-pattern>
	</servlet-mapping>
      
	<servlet>
		<servlet-name>hello3</servlet-name>
		<servlet-class>com.servlet.Hello3Servlet</servlet-class>
		<load-on-startup>2</load-on-startup>
	</servlet>
	<servlet-mapping>
		<servlet-name>hello3</servlet-name>
		<url-pattern>/hello3</url-pattern>
	</servlet-mapping>
```

在\<servlet\>元素中配置\<load-on-startup\>元素可以让服务器在启动时就创建该Servlet，其中\<load-on-startup\>元素的值必须是大于等于的整数，它的使用是服务器启动时创建Servlet的顺序。上例中，根据\<load-on-startup\>的值可以得知服务器创建Servlet的顺序为Hello1Servlet、Hello2Servlet、Hello3Servlet。数字越小 优先级别越高

#### 3. URL 模式

`<url-pattern>`是`<servlet-mapping>`的子元素，用来指定Servlet的访问路径，它必须是以`/`开头

* 可以在`<servlet-mapping>`中给出多个`<url-pattern>`，例如：

```xml
<servlet-mapping>
    <servlet-name>ServletDemo01</servlet-name>
    <url-pattern>/demo01</url-pattern>
    <url-pattern>/demo02</url-pattern>
  <!--一个Servlet 绑定了两个url-->
  </servlet-mapping>  
```

那么这说明一个Servlet绑定了两个URL，无论访问/demo01还是/demo01，访问的都是ServletDemo01

* 还可以在<url-pattern>中使用**通配符**，所谓通配符就是星号“*”，星号可以匹配任何URL前缀或后缀，使用通配符可以命名一个Servlet绑定一组URL，例如：

> 1. ```xml
>      <url-pattern>/servlet/*<url-patter>
>      ```
>       表示匹配以`/servlet`开头的任何路径 
>
> 2. ```xml
>      <url-pattern>*.do</url-pattern>
>      ```
>
> ​        扩展名匹配  **表示匹配任何以`.do`结尾的路径
>
> 3. ```xml
>     <url-pattern>/*<url-pattern>
>     ```
>     表示匹配任何路径
>

请注意，通配符要么为前缀，要么为后缀，不能出现在URL中间位置，也不能只有通配符

注意，通配符是一种模糊匹配URL的方式，如果存在更具体的``<url-pattern>`，那么访问路径会去匹配具体的`<url-pattern>`

```xml
<servlet>
		<servlet-name>hello1</servlet-name>
		<servlet-class>com.servlet.Hello1Servlet</servlet-class>
	</servlet>
	<servlet-mapping>
		<servlet-name>hello1</servlet-name>
		<url-pattern>/servlet/hello1</url-pattern>
	</servlet-mapping>

	<servlet>
		<servlet-name>hello2</servlet-name>
		<servlet-class>com.servlet.Hello2Servlet</servlet-class>
	</servlet>
	<servlet-mapping>
		<servlet-name>hello2</servlet-name>
		<url-pattern>/servlet/*</url-pattern>
	</servlet-mapping>
```

当访问路径为http://localhost:8080/hello/servlet/hello1时，因为访问路径即匹配hello1的`<url-pattern>`，又匹配hello2的`<url-pattern>`，但因为hello1的<url-pattern>中没有通配符，所以优先匹配，即设置hello1

#### 4. web.xml文件的继承

前面，学习了每个JavaWeb的web.xml ，知道这个web.xml是这个JavaWebx项目的访问路径和Servlet的配置文件，但各位有没有想过 当你访问了一个不存在的地址，为啥给你返回的是404呢，是谁给你返回的呢？肯定有一个Servlet，但这个Servlet在哪儿呢？

每个完整的JavaWeb应用中都需要有web.xml，但我们不知道所有的web.xml文件都有一个共同的父文件，它在Tomcat的conf/web.xml中　

**在${CATALINA_HOME}\conf\web.xml****中的内容，相当于写到了每个项目的web.xml中，它是所有web.xml的父文件。

对于一个完整的JavaWeb项目，Tomcat是JavaWeb项目中不变的部分，而我们写的服务器代码是 JavaWeb项目中变化的部分，这部分是根据业务需求来编写的。不管在什么项目中，当你访问了一个不存在的地址时，都会返回404，这一点没有变化。即 当访问的路径与某个项目中的所有Servlet都不匹配的时候，就会去上述的conf/web.xml中去请求一个固定的Servlet。

conf/web.xml文件内容:

```xml
<?xml version="1.0" encoding="ISO-8859-1"?>

<web-app xmlns="http://java.sun.com/xml/ns/javaee"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://java.sun.com/xml/ns/javaee
                      http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd"
  version="3.0">
     <servlet>
        <servlet-name>default</servlet-name>    
        <servlet-class>org.apache.catalina.servlets.DefaultServlet</servlet-class>
因为这个Servlet的URL路径优先级最低，如果一个请求没有人处理，那么它来处理！它显示404。
即 当访问路径不存在时，会执行该Servlet！原因：看下面哪个URL路径和这个Servlet匹配。
其实我们在访问index.html时也是在执行这个Servlet，为啥呢？因为这个JavaWeb项目中的web.xml路径配置中没有这个路径......

       <init-param>
            <param-name>debug</param-name>
            <param-value>0</param-value>
       </init-param>
       <init-param>
            <param-name>listings</param-name>
            <param-value>false</param-value>
       </init-param>
       <load-on-startup>1</load-on-startup>
</servlet>

    <servlet>
        <servlet-name>jsp</servlet-name>
        <servlet-class>org.apache.jasper.servlet.JspServlet</servlet-class>
        <init-param>
            <param-name>fork</param-name>
            <param-value>false</param-value>
        </init-param>
        <init-param>
            <param-name>xpoweredBy</param-name>
            <param-value>false</param-value>
        </init-param>
        <load-on-startup>3</load-on-startup>
    </servlet>

    <servlet-mapping>
        <servlet-name>default</servlet-name>
        <url-pattern>/</url-pattern>
此处的路径/优先级最低， 匹配所有URL，也就是说用户访问的URL路径没有匹配的页面时，那么执行的就是名为default的Servlet，即org.apache.catalina.servlets.DefaultServlet

    </servlet-mapping>


    <servlet-mapping>
        <servlet-name>jsp</servlet-name>
        <url-pattern>*.jsp</url-pattern>
任何URL后缀为jsp的访问，都会执行名为jsp的Servlet，即org.apache.jasper.servlet.JspServlet。
当你在浏览器中输入

当当前web项目的xml中并没有这个jsp的路径啊，为啥能得到一个页面呢？
因为这个请求被转到了org.apache.jasper.servlet.JspServlet


       <url-pattern>*.jspx</url-pattern>
任何URL后缀为jspx的访问，都会执行名为jsp的Servlet，即org.apache.jasper.servlet.JspServlet

    </servlet-mapping>

    <session-config>
        <session-timeout>30</session-timeout>
session的默认超时时间为30分钟，后面讲session时再说
    </session-config>

	<!-- 这里省略了大概4000多行的MIME类型的定义,这里只给出两种MIME类型的定义 -->
    <mime-mapping>
        <extension>bmp</extension>   ----文件的扩展名
        <mime-type>image/bmp</mime-type> ---- 对应http的type类型
    </mime-mapping>
    <mime-mapping>
        <extension>html</extension> ---- 文件的扩展名
        <mime-type>text/html</mime-type> ---- 对应http的type类型
</mime-mapping>
MIME类型用来标识网络上资源的媒体类型，这里举例为bmp和html两种MIME类型。

    <welcome-file-list>
        <welcome-file>index.html</welcome-file>
        <welcome-file>index.htm</welcome-file>
        <welcome-file>index.jsp</welcome-file>
</welcome-file-list>
在应用的web.xml中如果没有对<welcome-file-list>进行覆盖，那么默认主页为index.html、index.html、index.jsp

</web-app>
```

 现在咱们再回过头来，看看这个网址访问Servlet的方式

1. 通过浏览器 + 网址 访问Servlet

2. 服务器得到通过 网址，得到这个Servlet路径 /Servlet

3. 拿这个 Servlet路径和web.xml中的url-pattern 进行匹配

4. 再拿对应的servlet-name 找到匹配的Servlet的完整名称字符串，这个过程涉及到xml解析，由Tomcat来实现的

5. 当得到一个类的类名字符串之后，如何创建这个类的对象呢？如何调用这个类中的方法呢？这就需要用到**反射** 技术了。这个过程由Tomcat来实现的，即 Tomcat会通过反射技术来创建我们定义的Servlet对象，并调用这些Servlet对象中的固定的那几个方法(即 生命周期方法)(反射往往都和配置文件相关)

   > **Tomcat**通过反射来创建某个Servlet对象的时候，需要用到这个类的无参构造器，并且很多时候，不需要在Servlet中定义构造器，而就让Tomcat使用系统自动提供的无参构造器。所以，你千万不要在Servlet中定义了一个有参数的构造器，而又没有添加上一个无参数的构造器

   ​

# ServletContext

#### 1ServletContext概述

关于ServletContext 记住4句话：

* 服务器会为每个应用创建一个ServletContext对象
* 一个项目只有一个ServletContext对象
* 可以在N多个Servlet中来获取这个唯一的对象，使用它可以给多个Servlet之间传递数据
* 生命周期 与天地同寿！！！这个对象在Tomcat启动时就创建，在Tomcat关闭时才会死去！即
  * ServletContext对象的创建是在服务器启动时完成的；
  * ServletContext对象的销毁是在服务器关闭时完成的。



通常使用ServletContext对象可以在整个Web应用的动态资源之间共享数据！例如在AServlet中向ServletContext对象中保存一个值，然后在BServlet中就可以获取这个值，这就是共享数据了。

 ServletContext功能的编程思想是软件编程中较为常见的。如 在Android中，也有类似功能的API。如何获取ServletContext对象呢？

#### 2获取ServletContext

将会学到的有**4**种方式：

* ServletConfig-getServletContext()； 

通过ServletConfig对象调用方法**getServletContext()**得到ServletContext对象

* GenericServlet或者HttpServlet-getServletContext();

通过GenericServlet或者HttpServlet对象调用方法getServletContext()得到ServletContext对象

 

* HttpSession-getServletContext()            （后面学）
* ServletContextEvent-getServletContext()        （后面学）



现在来看前两种方式，其实 都是通过Tomcat在调用Servlet声明周期方法init(ServletConfig config)的时候 所传递的ServletConfig 对象来调用其实例方法 **ServletContext  getServletContext() **得到的！

在Servlet中获取ServletContext对象：

* 在void init(ServletConfig config)中：ServletContext context = config.getServletContext();，ServletConfig类的getServletContext()方法可以用来获取ServletContext对象；

在GenericeServlet或HttpServlet中获取ServletContext对象：

* GenericServlet类 实现了接口ServletConfig ，



就实现了getServletContext()方法，通过源代码可以看到最终还是通过ServletConfig对象（Tomcat在调用Servlet声明周期方法init(ServletConfigconfig)的时候 所传递的ServletConfig 对象）来调用getServletContest()方法；

具体代码：

```
public class MyServlet implements Servlet {

    public void init(ServletConfig config) {
        ServletContext context = config.getServletContext();
    }
…
}

```

```
public class MyServlet extends HttpServlet {
      public void doGet(HttpServletRequest request, HttpServletResponse response) {
          ServletContext context = this.getServletContext();//HttpServlet就是ServletConfig 的实类
          或者
          ServletContext context = this.getServletConfig().getServletContext()；
      }
}

```

得到ServletContext对象之后怎么来使用呢？

前面说，通常 使用ServletContext对象可以在整个Web应用的动态资源之间共享数据！例如在AServlet中向ServletContext对象中保存一个值，然后在BServlet中就可以获取这个值，这就是共享数据了。



#### 3域对象的功能

ServletContext对象是JavaWeb四大域对象之一，JavaWeb的四大域的类为：

* PageContext；
* ServletRequest；
* HttpSession；
* ServletContext；

所有域对象都有存取数据的功能，因为域对象内部有一个Map，用来存储数据。这种通过封装Map来实现数据存储的api，也是java语言中常见的。

总结：

域对象就是用来在多个Servlet中传递数据！！

* 域对象必须有要存数据功能
* 域对象必须要有取数据功能
* 域对象内部其实有一个Map



下面是ServletContext对象用来操作数据的方法：

* 存:void   setAttribute(Stringkey, Object  value)：

  用来存储一个对象，也可以称之为存储一个域属性，例如：servletContext.setAttribute(“xxx”, “XXX”)，在ServletContext中保存了一个域属性，域属性名称为xxx，域属性的值为XXX。**请注意，如果多次调用该方法，并且使用相同的****name，那么会覆盖上一次的值，这一特性与Map相同**；

* 取：Object  getAttribute(String key)：

  用来获取ServletContext中的数据，当前在获取之前需要先去存储才行，例如：

  String value = (String)servletContext.getAttribute(“xxx”); （这个方法的返回值类型为Object 所以需要强转），获取名为xxx的域属性。其中参数那么类似于Map中的key值；

* void   removeAttribute(String key)：用来移除ServletContext中参数name对应的域属性，类似于Map中的remove方法，删除一对（key, value）。如果参数name指定的域属性不存在，那么本方法什么都不做；

* Enumeration   getAttributeNames()：获取所有域属性的名称；



#### 5获取资源相关方法

在JavaWeb工程目录中的**WebRoot**是应用项目的**根目录**（ 咱们知道发布到Tomcat服务器中的就是这个WebRoot目录），在项目的目录下文件的 文件路径和 文件IO流如何获取呢？

如 WebRoot目录下的b.txt 和 a.txt

![](http://otgx4owbp.bkt.clouddn.com/18-1-22/31227008.jpg)



5.1获取真实路径（*****\********）

可以使用ServletContext对象来获取Web应用下的资源。

例如 期望获取根目录下的文件dp.properties 在服务器端的真实路径

```
String contextPath = getServletContext().getRealPath("dp.properties");
```

再例如在hello应用的根目录下创建a.txt文件，现在想在Servlet中获取这个资源，就可以使用ServletContext来获取。

* 获取a.txt的真实路径：String realPath =servletContext.getRealPath(“/a.txt”)，realPath的值为a.txt文件的绝对路径：F:\tomcat6\webapps\hello\a.txt；
* 获取b.txt的真实路径：String realPath =servletContext.getRealPath(“/WEB-INF/b.txt”)；

 其中，方法getRealPath(path)的路径path 的参数值 “/a.txt” 的 / 表示 应用项目的根目录。 

​     ----- 是针对getRealPath()

 当得到服务器端的文件之后再通过File包装成抽象路径，就可以对这个路径的文件进行操作，如复制删除 重命名等。



5.2　获取资源流

ServletContext提供了一种更加简洁的方式，可以通过ServletContext获取资源流，即把资源以**输入流**的方式获取：

* 获取a.txt资源流：InputStream in =servletContext.getResourceAsStream(“/a.txt”)；
* 获取b.txt资源流：InputStream in =servletContext.getResourceAsStream(“/WEB-INF/b.txt”)；



获取类路径下资源

在JavaWeb项目中的目录/WEB-INF/classes下存放的是.java文件 被编译成的二进制.class文件 ，目录/WEB-INF/lib下存储的是Java代码所需要的Jar包。

类路径对一个JavaWeb项目而言，就是/WEB-INF/classes和/WEB-INF/lib/每个jar包（因为Jar包中的文件也是有目录的，通常情况下就是将Java项目中src目录打成jar包）！获取类路径资源，就是获取这些目录下的资源。

这里要讲的是获取类路径下的资源，对于JavaWeb应用而言，就是获取classes目录下的资源。

通过使用Class或者ClassLoader：可以较为便捷的获取到类路径下的资源。上面是通过ServletContext的getResourceAsStream方法，这里要通过Class或者ClassLoader的getResourceAsStream方法。 

```
InputStream in = this.getClass().getResourceAsStream("/xxx.txt");
```

 

* 通过Class类的对象来获取类路径下的资源，对应JavaWeb应用的类路径就是classes目录下的资源。

具体的代码为：Class类的getResourceAsStream(String path)

1. 路径以“/”开头，相对classes路径；
2. 路径不以“/”开头，相对当前class文件所有路径，例如在com.servlet.MyServlet中执行，那么相对/classes/com/servlet/路径；

  例如：

  InputStream in = com.servlet.MyServlet.class.getResourceAsStream("a.jpg");

  获取的是：/WEB-INF/classes/com/servlet/a.jpg，即与MyServlet.class同目录下的资源

   例如：

  InputStream in = com.servlet.MyServlet.class.getResourceAsStream("/a.jpg");

  获取的是：/WEB-INF/classes/a.jpg，即类路径的根目录下的资源，类路径的根目录就是/classes目录

* 通过ClassLoader类的对象来获取类路径下的资源，对应JavaWeb应用的类路径就是classes目录下的资源

具体的代码为：ClassLoader类的getResourceAsStream(Stringpath)。注，ClassLoader对象需要通过Class对象调用.getClassLoader()方法得到。 

​     路径不以“/”开头，相对classes路径；

 例如：

```
InputStream in = this.getClass().getClassLoader().getResourceAsStream("a.jpg");
```

   获取的是：/WEB-INF/classes/a.jpg，即类路径的根目录下的资源，类路径的根目录就是/classes目录

若我想获取src目录下的a.txt中的内容 怎么办呢?

获取src路径下的资源，其实就是 获取类路径下的资源；或者说 若想在类路径下存放文件 在写代码的时候 将这个文件直接放置于src目录下即可。咱们知道，src目录下的文件并不会部署到Tomcat服务器中；只会将这个JavaWeb工程中的WebRoot目录下内容发布到服务器中



src目录下的.java文件会被编译成.class文件 并存放于WebRoot
-- WEB-INF -- classes 目录下，非.java文件（如 .txt文件）会直接复制于WebRoot -- WEB-INF -- classes 目录下，展开
WebRoot -- WEB-INF -- classes 目录 或者 项目的工作空间中的对应的目录下 

注意，getResourceAsStream(“a.txt”) 其中路径没有以 / 开头，是相对于classes目录。

 现在得到了 /WEB-INF/classes/a.jpg的输入流，怎么将这个输入流转化为字符串 并 在控制台打印呢？