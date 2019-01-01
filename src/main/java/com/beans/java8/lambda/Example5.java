package com.beans.java8.lambda;

import java.io.Closeable;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * 对象方法引用
 * 抽象方法的第一个参数类型刚好是实例方法的类型，抽象方法剩余的参数刚好可以当做实例方法的参数。如果函数式接口的实现能由上面说的
 * 实例方法调用来实现的话，那么就可以使用对象方法引用。
 *
 * 语法： 类名::instMethod 
 */
public class Example5 {
	/**
	 * 抽象方法没有参数，不能使用对象方法引用
	 * 比如说，如下函数式接口
	 */
	
	@SuppressWarnings({ "unused", "resource" })
	private void not() {
		Runnable runnable = () -> {};
		Closeable closeable = () -> {};
		Supplier<String> supplier = () -> "";
	}
	public static void main(String[] args) {
		//抽象方法的第一个参数类型刚好是实例方法的类型
		Consumer<Too> consumer1 = (Too too) -> new Too().foo();
		Consumer<Too> consumer2 = Too::foo;
		consumer1.accept(new Too());
		consumer2.accept(new Too());
		
		//抽象方法的第一个参数类型刚好是实例方法的类型，抽象方法剩余的参数刚好可以当做实例方法的参数
		BiConsumer<Too2, String> biConsumer1 = (Too2 too,String str) -> new Too2().foo1(str);
		biConsumer1.accept(new Too2(), "BiConsumer invoke");
		BiConsumer<Too2, String> biConsumer2 = Too2::foo1;
		biConsumer2.accept(new Too2(), "BiConsumer invode");
		
		BiFunction<Prod, String, Integer> biFunction1 = (prod,str) -> new Prod().get(str);
		System.out.println(biFunction1.apply(new Prod(), "20"));
		BiFunction<Prod, String, Integer> biFunction2 = Prod::get;
		System.out.println(biFunction2.apply(new Prod(), "30"));
		//总结，注意这里第一个参数最好是自定义类型
		
		Executor executor = Prod::run;
		executor.run(new Prod(), "aa", "bb");
		
	}
}

class Too {
	public void foo() {
		System.out.println("invoke");
	}
}

class Too2 {
	public void foo() {
		System.out.println("invoke");
	}
	
	public void foo1(String str) {
		System.out.println(str);
	}
}

class Prod {
	public Integer get(String str) {
		return Integer.valueOf(str);
		
	}
	
	public void run(String str,String size) {
		System.out.println("run");
		
	}
}

interface Executor {
	void run(Prod prod,String str,String size);
}