JDBC全称为：Java DataBase Connectivity（java数据库连接）。是SUN公司为了简化、统一对数据库的操作，定义了一套Java操作数据库的规范，称之为JDBC，即Java数据库编程接口，是一组标准的Java语言中的接口和类，使用这些接口和类，Java客户端程序可以访问各种不同类型的数据库。比如建立数据库连接、执行SQL语句进行数据的存取操作。

### 为什么使用JDBC？

1. 早前数据库产品众多，保守估计有100多种数据，这样造成我们应用程序连接访问数据库缺乏统一的接口。
2. 应用程序与数据库之间兼容性太差。

### 有了jdbc后

1. 统一程序连接访问数据库接口，实现异构数据库系统信息互访
2. 减少应用程序与数据库编码工作
3. 依靠 OOP(Object Oriented Programming)技术，提高代码的复用性

### 总之：

有了JDBC，向各种关系数据发送SQL语句就是一件很容易的事。有了JDBC，就不必为访问DB2数据库专门写一个程序，为访问Oracle数据库又专门写一个程序，或为访问MYSQL数据库又编写另一个程序等等，程序员只需用JDBC API写一个程序就够了，它可向相应数据库发送SQL调用。同时，将Java语言和JDBC结合起来使程序员不必为不同的平台编写不同的应用程序，只须写一遍程序就可以让它在任何平台上运行，这也是Java语言“编写一次，处处运行”的优势。

## 什么是JDBC驱动

早期SUN公司想编写一套可以连接所有数据库的API，但是当他们刚刚开始时就发现这是不可完成的任务，因为各个厂商的数据库服务器差异太大了。后来SUN开始与数据库厂商们讨论，最终得出的结论是，由SUN提供一套访问数据库的规范（就是一组接口），并提供连接数据库的协议标准，然后各个数据库厂商会遵循SUN的规范提供一套访问自己公司的数据库服务器的API出现。SUN提供的规范命名为JDBC，而各个厂商提供遵循了JDBC规范的API。

可以访问某种数据库的API被称之为JDBC驱动！

## 认识ODBC

> ODBC（Open DataBase Connectivity）微软公司数据库系统应用程序接口规范，支持应用程序以标准的ODBC函数和SQL语言访问不同数据库。使用C语言,调用本地代码,程序移植性差。将简单与高级功能合，实现性能差，难以学习掌握。

## 类型一、JDBC-ODBC桥（了解）

![img](http://ojx4zwltq.bkt.clouddn.com/17-8-30/43871199.jpg)

JDBC-ODBC 桥是sun公司提供的，是jdk提供的的标准API。这种类型的驱动实际是把所有 JDBC的调用传递给ODBC，再由ODBC调用本地数据库驱动代码。( 本地数据库驱动代码是指由数据库厂商提供的数据库操作二进制代码库，例如在Oracle for windows中就是oci dll 文件)。

只要本地机装有相关的ODBC驱动那么采用JDBC-ODBC桥几乎可以访问所有的数据库，JDBC- ODBC方法对于客户端已经具备ODBC driver的应用还是可行的。

但是，由于JDBC-ODBC先调用 ODBC 再由ODBC去调用本地数据库接口访问数据库。所以，执行效率比较低，对于那些大数据量存取的应用是不适合的。而且，这种方法要求客户端必须安装ODBC驱动，所以对于基于 internet 的应用也是不合适的。因为，你不可能要求所有客户都能找到ODBC driver。

## 类型二、本地API驱动（了解）

![img](http://ojx4zwltq.bkt.clouddn.com/17-8-30/66641004.jpg)

本地API驱动直接把JDBC调用转变为数据库的标准调用再去访问数据库。

这种方法需要本地数据库驱动代码。这些驱动程序通常由数据库供应商提供，这种驱动比起JDBC-ODBC桥执行效率虽然提高了。但是，它仍然需要在客户端安装该供应商的驱动程序在每台客户机上。这样就不适合基于internet的应用。并且，他的执行效率比起3、4型的JDBC驱动还是不够高。

## 类型三、网络协议驱动

![img](http://ojx4zwltq.bkt.clouddn.com/17-8-30/93955300.jpg)

这种驱动实际上是根据我们熟悉的三层结构建立的。JDBC先把对数局库的访问请求传递给网络上的中间件服务器， 中间件服务器再把请求翻译为符合数据库规范的调用，再把这种调用传给数据库服务器。如果中间件服务器也是用java开法的，那么在在中间层也可以使用1、2型 JDBC驱动程序作为访问数据库的方法。

由于这种驱动是基于server的。所以，它不需要在客户端加载数据库厂商提供的代码库。而且他在执行效率和可升级性方面是比较好的。因为大部分功能实现都在server端，所以这种驱动可以设计的很小，可以非常快速的加载到内存中.。但是，这种驱动在中间件层仍然需要配置其它数据库驱动程序，并且由于多了一个中间层传递数据，它的执行效率还不是最好。

## 类型四、本地协议驱动（重点）

![img](http://ojx4zwltq.bkt.clouddn.com/17-8-30/34473030.jpg)

这种驱动直接把JDBC调用转换为符合相关数据库系统规范的请求。由于4型驱动写的应用可以直接和数据库服务器通讯。这种类型的驱动完全由java实现，因此实现了平台独立性。

由于这种驱动不需要先把JDBC的调用传给ODBC或本地数据库接口或者是中间层服务器，所以它的执行效率是非常高的。而且它根本不需要在客户端或服务器端装载任何的软件或驱动。这种驱动程序可以动态的被下载，但是，对于不同的数据库，还是需要下载不同的驱动程序。

**目前，在日常的开发过程中，使用比较广泛的就是本地协议驱动，通过引入不同数据库厂商的驱动程序来操作数据库**

## 常用数据库的驱动程序

## Oracle数据库

驱动程序包名：ojdbc6.jar
驱动类的名字：oracle.jdbc.driver.OracleDriver
JDBC URL：jdbc:oracle:thin:@dbip:port:databasename

> 说明：驱动程序包名有可能会变

JDBC URL中各个部分含义如下：

1. dbip –为数据库服务器的IP地址，如果是本地可写：localhost或127.0.0.1。
2. port –为数据库的监听端口，需要看安装时的配置，缺省为1521。
3. databasename –为数据库的SID，通常为全局数据库的名字。

## MySQL数据库

驱动程序包名：mysql-connector-Java-3.1.11-bin.jar
驱动类的名字：com.mysql.jdbc.Driver
JDBC URL：jdbc:mysql://dbip:port/databasename?参数名1 =参数值1&参数名2=参数值2

> 说明：驱动程序包名有可能会变

JDBC URL其中各个部分含义如下：

1. dbip –为数据库服务器的IP地址，如果是本地可写：localhost或127.0.0.1。
2. port –为数据库的监听端口，需要看安装时的配置，缺省为3306。
3. databasename –数据库的名字。
4. 参数一:useUnicode=true
5. 参数二:characterEncoding=UTF-8

## SQL Server数据库 

驱动程序包名：msbase.jar mssqlserver.jar msutil.jar
驱动类的名字：com.microsoft.jdbc.sqlserver.SQLServerDriver
JDBC URL：jdbc:microsoft:sqlserver://dbip:port;DatabaseName=databasename

> 说明：驱动程序包名有可能会变

JDBC URL 中各个部分含义如下：

1. dbip –为数据库服务器的IP地址，如果是本地可写：localhost或127.0.0.1。
2. port –为数据库的监听端口，需要看安装时的配置，缺省为1433。
3. databasename –数据库的名字。



# JDBC体系结构

JDK提供jdbc接口，就是Java怎样去调用数据库，但是只是提供接口(规范)，数据库提供商实现这些接口，就是所谓数据库驱动。

java调用数据库驱动的接口方法，数据库驱动执行数据库操作，返回操作结果。

![img](http://ojx4zwltq.bkt.clouddn.com/17-8-30/75260003.jpg)



# Oracle11g JDBC驱动下载与配置

## 下载

[官方地址：Oracle11g JDBC驱动](http://www.oracle.com/technetwork/database/enterprise-edition/jdbc-112010-090769.html)

#### 下载完成得到以下文件

![img](http://ojx4zwltq.bkt.clouddn.com/17-8-30/66012784.jpg)

## 配置

### eclipse配置

1. 在项目根目录下创建目录 libs

   ![img](http://ojx4zwltq.bkt.clouddn.com/17-8-30/89112600.jpg)

2. 将下载好的 `ojdbc6.jar`复制到 libs目录下

   ![img](http://ojx4zwltq.bkt.clouddn.com/17-8-30/52319257.jpg)

3. 然后在项目名称上 >>>右键>>>`Properties`，然后选择 `Java Build Path`。

   ![img](http://ojx4zwltq.bkt.clouddn.com/17-8-30/53817013.jpg)

4. 打开`java Build Path`后，选择顶部选项卡 `Libraries`，之后选择右边第一个按钮 `Add JARs...`

   ![img](http://ojx4zwltq.bkt.clouddn.com/17-8-30/94087447.jpg)

5. 在`JAR Selection`窗口依次选择 当前项目>>>libs>>>ojdbc6.jar，然后点击OK。

   ![img](http://ojx4zwltq.bkt.clouddn.com/17-8-30/19939214.jpg)

6. 回到 `Java Build Path`界面后点击OK，即配置成功！

   ![img](http://ojx4zwltq.bkt.clouddn.com/17-8-30/1183513.jpg)

7. 查看项目，如图所示，Oracle JDBC驱动源码导入成功！
   ![img](http://ojx4zwltq.bkt.clouddn.com/17-8-30/61505963.jpg)





# 步骤

1. 加载驱动

2. 建立连接

   > 执行SQL语句

3. 关闭连接



# 驱动加载

1. 方式一

   ```
   DriverManager.registerDriver(new OracleDriver());

   ```

2. 方式二

   ```
    Class.forName("oracle.jdbc.driver.OracleDriver");//新老版本都可以，兼容老版本
   //或者
    Class.forName("oracle.jdbc.OracleDriver");//新版本推荐

   ```

> 注意：在实际开发中并不推荐采用registerDriver方法注册驱动。
>
> 1. 如果采用方式一，会导致驱动程序注册两次，也就是在内存中会有两个OracleDriver对象。
> 2. 如果采用方式一，由于实例化了oracle.jdbc.driver.OracleDriver.class，导致必须import该类，从而具体驱动产生了依赖，不方便扩展代码。
> 3. 推荐采取采用方式二的方式加载，这样不会导致驱动对象在内存中重复出现，并且采用此种方式，程序仅仅只需要一个字符串，不需要依赖具体的驱动，即不需要import相关的包，使程序的灵活性更高。

1. 自动加载驱动

   ```
   JDK6之后，JDBC已经升级到4.0了
   JDBC4.0之后自动加载驱动，程序猿不再需要调用 Class.forName
   ```



# 建立连接

### 核心代码

`DriverManager.getConnection(String url,String user, String password)`

```
        try {
            String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
            String user = "scott";
            String psw = "tiger";
            Connection conn = DriverManager.getConnection(url, user, psw);
            System.out.print("数据库连接成功！");
        } catch (SQLException e) {
            e.printStackTrace();
        }

```

### 说明

1. 参数 `String url` 由三部分组成：

   1. JDBC驱动协议含子协议
   2. 数据库主机ip地址含端口号
   3. 数据库名



## jdbc:oracle:thin:@localhost:1521:xyd

  协议               子协议                              ip地址                  端口      数据库名称

## 一个连接使用完后应释放连接资源。

核心代码：

```
Connection conn;//打开连接

//执行sql语句

//处理完成后释放连接资源。
if (conn != null) {
    try {
        conn.close(); // 关闭连接对象
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
```

# Connection接口

Connection：JDBC驱动与特定数据库的连接（会话：一次完整的连接到关闭的过程），可以在连接上下文中执行sql语句并返回结果。

DriverManager.getConnection(url, user, password)方法获得的Connection ，是建立在 JDBC URL中定义的数据库的连接上。

## 常用方法：

- createStatement()：创建向数据库发送sql的statement对象。
- prepareStatement(sql) ：创建向数据库发送预编译sql的PrepareSatement对象。
- prepareCall(sql);创建执行存储过程的callableStatement对象。（了解）
- setAutoCommit(boolean autoCommit)：设置事务是否自动提交。
- commit() ：在链接上提交事务。
- rollback() ：在此链接上回滚事务。
- setTransactionIsolation(int level);设置事务隔离级别（了解）





# Statement接口

Statement接口用于将 SQL 语句发送到数据库中，执行对数据库的数据的增删改查。它有2个子接口，CallableStatement(了解), PreparedStatement (后面重点讲解)。

Statement 对象用于执行不带参数的简单 SQL 语句；

## 创建Statement对象

```
//创建一个Statement对象，用于执行SQL语句并返回相应的结果
Statement statement = conn.createStatement();

```

## 常用Statement方法

- executeQuery(String sql);运行select语句，返回ResultSet结果集
- executeUpdate(String sql);运行insert/update/delete操作，返回响应的行数
- execute(String sql);运行任何sql语句(含DDL)，返回是否有结果
- addBatch(String sql) ;把多条sql语句放到一个批处理中
- executeBatch();向数据库发送一批sql语句执行

## Statement执行示意图

![img](http://ojx4zwltq.bkt.clouddn.com/17-8-30/95388741.jpg)



# 课前准备

进入Scott用户，复制一张 emp表为 myemp。

## no.1创建Statement对象

```
Statement st = conn.createStatement();

```

## no.2执行查询语句

```
//编写查询语句
String sql =  "SELECT * FROM myemp" ;
//或者
String sql =  "SELECT ename,empno,job FROM myemp" 

//执行sql语句。(默认自动提交)
ResultSet  rs = st.executeQuery(sql);
//执行查询返回的结果是一个ResultSet对象

//测试是否有返回查询数据
boolean next = rs.next();
System.out.println(next?"有数据":"一行数据都没");

```

至此，查询语句已经执行完成！

## no.3释放Statement资源

```
finally {//在finally中执行，以防在执行sql中出现错误，而忽略资源的释放。
    if (st!=null) {
        try {
            st.close();
        } catch (SQLException e) {
        }
    }    
}
```

# ResultSet基本使用

 结果集(ResultSet)是数据中查询结果返回的一种对象，可以说结果集是一个存储查询结果的对象，但是结果集并不仅仅具有存储的功能，他同时还具有操纵数据的功能，可能完成对数据的更新等。

 结果集读取数据的方法主要是getXXX()，他的参数可以是整型表示第几列（是从1开始的），还可以是列名。返回的是对应的XXX类型的值。如果对应那列是空值，XXX是对象的话返回XXX型的空值，如果XXX是数字类型，如Float等则返回0，boolean返回false.使用getString()可以返回所有的列的值，不过返回的都是字符串类型的。

## MySql 、Oracle与Java 对应的数据类型

| mysql     | oracle        | java               |
| --------- | ------------- | ------------------ |
| TIMESTAMP | Timestamp     | java.sql.Timestamp |
| VARCHAR   | VARCHAR2 CLOB | java.lang.String   |
| TEXT      | VARCHAR2 CLOB | java.lang.String   |
| INT       | NUMBER(10,0)  | java.lang.Integer  |
| date(年月日) | date          | java.sql.Date      |

## 使用ResultSet取出myemp查询的结果打印到控制台上

```
Statement st = conn.createStatement();
ResultSet resultSet = st.executeQuery("SELECT * FROM myemp");
while (resultSet.next()) {
    Integer empno = resultSet.getInt(1);//根据列的编号获取数据，效率比较高，清楚编号
    String ename = resultSet.getString(2);
    String job = resultSet.getString(3);
    Integer mgr = resultSet.getInt(4);
    Date hiredate = resultSet.getDate(5);
    Double sal = resultSet.getDouble(6);
    Double comm = resultSet.getDouble(7);
    Integer deptno = resultSet.getInt(8);
//    Integer empno = resultSet.getInt("empno");//根据列名获取数据
//    String ename = resultSet.getString("ename");
//    String job = resultSet.getString("job");
//    Integer mgr = resultSet.getInt("mgr");
//    Date hiredate = resultSet.getDate("hiredate");
//    Double sal = resultSet.getDouble("sal");
//    Double comm = resultSet.getDouble("comm");
//    Integer deptno = resultSet.getInt("deptno");
    System.out.println(empno + "\t" + ename + "\t" + job + "\t" + mgr + "\t" + hiredate + "\t" + sal + "\t"
            + comm + "\t" + deptno);
}

```

## ResultSet 取值 示意图

![img](http://ojx4zwltq.bkt.clouddn.com/17-8-31/52247036.jpg)



## 执行DML操作(insert update delete)

```
//String sql="INSERT INTO myemp (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL,  DEPTNO) VALUES (6666,'张三','搬砖的',7788,sysdate,999,40)";
//    String sql="INSERT INTO myemp (EMPNO, ENAME, MGR, HIREDATE, SAL,  DEPTNO) VALUES (9999,'李四',7788,sysdate,980,40)";
//    String sql="INSERT INTO myemp (EMPNO, ENAME, MGR, HIREDATE, SAL,  DEPTNO) VALUES (8899,'王五',7788,sysdate,30,40)";
//    String sql="INSERT INTO myemp (EMPNO, ENAME, MGR, HIREDATE, SAL,  DEPTNO) VALUES (6677,'赵六',7788,sysdate,500,40)";
//    String sql="UPDATE myemp SET deptno=30 WHERE empno=6666";
String sql="DELETE FROM myemp WHERE deptno=40";
int executeUpdate = st.executeUpdate(sql);//执行增删改操作。返回影响的行数。
System.out.println("响应行数："+executeUpdate);
```



## Statement执行DDL语句（了解）

## 测试

```
//重命名数据表
String sql ="RENAME myemp TO empp";
Statement st = conn.createStatement();
boolean execute = st.execute(sql);
System.out.println(execute ? "返回的是一个resultSet" : "执行的是DDL或增删改");

//true表示第一个返回值是一个ResultSet对象；false表示这是一个更新个数或者没有结果集。

```

> 注意：一般开发基本不会使用JDBC执行DDL sql语句。

# Statement执行批量插入

核心代码

```
Statement st = conn.createStatement();
conn.setAutoCommit(false);//设置conn不自动提交
String i1 = "INSERT INTO myemp (EMPNO, ENAME, JOB, HIREDATE, SAL,deptno) VALUES (1001,'张三','程序员',sysdate,9999.99,40)";
String i2 = "INSERT INTO myemp (EMPNO, ENAME, JOB, HIREDATE, SAL,deptno) VALUES (1002,'小贤','板砖工',sysdate,8.88,40)";
String i3 = "INSERT INTO myemp (EMPNO, ENAME, JOB, HIREDATE, SAL,deptno) VALUES (1003,'李四','程序员',sysdate,7777.77,40)";
String i4 = "INSERT INTO myemp (EMPNO, ENAME, JOB, HIREDATE, SAL,deptno) VALUES (1004,'老王','板砖工',sysdate,6.66,40)";
String i5 = "INSERT INTO myemp (EMPNO, ENAME, JOB, HIREDATE, SAL,deptno) VALUES (1005,'张伟','程序员',sysdate,5555.55,40)";
st.addBatch(i1);//添加待执行的sql插入语句
st.addBatch(i2);
st.addBatch(i3);
st.addBatch(i4);
st.addBatch(i5);
int[] executeBatch = st.executeBatch();//执行批量增加，返回每个增加的响应行数
System.out.println("响应结果：" + Arrays.toString(executeBatch));
conn.commit();//手动提交
conn.setAutoCommit(true);//如果conn连接还需要用，再把连接设置成自动提交
```



# SQL注入的问题

因为sql语句是用String拼接的，那么就可以在条件中 追加一个类似 `OR 1=1` 这种条件，让整个判断 和一个结果为true的逻辑 进行 OR运算。使得结果为true。这就是所谓的SQL注入。

```
String username="abcdefg";
String psw="123456' OR '1'='1";

ResultSet executeQuery = conn.createStatement().executeQuery("SELECT userno FROM user WHERE username='"+username+"' AND name='"+name+"'");
if (executeQuery.next()) {
    System.out.println("登陆成功！");
}

```

# 解决SQL注入的问题

使用PreparedStatement代替Statement。

> ps：任何时候都不要使用Statement



# PreparedStatement预处理语句对象

PreparedStatement是Statement的子接口，相对于Statement对象而言：PreperedStatement可以避免SQL注入的问题。

## PreparedStatement优点

1. PreperedStatement可以避免SQL注入的问题；

2. PreparedStatement 可对SQL进行预编译，从而提高数据库的执行效率；

3. PreperedStatement对于sql中的参数，允许使用占位符的形式进行替换，简化sql语句的编写。

   > 预编译：
   >
   >  数据库都会尽最大努力对预编译语句提供最大的性能优化，因为预编译语句有可能被重复调用，所以语句在被DB的编译器编译后，执行代码被缓存下来。那么下次调用时只要是相同的预编译语句就不需要编译，只要将参数直接传入编译过的语句执行代码中，就会得到执行。这并不是说只有一个 Connection 中多次执行的预编译语句被缓存，而是对于整个DB中(所有Connection)，只要预编译的语句语法和缓存中匹配。那么在任何时候就可以不需要再次编译而可以直接执行。

## 创建PreparedStatement对象

```
//创建一个Statement对象，用于执行SQL语句并返回相应的结果
PreparedStatement ps = conn.preparedStatement(String sql);//需指定预执行SQL语句

```

## 常用PreparedStatement方法

- executeQuery();运行select语句，返回ResultSet结果集
- executeUpdate();运行insert/update/delete操作，返回响应的行数
- execute();运行任何sql语句(含DDL)，返回是否有结果
- addBatch() ;把多条sql语句放到一个批处理中
- executeBatch();向数据库发送一批sql语句执行

## 注意：

PreparedStatement 每次执行一条SQL语句且提交后，应该释放相关资源。如需再次使用则都需要重新从Connection对象中的preparedStatement相关的方法来重新创建PreparedStatement对象，使用完释放资源。

## no.1创建PreparedStatement对象

```
//创建一个PreparedStatement对象，用于预执行SQL语句并返回相应的结果
String sql = "SELECT empno,ename,job,sal FROM myemp WHERE deptno=? AND sal >=?";//'?'代表占位符
PreparedStatement ps = conn.prepareStatement(sql);//需指定预执行SQL语句

```

## no.2填充占位符

**占位符下标从**`1`**开始，且顺序是从左到右。**

```
ps.setInt(1, 30);//设置第一个占位符的值为 30
ps.setDouble(2, 1500.00);//设置第二个占位符的值为 1500.00

```

## no.3执行查询语句

```
ResultSet rs = ps.executeQuery();//返回ResultSet

```

至此，查询语句已经执行完成！

## no.4释放PreparedStatement资源

```
finally {//在finally中执行，以防在执行sql中出现错误，而忽略资源的释放。
    if (ps!=null) {
        try {
            ps.close();
        } catch (SQLException e) {
        }
    }
}
```



# 执行insert操作

```
String sql = "INSERT INTO myemp (EMPNO, ENAME, JOB, HIREDATE, SAL,  DEPTNO) VALUES (?,?,?,?,?,?)";
ps = conn.prepareStatement(sql);
ps.setInt(1, 6666);
ps.setString(2, "杰克");
ps.setString(3, "船长");
ps.setDate(4, new java.sql.Date(System.currentTimeMillis()));//精确到 年月日
//ps.setTimestamp(4, new Timestamp(System.currentTimeMillis())); 精确到时分秒...
ps.setDouble(5, 9876.54);
ps.setInt(6, 40);
int update = ps.executeUpdate();//返回响应行数
System.out.println(update>0?"插入成功！":"插入失败！");

```

# 执行update操作

```
String sql="UPDATE myemp SET sal = sal - ? WHERE deptno=?";
ps = conn.prepareStatement(sql);
ps.setDouble(1, 500);
ps.setInt(2, 40);
int update = ps.executeUpdate();// 返回响应行数
System.out.println(update > 0 ? "更新成功！" : "更新失败！");

```

# 执行delete操作

```
String sql = "DELETE FROM myemp WHERE deptno=?";
ps = conn.prepareStatement(sql);
ps.setInt(1, 40);
int update = ps.executeUpdate();// 返回响应行数
System.out.println(update > 0 ? "删除成功！" : "删除失败！");
```



# 批量更新的优势

1. 多个SQL语句的执行，共用一个Connection资源。在对数据库操作时，connection资源是很宝贵的，数据库的维护从某种角度来说，就是减少数据库的连接数，减轻对DB的压力。创建一个数据连接要远远比使用数据库连接消耗资源。这也正是数据库连接池存在的意义。
2. 批处理在效率上总是比逐条处理有优势，要处理的数据的记录条数越大，批处理的优势越明显。在处理大批量相同业务逻辑的DB操作可以使用批处理达到简化、高效处理。
3. 在单一时间段，提高应用与DB间的吞吐量，缩短DB响应时间。大部分应用都有DB操作，如果SQL语句操作不当会导致DB长时间处于不可用状态，或是使DB资源占用率升高，从而影响了应用，最终被DB拖垮。缩短DB的响应时间，一来可以提供应用性能，二来减轻DB压力，对维持高系能的应用有极大的帮助。

## 批量更新的实现

PreparedStatement：

1. addBatch()将一组参数添加到PreparedStatement对象内部。
2. executeBatch()将一批参数提交给数据库来执行，如果全部命令执行成功，则返回更新计数组成的数组。

```
public class PreparedStatementCommitAndRollbackTest {
    private static String url = "jdbc:oracle:thin:@127.0.0.1:1521:yztc";
    private static String user = "scott";
    private static String psw = "tiger";

    public static void main(String args[]) {    
        Connection con = null;    
        PreparedStatement ps = null;
        try {    
            // 1. 建立与数据库的连接    
            con = DriverManager.getConnection(url,user,psw); 
            // 2. 执行sql语句    
            // 1).先创建PreparedStatement语句(发送slq请求）：    
            ps = con.prepareStatement("insert into myemp (empno,ename,job,sal) values(?,?,?,?)");    
            con.setAutoCommit(false);//1,首先把Auto commit设置为false,不让它自动提交    
            // 2) 设置sql语句1    
            ps.setInt(1, 33);    
            ps.setString(2,"wangqin");    
            ps.setString(3, "搬砖");    
            ps.setDouble(4, 78.5);    
            // 3) 将一组参数添加到此 PreparedStatement 对象的批处理命令中。    
            ps.addBatch();    
            // 2) 设置sql语句2    
            ps.setInt(1, 34);    
            ps.setString(2,"wuytun");    
            ps.setString(3, "程序猿");    
            ps.setDouble(4, 7777);    
            // 3) 将一组参数添加到此 PreparedStatement 对象的批处理命令中。    
            ps.addBatch();    
            // 2) 设置sql语句3    
            ps.setInt(1, 31);    
            ps.setString(2,"tetet");    
            ps.setString(3, "老师");    
            ps.setDouble(4, 900);    
            // 3) 将一组参数添加到此 PreparedStatement 对象的批处理命令中。    
            ps.addBatch();    
            // 2) 设置sql语句4    
            ps.setInt(1, 32);    
            ps.setString(2,"liug");    
            ps.setString(3, "医生");    
            ps.setDouble(4, 500);    
            // 3) 将一组参数添加到此 PreparedStatement 对象的批处理命令中。    
            ps.addBatch();    
              /**开发中针对集合的数据，可以使用循环....**/
            // 4) 将一批参数提交给数据库来执行，如果全部命令执行成功，则返回更新计数组成的数组。    
            ps.executeBatch();    
            System.out.println("插入成功！");    
            // 若成功执行完所有的插入操作，则正常结束    
            con.commit();//2,进行手动提交（commit）    
            System.out.println("提交成功!");    
            con.setAutoCommit(true);//3,提交完成后恢复现场将Auto commit,还原为true,    

        } catch (SQLException e) {    
            e.printStackTrace(); 
          try {    
                // 若出现异常，对数据库中所有已完成的操作全部撤销，则回滚到事务开始状态    
                if(!con.isClosed()){    
                    con.rollback();//4,当异常发生执行catch中SQLException时，记得要rollback(回滚)；    
                    System.out.println("插入失败，回滚！");    
                    con.setAutoCommit(true);    
                }    
            } catch (SQLException e1) {   
                e1.printStackTrace();    
            }   
        }finally{
            //释放   PreparedStatement 资源
            //释放 Connection 资源 
        }
    }    
}
```



# 批量处理 防止内存溢出

在使用批处理首先应该注意一点，批处理也不是万能的，批处理都存在一次执行的最大吞吐量限制。

正如上面所提到的，批处理在单一时间段提高了与DB间的吞吐量，但是任何DB都是有吞吐量最大限制。

当达到或是超过最大吞吐量的峰值时，容易导致DB过载，更严重会导致DB宕(dàng)机【指系统不能正常工作】。

例如上面的示例代码，如果 addBatch()的sql语句条数 很多，几万甚至几十万，分分钟使应用的性能急剧下降，而且给DB带来风险。正确的做法应该是分批分量进行提交。处理执行SQL的时候，批处理的分批的大小与数据库的吞吐量以及硬件配置有很大关系，需要通过测试找到最佳的分批大小，一般在200-2000之间。

如下代码：

```
    private static String url = "jdbc:oracle:thin:@127.0.0.1:1521:yztc";
    private static String user = "scott";
    private static String psw = "tiger";

    public static void main(String[] args) throws ClassNotFoundException {

        ArrayList<Emp> list =null;//需要批量更新的数据
        Connection con = null;
        PreparedStatement ps = null;
        try {
            // 1. 建立与数据库的连接
            con = DriverManager.getConnection(url, user, psw);
            con.setAutoCommit(false);
            String sql = "insert into myemp (empno,ename,job,sal) values(?,?,?,?)";
              // 2).先创建PreparedStatement语句：
            ps = con.prepareStatement(sql);
            for (int i = 0; i < list.size(); i++) {
                // 3) 设置sql语句1
                ps.setInt(1, list.get(i).getEmpno);
                ps.setString(2, list.get(i).getEname());
                ps.setString(3, list.get(i).getJob());
                ps.setDouble(4, list.get(i).getSal());
                ps.addBatch();
                  //4)每2000条 执行一次。到达最后一条数据的时候也执行一次。
                if ((i != 0 && i % 2000 == 0) || i == list.size()-1) {
                    ps.executeBatch();
                    ps.clearBatch();
                    ps.close();
                    ps = con.prepareStatement(sql);
                }
            }
              //5)提交
            con.commit();
            con.setAutoCommit(true);//恢复自动提交状态
            System.out.println("执行完成！");
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                // 若出现异常，对数据库中所有已完成的操作全部撤销，则回滚到事务开始状态
                if (!con.isClosed()) {
                    con.rollback();// 4,当异常发生执行catch中SQLException时，记得要rollback(回滚)；
                    System.out.println("插入失败，回滚！");
                    con.setAutoCommit(true);
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            // 释放 PreparedStatement 资源
            // 释放 Connection 资源
        }
    }
```



# 为什么需要使用数据库连接池

JDBC作为一种数据库访问技术，具有简单易用的优点。但使用这种模式进行Web应用程序开发，存在很多问题：首先，每一次Web请求都要建立一次数据库连接。建立连接是一个费时的活动，每次都得花费0.05s～1s的时间，而且系统还要分配内存资源。这个时间对于一次或几次数据库操作，或许感觉不出系统有多大的开销。可是对于现在的Web应用，尤其是大型电子商务网站，同时有几百人甚至几千人在线是很正常的事。在这种情况下，频繁的进行数据库连接操作势必占用很多的系统资源，网站的响应速度必定下降，严重的甚至会造成服务器的崩溃。不是危言耸听，这就是制约某些电子商务网站发展的技术瓶颈问题。其次，对于每一次数据库连接，使用完后都得断开。否则，如果程序出现异常而未能关闭，将会导致数据库系统中的内存泄漏，最终将不得不重启数据库。还有，这种开发不能控制被创建的连接对象数，系统资源会被毫无顾及的分配出去，如连接过多，也可能导致内存泄漏，服务器崩溃。

#### 普通的数据库连接创建的缺点：

用户每次请求都需要向数据库获得链接，而数据库创建连接通常需要消耗相对较大的资源，创建时间也较长。

假设网站一天10万访问量，数据库服务器就需要创建10万次连接，极大的浪费数据库的资源，并且极易造成数据库服务器内存溢出、甚至系统宕机等。

# 什么是数据库连接池

所谓数据库连接池，可以看作 ：在用户和数据库之间创建一个”池”，这个池中有若干个连接对象，当用户想要连接数据库，就要先从连接池中获取连接对象，然后操作数据库。一旦连接池中的连接对象被拿光了，下一个想要操作数据库的用户必须等待，等待其他用户释放连接对象，把它放回连接池中，这时候等待的用户才能获取连接对象，从而操作数据库。

# 数据库连接池技术的优点

### 1.资源重用

 由于数据库连接得以重用，避免了频繁创建，释放连接引起的大量性能开销。在减少系统消耗的基础上，另一方面也增加了系统运行环境的平稳性。

### 2.更快的系统反应速度

 数据库连接池在初始化过程中，往往已经创建了若干数据库连接置于连接池中备用。此时连接的初始化工作均已完成。对于业务请求处理而言，直接利用现有可用连接，避免了数据库连接初始化和释放过程的时间开销，从而减少了系统的响应时间。

### 3.新的资源分配手段

 对于多应用共享同一数据库的系统而言，可在应用层通过数据库连接池的配置，实现某一应用最大可用数据库连接数的限制，避免某一应用独占所有的数据库资源。

### 4.统一的连接管理，避免数据库连接泄露

 在较为完善的数据库连接池实现中，可根据预先的占用超时设定，强制回收被占用连接，从而避免了常规数据库连接操作中可能出现的资源泄露。

## 五种常用连接池的实现

实现目前有众多的开源连接池实现，它们大多数是比较独立的组件，经过一定的配置就可以在我们的应用中使用。下面是用得比较多的连接池：

1. 【c3p0】（**主讲**）：C3P0是一个开源的JDBC连接池，它实现了数据源和JNDI绑定，支持JDBC3规范和JDBC2的标准扩展，目前在hibernate和spring中，均有使用。
2. 【DBCP】：是一个依赖Jakarta commons-pool对象池机制的数据库连接池，Tomcat的数据源使用的就是DBCP。
3. 【Druid】：Druid在连接池领域里可以说是比较火的，是阿里巴巴开源的JDBC连接池、监控组件。属性的配置dbcp连接池的差不多。
4. 【BoneCP】：BoneCP 是一个开源的快速的 JDBC 连接池。BoneCP很小，只有四十几K(运行时需要log4j和Google Collections的支持，这二者加起来就不小了)，而相比之下 C3P0 要六百多K。另外 BoneCP 有个缺点是，JDBC驱动的加载是在连接池之外的，这样在一些应用服务器的配置上就不够灵活。
5. 【Proxool】：是一个Java SQL Driver驱动程序，提供了对你选择的其它类型的驱动程序的连接池封装。可以非常简单的移植到现存的代码中。完全可配置。快速，成熟，健壮。可以透明地为你现存的JDBC驱动程序增加连接池功能。



# 什么是c3p0？

c3p0是一个易于使用的库，用于通过使用jdbc3规范和jdbc2的可选扩展定义的功能来增加传统JDBC驱动程序“企业级”。从版本0.9.5开始，c3p0完全支持jdbc4规范。

特别是，c3p0提供了几个有用的服务：

- 一种将基于DriverManager的JDBC驱动程序适用于用于获取数据库连接的较新`javax.sql.DataSource`方案的类。
- DataSources之后的Connection和PreparedStatements的透明池化，可以围绕传统的驱动程序或任意未解压的DataSource“包装”。

# 环境要求

c3p0-0.9.5.2需要1.6.x或更高版本的Java运行时环境。

# c3p0缓存原理

C3P0连接池会根据你的配置来初始化N个数据库连接，空闲T时间后连接过期又会自动新建K个连接使得连接池总有空闲的数据库连接等待被取用。我们只需通过dataSourse.getConnection()即可从线程池中取用一个已经连接好的空闲连接，执行数据库操作。然后“断开”（放回）这个连接，把这个连接的使用权放回连接池。真正的数据库连接的创建与释放是由C3P0在后台自动完成的，我们花的只是取用与释放占用权的时间。全程耗时10+毫秒，比原来提高了几十倍。

# 下载C3P0工具包

下载网址：<https://sourceforge.net/projects/c3p0/files/latest/download?source=files>

> 提示：解压出来后，在lib目录中有3个jar包，导入你的项目中（与ojdbc6.jar导入方式一致，注意！注意！注意！！ojdbc6.jar也要导入！！！）。

# 配置C3P0连接池

作为一个数据库连接池自然有很多参数要设置，当然就算你不设置也有默认的，不过那不一定能满足你的要求。

### 主要配置信息：

1. 初始化连接池时建立多少个连接
2. 连接池最多容纳多少个连接
3. 每个连接的生存时间
4. 以及对具体数据库连接的配置：
   1. 数据库的驱动
   2. 数据库的URL
   3. 数据库登录名
   4. 数据库密码
5. 以及对这个数据库的连接池的细化配置，比如：
   1. 初始化时建立多少连接
   2. 最多最少连接数等等

### 配置步骤如下：

在src目录下新建一个名叫 `c3p0-config.xml` 的文件，注意！！！文件名必须是`c3p0-config.xml`。

#### 然后在这个文件中进行配置上面讲到的各项：

```
<?xml version="1.0" encoding="UTF-8"?>
<c3p0-config>
   <!--默认配置-->
    <default-config>  
        <property name="initialPoolSize">10</property>  
        <property name="maxIdleTime">30</property>  
        <property name="maxPoolSize">100</property>  
        <property name="minPoolSize">10</property>  
        <property name="maxStatements">200</property>  
    </default-config>  

   <!--配置连接池oracle-->
        <!-- oracle配置-->
   <named-config name="oracle">    
        <property name="driverClass">oracle.jdbc.driver.OracleDriver</property>    
        <property name="jdbcUrl">jdbc:oracle:thin:@localhost:1521:orcl</property>    
        <property name="user">scott</property>    
        <property name="password">tiger</property>
        <property name="maxPoolSize">100</property>
        <property name="minPoolSize">10</property>
        <property name="initialPoolSize">10</property>    
        <property name="maxIdleTime">30</property>    
        <property name="maxStatements">200</property>    
    </named-config>

</c3p0-config>

```

#### 更细致化的有以下配置：

```
           <!--连接池中保留的最大连接数。默认值: 15 -->
           <property name="maxPoolSize">20</property>

           <!-- 连接池中保留的最小连接数，默认为：3-->
           <property name="minPoolSize">2</property>

           <!-- 初始化连接池中的连接数，取值应在minPoolSize与maxPoolSize之间，默认为3-->
           <property name="initialPoolSize">2</property>

           <!--最大空闲时间，60秒内未使用则连接被丢弃。若为0则永不丢弃。默认值: 0 -->
           <property name="maxIdleTime">60</property>

           <!--maxStatements：最大连接数。-->
           <property name="maxStatements">100</property>

           <!--acquireIncrement：连接用完了自动增量3个。 -->
           <property name="acquireIncrement">3</property>

        <!--acquireRetryAttempts：连接失败后重新试30次。-->
        <property name="acquireRetryAttempts">30</property>

        <!--acquireRetryDelay；两次重新连接中间隔1000毫秒。 -->
        <property name="acquireRetryDelay">1000</property>

        <!--autoCommitOnClose：连接关闭时默认将所有未提交的操作回滚。 -->
        <property name="autoCommitOnClose">false</property>

        <!--breakAfterAcquireFailure：出错时不把正在提交的数据抛弃。-->
        <property name="breakAfterAcquireFailure">false</property>

        <!--checkoutTimeout：100毫秒后如果sql数据没有执行完将会报错，如果设置0，将会无限的等待。 --> 
        <property name="checkoutTimeout">100</property>

           <!--factoryClassLocation：指定c3p0 libraries的路径，如果（通常都是这样）在本地即可获得那么无需设置，默认null即可。-->
        <property name="factoryClassLocation">null</property>

        <!--idleConnectionTestPeriod：每60秒检查所有连接池中的空闲连接。--> 
        <property name="idleConnectionTestPeriod">60</property>

        <!--maxStatementsPerConnection：定义了连接池内单个连接所拥有的最大缓存statements数。Default: 0  -->
        <property name="maxStatementsPerConnection"></property>

        <!--numHelperThreads：异步操作，提升性能通过多线程实现多个操作同时被执行。Default: 3--> 
        <property name="numHelperThreads">3</property>

        <!--overrideDefaultUser：当用户调用getConnection()时使root用户成为去获取连接的用户。主要用于连接池连接非c3p0的数据源时。Default: null--> 
        <property name="overrideDefaultUser">root</property>

        <!--overrideDefaultPassword：与overrideDefaultUser参数对应使用的一个参数。Default: null-->
        <property name="overrideDefaultPassword">password</property>

        <!--preferredTestQuery：定义所有连接测试都执行的测试语句。在使用连接测试的情况下这个一显著提高测试速度。注意： 测试的表必须在初始数据源的时候就存在。Default: null-->
        <property name="preferredTestQuery">select id from test where id=1</property>

        <!--propertyCycle：用户修改系统配置参数执行前最多等待300秒。Default: 300 --> 
        <property name="propertyCycle">300</property>

        <!--usesTraditionalReflectiveProxies：动态反射代理。Default: false-->
        <property name="usesTraditionalReflectiveProxies">false</property>

```

> C3P0更详细的配置项及其含义，请参考：<http://www.mchange.com/projects/c3p0/index.html>。

## 项目中使用C3P0执行SQL语句

```
/**No.1创建C3P0连接池*/
ComboPooledDataSource oracle = new ComboPooledDataSource("oracle");
try {
    /**No.2从连接池中取出连接*/
    Connection conn = oracle.getConnection();
    System.out.println("获取连接成功！" + conn);
    /**No.3将连接放入连接池。注：并没有关闭连接*/
    conn.close();
} catch (SQLException e) {
    e.printStackTrace();
}

```

```

public class C3p0Utils {

    //通过标识名来创建相应连接池
    private static ComboPooledDataSource connPool = new ComboPooledDataSource("oracle");

    //从连接池中取用一个连接
    public static Connection getConnection() throws SQLException {
        try {
            return connPool.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("数据库连接出错!");
        }
    }

    //释放ResultSet资源
    public static void close(ResultSet rs) {
        close(null, null, rs);
    }

    //释放Statement资源
    public static void close(Statement st) {
        close(null, st, null);
    }

    //释放连接回连接池
    public static void close(Connection conn) {
        close(conn, null, null);
    }

    //释放Statement资源，释放连接返回连接池
    public static void close(Connection conn, Statement st) {
        close(conn, st, null);
    }

    //释放连接回连接池
    public static void close(Connection conn, Statement st, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.setAutoCommit(true);//恢复现场
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 专门用于发送增删改语句的方法
     *
     * @param
     * @return true表示成功 false表示失败
     */
    public static boolean executeUpdate(String sql, Object... params) {
        int count = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            setParams(ps, params);
            // 使用Statement对象发送SQL语句
            count = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            close(conn, ps);
        }
        return count > 0;
    }

    private static void setParams(PreparedStatement ps, Object... params) throws SQLException {
        if (params != null && params.length > 0) {
            for (int i = 0; i < params.length; i++) {
                ps.setObject(1 + i, params[i]);
            }
        }
    }
}
```



# Log4j简介

Log4j是Apache的一个开源项目，通过使用Log4j，我们可以控制日志信息输送的目的地是控制台、文件、GUI组件，甚至是套接口服务器、NT的事件记录器、UNIX Syslog守护进程等；我们也可以控制每一条日志的输出格式；通过定义每一条日志信息的级别，我们能够更加细致地控制日志的生成过程。最令人感兴趣的就是，这些可以通过一个配置文件来灵活地进行配置，而不需要修改应用的代码。

# Log4j工具下载

下载地址：<http://logging.apache.org/log4j/1.2/download.html>

# 配置log4j

【**配置方式一**】：Log4j可以通过java程序动态设置，该方式明显缺点是：如果需要修改日志输出级别等信息，则必须修改java文件，然后重新编译，很是麻烦；

【**配置方式二**】：log4j也可以通过配置文件的方式进行设置，目前支持两种格式的配置文件：

- xml文件
- properties文件（推荐）

### 配置步骤

1. 新建log4j.properties，置于 项目工程的根目录下。
2. 输入配置一下配置信息！主要有日志的输出位置，如果是文件，则指定文件的路径，输出的规则，文本格式等。

```
#log4j.rootLogger=日志级别，appender1(输入路径配置名称), appender1, stdout(输出到控制台)
log4j.rootLogger=all, ServerDailyRollingFile, stdout

#log4j.appender.ServerDailyRollingFile=org.apache.log4j.日志输出到哪儿
#ConsoleAppender（控制台）
#FileAppender（文件）
#DailyRollingFileAppender（每天产生一个日志文件）
#RollingFileAppender（文件大小到达指定尺寸时产生一个新的文件）
#WriteAppender（将日志信息以流格式发送到任意指定的地方）
#JDBCAppender（将日志信息保存到数据库中）
log4j.appender.ServerDailyRollingFile=org.apache.log4j.DailyRollingFileAppender

#log4j.appender.ServerDailyRollingFile.DatePattern=日志后缀格式
log4j.appender.ServerDailyRollingFile.DatePattern='.'yyyy-MM-dd

#log4j.appender.ServerDailyRollingFile.File=日志输出 目录及文件路径
log4j.appender.ServerDailyRollingFile.File=logs/notify-subscription.log


#log4j.appender.ServerDailyRollingFile.MaxFileSize=最大文件大小
log4j.appender.ServerDailyRollingFile.MaxFileSize=100M

#log4j.appender.ServerDailyRollingFile.MaxBackupIndex=备份文件个数
log4j.appender.ServerDailyRollingFile.MaxBackupIndex=10

#log4j.appender.ServerDailyRollingFile.layout=org.apache.log4j.日志布局格式
#HTMLLayout（以HTML表格形式布局）
#SimpleLayout（包含日志信息的级别和信息字符串）
#TTCCLayout（包含日志产生的时间，执行绪，类别等信息）
#PatternLayout（可以灵活的指定布局格式，常用）
log4j.appender.ServerDailyRollingFile.layout=org.apache.log4j.PatternLayout

#log4j.appender.appender1.layout.ConversionPattern=日志输出格式
#如：%d - %m%n或%d{yyyy-MM-dd HH:mm:ss} %p [%c  %l] %m%n
#%c 输出日志信息所属的类的全名
#%d 输出日志时间点的日期或时间，默认格式为ISO8601，也可以在其后指定格式，比如：%d{yyy-M-dd HH:mm:ss }，输出类似：2002-10-18- 22：10：28
#%f 输出日志信息所属的类的类名
#%l 输出日志事件的发生位置，即输出日志信息的语句处于它所在的类的第几行
#%m 输出代码中指定的信息，如log(message)中的message
#%n 输出一个回车换行符，Windows平台为“rn”，Unix平台为“n”
#%p 输出优先级，即DEBUG，INFO，WARN，ERROR，FATAL。如果是调用debug()输出的，则为DEBUG，依此类推
#%r 输出自应用启动到输出该日志信息所耗费的毫秒数
#%t 输出产生该日志事件的线程名
log4j.appender.ServerDailyRollingFile.layout.ConversionPattern=%d{yyyy-MM-dd HH:mm:ss} %p [%f %l] %m%n

#log4j.appender.ServerDailyRollingFile.Append=是否追加输出
log4j.appender.ServerDailyRollingFile.Append=true

#配置 stdout 输出位置为控制台
log4j.appender.stdout=org.apache.log4j.ConsoleAppender

#配置 stdout 日志输出格式的模式为自定义
log4j.appender.stdout.layout=org.apache.log4j.PatternLayout

#配置 stdout 自定义输出格式
log4j.appender.stdout.layout.ConversionPattern=%d{yyyy-MM-dd HH:mm:ss} %p [%c %l] %m%n

```

# 在java程序中使用Log4j

### 步骤一：

```
//在Java程序中加载配置信息并初始化相关设置，该语句全局只需要执行一次即可
PropertyConfigurator.configure("log4j.properties");

```

### 步骤二：

```
//得到一个日志输出对象，并执行相关类
public Logger log = Logger.getLogger(MainTestLog4j.class);

```

### 步骤三：

```
    /** 
     * @相关参数： 
     * @功能描述： 定义一个输出日志的方法 
     * trace→debug→info→warn→error→fatal→off 
     * 级别依次升高，级别高的level会屏蔽级别低的level。 
     *在日志配置文件中，如果设置级别为INFO，则优先级高于等于INFO级别（如：INFO、WARN、ERROR）的日志信息将可以被输出,小于该级别的如DEBUG将不会被输出。
     */
public static void logTest()  
{  
        log.trace("trace级别的日志输出");  
        log.info("info级别的日志输出");  
        log.debug("debug级别的日志输出");  
        log.warn("warn级别的日志输出");  
        log.error("error级别的日志输出");  
        log.fatal("fatal级别的日志输出");  
        try  
        {  
            System.out.println(9 / 0);  
        }  
        catch (RuntimeException e)  
        {  
            log.error(e.getMessage());  
        }  
}
```


####事务隔离 - 并发控制

事务隔离级别：一个事务对数据库的修改与并行的另一个事务的隔离程度。

两个并发事务同时访问数据库表相同的行时，可能存在以下三个问题：

1，幻想读：。事务T1读取一条指定，其中条件的语句，返回结果集此时事务T2插入一行新记录，恰好满足T1的其中条件然后T1使用相同的条件再次查询，结果集中可以看到T2插入的记录，这条新纪录就是幻想。

2，不可重复读取：事务T1读取一行记录，紧接着事务T2修改了T1刚刚读取的记录，然后T1再次查询，发现与第一次读取的记录不同，这称为不可重复读。

3，脏读：事务T1更新了一行记录，还未提交所做的修改，这时候T2读取了更新后的数据，然后T1执行回滚操作，取消刚才的修改，所以T2所读取的行就无效，也就是脏数据。

为了处理这些问题，SQL标准定义了以下几种事务隔离级别

READ UNCOMMITTED幻想读，不可重复读和脏读都允许。

READ COMMITTED允许幻想读，不可重复读，不允许脏读

REPEATABLE READ允许幻想读，不允许不可重复读和脏读

SERIALIZABLE幻想读，不可重复读和脏读都不允许

Oracle数据库支持READ COMMITTED和SERIALIZABLE这两种事务隔离级别。所以Oracle不支持脏读

SQL标准所定义的默认事务隔离级别是SERIALIZABLE，但是是Oracle默认使用的是READ COMMITTED

Serializable级别：可避免脏读，不可重复读，虚读情况的发生。对一张表的所有增删改动操作必须顺序执行，如果没有WHERE会锁住整张表，有WHERE会锁住WHERE范围，性能非常差。

  隔离级别          	脏读  	不可重复读	幻读  
  阅读未提交         	√   	√    	√   
  阅读提交（Oracle默认）	×   	√    	√   
  可重复的阅读        	×   	×    	√   
  序列化           	×   	×    	×   

设置事务的隔离级别

1. Connection.TRANSACTION_READ_UNCOMMITTED，
2. Connection.TRANSACTION_READ_COMMITTED，
3. Connection.TRANSACTION_REPEATABLE_READ
4. Connection.TRANSACTION_SERIALIZABLE。

    try {
        connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
        connection.setAutoCommit(false);
          //执行SQL语句
        connection.commit();
        } catch (SQLException e) {
        connection.rollback();
        e.printStackTrace();
    }


事务的原则

尽可能使事务保持简短很重要，当事务启动后，数据库管理系统（DBMS）必须在事务结束之前保留很多资源，以保证事务的正确安全执行。

特别是在大量并发的系统中，保持事务简短减少并发资源锁定争夺，将显得更为重要。

1. 事务处理时，禁止与用户交互，在事务开始前完成用户输入。
2. 在浏览数据时，尽量不要打开事务。
3. 尽可能使事务保持简短。
4. 考虑为只读查询时，未提交使用隔离级别，以减少阻塞。
5. 灵活地使用更低的事务隔离级别。
6. 在事务中尽量使访问的数据量最小。