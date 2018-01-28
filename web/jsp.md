主要学习内容：

1. JSP基础
2. Cookie
3. HttpSession



## JSP入门

#### 1.JSP概述

1.1　什么是JSP

**简单的说，JSP就是Servlet!!!**

**JSP = html +Java**脚本（代码片段） + JSP动态标签。

JSP（Java ServerPages）是JavaWeb服务器端的**动态资源**。它与html页面的作用是相同的，**显示数据和获取数据**。

JSP是运行在服务器端的文件，并最终被转为HTML，然后再客户端浏览器中执行。

jsp文件：

```
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!-- java代码的片段 -->
<%
String path = request.getContextPath();//获取项目名
/*
http://localhost:8080/day11_1/
*/
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<!-- 动态输出basePath -->
    <base href="<%=basePath%>">
    
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
  
    This is my JSP page. <br>
  
  </body>
</html>
```

```
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 定义变量 -->
<% int a = 10; %>

<!-- 打印输出 -->
<%= a %>

<%="hello world" %>

</body>
</html>
```

执行一下这个jsp文件，看效果。

代码中的

```
<%= a %>

<%="hello world" %>
```

通过在客户端浏览器中  查看网页源代码看到，动态的在输出了**basePath**。

**使用Servlet**也可以实现，但在想客户端响应页面HTML**标签的时候 **太麻烦了！！！！

也许 你会想，实现这个功能  使用Servlet 也可以啊，是的，通过参照jsp对应的servlet文件（Tomcat会将jsp转化为Servlet，路径为Tomcat的work路径下）知道 ，使用Servlet可以实现相同的功能

![](http://otgx4owbp.bkt.clouddn.com/18-1-23/37244667.jpg)



但是，Servlet响应HTML页面的使用太麻烦了，需要一行一行的out.write(...)来向客户端响应网页标签及内容。还是
**JSP **写法，更加便捷。

**使用HTML + js **

也行你这样想，js也可以让页面上的数据动态显示啊。js是前端浏览器技术，是浏览器支持的业务逻辑技术，js代码只能在浏览器中执行。当你访问服务器端的一个html资源的时候，浏览器会执行其中的js代码，如

```
<script>
       alert(window.location.href);
</script>
```

得到 路径，但是这只是客户端浏览器解析当前html资源得到的，而不是服务器根据某种情况 动态返回的。

再强调一下：js只是浏览器支持的前端技术，若期望页面的数据可以动态变化 可以通过：服务器Servlet提供数据 +  js代码来动态的展示页面，但这样还是不方便 对于Java程序员来说：

**使用jsp**技术来动态的展示页面是 终极方案！！！！

#### jsp 

1 可以写java代码，这个代码可以从数据库得到数据，这个java代码还可以写业务逻辑  

2 html+js+css+jquery.....  

3 jsp标签



刚刚说，JSP就是Servlet!

为啥要将Servlet以jsp程序的形式来展示呢？来总结一下：

前端静态文件html、服务器端资源Servlet 和 服务器端资源JSP 的优缺点：

* html：
  * 缺点：html是静态页面，不能包含动态信息
  * 优点：不用为输出html标签而发愁

注：html+js 可以让页面动起来，但这只是前端。若期望页面在不同的情况下展示不同的数据，需要通过ajax等js技术 从服务器端的servlet 拉取数据来动态的填充页面。

* Servlet：
  * 缺点：不适合设置html响应体，需要大量的response.getWriter().print("<html>")
  * 优点：动态资源，可以编程。Servlet一般在服务器端处理业务逻辑，并生产客户端所需要的数据。
* jsp(java server pages)：
  * 优点：在原有html的基础上添加java脚本，构成jsp页面。

注：Java代码在不同的情况下 可以生成不同的数据，即这个jsp页面是动态的。当客户端访问jsp资源的时候，jsp会先转化为servlet，然后servlet通过out.write(...)向客户端浏览器 想用html静态页面。****



1.2　JSP的组成.

　　JSP = html（前端的东西 css  js....） + Java脚本（代码片段） + JSP动态标签

![](http://otgx4owbp.bkt.clouddn.com/18-1-23/48382368.jpg)

#### 2.JSP语法

2.1　JSP脚本

JSP脚本 就是Java代码片段，它分为三种：

* <%...%>：Java语句，类似于Java方法体中的代码，用于定义0~N条Java语句！；
* <%=…%>：Java表达式，只是表达式！表达式的值会被输出到客户端；用于输出(常用)，用于输出一条表达式（或变量）的结果。response.getWriter().print(... );这里能放什么，它就可以放什么！
* <%!...%>：Java定义类成员，例如例如成员变量，方法等；用来创建类的成员变量和成员方法(基本不用，但容易被考到)，类体中可以放什么，它就可以放什么！这种脚本，现在很少使用了。

代码演示:

```
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<title>JSP演示</title>
  </head>
  
  <body>
    <h1>JSP演示</h1>
    <%
    	// Java语句
    	String s1 = "hello jsp";
    	// 不会输出到客户端，而是在服务器端的控制台打印
    	System.out.println(s1);
    %>

<%
  out.println(a);//输出变量
%>

  <!-- 输出到客户端浏览器上 -->
<%=a %>//输出变量

    输出变量：<%=s1 %><br/>
    输出int类型常量：<%=100 %><br/>
    输出String类型常量：<%="你好" %><br/>
    <br/>
    使用表达式输出常量是很傻的一件事，因为可以直接使用html即可，下面是输出上面的常量：<br/>
    100<br/>
你好   

<!-- 什么成员，并调用 -->
<%!
  private String hello = "world";
  public String sayHello() {
    return hello;
  }
%>
<%=sayHello()%>
  </body>
</html>
```

2.2　**内置对象**out

out对象在JSP页面中无需创建就可以使用，它的作用是用来向客户端输出。

```
 <body>
    <h1>out.jsp</h1>
	<%
		//向客户端输出
		out.print("你好！");
	%>
  </body>
```

其中<%=…%>与out.print()功能是相同的！它们都是向客户端输出，例如：

<%=s1%>等同于<% out.print(s1); %> 

<%=”hello”%>等同于<% out.print(“hello”);%>，也等同于直接在页面中写hello一样。

2.3　多个<%...%>相同的

在一个JSP中多个<%...%>是相通的。例如：

```
 <body>
    <h1>out.jsp</h1>
	<%
		String s = "hello";
	%>
	<%
		out.print(s);
	%>
  </body>
```

循环打印表格：

```
 <body>
    <h1>表格</h1>
	
	<table border="1" width="50%">
		<tr>
			<th>序号</th>
			<th>用户名</th>
			<th>密码</th>
		</tr>
	<%
		for(int i = 0; i < 10; i++) {	
	%>
		<tr>
			<td><%=i+1 %></td>
			<td>user<%=i %></td>
			<td><%=100 + 1 %></td>
		</tr>
	<%
		}
	%>
	</table>
  </body>
```

既然jsp就是servlet，那么在开发的时候，是使用jsp呢 还是使用servlet呢？这里呢，咱们先简单介绍一下，后面会经常提到。

其实，当jsp技术出现之后的 很长一段时间内，程序员就不再使用Servlet，服务器端的业务逻辑、请求数据的代码、页面html标签等 都是使用jsp 来写（都写在jsp文件中）。但后来，慢慢发现对于一些业务逻辑处理 还是使用servlet比较方便，并且能够让java代码和 html标签分割开来.....。所以，目前的java服务器端是 jsp和Servlet 各有分工。

简单的说：但凡是是展示数据的用jsp ， 业务逻辑（...数据库访问...）servlet

**jsp**和**Servlet**的分工:

* JSP：
  * 作为请求 发起页面，例如显示表单、超链接。
  * 作为请求 结束页面，例如显示数据。
* Servlet：
  * 作为请求中处理数据的环节。

###### JSP的原理

3.1　JSP是特殊的Servlet

　　JSP是一种特殊的Servlet，当JSP页面首次被访问时，容器（Tomcat）会先把JSP编译成Servlet，然后再去执行Servlet。所以JSP其实就是一个Servlet！



![](http://otgx4owbp.bkt.clouddn.com/18-1-23/9083013.jpg)







具体的流程为：

* 当jsp页面第一次被访问时，服务器会把jsp编译成java文件（这个java其实是一个servlet类）
* 然后再把java编译成.class
* 然后创建该类对象
* 最后调用它的service()方法
* 第二次请求同一jsp时，直接调用service()方法。（注：所以一个jsp“对象”是唯一的）



3.2　JSP真身存放目录

JSP生成的Servlet存放在${CATALANA}/work目录下，我经常开玩笑的说，它是JSP的“真身”。我们打开看看其中的内容，了解一下JSP的“真身”。

你会发现，在JSP中的静态信息（例如<html>等）在“真身”中都是使用out.write()完成打印！这些静态信息都是作为字符串输出给了客户端。



![](http://otgx4owbp.bkt.clouddn.com/18-1-23/45145454.jpg)





JSP的整篇内容都会放到名为_jspService的方法中！你可能会说<@page>不在“真身”中，<%@page>再讲。

a_jsp.java的_jspService()方法：

```
public void _jspService(final javax.servlet.http.HttpServletRequest request, 
final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

//jsp中共有9大内置对象，此处声明了6个。还有此方法形参中的两个request 和 response。
//还有一个内置对象，此处没有。
    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
final java.lang.Object page = this;
// 上面展示的8个对象对应着jsp的8个内置对象，即 在JSP文件中 在<%=%>和<%%>中不用创建即可使用的对象！
   
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


try {
      //对上面的变量（包括内置对象）进行赋值
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

//
//JSP页面中的内容都会在下面出现！这时上面所说的对象已经创建完了，所以在JSP页面中是可以使用的
//注：若使用Servlet，需要通过out.write(...)一行一行的向客户端响应数据，而使用jsp，jsp则会自动的帮你完成这些工作！

```



JSP的原理图（JSP转Servlet）

![](http://otgx4owbp.bkt.clouddn.com/18-1-23/87715279.jpg)

 

注：out.write 和 out.print 在此处的Servlet中其实没有区别！！！

###### 4　再论JSP脚本

JSP脚本一共三种形式：

* <%...%>：内容会直接放到“真身”中；
* <%=…%>：内容会放到out.print()中，作为out.print()的参数；
* <%!…%>：内容会放到_jspService()方法之外，被类直接包含；



前面已经讲解了<%...%>和<%=…%>，但还没有讲解<%!...%>的作用！

现在我们已经知道了，JSP其实就是一个类，一个Servlet类。<%!...%>的作用是在类中添加方法或成员的，所以<%!...%>中的内容不会出现在_jspService()中。

```
<%!
	  private String name;
	  public String hello() {
			return "hello JSP!";
	  }
%>
```

#### 5JSP注释

我们现在已经知道JSP是需要先编译成.java，再编译成.class的。其中**<%-- ...--%>**中的内容在JSP编译成.java时会被舍弃掉，即JSP注释。

也可以在JSP页面中使用**html**注释：<!-- …-->，但这个注释在JSP编译成的.java中是存在的，它不会被忽略，而且会被发送到客户端浏览器。但是在浏览器显示服务器发送过来的html时，因为<!-- …-->是html的注释，所以浏览器是不会显示它的。



![](http://otgx4owbp.bkt.clouddn.com/18-1-23/60546139.jpg)

## 会话跟踪技术

#### 1什么是会话跟踪技术

我们知道**HTTP**协议是无状态的，当客户端请求服务器 客户端和服务器建立连接，请求响应结束之后，客户端和服务器就断开连接，服务器就会完全 忘记 这个客户端。当客户端再次访问服务器的时候，这又是一次独立的访问，服务器也不会知道 这次访问的客户端和上次访问的客户端 有什么关系。即，对服务器来说，每次访问都是独立的没有关系的客户端访问。或者说，HTTP协议是无状态协议，也就是说每个请求都是独立的！无法记录前一次请求的状态。

在一个会话的多个请求中共享数据，或者说 让服务器记住之前的客户端浏览器请求，这就是会话跟踪技术。对于HTTP协议来说，可以使用cookie和session ，实现 服务器记住客户端 --  会话跟踪技术，这就是  cookie和session 经常使用的场景。cookie和session 是将要学习的重点内容。

例如在一个会话中的请求如下：

1. 请求银行主页；

2. 请求登录（请求参数是用户名和密码）；

3. 请求转账（请求参数与转账相关的数据）；

4. 请求信誉卡还款（请求参数与还款相关的数据）。


在这上会话中当前用户信息必须在这个会话中共享的，因为登录的是张三，那么在转账和还款时一定是相对张三的转账和还款！这就说明我们必须在一个会话过程中有共享数据的能力。

 

#### 2会话路径技术使用Cookie和session完成

我们知道HTTP协议是无状态协议，也就是说每个请求都是独立的！无法记录前一次请求的状态。

HTTP协议支持**Cookie**技术，即 HTTP协议的网络交互中可以使用Cookie来协助会话跟踪（会话标识可以存储在客户端浏览器中）！ --- Cookie是HTTP协议支持的技术，在Java语言、js语言、php语言等编程中 ，对于HTTP网络交互 都可以使用Cookie技术。注：Cookie是浏览器的存储小数据的技术 或者 浏览器存储小数据的文件。

而要实现会话跟踪，一般还需要服务器端为每一个会话生成“唯一标识”，例如

对于JavaWeb项目来说，具体是使用session在服务器端为每一个会话生成“会话标识”来完成会话跟踪，其中对于session的ID保存在客户端这个过程则是经常是依赖客户端浏览器的Cookie技术。所以，也会说，对于Javaweb项目实现回话跟踪 可以通过session依赖cookie 来实现。



## Cookie

### 1Cookie概述

#### 1.1　什么叫Cookie

Cookie翻译成中文是**小甜点，小饼干**的意思。、

Cookie翻译成中文是小甜点，小饼干的意思。

Cookie 是网站用来在客户端保存识别用户的一种小文件。一般用Cookie可以保存用户登录信息、购物数据信息等一系列微小信息。为啥用cookie呢？对于网站，有时咱们需要将一些用户登录信息、购物信息等保存在客户端来实现某种功能，这种保存时一种较为 持久的保存，如这些数据保存在本地的一个文件中。我们知道 网页是无法操作本地磁盘的，也就是说 网页是无法直接将自己的信息保存在本地，若需要这种功能 你就可以使用Cookie技术将数据保存在本地磁盘，实现一些小数据的 较为持久的保存。

Cookie是HTTP协议支持的技术。在HTTP中，它表示服务器送给客户端浏览器的小数据，并且这个小数据会保存在客户端浏览器中。其实Cookie就是一个键和一个值构成的，随着服务器端的响应发送给客户端浏览器。然后客户端浏览器会把Cookie保存起来，当下一次再访问服务器时把Cookie、再发送给服务器。

![](http://otgx4owbp.bkt.clouddn.com/18-1-23/46386680.jpg)

服务器创建标识用户（这个通常是服务器端的Session技术来完成）的键值对（通常值为SessionId）。这个键值对，在发送给客户端的时候 会被标识为Cookie，再通过响应发送给客户端。这个被标识为Cookie的小数据 是HTTP协议支持的，所以此时若客户端浏览器没有禁用Cookie则会自动通过Cookie技术将这个键值对存储在客户端浏览器中，并标明其来时哪个服务器。

　 当客户端向服务器发出请求时会把所有这个服务器Cookie包含在请求中发送给服务器，这样服务器就可以识别客户端了！



####1.2 Cookie规范

* Cookie大小上限为4KB；
* 一个服务器最多在客户端浏览器上保存20个Cookie；
* 一个浏览器最多保存300个Cookie； 

上面的数据只是HTTP的Cookie规范，但在浏览器大战的今天，一些浏览器为了打败对手，为了展现自己的能力起见，可能对Cookie规范“扩展”了一些，例如每个Cookie的大小为8KB，最多可保存500个Cookie等！但也不会出现把你硬盘占满的可能！

注意，不同浏览器之间是不共享Cookie的。也就是说在你使用IE访问服务器时，服务器会把Cookie发给IE，然后由IE保存起来，当你在使用FireFox访问服务器时，不可能把IE保存的Cookie发送给服务器。

#### 1.3 Cookie与HTTP头 

Cookie是通过HTTP请求和响应头在客户端

端和服务器端传递的：

*  Cookie：请求头，客户端发送给服务器端；

  * 格式：Cookie: a=A; b=B; c=C。即多个Cookie用分号离开；

*  Set-Cookie：响应头，服务器端发送给客户端；

  * 一个Cookie对象一个Set-Cookie：

    Set-Cookie: a=A

    Set-Cookie: b=B

    Set-Cookie: c=C

####1.4Cookie的覆盖

　　如果服务器端发送重复的Cookie那么会覆盖原有的Cookie，例如客户端的第一个请求服务器端发送的Cookie是：Set-Cookie: a=A；第二请求服务器端发送的是：Set-Cookie: a=AA，那么客户端只留下一个Cookie，即：a=AA。

  

Cookie示例（Servlet）

服务端ServletA将一个键值对 以Cookie的形式响应给客户端，客户端存储在本地，然后再访问ServletB，ServletB得到请求中的所有Cookie ，并在控制台打印出来。

我们这个案例是，客户端访问AServlet，AServlet在响应中添加Cookie，浏览器会自动保存Cookie。然后客户端访问BServlet，这时浏览器会自动在请求中带上Cookie，BServlet获取请求中的Cookie打印出来。

![](http://otgx4owbp.bkt.clouddn.com/18-1-23/62849288.jpg)



**注：**

**使用repsonse.addCookie()**方法向浏览器保存Cookie

**使用request.getCookies()**方法获取浏览器归还的Cookie

代码实现:

AServlet.java

```
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 给客户端发送Cookie
 * @author Administrator
 *
 */
public class AServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		String id = UUID.randomUUID().toString();//生成一个随机字符串
		Cookie cookie = new Cookie("id", id);//创建Cookie对象，指定名字和值
		response.addCookie(cookie);//在响应中添加Cookie对象
		response.getWriter().print("已经给你发送了ID");
	}
}
```

BServlet.java

```
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 获取客户端请求中的Cookie
 * @author Administrator
 *
 */
public class BServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		Cookie[] cs = request.getCookies();//获取请求中的Cookie
		if(cs != null) {//如果请求中存在Cookie
			for(Cookie c : cs) {//遍历所有Cookie
				if(c.getName().equals("id")) {//获取Cookie名字，如果Cookie名字是id
					response.getWriter().print("您的ID是：" + c.getValue());//打印Cookie值
				}
			}
		}
	}
}
```

Cookie示例（jsp）

客户端浏览器首先访问a.jsp，a.jsp向客户端浏览器以Cookie形式返回键值对。客户端保存在本地。然后客户端浏览器再访问b.jsp，同时将客户端的Cookie携带至服务器的b.jsp。

注：Cookie是不能跨浏览器的，若通过IE浏览器访问a.jsp，再通过火狐浏览器访问b.jsp，则b.jsp是无法的到之前返回的Cooike.

1. 首先在WebRoot目录下创建一个文件夹 用于保存jsp资源

然后在这个目录下 创建一个a.jsp 和 b.jsp

2. 当客户端浏览器访问a.jsp会向客户端发送Cookie形式的数据

```
<h1>jsp保存cookie</h1>

	<%
		Cookie c1 = new Cookie("aa", "AAA");
		response.addCookie(c1);

		Cookie c2 = new Cookie("bb", "BBB");
		response.addCookie(c2);		
	%>
```



3. 客户端使用同一浏览器再访问b.jsp的时候 可以得到 a.jsp响应的cookie形式的数据

```
 <h1>获取cookie的值</h1>  
   <%
      Cookie [] arr = request.getCookies();      
   
      for(Cookie c : arr){
    	  
    	  if(c != null ){  
    		  out.write(c.getName() + " " +  c.getValue() + "<br/>");
    	  }
      }
   %>
```

4. 在这里得到的Cookie 除了a.jsp响应的值，还有Tomcat响应的Cookie形式的值

首先请求a.jsp，并检测请求值和返回值

服务器是通过Cookie形式将aaa=AAA 和 bbb=BBB 响应给客户端的，客户端拿到这些Cookie形式的数据后，会保存在客户端本地。

当次客户端再次请求b.jsp的时候，会将这些Cookie形式的数据再提交给服务器b.jsp

看到页面显示出了 所有的Cookie。即，b.jsp获取了当次请求中的所有Cookie值。

###2 Cookie的生命

####2.1　什么是Cookie的生命

　　Cookie不只是有name和value，Cookie还是生命。所谓生命就是Cookie在客户端的有效时间（或者说 在客户端磁盘上的保存时间），可以通过setMaxAge(int)来设置Cookie的有效时间。以秒为单位，例如：cookie.setMaxAge(60)表示这个Cookie会被浏览器保存到硬盘上60秒。

* cookie.setMaxAge(-1)：cookie的maxAge属性的默认值就是-1，表示只在浏览器内存中存活。一旦关闭浏览器窗口，那么cookie就会消失。

Cookie只在浏览器内存中存在，当用户关闭浏览器时，浏览器进程结束，同时Cookie也就死亡了

* cookie.setMaxAge(60*60)：表示cookie对象可存活1小时。当生命大于0时，浏览器会把Cookie保存到硬盘上，就算关闭浏览器，就算重启客户端电脑，cookie也会存活1小时；maxAge>0：浏览器会把Cookie保存到客户机硬盘上，有效时长为maxAge的值决定



* cookie.setMaxAge(0)：cookie生命等于0是一个特殊的值，它表示cookie被作废！也就是说，如果原来浏览器已经保存了这个Cookie，那么可以通过Cookie的setMaxAge(0)来删除这个Cookie。无论是在浏览器内存中，还是在客户端硬盘上都会删除这个Cookie。 



示例：显示上次访问时间

* 创建Cookie，名为lasttime，值为当前时间，添加到response中；
* 在AServlet中获取请求中名为lasttime的Cookie；
* 如果不存在输出“您是第一次访问本站”，如果存在输出“您上一次访问本站的时间是xxx”；

```
public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
        //创建Cookie对象，名为lasttime，值为当前时间
		Cookie cookie = new Cookie("lasttime", new Date().toString());
		//设置Cookie在客户端的有效时间为1小时
         cookie.setMaxAge(60 * 60);
         //添加Cookie到response中
		response.addCookie(cookie);
		
        //获取请求中的Cookie
		Cookie[] cs = request.getCookies();
		String s = "您是首次访问本站！";
		if(cs != null) {//如果请求中存在Cookie
			for(Cookie c : cs) {//循环遍历请求中的Cookie
                //如果Cookie名为lasttime
				if(c.getName().equals("lasttime")) {
					s = "您上次的访问时间是：" + c.getValue();
				}
			}
		}
		//打印s到客户端
		response.getWriter().print(s);
	}
```

### 3 Cookie的path

####3.1什么是Cookie的路径

现在有WEB应用A，向客户端发送了10个Cookie，这就说明客户端无论访问应用A的哪个Servlet都会把这10个Cookie包含在请求中！

但是也许只有AServlet需要读取请求中的Cookie，而其他Servlet根本就不会获取请求中的Cookie。这说明客户端浏览器有时发送这些Cookie是多余的！或者，访问AServlet需要发送acookie，访问BServlet需要发送bcookie，而其他的cookie不发送。怎样才能实现？

可以通过设置Cookie的path来指定浏览器，在访问什么样的路径时，包含什么样的Cookie。

* Cookie的path并不是设置这个Cookie在客户端的保存路径！！！
* Cookie的path由服务器创建Cookie时设置。
* 当浏览器访问服务器某个路径时，需要归还哪些Cookie给服务器呢？这由Cookie的path决定。
* 浏览器访问服务器的路径，如果包含某个Cookie的路径，那么就会归还这个Cookie。

#### 3.2Cookie路径与请求路径的关系

下面我们来看看Cookie路径的作用：

**注：**

**服务器设置Cookie**的路径需要使用setPath()方法，例如：

**cookie.setPath(“/cookietest/servlet”);**

下面是客户端浏览器保存Cookie的3个路径：

**a:**/cookietest；

即服务器在响应Cookie形式的数据时，设置

cookie.setPath(“/cookietest”);

**b:**　/cookietest/servlet；

即服务器在响应Cookie形式的数据时，设置

cookie.setPath(“/cookietest/servlet”); 

**c:**　/cookietest/jsp；

即服务器在响应Cookie形式的数据时，设置

cookie.setPath(“/cookietest/jsp”);

下面是浏览器请求的URL：

A:　http://localhost:8080/cookietest/AServlet；

B:　http://localhost:8080/cookietest/servlet/BServlet；

C:　http://localhost:8080/cookietest/jsp/CServlet；

* 请求A时，会在请求中包含a；
* 请求B时，会在请求中包含a、b；
* 请求C时，会在请求中包含a、c；

也就是说，请求路径如果包含了Cookie路径，那么会在请求中包含这个Cookie，否则不会请求中不会包含这个Cookie。

* A请求的URL包含了“/cookietest”，所以会在请求中包含路径为“/cookietest”的Cookie；
* B请求的URL包含了“/cookietest”，以及“/cookietest/servlet”，所以请求中包含路径为“/cookietest”和“/cookietest/servlet”两个Cookie；
* C请求的URL包含了“/cookietest”，以及“/cookietest/jsp”，所以请求中包含路径为“/cookietest”和“/cookietest/jsp”两个Cookie；



####3.3设置Cookie的路径

设置Cookie的路径需要使用setPath()方法，例如：

cookie.setPath(“/cookietest/servlet”); 

如果没有设置Cookie的路径，那么Cookie路径的默认值当前访问资源所在路径，例如：

* 访问http://localhost:8080/cookietest/AServlet时添加的Cookie默认路径为/cookietest；
* 访问http://localhost:8080/cookietest/servlet/BServlet时添加的Cookie默认路径为/cookietest/servlet；
* 访问http://localhost:8080/cookietest/jsp/BServlet时添加的Cookie默认路径为/cookietest/jsp；



#### 4Cookie的domain（了解）

**Cookie**的domain属性可以让网站中二级域共享Cookie，次要！

百度你是了解的对吧！

http://www.baidu.com

http://zhidao.baidu.com

http://news.baidu.com

现在我希望在这些主机之间共享Cookie（例如在www.baidu.com中响应的cookie，可以在news.baidu.com请求中包含）。很明显，现在不是路径的问题了，而是主机的问题，即域名的问题。处理这一问题其实很简单，只需要下面两步：

* 设置Cookie的path为“/”：c.setPath(“/”)；
* 设置Cookie的domain为“.baidu.com”：c.setDomain(“.baidu.com”)。

 当domain为“.baidu.com”时，无论前缀是什么，都会共享Cookie的。但是现在我们需要设置两个虚拟主机：www.baidu.com和news.baidu.com。

第一步：设置windows的DNS路径解析

找到C:\WINDOWS\system32\drivers\etc\hosts文件，添加如下内容

```
127.0.0.1       localhost
127.0.0.1       www.baidu.com
127.0.0.1       news.baidu.com
```

第二步：设置Tomcat虚拟主机

找到server.xml文件，添加<Host>元素，内容如下：

```
   <Host name="www.baidu.com"  appBase="F:\webapps\www"
            unpackWARs="true" autoDeploy="true"
            xmlValidation="false" xmlNamespaceAware="false"/>
   <Host name="news.baidu.com"  appBase="F:\webapps\news"
            unpackWARs="true" autoDeploy="true"
            xmlValidation="false" xmlNamespaceAware="false"/>
```

第三步：创建A项目，创建AServlet，设置Cookie。

```
Cookie c = new Cookie("id", "baidu");
c.setPath("/");
c.setDomain(".baidu.com");
c.setMaxAge(60*60);
response.addCookie(c);
response.getWriter().print("OK");
```

把A项目的WebRoot目录复制到F:\webapps\www目录下，并把WebRoot目录的名字修改为ROOT。

第四步：创建B项目，创建BServlet，获取Cookie，并打印出来。

```
Cookie[] cs = request.getCookies();
		if(cs != null) {
			for(Cookie c : cs) {
				String s = c.getName() + ": " + c.getValue() + "<br/>";
				response.getWriter().print(s);
			}
}
```

把B项目的WebRoot目录复制到F:\webapps\news目录下，并把WebRoot目录的名字修改为ROOT。

第五步：访问www.baidu.com\AServlet，然后再访问news.baidu.com\BServlet。

 #### 5 Cookie中保存中文

Cookie的name和value都不能使用中文，如果希望在Cookie中使用中文，那么需要先对中文进行URL编码，然后把编码后的字符串放到Cookie中。

向客户端响应中添加Cookie

```
//使用URL编码
String name = URLEncoder.encode("姓名", "UTF-8");
String value = URLEncoder.encode("张三", "UTF-8");
//编码后的字符串保存到Cookie中
Cookie c = new Cookie(name, value);
c.setMaxAge(3600);
response.addCookie(c);
```

从客户端请求中获取Cookie

```
response.setContentType("text/html;charset=utf-8");
		Cookie[] cs = request.getCookies();
		if(cs != null) {
			for(Cookie c : cs) {
                 //把Cookie的name和value使用URL解码后再打印
				String name = URLDecoder.decode(c.getName(), "UTF-8");
				String value = URLDecoder.decode(c.getValue(), "UTF-8");
				String s = name + ": " + value + "<br/>";
				response.getWriter().print(s);
		}
}
```

#### 6显示曾经浏览过的商品

index.jsp

```
<body>
    <h1>商品列表</h1>
    <a href="/day03/GoodServlet?name=ThinkPad">ThinkPad</a><br/>
    <a href="/day03/GoodServlet?name=Lenovo">Lenovo</a><br/>
    <a href="/day03/GoodServlet?name=Apple">Apple</a><br/>
    <a href="/day03/GoodServlet?name=HP">HP</a><br/>
    <a href="/day03/GoodServlet?name=SONY">SONY</a><br/>
    <a href="/day03/GoodServlet?name=ACER">ACER</a><br/>
    <a href="/day03/GoodServlet?name=DELL">DELL</a><br/>
    
    <hr/>
    您浏览过的商品：
    <%
    	Cookie[] cs = request.getCookies();
    	if(cs != null) {
    		for(Cookie c : cs) {
    			if(c.getName().equals("goods")) {
    				out.print(c.getValue());
    			}
    		}
    	}
    %>
  </body>
```

GoodServlet

```
public class GoodServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String goodName = request.getParameter("name");
		String goods = CookieUtils.getCookValue(request, "goods");
		
		if(goods != null) {
			String[] arr = goods.split(", ");
			Set<String> goodSet = new LinkedHashSet(Arrays.asList(arr));
			goodSet.add(goodName);
			goods = goodSet.toString();
			goods = goods.substring(1, goods.length() - 1);
		} else {
			goods = goodName;
		}
		Cookie cookie = new Cookie("goods", goods);
		cookie.setMaxAge(1 * 60 * 60 * 24);
		response.addCookie(cookie);
		
		response.sendRedirect("/day/index.jsp");
	}
}
```

CookieUtils

```
public class CookieUtils {
	public static String getCookValue(HttpServletRequest request, String name) {
		Cookie[] cs = request.getCookies();
		if(cs == null) {
			return null;
		}
		for(Cookie c : cs) {
			if(c.getName().equals(name)) {
				return c.getValue();
			}
		}
		return null;
	}
}
```



## HttpSession

在正式学习Session之前，来温习一下 之前学习Cookie时，总结的一些内容，如下：

**会话跟踪技术**

**1**什么是会话跟踪技术

我们知道HTTP协议是无状态的，当客户端请求服务器 客户端和服务器建立连接，请求响应结束之后，客户端和服务器 就断开连接，服务器就会完全忘记 这个客户端。当客户端再次访问服务器的时候，这又是一次独立的访问，服务器也不会知道这次访问的客户端和上次访问的客户端 有什么关系。即，对服务器来说，每次访问都是独立的没有关系的客户端访问。或者说，HTTP协议是无状态协议，也就是说每个请求都是独立的！无法记录前一次请求的状态。

在一个会话的多个请求中共享数据，或者说让服务器记住之前的客户端浏览器请求，这就是会话跟踪技术。对于HTTP协议来说，可以使用cookie和session ，实现 服务器记住客户端，这就是  cookie和session 经常使用的场景。cookie和session 是将要学习的重点内容。

例如在一个会话中的请求如下：

* 请求银行主页；
* 请求登录（请求参数是用户名和密码）；
* 请求转账（请求参数与转账相关的数据）；
* 请求信誉卡还款（请求参数与还款相关的数据）。 

在这上会话中当前用户信息必须在这个会话中共享的，因为登录的是张三，那么在转账和还款时一定是相对张三的转账和还款！这就说明我们必须在一个会话过程中有共享数据的能力。



**2**会话路径技术使用Cookie或session完成

我们知道HTTP协议是无状态协议，也就是说每个请求都是独立的！无法记录前一次请求的状态。

HTTP协议的支持Cookie技术，即 HTTP协议的网络交互中可以使用Cookie来协助会话跟踪（会话标识可以存储在客户端浏览器中）！ --- **Cookie**是HTTP协议支持的技术，在Java语言、js语言、php语言等编程中，对于HTTP网络交互 都可以使用Cookie技术。注：Cookie只是客户端的存储小数据的技术。

而要实现回话跟踪，一般还需要服务器端为每一个会话生成“唯一标识”，例如

对于JavaWeb项目来说，具体是使用session在服务器端为每一个会话生成“会话标识”来完成会话跟踪，其中对于session的ID保存在客户端这个过程则是经常是依赖客户端浏览器的Cookie技术。所以，也会说，对于Javaweb项目实现回话跟踪 可以通过session依赖cookie 来实现。**---Session**是JavaWeb提供的，是JavaWeb中特有的，其他编程语言中没有，Session不是HTTP协议中定义的。

 

简单的说，在服务器端的session可以为每个会话生成一个“会话标识”，这个会话标识的ID会返回给客户端，客户端使用Cookie技术来将“会话标识”的ID存储在客户端浏览器中，当客户端再访问同一个会话中的服务器，会将这个“会话标识”的ID上传给服务器，服务器通过这个“会话标识”来辨识当次客户端请求的身份。

即 Session是用于生产服务器端的“会话标识”，Cookie是在客户端存储“会话标识”的ID。这两者 合在一起 实现 HTTP协议的网络交互会话跟踪技术。

注：浏览器可以设置禁用Cookie，这时 服务器端的Session的ID就无法存储在客户端了，但 可以通过URL重新来实现 会话跟踪。即 对于JavaWeb项目，实现会话跟踪 可以通过：

1.HttpSession+ Cookie

2.HttpSession+ URL重写（后面会介绍）

在JavaWeb中经常使用的是HttpSession。

### 1.HttpSession概述

####1.1什么是HttpSesssion

javax.servlet.http.HttpSession是由JavaWeb提供的，用来会话跟踪的类。session是服务器端对象，保存在服务器端！！！

HttpSession接口表示一个会话，我们可以把一个会话内需要共享的数据保存到HttSession对象中！

会话：一个用户对服务器的多次连贯性请求！所谓连贯性请求，就是该用户多次请求中间没有关闭浏览器！

会话范围：会话范围是某个用户从首次访问服务器开始，到该用户关闭浏览器结束！



#### 1.2获取HttpSession对象

* HttpSession request.getSesssion()：如果当前会话已经有了session对象那么直接返回，如果当前会话还不存在会话，那么创建session并返回；

* HttpSession request.getSession(boolean)：当参数为true时，与requeset.getSession()相同。如果参数为false，那么如果当前会话中存在session则返回，不存在返回null；


####1.3HttpSession是域对象

我们已经学习过**HttpServletRequest**、**ServletContext**，它们都是域对象，现在我们又学习了一个**HttpSession**，它也是域对象。它们是Servlet的三大域对象。

* HttpServletRequest：一个请求创建一个request对象，所以在同一个请求中可以共享request，例如一个请求从AServlet转发到BServlet，那么AServlet和BServlet可以共享request域中的数据；
* ServletContext：一个应用只创建一个ServletContext对象，所以在ServletContext中的数据可以在整个应用中共享，只要不启动服务器，那么ServletContext中的数据就可以共享；
* HttpSession：一个会话创建一个HttpSession对象，同一会话中的多个请求中可以共享session中的数据；



HttpSession和HttpServletRequest、ServletContext 一样 有着如下域方法：

* void setAttribute(String name, Object value)：用来存储一个对象，也可以称之为存储一个域属性，例如：session.setAttribute(“xxx”,“XXX”)，在session中保存了一个域属性，域属性名称为xxx，域属性的值为XXX。请注意，如果多次调用该方法，并且使用相同的name，那么会覆盖上一次的值，这一特性与Map相同；
* Object getAttribute(String name)：用来获取session中的数据，当前在获取之前需要先去存储才行，例如：String value = (String) session.getAttribute(“xxx”);，获取名为xxx的域属性；
* void removeAttribute(String name)：用来移除HttpSession中的域属性，如果参数name指定的域属性不存在，那么本方法什么都不做；
* Enumeration getAttributeNames()：获取所有域属性的名称；



###2  示例　

####2.1 演示session中会话的多次请求中共享数据

​    AServlet：向session域中保存数据

​    BServlet：从session域中获取数据

   演示：

第一个请求：访问AServlet

第二个请求：访问BServlet

 

若Servlet需要展示页面内容的话，使用JSP更加方便。那咱们就不使用Servlet，改用jsp。

新建一个JavaWeb工程，在WebRoot目录下新建session1目录，其目录下再创建a.jsp(向session域中保存数据)，b.jsp(从session域中获取数据)。



#### 2.2登录案例

需要的页面：

* login.jsp：登录页面，提供登录表单；
* index1.jsp：主页，显示当前用户名称，如果没有登录，显示您还没登录；
* index2.jsp：主页，显示当前用户名称，如果没有登录，显示您还没登录；

Servlet：

* LoginServlet：在login.jsp页面提交表单时，请求本Servlet。在本Servlet中获取用户名、密码进行校验，如果用户名、密码错误，显示“用户名或密码错误”，如果正确保存用户名session中，然后重定向到index1.jsp；



　　当用户没有登录时访问index1.jsp或index2.jsp，显示“您还没有登录”。如果用户在login.jsp登录成功后到达index1.jsp页面会显示当前用户名，而且不用再次登录去访问index2.jsp也会显示用户名。因为多次请求在一个会话范围，index1.jsp和index2.jsp都会到session中获取用户名，session对象在一个会话中是相同的，所以都可以获取到用户名！



login.jsp

```
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>login.jsp</title>
  </head>
  
  <body>
    <h1>login.jsp</h1>
    <hr/>
    <form action="/day06_4/LoginServlet" method="post">
    	用户名：<input type="text" name="username" /><br/>
        <input type="submit" value="Submit"/>
    </form>
  </body>
</html>
```

index1.jsp

```
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>index1.jsp</title>
  </head>
  
  <body>
<h1>index1.jsp</h1>
<%
    //在JSP页面中可以直接使用session不用创建。使用session获取用户名，如果没有用户名说明还没有登录
	String username = (String)session.getAttribute("username");
	if(username == null) {
        //如果session中没有username，说明还没有登录
		out.print("您还没有登录！");
	} else {
        //如果session中存在username，那么输出用户名
		out.print("用户名：" + username);
	}
%>
<hr/>
<a href="/day06_4/index2.jsp">index2</a>
  </body>
</html>
```

index2.jsp

```
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>index2.jsp</title>
  </head>
  
  <body>
<h1>index2.jsp</h1>
<%
	String username = (String)session.getAttribute("username");
	if(username == null) {
		out.print("您还没有登录！");
	} else {
		out.print("用户名：" + username);
	}
%>
<hr/>
<a href="/day06_4/index1.jsp">index1</a>
  </body>
</html>
```

LoginServlet

```
public class LoginServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
        //获取表单参数username
		String username = request.getParameter("username");
		
        //如果用户为itcast表示登录失败
		if(username.equalsIgnoreCase("scott")) {
			response.getWriter().print("用户名或密码错误！");
		} else {
            //获取session对象
			HttpSession session = request.getSession();
            //在session中保存用户名
			session.setAttribute("username", username);
            //重定向到index1.jsp。
			response.sendRedirect("/day06_4/index1.jsp");
            //因为在一个会话范围内，所以index1.jsp中的session能够 获取上面一行代码
            //session.setAttribute("username", username);
            //保存的在session中的username的值。
		}
	}
}
```



2.3 ：演示保存用户登录信息

  相关页面login.jsp和LoginServlet：

   **login.jsp**：登录页面，提供登陆表单,表单数据提交给LoginServlet(处理登陆的服务器端验证业务)

   LoginServlet：校验用户是否登录成功！

​      获取请求参数，校验用户是否登录成功

​       失败：保存错误信息到request域，转发到login.jsp(login.jsp显示request域中的错误信息)，让展示错误信息的login.jsp来响应客户端请求。

​        注：错误信息是保存到request域中，没必要保存至session和servletContext域中，这样擅自扩大      了数据的存在时间，浪费内存。

​        成功：保存用户信息到session域中，重定向到succ1.jsp页面，显示session域中的用户信息。



**succ1.jsp**：只有登录成功才能访问的页面01，并从session域获取用户信息并在页面上显示。如果从session域获取用户信息，不存在，显示“您还没有登录”。

还有一种情况，如果直接在浏览器地址中访问succ1.jsp，并且你没有登陆（session中没有用户信息），则重定向到login.jsp中。

**succ2.jsp**：只有登录成功才能访问的页面02，并从session域获取用户信息并在页面上显示。如果从session域获取用户信息，不存在，显示“您还没有登录”。

还有一种情况，如果直接在浏览器地址中访问succ1.jsp，并且你没有登陆（session中没有用户信息），则重定向到login.jsp中。

（有些页面是只能登陆成功后，才可以访问，这样的页面有N个，此处列举出两个登陆之后可以访问的页面succ1.jsp 、 succ2.jsp）

   只要用户没有关闭浏览器，存储在客户端浏览器中的sessionID就一直存在，同时保证存储在服务器端的保存用户信息的session没有被消亡，那么用户访问succ1和succ2就会通过！



![](http://otgx4owbp.bkt.clouddn.com/18-1-23/28621999.jpg)

这个业务流程 只是在演示Session是一个域对象，可以共享数据。而不是真实的登陆模块的业务逻辑。所以，各位在思考这个练习的业务流程的时候，不要脑海中去参照登陆网站 时，我们操作的那个流程。

新建一个JavaWeb项目，并在webRoot目录下 新建文件夹session2，并在这个目录下创建 login.jsp、succ1.jsp和succ2.jsp，并在src目录新建一个LoginServlet



### 3 session的实现原理

session底层是依赖Cookie的！我们来理解一下session的原理吧！

举一个生活中的示例：

银行是无法记住哪个客户是哪个客户的，也就是说银行和客户之间是 无状态的。当客户端今天去银行办理了业务之后，明天这个客户再去银行银行是无法记住这个客户是谁的。银行为了记住客户，会为每个客户端 办理 银行卡，银行通过卡号在数据库中查询可以知道这个客户是谁。

第一次去银行办理业务，银行会给你办理一张银行卡，你的个人信息和存款等信息存储在银行的服务器中 并且和这个银行卡的卡号绑定在一起。

你会将银行卡随身携带离开银行。

过几天，你再来到银行，你会将银行卡交给银行柜台，银行通过这个银行卡的卡号 能够查询到你的信息，就知道你是谁了。

........

银行是通过这个银行卡号来辨识用户的。银行将用户的信息存储在服务器，并和银行卡号绑定在一起。

 

对于JavaWeb的服务器端和浏览器客户端的交互原理同上。

HTTP协议是无状态协议。JavaWeb服务器是无法记录客户端浏览器的身份的。若需要实现回话跟踪，也需要使用一个标识。

当客户端浏览器首次访问服务器端的时候，并且当服务器首次使用session 此时要创建session，session是保存在服务器端（这个Session中可以保存一些数据）。然后，响应客户端浏览器的时候，会将这个Session的ID以Cookie的形式返回给客户端浏览器，这个SessionID在客户端就以Cookie的形式保存了。

当客户端再次访问服务器时，在请求中会带上sessionId，而服务器会通过sessionId找到对应的session，而无需再创建新的session。这样，服务器就辨识出了哪个客户端回话了。

依次类推.....

![](http://otgx4owbp.bkt.clouddn.com/18-1-23/79853995.jpg)



###### 4　session与浏览器

session保存在服务器，而sessionId通过Cookie发送给客户端，但这个Cookie的生命不-1，即只在浏览器内存中存在，也就是说如果用户关闭了浏览器，那么这个Cookie就丢失了。

当用户再次打开浏览器访问服务器时，就不会有sessionId发送给服务器，那么服务器会认为你没有session，所以服务器会创建一个session，并在响应中把sessionId中到Cookie中发送给客户端。　　　　　

你可能会说，那原来的session对象会怎样？当一个session长时间没人使用的话，服务器会把session删除了！这个时长在Tomcat中配置是30分钟，可以在${CATALANA}/conf/web.xml找到这个配置，当然你也可以在自己的web.xml中覆盖这个配置！

web.xml

```
 <session-config>
        <session-timeout>30</session-timeout>
 </session-config>
```

session失效时间也说明一个问题！如果你打开网站的一个页面开始长时间不动，超出了30分钟后，再去点击链接或提交表单时你会发现，你的session已经丢失了！

#### 5 session其他常用API

* String getId()：获取sessionId；
* int getMaxInactiveInterval()：获取session可以的最大不活动时间（秒），默认为30分钟。当session在30分钟内没有使用，那么Tomcat会在session池中移除这个session；
* void setMaxInactiveInterval(int interval)：设置session允许的最大不活动时间（秒），如果设置为1秒，那么只要session在1秒内不被使用，那么session就会被移除；
* long getCreationTime()：返回session的创建时间，返回值为当前时间的毫秒值；
* long getLastAccessedTime()：返回session的最后活动时间，返回值为当前时间的毫秒值；
* void invalidate()：让session失效！调用这个方法会被session失效，当session失效后，客户端再次请求，服务器会给客户端创建一个新的session，并在响应中给客户端新session的sessionId；
* boolean isNew()：查看session是否为新。当客户端第一次请求时，服务器为客户端创建session，但这时服务器还没有响应客户端，也就是还没有把sessionId响应给客户端时，这时session的状态为新。

```
public void doGet(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {
 
         response.setContentType("text/html;charset=UTF-8");
         //使用request对象的getSession()获取session，如果session不存在则创建一个
         HttpSession session = request.getSession();
         //获取session的Id
         String sessionId = session.getId();
         //判断session是不是新创建的
         if (session.isNew()) {
             response.getWriter().print("session创建成功，session的id是："+sessionId);
         }else {
             response.getWriter().print("服务器已经存在该session了，session的id是："+sessionId);
         }
     }
```



 #### 6URL重写

我们知道session依赖Cookie，那么session为什么依赖Cookie呢？因为服务器需要在每次请求中获取sessionId，然后找到客户端的session对象。那么如果客户端浏览器关闭了Cookie呢？那么session是不是就会不存在了呢？

其实还有一种方法让服务器收到的每个请求中都带有sessioinId，那就是URL重写！在每个页面中的每个链接和表单中都添加名为jSessionId的参数，值为当前sessionid。当用户点击链接或提交表单时也服务器可以通过获取jSessionId这个参数来得到客户端的sessionId，找到sessoin对象。

```
 <body>
      <h1>URL重写</h1>
      <a href='/day06_5/index.jsp;jsessionid=<%=session.getId() %>' >主页</a>

      <form action='/day06_5/index.jsp;jsessionid=<%=session.getId() %>' method="post">
          <input type="submit" value="提交"/>
      </form>
  </body>
  
 请求注意，在index.jsp后面使用的是分号，而不是问号，这是服务器对jsessionid这个参数的特殊要求
```

也可以使用response.encodeURL()对每个请求的URL处理，这个方法会自动追加jsessionid参数，与上面我们手动添加是一样的效果。

```
<a href='<%=response.encodeURL("/day06_5/index.jsp") %>' >主页</a>

<form action='<%=response.encodeURL("/day06_5/index.jsp") %>' method="post">
	<input type="submit" value="提交"/>
</form>
```

使用response.encodeURL()更加“智能”，它会判断客户端浏览器是否禁用了Cookie，如果禁用了，那么这个方法在URL后面追加jsessionid，否则不会追加。

