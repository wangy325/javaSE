
# Web的介绍

# Web应用的演变

## 1.单机程序

![img](http://ojx4zwltq.bkt.clouddn.com/17-9-14/57423497.jpg)

## 2.网络程序– 主机终端

![img](http://ojx4zwltq.bkt.clouddn.com/17-9-14/71680952.jpg)

## 3.网络程序– 两层CS(Client/Server)架构（客户端 + DB）

![img](http://ojx4zwltq.bkt.clouddn.com/17-9-14/77695424.jpg)

#### 两层CS架构的优缺点：

1. 优点
   1. 数据库作为Server，使用数据库特定的编程语言编写业务逻辑
   2. 客户端提供操作界面和少量的业务逻辑处理
2. 缺点
   1. 移植性差（更换数据库需要重新编程）
   2. 不适合大型应用（客户端需要与数据库之间建立持续的连接）

## 4.网络程序– 三层CS(Client/Server)架构（客户端 + 应用服务器+DB）

![img](http://ojx4zwltq.bkt.clouddn.com/17-9-14/27587027.jpg)

### 三层CS架构的工作流程

![img](http://ojx4zwltq.bkt.clouddn.com/17-9-14/74817819.jpg)

#### 三层CS构架的优缺点

- 特点
  - 数据库只负责数据的管理
  - 应用服务器提供所有的业务逻辑的处理
  - 客户端只负责提供操作界面
- 优点
  - 移植性好，适合大型应用
- 缺点
  - 客户端需要单独安装，开发复杂（需要自定义协议，编写客户端和服务器端的通信模块）

## 5.网络程序– BS(Browser/Server)架构

![img](http://ojx4zwltq.bkt.clouddn.com/17-9-14/26674629.jpg)

#### BS构架的优势 

- 特点
  - 数据库只负责数据的管理
  - Web服务器负责业务逻辑的处理
  - 浏览器负责提供操作页面
- 优点
  - 不需要单独安装客户端

  - 开发相对于CS简单，客户端和服务器的通信模块都是使用标准的HTTP协议进行通信

    ​



# 什么是Servlet

Sun（Oracle）公司制定的一种用来**扩展Web服务器功能**的**组件规范** 

### 扩展web服务器功能

 在BS(Browser Server)架构中，早期的Web服务器只能处理静态资源的请求，也就是无法根据请求进行计算后再生成相应的HTML内容。servlet可以处理动态资源的请求。web服务器收到请求之后，可以调用servlet来动态处理、生成动态页面并响应结果

### 组件规范

 组件规范是依靠一套API来实现的，也就是说开发中只要基于Sun公司提供的这套API，按照一定的规则来编写程序，那么就可以实现针对Web服务器的功能扩展。

 组件只是对部分功能的一个实现，不能单独运行，必须放在一定的环境中才能运行。而这个针对各个组件进行管理、创建、销毁的运行环境称为Web容器。

# Servlet运行原理

Servlet作为补充Web服务器功能的组件，需要依赖于Servlet容器才能运行，它的运行原理如图所示：

![img](http://ojx4zwltq.bkt.clouddn.com/17-9-14/24512831.jpg)

 在浏览器中输入请求地址后，浏览器会依据IP地址及端口号找到对应的Web服务器，如果请求的是静态资源，Web服务器直接提供响应；如果请求的是动态资源，则直接将请求传递给容器来处理

 能够充当Servlet容器这个角色的有很多软件，如Tomcat、Weblogic、JBoss等。而这些Servlet容器不仅仅具备了管理Servlet组件的功能，也具备了Web服务器的一些功能，所以很多时候只要安装一个Tomcat软件就同时具备了Web服务器及Servlet容器的双重功能。

 从上图中可以看出 Tomcat 的心脏是两个组件：Connector 和 Container，关于这两个组件将在后面详细介绍。Connector 组件是可以被替换，这样可以提供给服务器设计者更多的选择。

 Connector 组件是 Tomcat 中两个核心组件之一，它的主要任务是负责接收浏览器的发过来的 tcp 连接请求，创建一个 Request 和 Response 对象分别用于和请求端交换数据，然后会产生一个线程来处理这个请求并把产生的 Request 和 Response 对象传给处理这个请求的线程，处理这个请求的线程就是 Container 组件要做的事了。

 Container 是容器的父接口，所有子容器都必须实现这个接口，Container 容器的设计用的是典型的责任链的设计模式，它有四个子容器组件构成，分别是：Engine、Host、Context、Wrapper。其中Context 代表 Servlet 的上下文，它具备了 Servlet 运行的基本环境。

### Servlet容器

 Servlet容器也叫Servlet引擎，是Web服务器或者应用服务器的一部分，用户在发送请求和响应之上提供网络服务，解码基于MIME的请求，格式化基于MIME的请求，Servlet不能独立运行，必须被部署到Servlet容器中，由容器实例化和调用Servlet的方法。Servlet容器在Servlet的生命周期内保护和管理Servlet。

>  **MIME类型(多用途互联网邮件扩展类型)**是一种通知客户端其接收文件的多样性的机制。文件后缀名在网页上并没有明确的意义。因此，使服务器设置正确的传输类型非常重要，所以正确的MIME类型与每个文件一同传输给服务器。在网络资源进行连接时，浏览器经常使用MIME类型来决定执行何种默认行为。



# 如何开发一个Servlet

> 一到四个步骤实现静态Web，五到七步骤拓展了静态Web功能，成为动态Web
>
> 开发工具(Eclipse,MyEclipse,Idea) 

一、安装Apache Tomcat 8.0.x

二、搭建Web项目

三、项目部署到Tomcat中

四、测试：打开浏览器访问静态页面

五、编写java类，继承HttpServlet类,重写doGet和doPost方法

六、配置web.xml文件

七、重新部署到Tomcat并测试：打开浏览器访问Servlet



## 1. 安装Apache Tomcat 8.0.x

### 准备

安装JDK1.7及以上(Apache Tomcat 8.0.x需要jdk1.7以上)的java运行环境，以及配置JAVA_HOME、PATH、CLASSPATH环境变量

### 下载Apache Tomcat8.0.x

[Apache Tomcat官网下载](http://tomcat.apache.org/download-80.cgi)

![img](http://ojx4zwltq.bkt.clouddn.com/17-9-14/74631871.jpg)

**下载完成得到一个压缩包，并解压**

![img](http://ojx4zwltq.bkt.clouddn.com/17-9-14/89119849.jpg)

解压后得到一个 apache-tomcat-8.0.x的文件夹！

![img](http://ojx4zwltq.bkt.clouddn.com/17-9-14/19421074.jpg)

### Apache Tomcat各版本介绍

1. Apache Tomcat 9.x（最新版本）

   Apache Tomcat上9.x是发展的当前焦点，它建立在Tomcat 8.0.x和实现了目前草案的Servlet 4.0规范，也将执行 JSP 2.4？，EL 3.1？，目前对WebSocket的1.2？ 和JASPIC 1.1 规范工作的一次更新上这些规范为Java EE 8除此之外启动时，它包括以下显著改进：

   - 添加对HTTP / 2的支持（需要APR /本地库）
   - 添加对TLS虚拟主机的支持
   - 添加了对使用JSSE连接器（NIO和NIO2）使用OpenSSL for TLS支持的支持。

2. Apache Tomcat 8.x （可以使用该版本，目前发现兼容性与7差不多）

   - Apache Tomcat 8.x建立在Tomcat的7.0.x并实施 的Servlet 3.1，JSP 2.3，EL 3.0和WebSocket的1.1规格。除此之外，还包括以下重大改进：
     - 单个公共资源实现来替换早期版本中提供的多个资源扩展特性。
   - Apache Tomcat 8.5.x支持相同的Servlet，JSP，EL和WebSocket规范的版本的Apache Tomcat 8.0.x. 除此之外，它也实现了JASPIC 1.1规范。还有在许多领域显著变化引擎盖下，从而提高了性能，稳定性和总拥有成本。

3. Apache Tomcat 7.x （初学者使用7就行，兼容性最好）

   Apache Tomcat 7.x建立在Tomcat中6.0.x的改进和实现的Servlet 3.0**， **JSP 2.2**，**EL 2.2和 WebSocket的1.1规格。除此之外，它还包括以下改进：

   - Web应用程序内存泄漏检测和预防
   - 提高了Manager和Host Manager应用程序的安全性
   - 通用CSRF保护
   - 支持直接在Web应用程序中包含外部内容
   - 重构（连接器，生命周期）和大量的内部代码清理

4. Apache Tomcat 6.x (稍微有点老，不支持Servlet3.0规范)

   Apache Tomcat 6.x建立在Tomcat中的5.5.x的改进和实现的Servlet 2.5和 JSP 2.1规范。除此之外，它还包括以下改进：

   - 内存使用优化
   - 高级IO功能
   - 重构聚类



### 启动和关闭Tomcat

在启动Tomcat之前，我们必须要配置环境变量：

1. JAVA_HOME：必须先配置JAVA_HOME，因为Tomcat启动需要使用JDK；
2. CATALANA_HOME：如果是安装版，那么还需要配置这个变量，这个变量用来指定Tomcat的安装路径，例如：F:\apache-tomcat-7.0.42。
3. 启动：进入%CATALANA_HOME%\bin目录，找到[startup.bat]()，双击即可；
4. 关闭：进入%CATALANA_HOME%\bin目录，找到[shutdown.bat]() ，双击即可；

startup.bat会调用catalina.bat，而catalina.bat会调用setclasspath.bat，setclasspath.bat会使用JAVA_HOME环境变量，所以我们必须在启动Tomcat之前把JAVA_HOME配置正确。

启动问题：

点击startup.bat后窗口一闪即消失：检查JAVA_HOME环境变量配置是否正确；

### 进入Tomcat主页

　　访问：http://localhost:8080 

### Tomcat的目录结构

![img](http://img.blog.csdn.net/20170102211204947?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjU4Mjc4NDU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center)

 

 

**(1) bin**：

​      该目录下存放的是二进制可执行文件，如果是安装版，那么这个目录下会有两个exe文件：tomcat6.exe、tomcat6w.exe，前者是在控制台下启动Tomcat，后者是弹出UGI窗口启动Tomcat；如果是解压版，那么会有startup.bat和shutdown.bat文件，startup.bat用来启动Tomcat，但需要先配置JAVA_HOME环境变量才能启动，shutdawn.bat用来停止Tomcat；



**(2) conf**：这是一个非常非常重要的目录，这个目录下有四个最为重要的文件：

* server.xml：配置整个服务器信息。例如修改端口号，添加虚拟主机等;


* tomcatusers.xml：存储tomcat用户的文件，这里保存的是tomcat的用户名及密码，以及用户的角色信息。可以按着该文件中的注释信息添加tomcat用户，然后就可以Tomcat主页中进入Tomcat Manager页面了；            
* web.xml:部署描述符文件，这个文件中注册了很多MIME类型，即文档类型。这些MIME类型是客户端与服务器之间说明文档类型的，如用户请求一个html网页，那么服务器还会告诉客户端浏览器响应的文档是text/html类型的，这就是一个MIME类型。客户端浏览器通过这个MIME类型就知道如何处理它了。当然是在浏览器中显示这个html文件了。但如果服务器响应的是一个exe文件，那么浏览器就不可能显示它，而是应该弹出下载窗口才对。MIME就是用来说明文档的内容是什么类型的！          **
* context.xml：对所有应用的统一配置，通常我们不会去配置它。

(3) lib:

​     Tomcat的类库，里面是一大堆jar文件。如果需要添加Tomcat依赖的jar文件，可以把它放到这个目录中，当然也可以把应用依赖的jar文件放到这个目录中，这个目录中的jar所有项目都可以共享之，但这样你的应用放到其他Tomcat下时就不能再共享这个目录下的Jar包了，所以建议只把Tomcat需要的Jar包放到这个目录下；

(4) logs：

​     这个目录中都是日志文件，记录了Tomcat启动和关闭的信息，如果启动Tomcat时有错误，那么异常也会记录在日志文件中。

(5) temp:

​     存放Tomcat的临时文件，这个目录下的东西可以在停止Tomcat后删除！

(6) webapps：

​         存放web项目的目录，其中每个文件夹都是一个项目；如果这个目录下已经存在了目录，那么都是tomcat自带的。项目。其中ROOT是一个特殊的项目，在地址栏中没有给出项目目录时，对应的就是ROOT项目。进入示例项目。其中examples就是项目名，即文件夹的名字。

(7) work：

​          运行时生成的文件，最终运行的文件都在这里。通过webapps中的项目生成的！可以把这个目录下的内容删除，再次运行时会生再次生成work目录。当客户端用户访问一个JSP文件时，Tomcat会通过JSP生成Java文件，然后再编译Java文件生成class文件，生成的java和class文件都会存放到这个目录下。

(8) LICENSE：许可证。

(9) NOTICE:说明文件。

## 2. 搭建Web项目

1. 右键 `New`—>`Project` 创建新项目

   ![img](http://ojx4zwltq.bkt.clouddn.com/17-9-16/55438710.jpg)

2. 选择 `Web`—>`Dynamic Web Project`，然后 `Next`。【动态Web】

   ![img](http://ojx4zwltq.bkt.clouddn.com/17-9-16/89417081.jpg)

3. 在 `Project name` 输入 项目名称，在`Dynamic web module version`选择 2.5(web2.5)，其他默认，然后 `Next`。

   ![img](http://ojx4zwltq.bkt.clouddn.com/17-9-16/30941953.jpg)

4. 继续`Next`

   ![img](http://ojx4zwltq.bkt.clouddn.com/17-9-16/57104958.jpg)

5. Context root 是请求路径 端口号紧跟的部分，如：`localhost:8080/hello`，Context root 也可以填`/`，则请求地址为：`localhost:8080`。Content directory 是web容器的目录。 注意：第3步骤一定要勾上，否则手动配置web.xml比较麻烦， 直接 `FInish`

   ![img](http://ojx4zwltq.bkt.clouddn.com/17-9-16/6705776.jpg)

6. Web项目环境到此基本搭建完成！最后Web项目目录结构如下：

   ![img](http://ojx4zwltq.bkt.clouddn.com/17-9-16/67757124.jpg)

   > build是编译后的路径
   >
   > web/WEB-INF/lib 是关联第三方jar的目录



## 3. Eclipse 配置Tomcat容器

1. 显示Servers界面(如果第4步的视图已经存在则跳过)：`Window` -> `Show View`—>`Servers`。

   ![img](http://ojx4zwltq.bkt.clouddn.com/17-9-16/58787267.jpg)

2. 点击 `No servers are available.Click this...`在弹出的窗口 `New Server`中找到 `Apache`—>`Tomcat v9.0 Server` 然后`Next`。

   ![img](http://ojx4zwltq.bkt.clouddn.com/17-9-16/14183577.jpg)

3. 在 `New Server`中选择 `Browse`找到Tomcat的安装(解压)目录 ，然后 `Next>` 。

   ![img](http://ojx4zwltq.bkt.clouddn.com/17-9-16/45099563.jpg)

4. 在左边选择要部署到`Tomcat`的项目，然后点击 `Add>`到右边，然后 `Finish`。

   ![img](http://ojx4zwltq.bkt.clouddn.com/17-9-16/32575429.jpg)

## 4. 访问静态页面

5. 手动在项目目录下 的web目录下新建一个 index.html文件，并编写测试内容。

   ![img](http://ojx4zwltq.bkt.clouddn.com/17-9-16/99931398.jpg)

6. 运行Web服务器。运行后会自动打开刘浏览器并在浏览器上访问`http://localhost:8080/hello`

   ![img](http://ojx4zwltq.bkt.clouddn.com/17-9-16/66246890.jpg)

7. 此时页面上会显示`index.html`页面上的内容。

   ![img](http://ojx4zwltq.bkt.clouddn.com/17-9-16/36596233.jpg)

8. 静态页面的Web已经搭建完成！

   ![img](http://ojx4zwltq.bkt.clouddn.com/17-9-16/72680993.jpg)



动态的WEB资源

			Servlet/JSP
			在服务器中有固定的目录结构
			在webapps目录下创建一个文件夹
			webDemo
				|
			WEB-INF
				|
				web.xml		必须有的（配置文件）
				classes		文件夹（编译.class文件）
				lib			文件夹（第三方jar包）


## 5. Eclipse的创建Servlet

1. 关联Servlet源码（因为Servlet源码不在 JDK中）。右键项目 `Build Path`—> `Configure Build Path…`。【也可以通过项目的属性配置找到 `Build Path` 设置界面】

   ![img](http://ojx4zwltq.bkt.clouddn.com/17-9-16/17911407.jpg)

2. 选择 `Libraries` ，然后选择右边的 `Add Library...`。

   ![img](http://ojx4zwltq.bkt.clouddn.com/17-9-16/35518055.jpg)

3. 在`Add Library` 界面中 选择 `Server Runtime`，然后 `Next>`

   ![img](http://ojx4zwltq.bkt.clouddn.com/17-9-16/47420469.jpg)

4. 选择 `Apache Tomcat v8.0`，然后 `Finish`。 一路OK下去。至此 Servlet源码关联成功！

   ![img](http://ojx4zwltq.bkt.clouddn.com/17-9-16/5544526.jpg)

5. 在`src`目录下创建`HttpServlet`子类(记得分包)，右键->`New`->`Servlet`。(也可以自己创建Class并继承HttpServlet)

   ![img](http://ojx4zwltq.bkt.clouddn.com/17-9-16/59146982.jpg)

6. 填写 `Class name` 名称(即Servlet实现类的名称)，并点击`Next`

   ![img](http://ojx4zwltq.bkt.clouddn.com/17-9-16/78543996.jpg)

7. 该页面可以配置该Servlet的名字和描述等，后期都可以更改，默认即可，直接 `Next>`

   ![img](http://ojx4zwltq.bkt.clouddn.com/17-9-16/97089617.jpg)

8. 该页面是设置创建的实现类默认生成的代码，默认即可，后期都可以修改添加，直接 `FInish`

   > 注：一般第7步和第8步默认即可，所有可以在第6步骤的时候直接点击 `Finish`！

   ![img](http://ojx4zwltq.bkt.clouddn.com/17-9-16/1195620.jpg)

9. 重写doGet和doPost方法

   ```java
   public class ServletHello extends HttpServlet {
       protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           System.out.println("Post请求");
           doGet(request, response);
       }

       protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           System.out.println("Get请求");
           PrintWriter writer = response.getWriter();
           writer.write("<H1>Hello !This is an automatically created H1 tags!</H1>");
       }
   }
   ```

10. 传统的配置方式！！！在webapp/WEB-INF/web.xml文件中进行配置。

   ![img](http://ojx4zwltq.bkt.clouddn.com/17-9-16/11876638.jpg)

11. 重新运行项目！并在浏览器中输入：`http://localhost:8080/hello/test`。则页面会接收到 Servlet动态响应的数据！

    ![img](http://ojx4zwltq.bkt.clouddn.com/17-9-16/51615309.jpg)

至此，一个Servlet应用服务器就开发完成了！



# web程序常见错误及解决方法

 在刚开始进行Web应用开发的时候，经常看见页面出现404这个数字，我们一般会称之为运行产生了404错误。类似于404这个数字，还有可能在页面上看到405、500这两个数字，他们都是服务器执行完客户端的请求以后，返回给客户端的一个关于执行结果的状态编码说明。 如果在运行结果页面中没有看到期待的页面，却看到了404、405、500这样的数字，那么代表着服务器告诉客户端运行产生了错误，掌握何种错误情况产生对应的数字将有利于问题的解决

## 404错误产生原因及解决方法

 404产生的原因为Web服务器（容器）根据请求地址找不到对应资源，以下情况都会出现404的错误提示：

- 输入的地址有误（应用名大小写不正确，名称拼写不正确）
- 在web.xml文件中和中的两个不一致
- 没有将工程部署到Tomcat的webapps下面
- Web工程部署时的结构没有遵循Servlet的规范

具体的解决办法就是根据上面提到的4种情况，逐条进行检查

## 405错误产生原因及解决方法

405这个错误的产生原因是容器找不到service方法来处理请求。以下情况容器都将视为没有找到service()方法

- service方法名写错，字母顺序不对或大小写错误
- service方法参数类型与标准不一致，或参数顺序与标准不一致。一定是先HttpServletRequest，然后是HttpServletResponse类型
- service方法异常、返回值类型与标准不一致，一定是抛出ServletException、IOException。返回值类型是void

解决405错误的方法即检查service方法是否存在，签名（方法名、参数、返回值、异常类型）是否与覆盖的父类中的方法一致

#### 容器如何找到service()方法

 当在浏览器中输入 `http://localhost:8080/test` 这个地址后，容器是如何找到 HelloServlet.class这个文件并执行的呢？  首先容器会根据路径找到位于 `web目录`(通过配置可以将web目录输出位置移到Tomcat/webapps中)下面对应的文件夹，然后根据地址中的`/test`到`web.xml`文件中寻找与之匹配的节点，找到匹配的节点后会找到与该节点紧邻的节点，获取名称并在此寻找与该名称相等的节点，找到相等的节点后，搜寻该节点下面紧邻的节点，于是获取到了与该地址相对应的类名，借助于ClassLoader(反射)加载该类文件，创建对象并调用`service()`方法，客户端即可以看到了与该地址匹配的运行结果

## 500错误产生原因及解决方法

500的错误原因是请求的Servlet在执行service方法的过程中出现了错误，程序不能继续运行了。以下情况容器都将视为500的一种情况，而返回给客户端这个错误说明。 Servlet没有继承HttpServlet或实现Servlet接口

- web.xml文件中的写错，与真正的包名类名不符
- service方法中的代码运行时抛出异常

解决500的方法为依据上面三种情况依次进行检测，逐条排除



# HTTP协议（！）

协议的甲乙双方，就是客户端（浏览器）和服务器！协议理解成双方通信的格式！

l  请求协议；

l  响应协议；

例如，在浏览器里输入www.baidu.com “回车”访问百度服务器，咱们到底将什么提交给百度服务器了呢？

然后咱们看到浏览器里面显示了百度的页面，到底百度服务器给客户端返回什么数据了呢？

示例：

启动Tomcat服务器，在浏览器中输入请求hello3的网址

期望 在IE浏览器中通过HttpWatch来查看请求和响应内容

点击之后，用工具 （fiddler 或者 charles）

来请求部署在Tomcat服务器中的hello.html

咱们期望看到的数据在哪里呢？

咱们将这个 请求数据和 返回数据 复制到 记事本中，来看看

请求数据(上）和响应数据（下）：

![](http://otgx4owbp.bkt.clouddn.com/18-1-21/79129561.jpg)

这两个数据 都是遵守 **HTTP协议**的，什么是HTTP协议呢？

### 1　HTTP协议

HTTP（Hyper Text Transport Protocol），即超文本传输协议。这个协议详细规定了浏览器和万维网服务器之间互相通信的规则

HTTP就是一个通信规则，通信规则规定了客户端发送给服务器的内容格式，也规定了服务器发送给客户端的内容格式

客户端发送给服务器的格式叫“请求协议”；服务器发送给客户端的格式叫“响应协议”

HTTP协议是**无状态协议**，浏览器和客户端连接过之后，是不会记住对方的，即 HTTP 协议占用内存少

例如，当你在浏览器里输入一个网址，回车服务器给你返回的数据， 

然后服务器和浏览器 就断开了，即 服务器和浏览器不会再交互

### 2　请求协议

请求协议是浏览器发送给服务器的内容

请求协议的格式如下：

>
>  请求首行 
>  请求头信息（多个 头名称：头值 这种形式的数据）
>
>   空行 
>   [请求体 (正文) ]
>

浏览器发送给服务器的内容就这个格式的，如果不是这个格式服务器将无法解读

在HTTP协议中，请求有很多请求方法，其中最为常用的就是GET和POST

#### 2.1　GET请求

> Servlet 中的Get 请求来自于一个 URL 的正常请求，或者来自于一个未指定 Method 的 HTML 表单，它由 doGet() 方法处理
>
> GET 方法向页面请求发送已编码的用户信息。页面和已编码的信息中间用 ? 字符分隔，如
>
> `http://www.test.com/hello?key1=value1&key2=value2`

```http
GET /hello/index.jsp HTTP/1.1 <!--请求首行，GET请求没有请求体-->
Host: localhost
User-Agent: Mozilla/5.0 (Windows NT 5.1; rv:5.0) Gecko/20100101 Firefox/5.0
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8
Accept-Language: zh-cn,zh;q=0.5
Accept-Encoding: gzip, deflate
Accept-Charset: GB2312,utf-8;q=0.7,*;q=0.7
Connection: keep-alive
Cookie: JSESSIONID=369766FDF6220F7803433C0B2DE36D98  <!--请求头，请求头由key/value组成-->
　　 <--这个位置虽然没有东西，但很重要，它是空行，如果有请求体，那么请求体在空行的下面-->
```

* GET /hello/index.jsp HTTP/1.1：GET请求，请求服务器路径为/hello/index.jsp，协议为1.1；
* Host:localhost：请求的主机名为localhost；
* User-Agent: Mozilla/5.0 (**WindowsNT 5.1**; rv:5.0) Gecko/20100101**Firefox/5.0**：与浏览器和OS相关的信息。有些网站会显示用户的系统版本和浏览器版本信息，这都是通过获取User-Agent头信息而来的；咱们知道不同的浏览器对同一个页面可能会有不同的效果（兼容性），服务器就可以通过这个值 知道客户端的浏览器品牌，然后返回页面适配的数据；
* Accept:text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8：告诉服务器，当前客户端可以接收的文档类型，其实这里包含了*/*，就表示什么都可以接收；
* Accept-Language: zh-cn,en-us;q=0.5：当前客户端支持的语言，可以在浏览器的工具选项中找到语言相关信息；

  > zh-cn,en-us  虽然有两种语言格式，但服务器只关心第一种，第一种优先级高


* Accept-Encoding: gzip, deflate：支持的压缩格式。数据在网络上传递时，可能服务器会把数据压缩后再发送（省流量，传输快）；
* Accept-Charset: GB2312,utf-8;q=0.7,*;q=0.7：客户端支持的编码；
* Connection: keep-alive：客户端支持的链接方式，保持一段时间链接，默认为3000ms；

 咱们知道HTTP协议是无状态协议，浏览器通过一个请求网址连接至服务器，服务器返回数据，然后服务器和浏览器断开；.... 咱们知道一个页面里面通常有多个网址需要请求（例如 页面中的图片需要一个单独的网址请求），让浏览器和服务器 连接一段时间，使得这个页面中的所有请求这一个连接中 进行，提升了性能。避免不必要的请求连接和断开连接。

* Cookie: JSESSIONID=369766FDF6220F7803433C0B2DE36D98：因为不是第一次访问这个地址，所以会在请求中把上一次服务器响应中发送过来的Cookie在请求中一并发送去过；这个Cookie的名字为JSESSIONID，后详述

>  上面是列出了常见的请求头，除此之外，还有很多。这些请求头，不需要可以记住，知道常见的就行了，如
>
>  * Accept-Language: zh-cn,en-us;q=0.5
>  * User-Agent:Mozilla/5.0 (**Windows NT 5.1**; rv:5.0)Gecko/20100101** Firefox/5.0**
>  * Host:localhost
>
>  **虽然GET请求没请求体，但空行不能省略**
>

#### 2.2　POST请求

> POST 请求来自于一个特别指定了 METHOD 为 POST 的 HTML 表单（单选框，复选框，下拉框），它由 doPost() 方法处理
>
> POST 方法打包信息的方式与 GET 方法基本相同，但是 POST 方法不是把信息作为 URL 中 ? 字符后的文本字符串进行发送，而是把这些信息作为一个单独的消息

常见的请求协议除了GET请求，还有POST请求

1. 新建JavaWeb工程 

2. 在WebRoot目录下 新建一个login.html 文件.目前里面不要写中文，会乱码

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
    <body>
        <form action="hello.html" method="post">

            Username:<input type="text" name="username"/><br>
            Password:<input type="text" name="password"/><br>
            <input type="submit" value="Login"/>

        </form>
    </body>
</html>
```

3. 将这个项目部署到Tomcat里面，并重启Tomcat

4. 在客户端浏览器中访问这个项目中的网页 login.html

5. 使用工具来查看点击按钮“Login”时的 请求和返回数据

输入用户名和密码，点击按钮 “Login”

![](http://otgx4owbp.bkt.clouddn.com/18-1-21/39545787.jpg)

6. 将请求数据  和响应数据  复制到一个文件中，来观察其中的细节

![](http://otgx4owbp.bkt.clouddn.com/18-1-21/53023684.jpg) 

其中，最需要关注的是

一．请求体 :username=1234&password=1234

当点击按钮时，将 表单中的用户名:username=1234 和 密码：password=1234（多组数据之间以&分隔） 提交给服务器

 

二．请求头中的

1. Referer:` http://localhost:8080/day04/login.html` 指请求来自哪个页面，例如你在百度上点击链接到了这里，那么Referer:`http://www.baidu.com`；如果你是在浏览器的地址栏中直接输入的地址，那么就没有Referer这个请求头了；

   > Referer请求头是比较有用的一个请求头，它可以用来做统计工作，也可以用来做**防盗链**
   >
   > - 统计工作：我公司网站在百度上做了广告，但不知道在百度上做广告对我们网站的访问量是否有影响，那么可以对每个请求中的Referer进行分析，如果Referer为百度的很多，那么说明用户都是通过百度找到我们公司网站的
   > - 防盗链：我公司网站上有一个下载链接，而其他网站盗链了这个地址，例如在我网站上的index.html页面中有一个链接，点击即可下载JDK7.0，但有某个人的微博中盗链了这个资源，它也有一个链接指向我们网站的JDK7.0，也就是说登录它的微博，点击链接就可以从我网站上下载JDK7.0，这导致我们网站的广告没有看，但下载的却是我网站的资源。这时可以使用Referer进行防盗链，在资源被下载之前，我们对Referer进行判断，如果请求来自本网站，那么允许下载，如果非本网站，先跳转到本网站看广告，然后再允许下载


2. Content-Type: application/x-www-form-urlencoded表单的数据类型，说明请求体的数据会使用url方式来编码

   > [url编码](http://www.ruanyifeng.com/blog/2010/02/url_encoding.html)的数据都是以`%`为前缀，后面跟随两位的16进制，例如“张三”这两个字使用UTF-8的url编码`%E4%BC%A0%E6%99%BA`

前面学过编码，知道对英文字母 不会被编码，若表单里的用户名为中文呢？

![](http://otgx4owbp.bkt.clouddn.com/18-1-21/98482305.jpg)

> 注意 Last-Modified 响应头

其中，用户名 张三，被URL编码了

```
username=%E5%BC%A0%E4%B8%89&password=1234
```

`%E5%BC%A0%E4%B8%89`是被utf-8的url方式编码，若采用gbk的url方式编码就会变成%**%**%**%**% 。（因为utf-8编码，一个汉字3个字节；gbk编码一个汉字 两个字节）

为啥要对提交给服务器的数据进行 url编码呢？早期的时候，中文在浏览器的数据传输过程中，经常出现丢失字节。若将请求体里面的中文使用url编码之后，就方便传输了

> 注意，http协议中规定超链接中不应当出现中文，若有中文，程序员应当自己手动的对齐进行url编码

### 3.响应协议

浏览器通过请求协议请求服务器之后，服务器给浏览器返回的数据是什么样的呢？

#### 3.1　响应内容

响应内容是由**服务器发送给浏览器**的内容，浏览器会根据响应内容来显示

```html
HTTP/1.1 200 OK <!-- 响应首行-->
Server: Apache-Coyote/1.1
Content-Type: text/html;charset=UTF-8
Content-Length: 724
Set-Cookie: JSESSIONID=C97E2B4C55553EAB46079A4F263435A4; Path=/hello
Date: Wed, 25 Sep 2012 04:15:03 GMT <!-- 响应头-->
<!--空行-->

<!--以下是响应体-->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="http://localhost:8080/hello/">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
<form action="" method="post">
  关键字：<input type="text" name="keyword"/>
  <input type="submit" value="提交"/>
</form>
  </body>
</html> 
<!--以上是响应体-->
```

* HTTP/1.1 200 OK：响应协议为HTTP1.1，**状态码**为200（表示请求成功），OK是对状态码的解释; 状态码（响应码）以2开头都表示成功，以3开头的都需要转移访问地址，以4开头一般是客户端错误，以5开头一般是服务器端的错误
* Server: Apache-Coyote/1.1：服务器的版本信息；
* Content-Type: text/html;charset=UTF-8：响应体的类型 和 使用的编码为UTF-8；

  > 响应正文的MIME类型，例如image/jpeg表示响应正文为jpg图片 image/gif表示响应正文 为gif图片，例如text/html;charset=utf-8表示响应正文为html，并且编码为utf-8编码(若返回内容为text，则需要指定编码。此处编码为urt-8,那这个页面中可以有中文；若编码为ISO-8859-1,则这个页面中不能出现中文 ，否则乱码)。浏览器会通过这一信息来显示响应数据


* Content-Length: 724：响应体为724字节；

* Set-Cookie: JSESSIONID=C97E2B4C55553EAB46079A4F263435A4; Path=/hello：响应给客户端的Cookie；

* Date: Wed, 25 Sep 2012 04:15:03 GMT：响应的时间，这可能会有8小时的时区差；

  > 确实存在8小时的时差， 本地时区为 GMT+8


#### 3.2　响应码

响应头对浏览器来说很重要，它说明了响应的真正含义。例如200表示响应成功了，302表示重定向，这说明浏览器需要再发一个新的请求。

* 200

  请求成功，浏览器会把响应体内容（通常是html）显示在浏览器中

* 404

  请求的地址不对，即 请求的资源没有找到，说明客户端错误的请求了不存在的资源

![](http://otgx4owbp.bkt.clouddn.com/18-1-21/18346968.jpg)

 

* 500

  请求资源找到了，但服务器内部出现了错误

  例如，服务器端中有代码会出现运行时异常，浏览器一访问这个文件 就会报出异常

* 302

  重定向，当响应码为302时，表示服务器要求浏览器重新再发一个请求，服务器会发送一个响应头Location，它指定了新请求的URL地址。各位现在只要知道重定向 这个概念就行了，后面会用代码来实现

![](http://otgx4owbp.bkt.clouddn.com/18-1-21/19599617.jpg)

 

* 304

  当用户第一次请求hello.html时，服务器会添加一个名为`Last-Modified`响应头，这个头说明了index.html的最后修改时间，浏览器会把index.html内容，以及最后响应时间缓存下来

  当用户第二次请求index.html时，在请求中包含一个名为`If-Modified-Since`请求头，它的值就是第一次请求时服务器通过`Last-Modified`响应头发送给浏览器的值，即index.html最后的修改时间，`If-Modified-Since`请求头就是在告诉服务器，我这里浏览器缓存的index.html最后修改时间是这个，您看看现在的index.html最后修改时间是不是这个，如果还是，那么您就不用再响应这个index.html内容了，我会把缓存的内容直接显示出来

  而服务器端会获取`If-Modified-Since`值，与index.html的当前最后修改时间比对，如果相同，服务器会发响应码304，表示index.html与浏览器上次缓存的相同，无需再次发送，**浏览器可以显示自己的缓存页面**，如果比对不同，那么说明index.html已经做了修改，服务器会响应200

![](http://otgx4owbp.bkt.clouddn.com/18-1-21/92411310.jpg)

 

响应头：

* Last-Modified：最后的修改时间；

请求头：

* If-Modified-Since：把上次请求的index.html的最后修改时间还给服务器；

状态码：304，比较If-Modified-Since的时间与文件真实的时间一样时，服务器会响应304，而且不会有响正文，表示浏览器缓存的就是最新版本，就会直接从浏览器缓存中获取

例如，你访问 [www.baidu.com](http://www.baidu.com)，然后浏览器显示页面这个页面 是 服务器返回给客户端浏览器的  或者  是客户端浏览器缓存的页面。

#### 3.3　其他响应头

告诉浏览器不要缓存当前的数据的响应头：

* expires: -1；           值为-1，数据立即过期

  ```
  <meta http-equiv="expires" conten="0">
  ```

* pragma: no-cache  和 cache-Control: no-cache;服务器返回给浏览器的内容中，这个参数表明不缓存这个数据

  ```
  <meta http-equiv="pragma" conten="no-cache">
  <meta http-equiv="cache-control" conten="no-cache">
  ```

  为啥要写两个呢？其中一个是适配http1.0版本，一个是兼容http1.1版本。两个都写，可以兼   容http1.0及http1.1版本


* Refresh: 3;url=http://www.baidu.com

​       自动刷新响应头，浏览器会在3秒之后请求http://www.baidu.com：

#### 3.4　HTML中指定响应头

HTTP协议中的这些响应头如何在HTML页面中模拟呢？在HTMl页面中可以使用

```
<meta http-equiv="" content="">来模拟响应头
```

例如在index.html页面中给出

```
<meta http-equiv="Refresh" content="3;url=http://www.baidu.com">
```

表示浏览器只会显示index.html页面3秒，然后自动跳转到百度
