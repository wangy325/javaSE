# Set Map 接口

## 17.1 Set接口

### 17.1.1 集合的存储特点

1. 它不允许出现重复元素；
2. 不保证集合中元素的顺序（无下标）；
3. 允许包含值为null的元素，但最多只能有一个null元素。

### 17.1.2.2 HashSet的实现原理

HashSet 是 Set 的实现类，为快速查找设计的Set。存入HashSet的对象必须定义**hashCode()**。 

实现Set接口的集合存储对象时：

1. 根据每个对象的hash码值(调用hashCode()获得)用固定的算法算出它的存储索引，把对象存放在一个叫散列表的相应位置(表元)中：

   存对象时，集合首先调用该对象的hashCode方法来获得该对象的hashCode值，与hash表中的值进行比较。

   1. 如果不存在，则直接把该对象存入集合中，并把该hashCode值存入hash表中，此次add操作结束。
   2. 如果存在，则进行下面的计算：
      1. 通过“==”操作符判断已经存入过的对象与要存入的对象是否为同一对象。如果true则集合认为添加相同对象，add失败。如果false(不是同一对象)，则进行下面的计算：
         1. 调用要添加的对象的equals()方法，并把集合中的另一元素作为参数传入，如果返回值为true则集合认为添加相同对象，add失败。否则添加成功。

2. 取对象时：根据对象的hash码值计算出它的存储索引，在散列表的相应位置(表元)上的元素间进行少量的比较操作就可以找出它。

3. Set接口存、取、删对象都有很高的效率。

**对于要存放到Set集合中的对象，对应的类一定要重写equals()和hashCode(Object obj)方法以实现对象相等规则。**

#### 17.1.2.1 重写hashCode()与重写equals()

因为hashCode()和equals()方法的返回值共同决定了两个对象是否相等，所以覆写着两个方法时一般要保证两个方法的返回值保证兼容。

重写hashCode()和equals()方法的基本规则（建议）：

1. 如果两个对象通过equals()方法比较时返回true，则两个对象的hashCode()方法返回值应该也相等。
2. 对象中用作equals()比较标准的成员变量(属性)，也应该参与到hashCode的计算

### 17.1.3 LinkedHashSet(了解)

底层用链表记录了HashSet元素的插入顺序；

总结：一个‘有序’(迭代的顺序和插入的顺序一致)的HashSet：。

### 17.1.4 TreeSet(了解)

如果元素具备自然顺序( 实现了 Comparable<T> 接口的类) 的特性，那么就按照元素自然顺序的特性进行排序存储。

如果元素不具备自然顺序的特性，那么不能存入 TreeSet集合。

Set集合不能存放重复的元素，而TreeSet在判断重复条件的情况下，除了 HashSet的规则之后，还会判断comparaTo方法。如果返回0.则识别为重复元素。

## 17.3 Map接口概述    

1. 实现Map接口的集合类用来存储“键-值”映射对。key-value
2. Map实现类中存储的“键-值”映射对是通过键来唯一标识，Map底层的“键”是用Set来存放的。即：key 不可重复。
3. 映射Map每个元素含有两个部分：名称（key）和值（value）。其中key不得重复，所以它可以组成一个Set，而value部分可以重复可以组成一个Collection。
4. 常用的实现子类: HashMap、LinkedHashMap
5. HashMap和TreeMap区别与HashSet与TreeSet的区别完全一致。

### 17.3.1 Map接口的常用方法：重点

| 方法名                                    | 描述                                       |
| -------------------------------------- | ---------------------------------------- |
| Object  put(Object key, Object value); | 将指定的“键-值”对存入Map中，返回已经存在的key的Values。如果不存在则返回null。 |
| Object  get(Object key);               | 返回指定键所映射的值                               |
| Object  remove(Object key);            | 根据指定的键把此“键-值”对从Map中移除。                   |
| boolean  containsKey(Object key);      | 判断此Map是否包含指定键的“键-值”对。                    |
| boolean  containsValue(Object value);  | 判断此Map是否包含指定值的“键-值”对。                    |
| boolean  isEmpty();                    | 判断此Map中是否有元素。                            |
| int  size();                           | 获得些Map中“键-值”对的数量。                        |
| void  clear();                         | 清空Map中的所有“键-值”对。                         |
| Set  keySet();                         | 返回此Map中包含的键的Set集。                        |
| Collection values();                   | 返回此Map中包含的值的Collection集。                 |

### 17.3.2 Map接口的常用实现类

#### 17.3.2.1 HashMap

使用频率最高的一种Map集合。

HashMap内部对“键”用Set进行散列存放。所以根据“键”去取“值”的效率很高。

#### 17.3.2.2 LinkedHashMap(了解)

底层使用链表来记住了key的插入的顺序；

总结：一个‘有序’(迭代的顺序和插入的顺序一致)的HashMap。

#### 17.3.2.3 HashTable(了解)

HashTable用法与HastMap集合基本相同，只是HashTable是比较老的类集，是线程安全的，所以效率较低。 

## 17.4 Map.Entry

Map.Entry是Map中内部定义的一个接口，专门用来保存key-value的内容。

可以通过map集合的entrySet()方法来获得所有的Map.Entry组成的set集合。

```java
	Map<String, Integer> map = new HashMap<String,Integer>();
	Set<Entry<String, Integer>> entrySet = map.entrySet();
	Iterator<Entry<String, Integer>> iterator = entrySet.iterator();
	Entry<String, Integer> entry = iterator.next();
	Integer value = entry.getValue();//获取值
	String key = entry.getKey();//获取键
```

![](http://ojx4zwltq.bkt.clouddn.com/17-2-14/57262092-file_1487049566830_16469.png)

## 17.5 Collections：工具类

### Comparable 简介和Comparator的介绍

### Comparable 简介

Comparable 是排序接口。

若一个类实现了Comparable接口，就意味着“该类支持排序”。  即然实现Comparable接口的类支持排序，假设现在存在“实现Comparable接口的类的对象的List列表(或数组)”，则该List列表(或数组)可以通过 Collections.sort（或 Arrays.sort）进行排序。

此外，“实现Comparable接口的类的对象”可以用作“有序映射(如TreeMap)”中的键或“有序集合(TreeSet)”中的元素，而不需要指定比较器。

Comparable 定义

Comparable 接口仅仅只包括一个函数，它的定义如下：

```
package java.lang;import java.util.*;

public interface Comparable<T> {

    public int compareTo(T o);

}
```

说明：假设我们通过 x.compareTo(y) 来“比较x和y的大小”。若返回“负数”，意味着“x比y小”；返回“零”，意味着“x等于y”；返回“正数”，意味着“x大于y”。

### Comparator 简介

Comparator 是比较器接口。

我们若需要控制某个类的次序，而该类本身不支持排序(即没有实现Comparable接口)；那么，我们可以建立一个“该类的比较器”来进行排序。这个“比较器”只需要实现Comparator接口即可。

也就是说，我们可以通过“实现Comparator类来新建一个比较器”，然后通过该比较器对类进行排序。

 Comparator 定义

Comparator 接口仅仅只包括两个个函数，它的定义如下：

```
public interface Comparator<T> {

    int compare(T o1, T o2);
    boolean equals(Object obj);

}
```

说明：(01) 若一个类要实现Comparator接口：它一定要实现compareTo(T o1, T o2) 函数，但可以不实现 equals(Object obj) 函数。

```
    为什么可以不实现 equals(Object obj) 函数呢？ 因为任何类，默认都是已经实现了equals(Object obj)的。 Java中的一切类都是继承于java.lang.Object，在Object.java中实现了equals(Object obj)函数；所以，其它所有的类也相当于都实现了该函数。
```

(02) int compare(T o1, T o2) 是“比较o1和o2的大小”。返回“负数”，意味着“o1比o2小”；返回“零”，意味着“o1等于o2”；返回“正数”，意味着“o1大于o2”。

Comparator 和 Comparable 比较

Comparable是排序接口；若一个类实现了Comparable接口，就意味着“该类支持排序”。而Comparator是比较器；我们若需要控制某个类的次序，可以建立一个“该类的比较器”来进行排序。

**我们发现：Comparable相当于“内部比较器”，而Comparator相当于“外部比较器”。**



1. 排序操作**（主要针对List接口相关）**
   * reverse(List list)：反转指定List集合中元素的顺序
   * shuffle(List list)：对List中的元素进行随机排序（洗牌）
   * sort(List list)：对List里的元素根据自然升序排序
   * swap(List list, int i, int j)：将指定List集合中i处元素和j出元素进行交换
   * sort(List list, Comparator c)：自定义比较器进行排序
   * rotate(List list, int distance)：将所有元素向右移位指定长度，如果distance等于size那么结果不变
2. 查找和替换（主要针对Collection接口相关）
   * binarySearch(List list, Object key)：使用二分搜索法，以获得指定对象在List中的索引(下标)。
   * max(Collection coll)：返回最大元素
   * max(Collection coll, Comparator comp)：根据自定义比较器，返回最大元素
   * min(Collection coll)：返回最小元素
   * min(Collection coll, Comparator comp)：根据自定义比较器，返回最小元素
   * fill(List list, Object obj)：使用指定对象填充
   * frequency(Collection c, Object o)：返回指定集合中指定对象出现的次数
   * replaceAll(List list, Object old, Object new)：替换
3. 其他用法比较不常用，详情请参照 JAVA API 说明。



# 作业

1. HashSet集合练习：
   （1）创建一个Employee类，添加属性:name,age，salary; 封装这些属性并分别设置各个属性的get和set方法。	
   （2）在Employee 类基础上，为Employee 类添加相应的代码，使得Employee 对象能正确放入HashSet 中：如果年龄和姓名相同就认为他们为同一个对象。并编写相应的测试代码。
   例如：雇员的基本信息如下：

   | 姓名    |  年龄  | 工资   |
   | ----- | :--: | ---- |
   | Jack  |  18  | 1500 |
   | Mike  |  18  | 1600 |
   | Marry |  17  | 2000 |

2. (Map练习)已知某学校的教学课程内容安排如下：
   ![](http://ojx4zwltq.bkt.clouddn.com/17-3-19/6135334-file_1489914466090_14d5f.png)
   完成下列要求：
   1） 使用一个Map，以老师的名字作为键，以老师教授的课程名作为值，表示上述 课程安排。
   2） 增加了一位新老师Allen    教JDBC
   3） Lucy 改为教CoreJava
   4） 遍历Map，使用两种迭代方式输出所有的老师及老师教授的课程。

3. 用集合打印输出表格：


| name | age  | salary |
| :--: | :--: | :----: |
| tom  |  22  |  300d  |
| jack |  33  |  500d  |




1. 统计一个指定的字符串中每个字符出现的个数。把结果存入到一个Map中。(key 为某个字符，value为这个字符出现的次数)。

2. 写一个可以给斗地主玩家随机发牌的程序。
   a：牌可以随机发给三个玩家
   b：在控制台打印每个玩家的牌。
   c：对每个玩家手中的牌按照大小排序。

   ```java
   牌的花色："♠", "♥", "♣", "♦"
   ```

   *思路：创建一个容器存储所有的牌，再创建三个容器分别表示三个用户的牌，三个用户轮流从第一个容器中取牌，剩下三张为底牌。把大王和小王也算进去。可以封装一个类表示牌*