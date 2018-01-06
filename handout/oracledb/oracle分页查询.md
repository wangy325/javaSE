### 1.2.3 Oracle的分页查询

#### 1.2.3.1 认识 数据伪列

在此之前，其实我们已经使用过了一个数据伪列 SYSDATE ，但是在 Oracle中 还提供很多数据的伪列，其中最常用也是最重要的有 ROWNUM、ROWID 两个数据伪列；

- **ROWNUM**：程序开发中使用最多（重点）
- ROWID：在数据库程序分析的时候使用（与我们应用开发无关）。

##### 1.2.3.1.1  ROWNUM 伪列

ROWNUM是一种伪列，它会根据返回记录生成一个序列化的数字。利用ROWNUM，我们可以生产一些原先难以实现的结果输出。



**将ROWNUM伪列  作为emp表的查询字段进行查询，观察结果：**

1. 测试一

   ```mysql
   SELECT ROWNUM,empno,ename,job FROM emp ;
   ```

   ​	![](http://ojx4zwltq.bkt.clouddn.com/17-4-17/62533024-file_1492439317393_3d24.png)

2. 测试二

```mysql
SELECT ROWNUM,empno,ename,job FROM emp WHERE deptno=20;
```

​	![](http://ojx4zwltq.bkt.clouddn.com/17-4-17/10558531-file_1492439548162_5ee9.png)

**观察发现，ROWNUM 其实就是在查询出的结果后，对查询的结果进行顺序编号，从1开始。**

##### 1.2.3.1.2  对ROWNUM进行 >、>=、=操作

不能对ROWNUM使用>（大于1的数值）、>=（大于或等于2的数值）、=（大于1的数值），否则无结果

1. 测试一

   ```mysql
   SELECT * FROM emp WHERE ROWNUM >1;
   ```

   ​	![](http://ojx4zwltq.bkt.clouddn.com/17-4-17/92492826-file_1492439849219_d737.png)

2. 测试二

   ```mysql
   SELECT * FROM emp WHERE ROWNUM >=2;
   ```

   ​	![](http://ojx4zwltq.bkt.clouddn.com/17-4-17/70696108-file_1492439897094_10beb.png)

3. 测试三

   ```mysql
   SELECT * FROM emp WHERE ROWNUM = 2;
   ```

   ​	![](http://ojx4zwltq.bkt.clouddn.com/17-4-17/19643179-file_1492439948380_c7ae.png)

4. 测试四：

   ```mysql
   SELECT * FROM emp WHERE ROWNUM = 1;
   ```

   ![](http://ojx4zwltq.bkt.clouddn.com/17-4-17/98639229-file_1492440061946_4d8c.png)

   ***观察发现：以上测试 只有当 ROWNUM = 1 的时候才能查询出结果。***

**这是因为：**

- ROWNUM是伪列，必须要要有返回结果后，每条返回记录就会对应产生一个ROWNUM数值；
- 返回结果记录的ROWNUM是从1开始排序的，因此第一条始终是1；

**所以：**

这样一来，当查询到第一条记录时，该记录的ROWNUM为1，但条件要求 ROWNUM>1，因此不符合，继续取出下一条进行判断；但因为前面没有符合要求的记录，因此下一条记录过来后，其ROWNUM还是为1，如此循环，就不会产生结果。

而 默认查询第一条记录的 ROWNUM为1，所以

```mysql
SELECT * FROM emp WHERE ROWNUM = 1;
```

可以查询出数据库的第一条记录。在很多时候程序员在确认某个表中是否有存在数据时，可能你第一反应是使用

```mysql
SELECT * FROM emp;
```

但如果数据表存在大量数据的话，几乎有可能会把操作系统的内存占满卡死。所以一般，我们在确定一张表书否有数据的时候，直接在查询条件加上ROWNUM=1 即可，其思路就是只要存在一条数据就说明有相应数据，查询就可以直接返回了，这样就能提高性能了。

#### 1.2.3.2 分页查询

上面我们已经对 ROWNUM 进行 >、>=、= 的操作做了详细的介绍，那么 使用 ROWNUM 进行 <或者<=会是怎样的效果呢？

**范例：**查询出emp表的前5条数据。

```mysql
SELECT * FROM emp WHERE ROWNUM <=5;
```

![](http://ojx4zwltq.bkt.clouddn.com/17-4-17/2885303-file_1492440847117_14688.png)

**观察发现：**使用 ROWNUM < 或者 <= 可以取出 数据库的前 N 条数据。

##### 1.2.3.2.1 分页查询

**范例一：**查询出 emp表的第 6~10条数据。

```mysql
-- 我们想当然会这么去解决问题
SELECT * FROM emp WHERE ROWNUM BETWEEN 6 AND 10;
-- 或者
SELECT * FROM emp WHERE ROWNUM >=6 AND ROWNUM <=10;
```

​	![](http://ojx4zwltq.bkt.clouddn.com/17-4-17/72198225-file_1492441321878_9f15.png)

发现，查询结果并没有返回任何数据。

其实在上诉问题中我们已经对 ROWNUM 这个伪列做了详细的说明。

因为 SELECT 是在 FROM、WHERE 之后执行的，在取出1条数据 进行 WHERE判断的时候，此时该条数据的ROWNUM默认为1，而你的条件是  要求 ROWNUM 在 6~10之间，条件不满足；则继续取出下一条在和 WHERE的条件匹配，而因为上一条数据不满足，所以新取出的数据的 ROWNUM也是1。以此类推，条件不可能成立。

**问题分析：**

1. 取出前10条数据，返回一个多行多列的数据结果。既然是多行多列，我们可以讲查询结果当做一个虚拟表作为FROM子句查询表。
2. 针对子查询的虚拟表数据，再从虚拟表中取出满足条件的数据。

**问题解决：**

1. 查询前10条记录

   ```mysql
   SELECT ROWNUM,empno,ename,job,sal,hiredate FROM emp WHERE ROWNUM<=10;
   ```

   ![](http://ojx4zwltq.bkt.clouddn.com/17-4-17/41710646-file_1492441787333_6c15.png)

2. 将查询的结果作为 虚拟数据表 继续查询，而此时查询的结果作为虚拟表的话 ROWNUM 就是该虚拟表一列真是的数据，不再是伪列。可以当做普通的字段查询判断。

   ```mysql
   SELECT * 
   FROM (SELECT ROWNUM rn,empno,ename,job,sal,hiredate FROM emp WHERE ROWNUM<=10) temp
   WHERE temp.rn BETWEEN 6 AND 10;
   ```

   ![](http://ojx4zwltq.bkt.clouddn.com/17-4-17/55232547-file_1492441996889_164e3.png)

**范例二：**查询出 emp表的第 11~15条数据。

```mysql
SELECT * 
FROM (SELECT ROWNUM rn,empno,ename,job,sal,hiredate FROM emp WHERE ROWNUM<=15) temp
WHERE temp.rn BETWEEN 11 AND 15;
```

![](http://ojx4zwltq.bkt.clouddn.com/17-4-17/7667464-file_1492443285569_32f9.png)

发现数据表只剩下最后4行数据。那么，这其实就是我们分页查询中的随后一页的数据。



#### 1.2.3.3 分页查询的总结

以上 范例其实就是我们Oracle 所谓的分页查询。我们每次查询的条数为 5条(每页条数)：

那么：

1~5 就是第 1 页的数据

6~10 是第2页数据

11~15 是第3页数据(由于结果条数少于5，证明最后一页)

那么在java中。如果 我们要查询数据的页数为 pageNum，每页需要显示的条数为 pageSize。

则，分页查询的SQL语句就可以这么写：**（开发中该Sql结构 100% 会使用到）**

```
SELECT * FROM (SELECT ROWNUM rn,empno,ename,job,sal,hiredate FROM emp WHERE ROWNUM<=       pageNum*pageSize) temp 
WHERE temp.rn BETWEEN (pageNum-1)*pageSize+1 AND pageNum*pageSize;
```

