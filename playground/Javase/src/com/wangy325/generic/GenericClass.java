package com.wangy325.generic;

/**
 * @author wangy325
 *
 * @date Jan 10, 2018  10:44:27 AM
 *
 * @description   
 * 
 * @tags 
 */
/** 
 * 泛型类的标识符紧跟在类名后面, 用尖括号<> 
 * 此处 T 可以随便写为任意标识，常见的如 T、E、K、V 等形式的参数常用于表示泛型
 * 在实例化泛型类时，必须指定T的具体类型
 */
public class GenericClass<T> {

	// key这个成员变量的类型为T,T的类型由外部指定
	private T key;
	// 也可以指定 成员变量的类型
	private Integer VALUE;

	// 泛型构造方法形参key的类型也为T，T的类型由外部指定
	public GenericClass(T key) {
		this.key = key;
	}

	public GenericClass(Integer vALUE) {
		VALUE = vALUE;
	}

	public T getKey() { // 泛型方法getKey的返回值类型为T，T的类型由外部指定
		return key;
	}

	public Integer getVALUE() {
		return VALUE;
	}

	public void setVALUE(Integer vALUE) {
		VALUE = vALUE;
	}

	public static void main(String[] args) {
		/**
		 * //泛型的类型参数只能是包装类型（包括自定义类），不能是简单类型
		 * //传入的实参类型需与泛型的类型参数类型相同，即前后尖括号内的类型要一致
		 */
		GenericClass<Double> genericDouble= new GenericClass<Double>(12d);
		GenericClass<String> genericString = new GenericClass<String>("aa");
		System.out.println("key is " + genericDouble.getKey());
		System.out.println("key is " + genericString.getKey());

		System.out.println("<--------------->");
		/**
		 * 实际上, 创建泛型类实例化对象的时候, 如果没有指定参数数据类型
		 * 则会跳过泛型类的类型检查
		 * 编译会报警告
		 */
		GenericClass generic = new GenericClass("111111");
		/**
		 * 这里 初始化 generic1 默认调用的是 public GenericClass(Integer vALUE)
		 * 这个构造器, 因为这个构造器指定了 参数类型 Integer
		 */
		GenericClass generic1 = new GenericClass(4444);
		GenericClass generic2 = new GenericClass(55.55d);
		GenericClass generic3 = new GenericClass(false);

		System.out.println("泛型测试key is " + generic.getKey());
		System.out.println("泛型测试key is " + generic1.getVALUE());
		System.out.println("泛型测试key is " + generic2.getKey());
		System.out.println("泛型测试key is " + generic3.getKey());
		/// :~
		/**
		 *  泛型测试key is 111111
		 *	泛型测试key is 4444
		 *	泛型测试key is 55.55
		 *	泛型测试key is false
		 */

		System.out.println("<----------->");
		GenericClass<Double> gDouble = new GenericClass<Double>(123d);
		GenericClass<Number> gNumber = new GenericClass<Number>(456);

		showKeyValue(gNumber);
		/**
		 * 报错信息:
		 * The method showKeyValue(GenericClass<Number>) in the type
		 * GenericClass<T> is not applicable for the arguments 
		 * (GenericClass<Double>)
		 * 原因:
		 *  方法中指定了泛型参数类型 <Numeric>, 那么调用方法的时候只能
		 * 传入指定类型的参数, 尽管 Double 类可以看作是 Numberic 的子类
		 * 解决办法:
		 * 使用泛型通配符 ? 
		 */
		// showKeyValue(gDouble);
		showKeyValue1(gDouble);
	}
	/**
	 * 泛型类 不建议初始化指定数据类型的构造, 若如此做, 构造器初始化实例对象的时候
	 * 可能会遇到麻烦
	 * @param obj
	 */
	public static void showKeyValue(GenericClass<Number> obj) {
		System.out.println("泛型测试:key value is " + obj.getVALUE());
	}
	// 使用泛型通配符作为参数
	public static void showKeyValue1(GenericClass<?> obj) {
		System.out.println("泛型测试:key value is " + obj.getKey());
	}
}
