### Lambda表达式：
	- 地址：https://docs.oracle.com/javase/specs/jls/se8/html/jls-15.html#jls-15.27
	- 使用Lambda表达式可以替代只有一个抽象函数的接口实现，告别匿名内部类。
	- 使用Lambda表达式提升了对集合、框架的迭代、遍历、过滤数据的操作。
	
#### 特点：
	- 函数式编程
	- 参数类型推断
	- 代码量少
	
#### 好处：
	- 更容易的并行
	
#### 使用场景：
	- 任何有函数式接口的地方
	
#### 什么是函数式接口？
	- 只有一个抽象方法的接口(Object类的接口除外)是函数式接口
	- 接口可以使用@FunctionalInterface注解标注
	
#### JDK1.8之前的一些函数式接口：
	@FunctionalInterface
	public interface Runnable
	@FunctionalInterface
	public interface Callable<V>
	public interface Comparable<T> 
	
JDK1.8函数式接口：
	public interface Supplier<T> 代表一个输出
	public interface Consumer<T> 代表一个输入
	public interface BiConsumer<T, U> 代表两个输入
	public interface Function<T, R> 代表一个输入一个输出(一般输入和输出是不同类型的)
	public interface UnaryOperator<T> extends Function<T, T> 代表一个输入一个输出(一般输入和输出是相同类型的)
	public interface BiFunction<T, U, R>代表两个个输入一个输出(一般输入和输出是不同类型的)
	public interface BinaryOperator<T> extends BiFunction<T,T,T> 代表两个个输入一个输出(一般输入和输出是相同类型的)
	
Lambda是对象，是一个函数式接口的实例

语法：
LambdaParameters -> LambdaBody
(args) -> {expr}
(Object... args) -> {函数式接口抽象方法实现逻辑}
()里的参数个数，根据函数式接口里面的抽象方法的参数个数来决定
当只有一个参数时，()可以省略
当expr逻辑非常简单时，{}和return可以省略
示例：
() -> {} //无参，无返回值
() -> {System.out.println(1);} //无参，无返回值
() -> System.out.println(1) //无参，无返回值(上面的简写)
() -> {return 100} //无参，有返回值
() -> 100 //无参，有返回值(上面的简写)
() -> null //无参，有返回值(返回null)
(int x) -> {return x+1} //单个参数，有返回值
(int x) -> x+1 //单个参数，有返回值(上面的简写)
(x) -> x+1 //单个参数，有返回值(不指定参数类型，多个参数必须用括号)
x -> x+1 单个参数，有返回值(不指定参数类型)

注意事项：
不需要也不允许使用throws来声明它可能抛出的异常

怎样写好Lambda表达式？
看参数，看返回值

方法引用：
方法引用是用来直接访问类或者实例的已经存在的方法或者构造方法，方法引用提供了一种引用而不执行方法的方式，
如果抽象方法的实现恰好可以使用调用另外一个方法来实现，就有可能可以使用方法引用。

类型                         语法                                       对应的Lambda
静态方法引用     类名::staticMethod      (args) -> 类名::staticMethod(args)
实例方法引用     inst::instMethod        (args) -> inst::instMethod(args)
对象方法引用     类名::instMethod        (inst,args) -> 类名::instMethod(args)
构造方法引用     类名::new               (args) -> new 类名

1.如果函数式接口的实现恰好可以通过调用一个静态方法来实现，那么就可以使用静态方法引用
2.如果函数式接口的实现恰好可以通过调用一个实例方法来实现，那么就可以使用实例方法引用
3.抽象方法的第一个参数类型刚好是实例方法的类型，抽象方法剩余的参数刚好可以当做实例方法的参数。如果函数式接口的实现能由上面说的
实例方法调用来实现的话，那么就可以使用对象方法引用。
4.如果函数式接口的实现恰好可以通过调用一个类的构造方法来实现，那么就可以使用构造方法引用

--------------------------------------------------------------------------------------------------------------------

Stream:是处理数组和集合的一组API

特性：
	不是数据结构，没有内部存储
	不支持索引访问
	延迟计算
	支持并行
	很容易生成数组或集合(List,Set)
	支持过滤，查找，转换，汇总，聚合等操作

运行机制
	Stream分为源source，中间操作，终止操作
	流的源可以是一个数组，一个集合，一个生成器方法，一个I/O操作等等。
	一个流可以有零个或者多个中间操作，每一个中间操作都会返回一个新的流，供下一个操作使用。
	一个流只会有一个终止操作。
	Stream只有遇到终止操作，他的源才开始执行遍历操作。
	
中间操作
	过滤 filter
	去重 distinct
	排序 sorted
	截取 limit、skip
	转换 map/flatMap
	其他 peek
	
终止操作
	循环 forEach
	计算 min、max、count、average
	匹配 anyMatch、allMatch、noneMatch、findFirst、findAny
	汇聚 reduce
	收集器 toArray collect
	
Stream创建
	通过数组
	通过集合
	通过Stream.generate方法来创建
	通过Stream.iterate方法来创建
	其他API创建
