package com.wangy325.CollectionNote;
/**
 * @author wangy325
 *
 * @date Dec 19, 2017  9:16:46 AM
 *
 * @decription  List 接口
 * 				List 接口是 Collection 接口的子接口之一(另一个是Set);
 * 				List 接口有两个主要的实现类: ArrayList 和 LinkedList 两个实现类 
 * 				与 Set 相区别, List 是一个有序的, 可重复的集合, 集合中每个元素都有其索引号(类似数组的下标)
 * @target TODO
 */
public class List1 {
	public static void main(String[] args) {
		/**
		 * List 中添加了一些根据索引对集合元素进行操作的方法
		 * --> void add(int index, Object element); 将 element 插入到 index 处
		 * 
		 * --> boolean addAll(int index, Collection c); 将集合中的所有元素添加到 index处;
		 * 
		 * --> Object get(int index); 返回 index 处的元素;
		 * 
		 * --> int indexOf(Object obj); 返回 obj 在集合中 [第一次] 出现的位置索引;
		 * --> int lastIndexOf(Object obj);--
		 * 
		 * --> Object remove(int index); 移除 [并返回] index 处的元素;
		 * 
		 * --> Object set(int index, Object obj); 将 index 处的元素替换为obj, [返回] 被替代的元素;
		 * 
		 * --> ListIrerator listIterator(); 返回列表元素的 [专有] 迭代器
		 * 
		 * --> List subList(int FromList, int Toindex); 返回子集合;
		 * --> void replaceAll(UnaryOperator operator); 根据 operator 所给的规则重新设置集合的元素;
		 * --> void sort(Comparator c); 根据 Comparator 规则对 List 元素进行排序; 
		 */
		
		
	}

}
