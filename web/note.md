## From Mooc

### Tomcat 容器等级

> Tomcat
>> Container
>>> Engine
>>>> Host
>>>>> Servlet 
>>>>>> Context
>>>>>>> Wrapper
>>>>>>> Wrapper

> 一个Tomcat 只用创建一个（？）Servlet 对象；一个Servlet 对象可以有多个Context

### 创建 Servlet
#### 手动创建
- 继承 HttpServlet
- 重写doGet() 或 doPost() 方法
  > 根据处理请求不同，重写方法
- 在 web.xml 中注册 Servlet

#### 利用 Eclipse 创建
- src --> new -->Servlet
- 重写方法
- 部署运行