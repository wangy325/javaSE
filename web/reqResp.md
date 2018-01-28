今天将要学习的内容为：

1. response
2. request
3. 路径
4. 编码 

其中，response 和 request 是什么呢？

response和request 是服务器创建的两个对象，在服务器端的Servlet中可以通过request得到客户端请求的数据，可以通过response向客户端返回数据。

具体的 **客户端请求服务器的流程**：

1.N个客户端可以同时访问Tomcat服务器。**服务器收到每一个请求时，都会为这个请求开辟一个新的线程**。即 **Tomcat**服务器是异步处理机制。例如爱奇艺的一个视频，一百万个人可以同时观看，而不会出现 A看完，B再看.....； 

2.当服务器接收到请求后，服务器会创建request和response对象。每次请求服务器都会创建新的request和response对象，即每个请求有自己独自的request和response对象； 

3.Tomcat服务器把客户端的请求数据封装到request对象中（request就是请求数据的载体）；

 4.然后 Tomcat服务器**调用**Servlet的service(request, response)方法时把request和response这两个对象传递给service(request, response)方法体中，程序员就可以在service(request, response)方法体中通过request对象得到客户端的提交数据 并进行一些操作得到一些数据data，最后再使用response对象将数据data向客户端完成响应（向客户端返回数据）；

请求响应流程图:

![](http://otgx4owbp.bkt.clouddn.com/18-1-22/89132523.jpg)

首先来学习 Tomcat服务器提供的对象response。

**这个response**对象是服务器向客户端浏览器发送数据的**，这个数据呢必须是符合**HTTP协议的，这部分内容之前咱们学过。现在来回忆一下 HTTP协议中的服务器响应客户端的内容及其协议格式：

响应协议的格式如下：

```
响应首行；
响应头信息；
空行；
响应体。 ----  html格式的内容，可以被浏览器执行的，并显示在页面上的。响应首行、响应头信息、空行 是不会显示在页面上的。
```

响应内容是由服务器发送给浏览器的内容，浏览器会根据响应内容来显示。

```
HTTP/1.1 200 OK ---- 响应首行
Server: Apache-Coyote/1.1
Content-Type: text/html;charset=UTF-8
Content-Length: 724
Set-Cookie: JSESSIONID=C97E2B4C55553EAB46079A4F263435A4; Path=/hello
Date: Wed, 25 Sep 2012 04:15:03 GMT --- 响应头
----  空行
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
</html> --- 响应体
```



* HTTP/1.1 200 OK：响应协议为HTTP1.1，状态码为200（表示请求成功），OK是对状态码的解释；

​          状态码（响应码）

​           以2开头都表示成功，

​           以1开头的一般表示 服务器端正在处理请求过程中...**，**

​          以3开头的都需要转移访问地址

​          以4开头一般是客户端错误，

​          以5开头一般是服务器端的错误。

*  Server: Apache-Coyote/1.1：服务器的版本信息；


* Content-Type: text/html;charset=UTF-8：响应体的类型 和 使用的编码为UTF-8；

​        响应正文的MIME类型，例如image/jpeg表示响应正文为jpg图片 image/gif表示响应正文为gif图片，例如text/html;charset=utf-8表示响应正文为html，并且编码为utf-8编码(注：若返回内容为text，则需要指定编码。此处编码为urt-8,那这个页面中可以有中文；若编码为ISO-8859-1,则这个页面中不能出现中文 ，否则乱码)。浏览器会通过这一信息来显示响应数据。

* Content-Length: 724：响应体为724字节；


* Set-Cookie: JSESSIONID=C97E2B4C55553EAB46079A4F263435A4; Path=/hello：响应给客户端的Cookie；（Cookie是后面需要学习的一个重要的知识）

Date: Wed, 25 Sep 2016 04:15:03 GMT：响应的时间，这可能会有8小时的时区差；

## response

#### 1.response概述

服务器给客户端的响应内容（HTTP协议），都可以通过response这个对象来设置。

response是Servlet.service方法的一个参数，类型为javax.servlet.http.HttpServletResponse。

在JavaEE API中查询response是不行的，应该查询HttpServletResponse

在客户端发出每个请求时，服务器都会创建一个response对象，并传入给Servlet.service()方法。response对象是用来对客户端进行响应的，这说明在service()方法中使用response对象可以完成对客户端的响应工作。

**response**对象的功能分为以下四种：

* **设置响应头信息；**
* **发送状态码；**
* **设置响应正文；**
* **重定向**

咱们就按照响应协议中的内容 自上而下 来介绍response的常用API。

响应协议的格式如下：

```
响应首行；
响应头信息；
空行；
响应体。 ----  html格式的内容，可以被浏览器执行的，并显示在页面上的。响应首行、响应头信息、空行 是不会显示在页面上的。
```

1. 设置状态码

常见的状态码：**200**表示成功**、**302表示重定向**、**404表示客户端错（访问的资源不存在）、500表示服务器端错。

这些状态码，其实不需要咱们程序员 来手动的设置，服务器会自动的根据请求的具体情况 给客户端浏览器返回 200、302、404、500等。



但是呢，有时业务需求需要的业务逻辑为：纵使请求成功也给客户端返回一个404**，怎么办呢？这时候，咱们程序员就可以通过**response调用方法setError等 来实现。来看 JavaEE常见的API：

* setStatus(int sc) --> 发送成功的状态码，如可以发送成功状态码200，重定向状态码302

​        response.setStatus(200)：设置状态码为200

​        response.setStatus(302)：设置状态码为302

*  sendError(int sc) --> 发送错误状态码，例如404、500

​        response.sendError(404)

​        response.sendError(500)

* sendError(int sc, String msg) --> 也是发送错误状态码，还可以带一个错误信息！

​          response.sendError(404, “您要查找的资源不存在，存在也不给你看”);

当设置状态码为404时，Tomcat服务器会将当前请求的响应指向到Tomcat中固定的那个错误页面（源代码中是一个JSP）去，然后服务器将这个JSP给客户端。

​         repsonse.sendError(500, “服务器出错啦，纵使没错，执行这句代码你看到的也是出错啦”)：

设置状态码为500时，Tomcat服务器会将当前请求的响应指向到Tomcat中固定的那个错误页面（源代码中是一个JSP）去，然后服务器将这个JSP给客户端浏览器。

 在调用sendError()方法时，不只是设置了状态码，而且服务器Tomcat还会给浏览器响应一个固定错误的页面。如 大家浏览器上看到的错误信息，也是服务器响应的页面。



2. #### 设置响应头信息

   服务器给客户端的响应头：

   ```
   Server: Apache-Coyote/1.1
   Content-Type: text/html;charset=UTF-8
   Content-Length: 724
   Set-Cookie: JSESSIONID=C97E2B4C55553EAB46079A4F263435A4; Path=/hello
   Date: Wed, 25 Sep 2012 04:15:03 GMT
   ........
   ```

   HTTP协议中的响应头键值对 远不止这些！！！

   头就是一个键值对！响应头 可能是一个key 只对一个value，也可能是一个key 对应多个 value。

   常见的key 如，Content-Type、Refresh、Location等。在HTTP协议中，有哪些响应头键值对都是规定好的，这些键值对的意义也是规定好的。浏览器得到服务器响应的响应头键值对，浏览器知道他的作用是什么，然后浏览器会进行一些操作。所以，若服务器给浏览器返回了一个浏览器不认识的响应头（例如 response.setHeader("aaa","AAA") 这个响应头不是HTTP协议中定义的），浏览器也是无法识别。

   服务器在给客户端响应数据的时候，如在servlet中，若咱们程序员没有去设置这些头，则Tomcat服务器会使用默认值**；**当然程序员也可以根据业务需求来设置 这些响应头。如何来自定义响应头呢？

   可以使用response对象的setHeader()等方法来设置应头！使用该方法设置的响应头最终会发送给客户端浏览器！

* setHeader(String name, String value)：适用于单值（一个键一个值）的响应头，这个方法使用的较为多，下面的其他方法使用的较少。例如：response.setHeader("aaa", "AAA");

​       具体的HTTP响应头设置：

​         response.setHeader(“content-type”, “text/html;charset=utf-8”)：

​        设置content-type响应头，该头的作用是告诉浏览器响应内容为html类型，编码为utf-8。而且同时会设置       response的字符流编码为utf-8，即response.setCharacterEncoding(“utf-8”)；

​         response.setHeader("Refresh","5;URL=http://www.baidu.com")：5秒后自动跳转到百度主页。

* addHeader(String name, String value)：适用于多值（一个键多个值）的响应头（很少使用）

​      例如，

​       response.addHeader("aaa", "A");

​       response.addHeader("aaa","AA");

​       response.addHeader("aaa", "AAA");

* setIntHeader(String name, int value)：适用于单值的int类型的响应头

​    具体的HTTP响应头设置：

​     response.setIntHeader("Content-Length", 888);

* addIntHeader(String name, int value)：适用于多值的int类型的响应头（很少使用）   


* setDateHeader(String name, long value)：适用于单值的毫秒类型的响应头

​       具体的HTTP响应头设置：

​       response.setDateHeader("expires", 1000 \* 60 * 60 *24)  页面的缓存时间为24小时，超过这个时间再清除缓存。浏览器会将加载的页面缓存起来，若下次再请求这个页面的时候，浏览器判断本地是否有缓存的页面，若有直接加载；若没有，再从服务器获取。这个响应头键值对的作用是告诉浏览器缓存当前页面多长时间。若这样设置response.setDateHeader("expires",-1) 则客户端浏览器不会缓存这个页面。

有时，只设置这一个响应头并不能实现禁用浏览器缓存的功能。（浏览器默认有缓存页面的功能，但是当并没有设置这个响应头的时候，IE和谷歌浏览器 并没有缓存我们的Servlet返回的数据。不知具体原因）。

* addDateHeader(String name, long value)：适用于多值的毫秒类型的响应头（很少使用） 

除了setHeader()方法设置响应头，还可以

* response.setContentType("text/html;charset=utf-8")：

​    等同与调用response.setHeader(“content-type”, “text/html;charset=utf-8”)；

* response.setCharacterEncoding(“utf-8”)：设置字符响应流的字符编码为utf-8； 

​    关于上面说到的禁用浏览器缓存，咱们再来说说。

有时，只设置这一个响应头并不能实现禁用浏览器缓存的功能。一般要设置三个响应头：Cache-Control、pragma、expires，这样的话则会禁用HTTP协议的浏览器缓存了.（浏览器默认有缓存页面的功能，但是当并没有设置这三个响应头的时候，IE和谷歌浏览器 并没有缓存我们的Servlet返回的数据。不知具体原因）。

```
//缓存时间
resp.setDateHeader("expires", -1);
		
resp.setHeader("Cache-Control", "no-cache");
resp.setHeader("pragma", "no-cache");
```

**若返回的响应体是HTML格式的，标签头中的<meta>标签可以代替响应头，**

```
如，<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  设置编码

如，<meta http-equiv="refresh" content="3;"http://www.baidu.com">  设置编码
```

#### 重定向

5.1　什么是重定向

先举一个生活中的例子：

你（角色为客户端浏览器），张三和李四（角色为服务器端的两个servlet）。

你遇到了一个难题：1+1=？，你打电话给张三，张三说，我也不知道啊，你去问李四，他的电话号码为110。然后你又拨打了 李四的电话号码110，李四告诉你了这个答案。其中，张三告诉你李四的电话号码，你又第二次拨打的李四的电话。这种情形就类似于Tomcat服务器端的 **重定向**。

咱们在浏览器上为各位演示一下：

   SUN公司被oracle收购了。当你访问SUN公司的官网http://www.sun.com时，你会发现浏览器地址栏中的URL会变成https://www.oracle.com/sun/index.html（oracle的官网），这就是重定向了。

重定向是服务器通知浏览器去访问另一个地址，即再发出另一个请求。

重定向的演示图：

![](http://otgx4owbp.bkt.clouddn.com/18-1-22/18951578.jpg)



或者:

![](http://otgx4owbp.bkt.clouddn.com/18-1-22/52964370.jpg)



完成重定向

**状态吗设置为302**，并且设置Location响应头，完成重定向！如，

**response.setStatus(302);**

**repsonse.setHeader("Location","http://www.baidu.com");**、

响应码为200表示响应成功，而响应码为302表示重定向。所以完成重定向的第一步就是设置响应码为302。

因为重定向是通知浏览器再第二个请求，所以浏览器需要知道第二个请求的URL，所以完成重定向的第二步是设置Location头，指定第二个请求的URL地址。

```
public class AServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
         //设置响应码为302，表示重定向
		response.setStatus(302);
        //设置新请求的URLhttp://www.baidu.com
		response.setHeader("Location", "http://www.baidu.com");
	}
}
```

上面代码的作用是：当访问AServlet后，会通知浏览器重定向到百度主页。客户端浏览器解析到响应码为302后，就知道服务器让它重定向，所以它会马上获取响应头Location，然发出第二个请求http://www.baidu.com。

 如果要重定向的URL是在同一个服务器内，那么可以使用相对路径，例如：

新建两个servlet--BServlet 和 CServlet，当客户端浏览器访问BServlet的时候，会重定向到CServlet。

```
public class AServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
         //设置响应码为302，表示重定向
		response.setStatus(302);
        //设置新请求的URLhttp://www.baidu.com
		response.setHeader("Location", "/day01/cservlet");
	}
}
```



**便捷的重定向方式**

```
public class AServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("http://www.baiu.com");
	}
}
```

 

response.sendRedirect()方法会设置响应头为302，并设置Location响应头。

**如果要重定向的URL**是在同一个服务器内，那么可以使用相对路径，例如：

```
public class AServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("/hello/BServlet");
	}
}
```

重定向小结

* 重定向是**两次请求**；
* 重定向的URL可以是其他应用，不局限于当前应用；
* **重定向的响应头为302**，并且必须要有Location响应头；
* 重定向就不要再使用response.getWriter()或response.getOutputStream()输出数据，不然可能会出现异常；



**定时刷新**

在响应头里有一个key为**Refresh**的键值对，这个响应头是设置 定时刷新的，其效果类似于定时重定向。

在访问网页的时候，可能遇到过这样的情形：

登陆成功后，页面显示 5秒之后跳转到某个页面；访问某个页面，这个页面不存在，此时显示 3秒之后跳转到某个页面... 这样的功能就可以通过定时刷新来实现。



#### response响应正文

上面的响应设置是 响应码和响应头，是对响应体（响应正文）的设置，且不会显示在页面上。现在咱们来学习响应体（显示在浏览器页面上的内容）。响应体的格式可以是 html 、图片等。

response是响应对象，向客户端输出响应正文（响应体）可以使用response的响应流，repsonse一共提供了**两个响应流对象**，其类型分别为：**PrintWriter**（字符流） 和 **ServletOutputStream**（字节流）。

* **PrintWriter write = response.getWriter()**：获取响应字符流对象write，用来向客户端发送**字符数据**！通常需要设置编码。使用字符响应流对象可以方便的给客户端返回文字数据。

​       例如，response.getWriter().print("你好");//向客户端响应字符数据

* ServletOutputStream out = response.getOutputStream()：获取响应字节流对象out，用来向客户端发送字节数据。使用字节响应流对象可以给客户端返回二进制文件，如 图片、视频等。

​     例如，

​     byte[] bytes = ....文件的字节;

​     response.getOutputStream().write(bytes);//向客户端响应字节数据

当然，如果响应正文内容为字符，那么使用response.getWriter()，如果响应内容是字节，例如下载时，那么可以使用response.getOutputStream()。

注意，在一个请求中，不能同时使用这两个流！也就是说，要么你使用repsonse.getWriter()，要么使用response.getOutputStream()，但不能同时使用这两个流。不然会抛出[IllegalStateException](http://java.sun.com/j2se/1.5/docs/api/java/lang/IllegalStateException.html)异常。

 

####2.1　字符响应流

* 字符编码

​        常见字符编码：iso-8859-1(**不支持中文**)、gb2312、gbk、gb18030(系统默认编码，中国的国标码，支持中文)、utf-8(万国码，支持全世界的编码，并且通常情况下使用utf-8这种编码格式传输数据 也是比较省流量的，所以我们使用这个)。

首先确定几个概念：

1.解码--将字符按照某种编码方式转成字节；

   编码--将字节按照某种编码方式转成字符。

2.Tomcat8响应数据默认使用utf-8,  8.x之前的版本是iso-8859-1。

3.通常浏览器默认使用**GBK**编码。

服务器给客户端返回的数据的形态是字节。当将“中国是我的祖国”字符串通过响应字符流对response.getWriter()响应给客户端的时候，在Tomcat服务器中会首先对字符串“中国是我的祖国”进行解码成字节，这时Tomcat的默认方式为utf-8；字节返回给客户端浏览器，浏览器的默认编码方式为GBK，所以浏览器会使用GBK 来将这个字节编码为字符。但是，服务器的解码为utf-8，而浏览器的编码为GBK，并且此处的编码和解码方式不兼容 ，最终因为 解码和编码不一致 导致在浏览器上显示的文字是乱码！！！！怎么才会不出现乱码呢？

 

通常情况下，在使用**response.getWriter()**之前可以使用

**response.setHeader("Content-type","text/html;charset=utf-8")**来设置响应头，其作用有两个：

1.**response.setCharaceterEncoding(“utf-8”)**，设置输出给浏览器的字符是使用utf-8进行 编码的！

2.浏览器通过响应头的值"text/html;charset=utf-8"可以知道 响应内容格式是html，服务器的解码方式为utf-8，此时浏览器会使用utf-8的方式来编码字节，保证页面上的内容不会出现乱码。

setHeader("Content-Type","text/html;charset=utf-8")的快捷方法是：

setContentType("text/html;charset=utf-8)。

一般为了保证服务器给浏览器返回的内容不会出现乱码，都会在response.getWriter()之前加上一句

setContentType("text/html;charset=utf-8)。

 

咱们来思考一下，使用其他的编码方式可以避免乱码吗？为啥通常使用

setContentType("text/html;charset=utf-8)这句代码，避免乱码呢？

避免乱码的方法就是 解码和编码一致即可。既然 Tomcat响应数据默认使用utf-8 ，通常浏览器默认使用GBK编码，这时咱们就要来：

1.设置服务器端的解码方式！

2.通知浏览器使用哪种编码方式来编码字节！

 

 **1)**

 response.getWriter().print("大家好");

  因为Tomcat默认使用的是utf-8编码，不支持中文。所以一定乱码！

 

  **2)**

 response.setCharacterEncoding("utf-8");   设置输出给浏览器的字符是使用utf-8进行 编码的！

 response.getWriter().print("大家好");

  因为已经设置了字符流编码为utf-8，所以响应给客户端的数据为utf-8编码！

  但因为浏览器默认使用的是gbk来解析响应数据，所以乱码！如果浏览器使用utf-8编码，那么就不会乱码了。

 

  **3)**

 response.**setCharacterEncoding**("gbk");  //输出给浏览器的字符

 response.getWriter().print("大家好");

  因为设置了字符流编码为gbk，所以响应给客户端的数据为gbk编码！

  因为浏览器默认使用gbk来解析数据，所以不会出现乱码！如果浏览器使用utf-8编码，那么就会出现乱码！

 

 **4)**

response.setContentType("text/html;charset=utf-8");

response.getWriter().print("大家好");

setContentType()方法有两个作用：

设置字符流编码。等同与调用了response.setCharacterEncoding("utf-8")；

设置Content-type响应头，即通知浏览器响应数据的编码为utf-8。

因为设置字符流的编码为utf-8，所以响应给客户端数据为utf-8编码

因为设置了Content-type头为utf-8，所以浏览器会使用utf-8来解析响应数据

没有乱码！

 

  **5)**

 response.setContentType("text/html;charset=gbk");

 response.getWriter().print("大家好");

  设置了字符流为gbk，所以响应给客户端的数据为gbk

  设置了Content-type头为gbk，所以通知浏览器响应数据为gbk编码

  没有乱码！

 

  **6)**

 response.setHeader("Content-type","text/html;charset=utf-8")

  等同于repsonse.setContentType("text/html;charset=utf-8")

 

  **7)**

 response.getOutputStream().write("大家好".getBytes("gbk"));

  响应的数据是gbk编码客户端浏览器默认使用gbk编码  所以没有乱码

 

推荐第四种方式！！！！！

 

 缓冲区

response.getWriter()是PrintWriter类型，所以它有缓冲区，缓冲区的默认大小为8KB。也就是说，在响应数据没有输出8KB之前，数据都是存放在缓冲区中，而不会立刻发送到客户端。当Servlet执行结束后，服务器才会去刷新流，使缓冲区中的数据发送到客户端。

如果希望响应数据马上发送给客户端：

* 向流中写入大于8KB的数据；
* 调用response.flushBuffer()方法来手动刷新缓冲区；




## request

request是Servlet.service(request,response)方法的一个参数，类型javax.servlet.http.**HttpServletRequest**。在客户端发出每个请求时，服务器都会当前这个请求 创建一个request对象，并把请求的所有数据封装到request对象中，然后在调用Servlet.service(request, response)方法时传递给service()方法，这说明在service()方法中可以通过request对象来获取请求数据。

```
HTTP请求协议为：
请求行
请求头
空行
请求体（GET没体）
这些请求数据 都可以通过request得到。
```



request的功能可以分为以下几种：

* 封装了请求头数据；
* 封装了请求正文数据，如果是GET请求，那么就没有正文；
* request是一个域对象，可以把它当成Map来添加获取数据；
* request提供了请求转发和请求包含功能。



request中还提供了与请求相关的其他方法，有些方法是为了我们更加便捷的方法请求头数据而设计，有些是与请求URL相关的方法。

重点：

* String   getMethod()：返回请求方法，例如：GET
* String   getContextPath()：返回上下文路径，例如：/hello
* void   setCharacterEncoding(String code)：设置请求编码，只对请求体有效！注意，对于GET而言，没有请求体！！！所以此方法只能对POST请求中的参数有效！
* String   getRemoteAddr()：返回当前客户端的IP地址；



非重点：

*  int  getContentLength()：获取请求体的字节数，GET请求没有请求体，没有请求体返回-1；
*  String  getContentType()：获取请求类型，如果请求是GET，那么这个方法返回null；如果是POST请求，那么默认为application/x-www-form-urlencoded，表示请求体内容使用了URL编码；
*  Locale   getLocale()：返回当前客户端浏览器的Locale。java.util.Locale表示国家和言语，这个东西在国际化中很有用；例如zh_CN表示中文，中国
*  String getCharacterEncoding()：获取请求编码，如果没有setCharacterEncoding()，那么返回null，表示使用ISO-8859-1编码；
*  String  getQueryString()：返回请求URL中的参数列表，例如：username=zhangSan&password=123**
*  String   getRequestUR()：返回请求URI路径，从应用名称开始，到参数之前这一段，如：/hello/oneServlet
*  StringBuffer  getRequestURL()：返回请求URL路径，例如：http://localhost/hello/oneServlet，即返回除了参数以外的路径信息；
*  String   getServletPath()：返回Servlet路径，从应用名称后开始，到参数之前这一段，不包含应用名称，例如：/oneServlet
*  String  getRemoteHost()：返回当前客户端的主机名，但这个方法的实现还是获取IP地址；
*  String  getSchem()：返回请求协议，例如：http；
*  String  getServerName()：返回主机名，例如：localhost
*  int   getServerPort()：返回服务器端口号，例如：8080



#### request获取请求参数

请求服务器的方式分为 GET请求和POST请求.

GET请求和POST请求的区别：

* GET请求：
  * 请求参数会在浏览器的地址栏中显示，所以不安全；
  * 请求参数长度限制长度在1K之内；
  * GET请求没有请求体，无法通过request.setCharacterEncoding()来设置参数的编码；
* POST请求：
  * 请求参数不会显示浏览器的地址栏，相对安全；
  * 请求参数长度没有限制；
  * 可以通过request.setCharacterEncoding()来设置参数的编码;

客户端请求服务器的时候，通常也会传递参数（请求参数是由客户端发送给服务器的。Get请求是通过将参数拼接到URL后提交给服务器的，Post请求是将参数置于请求体中将参数提交给服务器的）。

最为常见的客户端传递参数方式有3种：

* 浏览器地址栏直接输入：一定是GET请求;
* 超链接：一定是GET请求
* 表单：可以是GET，也可以是POST，这取决与<form>的method属性值；



获取请求参数，即获取URL上的参数（get请求）和请求体中的参数（post请求在Servlet中，获取这两种请求参数的方式 是一样的！！！

在登陆、注册等功能中，都可以在服务器端通过以下几个方法获得客户端提交的数据。

请求参数：有一个参数一个值的，还有一个参数多个值！

常见的获取请求参数的方法：

* String   getParameter(String name)：获取指定名称的参数，如果存在同名参数，那么该方法只获取第一个参数值。（获取指定名称的请求参数值，适用于单值请求参数，例如用户名、密码等）
* String[]  getParameterValues(String name)：获取指定名称的参数，因为同名参数的存在，所以返回值为String[]。（获取指定名称的请求参数值，适用于多值请求参数，例如 注册功能中的爱好**多选项**。）
* Enumeration     getParameterNames():获取所有请求参数名称（key），然后再通过每一个key得到对应的value。可以为Enumeration增加泛型Enumeration<String>  getParameterNames()
* Map getParameterMap()：获取所有参数，封装到Map中，key为参数名称，value为参数值。可以为Map增加泛型Map<String,String[]>   getParameterMap()：获取所有请求参数，其中key为参数名，value为参数值（value为一个数组，因为可能存在参数名相同的多组key-value）

代码示例:

```
<form action="/Demo_day02/request02">
    
         用户名:<input type="text" name="username"/><br/>
         密码:<input type="text" name="password"/><br/>
    
       <input type="submit" value="登陆">
       
</form>
```

```
<form action="/Demo_day02/request03">
    
                    用户名:<input type="text" name="username"/><br>
                    密码:<input type="text" name="password"/><br>
                    爱好:<input type="checkbox" name="hobby" value="nv">爬山</input>
          <input type="checkbox" name="hobby" value="net">上网</input>
          <input type="checkbox" name="hobby" value="sprot">运动</input><br>
                    性别:<input type="radio" name="sex" value="nan">男</input>
          <input type="radio" name="sex" value="nv">女</input>          
          <br>
                     地址: <select name="city">
               <option>武汉</option>     
               <option>深圳</option>     
               <option>上海</option>         
            </select>
           
       <br/>     
       <input type="submit" value="登录"/>     
    </form>
```

 String getParameter(String name)：通过指定名称获取参数值；

```
   //点击超链接是GET请求，所以会执行doGet()方法	
   
public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("username=" + username);
		System.out.println("password=" + password);
}
	
   //提交表单是POST请求，所以会调用doPost()方法
public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("username=" + username);
		System.out.println("password=" + password);		
}
```

 String[]  getParameterValues(String name)：当多个参数名称相同时，可以使用方法来获取；

```
<a href="/hello/ParamServlet?name=zhangSan&name=liSi">超链接</a>//多个名为name的参数

public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] names = request.getParameterValues("name");//获取所有名为name的参数值
		System.out.println(Arrays.toString(names));
       //打印数组，输出结果为：[zhangSan, liSi]
}
```

Enumeration getParameterNames()：获取所有参数的名字；

```
 <form action="/hello/ParamServlet" method="post">
    	参数1：<input type="text" name="p1"/><br/>
    	参数2：<input type="text" name="p2"/><br/>
    	<input type="submit" value="提交"/>
    </form>
```

```
public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Enumeration names = request.getParameterNames();//获取所有参数名称，输出结果为：p1和p2
		while(names.hasMoreElements()) {
			System.out.println(names.nextElement());
		}
}
```



Map getParameterMap()：获取所有参数封装到Map中，其中key为参数名，value为参数值，因为一个参数名称可能有多个值，所以参数值是String[]，而不是String

```
<a href="/day05_1/ParamServlet?p1=v1&p1=vv1&p2=v2&p2=vv2">超链接</a>
```

```
  Map<String,String[]> paramMap = request.getParameterMap();
		for(String name : paramMap.keySet()) {
		   String[] values = paramMap.get(name);
	       System.out.println(name + ": " + Arrays.toString(values));
  }
```



####请求转发和请求包含

之前，咱们学过请求重定向，类比一个生活中的例子：（重定向 -- response.sendRedirect("/hello/BServlet");）

你拨打A人的电话号码，问“1+1=？”，A人不知道答案，说“你可以去问B人，他的电话号码为110”。立即，你通过A提供的B电话号码 给B打电话，问“1+1=？”，B回答你“等于2”。当然，也可能B也不知道答案，B又给了你C的电话号码.....   这就是请求重定向--根据当次请求（路径A）返回的路径重新访问一个新的资源（路径B）！这时，在客户端浏览器上看到的是路径B。



而请求转发和请求包含，又是啥意思呢？

你拨打A人的电话号码，问“1+1=？”，A人不知道答案，说“我帮你转接到B人吧”，然后转接给B，B告诉你了答案。当然B也可能不知道，然后B再转接给C.....  这就是请求转发和请求包含--请求服务器的一个资源（路径A），这个资源会自动的把当次请求转到其他资源（路径B）。这时，你在客户端浏览器上看到的仍然是路径A。



所以，

1.请求重定向是多个不同的请求！！

2.无论是请求转发还是请求包含，都表示由多个Servlet共同来处理这一个请求（服务器端封装的请求对象为request)。例如Servlet1来处理请求，然后Servlet1又转发给Servlet2来继续处理这个请求。

看下面的示意图：

重定向

![](http://otgx4owbp.bkt.clouddn.com/18-1-22/18951578.jpg)

请求转发和请求包含

![](http://otgx4owbp.bkt.clouddn.com/18-1-22/4996857.jpg)

那为啥 要请求转发和请求包含呢？例如，对于一个客户端的请求，服务器端需要多个Servlet来协同处理 才可以完成功能。通常，在多个servlet共同处理一个请求的时候，需要传递参数！！

这样的话，就产生了两个问题：

**1.**请求转发和 请求包含 有啥区别呢？

**2.**如何在处理同一个请求的多个servlet中 传递参数？



#### 请求转发与请求包含比较

* 如何实现？

**请求转发：**

在Service(request, response)方法中（经常使用的是进一步封装的get和post方法）

编写RequestDispatcher rd = request.getRequestDispatcher("/MyServlet");

// 使用request获取RequestDispatcher对象，方法的参数是被转发到的Servlet的URL路径rd.forward(request,response);



请求包含:（使用频率低)　　　

RequestDispatcher rd =request.getRequestDispatcher("/MyServlet"); 

// 使用request获取RequestDispatcher对象，方法的参数是包含的Servlet的URL路径

rd.include(request,response);



* 一个请求功能若需要跨多个Servlet，则需要使用**请求转发或者请求包含**。无论是请求转发还是请求包含，都是在对同一个客户端的请求进行处理（都是对同一个请求也就是对同一个request对象），在同一个**请求域**范围内！即，这几个Servlet在使用同一个request和response,所以这几个Servlet类中的

  Service(request,response)（经常使用的是进一步封装的get和post方法）方法中的对象request和response都是相同的！！！！



#### 请求转发和 请求包含操 作response对象给客户端返回数据时的区别：

**请求转发：**

如果在AServlet中请求转发到BServlet，那么在AServlet中就不允许再输出响应体，即不能再  使response.getWriter()和response.getOutputStream()向客户端输出，这一工作应该由BServlet来完成；

请求转发虽然不能输出响应体，但还是可以设置响应头的，

例如：response.setContentType(”text/html;charset=utf-8”);  。或者说，由下一个Servlet完成响应体！当前Servlet可以设置响应头！（**留头不留体**）

 如果在AServlet中执行了响应操作，那么有两种可能：

 * 如果在AServlet中响应的数据导致response提交，那么在转发时抛出异常；
 * 如果在AServlet中响应的数据没有导致response提交，那么response中的数据会被清空。



**请求包含：**

由多个Servlet共同未完成响应头和响应体！

* 在AServlet可以设置响应头
* 在AServlet可以使用响应流输出

（都留）

* **请求包含大多是应用在JSP**页面中，完成多页面的合并；
* **请求转发大多是应用在Servlet**中，转发目标大多是JSP页面；



![](http://otgx4owbp.bkt.clouddn.com/18-1-23/34187184.jpg)



再来思考第二个问题：

在请求转发中，如何在处理同一个请求的多个servlet中传递参数？



#### request域方法

request是域对象！在JavaWeb中一共四个域对象，其中ServletContext就是域对象，它在整个应用中只创建一个**ServletContext**对象；其他三个域对象：request、session、application。注：这三个域对象都属于Servlet的，并且这三个域对象都有如下三个方法：

　　　　 void   setAttribute(String name, Object value)

　　　　 Object   getAttribute(Stringname)

​                void   removeAttribute(Stringname);

现在咱们来重点学习request域对象。

request是一个**域对象**（**域对象可以存数据和取数据**），准确的说，**request**可以在一个请求中共享数据。

一个请求会创建一个request对象，如果在一个请求中经历了多个Servlet，那么多个Servlet（这些Servlet中的request对象是同一个对象）就可以使用request来共享数据。或者说，同一请求范围内使用request.setAttribute()、request.getAttribute()来传值！前一个Servlet调用setAttribute()保存值，后一个Servlet调用getAttribute()获取值。

下面是request的域方法:

* void setAttribute(String name, Object value)：用来存储一个对象，也可以称之为存储一个域属性，例如：request.setAttribute(“xxx”, “XXX”)，在request中保存了一个域属性，域属性名称为xxx，域属性的值为XXX。请注意，如果多次调用该方法，并且使用相同的name，那么会覆盖上一次的值，这一特性与Map相同；
* Object getAttribute(String name)：用来获取request中的数据，当前在获取之前需要先去存储才行，例如：String value = (String)request.getAttribute(“xxx”);，获取名为xxx的域属性；
* void removeAttribute(String name)：用来移除request中的域属性，如果参数name指定的域属性不存在，那么本方法什么都不做；
* Enumeration getAttributeNames()：获取所有域属性的名称；



流程图为：

![](http://otgx4owbp.bkt.clouddn.com/18-1-23/35358546.jpg)



6.4　请求转发与重定向比较

* 请求转发是一个请求一次响应，而重定向是多次请求多次响应；
* 请求转发后浏览器地址栏不会有变化，而重定向会有变化，因为重定向是重新从浏览器请求了一个新地址；
* 请求转发只能转发到**本项目**中的其他资源，而重定向**不仅能重定向到本项目**的其他资源，还能定向到其他项目的资源
* 请求转发是只发生在**服务器端**行为，只需给出转发的Servlet路(项目内部)；而重定向需要给出requestURI，即包含项目名，客户端浏览器要根据这个requestURI请求一个服务器端的资源！(可以是项目资源 也可以是外部资源（aservlet ，可以www.baidu.com）)
* 请求转发(请求方法是统一的)对AServlet和BServlet的请求方法是相同的，即要么都是GET，要么都是POST**，**因为请求转发是一个请求**；**重定向的第二个请求一定是GET；
* 请求转发和重定向的效率请求转发效率高！因为是一个请求！   
* 需要地址栏发生变化，那么必须使用重定向！
* 需要在下一个Servlet中获取request域中的数据，必须要使用转发！或者说需要在多个servlet中传递参数需要使用转发！
* 请求转发是request的方法    重定向是response的方法



获取客户端的请求参数request.getParameter()和获取服务器端的servlet域属性request.getAttribute() 的比较：

* getParameter()是获取客户端参数，它是从客户端传递给服务器的数据。
* getAttribute()是获取服务器端自己设置的数据，而不是客户端的数据。
* request没有setParameter()方法，不能自己设置参数，参数都由客户端传递
* request有setAttribute()方法，在getAttribute()之前，需要先setAttribute()才能获取到。
* getAttribute()和setAttribute()是用来在请求转发和请求包含中的多个Servlet中共享数据。







## 路径

#### 1.与路径相关的操作

* 超链接

* 表单

* 转发

* 包含

* 重定向

* <url-pattern>

* ServletContext获取资源

*   Class获取资源

* ClassLoader获取资源 

  ​

#### 2.客户端路径

###超链接、表单、重定向都是客户端路径，客户端路径可以分为三种方式：

* 绝对路径；

* 以“/”开头的相对路径；

* 不以“/”开头的相对路径；

  ​

```

例如：http://localhost:8080/hello2/pages/a.html中的超链接和表单如下：

绝对路径：  <a href="http://localhost:8080/hello2/index.html">链接1</a>
客户端路径：<a href="/hello2/pages/index.html">链接2</a>
相对路径：  <a href="index.html">链接3</a>
<hr/>
绝对路径：
<form action="http://localhost:8080/hello2/index.html">
  <input type="submit" value="表单1"/>
</form>
客户端路径：
<form action="/hello2/index.html">
  <input type="submit" value="表单2"/>
</form>
相对路径：
<form action="index.html">
  <input type="submit" value="表单3"/>
</form>
```

* 链接1和表单1：没什么可说的，它使用绝对路径；
* 链接2和表单2：以“/”开头，相对主机，与当前a.html的主机相同，即最终访问的页面为http://localhost:8080/hello2/index.html；
* 链接3和表单3：不以“/”开头，相对当前页面的路径，即a.html所有路径，即最终访问的路径为：http://localhost:8080/hello2/pages/index.html；



###重定向

重定向1:

```
public class AServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("/hello/index.html");
	}
}
```

重定向2：

```
public class AServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
	    //相对/hello 这个路径下面
		response.sendRedirect("index.html");
	}
}
```



**建议使用“/”**

强烈建议使用“/”开头的路径，这说明在页面中的超链接和表单都要以“/”开头，后面是当前应用的名称，再是访问路径：

```
<form action="/hello/AServlet">
</form>
<a href="/hello/b.html">链接</a> 
```

其中/hello是当前应用名称，这也说明如果将来修改了应用名称，那么页面中的所有路径也要修改，这一点确实是个问题。这一问题的处理方案会在学习了JSP之后讲解！ 

在Servlet中的重定向也建议使用“/”开头。同理，也要给出应用的名称！例如：

```
response.sendRedirect("/hello/BServlet");
```

其中/hello是当前应用名，如果将来修改了应用名称，那么也要修改所有重定向的路径，这一问题的处理方案是使用request.getContextPath()来获取应用名称。

```
response.sendRedirect(request.getContextPath() + "/BServlet");
```

####3.服务器端路径

服务器端路径必须是相对路径，不能是绝对路径。但相对路径有两种形式：

* 以“/”开头；
* 不以“/”开头；

其中请求转发、请求包含都是服务器端路径，服务器端路径与客户端路径的区别是：

* 客户端路径以“/”开头：相对当前主机；
* 服务器端路径以“/”开头：相对当前应用； 

#### 转发

转发1:

```
public class AServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/BServlet").forward(request, response);
	}
}
```

假设访问AServlet的路径为：http://localhost:8080/hello/AServlet

因为路径以“/”开头，所以相对当前应用，即http://localhost:8080/hello/BServlet。

#### 4 <url-pattern>路径

<url-pattern>必须使用“/”开头，并且相对的是当前应用。

####5.ServletContext获取资源

必须是相对路径，可以“/”开头，也可以不使用“/”开头，但无论是否使用“/”开头都是相对当前应用路径。

例如在AServlet中获取资源，AServlet的路径路径为：http://localhost:8080/hello/servlet/AServlet：

```
public class AServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path1 = this.getServletContext().getRealPath("a.txt");
		String path2 = this.getServletContext().getRealPath("/a.txt");
		System.out.println(path1);
		System.out.println(path2);
	}
}
```

path1和path2是相同的结果：http://localhost:8080/hello/a.txt

####6.Class获取资源

Class获取资源也必须是相对路径，可以“/”开头，也可以不使用“/”开头。

```
import java.io.InputStream;

public class Demo {
	public void fun1() {
		InputStream in = Demo.class.getResourceAsStream("/a.txt");
	}
	
	public void fun2() {
		InputStream in = Demo.class.getResourceAsStream("a.txt");
	}
}
```

其中fun1()方法获取资源时以“/”开头，那么相对的是当前类路径，即/hello/WEB-INF/classes/a.txt文件；

其中fun2()方法获取资源时没有以“/”开头，那么相对当前Demo.class所在路径，因为Demo类在com.xyd包下，所以资源路径为：/hello/WEB-INF/classes/com/xyd/a.txt。



#### 7ClassLoader获取资源

ClassLoader获取资源也必须是相对路径，可以“/”开头，也可以不使用“/”开头。但无论是否以“/”开头，资源都是相对当前类路径。

```
public class Demo {
	public void fun1() {
		InputStream in = Demo.class.getClassLoader().getResourceAsStream("/a.txt");
	}
	
	public void fun2() {
		InputStream in = Demo.class.getClassLoader().getResourceAsStream("a.txt");
	}
}
```

fun1()和fun2()方法的资源都是相对类路径，即classes目录，即/hello/WEB-INF/classes/a.txt



## 编码

#### 1请求编码

客户端提交给服务器端的参数的编码 分为两种情况：

1.1　直接在地址栏中给出中文

请求数据是由客户端浏览器发送服务器的，请求数据的编码是由浏览器决定的。例如在浏览器地址栏中给出：

http://localhost:8080/hello/AServlet?name=中国，那么其中“中国”是什么编码的呢？不同浏览器使用不同的编码，所以这是不确定的！

* IE：使用GB2312；
* FireFox：使用GB2312；
* Chrome：使用UTF-8；

 通常没有哪个应用要求用户在浏览器地址栏中输入请求数据的，所以大家只需了解一下即可。



1.2　在页面中发出请求

通常向服务器发送请求数据都需要先请求一个页面，然后用户在页面中输入数据。页面中有超链接和表单，通过超链接和表单就可以向服务器发送数据了。

因为页面是服务器发送到客户端浏览器的，所以这个页面本身的编码由服务器决定。而用户在页面中输入的数据也是由页面本身的编码决定的。

```
<!DOCTYPE html>
<html>
  <head>
<title>index.html</title>

<!--这就相当于给客户端发送了响应头content-type，指定当前页面的编码为utf-8 -->
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
  </head>
  
  <body>
<form action="/hello/servlet/AServlet">
  名称:<input type="text" name="name"/>
  <input type="submit" value="提交"/>
</form>
<a href="/hello/servlet/AServlet?name=中国">链接</a>
  </body>
</html>
```

当用户在index.html页面中输入数据时，都是UTF-8列表的。因为这个页面本身就是UTF-8编码的！

**页面的编译就是页面中输入数据的编码。**



1.3GET请求解读编码

当客户端通过GET请求发送数据给服务器时，在Tomcat服务器端使用request.getParameter()获取的数据是被服务器误认为ISO-8859-1编码的（从Tomcat8开始包括Tomcat8 此处的默认编码方式为UTF-8），也就是说客户端发送过来的数据无论是UTF-8还是GBK，服务器都认为是ISO-8859-1，这就说明我们需要在使用request.getParameter()获取数据后，再转发成正确的编码。

例如客户端以UTF-8发送的数据，使用如下转码方式：

String name =request.getParameter(“name”);//得到客户端提交的参数，字符串类型,并且这个字符串的编码方式为iso-8859-1

byte[] b =name.getBytes(“iso-8859-1”);//再通过**iso-8859-1**的编码方式将字符串name打碎成字节数组

**name = newString(b,”utf-8”);**//指定编码方式utf-8 通过String的构造器将字节数组再编码为 编码方式为utf-8的字符串

合在一起写：

**String name =request.getParameter(“name”);**

**name = newString(name.getBytes(“iso-8859-1”), “utf-8”);**

 

还有一种方式，但**不建议使用**：

在Tomcat配置文件中指定当前这台Tomcat服务器的Get请求到的数据的编码方式。

 去Tomcat的安装路径/conf/server.xml中配置

![](http://otgx4owbp.bkt.clouddn.com/18-1-23/47636783.jpg)



若不这样设置，默认得到客户端提交的数据的编码方式 还是ISO-8859-1。

这样就指定Tomcat服务的得到的数据的编码方式都为utf-8。但这样就将编码方式写死了，而且你不能其他Tomcat服务器也进行了这项设置 或者 部署这个项目的服务器容器也可能不会Tomcat而是其他，得到的数据 非常可能乱码。

 

1.4　POST请求解读编码

　　当客户端通过POST请求发送数据给服务器时，可以在使用request.getParameter()获取请求参数之前先通过request.setCharacterEncoding()来指定编码，然后再使用reuqest.getParameter()方法来获取请求参数，那么就是用指定的编码来读取了。

也就是说，如果是POST请求，服务器可以指定编码！但如果没有指定编码，那么默认还是使用ISO-8859-1来解读。

request.setCharacterEncoding(“utf-8”);

String name =request.getParameter(“name”);

**注：从Tomcat8****开始默认编码不再是iso-8859-1****，而变成了UTF-8.**

####2响应编码

响应：服务器发送给客户端数据！响应是由response对象来完成，如果响应的数据不是字符数据，那么就无需去考虑编码问题。当然，如果响应的数据是字符数据，那么就一定要考虑编码的问题了。

response.getWriter().print(“中国”);

上面代码因为没有设置repsonse.getWriter()字符流的编码，所以服务器使用默认的编码（ISO-8859-1）来处理，因为ISO-8859-1不支持中文，所以一定会出现编码的。

所以在使用response.getWriter()发送数据之前，一定要设置response.getWriter()的编码，这需要使用response.setCharacterEncoding()方法：

response.setCharacterEncoding(“utf-8”);

response.getWriter().print(“中国”);

上面代码因为在使用response.getWriter()输出之前已经设置了编码，所以输出的数据为utf-8编码。但是，因为没有告诉浏览器使用什么编码来读取响应数据，所以很可能浏览器会出现错误的解读，那么还是会出现乱码的。当然，通常浏览器都支持来设置当前页面的编码，如果用户在看到编码时，去设置浏览器的编码，如果设置的正确那么乱码就会消失。但是我们不能让用户总去自己设置编码，而且应该直接通知浏览器，服务器发送过来的数据是什么编码，这样浏览器就直接使用服务器告诉他的编码来解读！这需要使用content-type响应头。

response.setContentType(“text/html;charset=utf-8”);

response.getWriter().print(“中国”);

　　上面代码使用setContentType()方法设置了响应头content-type编码为utf-8，这不只是在响应中添加了响应头，还等于调用了一次response.setCharacterEncoding(“utf-8”)，也就是说，通过我们只需要调用一次response.setContentType(“text/html;charset=utf-8”)即可，而无需再去调用response.setCharacterEncoding(“utf-8”)了。

 在静态页面中，使用<meta>来设置content-type响应头，例如：

<metahttp-equiv="content-type" content="text/html;charset=UTF-8">

 

#### 3.URL编码

通过页面传输数据给服务器时，如果包含了一些特殊字符是无法发送的。这时就需要先把要发送的数据转换成URL编码格式，再发送给服务器。

其实需要我们自己动手给数据转换成URL编码的只有GET超链接，因为表单发送数据会默认使用URL编码，也就是说，不用我们自己来编码。

例如：“张三”这两个字通过URL编码后得到的是：“%E4%BC%A0%E6%99%BA”。URL编码是先需要把“张三”转换成字节，例如我们现在使用UTF-8把“张三”转换成字符，得到的结果是：“[-28,-68, -96, -26, -103, -70]”，然后再把所有负数加上256，得到[228, 188, 160, 230, 153, 186]，再把每个int值转换成16进制，得到[E4, BC, A0, E6, 99, BA]，最后再每个16进制的整数前面加上“%”。

通过URL编码，把“张三”转换成了“%E4%BC%A0%E6%99%BA”，然后发送给服务器！服务器会自动识别出数据是使用URL编码过的，然后会自动把数据转换回来。

 

当然，在页面中我们不需要自己去通过上面的过程把“张三”转换成“%E4%BC%A0%E6%99%BA”，而是使用Javascript来完成即可。当后面我们学习了JSP后，就不用再使用Javascript了。

```
 <script type="text/javascript">
  	function _go() {
  		location = "/day05_2/AServlet?name=" + encodeURIComponent("新一代");
  	}
  </script>
  
  <a href="javascript:_go();">链接</a>

```

因为URL默认只支持ISO-8859-1，这说明在URL中出现中文和一些特殊字符可能无法发送到服务器。所以我们需要对包含中文或特殊字符的URL进行URL编码。

服务器会自动识别数据是否使用了URL编码，如果使用了服务器会自动把数据解码，无需我们自己动手解码。