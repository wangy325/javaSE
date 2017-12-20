# 第16天

## 16.1 集合的概念以及集合框架介绍

### 16.1.1 集合的概念

集合框架是为表示和操作"多个对象"而规定的一种统一的标准的体系结构。任何集合框架都包含三大块内容：对外的接口、接口的实现和对集合运算的算法。

* 接口：即表示集合的抽象数据类型。接口提供了让我们 对集合中所表示的内容进行单独操作的可能。
* 实现：也就是集合框架中接口的具体实现。实际它们就是那些可复用的数据结构。
* 算法：在一个实现了某个集合框架中的接口的对象身上完成某种有用的计算的方法，例如查找、排序等。

> 1. 集合是Java API所提供的一系列类，可以用于动态存放多个对象。--集合只能存对象
> 2. jdk1.5开始，集合全部用泛型进行的重写，是一种数据安全的用法。

### 16.1.2 集合的框架结构介绍

![](http://ojx4zwltq.bkt.clouddn.com/17-2-13/13933588-file_1486950111445_3801.png)

Java的集合框架从整体上可以分为两大家族。

1. Collection(接口)家族。该接口下的所有子孙均存储的是单一对象。
2. Map(接口)家族。该接口下的所有子孙均存储的是key-value(键值对)形式的数据。

另外还有三个分支，均是为上述两大家族服务的。

1. Iterator(迭代器)家族。主要用于遍历Colleciton接口的及其子类而设计。
2. Comparator(比较器), 在集合中存储对象时候，用于对象之间的比较
3. Collecitons 是工具类。注意该类名带个s，一般就表示工具类。里面提供了N多静态方法，来对Colleciton集合进行操作。

### 16.1.3 集合与数组的对比

1. 数组声明了它容纳的元素的类型，而集合不声明。这是由于集合以object形式来存储它们的元素。
2. 一个数组实例具有固定的大小，不能伸缩。集合则使用初始容量和加载因子根据需要动态改变自己的大小。
3. 集合中不能放基本数据类型，但可以放基本数据类型的包装类。

## 16.2 Collection接口

**Collection 接口是一组允许重复的对象。 定义了存取对象的方法。**

Java不提供直接实现自Collection的类，Java提供的类都是继承自Collection的“子接口”(如：List和Set) 的实现类。

**两个非常常用的子接口：**

* List接口：存放的元素有序且允许有重复的集合接口。
* Set接口：存放的元素无序且不允许有重复的集合接口，所有的重复内容是靠hashCode()和euqals()两个方法区分的。 

### 16.2.1 集合对象的创建

接口不能被实例化，所以创建集合对象，只能创建其接口的实现类。如：

```java
Collection c1 = new ArrayList();
Collection c2 = new LinkedList();
Collection c3 = new HashSet();
```

### 16.2.2 Collection中常用的方法

| 方法名                                | 描述                                       |
| ---------------------------------- | ---------------------------------------- |
| int size();                        | 返回此collection中的元素个数。                     |
| boolean isEmpty();                 | 判断此collection中是否包含元素。                    |
| boolean contains(Object obj);      | 判断此collection是否包含指定(equals为true)的元素。     |
| boolean containsAll(Collection c); | 判断此collection是否包含指定 Collection c 中的所有元素。比较方式通过 equals比较 |
| boolean add(Object element);       | 向此collection中添加元素。                       |
| boolean addAll(Collection c);      | 将指定collection中的所有元素添加到此collection中       |
| boolean remove(Object element);    | 从此collection中移除指定的元素，如果有多个对象重复，则只会删除第一个。 |
| boolean removeAll(Collection c);   | 移除此collection中那些也包含在指定 Collection c 中的所有元素。比较方式通过 equals比较 |
| void clear();                      | 移除些collection中所有的元素。                     |
| boolean retainAll(Collection c);   | 仅保留此collection中那些也包含在指定 Collection c 的元素。比较方式通过 equals比较 |
| Iterator iterator();               | 返回在此collection的元素上进行迭代的迭代器。              |
| Object[] toArray();                | 把此collection转成数组。                        |

## 16.3 Iterator 迭代器

由于集合中存有很多元素，很多时候需要遍历集合中的所有元素，java专门为集合提供了遍历集合的API：迭代器接口

Iterator对象称作迭代器，用以方便的实现对集合内元素的遍历操作。

### 16.3.1 迭代器的工作原理

Iterator是专门的迭代输出接口。所谓的迭代输出就是将元素进行判断，判断是否有内容，如果有内容则把内容取出。

1. 使用集合的方法iterator()要求容器返回一个Iterator。第一次调用Iterator的next()方法时，它返回序列的第一个元素。注意：iterator()方法是java.lang.Iterable接口,被Collection继承。
2. 使用next()获得序列中的下一个元素。
3. 使用hasNext()检查序列中是否还有元素。
4. 使用remove()将迭代器新返回的元素删除。

Iterator是Java迭代器最简单的实现，为List设计的ListIterator具有更多的功能，它可以从两个方向遍历List，也可以从List中插入和删除元素。

### 16.3.2 迭代器的使用

调用集合对象的iterator()方法，可以获得一个与该集合对象关联的迭代器对象。例如：

```java
List<String> list = new ArrayList<>();  
list.add("abc1");
list.add("abc2");
list.add("abc3");
list.add("abc4");
Iterator<String> iterator = list.iterator();  //获得Iterator对象
```

Iterator定义如下三个方法：

1. boolean  hasNext();　//判断游标右边是否有元素。如果有返回true，否则false
2. Object  next() ;　//返回游标右边的元素并将游标移动到下一个位置
3. void  remove();　//删除游标左面的元素(即next的时候跳过的对象)

> 注意：
>
> 1. 迭代方向是单向的,只能从前朝后(Iterator有个专为list集合设计的子接口ListIterator可以实现双向迭代)。
> 2. 在用迭代器遍历集合的时候，如果要删除集合中的元素，只能调用迭代器的remove()，禁止调用集合对象的rmove()方法，否则有可能会出现异常：java.util.ConcurrentModificationException。//并发访问异常
> 3. 使用ListIterator就可以解决这种异常！

```java
public static void main(String[] args){

	List<String> list=new ArrayList<String>();
	list.add("abc1");
	list.add("abc2");
	list.add("abc3");
	list.add("abc4");
	// 迭代器
	Iterator<String> it=list.iterator();
	while(it.hasNext())
	{
		String str=it.next(); //2.此处，ConcurrentModificationException 并发修改异常
		if(str.equals("abc2"))
		{
			list.add("hello");//1.在迭代的时候，使用了list的添加方法
		}
		System.out.println(str);
	}
}
```

![](http://ojx4zwltq.bkt.clouddn.com/17-2-13/54644400-file_1486979996799_163ed.png)

针对List接口，使用 ListIterator 可以解决这种异常！

```java
public static void main(String[] args){
	List<String> list=new ArrayList<String>();
	list.add("abc1");
	list.add("abc2");
	list.add("abc3");
	list.add("abc4");
	// 获取列表迭代器
	ListIterator<String> it=list.listIterator();
		
	while(it.hasNext())
	{
		String str=it.next();
		if(str.equals("abc2"))
		{
			it.add("hello");//不使用list.add ，但 ListIterator 有add 方法。
		}
		System.out.println(str);
	}
	System.out.println(list);
}
```

![](http://ojx4zwltq.bkt.clouddn.com/17-2-13/93444259-file_1486980397767_8b94.png)

## 16.4 List接口

### 16.4.1 List接口的特点

1. 实现List接口的集合类中的元素是有序的，且允许重复。

2. List集合中的元素都对应一个整数型的序号记载其在集合中的位置(每个元素都有索引)，可以根据序号存取集合中的元素。

3. List集合不仅支持Iterator还支持List集合专用迭代器ListIterator(双向迭代器)

4. List接口比Collection接口中新增的几个实用方法：

   1. public E get(int index)；返回列表中的指定位置的的元素
   2. public void add(int index, E element);　 在列表的指定位置插入指定元素。将当前处于该位置的元素（如果有的话）和所有后续元素向右移动。
   3. public E set(int index, E element) ;　用指定元素替换列表中指定位置的元素
   4. public E remove(int index)      移除列表中指定位置的元素
   5. public ListIterator listIterator()     返回此列表元素的列表迭代器(List专有)

   > 注意：list集合中的元素的索引与数组中元素的索引一样，均是从0开始。

### 16.4.2 List接口的实现类

#### 16.4.2.1 ArrayList实现类，实现原理

ArrayList是使用数组结构实现的List集合

优点：

1. 对于使用索引取出元素有较好的效率【随机读取效率非常高】
2. 可以使用索引来快速定位对象

缺点：

* 删除和添加效率较低

#### 16.4.2.2 LinkedList实现类，实现原理

LinkedList是List的实现类，他是一个基于链表实现的List类，对于顺序访问集合中的元素进行了优化。特别是插入，删除元素的速度特别快。LinkedList即实现了List接口，也实现了Deque接口。因此可以作为栈来使用。

Deque接口是Queue接口的子接口，它代表一个双端队列。因此可以从两端来操作队列的元素。

优点：

* 删除和添加效率较高

缺点：

- 随机读取效率较低

**LinkedList新增了以下方法：**

1. public void addFirst(E e);向集合头部添加数据
2. public void addLast(E e);向集合尾部添加数据
3. public E removeFirst();删除链表第一个数据，并返回被删除的数据
4. public E removeLast();删除链表的最后一个数据，并返回被删除的数据



对比ArrayList与LinkedList的效率：代码示例：

```java
	public static void main(String[] args) {
		long l1 = System.currentTimeMillis();
		LinkedList<String> linkedList = new LinkedList<String>();
		for (int i = 0; i < 99999; i++) {
			linkedList.add("张三" + i);
		}

		long l2 = System.currentTimeMillis();
		System.out.println("LinkedList 添加时间：" + (l2 - l1));

		ArrayList<String> arrayList = new ArrayList<String>();
		for (int i = 0; i < 99999; i++) {
			arrayList.add("张三" + i);
		}
		long l3 = System.currentTimeMillis();
		System.out.println("ArrayList 添加时间：" + (l3 - l2));

		for (int i = 0; i < arrayList.size(); i++) {
			arrayList.get(i);

		}
		long l4 = System.currentTimeMillis();
		System.out.println("ArrayList 遍历时间：" + (l4 - l3));
		for (int i = 0; i < linkedList.size(); i++) {
			linkedList.get(i);
		}
		long l5 = System.currentTimeMillis();
		System.out.println("linkedList 遍历时间：" + (l5 - l4));

		while (linkedList.size() > 0) {
			linkedList.removeFirst();
		}
		long l6 = System.currentTimeMillis();
		System.out.println("linkedList 删除时间：" + (l6 - l5));

		while (arrayList.size() > 0) {
			arrayList.remove(0);
		}
		long l7 = System.currentTimeMillis();
		System.out.println("arrayList 删除时间：" + (l7 - l6));

	}
```

效果：

![](http://ojx4zwltq.bkt.clouddn.com/17-3-20/48372461-file_1490003382524_15ecd.png)

#### 16.4.1.3 Vector（了解）

在List 接口中还有一个子类：Vector。Vector类从整个 Java 的集合发展历史来看，Vector算是一个元老级的类，在 JDK1.0 的时候就已经存在此类。但是到了Java2(JDK1.2)之后重点强调了集合框架的概念，所以先后定义了很多的新接口(如：List 等)。但是考虑到一大部分的人已经习惯了使用 Vector类，因此设计者就让 Vector 类多实现了一个 List接口，这样才将其保留下来。但是因为其是 List 接口的子类，***所以 Vector 类的使用与之前的并没有太大的区别***。但是Vector内部有一些比较老的方法名比较长的方法。

Vector和ArrayList在使用上非常相似，都可用来表示一组数量可变的对象应用的集合，并且可以随机地访问其中的元素。 

1. Vector的方法都是同步的(Synchronized),是线程安全的(thread-safe)，而ArrayList的方法不是，由于线程的同步必然要影响性能，因此，ArrayList的性能比Vector好。 
2. 当Vector或ArrayList中的元素超过它的初始大小时，Vector会将它的容量翻倍，而ArrayList只增加50%的大小，这样，ArrayList就有利于节约内存空间。

> 开发中使用到比较少！作为了解。

#### 16.4.2.4 Stack（了解）

Stack 类表示后进先出（LIFO）的对象堆栈。它通过五个操作对类 Vector 进行了扩展 ，允许将向量视为堆栈。

1. push 将数据对象压入栈顶
2. pop 取出堆栈顶部的值(会删除顶部的值)
3. peek 返回堆栈顶部的值
4. empty 测试堆栈是否为空
5. search 检测一个元素在堆栈中的位置

首次创建堆栈时，它不包含项。即：空栈！ 

> 开发中使用到相对较少！作为了解。

# 作业

1. 集合练习：

   1. 创建一个Person类，添加属性:name,age; 封装这些属性并分别设置各个属性的方法。
   2. 根据用户输入的对象个数创建Person对象，接收用户在控制台上输入的每个对象的信息。(注意，将有些Person对象的名字和年龄设置相同)
   3. 创建一个Collection集合的对象，将Person对象添加到Collection集合中。
   4. 使用迭代器迭代输出该Collecion集合

      ​

2. List集合练习：

   1. 自定义类型User,包含2个属性 name和age
   2. 把多个User对象存储到List集合中。
   3. *把List集合中的元素按照年龄从小到大排列

3. 已知有个Worker类(有相应的属性name,age,salary，和showInfo方法),完成下面的要求：

   1. 创建一个List，在List中增加三个工人信息如下：

   | name   | age  | salary |
   | ------ | ---- | ------ |
   | zhang3 | 18   | 3000   |
   | li4    | 25   | 3500   |
   | wang5  | 22   | 3200   |

   2. 在li4 之前插入一个工人，信息为：姓名：zhao6，年龄：24，工资3300 3、删除wang5 的信息
   3. 利用for 循环遍历，打印List 中所有工人的信息
   4. 利用迭代遍历，对List 中所有的工人调用showInfo方法。
   5. 为Worker 类添加equals 方法。

4. 现在给出两个集合：

   - 集合A：1，7，9，11，13，15，17，19
   - 集合b：2，4，6，8，10

   两个集合合并为集合c，按升序排列。

   ​
